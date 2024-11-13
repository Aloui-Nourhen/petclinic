pipeline {
    agent any
    tools {
        // Définir les outils nécessaires (par exemple, Maven, JDK)
        maven 'Maven 3.6.3'
        jdk 'JDK 11'
    }
    stages {
        stage('Checkout') {
            steps {
                // Cloner ou vérifier le code à partir du dépôt Git
                git 'https://github.com/spring-projects/spring-petclinic.git'
            }
        }
        stage('Build') {
            steps {
                // Construire l'application avec Maven
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Exécuter les tests unitaires avec Maven
                sh 'mvn test'
            }
        }
        stage('Package') {
            steps {
                // Créer le package de l'application
                sh 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                // Déployer l'application sur un serveur (par exemple, un serveur Tomcat)
                sh 'scp target/petclinic.war user@server:/path/to/deploy'
            }
        }
        stage('Post-build actions') {
            steps {
                // Effectuer des actions post-build, comme envoyer un email ou notifier un autre système
                echo 'Pipeline terminé avec succès'
            }
        }
    }
}
