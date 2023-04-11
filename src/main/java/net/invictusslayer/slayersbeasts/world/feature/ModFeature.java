package net.invictusslayer.slayersbeasts.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;

//public class ModFeature extends Feature {
//    public static final HugeWhiteMushroomFeature HUGE_WHITE_MUSHROOM = register("huge_white_mushroom", new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
//
//    private static <C extends FeatureConfiguration, F extends Feature<C>> F register(String pKey, F pValue) {
//        return Registry.register(BuiltInRegistries.FEATURE, pKey, pValue);
//    }
//
//    public ModFeature(Codec pCodec) {
//        super(pCodec);
//    }
//
//    @Override
//    public boolean place(FeaturePlaceContext pContext) {
//        return true;
//    }
//}
