package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.ModBlocks;
import net.invictusslayer.slayersbeasts.init.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
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
        simpleItem(ModItems.WHITE_MUSHROOM);
        simpleItem(ModItems.WITHERBONE);
        simpleItem(ModItems.TIED_LEATHER);
        simpleItem(ModItems.TANNED_LEATHER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SlayersBeasts.MOD_ID, "item/" + item.getId().getPath()));
    }
}
