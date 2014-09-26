package me.capit.entropy;

import java.util.UUID;

public class User {
	
	private UUID uuid;
	private int tokens;
	private int bitcoins;
	
	public User(UUID uuid){
		this.uuid = uuid;
	}
	//Used to load back from the files (possibly)
	public User(UUID uuid, int tokens, int bitcoins){
		this.uuid = uuid;
		this.tokens = tokens;
		this.bitcoins = bitcoins;
	}
	
	public UUID getUniqueId(){
		return this.uuid;
	}
	
	public int getTokens(){
		return this.tokens;
	}
	
	public int getBitCoins(){
		return this.bitcoins;
	}

}
