pipeline {
    agent any

    stages {
        stage('Clone Code') {
            steps {
                // git clone url branch:master
                git 'https://github.com/keoKAY/reactjs-devop8-template'
            }
        }

    stage("Check Code Quality in Sonarqube "){
            
            environment {
                scannerHome= tool 'sonar-scanner' 
            }

            steps{
                withSonarQubeEnv(credentialsId: 'SONAR-TOKEN', installationName: 'sonar-scanner') {

                script{
                    def projectKey = 'reactjs-devops13-template' 
                    def projectName = 'ReactjsDevOps13template'
                    def projectVersion = '1.0.0' 
                    sh """
                    ${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName="${projectName}" \
                    -Dsonar.projectVersion=${projectVersion} \
                     """   
                        
                        }
            }

            }
        }
        stage("Build"){
            when {
                expression {false }
            }
            steps{
                sh """
                    docker build -t jenkins-react -f prod.Dockerfile .
                """
            }
        }
        stage("Deploy"){
            when {
                expression { false }
            }
            steps{
                sh """
                docker rm -f react-cont  || true

                docker run -dp 3005:80 --name react-cont jenkins-react
                """
            }
        }
    }
}
