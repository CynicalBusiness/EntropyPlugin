package me.capit.entropy.util;

import java.io.Serializable;

import me.capit.entropy.EntropyMain;

import org.bukkit.Location;

public abstract class Structure implements Serializable {
	private static final long serialVersionUID = -1676410770889394409L;
	private final StructureData data;
	private final Location loc;
	private final int townID;
	
	//Adding a temp tax system in. towntaxlevel * (1 + taxmodifier)
	public Structure(StructureData data, Location loc, int townID, double taxModifier){
		this.data = data;
		this.loc = loc;
		this.townID = townID;
	}
	
	public final String getName(){
		return data.getDisplayName();
	}
	
	public StructureData getData(){
		return data;
	}
	
	public Location getLocation(){
		return loc;
	}
	
	public int getTownID(){
		return townID;
	}
	
	public Town getTown(){
		return EntropyMain.getTownByID(townID);
	}
	
}
