package com.worminthedirt.farmhelper.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;

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

    //sends chat message of mob type when right clicked with an empty hand
    @EventHandler
    public static void onEntityClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getHand() == EquipmentSlot.HAND) {
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                EntityType type = event.getRightClicked().getType();
                player.sendMessage(ChatColor.GREEN + "that is a " + type.toString().toLowerCase());
            }
        }
    }
}
