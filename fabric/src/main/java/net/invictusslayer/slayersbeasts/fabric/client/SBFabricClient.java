package net.invictusslayer.slayersbeasts.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.client.SBClient;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

@Environment(EnvType.CLIENT)
public class SBFabricClient implements ClientModInitializer {
	public void onInitializeClient() {
		SlayersBeasts.clientSetup();
		SBClient.registerModelLayers((location, definition) -> EntityModelLayerRegistry.registerModelLayer(location, definition::get));
		SBClient.registerRenderers(EntityRendererRegistry::register);

		renderWoodFamilies();
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
				SBBlocks.ALGAE.get(), SBBlocks.TALL_DEAD_BUSH.get(),
				SBBlocks.TALL_BROWN_MUSHROOM.get(), SBBlocks.TALL_RED_MUSHROOM.get(),
				SBBlocks.BLACK_MUSHROOM.get(), SBBlocks.POTTED_BLACK_MUSHROOM.get(), SBBlocks.TALL_BLACK_MUSHROOM.get(),
				SBBlocks.WHITE_MUSHROOM.get(), SBBlocks.POTTED_WHITE_MUSHROOM.get(), SBBlocks.TALL_WHITE_MUSHROOM.get(),
				SBBlocks.WILLOW_BRANCH.get(), SBBlocks.WILLOW_BRANCH_PLANT.get(),
				SBBlocks.ICICLE.get(), SBBlocks.OBSIDIAN_SPIKE.get());
	}

	private void renderWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			if (variant.isCutout()) BlockRenderLayerMap.INSTANCE.putBlock((Block) supplier.get(), RenderType.cutout());
		}));
	}
}
