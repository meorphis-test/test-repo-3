plugins {
    id("meorphis-test-6.kotlin")
    id("meorphis-test-6.publish")
}

dependencies {
    api(project(":meorphis-test-6-java-client-okhttp"))
}
