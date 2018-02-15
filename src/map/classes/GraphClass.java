package map.classes;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import map.main.Main;

public class GraphClass {

	Main plugin = Main.plugin;
	
	public void create(Player player,String name) {
		
		if(checkExist(name) == true) {
			
			player.sendMessage("無向圖 " + name + " 已存在!");
			
			return;
			
		}
		
		plugin.graph.set(name, "");
		
		plugin.graph.set(name + ".vertex", "");
		
		plugin.reload();
		
		player.sendMessage("創建無向圖 " + name + " 成功!");
		
	}
	
	public void remove(Player player,String name) {
		
		if(checkExist(name) == false) {
			
			player.sendMessage("無向圖 " + name + " 不存在");
			
			return;
			
		}
		
		plugin.graph.set(name, null);
		
		plugin.reload();
		
		player.sendMessage("刪除無向圖 " + name + " 成功");
		
	}
	
	public boolean checkExist(String name) {
		
		if(plugin.graph.get(name) != null) {
			
			return true; 
			
		}
		
		return false;
		
	}
	
	public void doCalc(Player player,String graph,String start,String end) {
		
		int num1 = Math.abs(65 - (int) start.charAt(0));
		int num2 = Math.abs(65 - (int) end.charAt(0));
		int graphSize = plugin.graph.getStringList(graph + ".vertex").size();
		List<String> list = plugin.graph.getStringList(graph + ".graph");
		
		VertexClass ver = new VertexClass();
		
		int[][] gph = new int[graphSize][graphSize];
		
		for(int i = 0; i < graphSize; i++) {
			String[] spl = list.get(i).split(" ");
			for(int j = 0; j < graphSize; j++) {
				int d = (int)(Double.parseDouble(spl[j]) + 0.05);
				gph[i][j] = d;
			}
		}
		
		Dijkstra dij = new Dijkstra();
		
		String result = dij.MainDijkstra(player, gph, graphSize, num1, num2);
		
		for(int i = 0; i < result.length() - 1; i++) {
			
			String loc1 = ver.getLocation(graph, String.valueOf(result.charAt(i)));
			String loc2 = ver.getLocation(graph, String.valueOf(result.charAt(i+1)));
						
			Bukkit.getServer().dispatchCommand(player, String.format("/pos1 %s", loc1));
			Bukkit.getServer().dispatchCommand(player, String.format("/pos2 %s", loc2));
			
			Bukkit.getServer().dispatchCommand(player, String.format("/line 251:1"));
			
			Bukkit.getServer().dispatchCommand(player, String.format("/pos1 %s",loc1));
			Bukkit.getServer().dispatchCommand(player, String.format("/pos2 %s",loc1));
			
			Bukkit.getServer().dispatchCommand(player, String.format("/line 138"));
			
			Bukkit.getServer().dispatchCommand(player, String.format("/pos1 %s",loc2));
			Bukkit.getServer().dispatchCommand(player, String.format("/pos2 %s",loc2));
			
			Bukkit.getServer().dispatchCommand(player, String.format("/line 138"));
						
		}
		
		player.sendMessage("ok.");
		
	}
	
	public WorldEditPlugin getWorldEdit() {
		
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if (p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
        else return null;
		
	}
	
}
