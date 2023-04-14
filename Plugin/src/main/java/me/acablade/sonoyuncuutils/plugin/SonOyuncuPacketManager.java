package me.acablade.sonoyuncuutils.plugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.FieldUtils;
import com.comphenix.protocol.reflect.accessors.Accessors;
import com.comphenix.protocol.utility.MinecraftVersion;
import com.google.common.collect.BiMap;
import me.acablade.Commons;
import me.acablade.sonoyuncuutils.plugin.packets.ECPacket;
import me.acablade.sonoyuncuutils.plugin.packets.DiscordActivityPacket;
import me.acablade.sonoyuncuutils.plugin.packets.SPacket;
import net.minecraft.server.v1_8_R3.EnumProtocol;
import net.minecraft.server.v1_8_R3.EnumProtocolDirection;
import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SonOyuncuPacketManager {

    private static final HashMap<Class<? extends ECPacket>, PacketType> packetToType = new HashMap<Class<? extends ECPacket>, PacketType>();

    public static void registerPackets(){
        registerPacket(DiscordActivityPacket.class, Commons.PacketIds.SPacketLoginScreen, PacketType.Sender.SERVER);
    }

    private static void registerPacket(Class<? extends ECPacket> packetClass, int packetId, PacketType.Sender sender){
        final PacketType packetType = new PacketType(PacketType.Protocol.PLAY, sender, packetId, MinecraftVersion.BOUNTIFUL_UPDATE, "DiscordActivity");

        packetToType.put(packetClass, packetType);

        final EnumProtocol protocol = EnumProtocol.PLAY;

        final EnumProtocolDirection direction = packetType.isClient() ? EnumProtocolDirection.SERVERBOUND : EnumProtocolDirection.CLIENTBOUND;

        try {
            Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>> map = (Map<EnumProtocolDirection, BiMap<Integer, Class<? extends Packet<?>>>>) FieldUtils.readField(protocol, "j", true);

            BiMap<Integer, Class<? extends Packet<?>>> biMap = map.get(direction);

            biMap.put(packetId, (Class<? extends Packet<?>>) packetClass);
            map.put(direction, biMap);


        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Map<Class<?>, EnumProtocol> map = (Map<Class<?>, EnumProtocol>) Accessors.getFieldAccessor(EnumProtocol.class, Map.class, true).get(protocol);
        map.put(packetClass, protocol);

    }

    public static void sendCustomPacket(Player player, SPacket sPacket){
        PacketContainer packetContainer = new PacketContainer(packetToType.get(sPacket.getClass()), sPacket);

        try{
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packetContainer);
        }catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }



    }

    public static PacketType getCustomPacketType(Class<? extends ECPacket> clazz){
        return packetToType.get(clazz);
    }

}
