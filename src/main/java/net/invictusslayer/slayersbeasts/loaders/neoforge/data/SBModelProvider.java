//? if neoforge {
/*package net.invictusslayer.slayersbeasts.loaders.neoforge.data;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.block.WoodFamily;
import net.invictusslayer.slayersbeasts.init.SBBlocks;
import net.invictusslayer.slayersbeasts.init.SBItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.block.state.properties.Tilt;

public class SBModelProvider extends ModelProvider {
	public SBModelProvider(PackOutput output) {
		super(output, SlayersBeasts.MOD_ID);
	}

	protected void registerModels(BlockModelGenerators blockGen, ItemModelGenerators itemGen) {
		generateBlockFamilies(blockGen);
		generateWoodFamilies(blockGen, itemGen);

		blockGen.createTrivialCube(SBBlocks.CRYPT_PORTAL.get());
		blockGen.createRotatedMirroredVariantBlock(SBBlocks.CRYPTALITH.get());
		createInfusedCryptalith(blockGen, SBBlocks.INFUSED_CRYPTALITH.get(), SBBlocks.CRYPTALITH.get());
		createDepletedCryptalith(blockGen, SBBlocks.DEPLETED_CRYPTALITH.get(), SBBlocks.CRYPTALITH.get());
		blockGen.createTrivialCube(SBBlocks.JADE_BLOCK.get());
		blockGen.createTrivialCube(SBBlocks.EXOSKELETON_ORE.get());
		blockGen.createTrivialCube(SBBlocks.DEEPSLATE_EXOSKELETON_ORE.get());
		createStyphium(blockGen, SBBlocks.STYPHIUM.get());
		createStyphium(blockGen, SBBlocks.DEEPSLATE_STYPHIUM.get());
		
		blockGen.createRotatedVariantBlock(SBBlocks.RUDOSOL.get());
		blockGen.createRotatedVariantBlock(SBBlocks.ARIDISOL.get());
		blockGen.createAxisAlignedPillarBlock(SBBlocks.ANTHILL.get(), TexturedModel.COLUMN);
		blockGen.createAxisAlignedPillarBlock(SBBlocks.ANTHILL_HATCHERY.get(), TexturedModel.COLUMN);
		blockGen.createAxisAlignedPillarBlock(SBBlocks.OOTHECA.get(), TexturedModel.COLUMN);

		blockGen.createTrivialCube(SBBlocks.GLEAMING_ICE.get());
		createIcicle(blockGen, SBBlocks.ICICLE.get());
		createIcicle(blockGen, SBBlocks.OBSIDIAN_SPIKE.get());
		blockGen.createDoublePlant(SBBlocks.TALL_DEAD_BUSH.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createCrackedMud(blockGen, SBBlocks.CRACKED_MUD.get());
		blockGen.createTrivialCube(SBBlocks.PEAT.get());
		createAlgae(blockGen, SBBlocks.ALGAE.get(), SBItems.ALGAE.get());

		blockGen.createRotatedVariantBlock(SBBlocks.BLACK_SAND.get());
		BlockModelGenerators.BlockFamilyProvider blackSandstone = blockGen.new BlockFamilyProvider(TexturedModel.TOP_BOTTOM_WITH_WALL.get(SBBlocks.BLACK_SANDSTONE.get()).getMapping());
		blackSandstone.generateFor(SBBlockFamily.BLACK_SANDSTONE);

		BlockModelGenerators.BlockFamilyProvider smoothBlackSandstone = blockGen.new BlockFamilyProvider(TexturedModel.createAllSame(TextureMapping.getBlockTexture(SBBlocks.BLACK_SANDSTONE.get(), "_top")).getMapping());
		smoothBlackSandstone.generateFor(SBBlockFamily.SMOOTH_BLACK_SANDSTONE);

		BlockModelGenerators.BlockFamilyProvider cutBlackSandstone = blockGen.new BlockFamilyProvider(TexturedModel.COLUMN.get(SBBlocks.BLACK_SANDSTONE.get()).updateTextures(mapping ->
				mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(SBBlocks.CUT_BLACK_SANDSTONE.get()))).getMapping());
		cutBlackSandstone.generateFor(SBBlockFamily.CUT_BLACK_SANDSTONE);

		BlockModelGenerators.BlockFamilyProvider chiseledBlackSandstone = blockGen.new BlockFamilyProvider(TexturedModel.COLUMN.get(Blocks.CHISELED_SANDSTONE).updateTextures(mapping -> {
			mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(Blocks.SANDSTONE, "_top"));
			mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(Blocks.CHISELED_SANDSTONE));
		}).getMapping());
		chiseledBlackSandstone.fullBlockVariant(SBBlocks.CHISELED_BLACK_SANDSTONE.get());

//		blockGen.createTrivialBlock(SBBlocks.BLACK_SANDSTONE.get(), TexturedModel.TOP_BOTTOM_WITH_WALL);
//		blackSandstone.slab(SBBlocks.BLACK_SANDSTONE_SLAB.get());
//		blackSandstone.stairs(SBBlocks.BLACK_SANDSTONE_STAIRS.get());
//		blackSandstone.wall(SBBlocks.BLACK_SANDSTONE_WALL.get());
//		blockGen.createTrivialBlock(SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), TexturedModel.CUBE);
//		smoothBlackSandstone.slab(SBBlocks.SMOOTH_BLACK_SANDSTONE_SLAB.get());
//		smoothBlackSandstone.stairs(SBBlocks.SMOOTH_BLACK_SANDSTONE_STAIRS.get());
//		blockGen.createTrivialBlock(SBBlocks.CUT_BLACK_SANDSTONE.get(), TexturedModel.COLUMN);
//		cutBlackSandstone.slab(SBBlocks.CUT_BLACK_SANDSTONE_SLAB.get());
//		blackSandstone.fullBlockVariant(SBBlocks.CHISELED_BLACK_SANDSTONE.get());

		blockGen.createDoublePlant(SBBlocks.TALL_BROWN_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createDoublePlant(SBBlocks.TALL_RED_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createMushroomBlock(SBBlocks.BLACK_MUSHROOM_BLOCK.get());//,"mushroom_block_dark_inside"
		blockGen.createPlant(SBBlocks.BLACK_MUSHROOM.get(), SBBlocks.POTTED_BLACK_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createDoublePlant(SBBlocks.TALL_BLACK_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createMushroomBlock(SBBlocks.WHITE_MUSHROOM_BLOCK.get());
		blockGen.createPlant(SBBlocks.WHITE_MUSHROOM.get(), SBBlocks.POTTED_WHITE_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createDoublePlant(SBBlocks.TALL_WHITE_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
//		createThinMushroomStem(blockGen, SBBlocks.THIN_MUSHROOM_STEM.get());

		blockGen.createTrivialCube(SBBlocks.ALBINO_REDWOOD_LEAVES.get());
		blockGen.createPlant(SBBlocks.ALBINO_REDWOOD_SAPLING.get(), SBBlocks.POTTED_ALBINO_REDWOOD_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createGrowingPlant(SBBlocks.WILLOW_BRANCH.get(), SBBlocks.WILLOW_BRANCH_PLANT.get(), BlockModelGenerators.PlantType.NOT_TINTED);

		itemGen.createFlatItemModel(SBItems.MUSIC_DISC_INKISH.get(), ModelTemplates.FLAT_ITEM);

		itemGen.createFlatItemModel(SBItems.JADE.get(), ModelTemplates.FLAT_ITEM);
//		item(SBItems.JADE_SHARD.get(), ModelTemplates.FLAT_ITEM);
//		simpleItem(ModItems.CRYSTALLINE_WING.get(), ModelTemplates.FLAT_ITEM);
//		simpleItem(ModItems.CRYSTALLINE_CLAW.get(), ModelTemplates.FLAT_ITEM);
//		simpleItem(ModItems.CRYSTALLINE_CARAPACE.get(), ModelTemplates.FLAT_ITEM);
//		simpleItem(ModItems.INSECT_WING.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.INSECT_CLAW.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.INSECT_EYE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.INSECT_LEG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.FRIED_INSECT_LEG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.WITHERBONE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.TIED_LEATHER.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.TANNED_LEATHER.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.MUD_BALL.get(), ModelTemplates.FLAT_ITEM);

		itemGen.createFlatItemModel(SBItems.MANTIS_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.ANT_WORKER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.ANT_SOLDIER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.ANT_QUEEN_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.WITHER_SPIDER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.TYRACHNID_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.DAMSELFLY_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.ENT_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.WUDU_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.createFlatItemModel(SBItems.SPORETRAP_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
	}

	public void createInfusedCryptalith(BlockModelGenerators blockGen, Block block, Block bottom) {
		TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top_active")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		TextureMapping mapping1 = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.ACTIVE, ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, blockGen.modelOutput), ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping1, blockGen.modelOutput))).with(BlockModelGenerators.createHorizontalFacingDispatch()));
	}

	public void createDepletedCryptalith(BlockModelGenerators blockGen, Block block, Block bottom) {
		TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, blockGen.modelOutput)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
	}

	public void createStyphium(BlockModelGenerators blockGen, Block block) {
		TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, blockGen.modelOutput)));
	}

	public void createCrackedMud(BlockModelGenerators blockGen, Block block) {
		PropertyDispatch.C1<Tilt> property = PropertyDispatch.property(BlockStateProperties.TILT);
		for (Tilt tilt : Tilt.values()) property.select(tilt, createCrackedMudVariant(blockGen, block, tilt));
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(property));
	}

	public Variant createCrackedMudVariant(BlockModelGenerators blockGen, Block block, Tilt tilt) {
		String suffix = "_" + tilt.getSerializedName();
		TextureMapping mapping = TextureMapping.cube(TextureMapping.getBlockTexture(block, suffix));
		return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_ALL.createWithSuffix(block, suffix, mapping, blockGen.modelOutput));
	}

	public void createIcicle(BlockModelGenerators blockGen, Block block) {
		PropertyDispatch.C2<Direction, DripstoneThickness> properties = PropertyDispatch.properties(BlockStateProperties.VERTICAL_DIRECTION, BlockStateProperties.DRIPSTONE_THICKNESS);
		for (DripstoneThickness thickness : DripstoneThickness.values()) properties.select(Direction.UP, thickness, createIcicleVariant(blockGen, block, Direction.UP, thickness));
		for (DripstoneThickness thickness : DripstoneThickness.values()) properties.select(Direction.DOWN, thickness, createIcicleVariant(blockGen, block, Direction.DOWN, thickness));
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(properties));
	}

	public Variant createIcicleVariant(BlockModelGenerators blockGen, Block block, Direction direction, DripstoneThickness thickness) {
		String suffix = "_" + thickness.getSerializedName() + "_" + direction.getSerializedName();
		TextureMapping mapping = TextureMapping.cross(TextureMapping.getBlockTexture(block, suffix));
		return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.POINTED_DRIPSTONE.createWithSuffix(block, suffix, mapping, blockGen.modelOutput));
	}

	public void createAlgae(BlockModelGenerators blockGen, Block block, Item item) {
		blockGen.registerSimpleItemModel(block, blockGen.createFlatItemModelWithBlockTexture(item, block));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createRotatedVariant(block, ModelLocationUtils.getModelLocation(block)));
	}

	private void generateWoodFamilies(BlockModelGenerators blockGen, ItemModelGenerators itemGen) {
		WoodFamily.getAllFamilies().forEach(family -> {
			BlockModelGenerators.BlockFamilyProvider planks = blockGen.family((Block) family.get(WoodFamily.Variant.PLANKS).get());
			BlockModelGenerators.WoodProvider wood = blockGen.woodProvider((Block) family.get(WoodFamily.Variant.LOG).get());
			BlockModelGenerators.WoodProvider stripped = blockGen.woodProvider((Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());

			family.getVariants().forEach((variant, supplier) -> {
				if (!(supplier.get() instanceof Block block)) return;
				switch (variant) {
					case BOAT, CHEST_BOAT, HANGING_SIGN_ITEM, SIGN_ITEM -> itemGen.createFlatItemModel(block.asItem(), ModelTemplates.FLAT_ITEM);
					case BUTTON -> planks.button(block);
					case DOOR -> planks.door(block);
					case FENCE -> planks.fence(block);
					case FENCE_GATE -> planks.fenceGate(block);
					case HANGING_SIGN -> blockGen.createHangingSign(block, (Block) family.get(WoodFamily.Variant.WALL_HANGING_SIGN).get(), (Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());
					case LEAVES, PLANKS -> blockGen.createTrivialCube(block);
					case LOG -> wood.log(block);
					case SAPLING -> blockGen.createPlant(block, (Block) family.get(WoodFamily.Variant.POTTED_SAPLING).get(), BlockModelGenerators.PlantType.NOT_TINTED);
					case SIGN -> planks.sign(block);
					case SLAB -> planks.slab(block);
					case STAIRS -> planks.stairs(block);
					case STRIPPED_LOG -> stripped.log(block);
					case STRIPPED_WOOD -> stripped.wood(block);
					case PRESSURE_PLATE -> planks.pressurePlate(block);
					case TRAPDOOR -> planks.trapdoor(block);
					case WOOD -> wood.wood(block);
				}
			});
		});
	}

	private void generateBlockFamilies(BlockModelGenerators blockGen) {
		SBBlockFamily.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> {
			blockGen.family(family.getBaseBlock()).generateFor(family);
//			BlockModelGenerators.BlockFamilyProvider provider = blockGen.familyWithExistingFullBlock(family.getBaseBlock());
//			family.getVariants().forEach((variant, block) -> {
//				switch (variant) {
//					case SLAB -> provider.slab(block);
//					case STAIRS -> provider.stairs(block);
//					case FENCE -> provider.fence(block);
//					case FENCE_GATE -> provider.fenceGate(block);
//					case BUTTON -> provider.button(block);
//					case PRESSURE_PLATE -> provider.pressurePlate(block);
//					case DOOR -> provider.door(block);
//					case TRAPDOOR -> provider.trapdoor(block);
//					case WALL -> provider.wall(block);
//				}
//			});
		});
	}
}
*///?}