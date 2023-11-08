plugins {
    kotlin("jvm") version "1.9.20"
    application
}

group = "io.github.ackuq"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}
