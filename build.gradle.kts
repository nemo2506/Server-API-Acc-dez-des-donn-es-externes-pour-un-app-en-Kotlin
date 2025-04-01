plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("io.ktor.plugin") version "2.3.3"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

application {
    mainClass.set("com.aura.MainKt")
}

group = "com.aura"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")

    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0-RC")

    implementation("io.ktor:ktor-server-cors:2.3.3")
    implementation("io.ktor:ktor-server-swagger:2.3.3")
    implementation("org.slf4j:slf4j-simple:1.7.36")

    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveBaseName.set("ktor-server")
    archiveClassifier.set("")
    archiveVersion.set("1.0")

    manifest {
        attributes["Main-Class"] = "com.aura.MainKt"
    }
}

