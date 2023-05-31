pipeline {
    agent any

    options {
        timestamps()
        timeout(time: 10, unit: 'MINUTES')

        buildDiscarder(logRotator(numToKeepStr: '10'))
        disableConcurrentBuilds()
    }
    parameters {
        booleanParam(name: 'UNITTEST', defaultValue: false, description: 'Run Unit Tests?')
    }	
    
    stages {
        stage ('Init') {
            steps {
                echo 'Stage: Init'
                echo "branch=${env.BRANCH_NAME}, unitTests=${params.UNITTEST}"
            }
        }
        stage ('Unit Test') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'master'
                    params.UNITTEST == true
                }
            }
            options { timeout(time: 3, unit: 'MINUTES') }
            steps {
                echo 'Stage: Unit Test'
                // Use OR 'true' to allow the pipeline to continue on failure
                // sh 'mvn clean test || true'
                sh 'mvn clean test'
                junit(allowEmptyResults: false, testResults: '**/surefire-reports/*.xml')
            }
        }
        stage ('Build') {
            options { timeout(time: 3, unit: 'MINUTES') }
            steps {
                echo 'Stage: Build'
                sh 'mvn clean package -DskipTests'
                archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
            }
        }
    }
    post {
        always {
            echo 'post/always'
            deleteDir()
        }
    }
}
