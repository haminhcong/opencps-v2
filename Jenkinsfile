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
//                def sonarQubeID = '123'
//                def sonarQubeGateUrl = '456'
//                def sonarQubeInfo = httpRequest([
//                        acceptType : 'APPLICATION_JSON',
//                        httpMode   : 'GET',
//                        contentType: 'APPLICATION_JSON',
//                        // customHeaders: [[name: 'Private-Token', value: gitlab_api_token]],
//                        url        : "http://119.17.200.75:9000/api/measures/search_history?component=m-opencpsv2_opencps-v2_PR-2-RNTOX5QJL736HFHZQ7RSJMNFGJJFJ6D46MGOY6NQF3WORITP62MA&metrics=bugs%2Cduplicated_lines_density%2Cduplicated_blocks%2Ccoverage%2Clines_to_cover%2Cuncovered_lines&ps=1000"
//                ])
//
//                echo "${sonarQubeInfo}"

                sh 'gradle --no-daemon jacocoTestReport jacocoRootReport'
                withSonarQubeEnv('Sonar OpenCPS') {
                    // requires SonarQube Scanner for Gradle 2.1+
                    // It's important to add --info because of SONARJNKNS-281
                    sh 'gradle --no-daemon --info sonarqube'

                    def props = readProperties file: 'build/sonar/report-task.txt'
//                    env.SONAR_CE_TASK_URL = props['ceTaskUrl']
//                    env.SONAR_DASHBOARD_URL = props['dashboardUrl']
                }
            }

            stage("Quality Gate") {
                timeout(time: 1, unit: 'HOURS') {
                    // Just in case something goes wrong, pipeline will be killed after a timeout
                    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv

                    echo "${qg}"
                    // echo $SONAR_CE_TASK_URL
                    // echo $SONAR_DASHBOARD_URL
                    if (qg.status != 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
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


def buildPushCommit() {
    // sh 'gradle --no-daemon  buildService --profile'
}