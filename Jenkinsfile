import groovy.json.JsonSlurperClassic
import hudson.tasks.test.AbstractTestResultAction

// pipeline for push commit build

if (env.CHANGE_ID) {
    def sonarQubeInfoResp = httpRequest([
            acceptType : 'APPLICATION_JSON',
            httpMode   : 'GET',
            contentType: 'APPLICATION_JSON',
            // customHeaders: [[name: 'Private-Token', value: gitlab_api_token]],
            url        : "http://119.17.200.75:9000/api/measures/search_history?component=m-opencpsv2_opencps-v2_PR-2-RNTOX5QJL736HFHZQ7RSJMNFGJJFJ6D46MGOY6NQF3WORITP62MA&metrics=bugs%2Cduplicated_lines_density%2Cduplicated_blocks%2Ccoverage%2Clines_to_cover%2Cuncovered_lines&ps=1000"
    ])

    echo "${sonarQubeInfoResp.content}"
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
                    pullRequest.comment("[${testResultString}](${env.JOB_URL}${BUILD_NUMBER}/testReport/)")
                    if (isUnitTestsSuccess()) {
                        pullRequest.createStatus(status: 'success',
                                context: 'Unit test',
                                description: 'Test success: ' + testResultString,
                                targetUrl: "${env.JOB_URL}${BUILD_NUMBER}/testReport/".toString())
                    } else {
                        pullRequest.createStatus(status: 'failure',
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
                    def sonarQubeAnalysisResult = getSonarQubeAnalysisResult(SONAR_SERVER_URL, SONAR_PROJECT_KEY);
                    echo "${sonarQubeAnalysisResult}"
                    if (qg.status != 'OK') {
                        pullRequest.createStatus(status: 'failure',
                                context: 'SonarQube test',
                                description: 'Quality gate scan failed',
                                targetUrl: "${env.SONAR_DASHBOARD_URL}".toString())
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    } else {
                        pullRequest.createStatus(status: 'success',
                                context: 'SonarQube test',
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

@NonCPS
def getSonarQubeAnalysisResult(sonarQubeURL, projectKey) {

    def metricKeys ="coverage,bugs"
    echo "${sonarQubeInfo}"
}

@NonCPS
static def jsonParse(def jsonString) {
    new JsonSlurperClassic().parseText(jsonString)

}


def getSonarQubeMeasureMetric(sonarQubeURL, projectKey, metricKeys) {
    def measureResp = httpRequest([
            acceptType : 'APPLICATION_JSON',
            httpMode   : 'GET',
            contentType: 'APPLICATION_JSON',
            url        : "${sonarQubeURL}/api/measures/component?metricKeys=${metricKeys}&component=${projectKey}"
    ])
    def measureInfo = jsonParse(measureResp.content)
    return measureInfo['component']['measures']

}

def buildPushCommit() {
    // sh 'gradle --no-daemon  buildService --profile'
}