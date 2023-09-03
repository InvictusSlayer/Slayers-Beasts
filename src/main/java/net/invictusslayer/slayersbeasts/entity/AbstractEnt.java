package net.invictusslayer.slayersbeasts.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public abstract class AbstractEnt extends PathfinderMob {
	protected AbstractEnt(EntityType<? extends AbstractEnt> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}
}
