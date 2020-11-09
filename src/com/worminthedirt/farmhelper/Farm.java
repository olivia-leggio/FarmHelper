package com.worminthedirt.farmhelper;

import org.bukkit.Location;

public class Farm {
    private double x;
    private double y;
    private double z;
    private String world;
    private String name;

    public Farm(Location L, String name) {
        this.x = L.getX();
        this.y = L.getY();
        this.z = L.getZ();
        this.world = L.getWorld().getName();
        this.name = name;
    }
}
