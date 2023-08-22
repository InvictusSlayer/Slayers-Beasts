package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.item.SBItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class SBItemModelProvider extends ItemModelProvider {
    public SBItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(SBItems.JADE);
        simpleItem(SBItems.JADE_SHARD);
//        simpleItem(ModItems.CRYSTALLINE_WING);
//        simpleItem(ModItems.CRYSTALLINE_CLAW);
//        simpleItem(ModItems.CRYSTALLINE_CARAPACE);
//        simpleItem(ModItems.INSECT_WING);
        simpleItem(SBItems.INSECT_CLAW);
        simpleItem(SBItems.INSECT_EYE);
        simpleItem(SBItems.INSECT_LEG);
        simpleItem(SBItems.FRIED_INSECT_LEG);
        simpleItem(SBItems.WITHERBONE);
        simpleItem(SBItems.TIED_LEATHER);
        simpleItem(SBItems.TANNED_LEATHER);
        simpleItem(SBItems.MUD_BALL);

        blockItem(SBBlocks.ICICLE, "_frustum_down");
        blockItem(SBBlocks.TALL_DEAD_BUSH, "_top");
        blockItem(SBBlocks.WHITE_MUSHROOM);
        simpleItem(SBBlocks.ASPEN_DOOR);
        blockItem(SBBlocks.ASPEN_SAPLING);
        simpleItem(SBBlocks.CAJOLE_DOOR);
        blockItem(SBBlocks.CAJOLE_SAPLING);
        simpleItem(SBBlocks.DESERT_OAK_DOOR);
        blockItem(SBBlocks.DESERT_OAK_SAPLING);
        simpleItem(SBBlocks.EUCALYPTUS_DOOR);
        blockItem(SBBlocks.EUCALYPTUS_SAPLING);
        simpleItem(SBBlocks.KAPOK_DOOR);
        blockItem(SBBlocks.KAPOK_SAPLING);
        simpleItem(SBBlocks.REDWOOD_DOOR);
        blockItem(SBBlocks.REDWOOD_SAPLING);
        simpleItem(SBBlocks.WILLOW_DOOR);
        blockItem(SBBlocks.WILLOW_SAPLING);
        blockItem(SBBlocks.WILLOW_BRANCH);
        blockItem(SBBlocks.WILLOW_BRANCH_PLANT);

        spawnEggItem(SBItems.MANTIS_SPAWN_EGG);
        simpleItem(SBItems.WORKER_ANT_SPAWN_EGG);
        simpleItem(SBItems.SOLDIER_ANT_SPAWN_EGG);
        simpleItem(SBItems.QUEEN_ANT_SPAWN_EGG);
        spawnEggItem(SBItems.DAMSELFLY_SPAWN_EGG);
        spawnEggItem(SBItems.WITHER_SPIDER_SPAWN_EGG);
    }

    private void blockItem(RegistryObject<?> block) {
        blockItem(block, "");
    }

    private void blockItem(RegistryObject<?> block, String suffix) {
        withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "block/" + block.getId().getPath() + suffix));
    }

    private void simpleItem(RegistryObject<?> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void spawnEggItem(RegistryObject<ForgeSpawnEggItem> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/template_spawn_egg"));
    }
}
