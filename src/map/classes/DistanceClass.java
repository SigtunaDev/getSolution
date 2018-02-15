package map.classes;

import java.util.List;

import org.bukkit.entity.Player;

import map.main.Main;

public class DistanceClass {

	Main plugin = Main.plugin;

	public double calcDistance(Player player, String graph, String vertex, String anothervertex) {

		boolean find = checkVertexExist(graph,vertex,anothervertex);
		
		if(find == false) {
			
			player.sendMessage("找不到兩點之間的線: " + vertex + anothervertex);
			return 0;
			
		}
		
		List<String> list = plugin.graph.getStringList(graph + ".vertex");
		
		String a_loc = "",b_loc = "";
		
		for(String str : list) {
			
			String point = str.split("_")[0];
			
			if(point.equalsIgnoreCase(vertex)) {
				
				a_loc = str.split("_")[1];
				
			}
			
			if(point.equalsIgnoreCase(anothervertex)) {
				
				b_loc = str.split("_")[1];
				
			}
			
		}
		
		if(a_loc != "" && b_loc != "") {
			
			String[] as = a_loc.split(",");
			String[] bs = b_loc.split(",");
			
			Integer ax = Integer.parseInt(as[0]);
			Integer ay = Integer.parseInt(as[1]);
			Integer az = Integer.parseInt(as[2]);
			
			Integer bx = Integer.parseInt(bs[0]);
			Integer by = Integer.parseInt(bs[1]);
			Integer bz = Integer.parseInt(bs[2]);
			
			double d = Math.sqrt(Math.pow((bx-ax),2) + Math.pow((by-ay), 2) + Math.pow((bz-az), 2));
			
			player.sendMessage(String.format("線 " + vertex + anothervertex + " 長 %.2f 公尺",d));
			
			return d;
			
		}else {
			
			player.sendMessage("找不到線: " + vertex + anothervertex);
			return 0;
			
		}
		
	}

	public boolean checkVertexExist(String graph,String vertex,String anothervertex) {
		
		List<String> vertexs = plugin.graph.getStringList(graph + ".vertex");
		
		boolean a_find = false;
		boolean b_find = false;
		
		for(String str : vertexs) {
			
			String point = str.split("_")[0];
			
			if(point.equalsIgnoreCase(vertex)) {
				
				a_find = true;
				
			}
			
			if(point.equalsIgnoreCase(anothervertex)) {
				
				b_find = true;
				
			}
			
		}
		
		if(a_find == true && b_find == true) {
			
			return true;
			
		}
		
		return false;
		
	}

}
