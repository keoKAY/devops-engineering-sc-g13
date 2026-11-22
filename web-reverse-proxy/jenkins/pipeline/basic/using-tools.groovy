pipeline {
    agent any
    tools{
       // nodejs 'node-v22.23'
       nodejs 'node-v26.13'
    }
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
                   node --version 
                   npm --version 
                   #npm install 
                   #npm run build 
                """
            }
        }
      
    }
}
