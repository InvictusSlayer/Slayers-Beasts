package net.invictusslayer.slayersbeasts.forge.data;

import net.invictusslayer.slayersbeasts.common.SlayersBeasts;
import net.invictusslayer.slayersbeasts.common.init.SBSounds;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import java.util.function.Supplier;

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

	private void addMusicDisc(Supplier<Holder.Reference<SoundEvent>> sound) {
		add(sound.get().value(), SoundDefinition.definition().with(sound(sound.get().value().getLocation().getPath().replace(".", "/")).stream()));
	}

	private void addSound(Supplier<SoundEvent> sound) {
		add(sound.get(), SoundDefinition.definition().with(sound(sound.get().getLocation().getPath().replace(".", "/"))).subtitle(sound.get().getLocation().toLanguageKey("subtitles")));
	}
}
