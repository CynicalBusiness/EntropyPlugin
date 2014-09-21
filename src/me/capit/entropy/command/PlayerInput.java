package me.capit.entropy.command;

import java.util.Arrays;
import java.util.List;

import me.capit.entropy.EntropyMain;
import me.capit.entropy.Message;
import me.capit.entropy.blueprints.Blueprint;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInput implements CommandExecutor {
	final EntropyMain plugin;
	public PlayerInput(EntropyMain plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
		if (lbl.equalsIgnoreCase("city")){
			if (args.length>0 && !args[0].equalsIgnoreCase("?")){
				if (args[0].equalsIgnoreCase("admin") && s.hasPermission("city.admin")){
					List<String> tArgs = Arrays.asList(args);
					tArgs.remove(0);
					handleAdminCommands(s,cmd,lbl,tArgs.toArray(new String[]{}));
				} else if(!args[0].equalsIgnoreCase("admin") && s.hasPermission("city.player")) {
					handlePlayerCommands(s,cmd,lbl,args);
				} else {
					Message.sendError((Player) s, "You do not have permission for this command!");
				}
				return true;
			} else {
				return onCommand(s,cmd,lbl,new String[]{"help"});
			}
		}
		return false;
	}
	
	private void handlePlayerCommands(CommandSender s, Command cmd, String lbl, String[] args){
		
	}
	
	private void handleAdminCommands(CommandSender s, Command cmd, String lbl, String[] args){
		Player p = (Player) s;
		if (args[0].equalsIgnoreCase("blueprint") && args.length==2){
			if (args[1].equalsIgnoreCase("setCorner1")){
				Block[] cns = EntropyMain.corners.containsKey(p.getUniqueId()) ? 
						EntropyMain.corners.get(((Player) s).getUniqueId()) : new Block[2];
				cns[0] = p.getLocation().getBlock();
				EntropyMain.corners.put(p.getUniqueId(), cns);
			} else if (args[1].equalsIgnoreCase("setCorner2")){
				Block[] cns = EntropyMain.corners.containsKey(p.getUniqueId()) ? 
						EntropyMain.corners.get(((Player) s).getUniqueId()) : new Block[2];
				cns[1] = p.getLocation().getBlock();
				EntropyMain.corners.put(p.getUniqueId(), cns);
			} else if (args[1].equalsIgnoreCase("formBlueprint")){
				Block[] corners = EntropyMain.corners.get(((Player) s).getUniqueId());
				if (corners[0]!=null && corners[1]!=null){
					Blueprint print = new Blueprint(EntropyMain.util.getBlocksInArea(corners[0].getLocation(),corners[1].getLocation()));
					print.save();
				}
			}
		} else {
			Message.sendError((Player) s, "Invalid argument or argument count.");
		}
	}


}
