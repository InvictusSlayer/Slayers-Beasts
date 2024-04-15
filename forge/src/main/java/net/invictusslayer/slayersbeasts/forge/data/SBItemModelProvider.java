package net.invictusslayer.slayersbeasts.forge.data;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

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

		spawnEgg(SBItems.MANTIS_SPAWN_EGG);
		item(SBItems.ANT_WORKER_SPAWN_EGG);
		item(SBItems.ANT_SOLDIER_SPAWN_EGG);
		item(SBItems.ANT_QUEEN_SPAWN_EGG);
		spawnEgg(SBItems.WITHER_SPIDER_SPAWN_EGG);
		spawnEgg(SBItems.TYRACHNID_SPAWN_EGG);
		spawnEgg(SBItems.DAMSELFLY_SPAWN_EGG);
		spawnEgg(SBItems.ENT_SPAWN_EGG);
		spawnEgg(SBItems.WUDU_SPAWN_EGG);
		spawnEgg(SBItems.SPORETRAP_SPAWN_EGG);

		block(SBBlocks.ICICLE, "_frustum_down");
		block(SBBlocks.OBSIDIAN_SPIKE, "_tip_up");
		block(SBBlocks.TALL_DEAD_BUSH, "_top");
		block(SBBlocks.ALGAE);
		block(SBBlocks.BLACK_MUSHROOM);
		block(SBBlocks.WHITE_MUSHROOM);
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

	private void block(RegistrySupplier<?> block) {
		block(block, "");
	}

	private void block(RegistrySupplier<?> block, String suffix) {
		withExistingParent(block.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(SlayersBeasts.MOD_ID, "block/" + block.getId().getPath() + suffix));
	}

	private void item(RegistrySupplier<?> item) {
		withExistingParent(item.getId().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
	}

//	private void handheldItem(RegistrySupplier<Item> item) {
//		withExistingParent(item.getId().getPath(),
//				new ResourceLocation("item/handheld")).texture("layer0",
//				new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
//	}

	private void spawnEgg(RegistrySupplier<Item> item) {
		withExistingParent(item.getId().getPath(), new ResourceLocation("item/template_spawn_egg"));
	}
}
