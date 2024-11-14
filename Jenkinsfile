pipeline {
    agent any
    
    tools {
        // Assurez-vous que 'Maven' est configuré dans les outils Jenkins
        maven 'jenkins-maven' 
        // Assurez-vous que 'JDK' est configuré dans les outils Jenkins
        jdk 'JDK'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Vérifier que le dépôt Git est cloné correctement
                git branch: 'main', url: 'https://github.com/Aloui-Nourhen/petclinic.git'
            }
        }
        
        stage('Build') {
            steps {
                // Compiler le projet avec Maven
                bat 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Exécuter les tests avec Maven
                bat 'mvn test'
            }
        }
        
        stage('Package') {
            steps {
                // Créer un fichier JAR ou WAR pour l'application
                bat 'mvn package'
            }
        }
    }
    
    post {
        success {
            echo 'Le pipeline a réussi !'
        }
        failure {
            echo 'Le pipeline a échoué.'
        }
    }
}
