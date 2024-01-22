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

        stage('Build Docker Image'){
            when {
                branch 'main'
            }
            steps {
                script {
                   // app = docker.build(DOCKER_IMAGE_NAME + ":${env.BUILD_ID}")
                    app = docker.build(DOCKER_IMAGE_NAME + "latest")
                    app.push()
                }
            }
        }




    }
}

// Make domain application and adapters run in parallels
// Run a postgres database in the VM