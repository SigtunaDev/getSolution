package map.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import map.classes.VertexClass;

public class vertex implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length < 2) {
			
			help(sender);
			return false;
			
		}
		
		Player player = (Player) sender;
		
		String graph = args[0];
		
		String command = args[1];
		
		VertexClass vertex = new VertexClass();
		
		if(command.equalsIgnoreCase("add")) {
			
			vertex.add(player, graph);
			
		}else if(command.equalsIgnoreCase("set")) {
			
			String vertexPoint = args[2];
			
			vertex.set(player, graph, vertexPoint);
		
		}
		
		return false;
	}
	
	public void help(CommandSender sender) {
		
		sender.sendMessage("------------------------------------");
		sender.sendMessage("/vertex <graph> add 新增手上指著的點");
		sender.sendMessage("/vertex <graph> set <vertex> 設置點的新座標");
		sender.sendMessage("------------------------------------");
		
	}

}
