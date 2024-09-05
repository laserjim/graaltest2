plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url="file:///root/maven-bundle-ce-24.2.0-dev")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.graalvm.sdk:graal-sdk:24.2.0-SNAPSHOT")
    //implementation("org.graalvm.js:js:24.2.0-SNAPSHOT")
    implementation("org.graalvm.python:python-language:24.2.0-SNAPSHOT")
    runtimeOnly("org.graalvm.polyglot:python-community:24.2.0-SNAPSHOT")
    implementation("org.graalvm.polyglot:polyglot:24.2.0-SNAPSHOT")
    //implementation(fileTree(mapOf("dir" to "/root/graalpy-24.1.0-dev-linux-amd64/modules/", "include" to listOf("*.jar"))))
}

application {
    // Define the main class entry point
    mainClass.set("org.example.MainKt")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
