package net.invictusslayer.slayersbeasts.world.structure.structures;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class CryptStructure extends Structure {
    public static final Codec<CryptStructure> CODEC = simpleCodec(CryptStructure::new);

    protected CryptStructure(StructureSettings settings) {
        super(settings);
    }

    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        return Optional.empty();
    }

    public StructureType<?> type() {
        return SBStructureType.CRYPT.get();
    }
}
