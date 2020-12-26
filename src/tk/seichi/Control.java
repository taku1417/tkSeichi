package tk.seichi;

import org.bukkit.plugin.java.JavaPlugin;

public class Control extends JavaPlugin {

	@Override
	public void onDisable() {

		super.onDisable();
	}

	@Override
	public void onEnable() {

		super.onEnable();

		getCommand("tp-above").setExecutor(new TPAboveCom());
	}

}

