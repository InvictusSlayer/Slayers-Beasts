package net.invictusslayer.slayersbeasts.neoforge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.SBBlockFamily;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.invictusslayer.slayersbeasts.common.init.SBBlocks;
import net.invictusslayer.slayersbeasts.common.init.SBItems;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
		blockGen.createTrivialBlock(SBBlocks.ANTHILL.get(), TexturedModel.COLUMN);
		blockGen.createTrivialBlock(SBBlocks.ANTHILL_HATCHERY.get(), TexturedModel.COLUMN);
		blockGen.createTrivialBlock(SBBlocks.OOTHECA.get(), TexturedModel.COLUMN);

		blockGen.createTrivialCube(SBBlocks.GLEAMING_ICE.get());
		createSpike(blockGen, SBBlocks.ICICLE.get(), "_frustum_down");
		createSpike(blockGen, SBBlocks.OBSIDIAN_SPIKE.get(), "_tip_up");
		createDoublePlantWithRenderType(blockGen, SBBlocks.TALL_DEAD_BUSH.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createTiltingBlock(blockGen, SBBlocks.CRACKED_MUD.get());
		blockGen.createTrivialCube(SBBlocks.PEAT.get());
		createFloatingPlant(blockGen, SBBlocks.ALGAE.get());

		blockGen.createRotatedVariantBlock(SBBlocks.BLACK_SAND.get());
		TexturedModel blackSandstoneModel = TexturedModel.TOP_BOTTOM_WITH_WALL.get(SBBlocks.BLACK_SANDSTONE.get());
		BlockModelGenerators.BlockFamilyProvider blackSandstone = blockGen.new BlockFamilyProvider(blackSandstoneModel.getMapping());
		blackSandstone.fullBlock(SBBlocks.BLACK_SANDSTONE.get(), blackSandstoneModel.getTemplate()).generateFor(SBBlockFamily.BLACK_SANDSTONE);

		TexturedModel smoothBlackSandstoneModel = TexturedModel.createAllSame(TextureMapping.getBlockTexture(SBBlocks.BLACK_SANDSTONE.get(), "_top"));
		BlockModelGenerators.BlockFamilyProvider smoothBlackSandstone = blockGen.new BlockFamilyProvider(smoothBlackSandstoneModel.getMapping());
		smoothBlackSandstone.fullBlock(SBBlocks.SMOOTH_BLACK_SANDSTONE.get(), smoothBlackSandstoneModel.getTemplate()).generateFor(SBBlockFamily.SMOOTH_BLACK_SANDSTONE);

		TexturedModel cutBlackSandstoneModel = TexturedModel.COLUMN.get(SBBlocks.BLACK_SANDSTONE.get()).updateTextures(mapping -> mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(SBBlocks.CUT_BLACK_SANDSTONE.get())));
		BlockModelGenerators.BlockFamilyProvider cutBlackSandstone = blockGen.new BlockFamilyProvider(cutBlackSandstoneModel.getMapping());
		cutBlackSandstone.fullBlock(SBBlocks.CUT_BLACK_SANDSTONE.get(), cutBlackSandstoneModel.getTemplate()).generateFor(SBBlockFamily.CUT_BLACK_SANDSTONE);

