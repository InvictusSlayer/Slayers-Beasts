pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.fabricmc.net/")
        maven("https://maven.neoforged.net/releases/")

        // Stonecutter
        maven("https://maven.kikugie.dev/releases")
        maven("https://maven.kikugie.dev/snapshots")

        // Modstitch
        maven("https://maven.isxander.dev/releases/")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
    id("dev.kikugie.stonecutter") version "0.6+"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle.kts"

    create(rootProject) {
        fun mc(mcVersion: String, name: String = mcVersion, loaders: List<String>) =
            loaders.forEach { vers("$name-$it", mcVersion) }

        mc("1.21.4", loaders = listOf("fabric", "neoforge"))

        vcsVersion = "1.21.4-fabric"
    }
}

rootProject.name = "Slayer's Beasts"