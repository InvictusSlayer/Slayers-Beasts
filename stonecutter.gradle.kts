plugins {
    id("dev.kikugie.stonecutter")
}
stonecutter active "1.21.4-fabric"

stonecutter registerChiseled tasks.register("chiseledBuild", stonecutter.chiseled) {
    group = "project"
    ofTask("build")
}

allprojects {
    repositories {
        maven("https://maven.terraformersmc.com/releases/")
        maven("https://maven.parchmentmc.org/")
        maven("https://maven.shedaniel.me/")
        maven("https://maven.minecraftforge.net/")
    }
}