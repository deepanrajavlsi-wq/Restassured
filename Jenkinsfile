pipeline {
    agent any

    tools {
        maven 'Maven-3.10.0'
    }

    options {
        timestamps()
    }

    stages {
        stage('Build and test') {
            steps {
                dir('RESTAssuredAutomation') {
                    script {
                        if (isUnix()) {
                            sh 'mvn -B clean test'
                        } else {
                            bat 'mvn -B clean test'
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            junit testResults: 'RESTAssuredAutomation/target/surefire-reports/TEST-*.xml'
        }
    }
}
