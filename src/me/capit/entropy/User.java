package me.capit.entropy;

import java.util.UUID;

public class User {
	
	private UUID uuid;
	private int tokens;
	
	public User(UUID uuid){
		this.uuid = uuid;
	}

}
