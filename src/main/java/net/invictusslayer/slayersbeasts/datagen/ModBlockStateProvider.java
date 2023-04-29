package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.data.BlockFamily;
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
        ModBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(this::registerBlockFamily);

        cubeWithItem(ModBlocks.JADE_BLOCK.get());
        cubeWithItem(ModBlocks.EXOSKELETON_ORE.get());
        cubeWithItem(ModBlocks.DEEPSLATE_EXOSKELETON_ORE.get());

        simpleCubeBottomTopWithItem(ModBlocks.OOTHECA.get());
        cubeWithItem(ModBlocks.ANT_SOIL.get());
        simpleCubeBottomTopWithItem(ModBlocks.ANTHILL.get());
        simpleCubeBottomTopWithItem(ModBlocks.ANTHILL_HATCHERY.get());

        cubeWithItem(ModBlocks.BLACK_SAND.get());
        cubeBottomTopWithItem(ModBlocks.BLACK_SANDSTONE.get(), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) ModBlocks.BLACK_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        stairWithItem((StairBlock) ModBlocks.BLACK_SANDSTONE_STAIRS.get(), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        wallWithItem((WallBlock) ModBlocks.BLACK_SANDSTONE_WALL.get(), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_side"));
        cubeOtherWithItem(ModBlocks.SMOOTH_BLACK_SANDSTONE.get(), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) ModBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        stairWithItem((StairBlock) ModBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        columnWithItem(ModBlocks.CUT_BLACK_SANDSTONE.get(), blockTexture(ModBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) ModBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"), blockTexture(ModBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));
        columnWithItem(ModBlocks.CHISELED_BLACK_SANDSTONE.get(), blockTexture(ModBlocks.CHISELED_BLACK_SANDSTONE.get()), extend(blockTexture(ModBlocks.BLACK_SANDSTONE.get()), "_top"));

        sapling(ModBlocks.WHITE_MUSHROOM.get());
        mushroomBlockWithItem(ModBlocks.WHITE_MUSHROOM_BLOCK.get());

        logWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_LOG.get());
        logWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_LOG.get());
        woodWithItem((RotatedPillarBlock) ModBlocks.CAJOLE_WOOD.get(), blockTexture(ModBlocks.CAJOLE_LOG.get()));
        woodWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_CAJOLE_WOOD.get(), blockTexture(ModBlocks.STRIPPED_CAJOLE_LOG.get()));
        cubeWithItem(ModBlocks.CAJOLE_LEAVES.get());
        sapling(ModBlocks.CAJOLE_SAPLING.get());

        logWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_LOG.get());
        logWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        woodWithItem((RotatedPillarBlock) ModBlocks.EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.EUCALYPTUS_LOG.get()));
        woodWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()));
        cubeWithItem(ModBlocks.EUCALYPTUS_LEAVES.get());
        sapling(ModBlocks.EUCALYPTUS_SAPLING.get());

        logWithItem((RotatedPillarBlock) ModBlocks.ASPEN_LOG.get());
        logWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_ASPEN_LOG.get());
        woodWithItem((RotatedPillarBlock) ModBlocks.ASPEN_WOOD.get(), blockTexture(ModBlocks.ASPEN_LOG.get()));
        woodWithItem((RotatedPillarBlock) ModBlocks.STRIPPED_ASPEN_WOOD.get(), blockTexture(ModBlocks.STRIPPED_ASPEN_LOG.get()));
        cubeWithItem(ModBlocks.ASPEN_LEAVES.get());
        sapling(ModBlocks.ASPEN_SAPLING.get());
    }

    private void registerBlockFamily(BlockFamily family) {
        cubeWithItem(family.getBaseBlock());
        simpleSlabWithItem((SlabBlock) family.get(BlockFamily.Variant.SLAB), blockTexture(family.getBaseBlock()), blockTexture(family.getBaseBlock()));
        simpleStairWithItem((StairBlock) family.get(BlockFamily.Variant.STAIRS), blockTexture(family.getBaseBlock()));
        fenceWithItem((FenceBlock) family.get(BlockFamily.Variant.FENCE), blockTexture(family.getBaseBlock()));
        fenceGateWithItem((FenceGateBlock) family.get(BlockFamily.Variant.FENCE_GATE), blockTexture(family.getBaseBlock()));
        buttonWithItem((ButtonBlock) family.get(BlockFamily.Variant.BUTTON), blockTexture(family.getBaseBlock()));
        pressurePlateWithItem((PressurePlateBlock) family.get(BlockFamily.Variant.PRESSURE_PLATE), blockTexture(family.getBaseBlock()));
        doorBlockWithRenderType((DoorBlock) family.get(BlockFamily.Variant.DOOR),
                extend(blockTexture(family.get(BlockFamily.Variant.DOOR)), "_bottom"),
                extend(blockTexture(family.get(BlockFamily.Variant.DOOR)), "_top"), "cutout");
        trapdoorWithItem((TrapDoorBlock) family.get(BlockFamily.Variant.TRAPDOOR), true);
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

    private void logWithItem(RotatedPillarBlock block) {
        logBlock(block);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }
    private void woodWithItem(RotatedPillarBlock block, ResourceLocation texture) {
        axisBlock(block, texture, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }
    private void sapling(Block block) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cross(name(block), blockTexture(block)).renderType("cutout")).build());
    }
    private void simpleSlabWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation texture) {
        slabBlock(block, doubleslab, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/slab"));
    }
    private void slabWithItem(SlabBlock block, ResourceLocation doubleslab, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        slabBlock(block, doubleslab, side, bottom, top);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/slab"));
    }
    private void simpleStairWithItem(StairBlock block, ResourceLocation texture) {
        stairsBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/stairs"));
    }
    private void stairWithItem(StairBlock block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        stairsBlock(block, side, bottom, top);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/stairs"));
    }
    private void fenceWithItem(FenceBlock block, ResourceLocation texture) {
        fenceBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/fence_inventory").texture("texture", texture));
    }
    private void fenceGateWithItem(FenceGateBlock block, ResourceLocation texture) {
        fenceGateBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/template_fence_gate"));
    }
    private void wallWithItem(WallBlock block, ResourceLocation texture) {
        wallBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/wall_inventory").texture("wall", texture));
    }
    private void buttonWithItem(ButtonBlock block, ResourceLocation texture) {
        buttonBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/button_inventory"));
    }
    private void pressurePlateWithItem(PressurePlateBlock block, ResourceLocation texture) {
        pressurePlateBlock(block, texture);
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/pressure_plate_up"));
    }
    private void trapdoorWithItem(TrapDoorBlock block, boolean orientable) {
        trapdoorBlockWithRenderType(block, blockTexture(block), orientable, "cutout");
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/template_trapdoor_bottom").texture("texture", blockTexture(block)));
    }
    
    private void cubeWithItem(Block block) {
        cubeOtherWithItem(block, blockTexture(block));
    }
    private void cubeOtherWithItem(Block block, ResourceLocation texture) {
        simpleBlock(block, models().cubeAll(name(block), texture));
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_all"));
    }

    private void columnWithItem(Block block, ResourceLocation side, ResourceLocation end) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cubeColumn(name(block), side, end)).build());
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_column"));
    }

    private void simpleCubeBottomTopWithItem(Block block) {
        cubeBottomTopWithItem(block, extend(blockTexture(block), "_side"), extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top"));
    }
    private void cubeBottomTopWithItem(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder()
                .modelFile(models().cubeBottomTop(name(block), side, bottom, top)).build());
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_bottom_top"));
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
