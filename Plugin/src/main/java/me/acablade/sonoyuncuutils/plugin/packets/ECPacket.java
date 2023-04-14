package me.acablade.sonoyuncuutils.plugin.packets;

import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketListener;

import java.io.IOException;

public abstract class ECPacket implements Packet {
    @Override
    public void a(PacketDataSerializer packetDataSerializer) throws IOException {
        readPacketData(packetDataSerializer);
    }

    @Override
    public void b(PacketDataSerializer packetDataSerializer) throws IOException {
        writePacketData(packetDataSerializer);
    }

    @Override
    public void a(PacketListener packetListener) {
        handle(packetListener);
    }


    public abstract void readPacketData(PacketDataSerializer data) throws IOException;
    public abstract void writePacketData(PacketDataSerializer data) throws IOException;
    public abstract void handle(PacketListener packetListener);

}
