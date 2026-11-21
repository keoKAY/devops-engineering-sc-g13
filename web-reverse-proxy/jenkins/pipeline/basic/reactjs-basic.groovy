pipeline {
    agent any

    stages {
        stage('Clone Code') {
            steps {
                // git clone url branch:master
                git 'https://github.com/keoKAY/reactjs-devop8-template'
            }
        }
        stage("Build"){
            steps{
                sh """
                    docker build -t jenkins-react -f prod.Dockerfile .
                """
            }
        }
        stage("Deploy"){
            steps{
                sh """
                docker rm -f react-cont  || true

                docker run -dp 3005:80 --name react-cont jenkins-react
                """
            }
        }
    }
}
