package me.acablade.sonoyuncuutils.plugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import me.acablade.sonoyuncuutils.plugin.items.SonOyuncuItems;
import me.acablade.sonoyuncuutils.plugin.objects.KaptanMenu;
import me.acablade.sonoyuncuutils.plugin.packets.DiscordActivityPacket;
import me.acablade.sonoyuncuutils.plugin.packets.wrapper.WrapperPlayServerChat;
import me.acablade.sonoyuncuutils.plugin.packets.wrapper.WrapperPlayServerCustomPayload;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public final class SonOyuncuPackets implements Listener {

    private static SonOyuncuPackets instance;

    public static void init(JavaPlugin plugin){
        SonOyuncuItems.init();
        instance = new SonOyuncuPackets(plugin);
        instance.protocolLib = plugin.getServer().getPluginManager().isPluginEnabled("ProtocolLib");
        if(!instance.protocolLib){
            plugin.getLogger().warning("ProtocolLib bulunamadı, paketler çalışmaz durumda");
        }else{
            SonOyuncuPacketManager.registerPackets();
        }
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "Teyyapclntvars", (s, player, bytes) -> {});
        plugin.getServer().getPluginManager().registerEvents(instance, plugin);
    }

    public static SonOyuncuPackets getInstance(){
        return instance;
    }

    private boolean protocolLib;
    private Set<UUID> clientList;
    private final JavaPlugin plugin;

    public SonOyuncuPackets(JavaPlugin plugin){
        this.plugin = plugin;
        this.clientList = new HashSet<>();
    }
    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        if(event.getHostname().contains("\"token\"")){
            clientList.add(event.getPlayer().getUniqueId());
        }
    }

    public void setDiscordActivity(Player player, String name){
        if(!protocolLib) return;
        if(name.length() > 0xFF) return;
        SonOyuncuPacketManager.sendCustomPacket(player, new DiscordActivityPacket(name));
    }

    public void openKaptanMenu(Player player, KaptanMenu kaptanMenu) throws InvocationTargetException {
        if(!protocolLib) throw new PluginNotEnabledException("ProtocolLib bulunamadı!");
        WrapperPlayServerCustomPayload payload = new WrapperPlayServerCustomPayload();
        payload.setChannel("MC|GameMenu");
        payload.setContents(kaptanMenuBytes(kaptanMenu));
        ProtocolLibrary.getProtocolManager().sendServerPacket(player, payload.getHandle());
    }

    public void openLoginMenu(Player player) throws InvocationTargetException {
        if(!protocolLib) throw new PluginNotEnabledException("ProtocolLib bulunamadı!");
        WrapperPlayServerChat playServerChat = new WrapperPlayServerChat();
        playServerChat.setPosition((byte)10);
        playServerChat.setMessage(WrappedChatComponent.fromJson("\"{\\\"action\\\": \\\"displayGUI\\\", \\\"screenType\\\": \\\"login\\\", \\\"username\\\": \\\""+player.getName()+"\\\", \\\"chatLoginFormat\\\": \\\"/login \\u003cpassword\\u003e\\\"}\""));
        ProtocolLibrary.getProtocolManager().sendServerPacket(player, playServerChat.getHandle());
    }

    public void setCooldown(Player player, Material material, int tick) throws InvocationTargetException {
        if(!protocolLib) throw new PluginNotEnabledException("ProtocolLib bulunamadı!");
        WrapperPlayServerCustomPayload payload = new WrapperPlayServerCustomPayload();
        payload.setChannel("Teyyap");

        String s = "itemcooldown###" + material.getId() + "###" + tick;

        ByteBuf byteBuf = Unpooled.buffer();
        byteBuf.writeBytes(trimuint8(s.length()));
        byteBuf.writeBytes(s.getBytes());

        byte[] bytes = Arrays.copyOf(byteBuf.array(), 2 + s.length());
        payload.setContents(bytes);
        ProtocolLibrary.getProtocolManager().sendServerPacket(player, payload.getHandle());
    }

    String open = "Open";

    public byte[] convertToByteArray(int num)
    {
        final byte[] array = new byte[4];
        array[0] = (byte)((num & 0xFF000000) >> 24);
        array[1] = (byte)((num & 0xFF0000) >> 16);
        array[2] = (byte)((num & 0xFF00) >> 8);
        array[3] = (byte)(num & 0xFF);
        return array;
    }

    private byte[] trimuint8(int len){

        return Arrays.copyOfRange(convertToByteArray(len), 2, 4);
    }

    private byte[] kaptanMenuBytes(KaptanMenu menu){
        String s = menu.build();
        if(s.length() > 0xFFFF) return new byte[0];

        ByteBuf byteBuf = Unpooled.buffer();

        byteBuf.writeByte(0);
        byteBuf.writeByte(open.getBytes().length);
        byteBuf.writeBytes(open.getBytes());

        byte[] sLen = trimuint8(s.length());

        byteBuf.writeBytes(sLen);
        byteBuf.writeBytes(s.getBytes());

        return Arrays.copyOf(byteBuf.array(), 1 + 1 + 4 + sLen.length + s.length());
    }


    @EventHandler
    public void onQuit(PlayerQuitEvent event){

        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if(clientList.contains(uuid)){
            clientList.remove(uuid);
        }
    }



}
