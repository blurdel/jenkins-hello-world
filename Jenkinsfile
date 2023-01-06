pipeline {
	agent any

	options {
		timestamps()
		timeout(time: 10, unit: 'MINUTES')

		buildDiscarder(logRotator(numToKeepStr: '10'))
		disableConcurrentBuilds()
    }
	environment {
		SOME_STATIC_VERSION = "0.0.1"
	}
	parameters {
		choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Select the version for this build')
		booleanParam(name: 'UNITTEST', defaultValue: true, description: 'Run Unit Tests?')
	}	
	
	stages {
		stage ('Init') {
			steps {
				echo 'Stage: Init'
				echo "branch=${env.BRANCH_NAME}, version=${params.VERSION}, unitTests=${params.UNITTEST}"
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
		stage ('Cleanup') {
			steps {
				echo 'Stage: Cleanup'
			}
		}
	}
	post {
		// Execute after all stages executed
		always {
			echo 'post/always'
            deleteDir()
			//mail to: "user@gmail.com", subject: "Jenkins Test build", body: "Test Build of Jenkins job: ${env.JOB_NAME}"
		}
		success {
			echo 'post/success'
		}
		failure {
			echo 'post/failure'
			script {
				if (env.BRANCH_NAME == 'main') {
					//mail bcc: '', body: "<br>Project: ${env.JOB_NAME} <br>Build Number: ${env.BUILD_NUMBER} <br>URL: ${env.BUILD_URL}", cc: '', charset: 'UTF-8', from: 'Jenkins', mimeType: 'text/html', replyTo: '', subject: "Build Failure: Project ${env.JOB_NAME}", to: "user@gmail.com";
				}
			}
		}
	}
}
