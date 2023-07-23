package net.invictusslayer.slayersbeasts.world.feature.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class OothecaDecorator extends TreeDecorator {
    public static final Codec<OothecaDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability")
            .xmap(OothecaDecorator::new, decorator -> decorator.probability).codec();
    private final float probability;

    public OothecaDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> type() {
        return SBTreeDecorators.OOTHECA.get();
    }

    public void place(Context pContext) {

    }
}
