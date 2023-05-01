package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.invictusslayer.slayersbeasts.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SlayersBeasts.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JADE);
        simpleItem(ModItems.JADE_SHARD);
//        simpleItem(ModItems.CRYSTALLINE_WING);
//        simpleItem(ModItems.CRYSTALLINE_CLAW);
//        simpleItem(ModItems.CRYSTALLINE_CARAPACE);
//        simpleItem(ModItems.INSECT_WING);
        simpleItem(ModItems.INSECT_CLAW);
        simpleItem(ModItems.INSECT_EYE);
        simpleItem(ModItems.INSECT_LEG);
        simpleItem(ModItems.FRIED_INSECT_LEG);
        simpleItem(ModItems.WITHERBONE);
        simpleItem(ModItems.TIED_LEATHER);
        simpleItem(ModItems.TANNED_LEATHER);

        blockItem(ModBlocks.WHITE_MUSHROOM);
        simpleItem(ModBlocks.ASPEN_DOOR);
        blockItem(ModBlocks.ASPEN_SAPLING);
        simpleItem(ModBlocks.CAJOLE_DOOR);
        blockItem(ModBlocks.CAJOLE_SAPLING);
        simpleItem(ModBlocks.DESERT_OAK_DOOR);
        blockItem(ModBlocks.DESERT_OAK_SAPLING);
        simpleItem(ModBlocks.EUCALYPTUS_DOOR);
        blockItem(ModBlocks.EUCALYPTUS_SAPLING);
        simpleItem(ModBlocks.KAPOK_DOOR);
        blockItem(ModBlocks.KAPOK_SAPLING);
        simpleItem(ModBlocks.REDWOOD_DOOR);
        blockItem(ModBlocks.REDWOOD_SAPLING);

        spawnEggItem(ModItems.MANTIS_SPAWN_EGG);
        simpleItem(ModItems.WORKER_ANT_SPAWN_EGG);
        simpleItem(ModItems.SOLDIER_ANT_SPAWN_EGG);
        simpleItem(ModItems.QUEEN_ANT_SPAWN_EGG);
        spawnEggItem(ModItems.DAMSELFLY_SPAWN_EGG);
        spawnEggItem(ModItems.WITHER_SPIDER_SPAWN_EGG);
    }

    private void blockItem(RegistryObject<?> block) {
        withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "block/" + block.getId().getPath()));
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
