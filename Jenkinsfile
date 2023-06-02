pipeline{
    agent any
    stages{
        stage('Git Clone'){
            steps{
                git branch: 'main', url: 'https://github.com/sheebavv/jenkinssample.git'
            }
        }
        stage('Test'){
            steps{
            echo "Testing completed"
            }
        }
         
        stage('Build'){
            steps{
            echo "Build completed"
            }
        }
    }
}
