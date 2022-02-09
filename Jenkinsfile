pipeline {
     agent any
     stages {
            stage('Build') {
                steps {
                    bat 'mvn clean verify'
                }
            }
            stage('deploy'){
                steps {
                deploy adapters: [tomcat9(credentialsId: '721426fa-a879-459f-b62e-2e93223289b2', path: '', url: 'http://localhost:1111')], contextPath: 'greeting', war: 'target\greeting.war'
                }
               }

     }
}