package com.worminthedirt.farmhelper;

import org.bukkit.plugin.java.JavaPlugin;

public class FarmHelper extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("FarmHelper enabled!");

        loadCommands();
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
