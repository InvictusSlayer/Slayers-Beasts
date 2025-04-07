package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.SBMushroomCowVariant;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(MushroomCow.Variant.class)
public abstract class MushroomCowVariantMixin {
	@Shadow @Final @Mutable
	private static MushroomCow.Variant[] $VALUES;
	@Shadow @Final
	String type;

	@Invoker("<init>")
	private static MushroomCow.Variant newMushroomCowVariant(String name, int id, String type, BlockState state) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/animal/MushroomCow$Variant;$VALUES:[Lnet/minecraft/world/entity/animal/MushroomCow$Variant;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<MushroomCow.Variant> types = new ArrayList<>(Arrays.asList($VALUES));
		SBMushroomCowVariant.WHITE = newMushroomCowVariant("WHITE", types.size(), "white", Blocks.RED_MUSHROOM.defaultBlockState());
		SBMushroomCowVariant.BLACK = newMushroomCowVariant("BLACK", types.size() + 1, "black", Blocks.RED_MUSHROOM.defaultBlockState());
		types.addAll(List.of(SBMushroomCowVariant.BLACK, SBMushroomCowVariant.WHITE));
		$VALUES = types.toArray(new MushroomCow.Variant[0]);
	}

	@Shadow
	static MushroomCow.Variant byName(String string) {
		return null;
	}

	@Inject(method = "getBlockState", at = @At("HEAD"), cancellable = true)
	private void onGetBlockState(CallbackInfoReturnable<BlockState> cir) {
		if (byName(type).equals(SBMushroomCowVariant.BLACK)) cir.setReturnValue(SBBlocks.BLACK_MUSHROOM.get().defaultBlockState());
		if (byName(type).equals(SBMushroomCowVariant.WHITE)) cir.setReturnValue(SBBlocks.WHITE_MUSHROOM.get().defaultBlockState());
	}
}
