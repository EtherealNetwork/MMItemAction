package com.minemee.MMItemAction;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MMItemAction extends JavaPlugin {

	Logger log = Logger.getLogger("Minecraft");
	 
	public final MMItemActionBlockListener blockListener = new MMItemActionBlockListener();
	
	public void onEnable(){
		log.info("MMItemAction enabled!");
		
		PluginManager pm = getServer().getPluginManager();
	
		pm.registerEvents(this.blockListener, this);
	}
 
	public void onDisable(){
		log.info("MMItemAction disabled.");
	}
	
}
