package net.invictusslayer.slayersbeasts.mixin.common;

import net.invictusslayer.slayersbeasts.block.SBBlocks;
import net.invictusslayer.slayersbeasts.misc.SBMushroomCowType;
import net.minecraft.world.entity.animal.MushroomCow;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(MushroomCow.MushroomType.class)
public class MushroomCowTypeMixin {
	@Shadow @Final @Mutable
	private static MushroomCow.MushroomType[] $VALUES;

	@Invoker("<init>")
	private static MushroomCow.MushroomType newMushroomCowType(String name, int id, String type, BlockState block) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/animal/MushroomCow$MushroomType;$VALUES:[Lnet/minecraft/world/entity/animal/MushroomCow$MushroomType;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<MushroomCow.MushroomType> types = new ArrayList<>(Arrays.asList($VALUES));
		SBMushroomCowType.WHITE = newMushroomCowType("WHITE", types.size(), "white", SBBlocks.WHITE_MUSHROOM.get().defaultBlockState());
		SBMushroomCowType.BLACK = newMushroomCowType("BLACK", types.size() + 1, "black", SBBlocks.BLACK_MUSHROOM.get().defaultBlockState());
		types.addAll(List.of(SBMushroomCowType.BLACK, SBMushroomCowType.WHITE));
		$VALUES = types.toArray(new MushroomCow.MushroomType[0]);
	}
}
