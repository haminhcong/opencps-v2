node(){
    checkout scm
    sh 'ls -al'
    configFileProvider([configFile(fileId: "opencps_ci_cd_config.groovy", targetLocation: '.')]) {
            load "opencps_ci_cd_config.groovy"
    }
}
if (env.CHANGE_ID) {
    buildPullRequest()
} else {
    buildPushCommit()
}

def buildPushCommit() {
    node() {
        stage('Checkout Source Code') {
            checkoutSCM()
        }
        docker.image("openjdk:8u252-jdk").inside("-v ${env.OPENCPS_CACHE_VOLUME}:/root/gradle_cache") {
            sh 'mkdir -p /root/.gradle/ && cp -ar /root/gradle_cache/* /root/.gradle/'
            sh './gradlew -v'
            sh './gradlew buildService'
            sh './gradlew build'
            sh 'ls -al'
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