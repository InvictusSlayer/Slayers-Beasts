package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.block.entity.ModBlockEntities;
import net.invictusslayer.slayersbeasts.entity.ModEntities;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.invictusslayer.slayersbeasts.misc.ModBrewingRecipe;
import net.invictusslayer.slayersbeasts.misc.ModCreativeModeTab;
import net.invictusslayer.slayersbeasts.effect.ModEffects;
import net.invictusslayer.slayersbeasts.misc.ModPotions;
import net.invictusslayer.slayersbeasts.datagen.tags.ModPois;
import net.invictusslayer.slayersbeasts.misc.ModSounds;
import net.invictusslayer.slayersbeasts.world.biome.ModBiomes;
import net.invictusslayer.slayersbeasts.world.dimension.ModDimensions;
import net.invictusslayer.slayersbeasts.world.feature.ModFeatures;
import net.invictusslayer.slayersbeasts.world.feature.foliageplacer.ModFoliagePlacers;
import net.invictusslayer.slayersbeasts.world.feature.trunkplacer.ModTrunkPlacers;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SlayersBeasts {
    public static final String MOD_ID = "slayersbeasts";

    public SlayersBeasts() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModEntities.register(eventBus);
        ModEffects.register(eventBus);
        ModPotions.register(eventBus);
        ModSounds.register(eventBus);
        ModFoliagePlacers.register(eventBus);
        ModTrunkPlacers.register(eventBus);
        ModFeatures.register(eventBus);
        ModPois.register(eventBus);
        ModBiomes.register();
        ModDimensions.register();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.SLOWNESS,
                    ModItems.INSECT_EYE.get(), ModPotions.PARALYSIS_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.POISON,
                    ModItems.WITHERBONE.get(), ModPotions.WITHER_POTION.get()));
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents buildContents) {
        if (buildContents.getTab() == ModCreativeModeTab.SLAYERS_BEASTS_TAB) {
            buildContents.accept(ModItems.JADE);
            buildContents.accept(ModItems.JADE_SHARD);
            buildContents.accept(ModItems.CRYSTALLINE_WING);
            buildContents.accept(ModItems.CRYSTALLINE_CLAW);
            buildContents.accept(ModItems.CRYSTALLINE_CARAPACE);
            buildContents.accept(ModItems.INSECT_WING);
            buildContents.accept(ModItems.INSECT_CLAW);
            buildContents.accept(ModItems.INSECT_EYE);
            buildContents.accept(ModItems.INSECT_LEG);
            buildContents.accept(ModItems.FRIED_INSECT_LEG);
            buildContents.accept(ModItems.WITHERBONE);
            buildContents.accept(ModItems.TIED_LEATHER);
            buildContents.accept(ModItems.TANNED_LEATHER);

            buildContents.accept(ModBlocks.JADE_BLOCK);
            buildContents.accept(ModBlocks.EXOSKELETON_ORE);
            buildContents.accept(ModBlocks.DEEPSLATE_EXOSKELETON_ORE);
            
            buildContents.accept(ModBlocks.OOTHECA);
            buildContents.accept(ModBlocks.ANT_SOIL);
            buildContents.accept(ModBlocks.ANTHILL);
            buildContents.accept(ModBlocks.ANTHILL_HATCHERY);

            buildContents.accept(ModBlocks.BLACK_SAND);
            buildContents.accept(ModBlocks.BLACK_SANDSTONE);
            buildContents.accept(ModBlocks.BLACK_SANDSTONE_SLAB);
            buildContents.accept(ModBlocks.BLACK_SANDSTONE_STAIRS);
            buildContents.accept(ModBlocks.BLACK_SANDSTONE_WALL);
            buildContents.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE);
            buildContents.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB);
            buildContents.accept(ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS);
            buildContents.accept(ModBlocks.CUT_BLACK_SANDSTONE);
            buildContents.accept(ModBlocks.CUT_BLACK_SANDSTONE_SLAB);
            buildContents.accept(ModBlocks.CHISELED_BLACK_SANDSTONE);

            buildContents.accept(ModBlocks.WHITE_MUSHROOM);
            buildContents.accept(ModBlocks.WHITE_MUSHROOM_BLOCK);

            buildContents.accept(ModBlocks.ASPEN_LOG);
            buildContents.accept(ModBlocks.STRIPPED_ASPEN_LOG);
            buildContents.accept(ModBlocks.ASPEN_WOOD);
            buildContents.accept(ModBlocks.STRIPPED_ASPEN_WOOD);
            buildContents.accept(ModBlocks.ASPEN_LEAVES);
            buildContents.accept(ModBlocks.ASPEN_SAPLING);
            buildContents.accept(ModBlocks.ASPEN_PLANKS);
            buildContents.accept(ModBlocks.ASPEN_SLAB);
            buildContents.accept(ModBlocks.ASPEN_STAIRS);
            buildContents.accept(ModBlocks.ASPEN_FENCE);
            buildContents.accept(ModBlocks.ASPEN_FENCE_GATE);
            buildContents.accept(ModBlocks.ASPEN_DOOR);
            buildContents.accept(ModBlocks.ASPEN_TRAPDOOR);
            
            buildContents.accept(ModBlocks.CAJOLE_LOG);
            buildContents.accept(ModBlocks.STRIPPED_CAJOLE_LOG);
            buildContents.accept(ModBlocks.CAJOLE_WOOD);
            buildContents.accept(ModBlocks.STRIPPED_CAJOLE_WOOD);
            buildContents.accept(ModBlocks.CAJOLE_LEAVES);
            buildContents.accept(ModBlocks.CAJOLE_SAPLING);
            buildContents.accept(ModBlocks.CAJOLE_PLANKS);
            buildContents.accept(ModBlocks.CAJOLE_SLAB);
            buildContents.accept(ModBlocks.CAJOLE_STAIRS);
            buildContents.accept(ModBlocks.CAJOLE_FENCE);
            buildContents.accept(ModBlocks.CAJOLE_FENCE_GATE);
            buildContents.accept(ModBlocks.CAJOLE_DOOR);
            buildContents.accept(ModBlocks.CAJOLE_TRAPDOOR);

            buildContents.accept(ModBlocks.EUCALYPTUS_LOG);
            buildContents.accept(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
            buildContents.accept(ModBlocks.EUCALYPTUS_WOOD);
            buildContents.accept(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);
            buildContents.accept(ModBlocks.EUCALYPTUS_LEAVES);
            buildContents.accept(ModBlocks.EUCALYPTUS_SAPLING);
            buildContents.accept(ModBlocks.EUCALYPTUS_PLANKS);
            buildContents.accept(ModBlocks.EUCALYPTUS_SLAB);
            buildContents.accept(ModBlocks.EUCALYPTUS_STAIRS);
            buildContents.accept(ModBlocks.EUCALYPTUS_FENCE);
            buildContents.accept(ModBlocks.EUCALYPTUS_FENCE_GATE);
            buildContents.accept(ModBlocks.EUCALYPTUS_DOOR);
            buildContents.accept(ModBlocks.EUCALYPTUS_TRAPDOOR);
            
            buildContents.accept(ModBlocks.REDWOOD_LOG);
            buildContents.accept(ModBlocks.STRIPPED_REDWOOD_LOG);
            buildContents.accept(ModBlocks.REDWOOD_WOOD);
            buildContents.accept(ModBlocks.STRIPPED_REDWOOD_WOOD);
            buildContents.accept(ModBlocks.REDWOOD_LEAVES);
            buildContents.accept(ModBlocks.REDWOOD_SAPLING);
            buildContents.accept(ModBlocks.REDWOOD_PLANKS);
            buildContents.accept(ModBlocks.REDWOOD_SLAB);
            buildContents.accept(ModBlocks.REDWOOD_STAIRS);
            buildContents.accept(ModBlocks.REDWOOD_FENCE);
            buildContents.accept(ModBlocks.REDWOOD_FENCE_GATE);
            buildContents.accept(ModBlocks.REDWOOD_DOOR);
            buildContents.accept(ModBlocks.REDWOOD_TRAPDOOR);
            
            buildContents.accept(ModItems.MANTIS_SPAWN_EGG);
            buildContents.accept(ModItems.WORKER_ANT_SPAWN_EGG);
            buildContents.accept(ModItems.SOLDIER_ANT_SPAWN_EGG);
            buildContents.accept(ModItems.QUEEN_ANT_SPAWN_EGG);
            buildContents.accept(ModItems.DAMSELFLY_SPAWN_EGG);
            buildContents.accept(ModItems.WITHER_SPIDER_SPAWN_EGG);
        }
    }
}
