package net.invictusslayer.slayersbeasts.common.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.*;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.grower.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class SBBlocks {
//	public static final Supplier<Block> SEPULCHRA_PORTAL = registerBlock("sepulchra_portal", () -> new SepulchraPortalBlock(Block.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

	public static final Supplier<Block> CRYPT_PORTAL = registerBlock("crypt_portal", () -> new CryptPortalBlock(Block.Properties.copy(Blocks.END_PORTAL).mapColor(MapColor.QUARTZ).noLootTable()));
	public static final Supplier<Block> CRYPTALITH = registerBlockItem("cryptalith", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
	public static final Supplier<Block> INFUSED_CRYPTALITH = registerBlockItem("infused_cryptalith", () -> new InfusedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F).lightLevel(state -> 1)));
	public static final Supplier<Block> DEPLETED_CRYPTALITH = registerBlockItem("depleted_cryptalith", () -> new DepletedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F)));

	public static final Supplier<Block> JADE_BLOCK = registerBlockItem("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(9f)));

	public static final Supplier<Block> EXOSKELETON_ORE = registerBlockItem("exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(15f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
	public static final Supplier<Block> DEEPSLATE_EXOSKELETON_ORE = registerBlockItem("deepslate_exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(25f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

	public static final Supplier<Block> STYPHIUM = registerBlockItem("styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
	public static final Supplier<Block> DEEPSLATE_STYPHIUM = registerBlockItem("deepslate_styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));

	public static final Supplier<Block> RUDOSOL = registerBlockItem("rudosol", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final Supplier<Block> ARIDISOL = registerBlockItem("aridisol", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final Supplier<Block> ANTHILL = registerBlockItem("anthill", () -> new AnthillBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
	public static final Supplier<Block> ANTHILL_HATCHERY = registerBlockItem("anthill_hatchery", () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));

	public static final Supplier<Block> OOTHECA = registerBlockItem("ootheca", () -> new OothecaBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).strength(1f).noLootTable()));

	public static final Supplier<Block> GLEAMING_ICE = registerBlockItem("gleaming_ice", () -> new Block(BlockBehaviour.Properties.copy(Blocks.PACKED_ICE).lightLevel(state -> 7)));
	public static final Supplier<Block> ICICLE = registerBlockItem("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.ICE).sound(SoundType.GLASS)));
	public static final Supplier<Block> OBSIDIAN_SPIKE = registerBlockItem("obsidian_spike", () -> new ObsidianSpikeBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.COLOR_BLACK).strength(50.0F, 1200.0F)));

	public static final Supplier<Block> TALL_DEAD_BUSH = registerBlockItem("tall_dead_bush", () -> new TallDeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
	public static final Supplier<Block> CRACKED_MUD = registerBlockItem("cracked_mud", () -> new CrackedMudBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));
	public static final Supplier<Block> PEAT = registerBlockItem("peat", () -> new PeatBlock(BlockBehaviour.Properties.copy(Blocks.POWDER_SNOW).mapColor(MapColor.TERRACOTTA_BLACK).strength(1F).sound(SoundType.MUD).forceSolidOn().pushReaction(PushReaction.DESTROY)));
	public static final Supplier<Block> ALGAE = registerWaterBlockItem("algae", () -> new AlgaeBlock(BlockBehaviour.Properties.copy(Blocks.LILY_PAD).noCollission()));

	public static final Supplier<Block> PEGMATITE = registerBlockItem("pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final Supplier<Block> PEGMATITE_SLAB = registerBlockItem("pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEGMATITE.get())));
	public static final Supplier<Block> PEGMATITE_STAIRS = registerBlockItem("pegmatite_stairs", () -> new StairBlock(PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEGMATITE.get())));
	public static final Supplier<Block> PEGMATITE_WALL = registerBlockItem("pegmatite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(PEGMATITE.get()).forceSolidOn()));
	public static final Supplier<Block> POLISHED_PEGMATITE = registerBlockItem("polished_pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
	public static final Supplier<Block> POLISHED_PEGMATITE_SLAB = registerBlockItem("polished_pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));
	public static final Supplier<Block> POLISHED_PEGMATITE_STAIRS = registerBlockItem("polished_pegmatite_stairs", () -> new StairBlock(POLISHED_PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));

	public static final Supplier<Block> BLACK_SAND = registerBlockItem("black_sand", () -> new SandBlock(3748886, BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> BLACK_SANDSTONE = registerBlockItem("black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> BLACK_SANDSTONE_SLAB = registerBlockItem("black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> BLACK_SANDSTONE_STAIRS = registerBlockItem("black_sandstone_stairs", () -> new StairBlock(BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> BLACK_SANDSTONE_WALL = registerBlockItem("black_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> SMOOTH_BLACK_SANDSTONE = registerBlockItem("smooth_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> SMOOTH_BLACK_SANDSTONE_SLAB = registerBlockItem("smooth_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = registerBlockItem("smooth_black_sandstone_stairs", () -> new StairBlock(SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> CUT_BLACK_SANDSTONE = registerBlockItem("cut_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> CUT_BLACK_SANDSTONE_SLAB = registerBlockItem("cut_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
	public static final Supplier<Block> CHISELED_BLACK_SANDSTONE = registerBlockItem("chiseled_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));

	public static final Supplier<Block> TALL_BROWN_MUSHROOM = registerBlockItem("tall_brown_mushroom", () -> new TallMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.BRANCHING_BROWN_MUSHROOM));
	public static final Supplier<Block> TALL_RED_MUSHROOM = registerBlockItem("tall_red_mushroom", () -> new TallMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.BRANCHING_RED_MUSHROOM));
	public static final Supplier<Block> BLACK_MUSHROOM_BLOCK = registerBlockItem("black_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final Supplier<Block> BLACK_MUSHROOM = registerBlockItem("black_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.HUGE_BLACK_MUSHROOM));
	public static final Supplier<Block> POTTED_BLACK_MUSHROOM = registerBlock("potted_black_mushroom", () -> new FlowerPotBlock(BLACK_MUSHROOM.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));
	public static final Supplier<Block> TALL_BLACK_MUSHROOM = registerBlockItem("tall_black_mushroom", () -> new TallMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.BRANCHING_BLACK_MUSHROOM));
	public static final Supplier<Block> WHITE_MUSHROOM_BLOCK = registerBlockItem("white_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final Supplier<Block> WHITE_MUSHROOM = registerBlockItem("white_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.HUGE_WHITE_MUSHROOM));
	public static final Supplier<Block> POTTED_WHITE_MUSHROOM = registerBlock("potted_white_mushroom", () -> new FlowerPotBlock(WHITE_MUSHROOM.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_RED_MUSHROOM)));
	public static final Supplier<Block> TALL_WHITE_MUSHROOM = registerBlockItem("tall_white_mushroom", () -> new TallMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY), SBConfiguredFeatures.BRANCHING_WHITE_MUSHROOM));
//	public static final Supplier<Block> THIN_MUSHROOM_STEM = registerBlockItem("thin_mushroom_stem", () -> new ThinMushroomStemBlock(BlockBehaviour.Properties.copy(Blocks.MUSHROOM_STEM)));

	public static final Supplier<Block> ASPEN_LOG = registerBlockItem("aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> ASPEN_WOOD = registerBlockItem("aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_ASPEN_LOG = registerBlockItem("stripped_aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_ASPEN_WOOD = registerBlockItem("stripped_aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> ASPEN_LEAVES = registerBlockItem("aspen_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> ASPEN_SAPLING = registerBlockItem("aspen_sapling", () -> new SaplingBlock(new AspenGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_ASPEN_SAPLING = registerBlock("potted_aspen_sapling", () -> new FlowerPotBlock(ASPEN_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> ASPEN_PLANKS = registerBlockItem("aspen_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> ASPEN_STAIRS = registerBlockItem("aspen_stairs", () -> new StairBlock(ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> ASPEN_SLAB = registerBlockItem("aspen_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> ASPEN_FENCE = registerBlockItem("aspen_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> ASPEN_FENCE_GATE = registerBlockItem("aspen_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.ASPEN));
	public static final Supplier<Block> ASPEN_DOOR = registerBlockItem("aspen_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.ASPEN));
	public static final Supplier<Block> ASPEN_TRAPDOOR = registerBlockItem("aspen_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.ASPEN));
	public static final Supplier<Block> ASPEN_PRESSURE_PLATE = registerBlockItem("aspen_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.ASPEN));
	public static final Supplier<Block> ASPEN_BUTTON = registerBlockItem("aspen_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.ASPEN));
	public static final Supplier<Block> ASPEN_SIGN = registerBlock("aspen_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.ASPEN));
	public static final Supplier<Block> ASPEN_WALL_SIGN = registerBlock("aspen_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.ASPEN));
	public static final Supplier<Block> ASPEN_HANGING_SIGN = registerBlock("aspen_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.ASPEN));
	public static final Supplier<Block> ASPEN_WALL_HANGING_SIGN = registerBlock("aspen_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.ASPEN));

	public static final Supplier<Block> BLOODWOOD_LOG = registerBlockItem("bloodwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> BLOODWOOD_WOOD = registerBlockItem("bloodwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_BLOODWOOD_LOG = registerBlockItem("stripped_bloodwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_BLOODWOOD_WOOD = registerBlockItem("stripped_bloodwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> BLOODWOOD_LEAVES = registerBlockItem("bloodwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> BLOODWOOD_SAPLING = registerBlockItem("bloodwood_sapling", () -> new SaplingBlock(new BloodwoodGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_BLOODWOOD_SAPLING = registerBlock("potted_bloodwood_sapling", () -> new FlowerPotBlock(BLOODWOOD_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> BLOODWOOD_PLANKS = registerBlockItem("bloodwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> BLOODWOOD_STAIRS = registerBlockItem("bloodwood_stairs", () -> new StairBlock(BLOODWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> BLOODWOOD_SLAB = registerBlockItem("bloodwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> BLOODWOOD_FENCE = registerBlockItem("bloodwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> BLOODWOOD_FENCE_GATE = registerBlockItem("bloodwood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_DOOR = registerBlockItem("bloodwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_TRAPDOOR = registerBlockItem("bloodwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_PRESSURE_PLATE = registerBlockItem("bloodwood_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_BUTTON = registerBlockItem("bloodwood_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_SIGN = registerBlock("bloodwood_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_WALL_SIGN = registerBlock("bloodwood_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_HANGING_SIGN = registerBlock("bloodwood_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.BLOODWOOD));
	public static final Supplier<Block> BLOODWOOD_WALL_HANGING_SIGN = registerBlock("bloodwood_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.BLOODWOOD));

	public static final Supplier<Block> CAJOLE_LOG = registerBlockItem("cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> STRIPPED_CAJOLE_LOG = registerBlockItem("stripped_cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> CAJOLE_WOOD = registerBlockItem("cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_CAJOLE_WOOD = registerBlockItem("stripped_cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> CAJOLE_LEAVES = registerBlockItem("cajole_leaves", () -> new CajoleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> CAJOLE_SAPLING = registerBlockItem("cajole_sapling", () -> new SaplingBlock(new CajoleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_CAJOLE_SAPLING = registerBlock("potted_cajole_sapling", () -> new FlowerPotBlock(CAJOLE_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> CAJOLE_PLANKS = registerBlockItem("cajole_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> CAJOLE_SLAB = registerBlockItem("cajole_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> CAJOLE_STAIRS = registerBlockItem("cajole_stairs", () -> new StairBlock(CAJOLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> CAJOLE_FENCE = registerBlockItem("cajole_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> CAJOLE_FENCE_GATE = registerBlockItem("cajole_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.CAJOLE));
	public static final Supplier<Block> CAJOLE_BUTTON = registerBlockItem("cajole_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.CAJOLE));
	public static final Supplier<Block> CAJOLE_PRESSURE_PLATE = registerBlockItem("cajole_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.CAJOLE));
	public static final Supplier<Block> CAJOLE_DOOR = registerBlockItem("cajole_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.CAJOLE));
	public static final Supplier<Block> CAJOLE_TRAPDOOR = registerBlockItem("cajole_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.CAJOLE));

	public static final Supplier<Block> CYPRESS_LOG = registerBlockItem("cypress_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> CYPRESS_WOOD = registerBlockItem("cypress_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_CYPRESS_LOG = registerBlockItem("stripped_cypress_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_CYPRESS_WOOD = registerBlockItem("stripped_cypress_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> CYPRESS_LEAVES = registerBlockItem("cypress_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> CYPRESS_SAPLING = registerBlockItem("cypress_sapling", () -> new SaplingBlock(new CypressGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_CYPRESS_SAPLING = registerBlock("potted_cypress_sapling", () -> new FlowerPotBlock(CYPRESS_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> CYPRESS_PLANKS = registerBlockItem("cypress_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> CYPRESS_STAIRS = registerBlockItem("cypress_stairs", () -> new StairBlock(CYPRESS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> CYPRESS_SLAB = registerBlockItem("cypress_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> CYPRESS_FENCE = registerBlockItem("cypress_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> CYPRESS_FENCE_GATE = registerBlockItem("cypress_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.CYPRESS));
	public static final Supplier<Block> CYPRESS_DOOR = registerBlockItem("cypress_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.CYPRESS));
	public static final Supplier<Block> CYPRESS_TRAPDOOR = registerBlockItem("cypress_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.CYPRESS));
	public static final Supplier<Block> CYPRESS_PRESSURE_PLATE = registerBlockItem("cypress_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.CYPRESS));
	public static final Supplier<Block> CYPRESS_BUTTON = registerBlockItem("cypress_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.CYPRESS));
	public static final Supplier<Block> CYPRESS_SIGN = registerBlock("cypress_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.CYPRESS));
	public static final Supplier<Block> CYPRESS_WALL_SIGN = registerBlock("cypress_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.CYPRESS));
	public static final Supplier<Block> CYPRESS_HANGING_SIGN = registerBlock("cypress_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.CYPRESS));
	public static final Supplier<Block> CYPRESS_WALL_HANGING_SIGN = registerBlock("cypress_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.CYPRESS));

	public static final Supplier<Block> DESERT_OAK_LOG = registerBlockItem("desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> DESERT_OAK_WOOD = registerBlockItem("desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_DESERT_OAK_LOG = registerBlockItem("stripped_desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_DESERT_OAK_WOOD = registerBlockItem("stripped_desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> DESERT_OAK_LEAVES = registerBlockItem("desert_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> DESERT_OAK_SAPLING = registerBlockItem("desert_oak_sapling", () -> new SaplingBlock(new DesertOakGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_DESERT_OAK_SAPLING = registerBlock("potted_desert_oak_sapling", () -> new FlowerPotBlock(DESERT_OAK_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> DESERT_OAK_PLANKS = registerBlockItem("desert_oak_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> DESERT_OAK_STAIRS = registerBlockItem("desert_oak_stairs", () -> new StairBlock(DESERT_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> DESERT_OAK_SLAB = registerBlockItem("desert_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> DESERT_OAK_FENCE = registerBlockItem("desert_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> DESERT_OAK_FENCE_GATE = registerBlockItem("desert_oak_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_DOOR = registerBlockItem("desert_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_TRAPDOOR = registerBlockItem("desert_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_PRESSURE_PLATE = registerBlockItem("desert_oak_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_BUTTON = registerBlockItem("desert_oak_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_SIGN = registerBlock("desert_oak_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_WALL_SIGN = registerBlock("desert_oak_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_HANGING_SIGN = registerBlock("desert_oak_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.DESERT_OAK));
	public static final Supplier<Block> DESERT_OAK_WALL_HANGING_SIGN = registerBlock("desert_oak_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.DESERT_OAK));

	public static final Supplier<Block> EUCALYPTUS_LOG = registerBlockItem("eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> EUCALYPTUS_WOOD = registerBlockItem("eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_EUCALYPTUS_LOG = registerBlockItem("stripped_eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_EUCALYPTUS_WOOD = registerBlockItem("stripped_eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> EUCALYPTUS_LEAVES = registerBlockItem("eucalyptus_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> EUCALYPTUS_SAPLING = registerBlockItem("eucalyptus_sapling", () -> new SaplingBlock(new EucalyptusGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_EUCALYPTUS_SAPLING = registerBlock("potted_eucalyptus_sapling", () -> new FlowerPotBlock(EUCALYPTUS_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> EUCALYPTUS_PLANKS = registerBlockItem("eucalyptus_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> EUCALYPTUS_STAIRS = registerBlockItem("eucalyptus_stairs", () -> new StairBlock(EUCALYPTUS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> EUCALYPTUS_SLAB = registerBlockItem("eucalyptus_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> EUCALYPTUS_FENCE = registerBlockItem("eucalyptus_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> EUCALYPTUS_FENCE_GATE = registerBlockItem("eucalyptus_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_DOOR = registerBlockItem("eucalyptus_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_TRAPDOOR = registerBlockItem("eucalyptus_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_PRESSURE_PLATE = registerBlockItem("eucalyptus_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_BUTTON = registerBlockItem("eucalyptus_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_SIGN = registerBlock("eucalyptus_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_WALL_SIGN = registerBlock("eucalyptus_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_HANGING_SIGN = registerBlock("eucalyptus_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.EUCALYPTUS));
	public static final Supplier<Block> EUCALYPTUS_WALL_HANGING_SIGN = registerBlock("eucalyptus_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.EUCALYPTUS));

	public static final Supplier<Block> KAPOK_LOG = registerBlockItem("kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> KAPOK_WOOD = registerBlockItem("kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_KAPOK_LOG = registerBlockItem("stripped_kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_KAPOK_WOOD = registerBlockItem("stripped_kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> KAPOK_LEAVES = registerBlockItem("kapok_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> KAPOK_SAPLING = registerBlockItem("kapok_sapling", () -> new SaplingBlock(new KapokGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_KAPOK_SAPLING = registerBlock("potted_kapok_sapling", () -> new FlowerPotBlock(KAPOK_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> KAPOK_PLANKS = registerBlockItem("kapok_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> KAPOK_STAIRS = registerBlockItem("kapok_stairs", () -> new StairBlock(KAPOK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> KAPOK_SLAB = registerBlockItem("kapok_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> KAPOK_FENCE = registerBlockItem("kapok_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> KAPOK_FENCE_GATE = registerBlockItem("kapok_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.KAPOK));
	public static final Supplier<Block> KAPOK_DOOR = registerBlockItem("kapok_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.KAPOK));
	public static final Supplier<Block> KAPOK_TRAPDOOR = registerBlockItem("kapok_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.KAPOK));
	public static final Supplier<Block> KAPOK_PRESSURE_PLATE = registerBlockItem("kapok_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.KAPOK));
	public static final Supplier<Block> KAPOK_BUTTON = registerBlockItem("kapok_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.KAPOK));
	public static final Supplier<Block> KAPOK_SIGN = registerBlock("kapok_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.KAPOK));
	public static final Supplier<Block> KAPOK_WALL_SIGN = registerBlock("kapok_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.KAPOK));
	public static final Supplier<Block> KAPOK_HANGING_SIGN = registerBlock("kapok_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.KAPOK));
	public static final Supplier<Block> KAPOK_WALL_HANGING_SIGN = registerBlock("kapok_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.KAPOK));

	public static final Supplier<Block> REDWOOD_LOG = registerBlockItem("redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> REDWOOD_WOOD = registerBlockItem("redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_REDWOOD_LOG = registerBlockItem("stripped_redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_REDWOOD_WOOD = registerBlockItem("stripped_redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> REDWOOD_LEAVES = registerBlockItem("redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> REDWOOD_SAPLING = registerBlockItem("redwood_sapling", () -> new SaplingBlock(new RedwoodGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_REDWOOD_SAPLING = registerBlock("potted_redwood_sapling", () -> new FlowerPotBlock(REDWOOD_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> REDWOOD_PLANKS = registerBlockItem("redwood_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> REDWOOD_STAIRS = registerBlockItem("redwood_stairs", () -> new StairBlock(REDWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> REDWOOD_SLAB = registerBlockItem("redwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> REDWOOD_FENCE = registerBlockItem("redwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> REDWOOD_FENCE_GATE = registerBlockItem("redwood_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.REDWOOD));
	public static final Supplier<Block> REDWOOD_DOOR = registerBlockItem("redwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.REDWOOD));
	public static final Supplier<Block> REDWOOD_TRAPDOOR = registerBlockItem("redwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.REDWOOD));
	public static final Supplier<Block> REDWOOD_PRESSURE_PLATE = registerBlockItem("redwood_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.REDWOOD));
	public static final Supplier<Block> REDWOOD_BUTTON = registerBlockItem("redwood_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.REDWOOD));
	public static final Supplier<Block> REDWOOD_SIGN = registerBlock("redwood_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.REDWOOD));
	public static final Supplier<Block> REDWOOD_WALL_SIGN = registerBlock("redwood_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.REDWOOD));
	public static final Supplier<Block> REDWOOD_HANGING_SIGN = registerBlock("redwood_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.REDWOOD));
	public static final Supplier<Block> REDWOOD_WALL_HANGING_SIGN = registerBlock("redwood_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.REDWOOD));
	public static final Supplier<Block> ALBINO_REDWOOD_LEAVES = registerBlockItem("albino_redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> ALBINO_REDWOOD_SAPLING = registerBlockItem("albino_redwood_sapling", () -> new SaplingBlock(new AlbinoRedwoodGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_ALBINO_REDWOOD_SAPLING = registerBlock("potted_albino_redwood_sapling", () -> new FlowerPotBlock(ALBINO_REDWOOD_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));

	public static final Supplier<Block> WILLOW_LOG = registerBlockItem("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
	public static final Supplier<Block> WILLOW_WOOD = registerBlockItem("willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
	public static final Supplier<Block> STRIPPED_WILLOW_LOG = registerBlockItem("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
	public static final Supplier<Block> STRIPPED_WILLOW_WOOD = registerBlockItem("stripped_willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
	public static final Supplier<Block> WILLOW_LEAVES = registerBlockItem("willow_leaves", () -> new WillowLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
	public static final Supplier<Block> WILLOW_SAPLING = registerBlockItem("willow_sapling", () -> new SaplingBlock(new WillowGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
	public static final Supplier<Block> POTTED_WILLOW_SAPLING = registerBlock("potted_willow_sapling", () -> new FlowerPotBlock(WILLOW_SAPLING.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING)));
	public static final Supplier<Block> WILLOW_PLANKS = registerBlockItem("willow_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Supplier<Block> WILLOW_STAIRS = registerBlockItem("willow_stairs", () -> new StairBlock(WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));
	public static final Supplier<Block> WILLOW_SLAB = registerBlockItem("willow_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));
	public static final Supplier<Block> WILLOW_FENCE = registerBlockItem("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));
	public static final Supplier<Block> WILLOW_FENCE_GATE = registerBlockItem("willow_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SBWoodType.WILLOW));
	public static final Supplier<Block> WILLOW_DOOR = registerBlockItem("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSetType.WILLOW));
	public static final Supplier<Block> WILLOW_TRAPDOOR = registerBlockItem("willow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSetType.WILLOW));
	public static final Supplier<Block> WILLOW_PRESSURE_PLATE = registerBlockItem("willow_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSetType.WILLOW));
	public static final Supplier<Block> WILLOW_BUTTON = registerBlockItem("willow_button", () -> woodenButton(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSetType.WILLOW));
	public static final Supplier<Block> WILLOW_SIGN = registerBlock("willow_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), SBWoodType.WILLOW));
	public static final Supplier<Block> WILLOW_WALL_SIGN = registerBlock("willow_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), SBWoodType.WILLOW));
	public static final Supplier<Block> WILLOW_HANGING_SIGN = registerBlock("willow_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN), SBWoodType.WILLOW));
	public static final Supplier<Block> WILLOW_WALL_HANGING_SIGN = registerBlock("willow_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN), SBWoodType.WILLOW));
	public static final Supplier<Block> WILLOW_BRANCH = registerBlockItem("willow_branch", () -> new WillowBranchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
	public static final Supplier<Block> WILLOW_BRANCH_PLANT = registerBlockItem("willow_branch_plant", () -> new WillowBranchPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

	private static Block woodenButton(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new ButtonBlock(properties, blockSetType, 15, true);
	}

	private static Block woodenPressurePlate(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, properties, blockSetType);
	}

	private static <T extends Block> Supplier<T> registerWaterBlockItem(String name, Supplier<T> supplier) {
		Supplier<T> block = registerBlock(name, supplier);
		SBItems.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
		return block;
	}

	private static <T extends Block> Supplier<T> registerBlockItem(String name, Supplier<T> supplier) {
		Supplier<T> block = registerBlock(name, supplier);
		SBItems.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}

	private static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> supplier) {
		return SlayersBeasts.PLATFORM.register(BuiltInRegistries.BLOCK, name, supplier);
	}

	private static ResourceKey<Block> createKey(String path) {
		return ResourceKey.create(Registries.BLOCK, new ResourceLocation(SlayersBeasts.MOD_ID, path));
	}

	public static void register() {
		SlayersBeasts.LOGGER.info("Registering SBBlocks...");
	}
}
