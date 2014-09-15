package me.capit.entropy.util;

import java.io.Serializable;

import org.bukkit.configuration.ConfigurationSection;

import me.capit.entropy.EntropyMain;

public class StructureData implements Serializable {
	private static final long serialVersionUID = -848667128668047120L;
	private final ConfigurationSection config;
	private final String name;
	
	public StructureData(EntropyMain plugin, String name){
		this.name = name;
		if (plugin.getConfig().contains("buildings."+name)){
			config = plugin.getConfig().getConfigurationSection("buildings."+name);
		} else {
			config = plugin.getConfig().getConfigurationSection("buildings.Missing");
		}
	}
	
	public int getWidth(){
		return config.getInt("boundWidth");
	}
	
	public int getHeight(){
		return config.getInt("boundHeight");
	}
	
	public Schematic getSchematic(){
		// TODO
		return null;
	}
	
	public String getDisplayName(){
		return config.getString("displayName");
	}
	
	public String getName(){
		return name;
	}
	
	public boolean needsRoad(){
		return config.getBoolean("road");
	}
	
}
