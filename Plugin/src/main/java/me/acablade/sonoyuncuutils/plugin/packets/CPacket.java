package me.acablade.sonoyuncuutils.plugin.packets;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketListener;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

import java.io.IOException;
import java.util.UUID;

public abstract class CPacket extends ECPacket{

    public String readString(PacketDataSerializer data) {
        int stringLength = data.readInt();
        return data.c(stringLength);
    }

    public byte[] readByteArray(PacketDataSerializer data) {
        return data.a();
    }

    public UUID readUUID(PacketDataSerializer data) {
        return data.g();
    }

    public <T extends Enum<T>> T readEnum(PacketDataSerializer data, final Class<T> oclass) {
        return oclass.getEnumConstants()[data.e()];
    }

    public BlockPosition readBlockPosition(PacketDataSerializer data) {
        return data.c();
    }

    public int[] readBlockPositionBukkit(PacketDataSerializer data) {
        BlockPosition pos = readBlockPosition(data);
        return new int[] {pos.getX(), pos.getY(), pos.getZ()};
    }

    public net.minecraft.server.v1_8_R3.ItemStack readItemStack(PacketDataSerializer data) throws IOException {
        return data.i();
    }

    public org.bukkit.inventory.ItemStack readItemStackBukkit(PacketDataSerializer data) throws IOException {
        return CraftItemStack.asBukkitCopy(readItemStack(data));
    }

    public NBTTagCompound readNBTTagCompound(PacketDataSerializer data) throws IOException {
        return data.h();
    }

}
