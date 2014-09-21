package me.capit.entropy.currency;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Token implements CommandExecutor {
	
	public static String getPrefix(){
		return ChatColor.BLUE + "[Tokens] ";
	}

	public static int getTokens(String player) {
		return 0;
	}

	public static void setTokens(String player, int amount) {

	}

	public static void addTokens(String player, int amount) {
		setTokens(player, getTokens(player) + amount);
	}

	public static void removeTokens(String player, int amount) {
		setTokens(player, getTokens(player) - amount);
	}
	
	public static boolean hasEnough(String player, int amount){
		if(getTokens(player) - amount >= 0){
			return true;
		}
		return false;
			
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tokens")) {
			if (sender instanceof Player) {
				if (args[0].equalsIgnoreCase("get")) {
					// check if args[1] is a player
					getTokens("");
					return true;
				}
			}
				// its the console
			if (args.length == 3) {
				if (args[0].equalsIgnoreCase("set")) {
					// check if args[1] is a player
					int amount = pharseInt(args[2]);
					setTokens("", amount);
					//player.sendMessage(getPrefix() + ChatColor.GOLD + "Your tokens have been set 
					//to " + ChatColor.DARK_RED + getTokens(playerName) + ChatColor.GOLD + "!");
					return true;
				}else if (args[0].equalsIgnoreCase("add")) {
					// check if args[1] is a player
					int amount = pharseInt(args[2]);
					addTokens("", amount);
					//player.sendMessage(getPrefix() + ChatColor.GOLD + "You have been given " + 
					//ChatColor.DARK_RED + getTokens(playerName) + ChatColor.GOLD + " Tokens! Total: " + ChatColor.DARK_RED + amount + ChatColor.GOLD + "!");
					return true;
				}else if (args[0].equalsIgnoreCase("remove")) {
					// check if args[1] is a player
					int amount = pharseInt(args[2]);
					if(hasEnough("", amount)){
						removeTokens("", amount);
						//player.sendMessage(getPrefix() + ChatColor.DARK_RED + getTokens(playerName) 
						//+ ChatColor.GOLD + " have been taken from your account! Total: " + 
						//ChatColor.DARK_RED + amount + ChatColor.GOLD + "!");
					}else{
						//player.sendMessage(getPrefix() + ChatColor.GOLD + "You do not have enough 
						//tokens! Total " + ChatColor.DARK_RED + getTokens(playerName) + 
						//ChatColor.GOLD + "!");
					}
					return true;
				}
			}
			
		}
		return false;
	}

	private int pharseInt(String string) {
		int i = 0;
		try {
			i = Integer.parseInt(string);
		} catch (NumberFormatException e) {
		}
		return i;
	}

}
