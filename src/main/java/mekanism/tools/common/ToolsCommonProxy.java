package mekanism.tools.common;

import mekanism.common.Mekanism;
import mekanism.tools.common.MekanismTools.FeaturePrefs;

public class ToolsCommonProxy 
{
	/**
	 * Set and load the mod's common configuration properties.
	 */
	public void loadConfiguration()
	{
		MekanismTools.armorSpawnRate = Mekanism.configuration.get("tools.general", "MobArmorSpawnRate", 0.03, null, 0.00, 1.00).getDouble(0.03);

		for(FeaturePrefs feature : FeaturePrefs.values()) {
			feature.enabled = Mekanism.configuration.get("tools.prefs."+feature.configName, "---", true).getBoolean();
		}

		if(Mekanism.configuration.hasChanged())
			Mekanism.configuration.save();
	}
}
