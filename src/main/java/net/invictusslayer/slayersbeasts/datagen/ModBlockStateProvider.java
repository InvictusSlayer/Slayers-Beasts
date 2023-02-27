package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SlayersBeasts.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        columnBottomTopBlock(ModBlocks.OOTHECA.get());
        columnBottomTopBlock(ModBlocks.ANTHILL.get());
        columnBottomTopBlock(ModBlocks.ANT_HATCHERY.get());

        blockWithItem(ModBlocks.JADE_BLOCK);
        blockWithItem(ModBlocks.EXOSKELETON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_EXOSKELETON_ORE);

        logBlock((RotatedPillarBlock) ModBlocks.CAJOLE_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_LOG.get());
        woodBlock((RotatedPillarBlock) ModBlocks.CAJOLE_WOOD.get(), ModBlocks.CAJOLE_LOG.get());
        woodBlock((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_WOOD.get(), ModBlocks.STRIPPED_CAJOLE_LOG.get());
        blockWithItem(ModBlocks.CAJOLE_LEAVES);
        saplingBlock(ModBlocks.CAJOLE_SAPLING.get());
        blockWithItem(ModBlocks.CAJOLE_PLANKS);
        slabBlock((SlabBlock) ModBlocks.CAJOLE_SLAB.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.CAJOLE_STAIRS.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.CAJOLE_FENCE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.CAJOLE_FENCE_GATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.CAJOLE_BUTTON.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.CAJOLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.CAJOLE_DOOR.get(),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.CAJOLE_TRAPDOOR.get(), blockTexture(ModBlocks.CAJOLE_TRAPDOOR.get()), true, "cutout");

        logBlock((RotatedPillarBlock) ModBlocks.EUCALYPTUS_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        woodBlock((RotatedPillarBlock) ModBlocks.EUCALYPTUS_WOOD.get(), ModBlocks.EUCALYPTUS_LOG.get());
        woodBlock((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        blockWithItem(ModBlocks.EUCALYPTUS_LEAVES);
        saplingBlock(ModBlocks.EUCALYPTUS_SAPLING.get());
        blockWithItem(ModBlocks.EUCALYPTUS_PLANKS);
        slabBlock((SlabBlock) ModBlocks.EUCALYPTUS_SLAB.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.EUCALYPTUS_STAIRS.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlocks.EUCALYPTUS_FENCE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.EUCALYPTUS_FENCE_GATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        buttonBlock((ButtonBlock) ModBlocks.EUCALYPTUS_BUTTON.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.EUCALYPTUS_DOOR.get(),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.EUCALYPTUS_TRAPDOOR.get(), blockTexture(ModBlocks.EUCALYPTUS_TRAPDOOR.get()), true, "cutout");
    }

    private void woodBlock(RotatedPillarBlock block, Block log) {
        axisBlock(block, blockTexture(log), blockTexture(log));
    }
    private void saplingBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cross(name(block), blockTexture(block)).renderType("cutout")).build());
    }
    
    private void columnBottomTopBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cubeBottomTop(name(block),
                        extend(blockTexture(block), "_side"),
                        extend(blockTexture(block), "_bottom"),
                        extend(blockTexture(block), "_top"))).build()
        );
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
