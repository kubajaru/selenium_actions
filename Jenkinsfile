pipeline {
    agent any
    tools{
        maven "Maven"
    }
    stages {
        stage("test") {
            steps{
                echo "Starting tests"
                sh '''
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
