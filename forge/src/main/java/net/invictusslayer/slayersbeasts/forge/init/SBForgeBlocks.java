package net.invictusslayer.slayersbeasts.forge.init;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.forge.block.SepulchraPortalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class SBForgeBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SlayersBeasts.MOD_ID);

	public static final RegistryObject<Block> SEPULCHRA_PORTAL = BLOCKS.register("sepulchra_portal", () -> new SepulchraPortalBlock(Block.Properties.ofFullCopy(Blocks.NETHER_PORTAL).noLootTable()));
}
