import kotlin.collections.listOf
import org.gradle.api.tasks.testing.TestResult.ResultType.*
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties
import java.io.FileInputStream

plugins {
  application
  kotlin("jvm") version "1.2.51"
}

// get the Kotlin version from the Kotlin plugin definition
val kotlinVersion = plugins.getPlugin(KotlinPluginWrapper::class.java).kotlinPluginVersion
val junitVersion = "5.4.0"

allprojects {
  repositories {
    mavenCentral()
  }
}


dependencies {
  compile(kotlin("stdlib", kotlinVersion))
  compile(kotlin("stdlib-jdk8", kotlinVersion))

  testCompile(kotlin("stdlib", kotlinVersion))
  testImplementation(group = "org.junit", name = "junit-bom", version = junitVersion)
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api")
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-params")
  testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine")

  testImplementation(group = "org.mockito", name = "mockito-junit-jupiter", version = "2.18.3")
}

application {
  group = "lv.ctco.kotlin"
  version = "1.0-SNAPSHOT"
  applicationName = "kotlin-unit-tests"
  mainClassName = "com.home.ApplicationKt"
  applicationDefaultJvmArgs = listOf("-Xmx10m")
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

task("install", type = Exec::class) {
  configurations.compile.files
  commandLine = listOf("echo", "Downloaded all dependencies")
}