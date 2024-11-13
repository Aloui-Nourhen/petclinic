pipeline {
    agent any
    tools {
        maven 'jenkins-maven' // Utilisez le nom exact de votre installation Maven dans Jenkins
        jdk 'JDK'          // Assurez-vous que le nom du JDK est correct dans Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Aloui-Nourhen/petclinic.git' // Remplacez cette URL par celle de votre dépôt
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                sh 'scp target/petclinic.war user@server:/path/to/deploy'
            }
        }
        stage('Post-build actions') {
            steps {
                echo 'Pipeline terminé avec succès'
            }
        }
    }
}
