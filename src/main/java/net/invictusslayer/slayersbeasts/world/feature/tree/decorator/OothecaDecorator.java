package net.invictusslayer.slayersbeasts.world.feature.tree.decorator;

/*
public class OothecaDecorator extends TreeDecorator {
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((p_202307_) -> {
        return p_202307_ != WORLDGEN_FACING.getOpposite();
    }).toArray((p_202297_) -> {
        return new Direction[p_202297_];
    });

    private final float probability;
    public OothecaDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return null;
    }

    @Override
    public void place(Context pContext) {

    }

    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom,
                      List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {
        if (!(pRandom.nextFloat() >= this.probability)) {
            int i = pLogPositions.get(0).getY();
            pLogPositions.stream().filter((pos) -> pos.getY() - i <= 2).forEach((blockPos) -> {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (pRandom.nextFloat() <= 0.25F) {
                        Direction direction1 = direction.getOpposite();
                        BlockPos blockpos = blockPos.offset(direction1.getStepX(), 0, direction1.getStepZ());
                        if (Feature.isAir(pLevel, blockpos)) {
                            pBlockSetter.accept(blockpos, Blocks.COCOA.defaultBlockState().setValue(CocoaBlock.AGE,
                                    Integer.valueOf(pRandom.nextInt(3))).setValue(OothecaBlock.FACING, direction));
                        }
                    }
                }
            });
        }
    }
}
*/