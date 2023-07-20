package net.invictusslayer.slayersbeasts.world.feature;

import com.mojang.serialization.Codec;
import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public abstract class SBFeatures<FC extends FeatureConfiguration> extends Feature<FC> {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, SlayersBeasts.MOD_ID);

    public static final RegistryObject<HugeWhiteMushroomFeature> HUGE_WHITE_MUSHROOM = FEATURES.register("huge_white_mushroom", () -> new HugeWhiteMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));

    public SBFeatures(Codec<FC> pCodec) {
        super(pCodec);
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
