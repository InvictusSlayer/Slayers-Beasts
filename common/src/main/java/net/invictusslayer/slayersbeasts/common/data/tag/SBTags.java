package net.invictusslayer.slayersbeasts.common.data.tag;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class SBTags {
	public static class Blocks {
		public static final TagKey<Block> SEPULCHRA_PORTAL_FRAME = tag("sepulchra_portal_frame");

		public static final TagKey<Block> ANTHILLS = tag("anthills");
		public static final TagKey<Block> ANTHILL_REPLACEABLE = tag("anthill_replaceable");
		public static final TagKey<Block> ICICLE_REPLACEABLE = tag("icicle_replaceable");
		public static final TagKey<Block> STYPHIUM_REPLACEABLE = tag("styphium_replaceable");

		public static final TagKey<Block> ASPEN_LOGS = tag("aspen_logs");
		public static final TagKey<Block> CAJOLE_LOGS = tag("cajole_logs");
		public static final TagKey<Block> DESERT_OAK_LOGS = tag("desert_oak_logs");
		public static final TagKey<Block> EUCALYPTUS_LOGS = tag("eucalyptus_logs");
		public static final TagKey<Block> KAPOK_LOGS = tag("kapok_logs");
		public static final TagKey<Block> REDWOOD_LOGS = tag("redwood_logs");
		public static final TagKey<Block> WILLOW_LOGS = tag("willow_logs");

		private static TagKey<Block> tag(String name) {
			return TagKey.create(Registries.BLOCK, new ResourceLocation(SlayersBeasts.MOD_ID, name));
		}
	}

	public static class Items {
		public static final TagKey<Item> ASPEN_LOGS = tag("aspen_logs");
		public static final TagKey<Item> CAJOLE_LOGS = tag("cajole_logs");
		public static final TagKey<Item> DESERT_OAK_LOGS = tag("desert_oak_logs");
		public static final TagKey<Item> EUCALYPTUS_LOGS = tag("eucalyptus_logs");
		public static final TagKey<Item> KAPOK_LOGS = tag("kapok_logs");
		public static final TagKey<Item> REDWOOD_LOGS = tag("redwood_logs");
		public static final TagKey<Item> WILLOW_LOGS = tag("willow_logs");

		private static TagKey<Item> tag(String name) {
			return TagKey.create(Registries.ITEM, new ResourceLocation(SlayersBeasts.MOD_ID, name));
		}
	}

	public static class Biomes {
		public static final TagKey<Biome> SLAYERS_BIOMES = tag("slayers_biomes");
		public static final TagKey<Biome> WOOD_ANT_HABITAT = tag("wood_ant_habitat");
		public static final TagKey<Biome> LEAFCUTTER_ANT_HABITAT = tag("leafcutter_ant_habitat");
		public static final TagKey<Biome> MEADOW_ANT_HABITAT = tag("meadow_ant_habitat");

		public static final TagKey<Biome> IS_BRUSHLAND = tag("is_brushland");

		public static final TagKey<Biome> HAS_CRYPT_PORTAL = structureTag("crypt_portal");

		public static final TagKey<Biome> PLACES_ALGAE_COMMON = featureTag("algae_common");
		public static final TagKey<Biome> PLACES_ALGAE_NORMAL = featureTag("algae_normal");
		public static final TagKey<Biome> PLACES_EXOSKELETON_LUSH = featureTag("exoskeleton_lush");

		public static final TagKey<Biome> SPAWNS_MANTIS = spawnsTag("mantis");
		public static final TagKey<Biome> SPAWNS_DAMSELFLY = spawnsTag("damselfly");
		public static final TagKey<Biome> SPAWNS_ENT_OAK = spawnsTag("ent_oak");
		public static final TagKey<Biome> SPAWNS_ENT_BIRCH = spawnsTag("ent_birch");
		public static final TagKey<Biome> SPAWNS_ENT_SPRUCE = spawnsTag("ent_spruce");
		public static final TagKey<Biome> SPAWNS_ENT_DARK_OAK = spawnsTag("ent_dark_oak");
		public static final TagKey<Biome> SPAWNS_ENT_ACACIA = spawnsTag("ent_acacia");
		public static final TagKey<Biome> SPAWNS_ENT_JUNGLE = spawnsTag("ent_jungle");

		private static TagKey<Biome> structureTag(String name) {
			return tag("has_structure/" + name);
		}

		private static TagKey<Biome> featureTag(String name) {
			return tag("has_feature/" + name);
		}

		private static TagKey<Biome> spawnsTag(String name) {
			return tag("spawns_entity/" + name);
		}

		private static TagKey<Biome> tag(String name) {
			return TagKey.create(Registries.BIOME, new ResourceLocation(SlayersBeasts.MOD_ID, name));
		}
	}

	public static class EntityTypes {
		public static final TagKey<EntityType<?>> ANTHILL_INHABITANTS = tag("anthill_inhabitants");
		public static final TagKey<EntityType<?>> PEAT_WALKABLE_MOBS = tag("peat_walkable_mobs");

		private static TagKey<EntityType<?>> tag(String name) {
			return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
		}
	}

	public static class PoiTypes {
		public static final TagKey<PoiType> ANT_HOME = tag("ant_home");

		private static TagKey<PoiType> tag(String name) {
			return TagKey.create(Registries.POINT_OF_INTEREST_TYPE, new ResourceLocation(SlayersBeasts.MOD_ID, name));
		}
	}
}
