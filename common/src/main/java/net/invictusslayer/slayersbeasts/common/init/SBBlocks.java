package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.*;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.SBTreeGrowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class SBBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.BLOCK);
	
//	public static final RegistrySupplier<Block> SEPULCHRA_PORTAL = BLOCKS.register("sepulchra_portal", () -> new SepulchraPortalBlock(Block.Properties.ofFullCopy(Blocks.NETHER_PORTAL).noLootTable()));

	public static final RegistrySupplier<Block> CRYPT_PORTAL = BLOCKS.register("crypt_portal", () -> new CryptPortalBlock(Block.Properties.ofFullCopy(Blocks.END_PORTAL).mapColor(MapColor.QUARTZ).noLootTable()));
	public static final RegistrySupplier<Block> CRYPTALITH = register("cryptalith", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));
	public static final RegistrySupplier<Block> INFUSED_CRYPTALITH = register("infused_cryptalith", () -> new InfusedCryptalithBlock(BlockBehaviour.Properties.ofFullCopy(CRYPTALITH.get()).strength(55F, 3600000F).lightLevel(state -> 1)));
	public static final RegistrySupplier<Block> DEPLETED_CRYPTALITH = register("depleted_cryptalith", () -> new DepletedCryptalithBlock(BlockBehaviour.Properties.ofFullCopy(CRYPTALITH.get()).strength(55F, 3600000F)));

	public static final RegistrySupplier<Block> JADE_BLOCK = register("jade_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).strength(9f)));

	public static final RegistrySupplier<Block> EXOSKELETON_ORE = register("exoskeleton_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(15f).requiresCorrectToolForDrops()));
	public static final RegistrySupplier<Block> DEEPSLATE_EXOSKELETON_ORE = register("deepslate_exoskeleton_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).strength(25f).requiresCorrectToolForDrops()));

	public static final RegistrySupplier<Block> STYPHIUM = register("styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
	public static final RegistrySupplier<Block> DEEPSLATE_STYPHIUM = register("deepslate_styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

	public static final RegistrySupplier<Block> RUDOSOL = register("rudosol", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistrySupplier<Block> ARIDISOL = register("aridisol", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistrySupplier<Block> ANTHILL = register("anthill", () -> new AnthillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final RegistrySupplier<Block> ANTHILL_HATCHERY = register("anthill_hatchery", () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).strength(1f)));

	public static final RegistrySupplier<Block> OOTHECA = register("ootheca", () -> new OothecaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).strength(1f).noLootTable()));

	public static final RegistrySupplier<Block> GLEAMING_ICE = register("gleaming_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).lightLevel(state -> 7)));
	public static final RegistrySupplier<Block> ICICLE = register("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.ICE).sound(SoundType.GLASS)));
	public static final RegistrySupplier<Block> OBSIDIAN_SPIKE = register("obsidian_spike", () -> new ObsidianSpikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.COLOR_BLACK).strength(50.0F, 1200.0F)));

	public static final RegistrySupplier<Block> TALL_DEAD_BUSH = register("tall_dead_bush", () -> new TallDeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH)));
	public static final RegistrySupplier<Block> CRACKED_MUD = register("cracked_mud", () -> new CrackedMudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)));
	public static final RegistrySupplier<Block> PEAT = register("peat", () -> new PeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POWDER_SNOW).mapColor(MapColor.TERRACOTTA_BLACK).strength(1F).sound(SoundType.MUD).forceSolidOn().pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> ALGAE = BLOCKS.register("algae", () -> new AlgaeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).noCollission()));

	public static final RegistrySupplier<Block> PEGMATITE = register("pegmatite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final RegistrySupplier<Block> PEGMATITE_SLAB = register("pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get())));
	public static final RegistrySupplier<Block> PEGMATITE_STAIRS = register("pegmatite_stairs", () -> new StairBlock(PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get())));
	public static final RegistrySupplier<Block> PEGMATITE_WALL = register("pegmatite_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get()).forceSolidOn()));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE = register("polished_pegmatite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE_SLAB = register("polished_pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_PEGMATITE.get())));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE_STAIRS = register("polished_pegmatite_stairs", () -> new StairBlock(POLISHED_PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_PEGMATITE.get())));

	public static final RegistrySupplier<Block> BLACK_SAND = register("black_sand", () -> new ColoredFallingBlock(new ColorRGBA(3748886), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE = register("black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_SLAB = register("black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_STAIRS = register("black_sandstone_stairs", () -> new StairBlock(BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_WALL = register("black_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_WALL).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE = register("smooth_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE_SLAB = register("smooth_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = register("smooth_black_sandstone_stairs", () -> new StairBlock(SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CUT_BLACK_SANDSTONE = register("cut_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CUT_BLACK_SANDSTONE_SLAB = register("cut_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CHISELED_BLACK_SANDSTONE = register("chiseled_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));

	public static final RegistrySupplier<Block> TALL_BROWN_MUSHROOM = register("tall_brown_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_BROWN_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> TALL_RED_MUSHROOM = register("tall_red_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_RED_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> BLACK_MUSHROOM_BLOCK = register("black_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final RegistrySupplier<Block> BLACK_MUSHROOM = register("black_mushroom", () -> new MushroomBlock(SBConfiguredFeatures.HUGE_BLACK_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> POTTED_BLACK_MUSHROOM = BLOCKS.register("potted_black_mushroom", () -> new FlowerPotBlock(BLACK_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)));
	public static final RegistrySupplier<Block> TALL_BLACK_MUSHROOM = register("tall_black_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_BLACK_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> WHITE_MUSHROOM_BLOCK = register("white_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final RegistrySupplier<Block> WHITE_MUSHROOM = register("white_mushroom", () -> new MushroomBlock(SBConfiguredFeatures.HUGE_WHITE_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> POTTED_WHITE_MUSHROOM = BLOCKS.register("potted_white_mushroom", () -> new FlowerPotBlock(WHITE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM)));
	public static final RegistrySupplier<Block> TALL_WHITE_MUSHROOM = register("tall_white_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_WHITE_MUSHROOM, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
//	public static final RegistrySupplier<Block> THIN_MUSHROOM_STEM = register("thin_mushroom_stem", () -> new ThinMushroomStemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM)));

	public static final RegistrySupplier<Block> ASPEN_LOG = register("aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> ASPEN_WOOD = register("aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_ASPEN_LOG = register("stripped_aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_ASPEN_WOOD = register("stripped_aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> ASPEN_LEAVES = register("aspen_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> ASPEN_SAPLING = register("aspen_sapling", () -> new SaplingBlock(SBTreeGrowers.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> new FlowerPotBlock(ASPEN_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> ASPEN_PLANKS = register("aspen_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> ASPEN_STAIRS = register("aspen_stairs", () -> new StairBlock(ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> ASPEN_SLAB = register("aspen_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> ASPEN_FENCE = register("aspen_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> ASPEN_FENCE_GATE = register("aspen_fence_gate", () -> new FenceGateBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> ASPEN_DOOR = register("aspen_door", () -> new DoorBlock(SBBlockSetType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> ASPEN_TRAPDOOR = register("aspen_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> ASPEN_PRESSURE_PLATE = register("aspen_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.ASPEN));
	public static final RegistrySupplier<Block> ASPEN_BUTTON = register("aspen_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.ASPEN));
	public static final RegistrySupplier<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> new StandingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> new WallSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

	public static final RegistrySupplier<Block> CAJOLE_LOG = register("cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_CAJOLE_LOG = register("stripped_cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> CAJOLE_WOOD = register("cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_CAJOLE_WOOD = register("stripped_cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> CAJOLE_LEAVES = register("cajole_leaves", () -> new CajoleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> CAJOLE_SAPLING = register("cajole_sapling", () -> new SaplingBlock(SBTreeGrowers.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> CAJOLE_PLANKS = register("cajole_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> CAJOLE_SLAB = register("cajole_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> CAJOLE_STAIRS = register("cajole_stairs", () -> new StairBlock(CAJOLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> CAJOLE_FENCE = register("cajole_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> CAJOLE_FENCE_GATE = register("cajole_fence_gate", () -> new FenceGateBlock(SBWoodType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> CAJOLE_BUTTON = register("cajole_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.CAJOLE));
	public static final RegistrySupplier<Block> CAJOLE_PRESSURE_PLATE = register("cajole_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.CAJOLE));
	public static final RegistrySupplier<Block> CAJOLE_DOOR = register("cajole_door", () -> new DoorBlock(SBBlockSetType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> CAJOLE_TRAPDOOR = register("cajole_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

	public static final RegistrySupplier<Block> DESERT_OAK_LOG = register("desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> DESERT_OAK_WOOD = register("desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_DESERT_OAK_LOG = register("stripped_desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_DESERT_OAK_WOOD = register("stripped_desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> DESERT_OAK_LEAVES = register("desert_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> DESERT_OAK_SAPLING = register("desert_oak_sapling", () -> new SaplingBlock(SBTreeGrowers.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_DESERT_OAK_SAPLING = BLOCKS.register("potted_desert_oak_sapling", () -> new FlowerPotBlock(DESERT_OAK_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> DESERT_OAK_PLANKS = register("desert_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> DESERT_OAK_STAIRS = register("desert_oak_stairs", () -> new StairBlock(DESERT_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> DESERT_OAK_SLAB = register("desert_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> DESERT_OAK_FENCE = register("desert_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> DESERT_OAK_FENCE_GATE = register("desert_oak_fence_gate", () -> new FenceGateBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> DESERT_OAK_DOOR = register("desert_oak_door", () -> new DoorBlock(SBBlockSetType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> DESERT_OAK_TRAPDOOR = register("desert_oak_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> DESERT_OAK_PRESSURE_PLATE = register("desert_oak_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.DESERT_OAK));
	public static final RegistrySupplier<Block> DESERT_OAK_BUTTON = register("desert_oak_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.DESERT_OAK));
	public static final RegistrySupplier<Block> DESERT_OAK_SIGN = BLOCKS.register("desert_oak_sign", () -> new StandingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> DESERT_OAK_WALL_SIGN = BLOCKS.register("desert_oak_wall_sign", () -> new WallSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> DESERT_OAK_HANGING_SIGN = BLOCKS.register("desert_oak_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> DESERT_OAK_WALL_HANGING_SIGN = BLOCKS.register("desert_oak_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

	public static final RegistrySupplier<Block> EUCALYPTUS_LOG = register("eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> EUCALYPTUS_WOOD = register("eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_EUCALYPTUS_LOG = register("stripped_eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_EUCALYPTUS_WOOD = register("stripped_eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> EUCALYPTUS_LEAVES = register("eucalyptus_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> EUCALYPTUS_SAPLING = register("eucalyptus_sapling", () -> new SaplingBlock(SBTreeGrowers.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_EUCALYPTUS_SAPLING = BLOCKS.register("potted_eucalyptus_sapling", () -> new FlowerPotBlock(EUCALYPTUS_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> EUCALYPTUS_PLANKS = register("eucalyptus_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> EUCALYPTUS_STAIRS = register("eucalyptus_stairs", () -> new StairBlock(EUCALYPTUS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> EUCALYPTUS_SLAB = register("eucalyptus_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> EUCALYPTUS_FENCE = register("eucalyptus_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> EUCALYPTUS_FENCE_GATE = register("eucalyptus_fence_gate", () -> new FenceGateBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> EUCALYPTUS_DOOR = register("eucalyptus_door", () -> new DoorBlock(SBBlockSetType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> EUCALYPTUS_TRAPDOOR = register("eucalyptus_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> EUCALYPTUS_PRESSURE_PLATE = register("eucalyptus_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.EUCALYPTUS));
	public static final RegistrySupplier<Block> EUCALYPTUS_BUTTON = register("eucalyptus_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.EUCALYPTUS));
	public static final RegistrySupplier<Block> EUCALYPTUS_SIGN = BLOCKS.register("eucalyptus_sign", () -> new StandingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> EUCALYPTUS_WALL_SIGN = BLOCKS.register("eucalyptus_wall_sign", () -> new WallSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> EUCALYPTUS_HANGING_SIGN = BLOCKS.register("eucalyptus_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> EUCALYPTUS_WALL_HANGING_SIGN = BLOCKS.register("eucalyptus_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

	public static final RegistrySupplier<Block> KAPOK_LOG = register("kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> KAPOK_WOOD = register("kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_KAPOK_LOG = register("stripped_kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_KAPOK_WOOD = register("stripped_kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> KAPOK_LEAVES = register("kapok_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> KAPOK_SAPLING = register("kapok_sapling", () -> new SaplingBlock(SBTreeGrowers.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_KAPOK_SAPLING = BLOCKS.register("potted_kapok_sapling", () -> new FlowerPotBlock(KAPOK_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> KAPOK_PLANKS = register("kapok_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> KAPOK_STAIRS = register("kapok_stairs", () -> new StairBlock(KAPOK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> KAPOK_SLAB = register("kapok_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> KAPOK_FENCE = register("kapok_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> KAPOK_FENCE_GATE = register("kapok_fence_gate", () -> new FenceGateBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> KAPOK_DOOR = register("kapok_door", () -> new DoorBlock(SBBlockSetType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> KAPOK_TRAPDOOR = register("kapok_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> KAPOK_PRESSURE_PLATE = register("kapok_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.KAPOK));
	public static final RegistrySupplier<Block> KAPOK_BUTTON = register("kapok_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.KAPOK));
	public static final RegistrySupplier<Block> KAPOK_SIGN = BLOCKS.register("kapok_sign", () -> new StandingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> KAPOK_WALL_SIGN = BLOCKS.register("kapok_wall_sign", () -> new WallSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> KAPOK_HANGING_SIGN = BLOCKS.register("kapok_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> KAPOK_WALL_HANGING_SIGN = BLOCKS.register("kapok_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

	public static final RegistrySupplier<Block> REDWOOD_LOG = register("redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> REDWOOD_WOOD = register("redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_REDWOOD_LOG = register("stripped_redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_REDWOOD_WOOD = register("stripped_redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> REDWOOD_LEAVES = register("redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> REDWOOD_SAPLING = register("redwood_sapling", () -> new SaplingBlock(SBTreeGrowers.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_REDWOOD_SAPLING = BLOCKS.register("potted_redwood_sapling", () -> new FlowerPotBlock(REDWOOD_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> REDWOOD_PLANKS = register("redwood_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> REDWOOD_STAIRS = register("redwood_stairs", () -> new StairBlock(REDWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> REDWOOD_SLAB = register("redwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> REDWOOD_FENCE = register("redwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> REDWOOD_FENCE_GATE = register("redwood_fence_gate", () -> new FenceGateBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> REDWOOD_DOOR = register("redwood_door", () -> new DoorBlock(SBBlockSetType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> REDWOOD_TRAPDOOR = register("redwood_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> REDWOOD_PRESSURE_PLATE = register("redwood_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.REDWOOD));
	public static final RegistrySupplier<Block> REDWOOD_BUTTON = register("redwood_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.REDWOOD));
	public static final RegistrySupplier<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign", () -> new StandingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign", () -> new WallSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> REDWOOD_HANGING_SIGN = BLOCKS.register("redwood_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> REDWOOD_WALL_HANGING_SIGN = BLOCKS.register("redwood_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
	public static final RegistrySupplier<Block> ALBINO_REDWOOD_LEAVES = register("albino_redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> ALBINO_REDWOOD_SAPLING = register("albino_redwood_sapling", () -> new SaplingBlock(SBTreeGrowers.ALBINO_REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_ALBINO_REDWOOD_SAPLING = BLOCKS.register("potted_albino_redwood_sapling", () -> new FlowerPotBlock(ALBINO_REDWOOD_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));

	public static final RegistrySupplier<Block> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
	public static final RegistrySupplier<Block> WILLOW_WOOD = register("willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
	public static final RegistrySupplier<Block> STRIPPED_WILLOW_LOG = register("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
	public static final RegistrySupplier<Block> STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistrySupplier<Block> WILLOW_LEAVES = register("willow_leaves", () -> new WillowLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));
	public static final RegistrySupplier<Block> WILLOW_SAPLING = register("willow_sapling", () -> new SaplingBlock(SBTreeGrowers.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
	public static final RegistrySupplier<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling", () -> new FlowerPotBlock(WILLOW_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING)));
	public static final RegistrySupplier<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
	public static final RegistrySupplier<Block> WILLOW_STAIRS = register("willow_stairs", () -> new StairBlock(WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
	public static final RegistrySupplier<Block> WILLOW_SLAB = register("willow_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
	public static final RegistrySupplier<Block> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
	public static final RegistrySupplier<Block> WILLOW_FENCE_GATE = register("willow_fence_gate", () -> new FenceGateBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));
	public static final RegistrySupplier<Block> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(SBBlockSetType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
	public static final RegistrySupplier<Block> WILLOW_TRAPDOOR = register("willow_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));
	public static final RegistrySupplier<Block> WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.WILLOW));
	public static final RegistrySupplier<Block> WILLOW_BUTTON = register("willow_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON), SBBlockSetType.WILLOW));
	public static final RegistrySupplier<Block> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> new StandingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));
	public static final RegistrySupplier<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> new WallSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));
	public static final RegistrySupplier<Block> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));
	public static final RegistrySupplier<Block> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));
	public static final RegistrySupplier<Block> WILLOW_BRANCH = register("willow_branch", () -> new WillowBranchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> WILLOW_BRANCH_PLANT = register("willow_branch_plant", () -> new WillowBranchPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

	private static Block woodenButton(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new ButtonBlock(blockSetType, 15, properties);
	}

	private static Block woodenPressurePlate(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new PressurePlateBlock(blockSetType, properties);
	}

	private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
		RegistrySupplier<T> block = BLOCKS.register(name, supplier);
		SBItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}
}
