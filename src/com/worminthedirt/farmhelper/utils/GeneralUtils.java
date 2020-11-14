package com.worminthedirt.farmhelper.utils;

import org.bukkit.Bukkit;

public class GeneralUtils {
    public static void toConsole(String msg) {
        Bukkit.getConsoleSender().sendMessage(msg);
    }
}
