package me.capit.entropy.trading;

import org.bukkit.entity.Player;

public class Trade {
	
	public void createTrade(TradeInventory inv, Player player1, Player player2){
		
	}
	
	public void completeTrade(){
		//Close inventory, give player there new items, currency, xp...
	}
	
	public void cancelTrade(){
		//Close inv, make sure player hasnt got the item in hand while closing which could be
		//a possible dupe error.
	}

}
