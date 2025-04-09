package net.invictusslayer.slayersbeasts;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.invictusslayer.slayersbeasts.block.IExtendedMushroomBlock;
import net.invictusslayer.slayersbeasts.block.SBFlammableBlocks;
import net.invictusslayer.slayersbeasts.block.SBStrippableBlocks;
import net.invictusslayer.slayersbeasts.block.SBWoodType;
import net.invictusslayer.slayersbeasts.config.SBConfig;
import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.init.*;
import net.invictusslayer.slayersbeasts.item.SBDispensableItems;
import net.invictusslayer.slayersbeasts.world.biome.SBBiomeModifications;
import net.invictusslayer.slayersbeasts.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.world.biome.region.SBNetherRegion;
import net.invictusslayer.slayersbeasts.world.biome.region.SBOverworldRegion;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
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
		loadConfig();

		SBBlocks.init();
		SBItems.init();
		SBEntities.init();
		SBCreativeModeTabs.init();
		SBBlockEntities.init();
		SBVillagerType.init();
		SBEffects.init();
		SBPotions.init();
		SBSounds.init();
		SBDataComponents.init();
		SBPois.init();
		SBFeatures.init();
		SBTreeDecorators.init();
		SBFoliagePlacers.init();
		SBTrunkPlacers.init();
		SBStructurePieces.init();
		SBStructureTypes.init();
		SBTags.Blocks.init();
		SBTags.Items.init();
		SBTags.Biomes.init();
		SBTags.EntityTypes.init();
		SBTags.PoiTypes.init();

//		LOGGER.info(SBPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
	}

	private static void loadConfig() {
		if (CONFIG == null) {
			AutoConfig.register(SBConfig.class, Toml4jConfigSerializer::new);
			CONFIG = AutoConfig.getConfigHolder(SBConfig.class).getConfig();
		}
	}

	public static void commonSetup() {
		LOGGER.info("Extended MushroomCow$Type values: {}", Arrays.toString(MushroomCow.Variant.values()));
		LOGGER.info("Extended Fox$Type values: {}", Arrays.toString(Fox.Variant.values()));

		SBFlammableBlocks.register();
		SBStrippableBlocks.register();
		SBDispensableItems.register();
		SBBiomeModifications.registerSpawns();
		SBEntities.registerSpawns();
		SBVillagerType.setupBiomes();

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
		loadConfig();
		if (CONFIG.worldgen.overworld_biomes) Regions.register(new SBOverworldRegion(CONFIG.worldgen.overworld_region_weight));
		if (CONFIG.worldgen.nether_biomes) Regions.register(new SBNetherRegion(CONFIG.worldgen.nether_region_weight));
//		if (CONFIG.worldgen.end_biomes) Regions.register(new SBEndRegion(CONFIG.worldgen.end_region_weight));
	}
}
