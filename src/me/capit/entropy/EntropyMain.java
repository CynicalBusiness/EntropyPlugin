package me.capit.entropy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import me.capit.ds_mc.DSMCMain;
import me.capit.entropy.util.*;

import org.bukkit.plugin.java.JavaPlugin;

public class EntropyMain extends JavaPlugin {
	public static Logger logger;
	public static CoreUtil util;
	
	public static List<Town> towns = new ArrayList<Town>();
	
	public static Town getTownByID(int id){
		for (Town t : towns){
			if (t.getID()==id){
				return t;
			}
		}
		return null;
	}
	
	@Override
	public void onEnable(){
		logger = this.getLogger();
		logger.info(DSMCMain.formHeader(EntropyMain.class));
		
		logger.info("Loading utilities...");
		util = new CoreUtil(this);
		
		// TODO
	}
	
	@Override
	public void onDisable(){
		
	}
	
	public File getDataFile(String name){
		File dataFile = new File(this.getDataFolder()+File.separator+name+".bin");
		if (!dataFile.exists()){
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				// Ignored. An I/O exception will not occur on the machine.
			}
		}
		return dataFile;
	}
	
	public void saveData(){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getDataFile("towns"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (fos!=null){
			// List is not serializeable. D:<
			Town[] townsArray = towns.toArray(new Town[]{});
			byte[] data = DSMCMain.shuttle.serializeObject(townsArray); // This is why we have DSMC.
			try {
				fos.write(data);
				fos.flush();
				fos.close();
				logger.info("Data successfully saved.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadData(){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(getDataFile("towns"));
		} catch (IOException e){
			e.printStackTrace();
		}
		if (fis!=null){
			byte[] data = new byte[(int) getDataFile("towns").length()];
			try {
				fis.read(data);
				Object obj = DSMCMain.shuttle.deserializeObject(data);
				if (obj instanceof Town[]){
					towns = new ArrayList<Town>(Arrays.asList((Town[]) obj));
				}
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
