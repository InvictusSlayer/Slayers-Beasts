package net.invictusslayer.slayersbeasts.datagen;

import net.invictusslayer.slayersbeasts.SlayersBeasts;
import net.invictusslayer.slayersbeasts.sound.SBSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.registries.RegistryObject;

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

	private void addMusicDisc(RegistryObject<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(sound(sound.getId().toString().replace(".", "/")).stream()));
	}

	private void addSound(RegistryObject<SoundEvent> sound) {
		add(sound, SoundDefinition.definition().with(sound(sound.getId().toString().replace(".", "/"))).subtitle(sound.getId().toLanguageKey("subtitles")));
	}
}
