package map.main;

import map.command.distance;
import map.command.edge;
import map.command.graph;
import map.command.vertex;

public class CommandRegister {
	
	Main plugin = Main.plugin;
	
	public void register() {
		
		plugin.getCommand("graph").setExecutor(new graph());
		plugin.getCommand("edge").setExecutor(new edge());
		plugin.getCommand("vertex").setExecutor(new vertex());
		plugin.getCommand("distance").setExecutor(new distance());
		
	}

}
