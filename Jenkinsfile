pipeline {
    agent any

    tools {
        maven 'MAVEN3'
    }

    stages {
        stage('Package') {
            steps {
                // Get some code from Github repository
                git 'https://github.com/mymborrini/hexagonal-arch.git'
                sh 'java --version'
                sh 'mvn --version'
                sh 'mvn package -f pom.xml'
            }
        }


    }
}