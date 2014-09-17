package me.capit.entropy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Message {
	
	public enum MessageLevel{
		INFO, ERROR, DEBUG, WARNING, HELP;
		
		public ChatColor getColor(){
			switch(this){
			case ERROR:
				return ChatColor.RED;
			case WARNING:
				return ChatColor.YELLOW;
			case HELP:
				return ChatColor.GOLD;
			default:
				return ChatColor.WHITE;
			}
		}
	}
	
	public static void send(MessageLevel level, Player player, String message){
		player.sendMessage(EntropyMain.PLUGIN_TAG+level.getColor()+ChatColor.BOLD+level.toString()+": "+level.getColor()+message);
	}
	
	public static void sendAll(MessageLevel level, JavaPlugin plugin, String message){
		for (Player p : plugin.getServer().getOnlinePlayers()){
			send(level,p,message);
		}
	}
	
	public static void sendInfo(Player player, String message){
		send(MessageLevel.INFO,player,message);
	}
	
	public static void sendError(Player player, String message){
		send(MessageLevel.ERROR,player,message);
	}
	
	public static void sendHelp(Player player, String message){
		send(MessageLevel.HELP,player,message);
	}
	
}
