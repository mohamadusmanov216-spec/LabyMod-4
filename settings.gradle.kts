pluginManagement {
    repositories {
        maven("https://repo.labymod.net/releases/") {
            name = "LabyMod"
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "labyvisuals-addon"
