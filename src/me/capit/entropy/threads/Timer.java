package me.capit.entropy.threads;

import org.bukkit.scheduler.BukkitTask;

public class Timer implements Runnable {

	private BukkitTask task;
	
	public Timer() {
	}

	public void scheduleTask(BukkitTask task) {
		this.task = task;
	}

	public void cancelTask() {
		task.cancel();
	}

	public void run() {
		//Was thinking about a timer every so often to check the servers progress
		//Only while we start off to store stats about each aspect of the server so
		//we know what we need to change and what to keep...
	}
}