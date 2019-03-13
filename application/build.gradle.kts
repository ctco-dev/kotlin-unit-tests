import kotlin.collections.listOf
import org.gradle.api.tasks.testing.TestResult.ResultType.*
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties
import java.io.FileInputStream

plugins {
  kotlin("jvm") version "1.2.51"
}

// get the Kotlin version from the Kotlin plugin definition
val kotlinVersion = plugins.getPlugin(KotlinPluginWrapper::class.java).kotlinPluginVersion

allprojects {
  repositories {
    mavenCentral()
  }
}

dependencies {
  compile(kotlin("stdlib", kotlinVersion))
  compile(kotlin("stdlib-jdk8", kotlinVersion))
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