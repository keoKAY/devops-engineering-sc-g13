 // Build, Use Docker Container inside your jenkins pipeline 

pipeline {

        // discardOldBuild(logrotation)
    // timeout 
    options{
        timeout(time: 5, unit: 'SECONDS')
        buildDiscarder logRotator(numToKeepStr: '3', daysToKeepStr: '7')
    }
    agent {
        docker {
            image 'node:alpine'
            args '-u root' // user that run command in container is root 
        }
    }
    // tools{
    //    // nodejs 'node-v22.23'
    //    nodejs 'node-v26.13'
    // }
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
                   npm install 
                   npm run build 
                """
            }
        }
      
    }
}
