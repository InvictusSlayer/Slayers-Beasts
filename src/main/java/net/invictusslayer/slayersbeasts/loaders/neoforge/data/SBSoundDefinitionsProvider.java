//? if neoforge {
/*package net.invictusslayer.slayersbeasts.loaders.neoforge.data;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.init.SBSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

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

	private void addMusicDisc(Supplier<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(SoundDefinitionsProvider.sound(sound.get().location().toString().replace(".", "/")).stream()));
	}

	private void addSound(Supplier<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(SoundDefinitionsProvider.sound(sound.get().location().toString().replace(".", "/"))).subtitle(sound.get().location().toLanguageKey("subtitles")));
	}
}
*///?}