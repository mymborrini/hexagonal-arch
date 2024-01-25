pipeline {

/* This is really useful if you need to run your script inside a specific container
agent {
        docker { image 'node:20.11.0-alpine3.19' }
    }
*/
    agent any

    tools {
        maven 'maven3'
    }

    environment {
        DOCKER_IMAGE_NAME = "mborrini/hexagonal-arch"
    }

    stages {

        stage('Test') {

           steps {
               sh 'mvn test -f pom.xml'
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

        stage('Build Push Docker Image'){
            when {
                branch 'main'
            }
            steps {
                script {
                    app = docker.build(DOCKER_IMAGE_NAME + ":v0.3.1")
                    docker.withRegistry('', 'docker-cred'){
                        app.push()
                    }
                }
            }
        }




    }
}

// Make domain application and adapters run in parallels
// Run a postgres database in the VM