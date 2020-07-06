node {
    configFileProvider([configFile(fileId: "opencps_ci_cd_config.groovy", targetLocation: '.')]) {
            load "opencps_ci_cd_config.groovy"
    }
    stage('Preparation & Checkout') {
        checkout changelog: true, poll: true, scm: [
                $class           : 'GitSCM',
                branches         : [[name: 'master']],
                extensions       : [[$class : 'CloneOption',
                                     shallow: false, timeout: 75],
                                     [$class: 'CleanBeforeCheckout']],
                userRemoteConfigs: [[url: 'https://github.com/VietOpenCPS/opencps-v2.git']]
        ]
    }
    stage('Update cache') {
        docker.image("openjdk:8u252-jdk").inside("-v ${env.OPENCPS_CACHE_VOLUME}:/root/.gradle") {
            sh './gradlew -v'
            sh './gradlew buildService'
            sh './gradlew build'
        }
    }
}