import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // picocli
    implementation (files("libs/picocli-4.6.1.jar"))
    // json
    implementation ("com.google.code.gson:gson:2.9.0")

    // test
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    implementation("org.assertj:assertj-core:3.23.1")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}