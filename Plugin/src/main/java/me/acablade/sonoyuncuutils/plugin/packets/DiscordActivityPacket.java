package me.acablade.sonoyuncuutils.plugin.packets;

import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketListener;

import java.io.IOException;

public class DiscordActivityPacket extends SPacket{

    private String string;

    public DiscordActivityPacket(String string){
        this.string = string;
    }

    @Override
    public void readPacketData(PacketDataSerializer data) throws IOException {
    }

    @Override
    public void writePacketData(PacketDataSerializer data) throws IOException {
        //data.writeInt(Commons.PacketIds.SPacketLoginScreen);
        data.writeByte(string.length());
        data.writeBytes(string.getBytes());
    }

    @Override
    public void handle(PacketListener packetListener) {

    }
}
