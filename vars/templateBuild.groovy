def call(label = 'docker', cc_env = 'cc-docker', env = 'docker') {
    pipeline {
        agent {
            label 'docker'
        }
        environment {
            SAG_AQUARIUS='aquarius-bg.eur.ad.sag'
        }
        stages {
            stage("Provision CC") {
                environment {
                    CC_ENV = 'cc-docker'
                }
                steps {
                    timeout(time:30, unit:'MINUTES') {
                        echo "$CC_ENV"
                        //sh 'docker-compose run --rm init'
                        //sh 'docker-compose port cc 8091'
                    }
                }
            }        
            stage("Provision GA") {
                environment {
                    CC_ENV = 'docker'
                    TEST_SUITE = '**/AcceptanceTestSuite.class'
                }
                steps {
                    timeout(time:90, unit:'MINUTES') {
                        //sh "docker-compose run --rm test"
                        echo "$CC_ENV"
                    }
                }
                // post {
                //     always {
                //         junit "**/$CC_ENV/TEST-*.xml"
                //     }
                // }
            }
        }
    }
}
