package net.invictusslayer.slayersbeasts.common.data.lang;

import com.google.gson.JsonObject;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.block.WoodFamily;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public abstract class SBLangProvider implements DataProvider {
	private final Map<String, String> data = new TreeMap<>();
	private final PackOutput output;
	private final String locale;

	public SBLangProvider(PackOutput output, String locale) {
		this.output = output;
		this.locale = locale;
	}

	protected abstract void addTranslations();

	public CompletableFuture<?> run(CachedOutput cache) {
		addTranslations();

		if (!data.isEmpty()) return save(cache, output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(SlayersBeasts.MOD_ID).resolve("lang").resolve(locale + ".json"));

		return CompletableFuture.allOf();
	}

	public String getName() {
		return "Languages: " + locale;
	}

	private CompletableFuture<?> save(CachedOutput cache, Path path) {
		JsonObject json = new JsonObject();
		data.forEach(json::addProperty);

		return DataProvider.saveStable(cache, json, path);
	}

	protected void addBlock(Supplier<? extends Block> key, String name) {
		add(key.get(), name);
	}

	protected void add(Block key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void addItem(Supplier<? extends Item> key, String name) {
		add(key.get(), name);
	}

	protected void add(Item key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void addItemStack(Supplier<ItemStack> key, String name) {
		add(key.get(), name);
	}

	protected void add(ItemStack key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void addEnchantment(Supplier<? extends Enchantment> key, String name) {
		add(key.get(), name);
	}

	protected void add(Enchantment key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void addEffect(Supplier<? extends MobEffect> key, String name) {
		add(key.get(), name);
	}

	protected void add(MobEffect key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void addEntityType(Supplier<? extends EntityType<?>> key, String name) {
		add(key.get(), name);
	}

	protected void add(EntityType<?> key, String name) {
		add(key.getDescriptionId(), name);
	}

	protected void add(String key, String value) {
		if (data.put(key, value) != null) throw new IllegalStateException("Duplicate translation key " + key);
	}

	protected void addSound(Supplier<? extends SoundEvent> key, String name) {
		add(key.get().getLocation().toLanguageKey("subtitles"), name);
	}

	protected void addItemDesc(Supplier<? extends Item> key, String name) {
		add(key.get().getDescriptionId() + ".desc", name);
	}

	protected void addConfig(String key, String name) {
		add("text.autoconfig." + SlayersBeasts.MOD_ID + "." + key, name);
	}

	protected void addConfigTitle(String name) {
		addConfig("title", name);
	}

	protected void addConfigCategory(String key, String name) {
		addConfig("category." + key, name);
	}

	protected void addConfigOption(String key, String name) {
		addConfig("option." + key, name);
	}

	protected void addConfigOptionPrefix(String key, String name, String prefix) {
		addConfigOption(key, name);
		addConfigOption(key + ".@PrefixText", prefix);
	}

	protected void addConfigEnumTooltip(String key, int ordinal, String name) {
		addConfig(key + ".@Tooltip[" + ordinal + "]", name);
	}

	protected void addWoodFamily(WoodFamily family, String prefix) {
		family.getVariants().forEach((variant, object) -> {
			if (variant.getName() != null && object.isPresent()) {
				String name = prefix + " " + variant.getName();
				if (object.get() instanceof Block block) {
					addBlock(() -> block, name);
				} else if (object.get() instanceof Item item) {
					addItem(() -> item, name);
				}
			}
		});
	}

	protected void addBlockFamily(BlockFamily family, String name) {
		addBlock(family::getBaseBlock, name);
		family.getVariants().forEach(((variant, block) -> {
			if (variant.equals(BlockFamily.Variant.BUTTON)) {
				addBlock(() -> block, name + " Button");
			} else if (variant.equals(BlockFamily.Variant.CHISELED)) {
				addBlock(() -> block, "Chiseled " + name);
			} else if (variant.equals(BlockFamily.Variant.DOOR)) {
				addBlock(() -> block, name + " Door");
			} else if (variant.equals(BlockFamily.Variant.FENCE)) {
				addBlock(() -> block, name + " Fence");
			} else if (variant.equals(BlockFamily.Variant.FENCE_GATE)) {
				addBlock(() -> block, name + " Fence Gate");
			} else if (variant.equals(BlockFamily.Variant.SIGN)) {
				addBlock(() -> block, name + " Sign");
			} else if (variant.equals(BlockFamily.Variant.SLAB)) {
				addBlock(() -> block, name + " Slab");
			} else if (variant.equals(BlockFamily.Variant.STAIRS)) {
				addBlock(() -> block, name + " Stairs");
			} else if (variant.equals(BlockFamily.Variant.PRESSURE_PLATE)) {
				addBlock(() -> block, name + " Pressure Plate");
			} else if (variant.equals(BlockFamily.Variant.TRAPDOOR)) {
				addBlock(() -> block, name + " Trapdoor");
			} else if (variant.equals(BlockFamily.Variant.WALL)) {
				addBlock(() -> block, name + " Wall");
			}
		}));
	}
}
