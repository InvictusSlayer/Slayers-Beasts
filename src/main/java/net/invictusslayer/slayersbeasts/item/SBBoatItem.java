package net.invictusslayer.slayersbeasts.item;

import net.invictusslayer.slayersbeasts.entity.SBBoat;
import net.invictusslayer.slayersbeasts.entity.SBChestBoat;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class SBBoatItem extends Item {
	private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
	private final SBBoat.Type type;
	private final boolean hasChest;

	public SBBoatItem(boolean chestBoat, SBBoat.Type type, Item.Properties properties) {
		super(properties.stacksTo(1));
		this.hasChest = chestBoat;
		this.type = type;
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack item = player.getItemInHand(hand);
		HitResult result = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
		if (result.getType() == HitResult.Type.MISS) {
			return InteractionResultHolder.pass(item);
		} else {
			Vec3 vec3 = player.getViewVector(1.0F);
			List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vec3 vec31 = player.getEyePosition();

				for (Entity entity : list) {
					AABB aabb = entity.getBoundingBox().inflate(entity.getPickRadius());
					if (aabb.contains(vec31)) {
						return InteractionResultHolder.pass(item);
					}
				}
			}

			if (result.getType() == HitResult.Type.BLOCK) {
				Boat boat = getBoat(level, result);
				if (boat instanceof SBBoat boat1) boat1.setVariant(type);
				if (boat instanceof SBChestBoat boat1) boat1.setVariant(type);

				boat.setYRot(player.getYRot());
				if (!level.noCollision(boat, boat.getBoundingBox())) return InteractionResultHolder.fail(item);

				if (!level.isClientSide) {
					level.addFreshEntity(boat);
					level.gameEvent(player, GameEvent.ENTITY_PLACE, result.getLocation());
					if (!player.getAbilities().instabuild) {
						item.shrink(1);
					}
				}

				player.awardStat(Stats.ITEM_USED.get(this));
				return InteractionResultHolder.sidedSuccess(item, level.isClientSide());

			} else {
				return InteractionResultHolder.pass(item);
			}
		}
	}

	private Boat getBoat(Level level, HitResult result) {
		return hasChest ? new SBChestBoat(level, result.getLocation().x, result.getLocation().y, result.getLocation().z) : new SBBoat(level, result.getLocation().x, result.getLocation().y, result.getLocation().z);
	}
}
