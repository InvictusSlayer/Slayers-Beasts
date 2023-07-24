package net.invictusslayer.slayersbeasts.block;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Set;
import java.util.stream.Stream;

public record SBBlockSets(String name, boolean canOpenByHand, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();
    public static final BlockSetType ASPEN = register(woodSetType("aspen"));
    public static final BlockSetType CAJOLE = register(woodSetType("cajole"));
    public static final BlockSetType DESERT_OAK = register(woodSetType("desert_oak"));
    public static final BlockSetType EUCALYPTUS = register(woodSetType("eucalyptus"));
    public static final BlockSetType KAPOK = register(woodSetType("kapok"));
    public static final BlockSetType REDWOOD = register(woodSetType("redwood"));
    public static final BlockSetType WILLOW = register(woodSetType("willow"));

    public static BlockSetType woodSetType(String pName) {
        return new BlockSetType(pName, true, SoundType.WOOD, SoundEvents.WOODEN_DOOR_CLOSE, SoundEvents.WOODEN_DOOR_OPEN, SoundEvents.WOODEN_TRAPDOOR_CLOSE, SoundEvents.WOODEN_TRAPDOOR_OPEN, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundEvents.WOODEN_BUTTON_CLICK_ON);
    }

    public static BlockSetType register(BlockSetType pValue) {
        VALUES.add(pValue);
        return pValue;
    }

    public static Stream<BlockSetType> values() {
        return VALUES.stream();
    }
}
