plugins {
    java
    id("org.sonarqube") version "3.0"
    id("org.jetbrains.intellij") version "0.4.21"
}

group = "ir.msdehghan"
version = "0.11"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

intellij {
    version = "2020.1.4"
    setPlugins("yaml")
    updateSinceUntilBuild = false
}

sonarqube {
    properties {
        properties["sonar.projectKey"] = "MSDehghan_AnsiblePlugin"
        properties["sonar.organization"] = "msdehghan-github"
        properties["sonar.host.url"] = "https://sonarcloud.io"
    }
}

tasks.buildSearchableOptions {
    enabled = false
}