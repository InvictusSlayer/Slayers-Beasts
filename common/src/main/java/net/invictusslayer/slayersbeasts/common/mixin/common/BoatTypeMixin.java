package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

@Mixin(Boat.Type.class)
public abstract class BoatTypeMixin {
	@Shadow @Final @Mutable
	private static Boat.Type[] $VALUES;
	@Shadow @Final
	private String name;

	@Invoker("<init>")
	private static Boat.Type newBoatType(String name, int id, Block block, String type) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/Boat$Type;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<Boat.Type> types = new ArrayList<>(Arrays.asList($VALUES));
		SBBoatType.ASPEN = newBoatType("ASPEN", types.size(), Blocks.OAK_PLANKS, "aspen");
		SBBoatType.BLOODWOOD = newBoatType("BLOODWOOD", types.size() + 1, Blocks.OAK_PLANKS, "bloodwood");
		SBBoatType.CYPRESS = newBoatType("CYPRESS", types.size() + 2, Blocks.OAK_PLANKS, "cypress");
		SBBoatType.DESERT_OAK = newBoatType("DESERT_OAK", types.size() + 3, Blocks.OAK_PLANKS, "desert_oak");
		SBBoatType.EUCALYPTUS = newBoatType("EUCALYPTUS", types.size() + 4, Blocks.OAK_PLANKS, "eucalyptus");
		SBBoatType.KAPOK = newBoatType("KAPOK", types.size() + 5, Blocks.OAK_PLANKS, "kapok");
		SBBoatType.REDWOOD = newBoatType("REDWOOD", types.size() + 6, Blocks.OAK_PLANKS, "redwood");
		SBBoatType.WILLOW = newBoatType("WILLOW", types.size() + 7, Blocks.OAK_PLANKS, "willow");
		types.addAll(SBBoatType.values());
		$VALUES = types.toArray(new Boat.Type[0]);
	}

	@Shadow
	public static Boat.Type byName(String name) {
		return null;
	}

	@Inject(method = "getPlanks", at = @At("HEAD"), cancellable = true)
	private void onGetPlanks(CallbackInfoReturnable<Block> cir) {
		if (byName(name).equals(SBBoatType.ASPEN)) cir.setReturnValue(SBBlocks.ASPEN_PLANKS.get());
		if (byName(name).equals(SBBoatType.BLOODWOOD)) cir.setReturnValue(SBBlocks.BLOODWOOD_PLANKS.get());
		if (byName(name).equals(SBBoatType.CYPRESS)) cir.setReturnValue(SBBlocks.CYPRESS_PLANKS.get());
		if (byName(name).equals(SBBoatType.DESERT_OAK)) cir.setReturnValue(SBBlocks.DESERT_OAK_PLANKS.get());
		if (byName(name).equals(SBBoatType.EUCALYPTUS)) cir.setReturnValue(SBBlocks.EUCALYPTUS_PLANKS.get());
		if (byName(name).equals(SBBoatType.KAPOK)) cir.setReturnValue(SBBlocks.KAPOK_PLANKS.get());
		if (byName(name).equals(SBBoatType.REDWOOD)) cir.setReturnValue(SBBlocks.REDWOOD_PLANKS.get());
		if (byName(name).equals(SBBoatType.WILLOW)) cir.setReturnValue(SBBlocks.WILLOW_PLANKS.get());
	}
}
