package me.acablade.sonoyuncuutils.plugin;

import me.acablade.sonoyuncuutils.plugin.items.SonOyuncuItems;
import me.acablade.sonoyuncuutils.plugin.tinyprotocol.TinyProtocol;
import me.acablade.sonoyuncuutils.plugin.tinyprotocol.TinyProtocolImpl;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftMagicNumbers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class SonOyuncuPackets implements Listener {

    private static SonOyuncuPackets instance;

    public static void init(JavaPlugin plugin){
        SonOyuncuItems.init();
        instance = new SonOyuncuPackets(plugin);
        plugin.getServer().getPluginManager().registerEvents(instance, plugin);
    }

    public static SonOyuncuPackets getInstance(){
        return instance;
    }

    private Set<UUID> clientList;
    private final JavaPlugin plugin;

    private TinyProtocol protocol;

    public SonOyuncuPackets(JavaPlugin plugin){
        this.plugin = plugin;
        this.clientList = new HashSet<>();
        protocol = new TinyProtocolImpl(plugin);
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        plugin.getLogger().info(event.getHostname());
        if(event.getHostname().contains("\"token\"")){
            clientList.add(event.getPlayer().getUniqueId());
        }
    }
    @EventHandler
    public void onInteract(BlockPlaceEvent event){
        event.getPlayer().sendMessage(CraftMagicNumbers.getItem(event.getBlockPlaced().getType()).getName());
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event){

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if(clientList.contains(uuid)){
//            protocol.uninjectPlayer(player);
            clientList.remove(uuid);
        }
    }



}
