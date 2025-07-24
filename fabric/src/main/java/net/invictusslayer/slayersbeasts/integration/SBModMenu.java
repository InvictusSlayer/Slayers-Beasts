package net.invictusslayer.slayersbeasts.integration;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.invictusslayer.slayersbeasts.config.SBConfig;

@Environment(EnvType.CLIENT)
public class SBModMenu implements ModMenuApi {
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(SBConfig.class, parent).get();
	}
}
