package net.invictusslayer.slayersbeasts.common.world.feature.misc;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class CryptFoundationFeature extends Feature<NoneFeatureConfiguration> {
	public CryptFoundationFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		WorldGenLevel level = context.level();

		for (int x = -128; x <= 128; ++x) {
			for (int z = -128; z <= 128; ++z) {
				for (int y = 0; y <= 127; ++y) {
					if (Math.abs(x) > 126 || y < 2 || y > 125 || Math.abs(z) > 126) {
						level.setBlock(new BlockPos(x, y, z), Blocks.BEDROCK.defaultBlockState(), 16);
					} else {
						level.setBlock(new BlockPos(x, y, z), Blocks.STONE.defaultBlockState(), 16);
					}
				}
			}
		}

		return true;
	}
}
