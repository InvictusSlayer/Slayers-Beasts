package net.invictusslayer.slayersbeasts.mixin.common;

import net.invictusslayer.slayersbeasts.data.tag.SBTags;
import net.invictusslayer.slayersbeasts.entity.SBFoxVariant;
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

@Mixin(Fox.Variant.class)
public class FoxVariantMixin {
	@Shadow @Final @Mutable
	private static Fox.Variant[] $VALUES;

	@Invoker("<init>")
	private static Fox.Variant newFoxVariant(String name, int id, int ordinal, String type) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/animal/Fox$Variant;$VALUES:[Lnet/minecraft/world/entity/animal/Fox$Variant;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<Fox.Variant> types = new ArrayList<>(Arrays.asList($VALUES));
		SBFoxVariant.GREY = newFoxVariant("GREY", types.size(), types.size(), "grey");
		types.add(SBFoxVariant.GREY);
		$VALUES = types.toArray(new Fox.Variant[0]);
	}

	@Inject(method = "byBiome", at = @At("HEAD"), cancellable = true)
	private static void onByBiome(Holder<Biome> biome, CallbackInfoReturnable<Fox.Variant> cir) {
		if (biome.is(SBTags.Biomes.SPAWNS_GREY_FOXES)) cir.setReturnValue(SBFoxVariant.GREY);
	}
}
