import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.30"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    compile(project(":application"))

    testImplementation(group = "io.kotlintest", name = "kotlintest-runner-junit5", version = "3.3.0")
    testImplementation(group = "org.mockito", name = "mockito-junit-jupiter", version = "2.18.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.javaParameters = true
    kotlinOptions.jvmTarget = "1.8"
}