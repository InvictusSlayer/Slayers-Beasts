package net.invictusslayer.slayersbeasts.data;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.level.block.SBWoodFamily;
import net.invictusslayer.slayersbeasts.registries.SBBlocks;
import net.invictusslayer.slayersbeasts.registries.SBItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class SBItemModelProvider extends ItemModelProvider {
	public SBItemModelProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, SlayersBeasts.MOD_ID, helper);
	}

	protected void registerModels() {
		generateWoodFamilies();

		item(SBItems.MUSIC_DISC_INKISH);

		item(SBItems.JADE);
//		item(SBItems.JADE_SHARD);
//		simpleItem(ModItems.CRYSTALLINE_WING);
//		simpleItem(ModItems.CRYSTALLINE_CLAW);
//		simpleItem(ModItems.CRYSTALLINE_CARAPACE);
//		simpleItem(ModItems.INSECT_WING);
		item(SBItems.INSECT_CLAW);
		item(SBItems.INSECT_EYE);
		item(SBItems.INSECT_LEG);
		item(SBItems.FRIED_INSECT_LEG);
		item(SBItems.WITHERBONE);
		item(SBItems.TIED_LEATHER);
		item(SBItems.TANNED_LEATHER);
		item(SBItems.MUD_BALL);

		item(SBItems.MANTIS_SPAWN_EGG);
		item(SBItems.ANT_WORKER_SPAWN_EGG);
		item(SBItems.ANT_SOLDIER_SPAWN_EGG);
		item(SBItems.ANT_QUEEN_SPAWN_EGG);
		item(SBItems.WITHER_SPIDER_SPAWN_EGG);
		item(SBItems.TYRACHNID_SPAWN_EGG);
//		item(SBItems.BUTTERFLY_SPAWN_EGG);
		item(SBItems.DAMSELFLY_SPAWN_EGG);
		item(SBItems.ENT_SPAWN_EGG);
		item(SBItems.WUDU_SPAWN_EGG);
//		item(SBItems.SPORETRAP_SPAWN_EGG);

		block(SBBlocks.ICICLE, "_frustum_down");
		block(SBBlocks.OBSIDIAN_SPIKE, "_tip_up");
		block(SBBlocks.TALL_DEAD_BUSH, "_top");
		block(SBBlocks.ALGAE);
		block(SBBlocks.TALL_BROWN_MUSHROOM, "_top");
		block(SBBlocks.TALL_RED_MUSHROOM, "_top");
		block(SBBlocks.BLACK_MUSHROOM);
		block(SBBlocks.TALL_BLACK_MUSHROOM, "_top");
		block(SBBlocks.WHITE_MUSHROOM);
		block(SBBlocks.TALL_WHITE_MUSHROOM, "_top");
		block(SBBlocks.ALBINO_REDWOOD_SAPLING);
		block(SBBlocks.WILLOW_BRANCH);
		block(SBBlocks.WILLOW_BRANCH_PLANT);
	}

	private void generateWoodFamilies() {
		SBWoodFamily.getAllFamilies().forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			switch (variant) {
				case DOOR, BOAT, CHEST_BOAT, HANGING_SIGN_ITEM, SIGN_ITEM -> item((Supplier<? extends ItemLike>) supplier);
				case SAPLING -> block((Supplier<? extends Block>) supplier);
			}
		}));
	}

	private void block(Supplier<? extends Block> block) {
		block(block, "");
	}

	private void block(Supplier<? extends Block> block, String suffix) {
		singleTexture(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), ResourceLocation.withDefaultNamespace("item/generated"), "layer0",
				ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "block/" + BuiltInRegistries.BLOCK.getKey(block.get()).getPath() + suffix));
	}

	private void item(Supplier<? extends ItemLike> item) {
		singleTexture(BuiltInRegistries.ITEM.getKey(item.get().asItem()).getPath(), ResourceLocation.withDefaultNamespace("item/generated"), "layer0",
				ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "item/" + BuiltInRegistries.ITEM.getKey(item.get().asItem()).getPath()));
	}

//	private void handheldItem(Supplier<Item> item) {
//      singleTexture(BuiltInRegistries.ITEM.getKey(item.get()).getPath(), ResourceLocation.withDefaultNamespace("item/handheld"), "layer0",
//		        ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "item/" + BuiltInRegistries.ITEM.getKey(item.get()).getPath()));
//	}
}
