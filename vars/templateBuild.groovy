def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def cc_env = config.cc_env
    def main_env = config.env
    def label = config.label
    def aquarius = config.aquarius

    pipeline {
        agent any
        environment {
            SAG_AQUARIUS="$aquarius"
        }
        stages {
            stage("Provision Command Central") {
                environment {
                    CC_ENV = "$cc_env"
                }
                steps {
                    timeout(time:30, unit:'MINUTES') {
                        echo "Provisioning CC for $env.CC_ENV"
                        //sh 'docker-compose run --rm init'
                        sh 'docker-compose up -d cc'
                        sh 'docker-compose port cc 8091'
                    }
                }
            }        
            // stage("Provision GA") {
            //     environment {
            //         CC_ENV = "$main_env"
            //         TEST_SUITE = '**/AcceptanceTestSuite.class'
            //     }
            //     steps {
            //         timeout(time:90, unit:'MINUTES') {
            //             echo "Testing with $env.CC_ENV"
            //             sh "docker-compose run --rm test"
            //         }
            //     }
            // }
        }
    }
}
