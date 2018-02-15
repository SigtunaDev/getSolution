package map.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import map.classes.DistanceClass;

public class distance implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length < 2) {
			
			help(sender);
			return false;
			
		}
		
		Player player = (Player) sender;
		
		String graph = args[0];
		
		DistanceClass dis = new DistanceClass();
		
		String command = args[1];
		
		if(command.equalsIgnoreCase("get")) {
			
			dis.calcDistance(player, graph, args[2], args[3]);
			
		}
		
		return false;
	}
	
	public void help(CommandSender sender) {
		
		sender.sendMessage("/distance <graph> get <vertex> <anothervertex> 計算兩點之間的距離");
		
	}
	
	

}
