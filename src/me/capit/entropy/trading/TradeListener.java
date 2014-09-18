package me.capit.entropy.trading;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TradeListener implements Listener {

	private CoreTrade coreTrade;

	public TradeListener(CoreTrade trade) {
		coreTrade = trade;
	}

	@EventHandler
	public void onINVClick(InventoryClickEvent event) {
		Trade trade = Trade.getTrade(event.getInventory());
		if (trade == null)
			return;

		// check what they clicked

		// if it isnt equal to a "special item", return

		// if it is check what special item

		// add the special item to the list of trading items

		// cancel the event
	}

	@EventHandler
	public void onINVClose(InventoryCloseEvent event) {
		Trade trade = Trade.getTrade(event.getInventory());
		if (trade == null)
			return;
		trade.cancelTrade();

		if (trade.getPlayer1().getName().equalsIgnoreCase(((Player) event.getPlayer()).getName())) {
			trade.getPlayer1().sendMessage(
					coreTrade.getPrefix() + ChatColor.GRAY + "Trade Cancelled!");
			trade.getPlayer2().sendMessage(
					coreTrade.getPrefix() + ChatColor.GRAY + "Trade was cancelled by "
							+ ChatColor.AQUA + trade.getPlayer1().getName());
			return;
		} else {
			trade.getPlayer2().sendMessage(
					coreTrade.getPrefix() + ChatColor.GRAY + "Trade Cancelled!");
			trade.getPlayer1().sendMessage(
					coreTrade.getPrefix() + ChatColor.GRAY + "Trade was cancelled by "
							+ ChatColor.AQUA + trade.getPlayer2().getName());
			return;
		}
	}

	@EventHandler
	public void onINVMoveItem(InventoryMoveItemEvent event) {
		Trade trade = Trade.getTrade(event.getDestination());
		if (trade == null)
			return;

		// check where they moved the item

		// if it is on their side of the trading inv

		// add to trading items list

		// else: cancel and give the item back
	}

	@EventHandler
	public void onINVPickup(InventoryPickupItemEvent event) {
		Trade trade = Trade.getTrade(event.getInventory());
		if (trade == null)
			return;

		event.setCancelled(true);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Trade trade = Trade.getTrade(event.getPlayer());
		if (trade == null)
			return;

		trade.cancelTrade();
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Trade trade = Trade.getTrade(event.getEntity());
		if (trade == null)
			return;

		trade.cancelTrade();
	}

	@EventHandler
	public void onEntDamageByEnt(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {

			Trade trade = Trade.getTrade((Player) event.getEntity());
			if (trade == null)
				return;

			trade.cancelTrade();
		}
	}

}
