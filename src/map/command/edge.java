package map.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import map.classes.EdgeClass;
import map.main.Main;

public class edge implements CommandExecutor {

	Main plugin = Main.plugin;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length < 2) {

			help(sender);
			return false;

		}

		Player player = (Player) sender;

		String graph = args[0];
		String command = args[1];

		EdgeClass edge = new EdgeClass();

		if (command.equalsIgnoreCase("create")) {

			edge.create(player, graph, args[2], args[3]);

		} else if (command.equalsIgnoreCase("remove")) {

			edge.remove(player, graph, args[2], args[3]);

		}

		return false;
	}

	public void help(CommandSender sender) {

		sender.sendMessage("/edge <graph> create <vertex> <vertexs> 新增路線");
		sender.sendMessage("/edge <graph> remove <vertex> <vertex> 刪除路線");

	}

}
