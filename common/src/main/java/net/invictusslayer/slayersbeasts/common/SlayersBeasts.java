package net.invictusslayer.slayersbeasts.common;

import net.invictusslayer.slayersbeasts.SBExpectPlatform;
import net.invictusslayer.slayersbeasts.common.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
