pipeline {
    agent any
    tools {
        // Définir les outils nécessaires (Maven 3.9.9 et JDK 23)
        maven 'Maven 3.9.9'  // Remplacez par la version de Maven installée dans Jenkins
        jdk 'JDK 23'         // Remplacez par la version de JDK installée dans Jenkins
    }
    environment {
        // Spécifiez JAVA_HOME et MAVEN_HOME pour garantir l'utilisation des bonnes versions
        JAVA_HOME = tool name: 'JDK 23', type: 'JDK'
        MAVEN_HOME = tool name: 'Maven 3.9.9', type: 'Maven'
        PATH = "${JAVA_HOME}/bin:${MAVEN_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                // Cloner ou vérifier le code à partir de votre propre dépôt Git
                git 'https://github.com/Aloui-Nourhen/petclinic.git'  // Remplacez cette URL par celle de votre dépôt
            }
        }
        stage('Build') {
            steps {
                // Construire l'application avec Maven
                sh "'${MAVEN_HOME}/bin/mvn' clean install -DskipTests"
            }
        }
        stage('Test') {
            steps {
                // Exécuter les tests unitaires avec Maven
                sh "'${MAVEN_HOME}/bin/mvn' test"
            }
        }
        stage('Package') {
            steps {
                // Créer le package de l'application
                sh "'${MAVEN_HOME}/bin/mvn' package"
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
