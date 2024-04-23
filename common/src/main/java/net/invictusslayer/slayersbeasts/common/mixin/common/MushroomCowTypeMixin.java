package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.SBMushroomCowType;
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

@Mixin(MushroomCow.MushroomType.class)
public abstract class MushroomCowTypeMixin {
	@Shadow @Final @Mutable
	private static MushroomCow.MushroomType[] $VALUES;
	@Shadow @Final
	String type;

	@Invoker("<init>")
	private static MushroomCow.MushroomType newMushroomCowType(String name, int id, String type, BlockState state) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/animal/MushroomCow$MushroomType;$VALUES:[Lnet/minecraft/world/entity/animal/MushroomCow$MushroomType;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<MushroomCow.MushroomType> types = new ArrayList<>(Arrays.asList($VALUES));
		SBMushroomCowType.WHITE = newMushroomCowType("WHITE", types.size(), "white", Blocks.RED_MUSHROOM.defaultBlockState());
		SBMushroomCowType.BLACK = newMushroomCowType("BLACK", types.size() + 1, "black", Blocks.RED_MUSHROOM.defaultBlockState());
		types.addAll(List.of(SBMushroomCowType.BLACK, SBMushroomCowType.WHITE));
		$VALUES = types.toArray(new MushroomCow.MushroomType[0]);
	}

	@Shadow
	static MushroomCow.MushroomType byType(String name) {
		return null;
	}

	@Inject(method = "getBlockState", at = @At("HEAD"), cancellable = true)
	private void onGetBlockState(CallbackInfoReturnable<BlockState> cir) {
		if (byType(type).equals(SBMushroomCowType.BLACK)) cir.setReturnValue(SBBlocks.BLACK_MUSHROOM.get().defaultBlockState());
		if (byType(type).equals(SBMushroomCowType.WHITE)) cir.setReturnValue(SBBlocks.WHITE_MUSHROOM.get().defaultBlockState());
	}
}
