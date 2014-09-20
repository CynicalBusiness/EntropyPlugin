package me.capit.entropy.command;

import me.capit.entropy.EntropyMain;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PlayerInput implements CommandExecutor {
	final EntropyMain plugin;
	public PlayerInput(EntropyMain plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (lbl.equalsIgnoreCase("city")){
				Trade trade = new Trade(EntropyMain.trade, new TradeInventory(plugin), (Player) s, Bukkit.getPlayer(args[0]));
			return true;
		}
		return false;
	}

}
