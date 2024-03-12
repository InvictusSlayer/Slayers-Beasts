package net.invictusslayer.slayersbeasts.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.IExtendedMushroomBlock;
import net.invictusslayer.slayersbeasts.common.block.SBFlammableBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBPottedBlocks;
import net.invictusslayer.slayersbeasts.common.block.SBStrippableBlocks;
import net.invictusslayer.slayersbeasts.common.entity.*;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBEntities;
import net.invictusslayer.slayersbeasts.common.item.SBDispensableItems;
import net.invictusslayer.slayersbeasts.common.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import terrablender.api.SurfaceRuleManager;

import java.util.Arrays;

public class SBFabric implements ModInitializer {
	public void onInitialize() {
		SlayersBeasts.init();

		SlayersBeasts.LOGGER.info("Extended MushroomCow$Type values: " + Arrays.toString(MushroomCow.MushroomType.values()));
		SlayersBeasts.LOGGER.info("Extended Boat$Type values: " + Arrays.toString(Boat.Type.values()));

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

		SpawnPlacements.register(SBEntities.MANTIS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Mantis::canSpawn);
		SpawnPlacements.register(SBEntities.ANT_WORKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntWorker::canSpawn);
		SpawnPlacements.register(SBEntities.ANT_SOLDIER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntSoldier::canSpawn);
		SpawnPlacements.register(SBEntities.ANT_QUEEN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, AntQueen::canSpawn);
		SpawnPlacements.register(SBEntities.DAMSELFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Damselfly::canSpawn);
		SpawnPlacements.register(SBEntities.ENT_OAK.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn);
		SpawnPlacements.register(SBEntities.ENT_BIRCH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntMedium::canSpawn);
		SpawnPlacements.register(SBEntities.SPORETRAP.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Sporetrap::canSpawn);

		FabricDefaultAttributeRegistry.register(SBEntities.MANTIS.get(), Mantis.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.ANT_WORKER.get(), AntWorker.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.ANT_SOLDIER.get(), AntSoldier.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.ANT_QUEEN.get(), AntQueen.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.WITHER_SPIDER.get(), WitherSpider.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.TYRACHNID.get(), Tyrachnid.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.DAMSELFLY.get(), Damselfly.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.ENT_OAK.get(), EntMedium.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.ENT_BIRCH.get(), EntMedium.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.WUDU_OAK.get(), Wudu.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.SPORETRAP.get(), Sporetrap.createAttributes());
		FabricDefaultAttributeRegistry.register(SBEntities.IRK.get(), Irk.createAttributes());
	}
}
