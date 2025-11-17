plugins {
    id("java")
    id("net.labymod.addon") version "0.2.9"
}

group = "com.axmed555"
version = "1.0.0"

labymod {
    addonInfo {
        namespace = "labyvisuals"
        displayName = "LabyVisuals"
        author = "axmed555"
        description = "Visual effects addon for LabyMod 4"
        minecraftVersion = "1.20.1"
    }

    productionRelease()
}

repositories {
    mavenCentral()
}

dependencies {
    // Добавь здесь зависимости если нужны
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}