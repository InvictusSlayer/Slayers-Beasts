package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.DepletedCryptalithBlock;
import net.invictusslayer.slayersbeasts.block.InfusedCryptalithBlock;
import net.invictusslayer.slayersbeasts.block.SBBlockFamilies;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class SBBlockStateProvider extends BlockStateProvider {
    public SBBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    protected void registerStatesAndModels() {
        generateBlockFamilies();

        verticalPortal(SBBlocks.SEPULCHRA_PORTAL.get(), "translucent");
        horizontalPortal(SBBlocks.CRYPT_PORTAL.get(), "solid");
        cubeRandomWithItem(SBBlocks.CRYPTALITH.get(), false);
        infusedCryptalith();
        depletedCryptalith();
        cubeWithItem(SBBlocks.JADE_BLOCK.get());
        cubeWithItem(SBBlocks.EXOSKELETON_ORE.get());
        cubeWithItem(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
        simpleCubeBottomTopWithItem(SBBlocks.STYPHIUM.get());
        simpleCubeBottomTopWithItem(SBBlocks.DEEPSLATE_STYPHIUM.get());

        cubeRandomWithItem(SBBlocks.RUDOSOL.get(), true);
        cubeRandomWithItem(SBBlocks.ARIDISOL.get(), true);
        simpleCubeBottomTopWithItem(SBBlocks.ANTHILL.get());
        simpleCubeBottomTopWithItem(SBBlocks.ANTHILL_HATCHERY.get());
        simpleCubeBottomTopWithItem(SBBlocks.OOTHECA.get());

        cubeWithItem(SBBlocks.GLEAMING_ICE.get());
        dripstone(SBBlocks.ICICLE.get());
        dripstone(SBBlocks.OBSIDIAN_SPIKE.get());
        doubleCrossBlock(SBBlocks.TALL_DEAD_BUSH.get());
        tiltCubeWithItem(SBBlocks.CRACKED_MUD.get());
        cubeWithItem(SBBlocks.PEAT.get());
        flatRandomBlock(SBBlocks.ALGAE.get());

        cubeRandomWithItem(SBBlocks.BLACK_SAND.get(), true);
        cubeBottomTopWithItem(SBBlocks.BLACK_SANDSTONE.get(), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) SBBlocks.BLACK_SANDSTONE_SLAB.get(), blockTexture(SBBlocks.BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        stairWithItem((StairBlock) SBBlocks.BLACK_SANDSTONE_STAIRS.get(), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_side"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_bottom"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        wallWithItem((WallBlock) SBBlocks.BLACK_SANDSTONE_WALL.get(), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_side"));
        cubeOtherWithItem(SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get(), blockTexture(SBBlocks.BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        stairWithItem((StairBlock) SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get(), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        columnWithItem(SBBlocks.CUT_BLACK_SANDSTONE.get(), blockTexture(SBBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        slabWithItem((SlabBlock) SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get(), blockTexture(SBBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"), blockTexture(SBBlocks.CUT_BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));
        columnWithItem(SBBlocks.CHISELED_BLACK_SANDSTONE.get(), blockTexture(SBBlocks.CHISELED_BLACK_SANDSTONE.get()), extend(blockTexture(SBBlocks.BLACK_SANDSTONE.get()), "_top"));

        cross(SBBlocks.BLACK_MUSHROOM.get());
        mushroomBlockWithItem(SBBlocks.BLACK_MUSHROOM_BLOCK.get(),"mushroom_block_dark_inside");
        cross(SBBlocks.WHITE_MUSHROOM.get());
        mushroomBlockWithItem(SBBlocks.WHITE_MUSHROOM_BLOCK.get(), null);
        
        logWithItem((RotatedPillarBlock) SBBlocks.ASPEN_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_ASPEN_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.ASPEN_WOOD.get(), blockTexture(SBBlocks.ASPEN_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_ASPEN_WOOD.get(), blockTexture(SBBlocks.STRIPPED_ASPEN_LOG.get()));
        cubeWithItem(SBBlocks.ASPEN_LEAVES.get());
        cross(SBBlocks.ASPEN_SAPLING.get());

        logWithItem((RotatedPillarBlock) SBBlocks.CAJOLE_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_CAJOLE_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.CAJOLE_WOOD.get(), blockTexture(SBBlocks.CAJOLE_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_CAJOLE_WOOD.get(), blockTexture(SBBlocks.STRIPPED_CAJOLE_LOG.get()));
        cubeWithItem(SBBlocks.CAJOLE_LEAVES.get());
        cross(SBBlocks.CAJOLE_SAPLING.get());
        
        logWithItem((RotatedPillarBlock) SBBlocks.DESERT_OAK_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_DESERT_OAK_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.DESERT_OAK_WOOD.get(), blockTexture(SBBlocks.DESERT_OAK_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_DESERT_OAK_WOOD.get(), blockTexture(SBBlocks.STRIPPED_DESERT_OAK_LOG.get()));
        cubeWithItem(SBBlocks.DESERT_OAK_LEAVES.get());
        cross(SBBlocks.DESERT_OAK_SAPLING.get());

        logWithItem((RotatedPillarBlock) SBBlocks.EUCALYPTUS_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.EUCALYPTUS_WOOD.get(), blockTexture(SBBlocks.EUCALYPTUS_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), blockTexture(SBBlocks.STRIPPED_EUCALYPTUS_LOG.get()));
        cubeWithItem(SBBlocks.EUCALYPTUS_LEAVES.get());
        cross(SBBlocks.EUCALYPTUS_SAPLING.get());

        logWithItem((RotatedPillarBlock) SBBlocks.KAPOK_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_KAPOK_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.KAPOK_WOOD.get(), blockTexture(SBBlocks.KAPOK_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_KAPOK_WOOD.get(), blockTexture(SBBlocks.STRIPPED_KAPOK_LOG.get()));
        cubeWithItem(SBBlocks.KAPOK_LEAVES.get());
        cross(SBBlocks.KAPOK_SAPLING.get());
        
        logWithItem((RotatedPillarBlock) SBBlocks.REDWOOD_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_REDWOOD_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.REDWOOD_WOOD.get(), blockTexture(SBBlocks.REDWOOD_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_REDWOOD_WOOD.get(), blockTexture(SBBlocks.STRIPPED_REDWOOD_LOG.get()));
        cubeWithItem(SBBlocks.REDWOOD_LEAVES.get());
        cross(SBBlocks.REDWOOD_SAPLING.get());

        logWithItem((RotatedPillarBlock) SBBlocks.WILLOW_LOG.get());
        logWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_WILLOW_LOG.get());
        woodWithItem((RotatedPillarBlock) SBBlocks.WILLOW_WOOD.get(), blockTexture(SBBlocks.WILLOW_LOG.get()));
        woodWithItem((RotatedPillarBlock) SBBlocks.STRIPPED_WILLOW_WOOD.get(), blockTexture(SBBlocks.STRIPPED_WILLOW_LOG.get()));
        cubeWithItem(SBBlocks.WILLOW_LEAVES.get());
        cross(SBBlocks.WILLOW_SAPLING.get());
        cross(SBBlocks.WILLOW_BRANCH.get());
        cross(SBBlocks.WILLOW_BRANCH_PLANT.get());
    }

    private void generateBlockFamilies() {
        SBBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> {
            Block base = family.getBaseBlock();
            cubeWithItem(base);
            family.getVariants().forEach((variant, block) -> {
                if (variant == BlockFamily.Variant.SLAB) {
                    simpleSlabWithItem((SlabBlock) block, blockTexture(base), blockTexture(base));
                } else if (variant == BlockFamily.Variant.STAIRS) {
                    simpleStairWithItem((StairBlock) block, blockTexture(base));
                } else if (variant == BlockFamily.Variant.FENCE) {
                    fenceWithItem((FenceBlock) block, blockTexture(base));
                } else if (variant == BlockFamily.Variant.FENCE_GATE) {
                    fenceGateWithItem((FenceGateBlock) block, blockTexture(base));
                } else if (variant == BlockFamily.Variant.BUTTON) {
                    buttonWithItem((ButtonBlock) block, blockTexture(base));
                } else if (variant == BlockFamily.Variant.PRESSURE_PLATE) {
                    pressurePlateWithItem((PressurePlateBlock) block, blockTexture(base));
                } else if (variant == BlockFamily.Variant.DOOR) {
                    doorBlockWithRenderType((DoorBlock) block, extend(blockTexture(block), "_bottom"), extend(blockTexture(block), "_top"), "cutout");
                } else if (variant == BlockFamily.Variant.TRAPDOOR) {
                    trapdoorWithItem((TrapDoorBlock) block, true);
                } else if (variant == BlockFamily.Variant.WALL) {
                    wallWithItem((WallBlock) block, blockTexture(base));
                }
            });
        });
    }

    private void horizontalPortal(Block block, String renderType) {
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(models().getBuilder(name(block))
                .texture("portal", blockTexture(block)).texture("particle", blockTexture(block))
                .element().from(0, 6, 0).to(16, 12, 16)
                .face(Direction.UP).texture("#portal").end().face(Direction.DOWN).texture("#portal").end()
                .end().renderType(renderType)).build());
    }
    private void verticalPortal(Block block, String renderType) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean isX = state.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Direction.Axis.X;
            return ConfiguredModel.builder().modelFile(models().getBuilder(name(block) + (isX ? "_ns" : "_ew"))
                    .texture("portal", blockTexture(block)).texture("particle", blockTexture(block))
                    .element().from(isX ? 0 : 6, 0, isX ? 6 : 0).to(isX ? 16 : 10, 16, isX ? 10 : 16)
                    .face(isX ? Direction.NORTH : Direction.EAST).texture("#portal").end().face(isX ? Direction.SOUTH : Direction.WEST).texture("#portal").end()
                    .end().renderType(renderType)).build();
        });
    }

    private void doubleCrossBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String suffix = state.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? "_bottom" : "_top";
            return ConfiguredModel.builder().modelFile(models().cross(name(block) + suffix, extend(blockTexture(block), suffix)).renderType("cutout")).build();
        });
    }

    private void infusedCryptalith() {
        Block block = SBBlocks.INFUSED_CRYPTALITH.get();
        getVariantBuilder(block).forAllStates(state -> {
            String suffix = state.getValue(BlockStateProperties.EYE) ? "_active" : "";
            return ConfiguredModel.builder().modelFile(models().cubeBottomTop(name(block) + suffix, extend(blockTexture(block),
                    "_side"), blockTexture(SBBlocks.CRYPTALITH.get()), extend(blockTexture(block), "_top" + suffix)))
                    .rotationY((int) state.getValue(InfusedCryptalithBlock.FACING).toYRot()).build();
        });
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_bottom_top"));
    }
    private void depletedCryptalith() {
        Block block = SBBlocks.DEPLETED_CRYPTALITH.get();
        getVariantBuilder(block).forAllStates(state ->
                ConfiguredModel.builder().modelFile(models().cubeBottomTop(name(block), extend(blockTexture(block), "_side"),
                        blockTexture(SBBlocks.CRYPTALITH.get()), extend(blockTexture(block), "_top")))
                        .rotationY((int) state.getValue(DepletedCryptalithBlock.FACING).toYRot()).build());
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_bottom_top"));
    }

    private void dripstone(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String suffix = "_" + state.getValue(BlockStateProperties.DRIPSTONE_THICKNESS).getSerializedName() + "_" + state.getValue(BlockStateProperties.VERTICAL_DIRECTION).getSerializedName();
            return ConfiguredModel.builder().modelFile(models().cross(name(block) + suffix, extend(blockTexture(block), suffix)).renderType("cutout")).build();
        });
    }

    private void mushroomBlockWithItem(Block block, @Nullable String inside) {
        ModelFile outsideModel = models().withExistingParent(name(block), "minecraft:block/template_single_face").texture("texture", blockTexture(block));
        ModelFile insideModel = inside != null ? models().withExistingParent(inside, "minecraft:block/template_single_face").texture("texture", new ResourceLocation(SlayersBeasts.MOD_ID, "block/" + inside)) :
                models().getExistingFile(new ResourceLocation("minecraft:block/mushroom_block_inside"));
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
    private void cross(Block block) {
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

    private void cubeRandomWithItem(Block block, boolean onlyTop) {
        ModelFile model = models().cubeAll(name(block), blockTexture(block));
        getVariantBuilder(block).forAllStates(state -> onlyTop ? ConfiguredModel.allYRotations(model, 0, false) : ConfiguredModel.allRotations(model, false));
        simpleBlockItem(block, models().withExistingParent(name(block), "minecraft:block/cube_all"));
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

    private void tiltCubeWithItem(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            String tilt = "_" + state.getValue(BlockStateProperties.TILT).getSerializedName();
            return ConfiguredModel.builder().modelFile(models().cubeAll(name(block) + tilt, extend(blockTexture(block), tilt))).build();
        });
        simpleBlockItem(block, models().withExistingParent(name(block) + "_none", "minecraft:block/cube_all"));
    }

    private void flatRandomBlock(Block block) {
        ModelFile model = models().getBuilder(name(block)).ao(false)
                .texture("texture", blockTexture(block)).texture("particle", blockTexture(block))
                .element().from(0, 0.25F, 0).to(16, 0.25F, 16)
                .face(Direction.UP).texture("#texture").end().face(Direction.DOWN).texture("#texture").end()
                .end().renderType("cutout");
        getVariantBuilder(block).forAllStates(state -> ConfiguredModel.allYRotations(model, 0, false));
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
