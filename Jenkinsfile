pipeline {
    agent any

    environment {
        ARTIFACT_VERSION = '6.10.4'
        DEPLOY_ENVIRONMENT = 'staging'
        GIT_CREDENTIALS_ID = 'my_github_key'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Git checkout Started...'
                script {
                    checkout([
                        $class: 'GitSCM',
                        branches: [[name: 'main']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        submoduleCfg: [],
                        userRemoteConfigs: [[
                            credentialsId: env.GIT_CREDENTIALS_ID,
                            url: 'https://github.com/pmojumder/Ebay_01.git'
                        ]]
                    ])
                }
                echo 'Git checkout Completed...'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Test Execution Started...'
                bat 'mvn test'
                echo 'Test Execution Completed...'
            }
        }

        stage('Reports') {
            steps {
                echo 'Publishing test reports...'
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/surefire-reports/**', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution finished.'
        }
        success {
            echo 'Pipeline succeeded.'
            script {
                echo 'Triggering the next job...'
                build job: 'PythonLearn',
                parameters: [
                    string(name: 'ARTIFACT_VERSION', value: env.ARTIFACT_VERSION),
                    string(name: 'DEPLOY_ENVIRONMENT', value: env.DEPLOY_ENVIRONMENT)
                ],
                wait: false
            }
        
        }
        failure {
            echo 'Pipeline failed.'
            emailext (
                subject: "Jenkins Job Failed: ${env.JOB_NAME}",
                body: """<p>Jenkins job <b>${env.JOB_NAME}</b> has failed.</p>
                         <p>Build URL: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>""",
                to: 'plabani52@gmail.com,ruma.mojumder@gmail.com'
            )
        }
    }
}
