package com.worminthedirt.farmhelper.commands;

import com.worminthedirt.farmhelper.FarmHelper;
import com.worminthedirt.farmhelper.utils.GeneralUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


//saves a new farm teleport point
public class SetFarm implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        try {
            if (plugin.getConfig().getConfigurationSection("Farms." + player.getUniqueId()).contains(args[0])) {
                player.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you already have a farm with that name!");
                return false;
            }
        }
        catch (Exception e) {
            ;
        }

        Location playerLoc = player.getLocation();

        String farmName = args[0];
        //World world = playerLoc.getWorld();
        int X = playerLoc.getBlockX();
        int Y = playerLoc.getBlockY();
        int Z = playerLoc.getBlockZ();

        String path = "Farms." + player.getUniqueId() + "." + farmName;
        //plugin.getConfig().set(path + ".world", world);
        plugin.getConfig().set(path + ".X", X);
        plugin.getConfig().set(path + ".Y", Y);
        plugin.getConfig().set(path + ".Z", Z);

        try {
            plugin.saveConfig();
            player.sendMessage(ChatColor.GREEN + "[FarmHelper] saved " + farmName);
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "[FarmHelper] could not save farm!");
            GeneralUtils.toConsole(e.toString());
            return false;
        }

        return true;
    }
}
