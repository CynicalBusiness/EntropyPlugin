package me.capit.entropy.blueprints;

import java.io.Serializable;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SerialBlock implements Serializable{
	private static final long serialVersionUID = 910504721830373628L;
	
	private String world;
	private int x,y,z;
	
	public SerialBlock(String world, int x, int y, int z){
		this.world = world;
		this.x=x;this.y=y;this.z=z;
	}
	
	public Block getBlock(){
		World w = Bukkit.getWorld(world);
		return w.getBlockAt(x, y, z);
	}
}