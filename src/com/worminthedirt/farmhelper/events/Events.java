package com.worminthedirt.farmhelper.events;

import com.worminthedirt.farmhelper.FarmHelper;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class Events implements Listener {

    //test event listener
    @EventHandler
    public static void onCamillaJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getDisplayName().equals("roundfrog69")) {
            player.sendMessage(ChatColor.LIGHT_PURPLE + "hi babyyy xoxo <3 ;)");
        }
        else {
            player.sendMessage(ChatColor.DARK_RED + "welcome.. i guess ... ://");
        }
    }

    //teleports the clicked animal to the selected location
    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event) {
        Plugin plugin = FarmHelper.getPlugin(FarmHelper.class);
        Player player = event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                String farmName = plugin.getConfig().getString("Selections." + player.getUniqueId(), "NONE");
                if (farmName.equals("NONE")) {
                    player.sendMessage(ChatColor.YELLOW + "you must select a valid farm before teleporting!");
                }
                String path = "Farms." + player.getUniqueId() + "." + farmName;

                World world = player.getWorld();
                int X = plugin.getConfig().getInt(path + ".X");
                int Y = plugin.getConfig().getInt(path + ".Y");
                int Z = plugin.getConfig().getInt(path + ".Z");

                Location toTp = new Location(world, X, Y, Z);
                event.getRightClicked().teleport(toTp);
            }
        }
    }
}