//		BlockModelGenerators.BlockFamilyProvider chiseledBlackSandstone = blockGen.new BlockFamilyProvider(TexturedModel.COLUMN.get(SBBlocks.CHISELED_BLACK_SANDSTONE.get()).updateTextures(mapping -> {
//			mapping.put(TextureSlot.END, TextureMapping.getBlockTexture(SBBlocks.BLACK_SANDSTONE.get(), "_top"));
//			mapping.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(SBBlocks.CHISELED_BLACK_SANDSTONE.get()));
//		}).getMapping());
//		chiseledBlackSandstone.fullBlockVariant(SBBlocks.CHISELED_BLACK_SANDSTONE.get());

		createDoublePlantWithRenderType(blockGen, SBBlocks.TALL_BROWN_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createDoublePlantWithRenderType(blockGen, SBBlocks.TALL_RED_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createMushroomBlock(SBBlocks.BLACK_MUSHROOM_BLOCK.get());//,"mushroom_block_dark_inside"
		createPlantWithRenderType(blockGen, SBBlocks.BLACK_MUSHROOM.get(), SBBlocks.POTTED_BLACK_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createDoublePlantWithRenderType(blockGen, SBBlocks.TALL_BLACK_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		blockGen.createMushroomBlock(SBBlocks.WHITE_MUSHROOM_BLOCK.get());
		createPlantWithRenderType(blockGen, SBBlocks.WHITE_MUSHROOM.get(), SBBlocks.POTTED_WHITE_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createDoublePlantWithRenderType(blockGen, SBBlocks.TALL_WHITE_MUSHROOM.get(), BlockModelGenerators.PlantType.NOT_TINTED);
//		createThinMushroomStem(blockGen, SBBlocks.THIN_MUSHROOM_STEM.get());

		blockGen.createTrivialCube(SBBlocks.ALBINO_REDWOOD_LEAVES.get());
		createPlantWithRenderType(blockGen, SBBlocks.ALBINO_REDWOOD_SAPLING.get(), SBBlocks.POTTED_ALBINO_REDWOOD_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);
		createGrowingPlantWithRenderType(blockGen, SBBlocks.WILLOW_BRANCH.get(), SBBlocks.WILLOW_BRANCH_PLANT.get(), BlockModelGenerators.PlantType.NOT_TINTED);

		itemGen.generateFlatItem(SBItems.MUSIC_DISC_INKISH.get(), ModelTemplates.FLAT_ITEM);

		itemGen.generateFlatItem(SBItems.JADE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.JADE_SHARD.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.CRYSTALLINE_WING.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.CRYSTALLINE_CLAW.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.CRYSTALLINE_CARAPACE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.INSECT_WING.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.INSECT_CLAW.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.INSECT_EYE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.INSECT_LEG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.FRIED_INSECT_LEG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.WITHERBONE.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.TIED_LEATHER.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.TANNED_LEATHER.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.MUD_BALL.get(), ModelTemplates.FLAT_ITEM);

		itemGen.generateFlatItem(SBItems.MANTIS_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.ANT_WORKER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.ANT_SOLDIER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.ANT_QUEEN_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.WITHER_SPIDER_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.TYRACHNID_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.DAMSELFLY_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.ENT_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.WUDU_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
		itemGen.generateFlatItem(SBItems.SPORETRAP_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
	}

	public void createInfusedCryptalith(BlockModelGenerators blockGen, Block block, Block bottom) {
		ResourceLocation active = ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(block, "_active", new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top_active")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")), blockGen.modelOutput);
		ResourceLocation inActive = ModelTemplates.CUBE_BOTTOM_TOP.create(block, new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")), blockGen.modelOutput);
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(BlockModelGenerators.createBooleanModelDispatch(BlockStateProperties.ACTIVE, active, inActive)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
	}

	public void createDepletedCryptalith(BlockModelGenerators blockGen, Block block, Block bottom) {
		TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom)).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, blockGen.modelOutput)).with(BlockModelGenerators.createHorizontalFacingDispatch()));
	}

	public void createStyphium(BlockModelGenerators blockGen, Block block) {
		TextureMapping mapping = new TextureMapping().put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(block, "_bottom")).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side"));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, mapping, blockGen.modelOutput)));
	}

	public void createTiltingBlock(BlockModelGenerators blockGen, Block block) {
		PropertyDispatch.C1<Tilt> property = PropertyDispatch.property(BlockStateProperties.TILT);
		for (Tilt tilt : Tilt.values()) property.select(tilt, createTiltingBlockVariant(blockGen, block, tilt));
		blockGen.registerSimpleItemModel(block.asItem(), TextureMapping.getBlockTexture(block).withSuffix("_unstable"));
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(property));
	}

	public Variant createTiltingBlockVariant(BlockModelGenerators blockGen, Block block, Tilt tilt) {
		String suffix = "_" + tilt.getSerializedName();
		TextureMapping mapping = TextureMapping.cube(TextureMapping.getBlockTexture(block, suffix));
		return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.CUBE_ALL.createWithSuffix(block, suffix, mapping, blockGen.modelOutput));
	}

	public void createSpike(BlockModelGenerators blockGen, Block block, String suffix) {
		PropertyDispatch.C2<Direction, DripstoneThickness> properties = PropertyDispatch.properties(BlockStateProperties.VERTICAL_DIRECTION, BlockStateProperties.DRIPSTONE_THICKNESS);
		for (DripstoneThickness thickness : DripstoneThickness.values()) properties.select(Direction.UP, thickness, createSpikeVariant(blockGen, block, Direction.UP, thickness));
		for (DripstoneThickness thickness : DripstoneThickness.values()) properties.select(Direction.DOWN, thickness, createSpikeVariant(blockGen, block, Direction.DOWN, thickness));
		blockGen.registerSimpleFlatItemModel(block, suffix);
		blockGen.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(properties));
	}

	public Variant createSpikeVariant(BlockModelGenerators blockGen, Block block, Direction direction, DripstoneThickness thickness) {
		String suffix = "_" + thickness.getSerializedName() + "_" + direction.getSerializedName();
		TextureMapping mapping = TextureMapping.cross(TextureMapping.getBlockTexture(block, suffix));
		return Variant.variant().with(VariantProperties.MODEL, ModelTemplates.POINTED_DRIPSTONE.extend().renderType("minecraft:cutout").build().createWithSuffix(block, suffix, mapping, blockGen.modelOutput));
	}

	public void createFloatingPlant(BlockModelGenerators blockGen, Block block) {
		blockGen.registerSimpleFlatItemModel(block);
		blockGen.blockStateOutput.accept(BlockModelGenerators.createRotatedVariant(block, ModelLocationUtils.getModelLocation(block)));
	}

	public void createPlantWithRenderType(BlockModelGenerators blockGen, Block plant, Block potted, BlockModelGenerators.PlantType type) {
		blockGen.registerSimpleItemModel(plant.asItem(), type.createItemModel(blockGen, plant));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(plant, type.getCross().extend().renderType("minecraft:cutout").build().create(plant, type.getTextureMapping(plant), blockGen.modelOutput)));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(potted, type.getCrossPot().extend().renderType("minecraft:cutout").build().create(potted, type.getPlantTextureMapping(plant), blockGen.modelOutput)));
	}

	public void createDoublePlantWithRenderType(BlockModelGenerators blockGen, Block plant, BlockModelGenerators.PlantType type) {
		blockGen.registerSimpleFlatItemModel(plant, "_top");
		blockGen.createDoubleBlock(plant, blockGen.createSuffixedVariant(plant, "_top", type.getCross().extend().renderType("minecraft:cutout").build(), TextureMapping::cross), blockGen.createSuffixedVariant(plant, "_bottom", type.getCross().extend().renderType("minecraft:cutout").build(), TextureMapping::cross));
	}

	public void createGrowingPlantWithRenderType(BlockModelGenerators blockGen, Block plantEnd, Block plant, BlockModelGenerators.PlantType type) {
		blockGen.registerSimpleFlatItemModel(plantEnd);
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(plantEnd, type.getCross().extend().renderType("minecraft:cutout").build().create(plantEnd, type.getTextureMapping(plantEnd), blockGen.modelOutput)));
		blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(plant, type.getCross().extend().renderType("minecraft:cutout").build().create(plant, type.getTextureMapping(plant), blockGen.modelOutput)));
	}

	private void generateWoodFamilies(BlockModelGenerators blockGen, ItemModelGenerators itemGen) {
		WoodFamily.getAllFamilies().forEach(family -> {
			BlockModelGenerators.BlockFamilyProvider planks = blockGen.family((Block) family.get(WoodFamily.Variant.PLANKS).get());
			BlockModelGenerators.WoodProvider wood = blockGen.woodProvider((Block) family.get(WoodFamily.Variant.LOG).get());
			BlockModelGenerators.WoodProvider stripped = blockGen.woodProvider((Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get());

			family.getVariants().forEach((variant, supplier) -> {
				if (supplier.get() == null) return;
				switch (variant) {
					case BOAT_ITEM, CHEST_BOAT_ITEM -> itemGen.generateFlatItem((Item) supplier.get(), ModelTemplates.FLAT_ITEM);
					case BUTTON -> planks.button((Block) supplier.get());
					case DOOR -> planks.door((Block) supplier.get());
					case FENCE -> planks.fence((Block) supplier.get());
					case FENCE_GATE -> planks.fenceGate((Block) supplier.get());
					case HANGING_SIGN -> blockGen.createHangingSign((Block) family.get(WoodFamily.Variant.STRIPPED_LOG).get(), (Block) supplier.get(), (Block) family.get(WoodFamily.Variant.WALL_HANGING_SIGN).get());
					case LEAVES -> blockGen.createTrivialCube((Block) supplier.get());
					case LOG -> wood.log((Block) supplier.get());
					case SAPLING -> createPlantWithRenderType(blockGen, (Block) supplier.get(), (Block) family.get(WoodFamily.Variant.POTTED_SAPLING).get(), BlockModelGenerators.PlantType.NOT_TINTED);
					case SIGN -> {
						ResourceLocation location = ModelTemplates.PARTICLE_ONLY.create((Block) supplier.get(), TexturedModel.CUBE.get((Block) family.get(WoodFamily.Variant.PLANKS).get()).getMapping(), blockGen.modelOutput);
						blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock((Block) supplier.get(), location));
						blockGen.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock((Block) family.get(WoodFamily.Variant.WALL_SIGN).get(), location));
						blockGen.registerSimpleFlatItemModel(((Block) supplier.get()).asItem());
					}
					case SLAB -> planks.slab((Block) supplier.get());
					case STAIRS -> planks.stairs((Block) supplier.get());
					case STRIPPED_LOG -> stripped.log((Block) supplier.get());
					case STRIPPED_WOOD -> stripped.wood((Block) supplier.get());
					case PRESSURE_PLATE -> planks.pressurePlate((Block) supplier.get());
					case TRAPDOOR -> planks.trapdoor((Block) supplier.get());
					case WOOD -> wood.wood((Block) supplier.get());
				}
			});
		});
	}

	private void generateBlockFamilies(BlockModelGenerators blockGen) {
		SBBlockFamily.getAllFamilies().filter(BlockFamily::shouldGenerateModel).forEach(family -> blockGen.family(family.getBaseBlock()).generateFor(family));
	}
}
