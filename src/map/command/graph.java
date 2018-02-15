package map.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import map.classes.FinishClass;
import map.classes.GraphClass;

public class graph implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length < 2) {
			
			help(sender);
			return false;
			
		}
		
		String command = args[0];
		
		Player player = (Player) sender;
		
		GraphClass graph = new GraphClass();
		
		if(command.equalsIgnoreCase("create")) {
			
			graph.create(player, args[1]);
			
		}else if(command.equalsIgnoreCase("remove")) {
			
			graph.remove(player, args[1]);
			
		}else if(command.equalsIgnoreCase("finish")) {
			
			FinishClass fc = new FinishClass();
			
			fc.makeGraph(player, args[1]);
			
		}else if(command.equalsIgnoreCase("docalc")) {
			
			graph.doCalc(player, args[1], args[2], args[3]);
			
		}
		
		return false;
		
		
	}
	
	public void help(CommandSender sender) {
		
		sender.sendMessage("------------------------------------");
		sender.sendMessage("/graph create <name> �гy�@�i�L�V��");
		sender.sendMessage("/graph remove <name> �R���@�i�L�V��");
		sender.sendMessage("/graph finish <name> �����@�i�L�V��");
		sender.sendMessage("/graph docalc <name> <vertex> <vertex> �p��̤p���|");
		sender.sendMessage("------------------------------------");
		
	}

}
