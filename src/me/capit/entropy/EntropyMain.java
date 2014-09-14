package me.capit.entropy;

import java.util.logging.Logger;

import me.capit.ds_mc.DSMCMain;
import me.capit.entropy.util.CoreUtil;

import org.bukkit.plugin.java.JavaPlugin;

public class EntropyMain extends JavaPlugin {
	public static Logger logger;
	public static CoreUtil util;
	
	@Override
	public void onEnable(){
		logger = this.getLogger();
		logger.info(DSMCMain.formHeader(EntropyMain.class));
		
		logger.info("Loading utilities...");
		util = new CoreUtil(this);
		
		// TODO
	}
	
	@Override
	public void onDisable(){
		
	}
	
}
