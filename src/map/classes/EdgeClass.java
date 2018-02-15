package map.classes;

import java.util.List;

import org.bukkit.entity.Player;

import map.main.Main;

public class EdgeClass {

	Main plugin = Main.plugin;

	public void create(Player player, String graph, String vertex, String vertexs) {

		List<String> list = plugin.graph.getStringList(graph + ".edge");

		for (int i = 0; i < vertexs.length(); i++) {

			if (checkExist(graph, vertex, vertexs.charAt(i)) == false) {

				list.add(vertex.toUpperCase() + String.valueOf(vertexs.charAt(i)).toUpperCase());
				player.sendMessage("�s�W���u: " + vertex + vertexs.charAt(i));

			}else {
				
				player.sendMessage("�л\���u: " + vertex + vertexs.charAt(i));
				
			}
			
		}

		plugin.graph.set(graph + ".edge", list);

		plugin.reload();

		player.sendMessage("�s�W���u���\!");

	}

	public boolean checkExist(String graph, String vertex, char anothervertex) {

		List<String> list = plugin.graph.getStringList(graph + ".edge");

		for (String str : list) {

			if (str.equalsIgnoreCase(vertex + anothervertex)) {

				return true;

			}

		}

		return false;

	}

	public void remove(Player player, String graph, String vertex, String anothervertex) {

		List<String> list = plugin.graph.getStringList(graph + ".edge");

		boolean find = false;

		for (int i = 0; i < list.size(); i++) {

			String str = list.get(i);

			if (str.equalsIgnoreCase(vertex + anothervertex)) {

				list.remove(i);

				find = true;

			}

		}

		plugin.graph.set(graph + ".edge", list);

		plugin.reload();

		if (find == true) {

			player.sendMessage("�R�����u " + (vertex + anothervertex) + " ���\");

		} else {

			player.sendMessage("�o�����u���s�b: " + (vertex + anothervertex));

		}

	}

}
