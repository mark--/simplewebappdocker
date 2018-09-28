
pipeline {
    agent any
    stages {
        stage("Checkout") {
            steps {
                checkout scm
                script { currentBuild.result = 'SUCCESS'}
            }
        }



    }
    post {
        always {
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: emailextrecipients([
                    [$class: 'CulpritsRecipientProvider'],
                    [$class: 'RequesterRecipientProvider']
                ])])
        }
    }
}

