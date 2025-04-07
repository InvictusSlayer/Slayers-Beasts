package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.*;
import net.invictusslayer.slayersbeasts.common.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.common.world.feature.tree.SBTreeGrowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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

	public static final RegistrySupplier<Block> CRYPT_PORTAL = BLOCKS.register("crypt_portal", () -> new CryptPortalBlock(Block.Properties.ofFullCopy(Blocks.END_PORTAL).setId(createKey("crypt_portal")).mapColor(MapColor.QUARTZ).noLootTable()));
	public static final RegistrySupplier<Block> CRYPTALITH = register("cryptalith", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(createKey("cryptalith"))));
	public static final RegistrySupplier<Block> INFUSED_CRYPTALITH = register("infused_cryptalith", () -> new InfusedCryptalithBlock(BlockBehaviour.Properties.ofFullCopy(CRYPTALITH.get()).setId(createKey("infused_cryptalith")).strength(55F, 3600000F).lightLevel(state -> 1)));
	public static final RegistrySupplier<Block> DEPLETED_CRYPTALITH = register("depleted_cryptalith", () -> new DepletedCryptalithBlock(BlockBehaviour.Properties.ofFullCopy(CRYPTALITH.get()).setId(createKey("depleted_cryptalith")).strength(55F, 3600000F)));

	public static final RegistrySupplier<Block> JADE_BLOCK = register("jade_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).setId(createKey("jade_block")).strength(9f)));

	public static final RegistrySupplier<Block> EXOSKELETON_ORE = register("exoskeleton_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(createKey("exoskeleton_ore")).strength(15f).requiresCorrectToolForDrops()));
	public static final RegistrySupplier<Block> DEEPSLATE_EXOSKELETON_ORE = register("deepslate_exoskeleton_ore", () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(createKey("deepslate_exoskeleton_ore")).strength(25f).requiresCorrectToolForDrops()));

	public static final RegistrySupplier<Block> STYPHIUM = register("styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(createKey("styphium"))));
	public static final RegistrySupplier<Block> DEEPSLATE_STYPHIUM = register("deepslate_styphium", () -> new StyphiumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).setId(createKey("deepslate_styphium"))));

	public static final RegistrySupplier<Block> RUDOSOL = register("rudosol", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(createKey("rudosol")).strength(1f)));
	public static final RegistrySupplier<Block> ARIDISOL = register("aridisol", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(createKey("aridisol")).strength(1f)));
	public static final RegistrySupplier<Block> ANTHILL = register("anthill", () -> new AnthillBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(createKey("anthill")).strength(1f)));
	public static final RegistrySupplier<Block> ANTHILL_HATCHERY = register("anthill_hatchery", () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ROOTED_DIRT).setId(createKey("anthill_hatchery")).strength(1f)));

	public static final RegistrySupplier<Block> OOTHECA = register("ootheca", () -> new OothecaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).setId(createKey("ootheca")).strength(1f).noLootTable()));

	public static final RegistrySupplier<Block> GLEAMING_ICE = register("gleaming_ice", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_ICE).setId(createKey("gleaming_ice")).lightLevel(state -> 7)));
	public static final RegistrySupplier<Block> ICICLE = register("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE).setId(createKey("icicle")).mapColor(MapColor.ICE).sound(SoundType.GLASS)));
	public static final RegistrySupplier<Block> OBSIDIAN_SPIKE = register("obsidian_spike", () -> new ObsidianSpikeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POINTED_DRIPSTONE).setId(createKey("obsidian_spike")).mapColor(MapColor.COLOR_BLACK).strength(50.0F, 1200.0F)));

	public static final RegistrySupplier<Block> TALL_DEAD_BUSH = register("tall_dead_bush", () -> new TallDeadBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEAD_BUSH).setId(createKey("tall_dead_bush"))));
	public static final RegistrySupplier<Block> CRACKED_MUD = register("cracked_mud", () -> new CrackedMudBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD).setId(createKey("cracked_mud"))));
	public static final RegistrySupplier<Block> PEAT = register("peat", () -> new PeatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POWDER_SNOW).setId(createKey("peat")).mapColor(MapColor.TERRACOTTA_BLACK).strength(1F).sound(SoundType.MUD).forceSolidOn().pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> ALGAE = BLOCKS.register("algae", () -> new AlgaeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LILY_PAD).setId(createKey("algae")).noCollission()));

	public static final RegistrySupplier<Block> PEGMATITE = register("pegmatite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(createKey("pegmatite")).mapColor(MapColor.SAND)));
	public static final RegistrySupplier<Block> PEGMATITE_SLAB = register("pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get()).setId(createKey("pegmatite_slab"))));
	public static final RegistrySupplier<Block> PEGMATITE_STAIRS = register("pegmatite_stairs", () -> new StairBlock(PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get()).setId(createKey("pegmatite_stairs"))));
	public static final RegistrySupplier<Block> PEGMATITE_WALL = register("pegmatite_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PEGMATITE.get()).setId(createKey("pegmatite_wall")).forceSolidOn()));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE = register("polished_pegmatite", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).setId(createKey("polished_pegmatite")).mapColor(MapColor.SAND)));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE_SLAB = register("polished_pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(POLISHED_PEGMATITE.get()).setId(createKey("polished_pegmatite_slab"))));
	public static final RegistrySupplier<Block> POLISHED_PEGMATITE_STAIRS = register("polished_pegmatite_stairs", () -> new StairBlock(POLISHED_PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(POLISHED_PEGMATITE.get()).setId(createKey("polished_pegmatite_stairs"))));

	public static final RegistrySupplier<Block> BLACK_SAND = register("black_sand", () -> new ColoredFallingBlock(new ColorRGBA(3748886), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).setId(createKey("black_sand")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE = register("black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE).setId(createKey("black_sandstone")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_SLAB = register("black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_SLAB).setId(createKey("black_sandstone_slab")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_STAIRS = register("black_sandstone_stairs", () -> new StairBlock(BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_STAIRS).setId(createKey("black_sandstone_stairs")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> BLACK_SANDSTONE_WALL = register("black_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_WALL).setId(createKey("black_sandstone_wall")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE = register("smooth_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).setId(createKey("smooth_black_sandstone")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE_SLAB = register("smooth_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE_SLAB).setId(createKey("smooth_black_sandstone_slab")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = register("smooth_black_sandstone_stairs", () -> new StairBlock(SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE_STAIRS).setId(createKey("smooth_black_sandstone_stairs")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CUT_BLACK_SANDSTONE = register("cut_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE).setId(createKey("cut_black_sandstone")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CUT_BLACK_SANDSTONE_SLAB = register("cut_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_SANDSTONE_SLAB).setId(createKey("cut_black_sandstone_slab")).mapColor(MapColor.COLOR_BLACK)));
	public static final RegistrySupplier<Block> CHISELED_BLACK_SANDSTONE = register("chiseled_black_sandstone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.CHISELED_SANDSTONE).setId(createKey("chiseled_black_sandstone")).mapColor(MapColor.COLOR_BLACK)));

	public static final RegistrySupplier<Block> TALL_BROWN_MUSHROOM = register("tall_brown_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_BROWN_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("tall_brown_mushroom")).mapColor(MapColor.DIRT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> TALL_RED_MUSHROOM = register("tall_red_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_RED_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("tall_red_mushroom")).mapColor(MapColor.COLOR_RED).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> BLACK_MUSHROOM_BLOCK = register("black_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().setId(createKey("black_mushroom_block")).mapColor(MapColor.TERRACOTTA_BLACK).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final RegistrySupplier<Block> BLACK_MUSHROOM = register("black_mushroom", () -> new MushroomBlock(SBConfiguredFeatures.HUGE_BLACK_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("black_mushroom")).mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> POTTED_BLACK_MUSHROOM = BLOCKS.register("potted_black_mushroom", () -> new FlowerPotBlock(BLACK_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(createKey("potted_black_mushroom"))));
	public static final RegistrySupplier<Block> TALL_BLACK_MUSHROOM = register("tall_black_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_BLACK_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("tall_black_mushroom")).mapColor(MapColor.TERRACOTTA_BLACK).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> WHITE_MUSHROOM_BLOCK = register("white_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().setId(createKey("white_mushroom_block")).mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.BASS).strength(0.2f).sound(SoundType.WOOD).ignitedByLava()));
	public static final RegistrySupplier<Block> WHITE_MUSHROOM = register("white_mushroom", () -> new MushroomBlock(SBConfiguredFeatures.HUGE_WHITE_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("white_mushroom")).mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> POTTED_WHITE_MUSHROOM = BLOCKS.register("potted_white_mushroom", () -> new FlowerPotBlock(WHITE_MUSHROOM.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_RED_MUSHROOM).setId(createKey("potted_white_mushroom"))));
	public static final RegistrySupplier<Block> TALL_WHITE_MUSHROOM = register("tall_white_mushroom", () -> new TallMushroomBlock(SBConfiguredFeatures.BRANCHING_WHITE_MUSHROOM, BlockBehaviour.Properties.of().setId(createKey("tall_white_mushroom")).mapColor(MapColor.TERRACOTTA_WHITE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).hasPostProcess((state, level, pos) -> true).pushReaction(PushReaction.DESTROY)));
//	public static final RegistrySupplier<Block> THIN_MUSHROOM_STEM = register("thin_mushroom_stem", () -> new ThinMushroomStemBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).setId(createKey("thin_mushroom_stem"))));

	public static final RegistrySupplier<Block> ASPEN_LOG = register("aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("aspen_log"))));
	public static final RegistrySupplier<Block> ASPEN_WOOD = register("aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("aspen_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_ASPEN_LOG = register("stripped_aspen_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_aspen_log"))));
	public static final RegistrySupplier<Block> STRIPPED_ASPEN_WOOD = register("stripped_aspen_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_aspen_wood"))));
	public static final RegistrySupplier<Block> ASPEN_LEAVES = register("aspen_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("aspen_leaves"))));
	public static final RegistrySupplier<Block> ASPEN_SAPLING = register("aspen_sapling", () -> new SaplingBlock(SBTreeGrowers.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("aspen_sapling"))));
	public static final RegistrySupplier<Block> POTTED_ASPEN_SAPLING = BLOCKS.register("potted_aspen_sapling", () -> new FlowerPotBlock(ASPEN_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_aspen_sapling"))));
	public static final RegistrySupplier<Block> ASPEN_PLANKS = register("aspen_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("aspen_planks"))));
	public static final RegistrySupplier<Block> ASPEN_STAIRS = register("aspen_stairs", () -> new StairBlock(ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("aspen_stairs"))));
	public static final RegistrySupplier<Block> ASPEN_SLAB = register("aspen_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("aspen_slab"))));
	public static final RegistrySupplier<Block> ASPEN_FENCE = register("aspen_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("aspen_fence"))));
	public static final RegistrySupplier<Block> ASPEN_FENCE_GATE = register("aspen_fence_gate", () -> new FenceGateBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("aspen_fence_gate"))));
	public static final RegistrySupplier<Block> ASPEN_DOOR = register("aspen_door", () -> new DoorBlock(SBBlockSetType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("aspen_door"))));
	public static final RegistrySupplier<Block> ASPEN_TRAPDOOR = register("aspen_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("aspen_trapdoor"))));
	public static final RegistrySupplier<Block> ASPEN_PRESSURE_PLATE = register("aspen_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("aspen_pressure_plate")), SBBlockSetType.ASPEN));
	public static final RegistrySupplier<Block> ASPEN_BUTTON = register("aspen_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("aspen_button")), SBBlockSetType.ASPEN));
	public static final RegistrySupplier<Block> ASPEN_SIGN = BLOCKS.register("aspen_sign", () -> new StandingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("aspen_sign"))));
	public static final RegistrySupplier<Block> ASPEN_WALL_SIGN = BLOCKS.register("aspen_wall_sign", () -> new WallSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("aspen_wall_sign"))));
	public static final RegistrySupplier<Block> ASPEN_HANGING_SIGN = BLOCKS.register("aspen_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("aspen_hanging_sign"))));
	public static final RegistrySupplier<Block> ASPEN_WALL_HANGING_SIGN = BLOCKS.register("aspen_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.ASPEN, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("aspen_wall_hanging_sign"))));

	public static final RegistrySupplier<Block> CAJOLE_LOG = register("cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("cajole_log"))));
	public static final RegistrySupplier<Block> STRIPPED_CAJOLE_LOG = register("stripped_cajole_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_cajole_log"))));
	public static final RegistrySupplier<Block> CAJOLE_WOOD = register("cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("cajole_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_CAJOLE_WOOD = register("stripped_cajole_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_cajole_wood"))));
	public static final RegistrySupplier<Block> CAJOLE_LEAVES = register("cajole_leaves", () -> new CajoleLeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("cajole_leaves"))));
	public static final RegistrySupplier<Block> CAJOLE_SAPLING = register("cajole_sapling", () -> new SaplingBlock(SBTreeGrowers.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("cajole_sapling"))));
	public static final RegistrySupplier<Block> CAJOLE_PLANKS = register("cajole_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("cajole_planks"))));
	public static final RegistrySupplier<Block> CAJOLE_SLAB = register("cajole_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("cajole_slab"))));
	public static final RegistrySupplier<Block> CAJOLE_STAIRS = register("cajole_stairs", () -> new StairBlock(CAJOLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("cajole_stairs"))));
	public static final RegistrySupplier<Block> CAJOLE_FENCE = register("cajole_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("cajole_fence"))));
	public static final RegistrySupplier<Block> CAJOLE_FENCE_GATE = register("cajole_fence_gate", () -> new FenceGateBlock(SBWoodType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("cajole_fence_gate"))));
	public static final RegistrySupplier<Block> CAJOLE_BUTTON = register("cajole_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("cajole_button")), SBBlockSetType.CAJOLE));
	public static final RegistrySupplier<Block> CAJOLE_PRESSURE_PLATE = register("cajole_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("cajole_pressure_plate")), SBBlockSetType.CAJOLE));
	public static final RegistrySupplier<Block> CAJOLE_DOOR = register("cajole_door", () -> new DoorBlock(SBBlockSetType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("cajole_door"))));
	public static final RegistrySupplier<Block> CAJOLE_TRAPDOOR = register("cajole_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.CAJOLE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("cajole_trapdoor"))));

	public static final RegistrySupplier<Block> DESERT_OAK_LOG = register("desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("desert_oak_log"))));
	public static final RegistrySupplier<Block> DESERT_OAK_WOOD = register("desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("desert_oak_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_DESERT_OAK_LOG = register("stripped_desert_oak_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_desert_oak_log"))));
	public static final RegistrySupplier<Block> STRIPPED_DESERT_OAK_WOOD = register("stripped_desert_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_desert_oak_wood"))));
	public static final RegistrySupplier<Block> DESERT_OAK_LEAVES = register("desert_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("desert_oak_leaves"))));
	public static final RegistrySupplier<Block> DESERT_OAK_SAPLING = register("desert_oak_sapling", () -> new SaplingBlock(SBTreeGrowers.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("desert_oak_sapling"))));
	public static final RegistrySupplier<Block> POTTED_DESERT_OAK_SAPLING = BLOCKS.register("potted_desert_oak_sapling", () -> new FlowerPotBlock(DESERT_OAK_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_desert_oak_sapling"))));
	public static final RegistrySupplier<Block> DESERT_OAK_PLANKS = register("desert_oak_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("desert_oak_planks"))));
	public static final RegistrySupplier<Block> DESERT_OAK_STAIRS = register("desert_oak_stairs", () -> new StairBlock(DESERT_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("desert_oak_stairs"))));
	public static final RegistrySupplier<Block> DESERT_OAK_SLAB = register("desert_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("desert_oak_slab"))));
	public static final RegistrySupplier<Block> DESERT_OAK_FENCE = register("desert_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("desert_oak_fence"))));
	public static final RegistrySupplier<Block> DESERT_OAK_FENCE_GATE = register("desert_oak_fence_gate", () -> new FenceGateBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("desert_oak_fence_gate"))));
	public static final RegistrySupplier<Block> DESERT_OAK_DOOR = register("desert_oak_door", () -> new DoorBlock(SBBlockSetType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("desert_oak_door"))));
	public static final RegistrySupplier<Block> DESERT_OAK_TRAPDOOR = register("desert_oak_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("desert_oak_trapdoor"))));
	public static final RegistrySupplier<Block> DESERT_OAK_PRESSURE_PLATE = register("desert_oak_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("desert_oak_pressure_plate")), SBBlockSetType.DESERT_OAK));
	public static final RegistrySupplier<Block> DESERT_OAK_BUTTON = register("desert_oak_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("desert_oak_button")), SBBlockSetType.DESERT_OAK));
	public static final RegistrySupplier<Block> DESERT_OAK_SIGN = BLOCKS.register("desert_oak_sign", () -> new StandingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("desert_oak_sign"))));
	public static final RegistrySupplier<Block> DESERT_OAK_WALL_SIGN = BLOCKS.register("desert_oak_wall_sign", () -> new WallSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("desert_oak_wall_sign"))));
	public static final RegistrySupplier<Block> DESERT_OAK_HANGING_SIGN = BLOCKS.register("desert_oak_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("desert_oak_hanging_sign"))));
	public static final RegistrySupplier<Block> DESERT_OAK_WALL_HANGING_SIGN = BLOCKS.register("desert_oak_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.DESERT_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("desert_oak_wall_hanging_sign"))));

	public static final RegistrySupplier<Block> EUCALYPTUS_LOG = register("eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("eucalyptus_log"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_WOOD = register("eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("eucalyptus_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_EUCALYPTUS_LOG = register("stripped_eucalyptus_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_eucalyptus_log"))));
	public static final RegistrySupplier<Block> STRIPPED_EUCALYPTUS_WOOD = register("stripped_eucalyptus_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_eucalyptus_wood"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_LEAVES = register("eucalyptus_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("eucalyptus_leaves"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_SAPLING = register("eucalyptus_sapling", () -> new SaplingBlock(SBTreeGrowers.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("eucalyptus_sapling"))));
	public static final RegistrySupplier<Block> POTTED_EUCALYPTUS_SAPLING = BLOCKS.register("potted_eucalyptus_sapling", () -> new FlowerPotBlock(EUCALYPTUS_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_eucalyptus_sapling"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_PLANKS = register("eucalyptus_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("eucalyptus_planks"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_STAIRS = register("eucalyptus_stairs", () -> new StairBlock(EUCALYPTUS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("eucalyptus_stairs"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_SLAB = register("eucalyptus_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("eucalyptus_slab"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_FENCE = register("eucalyptus_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("eucalyptus_fence"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_FENCE_GATE = register("eucalyptus_fence_gate", () -> new FenceGateBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("eucalyptus_fence_gate"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_DOOR = register("eucalyptus_door", () -> new DoorBlock(SBBlockSetType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("eucalyptus_door"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_TRAPDOOR = register("eucalyptus_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("eucalyptus_trapdoor"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_PRESSURE_PLATE = register("eucalyptus_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("eucalyptus_pressure_plate")), SBBlockSetType.EUCALYPTUS));
	public static final RegistrySupplier<Block> EUCALYPTUS_BUTTON = register("eucalyptus_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("eucalyptus_button")), SBBlockSetType.EUCALYPTUS));
	public static final RegistrySupplier<Block> EUCALYPTUS_SIGN = BLOCKS.register("eucalyptus_sign", () -> new StandingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("eucalyptus_sign"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_WALL_SIGN = BLOCKS.register("eucalyptus_wall_sign", () -> new WallSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("eucalyptus_wall_sign"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_HANGING_SIGN = BLOCKS.register("eucalyptus_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("eucalyptus_hanging_sign"))));
	public static final RegistrySupplier<Block> EUCALYPTUS_WALL_HANGING_SIGN = BLOCKS.register("eucalyptus_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.EUCALYPTUS, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("eucalyptus_wall_hanging_sign"))));

	public static final RegistrySupplier<Block> KAPOK_LOG = register("kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("kapok_log"))));
	public static final RegistrySupplier<Block> KAPOK_WOOD = register("kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("kapok_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_KAPOK_LOG = register("stripped_kapok_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_kapok_log"))));
	public static final RegistrySupplier<Block> STRIPPED_KAPOK_WOOD = register("stripped_kapok_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_kapok_wood"))));
	public static final RegistrySupplier<Block> KAPOK_LEAVES = register("kapok_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("kapok_leaves"))));
	public static final RegistrySupplier<Block> KAPOK_SAPLING = register("kapok_sapling", () -> new SaplingBlock(SBTreeGrowers.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("kapok_sapling"))));
	public static final RegistrySupplier<Block> POTTED_KAPOK_SAPLING = BLOCKS.register("potted_kapok_sapling", () -> new FlowerPotBlock(KAPOK_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_kapok_sapling"))));
	public static final RegistrySupplier<Block> KAPOK_PLANKS = register("kapok_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("kapok_planks"))));
	public static final RegistrySupplier<Block> KAPOK_STAIRS = register("kapok_stairs", () -> new StairBlock(KAPOK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("kapok_stairs"))));
	public static final RegistrySupplier<Block> KAPOK_SLAB = register("kapok_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("kapok_slab"))));
	public static final RegistrySupplier<Block> KAPOK_FENCE = register("kapok_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("kapok_fence"))));
	public static final RegistrySupplier<Block> KAPOK_FENCE_GATE = register("kapok_fence_gate", () -> new FenceGateBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("kapok_fence_gate"))));
	public static final RegistrySupplier<Block> KAPOK_DOOR = register("kapok_door", () -> new DoorBlock(SBBlockSetType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("kapok_door"))));
	public static final RegistrySupplier<Block> KAPOK_TRAPDOOR = register("kapok_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("kapok_trapdoor"))));
	public static final RegistrySupplier<Block> KAPOK_PRESSURE_PLATE = register("kapok_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("kapok_pressure_plate")), SBBlockSetType.KAPOK));
	public static final RegistrySupplier<Block> KAPOK_BUTTON = register("kapok_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("kapok_button")), SBBlockSetType.KAPOK));
	public static final RegistrySupplier<Block> KAPOK_SIGN = BLOCKS.register("kapok_sign", () -> new StandingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("kapok_sign"))));
	public static final RegistrySupplier<Block> KAPOK_WALL_SIGN = BLOCKS.register("kapok_wall_sign", () -> new WallSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("kapok_wall_sign"))));
	public static final RegistrySupplier<Block> KAPOK_HANGING_SIGN = BLOCKS.register("kapok_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("kapok_hanging_sign"))));
	public static final RegistrySupplier<Block> KAPOK_WALL_HANGING_SIGN = BLOCKS.register("kapok_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.KAPOK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("kapok_wall_hanging_sign"))));

	public static final RegistrySupplier<Block> REDWOOD_LOG = register("redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("redwood_log"))));
	public static final RegistrySupplier<Block> REDWOOD_WOOD = register("redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("redwood_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_REDWOOD_LOG = register("stripped_redwood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_redwood_log"))));
	public static final RegistrySupplier<Block> STRIPPED_REDWOOD_WOOD = register("stripped_redwood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_redwood_wood"))));
	public static final RegistrySupplier<Block> REDWOOD_LEAVES = register("redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("redwood_leaves"))));
	public static final RegistrySupplier<Block> REDWOOD_SAPLING = register("redwood_sapling", () -> new SaplingBlock(SBTreeGrowers.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("redwood_sapling"))));
	public static final RegistrySupplier<Block> POTTED_REDWOOD_SAPLING = BLOCKS.register("potted_redwood_sapling", () -> new FlowerPotBlock(REDWOOD_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_redwood_sapling"))));
	public static final RegistrySupplier<Block> REDWOOD_PLANKS = register("redwood_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("redwood_planks"))));
	public static final RegistrySupplier<Block> REDWOOD_STAIRS = register("redwood_stairs", () -> new StairBlock(REDWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("redwood_stairs"))));
	public static final RegistrySupplier<Block> REDWOOD_SLAB = register("redwood_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("redwood_slab"))));
	public static final RegistrySupplier<Block> REDWOOD_FENCE = register("redwood_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("redwood_fence"))));
	public static final RegistrySupplier<Block> REDWOOD_FENCE_GATE = register("redwood_fence_gate", () -> new FenceGateBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("redwood_fence_gate"))));
	public static final RegistrySupplier<Block> REDWOOD_DOOR = register("redwood_door", () -> new DoorBlock(SBBlockSetType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("redwood_door"))));
	public static final RegistrySupplier<Block> REDWOOD_TRAPDOOR = register("redwood_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("redwood_trapdoor"))));
	public static final RegistrySupplier<Block> REDWOOD_PRESSURE_PLATE = register("redwood_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("redwood_pressure_plate")), SBBlockSetType.REDWOOD));
	public static final RegistrySupplier<Block> REDWOOD_BUTTON = register("redwood_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("redwood_button")), SBBlockSetType.REDWOOD));
	public static final RegistrySupplier<Block> REDWOOD_SIGN = BLOCKS.register("redwood_sign", () -> new StandingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("redwood_sign"))));
	public static final RegistrySupplier<Block> REDWOOD_WALL_SIGN = BLOCKS.register("redwood_wall_sign", () -> new WallSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("redwood_wall_sign"))));
	public static final RegistrySupplier<Block> REDWOOD_HANGING_SIGN = BLOCKS.register("redwood_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("redwood_hanging_sign"))));
	public static final RegistrySupplier<Block> REDWOOD_WALL_HANGING_SIGN = BLOCKS.register("redwood_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("redwood_wall_hanging_sign"))));
	public static final RegistrySupplier<Block> ALBINO_REDWOOD_LEAVES = register("albino_redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("albino_redwood_leaves"))));
	public static final RegistrySupplier<Block> ALBINO_REDWOOD_SAPLING = register("albino_redwood_sapling", () -> new SaplingBlock(SBTreeGrowers.ALBINO_REDWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("albino_redwood_sapling"))));
	public static final RegistrySupplier<Block> POTTED_ALBINO_REDWOOD_SAPLING = BLOCKS.register("potted_albino_redwood_sapling", () -> new FlowerPotBlock(ALBINO_REDWOOD_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_albino_redwood_sapling"))));

	public static final RegistrySupplier<Block> WILLOW_LOG = register("willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).setId(createKey("willow_log"))));
	public static final RegistrySupplier<Block> WILLOW_WOOD = register("willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).setId(createKey("willow_wood"))));
	public static final RegistrySupplier<Block> STRIPPED_WILLOW_LOG = register("stripped_willow_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).setId(createKey("stripped_willow_log"))));
	public static final RegistrySupplier<Block> STRIPPED_WILLOW_WOOD = register("stripped_willow_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).setId(createKey("stripped_willow_wood"))));
	public static final RegistrySupplier<Block> WILLOW_LEAVES = register("willow_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).setId(createKey("willow_leaves"))));
	public static final RegistrySupplier<Block> WILLOW_SAPLING = register("willow_sapling", () -> new SaplingBlock(SBTreeGrowers.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).setId(createKey("willow_sapling"))));
	public static final RegistrySupplier<Block> POTTED_WILLOW_SAPLING = BLOCKS.register("potted_willow_sapling", () -> new FlowerPotBlock(WILLOW_SAPLING.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).setId(createKey("potted_willow_sapling"))));
	public static final RegistrySupplier<Block> WILLOW_PLANKS = register("willow_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).setId(createKey("willow_planks"))));
	public static final RegistrySupplier<Block> WILLOW_STAIRS = register("willow_stairs", () -> new StairBlock(WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).setId(createKey("willow_stairs"))));
	public static final RegistrySupplier<Block> WILLOW_SLAB = register("willow_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).setId(createKey("willow_slab"))));
	public static final RegistrySupplier<Block> WILLOW_FENCE = register("willow_fence", () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).setId(createKey("willow_fence"))));
	public static final RegistrySupplier<Block> WILLOW_FENCE_GATE = register("willow_fence_gate", () -> new FenceGateBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).setId(createKey("willow_fence_gate"))));
	public static final RegistrySupplier<Block> WILLOW_DOOR = register("willow_door", () -> new DoorBlock(SBBlockSetType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).setId(createKey("willow_door"))));
	public static final RegistrySupplier<Block> WILLOW_TRAPDOOR = register("willow_trapdoor", () -> new TrapDoorBlock(SBBlockSetType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).setId(createKey("willow_trapdoor"))));
	public static final RegistrySupplier<Block> WILLOW_PRESSURE_PLATE = register("willow_pressure_plate", () -> woodenPressurePlate(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).setId(createKey("willow_pressure_plate")), SBBlockSetType.WILLOW));
	public static final RegistrySupplier<Block> WILLOW_BUTTON = register("willow_button", () -> woodenButton(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).setId(createKey("willow_button")), SBBlockSetType.WILLOW));
	public static final RegistrySupplier<Block> WILLOW_SIGN = BLOCKS.register("willow_sign", () -> new StandingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(createKey("willow_sign"))));
	public static final RegistrySupplier<Block> WILLOW_WALL_SIGN = BLOCKS.register("willow_wall_sign", () -> new WallSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN).setId(createKey("willow_wall_sign"))));
	public static final RegistrySupplier<Block> WILLOW_HANGING_SIGN = BLOCKS.register("willow_hanging_sign", () -> new CeilingHangingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(createKey("willow_hanging_sign"))));
	public static final RegistrySupplier<Block> WILLOW_WALL_HANGING_SIGN = BLOCKS.register("willow_wall_hanging_sign", () -> new WallHangingSignBlock(SBWoodType.WILLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).setId(createKey("willow_wall_hanging_sign"))));
	public static final RegistrySupplier<Block> WILLOW_BRANCH = register("willow_branch", () -> new WillowBranchBlock(BlockBehaviour.Properties.of().setId(createKey("willow_branch")).mapColor(MapColor.PLANT).randomTicks().noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
	public static final RegistrySupplier<Block> WILLOW_BRANCH_PLANT = register("willow_branch_plant", () -> new WillowBranchPlantBlock(BlockBehaviour.Properties.of().setId(createKey("willow_branch_plant")).mapColor(MapColor.PLANT).noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

	private static Block woodenButton(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new ButtonBlock(blockSetType, 15, properties);
	}

	private static Block woodenPressurePlate(BlockBehaviour.Properties properties, BlockSetType blockSetType) {
		return new PressurePlateBlock(blockSetType, properties);
	}

	private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
		RegistrySupplier<T> block = BLOCKS.register(name, supplier);
		SBItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name)))));
		return block;
	}

	private static ResourceKey<Block> createKey(String path) {
		return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, path));
	}
}
