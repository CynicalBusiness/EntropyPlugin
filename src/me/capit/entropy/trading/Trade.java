package me.capit.entropy.trading;

import org.bukkit.entity.Player;

public class Trade {
	
	private Player player1;
	private Player player2;
	private TradeInventory inv;
	private CoreTrade trade;
	
	public void createTrade(CoreTrade trade, TradeInventory inv, Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
		this.inv = inv;
		this.trade = trade;
	}
	
	public void completeTrade(){
		//Close inventory, give player there new items, currency, xp...
	}
	
	public void cancelTrade(){
		trade.restoreInventory(player1);
		trade.restoreInventory(player2);
		inv.destory();
	}

}
