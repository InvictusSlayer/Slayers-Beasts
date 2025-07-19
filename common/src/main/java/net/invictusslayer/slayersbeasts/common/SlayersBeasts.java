package net.invictusslayer.slayersbeasts.common;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.invictusslayer.slayersbeasts.common.block.IExtendedMushroomBlock;
import net.invictusslayer.slayersbeasts.common.block.SBFlammableBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBStrippableBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBWoodType;
import net.invictusslayer.slayersbeasts.common.config.SBConfig;
import net.invictusslayer.slayersbeasts.common.init.*;
import net.invictusslayer.slayersbeasts.common.item.SBDispensableItems;
import net.invictusslayer.slayersbeasts.common.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBNetherRegion;
import net.invictusslayer.slayersbeasts.common.world.biome.region.SBOverworldRegion;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.Arrays;
import java.util.ServiceLoader;

public class SlayersBeasts {
	public static final String MOD_ID = "slayersbeasts";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static SBConfig CONFIG = null;
	public static IPlatformHandler PLATFORM = null;

	public static void init() {
		loadPlatform(IPlatformHandler.class);
		loadConfig();

		SBItems.register();
		SBBlocks.register();
		SBEntities.register();
		SBCreativeModeTabs.register();
		SBVillagerType.register();
		SBBlockEntities.register();
		SBEffects.register();
		SBPotions.register();
		SBSounds.register();
		SBDataComponents.register();
		SBPois.register();
		SBFeatures.register();
		SBTreeDecorators.register();
		SBFoliagePlacers.register();
		SBTrunkPlacers.register();
		SBStructurePieces.register();
		SBStructureTypes.register();

//		SBBiomeModifications.registerFeatures();

		LOGGER.info(PLATFORM.configPath().toAbsolutePath().normalize().toString());
	}

	public static void loadConfig() {
		if (CONFIG != null) return;
		AutoConfig.register(SBConfig.class, Toml4jConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(SBConfig.class).getConfig();
	}

	public static <T extends IPlatformHandler> void loadPlatform(Class<T> clazz) {
		if (PLATFORM != null) return;
		final T loadedService = ServiceLoader.load(clazz).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
		LOGGER.debug("Loaded {} for service {}", loadedService, clazz);
		PLATFORM = loadedService;
	}

	public static void commonSetup() {
		LOGGER.info("Extended MushroomCow$Type values: {}", Arrays.toString(MushroomCow.Variant.values()));
		LOGGER.info("Extended Fox$Type values: {}", Arrays.toString(Fox.Variant.values()));

		SBFlammableBlocks.register();
		SBStrippableBlocks.register();
		SBDispensableItems.register();
//		SBBiomeModifications.registerSpawns();
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
