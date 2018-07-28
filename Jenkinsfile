node(){
    docker.image('ntk148v/gradle-git-4.5.1:alpine').withRun('-v $HOME/.m2:/home/gradle/.m2 -v $HOME/.gradle:/home/gradle/.gradle') { c ->
        catchError {
            stage('Checkout') {
                checkout scm
            }

            stage('Clean') {
                sh './gradlew -v'
                // Workaround with 'Gradle locks the global script cache' issue
                sh 'find /home/gradle/.gradle -type f -name "*.lock" | while read f; do rm $f; done'
                sh './gradlew clean --profile'
            }

            stage('Build') {
               if (env.CHANGE_ID) {
                    buildPullRequest()
               } else {
                    buildPushCommit()
               }
            }

            stage('Test') {
                if (env.CHANGE_ID) {
                    testPullRequest()
                } else {
                    testPushCommit()
                }
            }

            stage('SonarQube analysis') {
                withSonarQubeEnv('Sonar OpenCPS') {
                    // requires SonarQube Scanner for Gradle 2.1+
                    // It's important to add --info because of SONARJNKNS-281
                    sh './gradlew --info sonarqube'
                }

                script {
                    timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
                        def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }
    }
}


def buildPushCommit() {
    try {
        sh './gradlew buildService --profile'
    } catch(InterruptedException interruptEx) {
        currentBuild.result = 'ABORTED'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {
        // Update commit status (later)
        return
    }
}


def buildPullRequest() {
    try {
        sh './gradlew buildService --profile'
    } catch(InterruptedException interruptEx) {
        currentBuild.result = 'ABORTED'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {
        if (currentBuild.result == "ABORTED") {
            pullRequest.createStatus(status: 'canceled',
                                     description: 'Build was canceled')
        } else if (currentBuild.result == "FAILED") {
        pullRequest.createStatus(status: 'failed',
                                 description: 'Build was  Failed')
        } else {
            return
        }
    }
}


def cleanPushCommit() {
    try {
        sh './gradlew -v'
        // Workaround with 'Gradle locks the global script cache' issue
        sh 'find /home/gradle/.gradle -type f -name "*.lock" | while read f; do rm $f; done'
        sh './gradlew clean --profile'
        currentBuild.result = 'SUCCESS'
    } catch(InterruptedException interruptEx) {
        currentBuild.result = 'ABORTED'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {
        // Update commit status (later)
        return
    }
}


def testPushCommit() {
    try {
        sh './gradlew test --profile'
        currentBuild.result = 'SUCCESS'
    } catch(InterruptedException interruptEx) {
        currentBuild.result = 'ABORTED'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {
        // Update commit status (later)
        return
    }
}


def testPullRequest() {
    try {
        sh './gradlew test --profile'
        currentBuild.result = 'SUCCESS'
    } catch(InterruptedException interruptEx) {
        currentBuild.result = 'ABORTED'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    } finally {
        // Uncomment when we know Reviewer identities
        // pullRequest.addAssignee('Noone')
        if (currentBuild.result == "ABORTED") {
            pullRequest.createStatus(status: 'canceled',
                                     description: 'Test was canceled')
        } else if (currentBuild.result == "FAILED") {
            pullRequest.createStatus(status: 'failed',
                                     description: 'Test was Failed',
                                     targetUrl: "${env.JOB_URL}/testResults")
        } else if (currentBuild.result == 'SUCCESS') {
            // Create report! (with junit or publishHTML)
            pullRequest.createStatus(status: 'SUCCESS',
                                     description: 'All tests are passing.',
                                     targetUrl: "${env.JOB_URL}/testResults")
        } else {
            return
        }
    }
}
