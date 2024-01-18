pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    environment {
        DOCKER_IMAGE_NAME = "mborrini/hexagonal-arch"
    }

    stages {

        stage('Test') {

            parallel {

                stage('Domain') {
                    steps {
                        sh 'mvn test -f domain/pom.xml'
                    }
                }

                stage('Application') {
                    steps {
                        sh 'mvn test -f application/pom.xml'
                    }
                }

                stage('Domain') {
                    steps {
                        sh 'mvn test -f adapters/pom.xml'
                    }
                }



            }
        }

        stage('Package') {

            when {
                branch 'main'
            }

            steps {
                script {
                    sh 'mvn install -f pom.xml'
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