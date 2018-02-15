package map.classes;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import map.main.Main;

public class Dijkstra {

	public int end;

	public String MainDijkstra(Player player, int[][] graph, int graphSize, int start, int end) {

		this.end = end;
		
		int[][] cost = new int[graphSize][graphSize];
		int[] distance = new int[graphSize];
		int[] solution = new int[graphSize];
		final int INFINITY = 999999999;
		int[] visited = new int[graphSize];

		int mindistence;
		int count, nextnode = 0, i, j;

		for (i = 0; i < graphSize; i++) {
			for (j = 0; j < graphSize; j++) {
				if (graph[i][j] == 0) {
					cost[i][j] = INFINITY;
				} else {
					cost[i][j] = graph[i][j];
				}
			}
		}

		for (i = 0; i < graphSize; i++) {

			distance[i] = cost[start][i];
			solution[i] = start;
			visited[i] = 0;

		}

		distance[start] = 0;
		visited[start] = 1;
		count = 1;

		while (count < graphSize - 1) {

			mindistence = INFINITY;

			for (i = 0; i < graphSize; i++) {

				if (distance[i] < mindistence && visited[i] == 0) {

					mindistence = distance[i];
					nextnode = i;

				}

			}

			visited[nextnode] = 1;

			for (i = 0; i < graphSize; i++) {
				if (visited[i] == 0) {
					if (mindistence + cost[nextnode][i] < distance[i]) {
						distance[i] = mindistence + cost[nextnode][i];
						solution[i] = nextnode;
					}
				}
			}

			count++;

		}

		String str = "";

		i = end;
		
		str += (char) (i + 65);

		j = i;
		do {
			j = solution[j];
			str += (char) (j + 65);
		} while (j != start);

		String reverse = "";
		
		for(i = str.length() - 1; i >= 0; i--) {
			
			reverse += str.charAt(i);
			
		}
		
		new BukkitRunnable() {
			
			public void run() {
				
				player.sendMessage("計算完成! 總距離為: " + distance[end] + " 公尺");
				
			}
			
		}.runTaskLater(Main.plugin, 2*20);
		
		return reverse;

	}

}
