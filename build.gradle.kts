import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val http4k_version = "4.0.0.0"

plugins {
    kotlin("jvm") version "1.4.10"
    application
    java
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}

dependencies {
    implementation(platform("org.http4k:http4k-bom:$http4k_version"))
    implementation("org.http4k:http4k-format-jackson-xml:$http4k_version")
}
