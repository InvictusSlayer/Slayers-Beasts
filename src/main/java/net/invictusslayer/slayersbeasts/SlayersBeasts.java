package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.entity.SBBlockEntities;
import net.invictusslayer.slayersbeasts.datagen.tags.SBPois;
import net.invictusslayer.slayersbeasts.effect.SBEffects;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.item.SBPotions;
import net.invictusslayer.slayersbeasts.misc.SBCreativeModeTab;
import net.invictusslayer.slayersbeasts.misc.SBSounds;
import net.invictusslayer.slayersbeasts.world.biome.SBOverworldRegion;
import net.invictusslayer.slayersbeasts.world.biome.SBSurfaceRuleData;
import net.invictusslayer.slayersbeasts.world.biome.SBUndergroundRegion;
import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.world.feature.SBFeatures;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.SBTreeDecorators;
import net.invictusslayer.slayersbeasts.world.feature.tree.foliageplacer.SBFoliagePlacers;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunkplacer.SBTrunkPlacers;
import net.invictusslayer.slayersbeasts.world.structure.pieces.SBStructurePieces;
import net.invictusslayer.slayersbeasts.world.structure.structures.SBStructureType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(SlayersBeasts.MOD_ID)
public class SlayersBeasts {
    public static final String MOD_ID = "slayersbeasts";

    public SlayersBeasts() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SBCreativeModeTab.CREATIVE_MODE_TABS.register(eventBus);
        SBItems.ITEMS.register(eventBus);
        SBBlocks.BLOCKS.register(eventBus);
        SBBlockEntities.BLOCK_ENTITIES.register(eventBus);
        SBEntities.ENTITIES.register(eventBus);
//        SBVillagerType.register(eventBus);
        SBEffects.EFFECTS.register(eventBus);
        SBPotions.POTIONS.register(eventBus);
        SBSounds.SOUNDS.register(eventBus);
        SBTreeDecorators.TREE_DECORATORS.register(eventBus);
        SBFoliagePlacers.FOLIAGE_PLACERS.register(eventBus);
        SBTrunkPlacers.TRUNK_PLACERS.register(eventBus);
        SBFeatures.FEATURES.register(eventBus);
        SBStructurePieces.STRUCTURE_PIECES.register(eventBus);
        SBStructureType.STRUCTURES.register(eventBus);
        SBPois.POIS.register(eventBus);
        SBDimensions.register();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
//            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
//            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));

            Regions.register(new SBOverworldRegion(2));
            Regions.register(new SBUndergroundRegion(1));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SBSurfaceRuleData.overworldRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, SBSurfaceRuleData.netherRules());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
}
