package net.invictusslayer.slayersbeasts.world.structure.structures;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SBStructureType {
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, SlayersBeasts.MOD_ID);

	public static final RegistryObject<StructureType<CryptStructure>> CRYPT = STRUCTURE_TYPES.register("crypt", () -> () -> CryptStructure.CODEC);
	public static final RegistryObject<StructureType<CryptPortalStructure>> CRYPT_PORTAL = STRUCTURE_TYPES.register("crypt_portal", () -> () -> CryptPortalStructure.CODEC);
}
