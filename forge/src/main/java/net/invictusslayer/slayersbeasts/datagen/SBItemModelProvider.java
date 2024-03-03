package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SBItemModelProvider extends ItemModelProvider {
	public SBItemModelProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, SlayersBeasts.MOD_ID, helper);
	}

	protected void registerModels() {
		generateWoodFamilies();

		item(SBItems.MUSIC_DISC_INKISH);

		item(SBItems.JADE);
		item(SBItems.JADE_SHARD);
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

		spawnEgg(SBItems.MANTIS_SPAWN_EGG);
		item(SBItems.ANT_WORKER_SPAWN_EGG);
		item(SBItems.ANT_SOLDIER_SPAWN_EGG);
		item(SBItems.ANT_QUEEN_SPAWN_EGG);
		spawnEgg(SBItems.WITHER_SPIDER_SPAWN_EGG);
		spawnEgg(SBItems.TYRACHNID_SPAWN_EGG);
		spawnEgg(SBItems.DAMSELFLY_SPAWN_EGG);
		spawnEgg(SBItems.ENT_OAK_SPAWN_EGG);
		spawnEgg(SBItems.ENT_BIRCH_SPAWN_EGG);
		spawnEgg(SBItems.WUDU_OAK_SPAWN_EGG);
		spawnEgg(SBItems.SPORETRAP_SPAWN_EGG);

		block(SBBlocks.ICICLE, "_frustum_down");
		block(SBBlocks.OBSIDIAN_SPIKE, "_tip_up");
		block(SBBlocks.TALL_DEAD_BUSH, "_top");
		block(SBBlocks.ALGAE);
		block(SBBlocks.BLACK_MUSHROOM);
		block(SBBlocks.WHITE_MUSHROOM);
		block(SBBlocks.WILLOW_BRANCH);
		block(SBBlocks.WILLOW_BRANCH_PLANT);
	}

	private void generateWoodFamilies() {
		WoodFamily.getAllFamilies().forEach(family -> {
			if (family.get(WoodFamily.Variant.DOOR) != null) item(family.get(WoodFamily.Variant.DOOR));
			if (family.get(WoodFamily.Variant.BOAT) != null) item(family.get(WoodFamily.Variant.BOAT));
			if (family.get(WoodFamily.Variant.CHEST_BOAT) != null) item(family.get(WoodFamily.Variant.CHEST_BOAT));
			if (family.get(WoodFamily.Variant.HANGING_SIGN_ITEM) != null) item(family.get(WoodFamily.Variant.HANGING_SIGN_ITEM));
			if (family.get(WoodFamily.Variant.SAPLING) != null) block(family.get(WoodFamily.Variant.SAPLING));
			if (family.get(WoodFamily.Variant.SIGN_ITEM) != null) item(family.get(WoodFamily.Variant.SIGN_ITEM));
		});
	}

	private void block(RegistryObject<?> block) {
		block(block, "");
	}
	private void block(RegistryObject<?> block, String suffix) {
		withExistingParent(block.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(SlayersBeasts.MOD_ID, "block/" + block.getId().getPath() + suffix));
	}

	private void item(RegistryObject<?> item) {
		withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
	}

//	private void handheldItem(RegistryObject<Item> item) {
//		withExistingParent(item.getId().getPath(),
//				new ResourceLocation("item/handheld")).texture("layer0",
//				new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
//	}

	private void spawnEgg(RegistryObject<ForgeSpawnEggItem> item) {
		withExistingParent(item.getId().getPath(), new ResourceLocation("item/template_spawn_egg"));
	}
}
