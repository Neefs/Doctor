package me.TypicalBruhh.Doctor;

import org.bukkit.plugin.java.JavaPlugin;

import me.TypicalBruhh.Doctor.commands.Doctor;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		this.getCommand("Doctor").setExecutor(new Doctor());
	}


}
