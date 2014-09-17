package me.capit.entropy.async;

import java.io.Serializable;

import org.bukkit.scheduler.BukkitRunnable;

import me.capit.entropy.EntropyMain;

// Extending BukkitRunnable instead of implementing Runnable. Allows for better data handling.
// ... and there's too many "Timer" classes. .-.
public class AsyncHandler extends BukkitRunnable implements Serializable {
	private static final long serialVersionUID = 8583971189022887551L;
	
	final EntropyMain plugin;
	public AsyncHandler(EntropyMain plugin){
		this.plugin = plugin;
	}
	
	// Tasks handled in main thread.
	public void run(){
		
		// TODO Data validity check.
		
		plugin.saveData();
	}
}