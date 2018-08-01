// pipeline for push commit build
node() {
    docker.image('ntk148v/gradle-git-4.5.1:alpine').withRun('-v $HOME/.m2:/home/gradle/.m2 -v $HOME/.gradle:/home/gradle/.gradle') { c ->
        catchError {
            stage('Checkout') {
//                echo "${env.BRANCH_NAME}"
//                checkout scm
                checkout changelog: true, poll: true, scm: [
                        $class                           : 'GitSCM',
                        branches                         : scm.branches,
                        doGenerateSubmoduleConfigurations: scm.doGenerateSubmoduleConfigurations,
                        extensions                       : [[$class   : 'CloneOption',
                                                             reference: '/home/hieule/conghm-opencps-v2-local/opencps-v2.git',
                                                             shallow  : false, timeout: 75]],
                        userRemoteConfigs                : scm.userRemoteConfigs
                ]
            }
            stage('Clean') {
                sh 'cat  Jenkinsfile'
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

            stage('SonarQube analysis') {
                withSonarQubeEnv('Sonar OpenCPS') {
                    // requires SonarQube Scanner for Gradle 2.1+
                    // It's important to add --info because of SONARJNKNS-281
                    sh './gradlew --no-daemon --info sonarqube'
                }
            }

            stage("Quality Gate"){
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


def buildPushCommit() {
    sh './gradlew --no-daemon  buildService --profile'
}

@NonCPS
def getSubModules() {
    def moduleList = []
    new File("${workspace}/modules").eachDir() { dirName ->
        if (dirName.name.contains("backend") || dirName.name.contains("frontend") || dirName.name.contains("opencps")) {
            def testReportFile = new File("${dirName.getPath()}/build/reports/tests/test/index.html")
            if (testReportFile.exists()) {
                moduleList.add(dirName.getName())
            }
        }
    }
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
        echo "get module list"
        echo "${modulesList}"
        echo "${modulesList.size()}"
        for (def subModule : subModules) {
            publishHTML([
                    allowMissing: true, alwaysLinkToLastBuild: true,
                    keepAll     : true,
                    reportDir   : "modules/${subModule}/build/reports/tests/test/",
                    reportFiles : "index.html",
                    reportName  : "Unit test ${subModule} Report",
                    reportTitles: "Unit test ${subModule} Report"
            ])
        }
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