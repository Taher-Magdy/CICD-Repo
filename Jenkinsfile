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
        stage('Generate and Publish Allure Report') {
            steps {
                // Generate Allure report
                script {
                    sh 'allure generate target/allure-results --clean -o target/allure-report'
                }

                // Publish Allure report
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
  }
