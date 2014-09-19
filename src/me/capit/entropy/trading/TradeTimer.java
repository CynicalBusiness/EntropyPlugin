package me.capit.entropy.trading;

import org.bukkit.scheduler.BukkitTask;

public class TradeTimer implements Runnable {

	private BukkitTask task;
	//private Trade trade;
	
	public TradeTimer(Trade trade) {
		//this.trade = trade;
	}

	public void scheduleTask(BukkitTask task) {
		this.task = task;
	}

	public void cancelTask() {
		task.cancel();
	}

	public void run() {
		//close if move to far away
		//close if player is killed
		
		//^^^ may be easier to do on an event
	}
}
