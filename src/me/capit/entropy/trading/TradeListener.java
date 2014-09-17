package me.capit.entropy.trading;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TradeListener implements Listener{
	
	@EventHandler
	public void onINVClick(InventoryClickEvent event){
		//Check the inventory is a trading inv
		
		//check what they clicked
		
		//if it isnt equal to a "special item", return
		
		//if it is check what special item
		
		//add the special item to the list of trading items
		
		//cancel the event
	}
	
	@EventHandler
	public void onINVClose(InventoryCloseEvent event){
		//check the inventory is a trading inv
		
		//cancle the event
		
		//tell them to click the cancel button
	}
	
	@EventHandler
	public void onINVMoveItem(InventoryMoveItemEvent event){
		//Check the inventory is a trading inv
		
		//check where they moved the item
		
		//if it is on their side of the trading inv
		
		//add to trading items list
		
		//else: cancel and give the item back
	}
	
	@EventHandler
	public void onINVPickup(InventoryPickupItemEvent event){
		//Check the inventory is a trading inv
		
		//cancel the event
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		//Check if they where in a trade
		
		//Check the inventory is a trading inv
		
		//restore both players inventories safely
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event){
		//Check if they where in a trade
		
		//Check the inventory is a trading inv
		
		//restore both players inventories safely
	}
	
	@EventHandler
	public void onEntDamageByEnt(EntityDamageByEntityEvent event){
		//Check if they where in a trade
		
		//Check the inventory is a trading inv
		
		//cancel the trade
				
		//restore both players inventories safely
	}

}
