package net.invictusslayer.slayersbeasts.neoforge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.Objects;
import java.util.function.Supplier;

public class SBSoundDefinitionsProvider extends SoundDefinitionsProvider {
	protected SBSoundDefinitionsProvider(PackOutput output) {
		super(output, SlayersBeasts.MOD_ID);
	}

	public void registerSounds() {
		addMusicDisc(SBSounds.MUSIC_DISC_INKISH);

		addSound(SBSounds.MANTIS_AMBIENT);
		addSound(SBSounds.MANTIS_DEATH);
		addSound(SBSounds.MANTIS_HURT);
	}

	private void addMusicDisc(Supplier<Holder.Reference<SoundEvent>> sound) {
		add(sound.get().value(), SoundDefinition.definition().with(sound(Objects.requireNonNull(sound.get().getKey()).location().toString().replace(".", "/")).stream()));
	}

	private void addSound(Supplier<SoundEvent> sound) {
		add(sound.get(), SoundDefinition.definition().with(sound(sound.get().location().toString().replace(".", "/"))).subtitle(sound.get().location().toLanguageKey("subtitles")));
	}
}
