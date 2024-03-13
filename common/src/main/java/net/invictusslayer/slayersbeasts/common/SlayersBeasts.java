package net.invictusslayer.slayersbeasts.common;

import net.invictusslayer.slayersbeasts.SBExpectPlatform;
import net.invictusslayer.slayersbeasts.common.block.*;
import net.invictusslayer.slayersbeasts.common.init.*;
import net.invictusslayer.slayersbeasts.common.item.SBDispensableItems;
import net.invictusslayer.slayersbeasts.common.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import terrablender.api.SurfaceRuleManager;

import java.util.Arrays;

public class SlayersBeasts {
	public static final String MOD_ID = "slayersbeasts";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static void init() {
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

		LOGGER.info(SBExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
	}

	public static void clientSetup() {
		SBWoodType.values().forEach(type -> {
			Sheets.SIGN_MATERIALS.put(type, Sheets.createSignMaterial(type));
			Sheets.HANGING_SIGN_MATERIALS.put(type, Sheets.createHangingSignMaterial(type));
		});
	}

	public static void commonSetup() {
		LOGGER.info("Extended MushroomCow$Type values: {}", Arrays.toString(MushroomCow.MushroomType.values()));
		LOGGER.info("Extended Boat$Type values: {}", Arrays.toString(Boat.Type.values()));

		SBFlammableBlocks.register();
		SBStrippableBlocks.register();
		SBPottedBlocks.register();
		SBDispensableItems.register();

		((IExtendedMushroomBlock) SBBlocks.BLACK_MUSHROOM.get()).setMightyMushroom(SBConfiguredFeatures.MIGHTY_BLACK_MUSHROOM);
		((IExtendedMushroomBlock) Blocks.BROWN_MUSHROOM).setMightyMushroom(SBConfiguredFeatures.MIGHTY_BROWN_MUSHROOM);
		((IExtendedMushroomBlock) Blocks.RED_MUSHROOM).setMightyMushroom(SBConfiguredFeatures.MIGHTY_RED_MUSHROOM);
		((IExtendedMushroomBlock) SBBlocks.WHITE_MUSHROOM.get()).setMightyMushroom(SBConfiguredFeatures.MIGHTY_WHITE_MUSHROOM);

		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SlayersBeasts.MOD_ID, SBSurfaceRuleData.overworldRules());
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, SlayersBeasts.MOD_ID, SBSurfaceRuleData.netherRules());
//		SurfaceRuleManager.addSurfaceRules(EBRuleCategory.END, SlayersBeasts.MOD_ID, SBSurfaceRuleData.endRules());
	}
}
