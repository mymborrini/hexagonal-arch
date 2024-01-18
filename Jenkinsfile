pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    environment {
        DOCKER_IMAGE_NAME = "mborrini/hexagonal-arch"
    }

    stages {
        stage('Package') {

            steps {
                script {
                    sh 'mvn package -f pom.xml'
                }
            }
        }

        stage('Build Docker Image'){
            when {
                branch 'main'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME)
                }
            }
        }

        stage('Deploy'){
            when {
                branch 'main'
            }
            steps {
                sh 'docker-compose up -d'
            }
        }


    }
}

// Make domain application and adapters run in parallels
// Run a postgres database in the VM