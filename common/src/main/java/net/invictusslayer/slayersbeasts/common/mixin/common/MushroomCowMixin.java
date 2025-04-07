package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.SBMushroomCowVariant;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.animal.MushroomCow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@SuppressWarnings("AddedMixinMembersNamePattern")
@Mixin(MushroomCow.class)
public abstract class MushroomCowMixin {
	@Shadow
	private UUID lastLightningBoltUUID;

	@Shadow
	public abstract MushroomCow.Variant getVariant();

	@Inject(method = "thunderHit", at = @At("HEAD"), cancellable = true)
	private void onThunderHit(ServerLevel level, LightningBolt lightning, CallbackInfo ci) {
		UUID uuid = lightning.getUUID();
		if (!uuid.equals(lastLightningBoltUUID)) {
			((MushroomCow) (Object) this).setVariant(cycleVariant(getVariant()));
			lastLightningBoltUUID = uuid;
			((MushroomCow) (Object) this).playSound(SoundEvents.MOOSHROOM_CONVERT, 2.0F, 1.0F);
		}
		ci.cancel();
	}

	@Inject(method = "getOffspringVariant", at = @At("HEAD"), cancellable = true)
	private void onGetOffspringType(MushroomCow mate, CallbackInfoReturnable<MushroomCow.Variant> cir) {
		MushroomCow.Variant type = getVariant();
		MushroomCow.Variant mateType = mate.getVariant();
		if (type == mateType && RandomSource.create().nextInt(1024) == 0) {
			cir.setReturnValue(cycleVariant(type));
		}
		cir.setReturnValue(RandomSource.create().nextBoolean() ? type : mateType);
	}

	@Unique
	private static MushroomCow.Variant cycleVariant(MushroomCow.Variant type) {
		if (type == MushroomCow.Variant.RED) return MushroomCow.Variant.BROWN;
		if (type == MushroomCow.Variant.BROWN) return SBMushroomCowVariant.WHITE;
		if (type == SBMushroomCowVariant.WHITE) return SBMushroomCowVariant.BLACK;
		return MushroomCow.Variant.RED;
	}
}
