package com.worminthedirt.farmhelper.commands;

import com.worminthedirt.farmhelper.FarmHelper;
import com.worminthedirt.farmhelper.utils.GeneralUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetTeleport implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        try {
            if (plugin.getConfig().getConfigurationSection("TPs." + player.getUniqueId()).contains(args[0])) {
                player.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you already have a tp point with that name!");
                return false;
            }
        }
        catch (Exception e) {
            ;
        }

        Location playerLoc = player.getLocation();

        String tpName = args[0];
        int X = playerLoc.getBlockX();
        int Y = playerLoc.getBlockY();
        int Z = playerLoc.getBlockZ();

        String path = "TPs." + player.getUniqueId() + "." + tpName;
        plugin.getConfig().set(path + ".X", X);
        plugin.getConfig().set(path + ".Y", Y);
        plugin.getConfig().set(path + ".Z", Z);

        try {
            plugin.saveConfig();
            player.sendMessage(ChatColor.GREEN + "[FarmHelper] saved " + tpName);
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "[FarmHelper] could not save tp point!");
            GeneralUtils.toConsole(e.toString());
            return false;
        }

        return true;
    }
}
