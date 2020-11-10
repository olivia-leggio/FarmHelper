package com.worminthedirt.farmhelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hai implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage(ChatColor.YELLOW + "haiii :3c");
        }
        return true;
    }
}
