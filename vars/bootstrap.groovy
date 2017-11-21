def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node(config.node) {
        git url: "http://irepo.eur.ad.sag/scm/devops/command-central.git", branch: config.branch
        sagantcc '-version'
        //sagccant "agent -Daccept.license=true -Dbootstrap=${config.bootstrap}"
        // sagccant "up"
        // sagccant "test"
        // sagccant "test -Dsuite=ga"
        // junit 'build/tests/**/TEST-*.xml'
        // mail to: "...", subject: "${config.name} plugin build", body: "..."
    }
}
