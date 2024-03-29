package net.invictusslayer.slayersbeasts.forge.item;

import net.invictusslayer.slayersbeasts.common.world.dimension.SBDimensions;
import net.invictusslayer.slayersbeasts.forge.block.SepulchraPortalBlock;
import net.invictusslayer.slayersbeasts.forge.init.SBForgeBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class SepulchraPortalItem extends Item {
	public SepulchraPortalItem(Properties properties) {
		super(properties);
	}

	public InteractionResult useOn(UseOnContext context) {
		if (context.getPlayer() != null) {
			if (context.getPlayer().level().dimension() == SBDimensions.SEPULCHRA || context.getPlayer().level().dimension() == Level.OVERWORLD) {
				for (Direction direction : Direction.Plane.VERTICAL) {
					BlockPos framePos = context.getClickedPos().relative(direction);
					if (((SepulchraPortalBlock) SBForgeBlocks.SEPULCHRA_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
						context.getLevel().playSound(context.getPlayer(), framePos, SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
						return InteractionResult.CONSUME;
					}
					else return InteractionResult.FAIL;
				}
			}
		}
		return InteractionResult.FAIL;
	}
}
