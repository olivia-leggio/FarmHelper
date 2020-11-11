package com.worminthedirt.farmhelper.commands;

import com.worminthedirt.farmhelper.FarmHelper;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetFarm implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        Location playerLoc = player.getLocation();

        String farmName = args[0];
        World world = playerLoc.getWorld();
        int X = playerLoc.getBlockX();
        int Y = playerLoc.getBlockY();
        int Z = playerLoc.getBlockZ();

        String path = "Farms." + player.getUniqueId() + "." + farmName;
        plugin.getConfig().set(path + ".world", world);
        plugin.getConfig().set(path + ".X", X);
        plugin.getConfig().set(path + ".Y", Y);
        plugin.getConfig().set(path + ".Z", Z);

        try {
            plugin.saveConfig();
            player.sendMessage(ChatColor.GREEN + "saved " + farmName);
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "could not save farm!");
            player.sendMessage(ChatColor.DARK_RED + e.toString());
        }

        return true;
    }
}
