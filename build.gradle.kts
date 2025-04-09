plugins {
    id("dev.isxander.modstitch.base") version "0.5.12"
}

fun prop(name: String, consumer: (prop: String) -> Unit) {
    (findProperty(name) as? String?)?.let(consumer)
}

val mcVersion = property("deps.minecraft") as String

val isFabric = modstitch.isLoom
val isNeoforge = modstitch.isModDevGradleRegular
val isForge = modstitch.isModDevGradleLegacy
val loader = when {
    isFabric -> "fabric"
    isNeoforge -> "neoforge"
    isForge -> "forge"
    else -> throw IllegalStateException("Unsupported loader")
}

modstitch {
    minecraftVersion = mcVersion

    javaTarget = when (mcVersion) {
        "1.20.1" -> 17
        "1.21.4" -> 21
        else -> throw IllegalArgumentException("Please store the java version for ${property("deps.minecraft")} in common.txt!")
    }

    parchment {
        prop("deps.parchment") { mappingsVersion = it }
        prop("deps.minecraft") { minecraftVersion = it }
    }

    metadata {
        modId = property("mod.id") as String
        modName = property("mod.name") as String
        modVersion = "${property("mod.version")}-$mcVersion-$loader"
        modGroup = property("mod.group") as String
        modAuthor = property("mod.authors") as String
        modLicense = property("mod.license") as String
        modDescription = property("mod.description") as String

        fun <K, V> MapProperty<K, V>.populate(block: MapProperty<K, V>.() -> Unit) {
            block()
        }

        replacementProperties.populate {
            put("homepage_url", property("mod.homepage_url") as String)
            put("source_url", property("mod.source_url") as String)
            put("issue_url", property("mod.issue_url") as String)
            put("pack_format", when (mcVersion) {
                "1.20.1" -> 15
                "1.21.4" -> 46
                else -> throw IllegalArgumentException("Please store the resource pack version for ${property("deps.minecraft")} in build.gradle.kts!")
            }.toString())
            prop("meta.minecraft") { put("mc_range", it) }
            prop("meta.fabric") { put("fabric_range", it) }
            prop("meta.neoforge") { put("neo_range", it) }
            prop("meta.forge") { put("forge_range", it) }
            prop("meta.terrablender") { put("tb_range", it) }
        }
    }

    loom {
        fabricLoaderVersion = property("deps.fabric_loader") as String

        configureLoom {
            accessWidenerPath = rootProject.file("src/main/resources/slayersbeasts.accesswidener")

//            runs.all {
//                runDir = "../../run"
//                ideConfigGenerated(true)
//            }
        }
    }

    moddevgradle {
        enable {
            prop("deps.forge_version") { forgeVersion = it }
            prop("deps.neoforge") { neoForgeVersion = it }
            prop("deps.mcp_version") { mcpVersion = it }
        }

        defaultRuns()

        configureNeoforge {
            validateAccessTransformers = true
            accessTransformers { file("src/main/resources/META-INF/accesstransformer.cfg") }

            runs.all {
                disableIdeRun()
            }
        }
    }

//    mixin {
//        addMixinsToModManifest = false
//
//        configs.register("slayersbeasts")
//        if (isFabric) configs.register("slayersbeasts-fabric")
//        if (isNeoforge) configs.register("slayersbeasts-neoforge")
//        if (isForge) configs.register("slayersbeasts-forge")
//    }
}

stonecutter {
    consts(
        "fabric" to isFabric,
        "neoforge" to isNeoforge,
        "forge" to isForge
    )
    swaps["client_env"] =
        if (isFabric) "import net.fabricmc.api.EnvType;\nimport net.fabricmc.api.Environment;\n\n@Environment(EnvType.CLIENT)"
        else "import net.neoforged.api.distmarker.Dist;\nimport net.neoforged.api.distmarker.OnlyIn;\n\n@OnlyIn(Dist.CLIENT)"
}

// If you want to create proxy configurations for more source sets, such as client source sets,
// use the modstitch.createProxyConfigurations(sourceSets["client"]) function.
dependencies {
    modstitch.loom {
        modstitchModImplementation("net.fabricmc.fabric-api:fabric-api:${property("deps.fabric_api")}")
        modstitchModImplementation("com.terraformersmc:modmenu:${property("deps.modmenu")}")
    }

    modstitchModImplementation("me.shedaniel.cloth:cloth-config-$loader:${property("deps.cloth_config")}")
    modstitchModImplementation("com.github.glitchfiend:TerraBlender-$loader:$mcVersion-${property("deps.terrablender")}")
}

sourceSets {
    main {
        resources {
//            srcDir(rootProject.file("src/main/generated"))
//            srcDir(rootProject.file("src/main/resources"))
//            srcDir(rootProject.file("src/main/templates"))
        }
    }
}