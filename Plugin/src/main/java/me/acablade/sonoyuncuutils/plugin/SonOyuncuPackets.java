package me.acablade.sonoyuncuutils.plugin;

import com.comphenix.protocol.ProtocolLibrary;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import me.acablade.sonoyuncuutils.plugin.items.SonOyuncuItems;
import me.acablade.sonoyuncuutils.plugin.packets.DiscordActivityPacket;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.StandardMessenger;

import java.io.IOException;
import java.util.*;

public final class SonOyuncuPackets implements Listener {

    private static SonOyuncuPackets instance;

    public static void init(JavaPlugin plugin){
        SonOyuncuItems.init();
        instance = new SonOyuncuPackets(plugin);
        SonOyuncuPacketManager.registerPackets();
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "Teyyapclntvars\0Teyyap", (s, player, bytes) -> {});
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "Teyyapclntvars\0Teyyap");
        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "MC|GameMenu");
        plugin.getServer().getPluginManager().registerEvents(instance, plugin);
    }

    public static SonOyuncuPackets getInstance(){
        return instance;
    }

    private Set<UUID> clientList;
    private final JavaPlugin plugin;

    public SonOyuncuPackets(JavaPlugin plugin){
        this.plugin = plugin;
        this.clientList = new HashSet<>();
//        protocol = new TinyProtocolImpl(plugin);
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
        // event.getPlayer().sendMessage(CraftMagicNumbers.getItem(event.getBlockPlaced().getType()).getName());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws IOException {
        SonOyuncuPacketManager.sendCustomPacket(event.getPlayer(), new DiscordActivityPacket("Emrenin annesiyle"));
        plugin.getServer().getScheduler().runTaskLater(plugin, () -> open(event.getPlayer()), 20);
    }

    String s = "{\"Title\":\"Kaptan Menüsü\",\"Games\":[{\"ID\":\"orman\",\"TextureID\":\"survival\",\"DisplayName\":\"Orman\",\"Online\":\"111\"},{\"ID\":\"pandora\",\"TextureID\":\"arenapvp\",\"DisplayName\":\"Pandora\",\"Online\":\"37\"},{\"ID\":\"nether\",\"TextureID\":\"thepit\",\"DisplayName\":\"Nether\",\"Online\":\"0\"},{\"ID\":\"pvp\",\"TextureID\":\"survivaltitanium\",\"DisplayName\":\"Titanya Limanı\",\"Online\":\"51\"}]}";
    String open = "Open";

    public void open(Player p){
        ByteBuf byteBuf = Unpooled.buffer();

        byteBuf.writeByte(open.getBytes().length);
        byteBuf.writeBytes(open.getBytes());
        byteBuf.writeBytes(new byte[]{0x01, 0x60});
        byteBuf.writeBytes(s.getBytes());

        p.sendPluginMessage(plugin, "MC|GameMenu", byteBuf.array());

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
