package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.world.entity.animal.MushroomCow;

public class SBMushroomCowType {
	public static MushroomCow.MushroomType BLACK;
	public static MushroomCow.MushroomType WHITE;

	public static MushroomCow.MushroomType cycleVariant(MushroomCow.MushroomType type) {
		if (type == MushroomCow.MushroomType.RED) return MushroomCow.MushroomType.BROWN;
		if (type == MushroomCow.MushroomType.BROWN) return WHITE;
		if (type == WHITE) return BLACK;
		return MushroomCow.MushroomType.RED;
	}
}
