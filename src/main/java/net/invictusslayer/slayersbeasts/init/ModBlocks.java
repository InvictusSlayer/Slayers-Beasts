package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModFlammableRotatedPillarBlock;
import net.invictusslayer.slayersbeasts.world.feature.tree.CajoleTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SlayersBeasts.MOD_ID);

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()), ModCreativeModeTab.SLAYERS_BEASTS_TAB);

    public static final RegistryObject<Block> EXOSKELETON_ORE = registerBlock("exoskeleton_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(15f).requiresCorrectToolForDrops()), ModCreativeModeTab.SLAYERS_BEASTS_TAB);
    public static final RegistryObject<Block> DEEPSLATE_EXOSKELETON_ORE = registerBlock("deepslate_exoskeleton_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(25f).requiresCorrectToolForDrops()), ModCreativeModeTab.SLAYERS_BEASTS_TAB);


    public static final RegistryObject<Block> CAJOLE_LOG = registerBlock("cajole_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.SLAYERS_BEASTS_TAB);
    public static final RegistryObject<Block> STRIPPED_CAJOLE_LOG = registerBlock("stripped_cajole_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.SLAYERS_BEASTS_TAB);
    public static final RegistryObject<Block> CAJOLE_WOOD = registerBlock("cajole_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.SLAYERS_BEASTS_TAB);
    public static final RegistryObject<Block> STRIPPED_CAJOLE_WOOD = registerBlock("stripped_cajole_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.SLAYERS_BEASTS_TAB);

    public static final RegistryObject<Block> CAJOLE_PLANKS = registerBlock("cajole_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.SLAYERS_BEASTS_TAB);

    public static final RegistryObject<Block> CAJOLE_LEAVES = registerBlock("cajole_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.SLAYERS_BEASTS_TAB);

    public static final RegistryObject<Block> CAJOLE_SAPLING = registerBlock("cajole_sapling",
            () -> new SaplingBlock(new CajoleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)),
            ModCreativeModeTab.SLAYERS_BEASTS_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
