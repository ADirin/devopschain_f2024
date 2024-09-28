pipeline {
    agent any // IN THE LECTURE I WILL EXPLAIN THE SCRIPT AND THE WORKFLOW
    
    environment {
        // Define Docker Hub credentials ID
        DOCKERHUB_CREDENTIALS_ID = 'dockerhub-credentials'
        // Define Docker Hub repository name
        DOCKERHUB_REPO = 'amirdi/devopschain'
        // Define Docker image tag
        DOCKER_IMAGE_TAG = 'ver2'
    }
    stages {
        stage('Checkout') {
            steps {
                // Checkout code from Git repository
                git 'https://github.com/ADirin/devopschain_f2024.git'
            }
        }
        stage('Code Coverage') {
            steps {
                // Run Maven to generate JaCoCo code coverage report (Windows bat or Linux sh)
                bat 'mvn jacoco:report' // For Windows
                // sh 'mvn jacoco:report' // Uncomment if you're running on Linux
            }
        }
        stage('Publish Test Results') {
            steps {
                // Publish the JUnit test results
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                // Publish the Jacoco coverage report
                jacoco()
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image with the tag from the Dockerfile in the current directory
                    docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    // Push the built Docker image to Docker Hub
                    docker.withRegistry('https://index.docker.io/v1/', env.DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }
}
