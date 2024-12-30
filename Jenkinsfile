pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Ensure this matches the Maven configuration in Jenkins
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token') // Replace with your credentials ID for the SonarQube token
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') { // Ensure this matches your SonarQube configuration in Jenkins
                    bat """
                    mvn sonar:sonar ^
                      -Dsonar.projectKey=sonar-maven ^
                      -Dsonar.sources=src/main/java ^
                      -Dsonar.host.url=http://localhost:9000 ^
                      -Dsonar.login=%SONAR_TOKEN%
                    """
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
