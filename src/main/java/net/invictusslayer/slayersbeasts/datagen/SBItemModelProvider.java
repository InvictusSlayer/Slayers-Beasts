package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SBItemModelProvider extends ItemModelProvider {
    public SBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    protected void registerModels() {
        item(SBItems.JADE);
        item(SBItems.JADE_SHARD);
//        simpleItem(ModItems.CRYSTALLINE_WING);
//        simpleItem(ModItems.CRYSTALLINE_CLAW);
//        simpleItem(ModItems.CRYSTALLINE_CARAPACE);
//        simpleItem(ModItems.INSECT_WING);
        item(SBItems.INSECT_CLAW);
        item(SBItems.INSECT_EYE);
        item(SBItems.INSECT_LEG);
        item(SBItems.FRIED_INSECT_LEG);
        item(SBItems.WITHERBONE);
        item(SBItems.TIED_LEATHER);
        item(SBItems.TANNED_LEATHER);
        item(SBItems.MUD_BALL);

        block(SBBlocks.ICICLE, "_frustum_down");
        block(SBBlocks.OBSIDIAN_SPIKE, "_tip_up");
        block(SBBlocks.TALL_DEAD_BUSH, "_top");
        block(SBBlocks.ALGAE);
        block(SBBlocks.BLACK_MUSHROOM);
        block(SBBlocks.WHITE_MUSHROOM);
        item(SBBlocks.ASPEN_DOOR);
        block(SBBlocks.ASPEN_SAPLING);
        item(SBBlocks.CAJOLE_DOOR);
        block(SBBlocks.CAJOLE_SAPLING);
        item(SBBlocks.DESERT_OAK_DOOR);
        block(SBBlocks.DESERT_OAK_SAPLING);
        item(SBBlocks.EUCALYPTUS_DOOR);
        block(SBBlocks.EUCALYPTUS_SAPLING);
        item(SBBlocks.KAPOK_DOOR);
        block(SBBlocks.KAPOK_SAPLING);
        item(SBBlocks.REDWOOD_DOOR);
        block(SBBlocks.REDWOOD_SAPLING);
        item(SBBlocks.WILLOW_DOOR);
        block(SBBlocks.WILLOW_SAPLING);
        block(SBBlocks.WILLOW_BRANCH);
        block(SBBlocks.WILLOW_BRANCH_PLANT);

        spawnEgg(SBItems.MANTIS_SPAWN_EGG);
        item(SBItems.WORKER_ANT_SPAWN_EGG);
        item(SBItems.SOLDIER_ANT_SPAWN_EGG);
        item(SBItems.QUEEN_ANT_SPAWN_EGG);
        spawnEgg(SBItems.WITHER_SPIDER_SPAWN_EGG);
        spawnEgg(SBItems.DAMSELFLY_SPAWN_EGG);
        spawnEgg(SBItems.ENT_OAK_SPAWN_EGG);
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

//    private void handheldItem(RegistryObject<Item> item) {
//        withExistingParent(item.getId().getPath(),
//                new ResourceLocation("item/handheld")).texture("layer0",
//                new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
//    }

    private void spawnEgg(RegistryObject<ForgeSpawnEggItem> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/template_spawn_egg"));
    }
}
