pipeline {
    agent any

    // declare variable for resuable purpose 
    // User-Defined vs Built-in
    environment{
        IMG_NAME="sc-jenkins-react"
        VERSION="v1.0.${env.BUILD_NUMBER}"
        FULL_IMG="${IMG_NAME}:${VERSION}"
        DOCKERFILE="prod.Dockerfile"
    }
    stages {
        stage('Clone Code') {
            steps {
                // git clone url branch:master
                git 'https://github.com/keoKAY/reactjs-devop8-template'
            }
        }
        stage("Build"){
            when {
                expression{ false }
            }
            steps{
                sh """
                    docker build -t ${FULL_IMG} -f ${DOCKERFILE} .
                """
            }
        }
        stage("Registry"){
            when{
                expression {
                    params.IS_PUSH == true 
                }
            }
            steps{
                withCredentials([usernamePassword(
                    credentialsId: 'DH_STAG', 
                    passwordVariable: 'PASS', 
                    usernameVariable: 'NAME')]) {
                
                sh """
                docker login -u ${NAME} -p ${PASS} 
                docker tag ${FULL_IMG} ${NAME}/${FULL_IMG} 
                docker push ${NAME}/${FULL_IMG} 
                """
  


            }

                
            }
        }
        stage("Deploy"){
            steps{
               
               script{
                def envOption=input message: 'Choose your environment: ', parameters: [choice(choices: ['STAG', 'PROD', 'TESTING'], description: 'environment to deploy the service ', name: 'ENVIRONMENT')]
                
                 sh """
                    echo "Your option is : ${envOption}"
                 """

               }
                // sh """
                // docker rm -f react-cont  || true
                // docker run -dp 3005:80 --name react-cont ${FULL_IMG}
                // """
            }
        }
    }
}
