package me.capit.entropy.trading;

import me.capit.entropy.EntropyMain;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

public class TradeInventory {
	
	private Inventory inv;
	private EntropyMain main;
	
	public TradeInventory(EntropyMain main){
		this.main = main;
		inv = this.main.getServer().createInventory(null, 54, ChatColor.DARK_RED + "Trading Inventory!");
	}
	
	public void setUpInventory(){
		TradeIcons.registerTradingIcons(inv);
	}
	
	public void destory(){
		inv.clear();
	}
	
	public Inventory getInventory(){
		return inv;
	}

}
