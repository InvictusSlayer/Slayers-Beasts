package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.entity.SBBlockEntities;
import net.invictusslayer.slayersbeasts.datagen.tags.SBPois;
import net.invictusslayer.slayersbeasts.effect.SBEffects;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.misc.SBBrewingRecipe;
import net.invictusslayer.slayersbeasts.misc.SBCreativeModeTab;
import net.invictusslayer.slayersbeasts.misc.SBPotions;
import net.invictusslayer.slayersbeasts.misc.SBSounds;
import net.invictusslayer.slayersbeasts.world.biome.*;
import net.invictusslayer.slayersbeasts.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.world.feature.SBFeatures;
import net.invictusslayer.slayersbeasts.world.feature.treedecorator.SBTreeDecorators;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.SBFoliagePlacers;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.SBTrunkPlacers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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

        SBCreativeModeTab.register(eventBus);
        SBItems.register(eventBus);
        SBBlocks.register(eventBus);
        SBBlockEntities.register(eventBus);
        SBEntities.register(eventBus);
//        SBVillagerType.register(eventBus);
        SBEffects.register(eventBus);
        SBPotions.register(eventBus);
        SBSounds.register(eventBus);
        SBTreeDecorators.register(eventBus);
        SBFoliagePlacers.register(eventBus);
        SBTrunkPlacers.register(eventBus);
        SBFeatures.register(eventBus);
        SBPois.register(eventBus);
        SBDimensions.register();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.SLOWNESS, SBItems.INSECT_EYE.get(), SBPotions.PARALYSIS_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new SBBrewingRecipe(Potions.POISON, SBItems.WITHERBONE.get(), SBPotions.WITHER_POTION.get()));

            Regions.register(new SBOverworldRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SBSurfaceRuleData.overworldRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, SBSurfaceRuleData.netherRules());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
}
