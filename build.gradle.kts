plugins {
    id("java")
    id("application")
}

group = "com.axmed555"
version = "1.0.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

// ПРАВИЛЬНЫЙ синтаксис для jar задачи
tasks.jar {
    manifest {
        attributes(
            "LabyMod-Module" to "com.axmed555.labyvisuals.LabyVisualsAddon",
            "Version" to version,
            "Author" to "axmed555"
        )
    }
    
    archiveBaseName.set("labyvisuals-addon")
    archiveVersion.set("1.0.0")
    
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
