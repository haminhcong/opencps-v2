import groovy.io.FileType

node() {
    docker.image('ntk148v/gradle-git-4.5.1:alpine').withRun('-v $HOME/.m2:/home/gradle/.m2 -v $HOME/.gradle:/home/gradle/.gradle') { c ->
        catchError {
            stage('Checkout') {
                checkout scm
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
        def htmlReports = ""
        def currentDir = new File("modules")
        currentDir.eachFileRecurse(FileType.DIRECTORIES) { dirName ->
            if (dirName.name.contains("backend") || dirName.name.contains("frontend") || dirName.name.contains("opencps")) {
                htmlReports += dirName.name + "/reports/tests/test/index.html"
            }
        }
        if (htmlReports.length() >= 1) {
            htmlReports = htmlReports.substring(0, htmlReports.length() - 1);
        }
        echo "${htmlReports}"
        publishHTML([
                allowMissing: true, alwaysLinkToLastBuild: false,
                keepAll     : false, reportDir: 'modules',
                reportFiles : htmlReports,
                reportName  : 'HTML Report', reportTitles: ''
        ])
    }
}