package me.capit.entropy.blueprints;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import me.capit.ds_mc.DSMCMain;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Blueprint {
	
	class BadDataFormatException extends Exception{
		private static final long serialVersionUID = -5641551435152447364L;
		public BadDataFormatException(String msg){super(msg);}
	}
	
	class SerialBlock implements Serializable{
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
	
	public SerialBlock[][] blocks = new SerialBlock[][]{};
	
	private File blueprint;
	
	/**
	 * Creates a blueprint from a file. If the file does not exist, it is created.
	 * @param blueprint The file to load from.
	 * @throws IllegalArgumentException If the file passed is not valid (not a .print or is a directory).
	 * @throws IOException Exceptions thrown from the input stream.
	 * @throws BadDataFormatException If the data on the file is corrupt or not correct.
	 */
	public Blueprint(File blueprint) throws IllegalArgumentException, IOException, BadDataFormatException{
		this.blueprint = blueprint;
		if (!blueprint.exists()){
			blueprint.createNewFile();
			this.save();
		}
		if (blueprint.isFile()){
			String[] fname = blueprint.getName().split(".");
			if (fname[fname.length-1].equalsIgnoreCase("print")){
				FileInputStream fis = new FileInputStream(blueprint);
				byte[] data = new byte[(int) blueprint.length()];
				fis.read(data);
				Object obj = DSMCMain.shuttle.deserializeObject(data);
				if (obj instanceof SerialBlock[][]){
					blocks = (SerialBlock[][]) obj;
					fis.close();
				} else {
					fis.close();
					throw new BadDataFormatException("Attempted to load data, but was not list!");
				}
			} else {
				throw new IllegalArgumentException("Failed to load blueprint, the file is not a .print file!");
			}
		} else {
			throw new IllegalArgumentException("Blueprint cannot be a Directory.");
		}
	}
	
	/**
	 * Saved the data stored in this blueprint to disk in the file it was loaded from.
	 * <br><br>
	 * Create a new Blueprint object with a non-existant file, modify the blocks, then save in
	 * order to create a new blueprint file.
	 */
	public void save(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(blueprint);
		} catch (IOException e) {
			// Do nothing.
		} finally {
			if (fos!=null){
				try {
					byte[] data = DSMCMain.shuttle.serializeObject(blocks);
					fos.write(data);
					fos.close();
				} catch (IOException e) {
					// Again, nothing.
				}
			}
		}
	}
	
}
