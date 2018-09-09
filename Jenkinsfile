import groovy.json.JsonSlurperClassic
import hudson.tasks.test.AbstractTestResultAction

node() {
    stage('Checkout') {
        checkoutSCM()
    }
    def isReleaseBuild = false
    try{
        if (TAG_VERSION.length() > 0){
            isReleaseBuild= true
        }
    } catch (err) {
        echo "Not release build."
    }
    def tag = sh(returnStdout: true, script: "git tag --contains | head -1").trim()
    if (tag) {
        stage("Build tag") {
            echo "Build tag started!"
            echo "Tag name: ${tag}"
        }
    } else if (isReleaseBuild) {
        buildRelease()
    } else if (env.CHANGE_ID) {
        buildPullRequest()
    } else {
        buildPushCommit()
    }
}

def buildPullRequest() {
    docker.image('opencpsv2/gradle:4.9.0-jdk8').inside('-v "gradle_cache_volume:/home/gradle/gradle_cache" ') {
        stage('Set ENV') {
            env.GIT_PROJECT_NAME = determineRepoName()
            env.SONA_QUBE_PROJECT_KEY = env.GIT_PROJECT_NAME + ":" + env.BRANCH_NAME
            echo "${env.SONA_QUBE_PROJECT_KEY}"
            echo sh(script: 'env|sort', returnStdout: true)
        }

        stage('Clean') {
            sh 'cat  Jenkinsfile'
            sh 'gradle -v'
            sh 'gradle --no-daemon clean --profile'
        }

        stage('Build') {
            sh 'gradle --no-daemon  buildService --profile'
        }

        stage('Test') {
            try {
                sh 'gradle --no-daemon  test --profile'
            } catch (err) {
                echo "${err}"
                throw err
            } finally {
                junit 'modules/**/TEST-*.xml'
                def testResultString = getTestStatuses()
                echo "${testResultString}"
                pullRequest.comment("${env.GIT_COMMIT_ID}: ${testResultString}. [Details Report...](${env.JOB_URL}${BUILD_NUMBER}/testReport/)")
            }
        }

        stage('SonarQube analysis') {
            sh 'gradle --no-daemon jacocoTestReport jacocoRootReport'
            withSonarQubeEnv('Sonar OpenCPS') {
                sh "gradle --no-daemon --info sonarqube -Dsonar.projectName=${env.SONA_QUBE_PROJECT_KEY} -Dsonar.projectKey=${env.SONA_QUBE_PROJECT_KEY}"

                def props = readProperties file: 'build/sonar/report-task.txt'
                env.SONAR_CE_TASK_ID = props['ceTaskId']
                env.SONAR_PROJECT_KEY = props['projectKey']
                env.SONAR_SERVER_URL = props['serverUrl']
                env.SONAR_DASHBOARD_URL = props['dashboardUrl']
            }
        }

        stage("Quality Gate") {
            timeout(time: 1, unit: 'HOURS') {
                // Just in case something goes wrong, pipeline will be killed after a timeout
                def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
                echo "{env.SONAR_SERVER_URL}"
                echo "{env.SONAR_PROJECT_KEY}"
                echo "{env.SONAR_DASHBOARD_URL}"
                def sonarQubeAnalysisResult = getSonarQubeAnalysisResult(SONAR_SERVER_URL, SONAR_PROJECT_KEY)
                echo "${sonarQubeAnalysisResult}"
                sonarQubeAnalysisResult += "\n SonaQube analysis result details: [SonarQube Dashboard](${SONAR_DASHBOARD_URL})"
                pullRequest.comment("${env.GIT_COMMIT_ID}: " + sonarQubeAnalysisResult)
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
            }
        }
    }
}


@NonCPS
def getTestStatuses() {
    def testStatus = ""
    AbstractTestResultAction testResultAction = currentBuild.rawBuild.getAction(AbstractTestResultAction.class)
    if (testResultAction != null) {
        def total = testResultAction.totalCount
        def failed = testResultAction.failCount
        def skipped = testResultAction.skipCount
        def passed = total - failed - skipped
        testStatus = "Unit Test Results: Passed: ${passed}, Failed: ${failed} ${testResultAction.failureDiffString}, Skipped: ${skipped}"
    }
    return testStatus
}

@NonCPS
def isUnitTestsSuccess() {
    AbstractTestResultAction testResultAction = currentBuild.rawBuild.getAction(AbstractTestResultAction.class)
    if (testResultAction != null) {
        def failed = testResultAction.failCount
        if (failed == 0) {
            return true
        }
    }
    return false
}

static def getMetricEntryByKey(metricResultList, metricKey) {
    for (metricEntry in metricResultList) {
        if (metricEntry["metric"] == metricKey) {
            return metricEntry
        }
    }
    return null
}


