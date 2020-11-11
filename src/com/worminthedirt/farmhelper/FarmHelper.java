package com.worminthedirt.farmhelper;

import com.worminthedirt.farmhelper.events.Events;
import org.bukkit.plugin.java.JavaPlugin;

public class FarmHelper extends JavaPlugin {
    @Override
    public void onEnable() {
        loadCommands();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getLogger().info("FarmHelper enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FarmHelper disabled :(");
    }

    private void loadCommands() {
        this.getCommand("hi").setExecutor(new Hai());
        getLogger().info("command /hi loaded");
    }
}
