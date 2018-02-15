package map.main;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public File gc;
	
	public FileConfiguration graph;
	
	public static Main plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		fileLoad();
		
		CommandRegister command = new CommandRegister();
		
		command.register();
		
	}
	
	public void fileLoad() {
		
		gc = new File(this.getDataFolder() + "/graphConfig.yml");
		
		graph = YamlConfiguration.loadConfiguration(gc);
		
	}
	
	public void reload() {
		
		try {
			
			graph.save(gc);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
