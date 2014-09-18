package me.capit.entropy.trading;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CoreTrade {
	
	//If the trade fails, items stored here will be returned.
	public static HashMap<String, ItemStack[]> startingItems = new HashMap<String, ItemStack[]>();
	
	public void restoreInventory(Player player){
		player.getInventory().clear();
		player.getInventory().setContents(CoreTrade.startingItems.get(player.getName()));
		player.closeInventory();
	}
	
	public String getPrefix(){
		return ChatColor.AQUA + "[Trade] ";
	}
	
}
