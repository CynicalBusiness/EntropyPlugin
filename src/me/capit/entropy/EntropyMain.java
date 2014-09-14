package me.capit.entropy;

import java.util.logging.Logger;

import me.capit.ds_mc.DSMCMain;

import org.bukkit.plugin.java.JavaPlugin;

public class EntropyMain extends JavaPlugin {
	public static Logger logger;
	
	@Override
	public void onEnable(){
		logger = this.getLogger();
		logger.info(DSMCMain.formHeader(EntropyMain.class));
		
		// TODO
	}
	
	@Override
	public void onDisable(){
		
	}
	
}
