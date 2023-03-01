package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SlayersBeasts.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        columnBottomTopBlockWithItem(ModBlocks.OOTHECA.get());
        columnBottomTopBlockWithItem(ModBlocks.ANTHILL.get());
        columnBottomTopBlockWithItem(ModBlocks.ANT_HATCHERY.get());

        blockWithItem(ModBlocks.JADE_BLOCK);
        blockWithItem(ModBlocks.EXOSKELETON_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_EXOSKELETON_ORE);

        logBlockWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_LOG.get());
        logBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_LOG.get());
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_WOOD.get(), blockTexture(ModBlocks.CAJOLE_LOG.get()));
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CAJOLE_LOG.get()));
        blockWithItem(ModBlocks.CAJOLE_LEAVES);
        saplingBlock(ModBlocks.CAJOLE_SAPLING.get());
        blockWithItem(ModBlocks.CAJOLE_PLANKS);
        slabBlockWithItem((SlabBlock) ModBlocks.CAJOLE_SLAB.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        stairBlockWithItem((StairBlock) ModBlocks.CAJOLE_STAIRS.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceBlockWithItem((FenceBlock) ModBlocks.CAJOLE_FENCE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceGateBlockWithItem((FenceGateBlock) ModBlocks.CAJOLE_FENCE_GATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        buttonBlockWithItem((ButtonBlock) ModBlocks.CAJOLE_BUTTON.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        pressurePlateBlockWithItem((PressurePlateBlock) ModBlocks.CAJOLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.CAJOLE_DOOR.get(),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderTypeAndItem((TrapDoorBlock) ModBlocks.CAJOLE_TRAPDOOR.get(), blockTexture(ModBlocks.CAJOLE_TRAPDOOR.get()), true, "cutout");

        logBlockWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_LOG.get());
        logBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.EUCALYPTUS_LOG.get()));
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()));
        blockWithItem(ModBlocks.EUCALYPTUS_LEAVES);
        saplingBlock(ModBlocks.EUCALYPTUS_SAPLING.get());
        blockWithItem(ModBlocks.EUCALYPTUS_PLANKS);
        slabBlockWithItem((SlabBlock) ModBlocks.EUCALYPTUS_SLAB.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        stairBlockWithItem((StairBlock) ModBlocks.EUCALYPTUS_STAIRS.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceBlockWithItem((FenceBlock) ModBlocks.EUCALYPTUS_FENCE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceGateBlockWithItem((FenceGateBlock) ModBlocks.EUCALYPTUS_FENCE_GATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        buttonBlockWithItem((ButtonBlock) ModBlocks.EUCALYPTUS_BUTTON.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        pressurePlateBlockWithItem((PressurePlateBlock) ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.EUCALYPTUS_DOOR.get(),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderTypeAndItem((TrapDoorBlock) ModBlocks.EUCALYPTUS_TRAPDOOR.get(), blockTexture(ModBlocks.EUCALYPTUS_TRAPDOOR.get()), true, "cutout");
    }


    private void logBlockWithItem(RotatedPillarBlock block) {
        logBlock(block);
        simpleBlockItem(block, models().cubeColumn(name(block), blockTexture(block), extend(blockTexture(block), "_top")));
    }
    private void woodBlockWithItem(RotatedPillarBlock block, ResourceLocation texture) {
        axisBlock(block, texture, texture);
        simpleBlockItem(block, models().cubeColumn(name(block), texture, texture));
    }
    private void saplingBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cross(name(block), blockTexture(block)).renderType("cutout")).build());
    }
    private void slabBlockWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, models().slab(name(block), texture, texture, texture));
    }
    private void stairBlockWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlock(block, texture);
        simpleBlockItem(block, models().stairs(name(block), texture, texture, texture));
    }
    private void fenceBlockWithItem(FenceBlock block, ResourceLocation texture) {
        fenceBlock(block, texture);
        simpleBlockItem(block, models().fenceInventory(name(block), texture));
    }
    private void fenceGateBlockWithItem(FenceGateBlock block, ResourceLocation texture) {
        fenceGateBlock(block, texture);
        simpleBlockItem(block, models().fenceGate(name(block), texture));
    }
    private void buttonBlockWithItem(ButtonBlock block, ResourceLocation texture) {
        buttonBlock(block, texture);
        simpleBlockItem(block, models().buttonInventory(name(block), texture));
    }
    private void pressurePlateBlockWithItem(PressurePlateBlock block, ResourceLocation texture) {
        pressurePlateBlock(block, texture);
        simpleBlockItem(block, models().pressurePlate(name(block), texture));
    }
    private void trapdoorBlockWithRenderTypeAndItem(TrapDoorBlock block, ResourceLocation texture, boolean orientable, String renderType) {
        trapdoorBlockWithRenderType(block, texture, orientable, renderType);
        simpleBlockItem(block, models().trapdoorBottom(name(block), texture));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void columnBottomTopBlockWithItem(Block block) {
        customBlockWithItem(block, models().cubeBottomTop(name(block),
                extend(blockTexture(block), "_side"),
                extend(blockTexture(block), "_bottom"),
                extend(blockTexture(block), "_top")));
    }

    private void customBlockWithItem(Block block, ModelFile model) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(model).build());
        simpleBlockItem(block, model);
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
