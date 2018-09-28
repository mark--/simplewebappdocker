
pipeline {
    agent any
    stages {
        stage("Checkout") {
            steps {
                checkout scm
                script { currentBuild.result = 'SUCCESS'}
            }
        }
        stage("Push Test") {
            tools {
                docker "docker"
            }
            steps { sh "docker  clean deploy" }
            post {
                failure {
                    script { currentBuild.result = 'FAILED'}
                }
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

