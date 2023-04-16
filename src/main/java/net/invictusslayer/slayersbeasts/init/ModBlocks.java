package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.AnthillBlock;
import net.invictusslayer.slayersbeasts.block.AnthillHatcheryBlock;
import net.invictusslayer.slayersbeasts.block.CajoleLeavesBlock;
import net.invictusslayer.slayersbeasts.block.OothecaBlock;
import net.invictusslayer.slayersbeasts.block.flammable.*;
import net.invictusslayer.slayersbeasts.world.feature.ModConfiguredFeatures;
import net.invictusslayer.slayersbeasts.world.feature.tree.CajoleTreeGrower;
import net.invictusslayer.slayersbeasts.world.feature.tree.EucalyptusTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EXOSKELETON_ORE = registerBlock("exoskeleton_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(15f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_EXOSKELETON_ORE = registerBlock("deepslate_exoskeleton_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(25f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    public static final RegistryObject<Block> OOTHECA = registerBlock("ootheca",
            () -> new OothecaBlock(BlockBehaviour.Properties.of(Material.SCULK).strength(1f).noLootTable()));

    public static final RegistryObject<Block> ANT_SOIL = registerBlock("ant_soil",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS).strength(1f).sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> ANTHILL = registerBlock("anthill",
            () -> new AnthillBlock(BlockBehaviour.Properties.of(Material.GRASS).strength(1f).sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> ANTHILL_HATCHERY = registerBlock("anthill_hatchery",
            () -> new AnthillHatcheryBlock(BlockBehaviour.Properties.of(Material.GRASS).strength(1f).sound(SoundType.ROOTED_DIRT)));

    public static final RegistryObject<Block> BLACK_SAND = registerBlock("black_sand",
            () -> new SandBlock(3748886, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_BLACK).strength(0.5F).sound(SoundType.SAND)));

    public static final RegistryObject<Block> WHITE_MUSHROOM = registerBlock("white_mushroom",
            () -> new MushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM), ModConfiguredFeatures.HUGE_WHITE_MUSHROOM));
    public static final RegistryObject<Block> WHITE_MUSHROOM_BLOCK = registerBlock("white_mushroom_block",
            () -> new HugeMushroomBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK)));

    public static final RegistryObject<Block> CAJOLE_LOG = registerBlock("cajole_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CAJOLE_LOG = registerBlock("stripped_cajole_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> CAJOLE_WOOD = registerBlock("cajole_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CAJOLE_WOOD = registerBlock("stripped_cajole_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CAJOLE_LEAVES = registerBlock("cajole_leaves",
            () -> new CajoleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> CAJOLE_SAPLING = registerBlock("cajole_sapling",
            () -> new SaplingBlock(new CajoleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> CAJOLE_PLANKS = registerBlock("cajole_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> CAJOLE_SLAB = registerBlock("cajole_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> CAJOLE_STAIRS = registerBlock("cajole_stairs",
            () -> new ModFlammableStairBlock(() -> ModBlocks.CAJOLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> CAJOLE_FENCE = registerBlock("cajole_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> CAJOLE_FENCE_GATE = registerBlock("cajole_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> CAJOLE_BUTTON = registerBlock("cajole_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), 15, true,
                    SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
    public static final RegistryObject<Block> CAJOLE_PRESSURE_PLATE = registerBlock("cajole_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final RegistryObject<Block> CAJOLE_DOOR = registerBlock("cajole_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),
                    SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> CAJOLE_TRAPDOOR = registerBlock("cajole_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR),
                    SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));
    
    public static final RegistryObject<Block> EUCALYPTUS_LOG = registerBlock("eucalyptus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_LOG = registerBlock("stripped_eucalyptus_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> EUCALYPTUS_WOOD = registerBlock("eucalyptus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_EUCALYPTUS_WOOD = registerBlock("stripped_eucalyptus_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> EUCALYPTUS_LEAVES = registerBlock("eucalyptus_leaves",
            () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), 60, 30));
    public static final RegistryObject<Block> EUCALYPTUS_SAPLING = registerBlock("eucalyptus_sapling",
            () -> new SaplingBlock(new EucalyptusTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> EUCALYPTUS_PLANKS = registerBlock("eucalyptus_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_SLAB = registerBlock("eucalyptus_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_STAIRS = registerBlock("eucalyptus_stairs",
            () -> new ModFlammableStairBlock(() -> ModBlocks.CAJOLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_FENCE = registerBlock("eucalyptus_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_FENCE_GATE = registerBlock("eucalyptus_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), 20, 5));
    public static final RegistryObject<Block> EUCALYPTUS_BUTTON = registerBlock("eucalyptus_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), 15, true,
                    SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON));
    public static final RegistryObject<Block> EUCALYPTUS_PRESSURE_PLATE = registerBlock("eucalyptus_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE),
                    SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON));
    public static final RegistryObject<Block> EUCALYPTUS_DOOR = registerBlock("eucalyptus_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR),
                    SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN));
    public static final RegistryObject<Block> EUCALYPTUS_TRAPDOOR = registerBlock("eucalyptus_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR),
                    SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
