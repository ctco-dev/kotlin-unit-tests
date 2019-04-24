
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.3.30"
}

val junitVersion = "5.4.0"

allprojects {
  repositories {
    mavenCentral()
  }
}


dependencies {
  compile(project(":application"))

  testImplementation(group = "org.junit", name = "junit-bom", version = junitVersion)
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api")
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params")
  testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine")

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