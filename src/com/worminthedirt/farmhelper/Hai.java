package com.worminthedirt.farmhelper;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hai implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (args.length == 0) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("haiii " + player.getDisplayName() + " :3c");
            }
        }
        else if (args[0].equals("yellow")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.YELLOW + "haiii " + player.getDisplayName() + " :3c");
            }
        }
        else if (args[0].equals("green")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.GREEN + "haiii " + player.getDisplayName() + " :3c");
            }
        }
        else if (args[0].equals("red")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.RED + "haiii " + player.getDisplayName() + " :3c");
            }
        }
        else if (args[0].equals("blue")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(ChatColor.BLUE + "haiii " + player.getDisplayName() + " :3c");
            }
        }
        else {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("haiii " + player.getDisplayName() + " :3c");
            }
        }


        return true;
    }
}
