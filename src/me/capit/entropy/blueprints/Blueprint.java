package me.capit.entropy.blueprints;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import me.capit.ds_mc.DSMCMain;

public class Blueprint implements Serializable {
	private static final long serialVersionUID = -7801407464779177668L;

	public class BadDataFormatException extends Exception{
		private static final long serialVersionUID = -5641551435152447364L;
		public BadDataFormatException(String msg){super(msg);}
	}
	
	public SerialBlock[][] blocks = new SerialBlock[][]{};
	
	private File blueprint;
	
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
	
	public Blueprint(SerialBlock[][] blocks){
		this.blocks = blocks;
	}
	
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
