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
                buildPushCommit()
            }

            stage('Test') {
                testPushCommit()
            }
        }
    }
}


def buildPushCommit() {
    try {
//        sh './gradlew buildService --profile'
        throw new IOException("Error")
    }  catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    }finally{
       return
    }
}
def testPushCommit() {
    try {
        sh './gradlew test --profile'
        currentBuild.result = 'SUCCESS'
    } catch(err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}