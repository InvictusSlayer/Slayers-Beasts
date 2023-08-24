package net.invictusslayer.slayersbeasts.block;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.flammable.*;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.invictusslayer.slayersbeasts.world.feature.SBConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.tree.*;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class SBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Block> SEPULCHRA_PORTAL = BLOCKS.register("sepulchra_portal", () -> new SepulchraPortalBlock(Block.Properties.copy(Blocks.NETHER_PORTAL).noLootTable()));

    public static final RegistryObject<Block> CRYPT_PORTAL = BLOCKS.register("crypt_portal", () -> new CryptPortalBlock(Block.Properties.copy(Blocks.END_PORTAL).mapColor(MapColor.QUARTZ).noLootTable()));
    public static final RegistryObject<Block> CRYPTALITH = registerBlock("cryptalith", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> INFUSED_CRYPTALITH = registerBlock("infused_cryptalith", () -> new InfusedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F).lightLevel(state -> 1)));
    public static final RegistryObject<Block> DEPLETED_CRYPTALITH = registerBlock("depleted_cryptalith", () -> new DepletedCryptalithBlock(BlockBehaviour.Properties.copy(CRYPTALITH.get()).strength(55F, 3600000F)));

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(9f)));

    public static final RegistryObject<Block> EXOSKELETON_ORE = registerBlock("exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(15f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_EXOSKELETON_ORE = registerBlock("deepslate_exoskeleton_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(25f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> OOTHECA = registerBlock("ootheca", () -> new OothecaBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).strength(1f).noLootTable()));

    public static final RegistryObject<Block> ANT_SOIL = registerBlock("ant_soil", () -> new Block(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
    public static final RegistryObject<Block> ANTHILL = registerBlock("anthill", () -> new AnthillBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));
    public static final RegistryObject<Block> ANTHILL_HATCHERY = registerBlock("anthill_hatchery", () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.copy(Blocks.ROOTED_DIRT).strength(1f)));

    public static final RegistryObject<Block> ICICLE = registerBlock("icicle", () -> new IcicleBlock(BlockBehaviour.Properties.copy(Blocks.POINTED_DRIPSTONE).mapColor(MapColor.ICE).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> TALL_DEAD_BUSH = registerBlock("tall_dead_bush", () -> new TallDeadBushBlock(BlockBehaviour.Properties.copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<Block> CRACKED_MUD = registerBlock("cracked_mud", () -> new CrackedMudBlock(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));
    public static final RegistryObject<Block> PEAT = registerBlock("peat", () -> new PeatBlock(BlockBehaviour.Properties.copy(Blocks.POWDER_SNOW).mapColor(MapColor.TERRACOTTA_BLACK).strength(1F).sound(SoundType.MUD).forceSolidOn().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> PEGMATITE = registerBlock("pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
    public static final RegistryObject<Block> PEGMATITE_SLAB = registerBlock("pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PEGMATITE.get())));
    public static final RegistryObject<Block> PEGMATITE_STAIRS = registerBlock("pegmatite_stairs", () -> new StairBlock(() -> PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(PEGMATITE.get())));
    public static final RegistryObject<Block> PEGMATITE_WALL = registerBlock("pegmatite_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(PEGMATITE.get()).forceSolidOn()));
    public static final RegistryObject<Block> POLISHED_PEGMATITE = registerBlock("polished_pegmatite", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.SAND)));
    public static final RegistryObject<Block> POLISHED_PEGMATITE_SLAB = registerBlock("polished_pegmatite_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));
    public static final RegistryObject<Block> POLISHED_PEGMATITE_STAIRS = registerBlock("polished_pegmatite_stairs", () -> new StairBlock(() -> POLISHED_PEGMATITE.get().defaultBlockState(), BlockBehaviour.Properties.copy(POLISHED_PEGMATITE.get())));

    public static final RegistryObject<Block> BLACK_SAND = registerBlock("black_sand", () -> new SandBlock(3748886, BlockBehaviour.Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SANDSTONE = registerBlock("black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SANDSTONE_SLAB = registerBlock("black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SANDSTONE_STAIRS = registerBlock("black_sandstone_stairs", () -> new StairBlock(() -> BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BLACK_SANDSTONE_WALL = registerBlock("black_sandstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SANDSTONE_WALL).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE = registerBlock("smooth_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_SLAB = registerBlock("smooth_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> SMOOTH_BLACK_SANDSTONE_STAIRS = registerBlock("smooth_black_sandstone_stairs", () -> new StairBlock(() -> SMOOTH_BLACK_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.SMOOTH_SANDSTONE_STAIRS).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> CUT_BLACK_SANDSTONE = registerBlock("cut_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> CUT_BLACK_SANDSTONE_SLAB = registerBlock("cut_black_sandstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CUT_SANDSTONE_SLAB).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> CHISELED_BLACK_SANDSTONE = registerBlock("chiseled_black_sandstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_SANDSTONE).mapColor(MapColor.COLOR_BLACK)));

    public static final RegistryObject<Block> WHITE_MUSHROOM_BLOCK = registerBlock("white_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM_BLOCK).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> WHITE_MUSHROOM = registerBlock("white_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.copy(Blocks.RED_MUSHROOM).mapColor(MapColor.TERRACOTTA_WHITE), SBConfiguredFeatures.HUGE_WHITE_MUSHROOM));

    public static final RegistryObject<Block> ASPEN_LOG = registerBlock("aspen_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> ASPEN_WOOD = registerBlock("aspen_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> ASPEN_LEAVES = registerBlock("aspen_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> ASPEN_SAPLING = registerBlock("aspen_sapling", () -> new SaplingBlock(new AspenGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ASPEN_PLANKS = registerBlock("aspen_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> ASPEN_SLAB = registerBlock("aspen_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> ASPEN_STAIRS = registerBlock("aspen_stairs", () -> new FlammableStairBlock(() -> ASPEN_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> ASPEN_FENCE = registerBlock("aspen_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> ASPEN_BUTTON = registerBlock("aspen_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.ASPEN, 15, true));
    public static final RegistryObject<Block> ASPEN_PRESSURE_PLATE = registerBlock("aspen_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.ASPEN));
    public static final RegistryObject<Block> ASPEN_DOOR = registerBlock("aspen_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.ASPEN));
    public static final RegistryObject<Block> ASPEN_TRAPDOOR = registerBlock("aspen_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.ASPEN));

    public static final RegistryObject<Block> CAJOLE_LOG = registerBlock("cajole_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CAJOLE_LOG = registerBlock("stripped_cajole_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> CAJOLE_WOOD = registerBlock("cajole_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CAJOLE_WOOD = registerBlock("stripped_cajole_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CAJOLE_LEAVES = registerBlock("cajole_leaves", () -> new CajoleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> CAJOLE_SAPLING = registerBlock("cajole_sapling", () -> new SaplingBlock(new CajoleGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CAJOLE_PLANKS = registerBlock("cajole_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> CAJOLE_SLAB = registerBlock("cajole_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> CAJOLE_STAIRS = registerBlock("cajole_stairs", () -> new FlammableStairBlock(() -> CAJOLE_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> CAJOLE_FENCE = registerBlock("cajole_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> CAJOLE_FENCE_GATE = registerBlock("cajole_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> CAJOLE_BUTTON = registerBlock("cajole_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.CAJOLE, 15, true));
    public static final RegistryObject<Block> CAJOLE_PRESSURE_PLATE = registerBlock("cajole_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.CAJOLE));
    public static final RegistryObject<Block> CAJOLE_DOOR = registerBlock("cajole_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.CAJOLE));
    public static final RegistryObject<Block> CAJOLE_TRAPDOOR = registerBlock("cajole_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.CAJOLE));
    
    public static final RegistryObject<Block> DESERT_OAK_LOG = registerBlock("desert_oak_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_DESERT_OAK_LOG = registerBlock("stripped_desert_oak_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> DESERT_OAK_WOOD = registerBlock("desert_oak_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_DESERT_OAK_WOOD = registerBlock("stripped_desert_oak_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> DESERT_OAK_LEAVES = registerBlock("desert_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> DESERT_OAK_SAPLING = registerBlock("desert_oak_sapling", () -> new SaplingBlock(new DesertOakGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DESERT_OAK_PLANKS = registerBlock("desert_oak_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> DESERT_OAK_SLAB = registerBlock("desert_oak_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> DESERT_OAK_STAIRS = registerBlock("desert_oak_stairs", () -> new FlammableStairBlock(() -> DESERT_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> DESERT_OAK_FENCE = registerBlock("desert_oak_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> DESERT_OAK_FENCE_GATE = registerBlock("desert_oak_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> DESERT_OAK_BUTTON = registerBlock("desert_oak_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.DESERT_OAK, 15, true));
    public static final RegistryObject<Block> DESERT_OAK_PRESSURE_PLATE = registerBlock("desert_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.DESERT_OAK));
    public static final RegistryObject<Block> DESERT_OAK_DOOR = registerBlock("desert_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.DESERT_OAK));
    public static final RegistryObject<Block> DESERT_OAK_TRAPDOOR = registerBlock("desert_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.DESERT_OAK));

    public static final RegistryObject<Block> EUCALYPTUS_LOG = registerBlock("eucalyptus_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_LOG = registerBlock("stripped_eucalyptus_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> EUCALYPTUS_WOOD = registerBlock("eucalyptus_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_WOOD = registerBlock("stripped_eucalyptus_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> EUCALYPTUS_LEAVES = registerBlock("eucalyptus_leaves", () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));
    public static final RegistryObject<Block> EUCALYPTUS_SAPLING = registerBlock("eucalyptus_sapling", () -> new SaplingBlock(new EucalyptusGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> EUCALYPTUS_PLANKS = registerBlock("eucalyptus_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_SLAB = registerBlock("eucalyptus_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_STAIRS = registerBlock("eucalyptus_stairs", () -> new FlammableStairBlock(() -> EUCALYPTUS_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_FENCE = registerBlock("eucalyptus_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_FENCE_GATE = registerBlock("eucalyptus_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_BUTTON = registerBlock("eucalyptus_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.EUCALYPTUS, 15, true));
    public static final RegistryObject<Block> EUCALYPTUS_PRESSURE_PLATE = registerBlock("eucalyptus_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.EUCALYPTUS));
    public static final RegistryObject<Block> EUCALYPTUS_DOOR = registerBlock("eucalyptus_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.EUCALYPTUS));
    public static final RegistryObject<Block> EUCALYPTUS_TRAPDOOR = registerBlock("eucalyptus_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.EUCALYPTUS));

    public static final RegistryObject<Block> KAPOK_LOG = registerBlock("kapok_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_KAPOK_LOG = registerBlock("stripped_kapok_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> KAPOK_WOOD = registerBlock("kapok_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_KAPOK_WOOD = registerBlock("stripped_kapok_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> KAPOK_LEAVES = registerBlock("kapok_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> KAPOK_SAPLING = registerBlock("kapok_sapling", () -> new SaplingBlock(new KapokGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> KAPOK_PLANKS = registerBlock("kapok_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> KAPOK_SLAB = registerBlock("kapok_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> KAPOK_STAIRS = registerBlock("kapok_stairs", () -> new FlammableStairBlock(() -> KAPOK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> KAPOK_FENCE = registerBlock("kapok_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> KAPOK_FENCE_GATE = registerBlock("kapok_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> KAPOK_BUTTON = registerBlock("kapok_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.KAPOK, 15, true));
    public static final RegistryObject<Block> KAPOK_PRESSURE_PLATE = registerBlock("kapok_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.KAPOK));
    public static final RegistryObject<Block> KAPOK_DOOR = registerBlock("kapok_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.KAPOK));
    public static final RegistryObject<Block> KAPOK_TRAPDOOR = registerBlock("kapok_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.KAPOK));

    public static final RegistryObject<Block> REDWOOD_LOG = registerBlock("redwood_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> REDWOOD_WOOD = registerBlock("redwood_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling", () -> new SaplingBlock(new RedwoodGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> REDWOOD_SLAB = registerBlock("redwood_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> REDWOOD_STAIRS = registerBlock("redwood_stairs", () -> new FlammableStairBlock(() -> REDWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> REDWOOD_FENCE = registerBlock("redwood_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> REDWOOD_BUTTON = registerBlock("redwood_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.REDWOOD, 15, true));
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.REDWOOD));
    public static final RegistryObject<Block> REDWOOD_DOOR = registerBlock("redwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.REDWOOD));
    public static final RegistryObject<Block> REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.REDWOOD));

    public static final RegistryObject<Block> WILLOW_LOG = registerBlock("willow_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> WILLOW_WOOD = registerBlock("willow_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood", () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WILLOW_LEAVES = registerBlock("willow_leaves", () -> new WillowLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> WILLOW_SAPLING = registerBlock("willow_sapling", () -> new SaplingBlock(new WillowGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WILLOW_PLANKS = registerBlock("willow_planks", () -> new FlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> WILLOW_SLAB = registerBlock("willow_slab", () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> WILLOW_STAIRS = registerBlock("willow_stairs", () -> new FlammableStairBlock(() -> WILLOW_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> WILLOW_FENCE = registerBlock("willow_fence", () -> new FlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> WILLOW_FENCE_GATE = registerBlock("willow_fence_gate", () -> new FlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> WILLOW_BUTTON = registerBlock("willow_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), SBBlockSets.WILLOW, 15, true));
    public static final RegistryObject<Block> WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), SBBlockSets.WILLOW));
    public static final RegistryObject<Block> WILLOW_DOOR = registerBlock("willow_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), SBBlockSets.WILLOW));
    public static final RegistryObject<Block> WILLOW_TRAPDOOR = registerBlock("willow_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), SBBlockSets.WILLOW));
    public static final RegistryObject<Block> WILLOW_BRANCH = registerBlock("willow_branch", () -> new WillowBranchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).randomTicks().noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WILLOW_BRANCH_PLANT = registerBlock("willow_branch_plant", () -> new WillowBranchPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().strength(0.2F).sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        SBItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
