package net.invictusslayer.slayersbeasts.common.world.structure.structures;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.invictusslayer.slayersbeasts.common.init.SBStructureTypes;
import net.invictusslayer.slayersbeasts.common.world.structure.pieces.CryptPieces;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;

public class CryptStructure extends Structure {
	public static final Codec<CryptStructure> CODEC = RecordCodecBuilder.create(instance ->
			instance.group(settingsCodec(instance),
							StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
							HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight))
					.apply(instance, CryptStructure::new));
	private final Holder<StructureTemplatePool> startPool;
	private final HeightProvider startHeight;

	public CryptStructure(StructureSettings settings, Holder<StructureTemplatePool> startPool, HeightProvider startHeight) {
		super(settings);
		this.startPool = startPool;
		this.startHeight = startHeight;
	}

	public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		ChunkPos chunkPos = context.chunkPos();
		int i = startHeight.sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));
		BlockPos pos = new BlockPos(chunkPos.getMinBlockX(), i, chunkPos.getMinBlockZ());
		return CryptPieces.addPieces(context, startPool, pos, 128);
	}

	public StructureType<?> type() {
		return SBStructureTypes.CRYPT.get();
	}
}
