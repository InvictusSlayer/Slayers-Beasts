package net.invictusslayer.slayersbeasts.common.item;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;

public class SBJukeboxSongs {
	public static final ResourceKey<JukeboxSong> INKISH = createKey("inkish");

	public static void bootstrap(BootstrapContext<JukeboxSong> context) {
		HolderGetter<SoundEvent> soundEvents = context.lookup(Registries.SOUND_EVENT);

		register(context, INKISH, soundEvents.getOrThrow(SBSounds.MUSIC_DISC_INKISH.getKey()), 220, 1);
	}

	private static ResourceKey<JukeboxSong> createKey(String key) {
		return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(SlayersBeasts.MOD_ID, key));
	}

	private static void register(BootstrapContext<JukeboxSong> context, ResourceKey<JukeboxSong> key, Holder.Reference<SoundEvent> soundEvent, float lengthInSeconds, int comparatorOutput) {
		context.register(key, new JukeboxSong(soundEvent, Component.translatable(Util.makeDescriptionId("jukebox_song", key.location())), lengthInSeconds, comparatorOutput));
	}
}
