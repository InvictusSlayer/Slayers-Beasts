package net.invictusslayer.slayersbeasts.neoforge.data;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

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

	private void addMusicDisc(RegistrySupplier<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(sound(sound.getId().toString().replace(".", "/")).stream()));
	}

	private void addSound(RegistrySupplier<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(sound(sound.getId().toString().replace(".", "/"))).subtitle(sound.getId().toLanguageKey("subtitles")));
	}
}
