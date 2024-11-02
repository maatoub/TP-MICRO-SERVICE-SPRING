pipeline {
    agent any

    tools {
        maven 'maven-3.9.6' 
        jdk 'jdk-17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/maatoub/TP-MICRO-SERVICE-SPRING.git' 
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests' 
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def imageTag = "pipeline-test:${env.BUILD_NUMBER}"
                    bat "docker build -t ${imageTag} ."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'password', usernameVariable: 'username')]) {
                        bat "docker login -u %username% -p %password%"
                        bat "docker push ${imageTag}"
                    }
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    def imageTag = "pipeline-test:${env.BUILD_NUMBER}"
                    bat "docker run -d -p 8080:8080 ${imageTag}"
                }
            }
        }
    }

    post {
        success {
            echo 'Construction et déploiement réussis !'
        }
        failure {
            echo 'Échec de la construction ou du déploiement.'
        }
    }
}