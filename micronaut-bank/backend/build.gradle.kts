plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("io.micronaut.application") version "3.2.1"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.10"
    jacoco
}

version = "0.1"
group = "br.com.cezarcruz"

val kotlinVersion = project.properties["kotlinVersion"]
val coroutineVersion = project.properties["coroutineVersion"]
val fluentValidatorVersion = "1.10.0"
val archunitVersion = "0.22.0"

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("br.com.cezarcruz.*")
    }
}

jacoco {
    toolVersion = "0.8.7"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(true)
    }
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}

allOpen {
    annotations("jakarta.inject.Singleton")
}

dependencies {

    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.openapi:micronaut-openapi")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")

    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")

    implementation("io.micronaut:micronaut-tracing")
    implementation("io.micronaut.tracing:micronaut-tracing-jaeger")

    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("javax.annotation:javax.annotation-api")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutineVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")

    implementation("io.micronaut:micronaut-validation")
    implementation("com.github.mvallim:java-fluent-validator:${fluentValidatorVersion}")

    testImplementation("com.tngtech.archunit:archunit:${archunitVersion}")

    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}

application {
    mainClass.set("br.com.cezarcruz.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {

    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }

}
