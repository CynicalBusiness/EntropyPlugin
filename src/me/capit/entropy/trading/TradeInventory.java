package me.capit.entropy.trading;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TradeInventory {
	
	private Inventory inv;
	
	public TradeInventory(){
		inv = Bukkit.createInventory(null, InventoryType.CHEST, ChatColor.DARK_RED + "Trading Inventory!");
	}
	
	public void setUpInventory(){
		//Add starting option items - trade money, trade virtual item (e.g building)
		
		//money options
		
		//possibly add a military trade system for empire owners to trade equipment
	}
	
	public void destory(){
		inv.clear();
	}

	public void addTradingItem(Player player, ItemStack stack) {
		
	}

	public void removeTradingItem(Player player, ItemStack stack) {
		
	}
	
	public Inventory getInventory(){
		return inv;
	}

}
