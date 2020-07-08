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
                sh './gradlew --no-daemon test'
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