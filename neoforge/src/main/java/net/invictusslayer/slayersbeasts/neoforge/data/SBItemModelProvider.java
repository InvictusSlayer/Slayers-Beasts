package net.invictusslayer.slayersbeasts.neoforge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;

import java.util.function.Supplier;

public class SBItemModelProvider extends ItemModelProvider {
	public SBItemModelProvider(PackOutput output) {
		super(output, SlayersBeasts.MOD_ID, null);
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
		WoodFamily.getAllFamilies().forEach(family -> family.getVariants().forEach((variant, supplier) -> {
			switch (variant) {
				case DOOR, BOAT, CHEST_BOAT, HANGING_SIGN_ITEM, SIGN_ITEM -> item(supplier);
				case SAPLING -> block(supplier);
			}
		}));
	}

	private void block(Supplier<?> block) {
		block(block, "");
	}

	private void block(Supplier<?> block, String suffix) {
//		withExistingParent(block.getPath(),
//				ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")).texture("layer0",
//				ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "block/" + block.get().getPath() + suffix));
	}

	private void item(Supplier<?> item) {
//		withExistingParent(item.getId().getPath(),
//				ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")).texture("layer0",
//				ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
	}

//	private void handheldItem(Supplier<Item> item) {
//		withExistingParent(item.getId().getPath(),
//				ResourceLocation.fromNamespaceAndPath("minecraft", "item/handheld")).texture("layer0",
//				ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
//	}
}
