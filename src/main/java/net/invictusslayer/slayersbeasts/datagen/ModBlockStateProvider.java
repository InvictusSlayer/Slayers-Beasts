package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SlayersBeasts.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cubeWithItem(ModBlocks.JADE_BLOCK.get());
        cubeWithItem(ModBlocks.EXOSKELETON_ORE.get());
        cubeWithItem(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get());

        cubeBottomTopBlockWithItem(ModBlocks.OOTHECA.get());
        cubeWithItem(ModBlocks.ANT_SOIL.get());
        cubeBottomTopBlockWithItem(ModBlocks.ANTHILL.get());
        cubeBottomTopBlockWithItem(ModBlocks.ANTHILL_HATCHERY.get());

        cubeWithItem(ModBlocks.BLACK_SAND.get());

        saplingBlock(ModBlocks.WHITE_MUSHROOM.get());
        mushroomBlockWithItem(ModBlocks.WHITE_MUSHROOM_BLOCK.get());

        logBlockWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_LOG.get());
        logBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_LOG.get());
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_WOOD.get(), blockTexture(ModBlocks.CAJOLE_LOG.get()));
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CAJOLE_LOG.get()));
        cubeWithItem(ModBlocks.CAJOLE_LEAVES.get());
        saplingBlock(ModBlocks.CAJOLE_SAPLING.get());
        cubeWithItem(ModBlocks.CAJOLE_PLANKS.get());
        slabBlockWithItem((SlabBlock) ModBlocks.CAJOLE_SLAB.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        stairBlockWithItem((StairBlock) ModBlocks.CAJOLE_STAIRS.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceBlockWithItem((FenceBlock) ModBlocks.CAJOLE_FENCE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        fenceGateBlockWithItem((FenceGateBlock) ModBlocks.CAJOLE_FENCE_GATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        buttonBlockWithItem((ButtonBlock) ModBlocks.CAJOLE_BUTTON.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        pressurePlateBlockWithItem((PressurePlateBlock) ModBlocks.CAJOLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CAJOLE_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.CAJOLE_DOOR.get(),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.CAJOLE_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderTypeAndItem((TrapDoorBlock) ModBlocks.CAJOLE_TRAPDOOR.get(), true, "cutout");

        logBlockWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_LOG.get());
        logBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.EUCALYPTUS_LOG.get()));
        woodBlockWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()));
        cubeWithItem(ModBlocks.EUCALYPTUS_LEAVES.get());
        saplingBlock(ModBlocks.EUCALYPTUS_SAPLING.get());
        cubeWithItem(ModBlocks.EUCALYPTUS_PLANKS.get());
        slabBlockWithItem((SlabBlock) ModBlocks.EUCALYPTUS_SLAB.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        stairBlockWithItem((StairBlock) ModBlocks.EUCALYPTUS_STAIRS.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceBlockWithItem((FenceBlock) ModBlocks.EUCALYPTUS_FENCE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        fenceGateBlockWithItem((FenceGateBlock) ModBlocks.EUCALYPTUS_FENCE_GATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        buttonBlockWithItem((ButtonBlock) ModBlocks.EUCALYPTUS_BUTTON.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        pressurePlateBlockWithItem((PressurePlateBlock) ModBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EUCALYPTUS_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.EUCALYPTUS_DOOR.get(),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_bottom"),
                extend(blockTexture(ModBlocks.EUCALYPTUS_DOOR.get()), "_top"), "cutout");
        trapdoorBlockWithRenderTypeAndItem((TrapDoorBlock) ModBlocks.EUCALYPTUS_TRAPDOOR.get(), true, "cutout");
    }

    private void mushroomBlockWithItem(Block block) {
        ModelFile outsideModel = models().withExistingParent(name(block), "minecraft:block/template_single_face").texture("texture", blockTexture(block));
        ModelFile insideModel = models().getExistingFile(new ResourceLocation("minecraft:block/mushroom_block_inside"));
        getMultipartBuilder(block).part().modelFile(outsideModel).addModel().condition(BlockStateProperties.NORTH, true).end()
                .part().modelFile(outsideModel).rotationY(90).uvLock(true).addModel().condition(BlockStateProperties.EAST, true).end()
                .part().modelFile(outsideModel).rotationY(180).uvLock(true).addModel().condition(BlockStateProperties.SOUTH, true).end()
                .part().modelFile(outsideModel).rotationY(270).uvLock(true).addModel().condition(BlockStateProperties.WEST, true).end()
                .part().modelFile(outsideModel).rotationX(270).uvLock(true).addModel().condition(BlockStateProperties.UP, true).end()
                .part().modelFile(outsideModel).rotationX(90).uvLock(true).addModel().condition(BlockStateProperties.DOWN, true).end()
                .part().modelFile(insideModel).addModel().condition(BlockStateProperties.NORTH, false).end()
                .part().modelFile(insideModel).rotationY(90).uvLock(false).addModel().condition(BlockStateProperties.EAST, false).end()
                .part().modelFile(insideModel).rotationY(180).uvLock(false).addModel().condition(BlockStateProperties.SOUTH, false).end()
                .part().modelFile(insideModel).rotationY(270).uvLock(false).addModel().condition(BlockStateProperties.WEST, false).end()
                .part().modelFile(insideModel).rotationX(270).uvLock(false).addModel().condition(BlockStateProperties.UP, false).end()
                .part().modelFile(insideModel).rotationX(90).uvLock(false).addModel().condition(BlockStateProperties.DOWN, false);
        simpleBlockItem(block, models().withExistingParent(name(block) + "_inventory", "minecraft:block/cube_all").texture("all", blockTexture(block)));
    }

    private void logBlockWithItem(RotatedPillarBlock block) {
        logBlock(block);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }
    private void woodBlockWithItem(RotatedPillarBlock block, ResourceLocation texture) {
        axisBlock(block, texture, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }
    private void saplingBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cross(name(block), blockTexture(block)).renderType("cutout")).build());
    }
    private void slabBlockWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/slab"));
    }
    private void stairBlockWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/stairs"));
    }
    private void fenceBlockWithItem(FenceBlock block, ResourceLocation texture) {
        fenceBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/fence_inventory").texture("texture", texture));
    }
    private void fenceGateBlockWithItem(FenceGateBlock block, ResourceLocation texture) {
        fenceGateBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/template_fence_gate"));
    }
    private void buttonBlockWithItem(ButtonBlock block, ResourceLocation texture) {
        buttonBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/button_inventory"));
    }
    private void pressurePlateBlockWithItem(PressurePlateBlock block, ResourceLocation texture) {
        pressurePlateBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/pressure_plate_up"));
    }
    private void trapdoorBlockWithRenderTypeAndItem(TrapDoorBlock block, boolean orientable, String renderType) {
        trapdoorBlockWithRenderType(block, blockTexture(block), orientable, renderType);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/template_trapdoor_bottom").texture("texture", blockTexture(block)));
    }

    private void cubeWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }

    private void cubeBottomTopBlockWithItem(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cubeBottomTop(name(block),
                        extend(blockTexture(block), "_side"),
                        extend(blockTexture(block), "_bottom"),
                        extend(blockTexture(block), "_top"))).build());
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_bottom_top"));
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
