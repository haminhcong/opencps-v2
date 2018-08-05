import hudson.tasks.test.AbstractTestResultAction
// pipeline for push commit build
node() {
//    docker.image('conghm/gradle-git-4.5.1:alpine').withRun('-v maven_cache_volume:/home/gradle/maven_cache -v gradle_cache_volume:/home/gradle/gradle_cache') { c ->
//    docker.image('conghm/gradle-git-4.5.1:alpine').withRun() { c ->
    docker.image('conghm/gradle:4.9.0-jdk8').inside('-v "gradle_cache_volume:/home/gradle/gradle_cache" ') {
        stage('Checkout') {
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
//            sh 'cp -ar /home/gradle/gradle_cache/* /home/gradle/.gradle/'
            sh 'cat  Jenkinsfile'
            sh 'gradle -v'
            sh 'ls -al /home/gradle/.gradle'
            sh 'du -sh /home/gradle/.gradle'
            sh 'gradle --no-daemon clean --profile'
        }

        stage('Build') {
            buildPushCommit()
        }

        stage('Test') {
            testPushCommit()
        }
    }
}


def buildPushCommit() {
    sh 'gradle --no-daemon  buildService --profile'
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

@NonCPS
def getTestStatuses() {
    def testStatus = ""
    AbstractTestResultAction testResultAction = currentBuild.rawBuild.getAction(AbstractTestResultAction.class)
    if (testResultAction != null) {
        def total = testResultAction.totalCount
        def failed = testResultAction.failCount
        def skipped = testResultAction.skipCount
        def passed = total - failed - skipped
        // testStatus = "Test Status:\n  Passed: ${passed}, Failed: ${failed} ${testResultAction.failureDiffString}, Skipped: ${skipped}"
        testStatus = "Unit Test Results: Passed: ${passed}, Failed: ${failed} ${testResultAction.failureDiffString}, Skipped: ${skipped}"

        if (failed == 0) {
            currentBuild.result = 'SUCCESS'
        }
    }
    return testStatus
}

@NonCPS
def isUnitTestsSuccess(){
    AbstractTestResultAction testResultAction = currentBuild.rawBuild.getAction(AbstractTestResultAction.class)
    if (testResultAction != null) {
        def failed = testResultAction.failCount
        if (failed == 0) {
            return true
        }
    }
    return false
}


def testPushCommit() {
    try {
        sh 'gradle --no-daemon  test --profile'
        if (env.CHANGE_ID) {
            pullRequest.createStatus(status: 'success',
                         context: 'continuous-integration/jenkins/pr-merge/tests',
                         description: 'Check test',
                         targetUrl: "${env.JOB_URL}".toString())
                         
        }
    } catch (err) {
        echo "${err}"
        throw err
    } finally {
        junit 'modules/**/TEST-*.xml'
        if (env.CHANGE_ID) {
            def testResultString = getTestStatuses()
            echo "${testResultString}"
            pullRequest.comment("[${testResultString}](${env.JOB_URL}${BUILD_NUMBER}/testReport/)")
            if(isUnitTestsSuccess()){
                pullRequest.createStatus(status: 'success',
                            context: 'Unit test',
                            description: "Test success: ${testResultString}".toString(),
                            targetUrl: "${env.JOB_URL}${BUILD_NUMBER}/testReport/")
            }
            else{
                pullRequest.createStatus(status: 'failure',
                            context: 'Unit test',
                            description: "Test failed: ${testResultString}".toString(),
                            targetUrl: "${env.JOB_URL}${BUILD_NUMBER}/testReport/".toString())
            }
                         
        }

//        for (def subModule : subModules) {
//            publishHTML([
//                    allowMissing         : true,
//                    alwaysLinkToLastBuild: true,
//                    keepAll              : true,
//                    reportDir            : "modules/${subModule}/build/reports/tests/test/",
//                    reportFiles          : "index.html",
//                    reportTitles         : "Unit test ${subModule} Report"
//            ])
//        }
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