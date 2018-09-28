
pipeline {
    agent none
    stages {
        stage("Choose Environment") {
            steps {
                script { 
                 env.DEPLOYENV = input message: 'On which environment should the application be employed?',
              	parameters: [choice(name: 'Environment', choices: 'dev\ntest\nprod')]
                
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

