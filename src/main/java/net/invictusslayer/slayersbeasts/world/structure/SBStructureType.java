package net.invictusslayer.slayersbeasts.world.structure;

import com.mojang.serialization.Codec;
import net.invictusslayer.slayersbeasts.world.structure.structures.CryptStructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public interface SBStructureType<S extends Structure> {
	StructureType<CryptStructure> CRYPT = register("crypt", CryptStructure.CODEC);

	private static <S extends Structure> StructureType<S> register(String name, Codec<S> codec) {
		return Registry.register(BuiltInRegistries.STRUCTURE_TYPE, name, () -> codec);
	}
}
