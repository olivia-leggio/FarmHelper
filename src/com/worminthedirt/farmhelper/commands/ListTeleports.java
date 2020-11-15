package com.worminthedirt.farmhelper.commands;

import com.worminthedirt.farmhelper.FarmHelper;
import com.worminthedirt.farmhelper.utils.GeneralUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ListTeleports implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "[FarmHelper] you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;

        try {
            for (String tpName : plugin.getConfig().getConfigurationSection("TPs." + player.getUniqueId()).getKeys(false)) {
                player.sendMessage(ChatColor.YELLOW + tpName);
            }
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "[FarmHelper] could not list your tp points!");
            GeneralUtils.toConsole(e.toString());
            return false;
        }

        return true;
    }
}
