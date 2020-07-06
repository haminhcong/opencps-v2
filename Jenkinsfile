node() {
    stage('Check') {
        sh 'cat  Jenkinsfile'
        sh 'gradle -v'
        sh 'gradle --no-daemon clean --profile'
    }
}