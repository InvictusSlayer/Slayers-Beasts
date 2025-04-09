package net.invictusslayer.slayersbeasts.init;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.world.structure.structures.CryptPortalStructure;
import net.invictusslayer.slayersbeasts.world.structure.structures.CryptStructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.function.Supplier;

public class SBStructureTypes {
	//? if neoforge
	/*public static final net.neoforged.neoforge.registries.DeferredRegister<StructureType<?>> STRUCTURE_TYPES = net.neoforged.neoforge.registries.DeferredRegister.create(Registries.STRUCTURE_TYPE, SlayersBeasts.MOD_ID);*/

	public static final Supplier<StructureType<CryptStructure>> CRYPT = register("crypt", () -> CryptStructure.CODEC);
	public static final Supplier<StructureType<CryptPortalStructure>> CRYPT_PORTAL = register("crypt_portal", () -> CryptPortalStructure.CODEC);

	private static <T extends StructureType<?>> Supplier<T> register(String name, T structure) {
		//? if fabric
		return () -> Registry.register(BuiltInRegistries.STRUCTURE_TYPE, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, name), structure);
		//? if neoforge
		/*return STRUCTURE_TYPES.register(name, () -> structure);*/
	}

	public static void init() {
		SlayersBeasts.LOGGER.info("Initialised Structures");
	}
}
