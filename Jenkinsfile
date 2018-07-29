import groovy.io.FileType

node() {
    docker.image('ntk148v/gradle-git-4.5.1:alpine').withRun('-v $HOME/.m2:/home/gradle/.m2 -v $HOME/.gradle:/home/gradle/.gradle') { c ->
        catchError {
            stage('Checkout') {
//                checkout scm
                checkout changelog: true, poll: true, scm: [
                        $class           : 'GitSCM',
                        extensions       : [[$class   : 'CloneOption',
                                             reference: '/home/hieule/conghm-opencps-v2-local/opencps-v2.git',
                                             shallow  : false, timeout: 75]],
                        userRemoteConfigs: [[credentialsId: 'conghm-github-clone-token',
                                             url          : 'https://github.com/haminhcong/opencps-v2']]
                ]
            }
            stage('Clean') {
                sh './gradlew -v'
                // Workaround with 'Gradle locks the global script cache' issue
                sh 'find /home/gradle/.gradle -type f -name "*.lock" | while read f; do rm $f; done'
                sh './gradlew --no-daemon clean --profile'
            }

            stage('Build') {
                buildPushCommit()
            }

            stage('Test') {
                testPushCommit()
            }
        }
    }
}


def buildPushCommit() {
    sh './gradlew --no-daemon  buildService --profile'
}

def testPushCommit() {
    try {
        sh './gradlew --no-daemon  test --profile'
    } catch (err) {
        echo "${err}"
        throw err
    } finally {
        sh './gradlew --no-daemon  aggregateUnitTests --profile'
        publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: false,
                keepAll     : false, reportDir: 'build/unit_test_results',
                reportFiles : "**.html",
                reportName  : 'HTML Report', reportTitles: ''
        ])
    }
}