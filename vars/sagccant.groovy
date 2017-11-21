def call(String command) {
    if (isUnix()) {
        sh "ant $command"
    } else {
        bat "ant $command"
    }   
}
