def call(command) {
    if (isUnix()) {
        sh "./gradlew $command"
    } else {
        bat "gradlew $command"
    }
}