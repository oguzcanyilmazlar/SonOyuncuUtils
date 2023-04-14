package me.acablade.sonoyuncuutils.plugin;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class SonOyuncuPacketsMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        SonOyuncuPackets.init(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
