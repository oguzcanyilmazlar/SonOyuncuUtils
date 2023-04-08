package me.acablade.sonoyuncuutils.plugin.tinyprotocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.IOException;


public class TinyProtocolImpl extends TinyProtocol {

    /**
     * Construct a new instance of TinyProtocol, and start intercepting packets for all connected clients and future clients.
     * <p>
     * You can construct multiple instances per plugin.
     *
     * @param plugin - the plugin.
     */
    public TinyProtocolImpl(Plugin plugin) {
        super(plugin);
    }



    @Override
    public Object onPacketInAsync(Player sender, Channel channel, Object packet) {
        if(packet instanceof PacketPlayInCustomPayload)
            handlePayload(channel, packet);
        else if(packet instanceof PacketPlayInSetCreativeSlot)
            handleWindowClick(sender, channel, packet);
        else if(packet instanceof PacketPlayInBlockPlace)
            handleBlockPlacement(sender, channel, packet);


        return super.onPacketInAsync(sender, channel, packet);
    }

    private void handleWindowClick(Player player, Channel channel, Object packet){

        PacketPlayInSetCreativeSlot creative = (PacketPlayInSetCreativeSlot) packet;

        if(creative.getItemStack() == null) return;

        plugin.getLogger().info("itemstack: " + creative.getItemStack().getItem().getName());


    }

    private void handleBlockPlacement(Player player, Channel channel, Object packet){

        PacketPlayInBlockPlace blockPlace = (PacketPlayInBlockPlace) packet;

        if(blockPlace.getItemStack() == null) return;

        plugin.getLogger().info("itemstack: " + blockPlace.getItemStack().getItem().getName());


    }

    private void handlePayload(Channel channel, Object packet){
        PacketPlayInCustomPayload payload = (PacketPlayInCustomPayload) packet;

        String payloadChannel = payload.a();
        ByteBuf bytes = payload.b();

//        plugin.getLogger().info(payloadChannel);
//        plugin.getLogger().info(Arrays.toString(bytes.array()));
//        plugin.getLogger().info(new String(bytes.array()));
    }

    private void handleBlockOut(Player receiver, Channel channel, Object packet) {

        PacketPlayOutBlockChange change = (PacketPlayOutBlockChange) packet;

        PacketDataSerializer dataSerializer = new PacketDataSerializer(Unpooled.buffer());

        try {
            change.b(dataSerializer);
            BlockPosition pos = dataSerializer.c();
            int x = dataSerializer.e();
            int type = x >> 4;
            plugin.getLogger().info("id: " + type);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Object onPacketOutAsync(Player receiver, Channel channel, Object packet) {
        if(packet instanceof PacketPlayOutBlockChange)
            handleBlockOut(receiver, channel, packet);
        return super.onPacketOutAsync(receiver, channel, packet);
    }
}
