package me.capit.entropy.util;

import java.io.Serializable;

import me.capit.entropy.EntropyMain;

public class Town implements Serializable {
	private static final long serialVersionUID = -8979383970183615150L;
	final EntropyMain plugin;
	
	public Town(EntropyMain plugin){
		this.plugin = plugin;
	}
	
}
