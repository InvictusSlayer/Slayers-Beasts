package net.invictusslayer.slayersbeasts.misc;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SlayersBeasts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModCreativeModeTab {
    public static CreativeModeTab SLAYERS_BEASTS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        SLAYERS_BEASTS_TAB = event.registerCreativeModeTab(new ResourceLocation(SlayersBeasts.MOD_ID, "slayers_beasts_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.EUCALYPTUS_SAPLING.get()))
                        .title(Component.translatable("creativemodetab.slayers_beasts_tab")).build());
    }
}
