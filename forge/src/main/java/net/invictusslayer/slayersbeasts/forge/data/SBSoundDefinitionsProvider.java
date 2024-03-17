package net.invictusslayer.slayersbeasts.forge.data;

import dev.architectury.registry.registries.RegistrySupplier;
import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SBSoundDefinitionsProvider extends SoundDefinitionsProvider {
	protected SBSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, SlayersBeasts.MOD_ID, helper);
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
