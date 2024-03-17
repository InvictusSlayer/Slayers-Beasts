package net.invictusslayer.slayersbeasts.common.data.loot;

import com.google.common.collect.Sets;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class SBLootTables {
	private static final Set<ResourceLocation> LOCATIONS = Sets.newHashSet();
	private static final Set<ResourceLocation> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

	public static final ResourceLocation CRYPT_COMMON = register("chests/crypt_common");
	public static final ResourceLocation CRYPT_RARE = register("chests/crypt_rare");

	private static ResourceLocation register(String path) {
		ResourceLocation id = new ResourceLocation(SlayersBeasts.MOD_ID, path);
		if (LOCATIONS.add(id)) {
			return id;
		} else {
			throw new IllegalArgumentException(id + " is already a registered loot table");
		}
	}

	public static Set<ResourceLocation> all() {
		return IMMUTABLE_LOCATIONS;
	}
}
