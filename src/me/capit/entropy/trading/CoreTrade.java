package me.capit.entropy.trading;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CoreTrade {
	
	//If the trade fails, items stored here will be returned.
	public static HashMap<UUID, ItemStack[]> startingItems = new HashMap<UUID, ItemStack[]>();
	
	public void restoreInventory(Player player){
		player.getInventory().clear();
		player.getInventory().setContents(CoreTrade.startingItems.get(player.getUniqueId()));
		player.closeInventory();
	}
	
	public String getPrefix(){
		return ChatColor.AQUA + "[Trade] ";
	}
	
}
