pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat "mvn -D clean test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'emailable-report.html',
                       reportName: 'HTML Report',
                       reportTitles: '',
                       useWrapperFileDirectly: true])
                }
            }
        }

        stage('Open Allure Report') {
            steps {
                // Open Allure report in the default web browser
                script {
                    bat 'allure open target\\allure-results'
                }
            }
        }
               
    }
  }
