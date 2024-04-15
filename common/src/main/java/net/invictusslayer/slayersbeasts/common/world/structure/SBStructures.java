package net.invictusslayer.slayersbeasts.common.world.structure;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomes;
import net.invictusslayer.slayersbeasts.common.world.structure.pools.CryptPools;
import net.invictusslayer.slayersbeasts.common.world.structure.pools.RedwoodLodgePools;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptPortalStructure;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class SBStructures {
	public static final ResourceKey<Structure> CRYPT = createKey("crypt");
	public static final ResourceKey<Structure> CRYPT_PORTAL = createKey("crypt_portal");
	public static final ResourceKey<Structure> REDWOOD_LODGE = createKey("redwood_lodge");

	public static void bootstrap(BootstapContext<Structure> context) {
		HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

		context.register(CRYPT, new CryptStructure(structure(HolderSet.direct(biomes.getOrThrow(SBBiomes.THE_CRYPT)), Map.of(), GenerationStep.Decoration.UNDERGROUND_STRUCTURES, TerrainAdjustment.NONE), pools.getOrThrow(CryptPools.START), ConstantHeight.of(VerticalAnchor.absolute(60))));
		context.register(CRYPT_PORTAL, new CryptPortalStructure(structure(biomes.getOrThrow(SBTags.Biomes.HAS_CRYPT_PORTAL), TerrainAdjustment.BEARD_THIN)));
		context.register(REDWOOD_LODGE, new JigsawStructure(structure(biomes.getOrThrow(SBTags.Biomes.HAS_REDWOOD_LODGE), TerrainAdjustment.BEARD_THIN), pools.getOrThrow(RedwoodLodgePools.START), 3, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
	}

	private static Structure.StructureSettings structure(HolderSet<Biome> biomes, Map<MobCategory, StructureSpawnOverride> spawns, GenerationStep.Decoration step, TerrainAdjustment terrain) {
		return new Structure.StructureSettings(biomes, spawns, step, terrain);
	}

	private static Structure.StructureSettings structure(HolderSet<Biome> biomes, TerrainAdjustment terrain) {
		return structure(biomes, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, terrain);
	}

	private static ResourceKey<Structure> createKey(String name) {
		return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
	}
}
