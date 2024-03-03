package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.block.entity.SBHangingSignBlockEntity;
import net.invictusslayer.slayersbeasts.block.entity.SBSignBlockEntity;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.tree.grower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class SBBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SlayersBeasts.MOD_ID);

	public static final RegistryObject<Block> SEPULCHRA_PORTAL = BLOCKS.register("sepulchra_portal", () -> new SepulchraPortalBlock(Block.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

	public static final RegistryObject<Block> CRYPT_PORTAL = BLOCKS.register("crypt_portal", () -> new CryptPortalBlock(Block.Properties.copy(Blocks.END_PORTAL).mapColor(MapColor.QUARTZ).noLootTable()));
	public static final RegistryObject<Block> CRYPTALITH = register("cryptalith", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
	public static final RegistryObject<Block> INFUSED_CRYPTALITH = register("infused_cryptalith", () -> new InfusedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F).lightLevel(state -> 1)));
	public static final RegistryObject<Block> DEPLETED_CRYPTALITH = register("depleted_cryptalith", () -> new DepletedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F)));

	public static final RegistryObject<Block> JADE_BLOCK = register("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(9f)));

	public static final RegistryObject<Block> EXOSKELETON_ORE = register("exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(15f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final RegistryObject<Block> DEEPSLATE_EXOSKELETON_ORE = register("deepslate_exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(25f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

	public static final RegistryObject<Block> STYPHIUM = register("styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
	public static final RegistryObject<Block> DEEPSLATE_STYPHIUM = register("deepslate_styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

	public static final RegistryObject<Block> RUDOSOL = register("rudosol", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistryObject<Block> ARIDISOL = register("aridisol", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistryObject<Block> ANTHILL = register("anthill", () -> new AnthillBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistryObject<Block> ANTHILL_HATCHERY = register("anthill_hatchery", () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));

	public static final RegistryObject<Block> OOTHECA = register("ootheca", () -> new OothecaBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).strength(1f).noLootTable()));

	public static final RegistryObject<Block> GLEAMING_ICE = register("gleaming_ice", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).lightLevel(state -> 7)));
	public static final RegistryObject<Block> ICICLE = register("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.ICE).sound(SoundType.GLASS)));
	public static final RegistryObject<Block> OBSIDIAN_SPIKE = register("obsidian_spike", () -> new ObsidianSpikeBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.COLOR_BLACK).strength(50.0F, 1200.0F)));

	public static final RegistryObject<Block> TALL_DEAD_BUSH = register("tall_dead_bush", () -> new TallDeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
	public static final RegistryObject<Block> CRACKED_MUD = register("cracked_mud", () -> new CrackedMudBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));
	public static final RegistryObject<Block> PEAT = register("peat", () -> new PeatBlock(BlockBehaviour.Properties.copy(Blocks.POWDER_SNOW).mapColor(MapColor.TERRACOTTA_BLACK).strength(1F).sound(SoundType.MUD).forceSolidOn().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> ALGAE = BLOCKS.register("algae", () -> new AlgaeBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).noCollission()));

	public static final RegistryObject<Block> PEGMATITE = register("pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final RegistryObject<Block> PEGMATITE_SLAB = register("pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEGMATITE.get())));
	public static final RegistryObject<Block> PEGMATITE_STAIRS = register("pegmatite_stairs", () -> new StairBlock(() -> PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEGMATITE.get())));
	public static final RegistryObject<Block> PEGMATITE_WALL = register("pegmatite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(PEGMATITE.get()).forceSolidOn()));
	public static final RegistryObject<Block> POLISHED_PEGMATITE = register("polished_pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final RegistryObject<Block> POLISHED_PEGMATITE_SLAB = register("polished_pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));
	public static final RegistryObject<Block> POLISHED_PEGMATITE_STAIRS = register("polished_pegmatite_stairs", () -> new StairBlock(() -> POLISHED_PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));

	public static final RegistryObject<Block> BLACK_SAND = register("black_sand", () -> new SandBlock(3748886, BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> BLACK_SANDSTONE = register("black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_SLAB = register("black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_STAIRS = register("black_sandstone_stairs", () -> new StairBlock(() -> BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> BLACK_SANDSTONE_WALL = register("black_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE = register("smooth_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_SLAB = register("smooth_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = register("smooth_black_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> CUT_BLACK_SANDSTONE = register("cut_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> CUT_BLACK_SANDSTONE_SLAB = register("cut_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistryObject<Block> CHISELED_BLACK_SANDSTONE = register("chiseled_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));

	public static final RegistryObject<Block> BLACK_MUSHROOM_BLOCK = register("black_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.TERRACOTTA_BLACK)));
	public static final RegistryObject<Block> BLACK_MUSHROOM = register("black_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.HUGE_BLACK_MUSHROOM) {public PlantType getPlantType(BlockGetter level, BlockPos pos) {return PlantType.CAVE;}});
	public static final RegistryObject<Block> POTTED_BLACK_MUSHROOM = BLOCKS.register("potted_black_mushroom", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLACK_MUSHROOM, BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));
	public static final RegistryObject<Block> WHITE_MUSHROOM_BLOCK = register("white_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> WHITE_MUSHROOM = register("white_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.HUGE_WHITE_MUSHROOM) {public PlantType getPlantType(BlockGetter level, BlockPos pos) {return PlantType.CAVE;}});
	public static final RegistryObject<Block> POTTED_WHITE_MUSHROOM = BLOCKS.register("potted_white_mushroom", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_MUSHROOM, BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));
	public static final RegistryObject<Block> THIN_MUSHROOM_STEM = register("thin_mushroom_stem", () -> new ThinMushroomStemBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));

	public static final RegistryObject<Block> ASPEN_LOG = register("aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> ASPEN_WOOD = register("aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = register("stripped_aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = register("stripped_aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> ASPEN_LEAVES = register("aspen_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> ASPEN_SAPLING = register("aspen_sapling", () -> new SaplingBlock(new AspenGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ASPEN_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> ASPEN_PLANKS = register("aspen_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> ASPEN_STAIRS = register("aspen_stairs", () -> new StairBlock(() -> ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> ASPEN_SLAB = register("aspen_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> ASPEN_FENCE = register("aspen_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> ASPEN_FENCE_GATE = register("aspen_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> ASPEN_DOOR = register("aspen_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.ASPEN));
	public static final RegistryObject<Block> ASPEN_TRAPDOOR = register("aspen_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.ASPEN));
	public static final RegistryObject<Block> ASPEN_PRESSURE_PLATE = register("aspen_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.ASPEN));
	public static final RegistryObject<Block> ASPEN_BUTTON = register("aspen_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.ASPEN));
	public static final RegistryObject<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.ASPEN));
	public static final RegistryObject<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.ASPEN));
	public static final RegistryObject<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.ASPEN));
	public static final RegistryObject<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.ASPEN));

	public static final RegistryObject<Block> CAJOLE_LOG = register("cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_CAJOLE_LOG = register("stripped_cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> CAJOLE_WOOD = register("cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_CAJOLE_WOOD = register("stripped_cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> CAJOLE_LEAVES = register("cajole_leaves", () -> new CajoleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> CAJOLE_SAPLING = register("cajole_sapling", () -> new SaplingBlock(new CajoleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> CAJOLE_PLANKS = register("cajole_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> CAJOLE_SLAB = register("cajole_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> CAJOLE_STAIRS = register("cajole_stairs", () -> new StairBlock(() -> CAJOLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> CAJOLE_FENCE = register("cajole_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> CAJOLE_FENCE_GATE = register("cajole_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> CAJOLE_BUTTON = register("cajole_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.CAJOLE));
	public static final RegistryObject<Block> CAJOLE_PRESSURE_PLATE = register("cajole_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.CAJOLE));
	public static final RegistryObject<Block> CAJOLE_DOOR = register("cajole_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.CAJOLE));
	public static final RegistryObject<Block> CAJOLE_TRAPDOOR = register("cajole_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.CAJOLE));

	public static final RegistryObject<Block> DESERT_OAK_LOG = register("desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> DESERT_OAK_WOOD = register("desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_DESERT_OAK_LOG = register("stripped_desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_DESERT_OAK_WOOD = register("stripped_desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> DESERT_OAK_LEAVES = register("desert_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> DESERT_OAK_SAPLING = register("desert_oak_sapling", () -> new SaplingBlock(new DesertOakGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_DESERT_OAK_SAPLING = BLOCKS.register("potted_desert_oak_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DESERT_OAK_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> DESERT_OAK_PLANKS = register("desert_oak_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> DESERT_OAK_STAIRS = register("desert_oak_stairs", () -> new StairBlock(() -> DESERT_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> DESERT_OAK_SLAB = register("desert_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> DESERT_OAK_FENCE = register("desert_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> DESERT_OAK_FENCE_GATE = register("desert_oak_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> DESERT_OAK_DOOR = register("desert_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_TRAPDOOR = register("desert_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_PRESSURE_PLATE = register("desert_oak_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_BUTTON = register("desert_oak_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_SIGN = BLOCKS.register("desert_oak_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_WALL_SIGN = BLOCKS.register("desert_oak_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_HANGING_SIGN = BLOCKS.register("desert_oak_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.DESERT_OAK));
	public static final RegistryObject<Block> DESERT_OAK_WALL_HANGING_SIGN = BLOCKS.register("desert_oak_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.DESERT_OAK));

	public static final RegistryObject<Block> EUCALYPTUS_LOG = register("eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> EUCALYPTUS_WOOD = register("eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_LOG = register("stripped_eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_WOOD = register("stripped_eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> EUCALYPTUS_LEAVES = register("eucalyptus_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> EUCALYPTUS_SAPLING = register("eucalyptus_sapling", () -> new SaplingBlock(new EucalyptusGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_EUCALYPTUS_SAPLING = BLOCKS.register("potted_eucalyptus_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, EUCALYPTUS_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> EUCALYPTUS_PLANKS = register("eucalyptus_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> EUCALYPTUS_STAIRS = register("eucalyptus_stairs", () -> new StairBlock(() -> EUCALYPTUS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> EUCALYPTUS_SLAB = register("eucalyptus_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> EUCALYPTUS_FENCE = register("eucalyptus_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> EUCALYPTUS_FENCE_GATE = register("eucalyptus_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> EUCALYPTUS_DOOR = register("eucalyptus_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_TRAPDOOR = register("eucalyptus_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_PRESSURE_PLATE = register("eucalyptus_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_BUTTON = register("eucalyptus_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_SIGN = BLOCKS.register("eucalyptus_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_WALL_SIGN = BLOCKS.register("eucalyptus_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_HANGING_SIGN = BLOCKS.register("eucalyptus_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.EUCALYPTUS));
	public static final RegistryObject<Block> EUCALYPTUS_WALL_HANGING_SIGN = BLOCKS.register("eucalyptus_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.EUCALYPTUS));

	public static final RegistryObject<Block> KAPOK_LOG = register("kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> KAPOK_WOOD = register("kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_KAPOK_LOG = register("stripped_kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_KAPOK_WOOD = register("stripped_kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> KAPOK_LEAVES = register("kapok_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> KAPOK_SAPLING = register("kapok_sapling", () -> new SaplingBlock(new KapokGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_KAPOK_SAPLING = BLOCKS.register("potted_kapok_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, KAPOK_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> KAPOK_PLANKS = register("kapok_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> KAPOK_STAIRS = register("kapok_stairs", () -> new StairBlock(() -> KAPOK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> KAPOK_SLAB = register("kapok_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> KAPOK_FENCE = register("kapok_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> KAPOK_FENCE_GATE = register("kapok_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> KAPOK_DOOR = register("kapok_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.KAPOK));
	public static final RegistryObject<Block> KAPOK_TRAPDOOR = register("kapok_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.KAPOK));
	public static final RegistryObject<Block> KAPOK_PRESSURE_PLATE = register("kapok_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.KAPOK));
	public static final RegistryObject<Block> KAPOK_BUTTON = register("kapok_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.KAPOK));
	public static final RegistryObject<Block> KAPOK_SIGN = BLOCKS.register("kapok_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.KAPOK));
	public static final RegistryObject<Block> KAPOK_WALL_SIGN = BLOCKS.register("kapok_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.KAPOK));
	public static final RegistryObject<Block> KAPOK_HANGING_SIGN = BLOCKS.register("kapok_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.KAPOK));
	public static final RegistryObject<Block> KAPOK_WALL_HANGING_SIGN = BLOCKS.register("kapok_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.KAPOK));

	public static final RegistryObject<Block> REDWOOD_LOG = register("redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> REDWOOD_WOOD = register("redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = register("stripped_redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = register("stripped_redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> REDWOOD_LEAVES = register("redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> REDWOOD_SAPLING = register("redwood_sapling", () -> new SaplingBlock(new RedwoodGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = BLOCKS.register("potted_redwood_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, REDWOOD_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> REDWOOD_PLANKS = register("redwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> REDWOOD_STAIRS = register("redwood_stairs", () -> new StairBlock(() -> REDWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> REDWOOD_SLAB = register("redwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> REDWOOD_FENCE = register("redwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> REDWOOD_FENCE_GATE = register("redwood_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> REDWOOD_DOOR = register("redwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_TRAPDOOR = register("redwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = register("redwood_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_BUTTON = register("redwood_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_HANGING_SIGN = BLOCKS.register("redwood_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.REDWOOD));
	public static final RegistryObject<Block> REDWOOD_WALL_HANGING_SIGN = BLOCKS.register("redwood_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.REDWOOD));

	public static final RegistryObject<Block> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> WILLOW_WOOD = register("willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = register("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> WILLOW_LEAVES = register("willow_leaves", () -> new WillowLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> WILLOW_SAPLING = register("willow_sapling", () -> new SaplingBlock(new WillowGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WILLOW_SAPLING, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistryObject<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> WILLOW_STAIRS = register("willow_stairs", () -> new StairBlock(() -> WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> WILLOW_SLAB = register("willow_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> WILLOW_FENCE_GATE = register("willow_fence_gate", () -> woodenFenceGate(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)));
	public static final RegistryObject<Block> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.WILLOW));
	public static final RegistryObject<Block> WILLOW_TRAPDOOR = register("willow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.WILLOW));
	public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.WILLOW));
	public static final RegistryObject<Block> WILLOW_BUTTON = register("willow_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.WILLOW));
	public static final RegistryObject<Block> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> sign(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.WILLOW));
	public static final RegistryObject<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> wallSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.WILLOW));
	public static final RegistryObject<Block> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign", () -> hangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.WILLOW));
	public static final RegistryObject<Block> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign", () -> wallHangingSign(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.WILLOW));
	public static final RegistryObject<Block> WILLOW_BRANCH = register("willow_branch", () -> new WillowBranchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> WILLOW_BRANCH_PLANT = register("willow_branch_plant", () -> new WillowBranchPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

	private static Block woodenFenceGate(BlockBehaviour.Properties properties) {
		return new FenceGateBlock(properties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
	}
	private static Block woodenButton(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new ButtonBlock(properties, blockSetType, 15, true);
	}
	private static Block woodenPressurePlate(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties, blockSetType);
	}

	private static Block sign(BlockBehaviour.Properties properties, WoodType woodType) {
		return new StandingSignBlock(properties, woodType) {
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new SBSignBlockEntity(pos, state);
			}
		};
	}
	private static Block wallSign(BlockBehaviour.Properties properties, WoodType woodType) {
		return new WallSignBlock(properties, woodType) {
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new SBSignBlockEntity(pos, state);
			}
		};
	}
	private static Block hangingSign(BlockBehaviour.Properties properties, WoodType woodType) {
		return new CeilingHangingSignBlock(properties, woodType) {
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new SBHangingSignBlockEntity(pos, state);
			}
		};
	}
	private static Block wallHangingSign(BlockBehaviour.Properties properties, WoodType woodType) {
		return new WallHangingSignBlock(properties, woodType) {
			public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
				return new SBHangingSignBlockEntity(pos, state);
			}
		};
	}

	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
		RegistryObject<T> block = BLOCKS.register(name, supplier);
		SBItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}
}
