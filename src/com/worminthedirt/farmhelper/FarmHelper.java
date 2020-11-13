package com.worminthedirt.farmhelper;

import com.worminthedirt.farmhelper.commands.Hai;
import com.worminthedirt.farmhelper.commands.ListFarms;
import com.worminthedirt.farmhelper.commands.SelectFarm;
import com.worminthedirt.farmhelper.commands.SetFarm;
import com.worminthedirt.farmhelper.events.Events;
import org.bukkit.plugin.java.JavaPlugin;

public class FarmHelper extends JavaPlugin {

    @Override
    public void onEnable() {
        loadCommands();
        loadConfigs();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getLogger().info("FarmHelper enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FarmHelper disabled :(");
    }

    private void loadCommands() {
        this.getCommand("hi").setExecutor(new Hai());
        this.getCommand("setfarm").setExecutor(new SetFarm());
        this.getCommand("listfarms").setExecutor(new ListFarms());
        this.getCommand("select").setExecutor(new SelectFarm());
    }

    private void loadConfigs() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
