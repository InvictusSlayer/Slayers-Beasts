package net.invictusslayer.slayersbeasts.common.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.client.state.AntWorkerRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class AntCargoModel extends EntityModel<AntWorkerRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, "ant_worker_model"), "cargo");
//	private final ModelPart cargo;

	public AntCargoModel(ModelPart root) {
		super(root);
//		this.cargo = root.getChild("cargo");
	}

	public void setupAnim(AntWorkerRenderState state) {
		super.setupAnim(state);
	}

	public static LayerDefinition createCargoLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cargo = partdefinition.addOrReplaceChild("cargo", CubeListBuilder.create().texOffs(5, 6).addBox(-0.5F, -4.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-0.5F, -5.0F, -3.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(6, 0).addBox(-0.5F, -6.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 7).addBox(-0.5F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.75F, -5.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}
}
