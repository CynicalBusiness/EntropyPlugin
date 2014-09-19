package me.capit.entropy.trading;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class TradeInventory {
	
	private Inventory inv;
	
	public TradeInventory(){
		inv = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "Trading Inventory!");
	}
	
	public void setUpInventory(){
		//Add starting option items - trade money, trade virtual item (e.g building)
		
		//money options
		
		//possibly add a military trade system for empire owners to trade equipment
	}
	
	public void destory(){
		inv.clear();
	}
	
	public Inventory getInventory(){
		return inv;
	}

}
