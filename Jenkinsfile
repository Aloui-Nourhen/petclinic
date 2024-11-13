pipeline {
    agent any
    environment {
        MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
    }
    stages {
        stage('Build') {
            steps {
                script {
                    try {
                        // Enlève "nohup" pour rendre la commande compatible Windows
                        bat 'mvn -B clean install -U -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true'
                    } catch (Exception e) {
                        echo "Build failed due to dependency resolution issues: ${e.message}"
                        error("Stopping pipeline due to dependency issues.")
                    }
                }
            }
        }
        stage('Test') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                bat 'mvn test'
            }
        }
        stage('Package') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            when {
                expression { currentBuild.resultIsBetterOrEqualTo('SUCCESS') }
            }
            steps {
                echo 'Deployment step goes here'
                // Ajoutez vos étapes de déploiement ici
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
