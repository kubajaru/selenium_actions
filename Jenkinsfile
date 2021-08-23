pipeline {
    agent any
    tools{
        maven "Maven"
    }
    stages{
        stage("build") {
            steps{
                echo "Building project"
                sh '''
                    cd week6
                    mvn clean compile
                '''
            }
        }
        stage("test") {
            steps{
                echo "Starting tests"
                sh '''
                    cd week6
                    mvn test
                '''
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/junitreports/*.xml'
            mail to: 'kubajaru@gmail.com',
                    subject: "Built Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Build finished"
        }
        failure {
            mail to: 'kubajaru@gmail.com',
                    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                    body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}