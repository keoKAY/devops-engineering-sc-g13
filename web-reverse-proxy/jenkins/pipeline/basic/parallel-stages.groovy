pipeline{
    agent any 
    stages{
        stage("Stage1"){
            steps{
                echo "This is stage1 "
            }
        }
        // parallel keywords 
        stage("Stage2"){
            parallel{
                stage("Tasks 1 "){
                    steps{
                        echo "This is task 1 "
                    }
                }
                stage("Tasks 2 "){
                    steps{
                        echo "This is tasks 2 "
                    }
                }
            }
            
        }
        stage("Last Stage"){
            steps{
                echo "This is the last stage "
            }
        }
    }
}