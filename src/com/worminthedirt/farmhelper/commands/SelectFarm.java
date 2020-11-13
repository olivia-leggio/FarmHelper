package com.worminthedirt.farmhelper.commands;

import com.worminthedirt.farmhelper.FarmHelper;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SelectFarm implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;

        try {
            if (plugin.getConfig().getConfigurationSection("Farms." + player.getUniqueId()).contains(args[0])) {
                String path = "Selections." + player.getUniqueId();
                plugin.getConfig().set(path, args[0]);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GREEN + "teleporting to " + args[0] + "...");
            }
            else {
                player.sendMessage(ChatColor.YELLOW + "you don't a farm named " + args[0] + "!");
                return false;
            }
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.YELLOW + "you don't a farm named " + args[0] + "!");
            return false;
        }

        return true;
    }
}
