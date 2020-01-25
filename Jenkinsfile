pipeline {
  agent {
    label 'maven'
  }
  tools {
    jdk 'jdk8'
    maven 'm3'
  }
  stages {
    stage('Tools') {
      steps {
        sh 'java -version'
        sh 'mvn -B --version'
      }
    }
    stage('Test') {
      when {
        not {
          branch 'feature/*'
        }
      }
      steps {
        sh 'mvn -B clean test'
      }
    }
    stage('Deploy') {
      when {
        anyOf {
          branch 'develop'
          branch 'master'
        }
      }
      steps {
        sh 'mvn -B -P deploy clean deploy'
      }
    }
    stage('Snapshot Site') {
      when {
        branch 'develop'
      }
      steps {
        sh 'mvn -B clean site-deploy'
      }
    }
    stage('Release Site') {
      when {
        branch 'master'
      }
      steps {
        sh 'mvn -B -P gh-pages-site clean site site:stage scm-publish:publish-scm'
      }
    }
    stage('Deploy Feature') {
      when {
        branch 'feature/*'
      }
      steps {
        sh 'mvn -B -P feature,allow-features clean deploy'
      }
    }
  }
}