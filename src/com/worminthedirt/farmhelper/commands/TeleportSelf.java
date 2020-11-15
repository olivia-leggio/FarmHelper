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

public class TeleportSelf implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;

        String tpName = plugin.getConfig().getString("TPs." + player.getUniqueId(), "NONE");
        if (tpName.equals("NONE")) {
            player.sendMessage(ChatColor.YELLOW + "[FarmHelper] you must select a valid tp point before teleporting!");
        }
        String path = "TPs." + player.getUniqueId() + "." + tpName;

        World world = player.getWorld();
        int X = plugin.getConfig().getInt(path + ".X");
        int Y = plugin.getConfig().getInt(path + ".Y");
        int Z = plugin.getConfig().getInt(path + ".Z");

        Location toTp = new Location(world, X, Y, Z);
        player.teleport(toTp);

        return true;
    }
}
