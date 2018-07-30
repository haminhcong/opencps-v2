import groovy.io.FileType

// pipeline for push commit build
node() {
    docker.image('ntk148v/gradle-git-4.5.1:alpine').withRun('-v $HOME/.m2:/home/gradle/.m2 -v $HOME/.gradle:/home/gradle/.gradle') { c ->
        catchError {
            stage('Checkout') {
//                echo "${env.BRANCH_NAME}"
//                checkout scm
                checkout changelog: true, poll: true, scm: [
                        $class           : 'GitSCM',
                        branches: scm.branches,
                        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                        extensions       : [[$class   : 'CloneOption',
                                             reference: '/home/hieule/conghm-opencps-v2-local/opencps-v2.git',
                                             shallow  : false, timeout: 75]],
                        userRemoteConfigs: scm.userRemoteConfigs
                ]
            }
            stage('Clean') {
                sh 'cat  Jenkinsfile'
                sh './gradlew -v'
                // Workaround with 'Gradle locks the global script cache' issue
                sh 'find /home/gradle/.gradle -type f -name "*.lock" | while read f; do rm $f; done'
                sh './gradlew --no-daemon clean --profile'

                def modulesList = getSubModules()
                echo "${modulesList}"
            }
//
//            stage('Build') {
//                buildPushCommit()
//            }
//
//            stage('Test') {
//                testPushCommit()
//            }
        }
    }
}


def buildPushCommit() {
    sh './gradlew --no-daemon  buildService --profile'
}

@NonCPS
def getSubModules() {
    sh "ls -al"
    def currentDir = new File("./modules")
    echo "${currentDir.path}"
    def moduleList = []
//    currentDir.eachFileRecurse(FileType.DIRECTORIES) { dirName ->
//        if (dirName.name.contains("backend") || dirName.name.contains("frontend") || dirName.name.contains("opencps")) {
//            if (fileExists('file')) {
//                echo "${dirName}"
//                moduleList.add(dirName)
//            } else {
//                echo "No + ${dirName}"
//            }
//        }
//    }
    return moduleList
}


def testPushCommit() {
    try {
        sh './gradlew --no-daemon  test --profile'
    } catch (err) {
        echo "${err}"
        throw err
    } finally {
        junit 'modules/**/TEST-*.xml'
        def modulesList = getSubModules()
        echo "${modulesList}"
//        sh './gradlew --no-daemon  aggregateUnitTests --profile'
//        publishHTML([
//                allowMissing: true, alwaysLinkToLastBuild: false,
//                keepAll     : false, reportDir: 'build/unit_test_results',
//                reportFiles : "**.html",
//                reportName  : 'HTML Report', reportTitles: ''
//        ])
    }
}

//def htmlReports = ""
//def currentDir = new File("modules")
//currentDir.eachFileRecurse(FileType.DIRECTORIES) { dirName ->
//    if (dirName.name.contains("backend") || dirName.name.contains("frontend") || dirName.name.contains("opencps")) {
//        htmlReports += dirName.name + "/reports/tests/test/index.html"
//    }
//}
//if (htmlReports.length() >= 1) {
//    htmlReports = htmlReports.substring(0, htmlReports.length() - 1);
//}
//echo "${htmlReports}"
//publishHTML([
//        allowMissing: true, alwaysLinkToLastBuild: false,
//        keepAll     : false, reportDir: 'modules',
//        reportFiles : htmlReports,
//        reportName  : 'HTML Report', reportTitles: ''
//])
//