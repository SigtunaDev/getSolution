package map.classes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import map.main.Main;

public class FinishClass {

	Main plugin = Main.plugin;

	public void makeGraph(Player player, String graph) {

		DistanceClass dis = new DistanceClass();
		EdgeClass edg = new EdgeClass();
		
		List<String> vertex = plugin.graph.getStringList(graph + ".vertex");
		
		int graphSize = vertex.size();
		
		double[][] deg = new double[graphSize][graphSize];

		//A = 65
		
		for (int i = 0; i < graphSize; i++) {
			for (int j = 0; j < graphSize; j++) {
				
				if(i == j) {
					
					deg[i][j] = 0;
					
				}else {
					
					char v1 = (char)(65 + i);
					char v2 = (char)(65 + j);
																
					if(edg.checkExist(graph, String.valueOf(v1), v2) == true) {
						
						double result = dis.calcDistance(player, graph, String.valueOf(v1), String.valueOf(v2));
						
						deg[i][j] = result;
						
					}else {
						
						deg[i][j] = 0;
						
					}
					
				}
				
			}
		}
		
		List<String> list = new ArrayList<String>();
			
		for(int i = 0; i < graphSize; i++) {
			
			String gph = "";
			
			for(int j = 0; j < graphSize - 1; j++) {
				
				gph += String.format("%.2f", deg[i][j]) + " ";
				
			}
			
			gph += String.format("%.2f", deg[i][graphSize-1]);
			
			list.add(gph);
			
		}
		
		plugin.graph.set(graph + ".graph", list);
		
		plugin.reload();

	}

}
