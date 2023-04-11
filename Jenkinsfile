pipeline {
    agent any

    options {
        timestamps()
        timeout(time: 10, unit: 'MINUTES')

        buildDiscarder(logRotator(numToKeepStr: '10'))
        disableConcurrentBuilds()
    }
    parameters {
        booleanParam(name: 'UNITTEST', defaultValue: true, description: 'Run Unit Tests?')
    }	
    
    stages {
        stage ('Init') {
            steps {
                echo 'Stage: Init'
                echo "branch=${env.BRANCH_NAME}, unitTests=${params.UNITTEST}"
            }
        }
        stage ('Test') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'master'
                    params.UNITTEST == true
                }
            }
            options { timeout(time: 3, unit: 'MINUTES') }
            steps {
                echo 'Stage: Test'
                // Use OR 'true' to allow the pipeline to continue on failure
                // sh 'mvn clean test || true'
                sh 'mvn clean test'
                junit(allowEmptyResults: false, testResults: '**/surefire-reports/*.xml')
            }
        }
        stage ('Build') {
            when {
                expression {
                    env.BRANCH_NAME == 'main' || env.BRANCH_NAME == 'master'
                }
            }
            options { timeout(time: 3, unit: 'MINUTES') }
            steps {
                echo 'Stage: Build'
                sh 'mvn clean verify -DskipTests'
                archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
            }
        }
        /*
        stage ('Test Docker') {
            agent { dockerfile true }
            steps {
                echo 'Stage: Test Docker'
                // sh 'node --version'
            }
        }
        */
    }
    post {
        // Execute after all stages executed
        always {
            echo 'post/always'
            deleteDir()
        }
        success {
            echo 'post/success'
        }
        failure {
            echo 'post/failure'
        }
    }
}
