package me.capit.entropy.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import me.capit.entropy.EntropyMain;

public class CoreUtil {
	final EntropyMain plugin;

	public CoreUtil(EntropyMain plugin) {
		this.plugin = plugin;
	}

	public boolean areaOnlyContains(Location corner1, Location corner2, Material mat){
		if (corner1.getWorld().getName().equalsIgnoreCase(corner2.getWorld().getName())){
			for (int y = corner1.getBlockY(); y < corner2.getBlockY(); y++) {
				for (int x = corner1.getBlockX(); x < corner2.getBlockX(); x++) {
					for (int z = corner1.getBlockZ(); z < corner2.getBlockZ(); z++) {
						if (corner1.getWorld().getBlockAt(x, y, z).getType() != mat) return false;
					}
				}
			}
			return true;
		} else {
			throw new IllegalArgumentException("Location's worlds don't match.");
		}
	}
	
	public boolean areaEmpty(Location corner1, Location corner2){
		return areaOnlyContains(corner1,corner2,Material.AIR);
	}

	public boolean structureFits(Structure structure, Location loc) {
		World world = loc.getWorld();
		
		return false;
	}

}
