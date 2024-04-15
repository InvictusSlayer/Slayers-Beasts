package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.common.entity.SBFoxType;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.biome.Biome;
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

@Mixin(Fox.Type.class)
public class FoxTypeMixin {
	@Shadow @Final @Mutable
	private static Fox.Type[] $VALUES;

	@Invoker("<init>")
	private static Fox.Type newFoxType(String name, int id, int ordinal, String type) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/animal/Fox$Type;$VALUES:[Lnet/minecraft/world/entity/animal/Fox$Type;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<Fox.Type> types = new ArrayList<>(Arrays.asList($VALUES));
		SBFoxType.GREY = newFoxType("GREY", types.size(), types.size(), "grey");
		types.add(SBFoxType.GREY);
		$VALUES = types.toArray(new Fox.Type[0]);
	}

	@Inject(method = "byBiome", at = @At("HEAD"), cancellable = true)
	private static void onByBiome(Holder<Biome> biome, CallbackInfoReturnable<Fox.Type> cir) {
		if (biome.is(SBTags.Biomes.SPAWNS_GREY_FOXES)) cir.setReturnValue(SBFoxType.GREY);
	}
}
