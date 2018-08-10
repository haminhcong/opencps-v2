import groovy.json.JsonSlurperClassic
import hudson.tasks.test.AbstractTestResultAction

// pipeline for push commit build

if (env.CHANGE_ID) {
    pullRequest.comment("Check comment")
    buildPullRequest()
} else {
    buildPushCommit()
}

def buildPullRequest() {
    node() {
        docker.image('conghm/gradle:4.9.0-jdk8').inside('-v "gradle_cache_volume:/home/gradle/gradle_cache" ') {
            stage('Checkout') {
                checkout changelog: true, poll: true, scm: [
                        $class                           : 'GitSCM',
                        branches                         : scm.branches,
                        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                        extensions                       : [[$class   : 'CloneOption',
                                                             reference: '/home/hieule/conghm-opencps-v2-local/opencps-v2.git',
                                                             shallow  : false, timeout: 75]],
                        userRemoteConfigs                : scm.userRemoteConfigs
                ]
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
                    pullRequest.comment("${testResultString}. [Details Report...](${env.JOB_URL}${BUILD_NUMBER}/testReport/)")
                    if (isUnitTestsSuccess()) {
                        createPullRequestStatus(status: 'success',
                                context: 'Unit test',
                                description: 'Test success: ' + testResultString,
                                targetUrl: "${env.JOB_URL}${BUILD_NUMBER}/testReport/".toString())
                    } else {
                        createPullRequestStatus(status: 'failure',
                                context: 'Unit test: ',
                                description: "Test failed: ${testResultString}".toString(),
                                targetUrl: "${env.JOB_URL}${BUILD_NUMBER}/testReport/".toString())
                    }
                }
            }

            stage('SonarQube analysis') {
                sh 'gradle --no-daemon jacocoTestReport jacocoRootReport'
                withSonarQubeEnv('Sonar OpenCPS') {
                    sh 'gradle --no-daemon --info sonarqube'

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
                    pullRequest.comment(sonarQubeAnalysisResult)

                    if (qg.status != 'OK') {
                        createPullRequestStatus(status: 'failure',
                                context: 'SonarQube scan',
                                description: 'Quality gate scan failed',
                                targetUrl: "${env.SONAR_DASHBOARD_URL}".toString())
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    } else {
                        createPullRequestStatus(status: 'success',
                                context: 'SonarQube scan',
                                description: 'Quality gate scan success',
                                targetUrl: "${env.SONAR_DASHBOARD_URL}".toString())
                    }
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
    // sh 'gradle --no-daemon  buildService --profile'
}
