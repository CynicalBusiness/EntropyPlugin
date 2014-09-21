package me.capit.entropy.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

import me.capit.entropy.EntropyMain;
import me.capit.entropy.blueprints.SerialBlock;

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
		@SuppressWarnings("unused")
		World world = loc.getWorld();
		
		return false;
	}
	
	public Location closestToOrigin(Location loc1, Location loc2){
		Vector origin = new Vector();
		Vector v1 = new Vector(loc1.getBlockX(),loc1.getBlockY(),loc1.getBlockZ());
		Vector v2 = new Vector(loc2.getBlockX(),loc2.getBlockY(),loc2.getBlockZ());
		double v1M = v1.subtract(origin).length();
		double v2M = v2.subtract(origin).length();
		if (v1M<v2M){
			return loc1;
		} else {
			return loc2;
		}
	}
	
	public SerialBlock[][] getBlocksInArea(Location corner1, Location corner2){
		if (corner1.getWorld().getName().equalsIgnoreCase(corner2.getWorld().getName())){
			int yMin = Math.min(corner1.getBlockX(), corner2.getBlockX());
			int yMax = Math.max(corner1.getBlockX(), corner2.getBlockX());
			int xMin = Math.min(corner1.getBlockY(), corner2.getBlockY());
			int xMax = Math.max(corner1.getBlockY(), corner2.getBlockY());
			int zMin = Math.min(corner1.getBlockZ(), corner2.getBlockZ());
			int zMax = Math.max(corner1.getBlockZ(), corner2.getBlockZ());
			List<SerialBlock[]> ys = new ArrayList<SerialBlock[]>();
			for (int y = yMin; y < yMax; y++) {
				List<SerialBlock> xs = new ArrayList<SerialBlock>();
				for (int x = xMin; x < xMax; x++) {
					for (int z = zMin; z < zMax; z++) {
						xs.add(new SerialBlock(corner1.getWorld().getName(),x,y,z));
					}
				}
				ys.add(xs.toArray(new SerialBlock[]{}));
			}
			return ys.toArray(new SerialBlock[][]{});
		} else {
			throw new IllegalArgumentException("Location's worlds don't match.");
		}
	}

}
