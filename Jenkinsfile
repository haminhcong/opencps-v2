// pipeline for push commit build
node() {
    docker.image('conghm/gradle-git-4.5.1:alpine').withRun('-v maven_cache_volume:/home/gradle/maven_cache -v gradle_cache_volume:/home/gradle/gradle_cache') { c ->
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
                sh 'du -sh /home/gradle/.gradle'
                sh 'sleep 120'
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
                    allowMissing         : true,
                    alwaysLinkToLastBuild: true,
                    keepAll              : true,
                    reportDir            : "modules/${subModule}/build/reports/tests/test/",
                    reportFiles          : "index.html",
                    reportTitles         : "Unit test ${subModule} Report"
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