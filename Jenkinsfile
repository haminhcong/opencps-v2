env.OPENCPS_CACHE_VOLUME='gradle_cache_volume_test'

if (env.CHANGE_ID) {
    buildPullRequest()
} else {
    buildPushCommit()
}

def buildPushCommit() {
    node() {
        sh 'ls -alh'
        stage('Checkout Source Code') {
            checkoutSCM()
        }
        docker.image("openjdk:8u252-jdk").inside("-v ${env.OPENCPS_CACHE_VOLUME}:/root/gradle_cache") {
            sh 'mkdir -p /root/.gradle/ && cp -ar /root/gradle_cache/* /root/.gradle/'
            stage('Compile & build'){
                sh './gradlew -v'
                sh './gradlew --no-daemon buildService'
                sh './gradlew --no-daemon build'
            }
            stage('Test'){
                try {
                    sh './gradlew --no-daemon test --profile'
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
}

def checkoutSCM() {
    checkout([
        $class: 'GitSCM',
        branches: scm.branches,
        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
        extensions       : [[$class : 'CloneOption', shallow: false, timeout: 75],
                            [$class: 'CleanBeforeCheckout']],
        userRemoteConfigs: scm.userRemoteConfigs
    ])
    GIT_REVISION = sh(script: 'git rev-parse HEAD', returnStdout: true)
    env.GIT_COMMIT_ID = GIT_REVISION.substring(0, 7)
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
