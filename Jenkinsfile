@Library('ceiba-jenkins-library') _

pipeline {
	//Donde se va a ejecutar el Pipeline
	agent {
		label 'Slave_Induccion'
	}

	//Opciones específicas de Pipeline dentro del Pipeline
	options {
		buildDiscarder(logRotator(numToKeepStr: '3'))
	disableConcurrentBuilds()
	}

	//Una sección que define las herramientas “preinstaladas” en Jenkins
	tools {
		jdk 'JDK11_Centos' //Versión preinstalada en la Configuración del Master
	}

	//Aquí comienzan los “items” del Pipeline
	stages{
		stage('Checkout') {
			steps{
				echo "------------>Checkout<------------"
				checkout scm
			}
		}

		stage('Compile & Unit Tests') {
			steps{
				echo "------------>Compile & Unit Tests<------------"
				sh 'chmod +x ./ms-invoicing/gradlew'
				sh './ms-invoicing/gradlew --b ./ms-invoicing/build.gradle test'
			}
		}
/*
		stage('Static Code Analysis') {
			steps{
				echo '------------>Análisis de código estático<------------'
				withSonarQubeEnv('Sonar') {
					sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
				}
			}
		}*/

		stage('Static Code Analysis') {
			steps{
			    echo '------------>Análisis de código estático<------------'
				sonarqubeMasQualityGatesP(
				sonarKey:'co.com.ceiba.adn:facturacion.farmacia-adrian.melo',
				sonarName:'"CeibaADN-FacturacionFarmacia(adrian.melo)"',
				sonarPathProperties:'./sonar-project.properties')
			}
		} 


		stage('Build') {
			steps {
				echo "------------>Build<------------"
				//Construir sin tarea test que se ejecutó previamente
				sh './ms-invoicing/gradlew --b ./ms-invoicing/build.gradle build -x test'

			}
		}  
	}

	post {
		always {
			echo 'This will always run'
		}
		success {
			echo 'This will run only if successful'
			junit 'ms-invoicing/build/jacoco/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
		}
		failure {
			echo 'This will run only if failed'
			mail (to: 'adrian.melo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")

		}
		unstable {
			echo 'This will run only if the run was marked as unstable'
		}
		changed {
			echo 'This will run only if the state of the Pipeline has changed'
			echo 'For example, if the Pipeline was previously failing but is now successful'
		}
	}
}