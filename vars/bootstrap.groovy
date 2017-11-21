def call(node = '', bootstrap = 'default', branch = 'release/101oct2017') {
    // // evaluate the body block, and collect configuration into the object
    // def config = [:]
    // body.resolveStrategy = Closure.DELEGATE_FIRST
    // body.delegate = config
    // body()

    // now build, based on the configuration provided
    node(node) {
        git url: "http://irepo.eur.ad.sag/scm/devops/command-central.git", branch: branch
        sagantcc '-version'
        //sagccant "agent -Daccept.license=true -Dbootstrap=${config.bootstrap}"
        // sagccant "up"
        // sagccant "test"
        // sagccant "test -Dsuite=ga"
        // junit 'build/tests/**/TEST-*.xml'
        // mail to: "...", subject: "${config.name} plugin build", body: "..."
    }
}
