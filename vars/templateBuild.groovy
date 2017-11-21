def call(cc_env = 'cc-docker', env = 'docker') {
    stage("Provision Command Central") {
        echo "Provisioning Command Central using $cc_env environment configuration"
    }        
    stage("Provision Environment") {
        echo "Provisioning environment $env"
        // post {
        //     always {
        //         junit "**/$CC_ENV/TEST-*.xml"
        //     }
        // }
    }
}
