package me.capit.entropy.trading;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TradeInventory {
	
	private Inventory inv;
	
	public TradeInventory(){
		inv = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "Trading Inventory!");
	}
	
	public void setUpInventory(){
		//Add starting option items - trade money, trade virtual item (e.g building)
	}
	
	public void destory(){
		inv.clear();
		//Anything handled when closing, ending or cancling a trade
	}

	public void addTradingItem(Player player, ItemStack stack) {
		
	}

	public void removeTradingItem(Player player, ItemStack stack) {

	}

}
