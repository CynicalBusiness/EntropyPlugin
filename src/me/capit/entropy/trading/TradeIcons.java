package me.capit.entropy.trading;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TradeIcons {
	
	public static void setIcons(Inventory inventory){
		registerUselessIcons(inventory, 4, 13, 22, 31, 40, 49);
		
		
	}
	
	public static void registerUselessIcons(Inventory inv, int... slots){
		ItemStack stack = new ItemStack(Material.IRON_FENCE, 1);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName("");
		stack.setItemMeta(meta);
		for(int i : slots){
			inv.setItem(i, stack);
		}
	}
	
	public static void registerTradingIcons(Inventory inv){
		ItemStack money = new ItemStack(Material.BLAZE_POWDER, 1);
		ItemMeta meta = money.getItemMeta();
		meta.setDisplayName(ChatColor.GREEN + "Trade money!");
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "To trade money click me.");
		lore.add(ChatColor.WHITE + "This will close the inventory and ask");
		lore.add(ChatColor.WHITE + "you to type in chat the amount of money");
		lore.add(ChatColor.WHITE + "you wish to trade!");
		meta.setLore(lore);
		
		
	}

}
