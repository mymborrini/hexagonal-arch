pipeline {
    agent any

    tools {
        maven 'maven3'
    }

    stages {
        stage('Package') {
            steps {

                git branch: 'main', url: 'https://github.com/mymborrini/hexagonal-arch.git'
                sh 'java --version'
                sh 'mvn --version'
                sh 'mvn package -f pom.xml'
            }
        }

        stage('Build Image'){
            steps {
                script {
                    sh 'ls adapters/target/'
                    app = docker.build('mborrini/hexagonal-arch')
                }
            }
        }

        stage('Run'){
            steps {
                sh 'docker network inspect hexagonal-arch --format {{.Id}} 2>/dev/null || docker network create --driver bridge hexagonal-arch'
                sh 'docker run -d \
                    	--name psql15 \
                    	--network hexagonal-arch \
                    	-e POSTGRES_PASSWORD=postgres123 \
                    	-e PGDATA=/var/lib/postgresql/data/pgdata \
                    	postgres:15'
                sh 'docker run mborrini/hexagonal-arch --network hexagonal-arch'
            }
        }


    }
}
// What to do now?
// Make jenkins download automatically when a new commit and trigger the pipeline based on the configuration in the repository
// Make domain application and adapters run in parallels
// Run a postgres database in the VM