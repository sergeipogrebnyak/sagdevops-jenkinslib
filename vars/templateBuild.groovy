def call(cc_env = 'cc-docker', env = 'docker') {
    stage("Provision Command Central") {
        environment {
            CC_ENV = cc_env
        }
        echo "Provisioning Command Central using $CC_ENV environment configuration"
    }        
    stage("Provision Environment") {
        environment {
            CC_ENV = env
            TEST_SUITE = '**/AcceptanceTestSuite.class'
        }
        echo "Provisioning environment $CC_ENV"
        // post {
        //     always {
        //         junit "**/$CC_ENV/TEST-*.xml"
        //     }
        // }
    }
}
