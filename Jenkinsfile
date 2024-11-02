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
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'password', usernameVariable: 'username')]) {
                        def imageTag = "${username}/pipeline-test:${env.BUILD_NUMBER}"
                        bat "docker build -t ${imageTag} ."
                        bat "echo %password% | docker login -u %username% --password-stdin"
                        bat "docker push ${imageTag}"
                    }
                }
            }
        }

        stage('Deploy to Docker') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'password', usernameVariable: 'username')]) {
                        def imageTag = "${username}/pipeline-test:${env.BUILD_NUMBER}"
                        bat "docker run -d -p 8080:8080 ${imageTag}"
                    }
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
