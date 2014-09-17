package me.capit.entropy.trading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TradeInventory {
	
	private HashMap<String, List<ItemStack>> trades;
	
	private Inventory inv;
	
	public TradeInventory(){
		trades = new HashMap<String, List<ItemStack>>();
		inv = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "Trading Inventory!");
	}
	
	public void setUpInventory(){
		//Add starting option items - trade money, trade virtual item (e.g building)
	}
	
	public void destory(){
		inv.clear();
	}

	public void addTradingItem(Player player, ItemStack stack) {
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.add(stack);
		trades.put(player.getName(), items);
	}

	public void removeTradingItem(Player player, ItemStack stack) {
		List<ItemStack> items = new ArrayList<ItemStack>();
		items.remove(stack);
		trades.put(player.getName(), items);
	}

}
