package me.capit.entropy.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import me.capit.entropy.EntropyMain;

public class Town implements Serializable {
	private static final long serialVersionUID = -8979383970183615150L;
	final EntropyMain plugin;
	
	private final UUID owner;
	private final int id;
	
	private int daysOfInactivityLeft = 7;
	private String name;
	private boolean abandoned = false;
	
	private List<Structure> structures = new ArrayList<Structure>();
	private List<UUID> players = new ArrayList<UUID>();
	
	private String getAdaptedName(String name){
		return getAdaptedName(name,0);
	}
	
	private String getAdaptedName(String name, int trys){
		name = trys>0 ? name.substring(0, name.length()-3) : name; // Used 3 because of index offset.
		if (EntropyMain.getTownByName(name)==null){
			return trys>0 ? name+" "+trys : name;
		} else {
			return getAdaptedName(name, ++trys);
		}
	}
	
	//With the tax system, the town mayor or what will be able to set different scale
	//taxes based on how much money a person earns (for their job or whatever they earn money from)
	//e.g. players who earn 2K or less a minecraft day get 0% tax. earn more than 100K has 40% tax
	//not sure how we should create this, i was thinking a map but im not sure...
	public Town(EntropyMain plugin, UUID owner, String name){
		this.plugin = plugin;
		this.owner = owner;
		this.id = EntropyMain.towns.size();
		
		List<String> names = plugin.getConfig().getStringList("default_city_names");
		Random rand = new Random();
		IntStream is = rand.ints(1L, 0, names.size()-1); // Index offset again.
		this.name = getAdaptedName(names.get(is.toArray()[0]));
		is.close();
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = getAdaptedName(name);
	}
	
	public UUID getOwner(){
		return owner;
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
	
	public List<UUID> getPlayers(){
		return players;
	}
	
	public boolean isAbandoned(){
		return abandoned;
	}
	
}
