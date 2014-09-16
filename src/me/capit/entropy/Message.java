package me.capit.entropy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Message {
	
	public static void sendError(Player player, String message){
		player.sendMessage(ChatColor.DARK_RED + "[ERROR] " + message);
	}
	
	public static void sendHelp(Player player, String message){
		player.sendMessage(ChatColor.GOLD + "[Entropy] " + message);
	}
	
	public static void sendWarning(Player player, String message){
		player.sendMessage(ChatColor.YELLOW + "[Warning] " + message);
	}

}
