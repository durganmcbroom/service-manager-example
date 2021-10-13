plugins {
    kotlin("jvm") version "1.5.30"
    kotlin("kapt") version "1.5.30"
}

group = "net.yakclient"
version = "1.0-SNAPSHOT"

tasks.wrapper {
    gradleVersion = "7.2"
}
//kapt {
//    keepJavacAnnotationProcessors = true
//}
allprojects {
    apply(plugin="org.jetbrains.kotlin.jvm")
    apply(plugin="kotlin-kapt")

    kotlin {
        explicitApi()
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")

        implementation("io.github.emilyy-dev:annotated-service-provider:1.0.1")
        kapt("io.github.emilyy-dev:annotated-service-provider:1.0.1")
    }

    tasks.compileKotlin {
        destinationDirectory.set(tasks.compileJava.get().destinationDirectory.asFile.get())
        kotlinOptions.jvmTarget = "11"
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.compileTestKotlin {
        destinationDirectory.set(tasks.compileTestJava.get().destinationDirectory.asFile.get())
        kotlinOptions.jvmTarget = "11"

    }
}