package com.worminthedirt.farmhelper;

import com.worminthedirt.farmhelper.commands.*;
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
        this.getCommand("selectfarm").setExecutor(new SelectFarm());
        this.getCommand("deletefarm").setExecutor(new DeleteFarm());
        this.getCommand("updatefarm").setExecutor(new UpdateFarm());
        this.getCommand("settp").setExecutor(new SetTeleport());
        this.getCommand("listtp").setExecutor(new ListTeleports());
        this.getCommand("tpself").setExecutor(new TeleportSelf());
    }

    private void loadConfigs() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
