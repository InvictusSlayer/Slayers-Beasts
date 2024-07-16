package net.invictusslayer.slayersbeasts.common;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.invictusslayer.slayersbeasts.SBPlatform;
import net.invictusslayer.slayersbeasts.common.block.IExtendedMushroomBlock;
import net.invictusslayer.slayersbeasts.common.block.SBFlammableBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBStrippableBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBWoodType;
import net.invictusslayer.slayersbeasts.common.config.SBConfig;
import net.invictusslayer.slayersbeasts.common.init.*;
import net.invictusslayer.slayersbeasts.common.item.SBDispensableItems;
import net.invictusslayer.slayersbeasts.common.world.biome.SBBiomeModifications;
import net.invictusslayer.slayersbeasts.common.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBNetherRegion;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBOverworldRegion;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.Arrays;

public class SlayersBeasts {
	public static final String MOD_ID = "slayersbeasts";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static SBConfig CONFIG;

	public static void init() {
		AutoConfig.register(SBConfig.class, Toml4jConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(SBConfig.class).getConfig();

		SBCreativeModeTabs.CREATIVE_TABS.register();
		SBBlocks.BLOCKS.register();
		SBItems.ITEMS.register();
		SBBlockEntities.BLOCK_ENTITIES.register();
		SBEntities.ENTITIES.register();
		SBVillagerType.VILLAGER_TYPES.register();
		SBEffects.EFFECTS.register();
		SBPotions.POTIONS.register();
		SBSounds.SOUNDS.register();
		SBPois.POIS.register();
		SBFeatures.FEATURES.register();
		SBTreeDecorators.TREE_DECORATORS.register();
		SBFoliagePlacers.FOLIAGE_PLACERS.register();
		SBTrunkPlacers.TRUNK_PLACERS.register();
		SBStructurePieces.STRUCTURE_PIECES.register();
		SBStructureTypes.STRUCTURE_TYPES.register();

		SBVillagerType.biomeSetup();
//		SBBiomeModifications.registerFeatures();
		SBEntities.registerAttributes();

		LOGGER.info(SBPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
	}

	public static void commonSetup() {
		LOGGER.info("Extended MushroomCow$Type values: {}", Arrays.toString(MushroomCow.MushroomType.values()));
		LOGGER.info("Extended Boat$Type values: {}", Arrays.toString(Boat.Type.values()));

		SBFlammableBlocks.register();
		SBStrippableBlocks.register();
		SBDispensableItems.register();
		SBBiomeModifications.registerSpawns();
		SBEntities.registerSpawns();

		((IExtendedMushroomBlock) SBBlocks.BLACK_MUSHROOM.get()).setMightyMushroom(SBConfiguredFeatures.MIGHTY_BLACK_MUSHROOM);
		((IExtendedMushroomBlock) Blocks.BROWN_MUSHROOM).setMightyMushroom(SBConfiguredFeatures.MIGHTY_BROWN_MUSHROOM);
		((IExtendedMushroomBlock) Blocks.RED_MUSHROOM).setMightyMushroom(SBConfiguredFeatures.MIGHTY_RED_MUSHROOM);
		((IExtendedMushroomBlock) SBBlocks.WHITE_MUSHROOM.get()).setMightyMushroom(SBConfiguredFeatures.MIGHTY_WHITE_MUSHROOM);

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SlayersBeasts.MOD_ID, SBSurfaceRuleData.overworldRules());
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, SlayersBeasts.MOD_ID, SBSurfaceRuleData.netherRules());
//		SurfaceRuleManager.addSurfaceRules(EBRuleCategory.END, SlayersBeasts.MOD_ID, SBSurfaceRuleData.endRules());
	}

	public static void clientSetup() {
		SBWoodType.values().forEach(type -> {
			Sheets.SIGN_MATERIALS.put(type, Sheets.createSignMaterial(type));
			Sheets.HANGING_SIGN_MATERIALS.put(type, Sheets.createHangingSignMaterial(type));
		});
	}

	public static void registerRegions() {
		if (CONFIG.worldgen.overworld_biomes) Regions.register(new SBOverworldRegion(CONFIG.worldgen.overworld_region_weight));
		if (CONFIG.worldgen.nether_biomes) Regions.register(new SBNetherRegion(CONFIG.worldgen.nether_region_weight));
//		if (CONFIG.worldgen.end_biomes) Regions.register(new SBEndRegion(CONFIG.worldgen.end_region_weight));
	}
}