def getSonarQubeAnalysisResult(sonarQubeURL, projectKey) {
    def metricKeys = "duplicated_lines,coverage,bugs,uncovered_lines,lines_to_cover"
    def metricResultList = getSonarQubeMeasureMetric(sonarQubeURL, projectKey, metricKeys)
    echo "${metricResultList}"
    def sonarQubeAnalysisResult = "SonarQube analysis results: \n"
    def uncoveredLinesEntry = getMetricEntryByKey(metricResultList, "uncovered_lines")
    def linesToCoverEntry = getMetricEntryByKey(metricResultList, "lines_to_cover")
    def coveragePercentEntry = getMetricEntryByKey(metricResultList, "coverage")
    def duplicatedLinesEntry = getMetricEntryByKey(metricResultList, "duplicated_lines")
    def totalBugsEntry = getMetricEntryByKey(metricResultList, "bugs")

    sonarQubeAnalysisResult += "Coverage statistic: ${uncoveredLinesEntry['value']}/${linesToCoverEntry['value']} uncovered - "
    sonarQubeAnalysisResult += "Coverage percent: ${coveragePercentEntry['value']}% \n"
    sonarQubeAnalysisResult += "Duplicated lines: ${duplicatedLinesEntry['value']} lines \n"
    sonarQubeAnalysisResult += "Total bugs found: ${totalBugsEntry['value']} bugs"
    return sonarQubeAnalysisResult
}

@NonCPS
static def jsonParse(def jsonString) {
    new JsonSlurperClassic().parseText(jsonString)

}

@NonCPS
def createPullRequestStatus(params) {
    pullRequest.createStatus(params)
}


def determineRepoName() {
    echo "${scm.getUserRemoteConfigs()[0].getUrl().tokenize('/')}"
    def repo_name_arr = scm.getUserRemoteConfigs()[0].getUrl().tokenize('/')
    def repo_user_name = repo_name_arr[repo_name_arr.size() - 2]
    def repo_name = repo_name_arr.last().split("\\.")[0]
    return repo_user_name + ":" + repo_name
}

def getSonarQubeMeasureMetric(sonarQubeURL, projectKey, metricKeys) {
    def measureResp = httpRequest([
            acceptType : 'APPLICATION_JSON',
            httpMode   : 'GET',
            contentType: 'APPLICATION_JSON',
            url        : "${sonarQubeURL}/api/measures/component?metricKeys=${metricKeys}&component=${projectKey}"
    ])
    def measureInfo = jsonParse(measureResp.content)
    echo "${measureInfo}"
    return measureInfo['component']['measures']
}


def buildPushCommit() {
    docker.image('opencpsv2/gradle:4.9.0-jdk8').inside('-v "gradle_cache_volume:/home/gradle/gradle_cache" ') {
        notifyStarted()
        stage('Clean') {
            sh 'gradle --no-daemon clean --profile'
        }
        stage('Build') {
            sh 'gradle --no-daemon  buildService --profile'
        }
        stage('Test') {
            try {
                sh 'gradle --no-daemon  test --profile'
            } catch (err) {
                echo "${err}"
                throw err
            } finally {
                junit 'modules/**/TEST-*.xml'
            }
        }
    }
}


def checkoutSCM() {
    checkout scm
    GIT_REVISION = sh(script: 'git rev-parse HEAD', returnStdout: true)
    env.GIT_COMMIT_ID = GIT_REVISION.substring(0, 7)
}

def notifyStarted() {
    // send to email
    emailext(
            subject: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
            // Update this list by change env variable at Manage Jenkins > Configure System > Global properties
            to: "${env.OPENCPS_MAIL_LIST}"
    )
}
// RELEASE_COMMIT_ID RELEASE_BRANCH RELEASE_TITLE RELEASE_NOTE
def buildRelease() {
    // check input conditions
    if (RELEASE_TITLE.length() == 0 ||
            RELEASE_COMMIT_ID.length() == 0 ||
            TAG_VERSION == 'NOT_SET'){
        error "Input parameter is not valid. Check them again. Release Failed."
    }

    echo "Release version: ${TAG_VERSION}"
    echo "Release commit id: ${RELEASE_COMMIT_ID}"
    echo "Release title: ${RELEASE_TITLE}"
    echo "Release note: ${RELEASE_NOTE}"

    stage('Checkout'){
        checkout changelog: true, poll: true, scm: [
                $class           : 'GitSCM',
                branches         : [[name: RELEASE_COMMIT_ID]],
                extensions       : [[$class : 'CloneOption',
                                     shallow: false, timeout: 75]],
                userRemoteConfigs: [[url: 'https://github.com/haminhcong/opencps-v2.git']]
        ]
    }

    stage('Verify'){
        echo "dev cd release test commit build by branch"
    }
    docker.image('opencpsv2/gradle:4.9.0-jdk8').inside('-v "gradle_cache_volume:/home/gradle/gradle_cache" ') {
        stage('Set ENV') {
            env.GIT_PROJECT_NAME = determineRepoName()
            env.SONA_QUBE_PROJECT_KEY = env.GIT_PROJECT_NAME + ":" + env.BRANCH_NAME
            echo "${env.SONA_QUBE_PROJECT_KEY}"
            echo sh(script: 'env|sort', returnStdout: true)
        }

        stage('Clean') {
            sh 'cat  Jenkinsfile'
            sh 'gradle -v'
            sh 'gradle --no-daemon clean --profile'
        }

        stage('Build') {
            sh 'gradle --no-daemon  buildService --profile'
        }

        stage('Test') {
            try {
                sh 'gradle --no-daemon  test --profile'
            } catch (err) {
                echo "${err}"
                throw err
            } finally {
                junit 'modules/**/TEST-*.xml'
                def testResultString = getTestStatuses()
                echo "${testResultString}"
                pullRequest.comment("${env.GIT_COMMIT_ID}: ${testResultString}. [Details Report...](${env.JOB_URL}${BUILD_NUMBER}/testReport/)")
            }
        }
    }
}
