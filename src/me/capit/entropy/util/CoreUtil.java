package me.capit.entropy.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import me.capit.entropy.EntropyMain;

public class CoreUtil {
	final EntropyMain plugin;
	public CoreUtil(EntropyMain plugin){
		this.plugin = plugin;
	}
	
	public boolean areaEmpty(World world, Location corner1, Location corner2){
		for (int y=corner1.getBlockY();y<corner2.getBlockY();y++){
			for (int x=corner1.getBlockX();x<corner2.getBlockX();x++){
				for (int z=corner1.getBlockZ();z<corner2.getBlockZ();z++){
					if (world.getBlockAt(x, y, z).getType()!=Material.AIR) return false;
				}
			}
		}
		return true;
	}
	

	public boolean structureFits(World world, Structure structure, Location loc){
		
		return false;
	}
	
}
