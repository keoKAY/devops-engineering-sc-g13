// Build, Use Docker Container inside your jenkins pipeline 

pipeline {
    
    agent {
        docker {
            image 'node:alpine'
            args '-u root' // user that run command in container is root 
        }
    }

    // discardOldBuild(logrotation)
    // timeout 
    options{
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(numToKeepStr: '15'))
        disableConcurrentBuilds()
        timestamps() 
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
        stage("Testing"){
            options{
                retry(2)
                timeout(time: 5, unit: 'MINUTES')
            }
            steps{
                sh """
                echo "Demo Commands !"
                """
            }
        }
      
    }
}
