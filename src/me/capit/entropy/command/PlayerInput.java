package me.capit.entropy.command;

import java.util.Arrays;
import java.util.List;

import me.capit.entropy.EntropyMain;
import me.capit.entropy.Message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInput implements CommandExecutor {
	final EntropyMain plugin;
	public PlayerInput(EntropyMain plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (lbl.equalsIgnoreCase("city")){
			if (args.length>0 && !args[0].equalsIgnoreCase("?")){
				if (args[0].equalsIgnoreCase("admin") && s.hasPermission("city.admin")){
					List<String> tArgs = Arrays.asList(args);
					tArgs.remove(0);
					handleAdminCommands(s,cmd,lbl,tArgs.toArray(new String[]{}));
				} else if(s.hasPermission("city.player")) {
					handlePlayerCommands(s,cmd,lbl,args);
				} else {
					Message.sendError((Player) s, "You do not have permission for this command!");
				}
				return true;
			} else {
				return onCommand(s,cmd,lbl,new String[]{"help"});
			}
		}
		return false;
	}
	
	private void handlePlayerCommands(CommandSender s, Command cmd, String lbl, String[] args){
		
	}
	
	private void handleAdminCommands(CommandSender s, Command cmd, String lbl, String[] args){
		
	}


}
