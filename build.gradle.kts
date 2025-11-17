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

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
}

jar {
    manifest {
        attributes(
            "LabyMod-Module" to "com.axmed555.labyvisuals.LabyVisualsAddon",
            "Version" to version
        )
    }
}
