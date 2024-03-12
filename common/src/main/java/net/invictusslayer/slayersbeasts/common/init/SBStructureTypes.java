package net.invictusslayer.slayersbeasts.common.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptPortalStructure;
import net.invictusslayer.slayersbeasts.common.world.structure.structures.CryptStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class SBStructureTypes {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(SlayersBeasts.MOD_ID, Registries.STRUCTURE_TYPE);

	public static final RegistrySupplier<StructureType<CryptStructure>> CRYPT = STRUCTURE_TYPES.register("crypt", () -> () -> CryptStructure.CODEC);
	public static final RegistrySupplier<StructureType<CryptPortalStructure>> CRYPT_PORTAL = STRUCTURE_TYPES.register("crypt_portal", () -> () -> CryptPortalStructure.CODEC);
}
