import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.kotlin"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    //thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
//  runtimeOnly("com.h2database:h2")
    implementation("com.mysql:mysql-connector-j:8.0.33")
    // https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

}
sourceSets {
    val profile = try {
        if (project.hasProperty("profile")) project.property("profile").toString()
        else "dev"
    } catch (e: Exception) {"dev"}
    main {
        java.srcDirs("src/main/java")
        resources {
            srcDirs(listOf("src/main/resources", "src/main/resources-$profile"))
        }
    }
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
tasks {
    processResources {
        duplicatesStrategy = org.gradle.api.file.DuplicatesStrategy.INCLUDE
    }
}
tasks.withType<Test> {
    useJUnitPlatform()
}
