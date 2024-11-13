pipeline {
    agent any

    environment {
        // Configuration Maven
        MAVEN_HOME = tool name: 'jenkins-maven', type: 'hudson.tasks.Maven$MavenInstallation'
        PATH = "${env.PATH};${MAVEN_HOME}\\bin"
    }

    stages {
        stage('Checkout') {
            steps {
                // Cloner le dépôt depuis GitHub
                git url: 'https://github.com/Aloui-Nourhen/petclinic.git', branch: 'master'
            }
        }

        stage('Build') {
            steps {
                // Compilation du projet avec Maven
                script {
                    if (isUnix()) {
                        sh "'${MAVEN_HOME}/bin/mvn' clean install"
                    } else {
                        bat(/"${MAVEN_HOME}\bin\mvn" clean install/)
                    }
                }
            }
        }

        stage('Test') {
            steps {
                // Exécution des tests avec Maven
                script {
                    if (isUnix()) {
                        sh "'${MAVEN_HOME}/bin/mvn' test"
                    } else {
                        bat(/"${MAVEN_HOME}\bin\mvn" test/)
                    }
                }
            }
        }

        stage('Package') {
            steps {
                // Générer le package
                script {
                    if (isUnix()) {
                        sh "'${MAVEN_HOME}/bin/mvn' package"
                    } else {
                        bat(/"${MAVEN_HOME}\bin\mvn" package/)
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Déploiement de l’application...'
                // Ajoutez ici les étapes de déploiement, par exemple, copier le .jar généré vers un serveur
            }
        }
    }

    post {
        always {
            echo 'Pipeline terminé.'
            // Actions à effectuer, quel que soit le résultat, comme la suppression des fichiers temporaires
        }
        success {
            echo 'Pipeline terminé avec succès.'
        }
        failure {
            echo 'Échec du pipeline.'
        }
    }
}
