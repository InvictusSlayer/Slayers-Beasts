package net.invictusslayer.slayersbeasts;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.entity.SBBlockEntities;
import net.invictusslayer.slayersbeasts.effect.SBEffects;
import net.invictusslayer.slayersbeasts.entity.SBEntities;
import net.invictusslayer.slayersbeasts.entity.npc.SBVillagerType;
import net.invictusslayer.slayersbeasts.event.SBClientEvents;
import net.invictusslayer.slayersbeasts.event.SBCommonEvents;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.item.SBPotions;
import net.invictusslayer.slayersbeasts.misc.SBCreativeModeTab;
import net.invictusslayer.slayersbeasts.misc.SBPois;
import net.invictusslayer.slayersbeasts.misc.SBSounds;
import net.invictusslayer.slayersbeasts.world.feature.SBFeatures;
import net.invictusslayer.slayersbeasts.world.feature.tree.decorator.SBTreeDecorators;
import net.invictusslayer.slayersbeasts.world.feature.tree.foliageplacer.SBFoliagePlacers;
import net.invictusslayer.slayersbeasts.world.feature.tree.trunkplacer.SBTrunkPlacers;
import net.invictusslayer.slayersbeasts.world.structure.pieces.SBStructurePieces;
import net.invictusslayer.slayersbeasts.world.structure.structures.SBStructureType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SlayersBeasts.MOD_ID)
public class SlayersBeasts {
    public static final String MOD_ID = "slayersbeasts";
    public static final String FORGE = "forge";

    public SlayersBeasts() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

	    SBCreativeModeTab.CREATIVE_TABS.register(eventBus);
        SBItems.ITEMS.register(eventBus);
        SBBlocks.BLOCKS.register(eventBus);
        SBBlockEntities.BLOCK_ENTITIES.register(eventBus);
        SBEntities.ENTITIES.register(eventBus);
        SBVillagerType.VILLAGER_TYPES.register(eventBus);
        SBEffects.EFFECTS.register(eventBus);
        SBPotions.POTIONS.register(eventBus);
        SBSounds.SOUNDS.register(eventBus);
        SBTreeDecorators.TREE_DECORATORS.register(eventBus);
        SBFoliagePlacers.FOLIAGE_PLACERS.register(eventBus);
        SBTrunkPlacers.TRUNK_PLACERS.register(eventBus);
        SBFeatures.FEATURES.register(eventBus);
        SBStructurePieces.STRUCTURE_PIECES.register(eventBus);
        SBStructureType.STRUCTURE_TYPES.register(eventBus);
        SBPois.POIS.register(eventBus);

        SBVillagerType.biomeSetup();

	    eventBus.addListener(SBCommonEvents::commonSetup);
	    eventBus.addListener(SBClientEvents::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
