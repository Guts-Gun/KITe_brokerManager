pipeline {
    agent any

    environment {
        imagename = "rnjsxorl3075/kite_brokermanager"
        registryCredential = 'docker'
        dockerImage = '' 
    }

    stages {

        // gradle build
        stage('Bulid Gradle') {
          agent any
          steps {
            echo 'Bulid Gradle'
            dir ('.'){
                sh """
                chmod +x gradlew
                ./gradlew clean build --exclude-task test
                """
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }

        // docker build
        stage('Bulid Docker') {
          agent any
          steps {
            echo 'Bulid Docker'
            sh "echo jenkins | sudo -kS chmod 666 /var/run/docker.sock"
            script {
                  dockerImage = docker.build imagename
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }

        // docker push
        stage('Push Docker') {
          agent any
          steps {
            echo 'Push Docker'
            script {
                docker.withRegistry( '', registryCredential) {
                    dockerImage.push("${currentBuild.number}")
                }
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }

        stage('Deploy to dev') {
          steps {

              git credentialsId: 'github',
                      url: 'https://github.com/Guts-Gun/KITe_ArgoCD.git',
                      branch: 'main'

              sh "git pull origin main"
              sh "sed -i 's/kite_brokermanager:.*\$/kite_brokermanager:${currentBuild.number}/g' service/brokermanager-deployment.yaml"
              sh "cat service/brokermanager-deployment.yaml"
              sh "git config user.name 'Lab00700'"
              sh "git config user.email 'zerglisk123@naver.com'"
              sh "git add service/brokermanager-deployment.yaml"
              sh "git commit -m '[UPDATE] kite_brokermanager ${currentBuild.number} image versioning'"

              withCredentials([gitUsernamePassword(credentialsId: 'github')]) {
                sh "git remote set-url origin https://github.com/Guts-Gun/KITe_ArgoCD.git"
                sh "git push origin main"
              }
            }

           post {
                    failure {
                      echo 'Update 실패ㅠㅠ'
                    }
                    success {
                      echo 'Update 성공!!!!'
                    }
            }
        }
    }
}
