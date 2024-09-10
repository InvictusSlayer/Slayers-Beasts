package net.invictusslayer.slayersbeasts.common.world.structure;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;

import java.util.List;

public class SBStructureSets {
	public static final ResourceKey<StructureSet> CRYPT_PORTALS = createKey("crypt_portals");
	public static final ResourceKey<StructureSet> LODGES = createKey("lodges");

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

		register(context, CRYPT_PORTALS, structures.getOrThrow(SBStructures.CRYPT_PORTAL), new RandomSpreadStructurePlacement(12, 6, RandomSpreadType.LINEAR, 987654002));
		register(context, LODGES, List.of(StructureSet.entry(structures.getOrThrow(SBStructures.REDWOOD_LODGE))), new RandomSpreadStructurePlacement(24, 10, RandomSpreadType.LINEAR, 987654003));
	}

	private static ResourceKey<StructureSet> createKey(String name) {
		return ResourceKey.create(Registries.STRUCTURE_SET, new ResourceLocation(SlayersBeasts.MOD_ID, name));
	}

	private static void register(BootstrapContext<StructureSet> context, ResourceKey<StructureSet> key, List<StructureSet.StructureSelectionEntry> config, StructurePlacement placement) {
		context.register(key, new StructureSet(config, placement));
	}

	private static void register(BootstrapContext<StructureSet> context, ResourceKey<StructureSet> key, Holder<Structure> config, StructurePlacement placement) {
		context.register(key, new StructureSet(config, placement));
	}
}
