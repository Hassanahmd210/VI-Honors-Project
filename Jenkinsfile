pipeline {
    agent any
    tools {
        maven 'maven' // Ensure 'maven' is configured in Jenkins -> Global Tool Configuration
    }
    environment {
        REPO_URL = 'https://github.com/Hassanahmd210/VI-Honors-Project.git' // Replace with your GitHub repo URL
        IMAGE_NAME = 'hassanahmd05/springboot-docker' // Replace with your Docker Hub username
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: "${REPO_URL}"]]
                )
            }
        }

        stage('Build Maven') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Run Container') {
            steps {
                bat "docker run -d -p 8081:8081 ${IMAGE_NAME}"
            }
        }
    }
}
