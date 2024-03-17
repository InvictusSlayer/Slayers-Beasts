package net.invictusslayer.slayersbeasts.common.mixin.common;

import net.invictusslayer.slayersbeasts.common.entity.vehicle.SBBoatType;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(Boat.Type.class)
public class BoatTypeMixin {
	@Shadow @Final @Mutable
	private static Boat.Type[] $VALUES;

	@Invoker("<init>")
	private static Boat.Type newBoatType(String name, int id, Block planks, String type) {
		throw new AssertionError();
	}

	@Inject(method = "<clinit>", at = @At(value = "FIELD", opcode = Opcodes.PUTSTATIC, target = "Lnet/minecraft/world/entity/vehicle/Boat$Type;$VALUES:[Lnet/minecraft/world/entity/vehicle/Boat$Type;", shift = At.Shift.AFTER))
	private static void onClinit(CallbackInfo ci) {
		ArrayList<Boat.Type> types = new ArrayList<>(Arrays.asList($VALUES));
		SBBoatType.ASPEN = newBoatType("ASPEN", types.size(), Blocks.OAK_PLANKS, "aspen");
		SBBoatType.DESERT_OAK = newBoatType("DESERT_OAK", types.size() + 1, Blocks.OAK_PLANKS, "desert_oak");
		SBBoatType.EUCALYPTUS = newBoatType("EUCALYPTUS", types.size() + 2, Blocks.OAK_PLANKS, "eucalyptus");
		SBBoatType.KAPOK = newBoatType("KAPOK", types.size() + 3, Blocks.OAK_PLANKS, "kapok");
		SBBoatType.REDWOOD = newBoatType("REDWOOD", types.size() + 4, Blocks.OAK_PLANKS, "redwood");
		SBBoatType.WILLOW = newBoatType("WILLOW", types.size() + 5, Blocks.OAK_PLANKS, "willow");
		types.addAll(List.of(SBBoatType.ASPEN, SBBoatType.DESERT_OAK, SBBoatType.EUCALYPTUS, SBBoatType.KAPOK, SBBoatType.REDWOOD, SBBoatType.WILLOW));
		$VALUES = types.toArray(new Boat.Type[0]);
	}
}
