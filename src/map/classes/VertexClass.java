package map.classes;

import java.util.HashSet;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import map.main.Main;

public class VertexClass {
	
	Main plugin = Main.plugin;
	
	public void add(Player player,String graph) {
		
		List<String> list = plugin.graph.getStringList(graph + ".vertex");
		
		char c = (char)(65+list.size());
		
		Location loc = player.getEyeLocation();
		
		String location = loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
		
		list.add(c + "_" + location);
		
		plugin.graph.set(graph + ".vertex", list);
		
		plugin.reload();
		
		player.sendMessage("已新增點" + c + "!，座標為:" + location);
		
	}
	
	public void set(Player player,String graph,String vertex) {
		
		List<String> list = plugin.graph.getStringList(graph + ".vertex");
		
		boolean find = false;
		
		String location = "";
		
		for(int i = 0; i < list.size(); i++) {
			
			String get = list.get(i).split("_")[0];
			
			Location loc = player.getTargetBlock((HashSet<Material>)null,0).getLocation();	
			
			location = loc.getBlockX() + "," + loc.getBlockY() + "," + loc.getBlockZ();
			
			if(get.equals(vertex)) {
				
				list.set(i, vertex + "_" + location);
				
				find = true;
				
			}
			
			plugin.graph.set(graph + ".vertex", list);
			
			plugin.reload();
			
		}
		
		if(find == false) {
			
			player.sendMessage("在這張無向圖找不到這個點：" + vertex);
			
		}else {
			
			player.sendMessage("更新成功，將 " + vertex + " 點更新成 " + location);
			
		}
		
	}
	
	public String getLocation(String graph,String vertex) {
		
		List<String> list = plugin.graph.getStringList(graph + ".vertex");
		
		for(String str : list ) {
			
			if(str.split("_")[0].equalsIgnoreCase(vertex)) {
				
				return str.split("_")[1];
				
			}
			
		}
		
		return null;
		
	}

}
