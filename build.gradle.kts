plugins {
    id("java")
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

// LabyMod API будет доступно при запуске в клиенте
dependencies {
    // Минимальные зависимости для компиляции
    implementation("com.google.code.gson:gson:2.10.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

jar {
    manifest {
        attributes(
            "LabyMod-Module" to "com.axmed555.labyvisuals.LabyVisualsAddon",
            "Version" to version
        )
    }
    
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
