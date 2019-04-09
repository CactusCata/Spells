package com.gmail.cactuscata.spells;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Test(this), this);

	}

}
