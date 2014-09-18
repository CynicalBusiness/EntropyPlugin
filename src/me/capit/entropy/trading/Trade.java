package me.capit.entropy.trading;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trade {
	
	private Player player1;
	private Player player2;
	private TradeInventory inv;
	private CoreTrade trade;
	
	private static ArrayList<Trade> trades = new ArrayList<Trade>();
	
	private enum TradeEndReason{
		
		CANCEL("&7The trade has been canceled by &b<player>&7!"), 
		COMPLETE("&7The trade has been completed!"), 
		LOGOUT("&7Player &b<player> &7has logged out so the trade has ended!"),
		KILLED("&7Player &b<player> &7was killed, trade ended!"),
		RESTART("&7Sorry to cut you short but the server is restarting!!!");
		
		private String reason;
		
		TradeEndReason(String string){
			string = reason;
		}
		
		public String getReason(){
			return reason;
		}
		
	}
	
	public static Trade getTrade(Inventory inventory){
		for(Trade trade : trades){
			if(trade.getInventory().getName().equalsIgnoreCase(inventory.getName())){
				return trade;
			}
		}
		return null;
	}
	
	public static Trade getTrade(Player player){
		for(Trade trade : trades){
			if(trade.player1.getName().equalsIgnoreCase(player.getName()) || trade.player2.getName().equalsIgnoreCase(player.getName())){
				return trade;
			}
		}
		return null;
	}
	
	public void createTrade(CoreTrade trade, TradeInventory inv, Player player1, Player player2){
		this.player1 = player1;
		this.player2 = player2;
		this.inv = inv;
		this.trade = trade;
		
		startTrade(player1, player2);
	}
	
	public void completeTrade(){
		trades.remove(this);
		player1.closeInventory();
		player2.closeInventory();
		//Close inventory, give player there new items, currency, xp...
	}
	
	public void cancelTrade(){
		trade.restoreInventory(player1);
		trade.restoreInventory(player2);
		trades.remove(this);
		inv.destory();
	}
	
	public Inventory getInventory(){
		return inv.getInventory();
	}
	
	public void startTrade(Player player1, Player player2){
		player1.closeInventory();
		player2.closeInventory();
		
		player1.openInventory(getInventory());
		player2.openInventory(getInventory());
		
		inv.setUpInventory();
	}
	
	//Called on stopping the plugin to safely end all trades.
	public static void endAllTrades(){
		for(Trade trade : trades){
			trade.cancelTrade();
			String msg = ChatColor.translateAlternateColorCodes('&', TradeEndReason.RESTART.getReason());
			trade.player1.sendMessage(msg);
			trade.player2.sendMessage(msg);
		}
	}
	
	public Player getPlayer1(){
		return this.player1;
	}
	
	public Player getPlayer2(){
		return this.player2;
	}

}
