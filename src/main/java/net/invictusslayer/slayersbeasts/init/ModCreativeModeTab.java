package net.invictusslayer.slayersbeasts.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public final class ModCreativeModeTab {
    public static final CreativeModeTab SLAYERS_BEASTS_TAB = new CreativeModeTab("slayers_beasts_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WITHERBONE.get());
        }
    };
}
