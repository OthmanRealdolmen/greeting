pipeline {
     agent any
     stages {
            stage('Build, Test') {
                when {
                    not{
                        branch 'main'
                    }

                }
                steps {
                    bat 'mvn clean verify'
                }
            }
            stage('Build, Test, Release') {
                 when{
                      branch 'main'
                 }
                  steps {
                       rtMavenDeployer (
                         id: 'deployer',
                         serverId: 'artifactory',
                         releaseRepo: 'maven-libs-release-local',
                         snapshotRepo: 'maven-libs-snapshot-local'
                       )

                       rtMavenRun (
                          tool: 'Maven 3.8.4',
                          pom: 'pom.xml',
                          goals: 'clean install',
                          deployerId: 'deployer',
                       )
                  }
            }
            stage('deploy'){
                when{
                    branch 'main'
                }
                steps {
                deploy adapters: [
                    tomcat9(
                        credentialsId: '721426fa-a879-459f-b62e-2e93223289b2',
                        path: '',
                        url: 'http://localhost:1111')
                        ],
                    contextPath: 'greeting',
                    war: 'target/greeting.war'
                }
               }

     }
}