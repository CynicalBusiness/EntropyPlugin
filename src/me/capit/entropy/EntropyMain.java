package me.capit.entropy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import me.capit.ds_mc.DSMCMain;
import me.capit.entropy.async.AsyncHandler;
import me.capit.entropy.command.PlayerInput;
import me.capit.entropy.trading.CoreTrade;
import me.capit.entropy.trading.Trade;
import me.capit.entropy.trading.TradeListener;
import me.capit.entropy.util.CoreUtil;
import me.capit.entropy.util.Town;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EntropyMain extends JavaPlugin {
	public static final ChatColor PLUGIN_COLOR = ChatColor.YELLOW;
	public static final String PLUGIN_TAG = ChatColor.DARK_GRAY + "[" + PLUGIN_COLOR + "Entropy"
			+ ChatColor.DARK_GRAY + "] " + ChatColor.RESET;

	public static Logger logger;
	public static CoreUtil util;
	public static AsyncHandler timer;
	public static PlayerInput input;
	public static CoreTrade trade;

	public static List<Town> towns = new ArrayList<Town>();

	public static Town getTownByID(int id) {
		for (Town t : towns) {
			if (t.getID() == id) {
				return t;
			}
		}
		return null;
	}

	public static Town getTownByOwner(UUID owner) {
		for (Town t : towns) {
			if (t.getOwner().equals(owner)) {
				return t;
			}
		}
		return null;
	}
	
	public static CoreTrade getCoreTrade(){
		return trade;
	}

	@Override
	public void onEnable() {
		logger = this.getLogger();
		logger.info(DSMCMain.formHeader(EntropyMain.class));

		logger.info("Loading utilities...");
		util = new CoreUtil(this);

		logger.info("Accessing disk...");
		saveDefaultConfig();
		loadData();
		logger.info("  " + towns.size() + " towns loaded.");

		logger.info("Registering commands and events...");
		input = new PlayerInput(this);

		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new TradeListener(trade), this);

		this.getServer().getPluginCommand("city").setExecutor(input);

		logger.info("Loading async data...");
		timer = new AsyncHandler(this);
		timer.runTaskTimerAsynchronously(this, 0L, 1200L); // One minute. 20*60.
		logger.info("  Scheduled AsyncHandler successfully!");

		logger.info(DSMCMain.formFooter(EntropyMain.class));
	}

	@Override
	public void onDisable() {
		logger.info(DSMCMain.formHeader(EntropyMain.class));
		logger.info("Shutting down...");
		logger.info("  Saving " + towns.size() + " towns...");
		saveData();

		logger.info("Safely ending trades...");
		Trade.endAllTrades();

		logger.info(DSMCMain.formFooter(EntropyMain.class));
	}

	public File getDataFile(String name) {
		File dataFile = new File(this.getDataFolder() + File.separator + name + ".bin");
		if (!dataFile.exists()) {
			try {
				dataFile.createNewFile();
			} catch (IOException e) {
				// Ignored. An I/O exception will not occur on the machine.
			}
		}
		return dataFile;
	}

	public void saveData() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(getDataFile("towns"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if (fos != null) {
			// List is not serializeable. D:<
			Town[] townsArray = towns.toArray(new Town[] {});
			byte[] data = DSMCMain.shuttle.serializeObject(townsArray); 
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

	public void loadData() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(getDataFile("towns"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (fis != null) {
			byte[] data = new byte[(int) getDataFile("towns").length()];
			try {
				fis.read(data);
				Object obj = DSMCMain.shuttle.deserializeObject(data);
				if (obj instanceof Town[]) {
					towns = new ArrayList<Town>(Arrays.asList((Town[]) obj));
				}
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
