package me.capit.entropy.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.capit.entropy.EntropyMain;

public class Town implements Serializable {
	private static final long serialVersionUID = -8979383970183615150L;
	final EntropyMain plugin;
	
	private final UUID owner;
	
	private int daysOfInactivityLeft = 7;
	private int storageUsed;
	private String name;
	
	private List<Structure> structures = new ArrayList<Structure>();
	
	private ArrayList<UUID> players = new ArrayList<UUID>();
	
	public Town(EntropyMain plugin, UUID owner, String name, int storageUsed){
		this.plugin = plugin;
		this.owner = owner;
		this.name = name;
		this.storageUsed = storageUsed;
	}
	
	public String getName(){
		return name;
	}
	
	public UUID getOwner(){
		return owner;
	}
	
	public int getStorageUsed(){
		return storageUsed;
	}
	
	public void setStorageUsed(int amount){
		storageUsed = amount;
	}
	
	public void inactiveDay(){
		daysOfInactivityLeft--;
	}
	
	public int getInactiveDays(){
		return daysOfInactivityLeft;
	}
	
	public void setInactiveDays(int days){
		daysOfInactivityLeft = days;
	}
	
	public void addStructure(Structure structure){
		structures.add(structure);
	}
	
	public void removeStructure(Structure structure){
		structures.remove(structure);
	}
	
	public List<Structure> getStructures(){
		return structures;
	}
	
	public void addPlayer(UUID uuid){
		players.add(uuid);
	}
	
	public void removePlayer(UUID uuid){
		players.remove(uuid);
	}
	
	public ArrayList<UUID> getPlayers(){
		return players;
	}
	
}
