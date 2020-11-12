package com.worminthedirt.farmhelper.commands;


import com.worminthedirt.farmhelper.FarmHelper;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import java.util.Set;

//sends a list of the users saved farm points in chat
public class ListFarms implements CommandExecutor {
    private Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.DARK_RED + "you must be a player to use this command!");
            return false;
        }
        Player player = (Player) sender;
        ConfigurationSection cs = plugin.getConfig().getConfigurationSection("Farms." + player.getUniqueId());
        Object[] farmsArray = cs.getKeys(false).toArray();

        try {
            for (int i = 0; i < farmsArray.length; i++) {
                sender.sendMessage(ChatColor.YELLOW + farmsArray[i].toString());
            }
        }
        catch (Exception e) {
            player.sendMessage(ChatColor.DARK_RED + "could not list your farms!");
            player.sendMessage(ChatColor.DARK_RED + e.toString());
        }
        return true;
    }
}
