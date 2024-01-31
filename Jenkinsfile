pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                // Run Maven clean and test
                bat "mvn -D clean test"

                // Generate Allure report
                bat 'allure generate target/allure-results --clean -o target/allure-report'

                // Publish Allure report
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }

            post {
                success {
                    // Archive HTML reports (if applicable)
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/surefire-reports/',
                        reportFiles: 'emailable-report.html',
                        reportName: 'HTML Report',
                        reportTitles: '',
                        useWrapperFileDirectly: true
                    ])
                }
            }
        }
    }

    }
}