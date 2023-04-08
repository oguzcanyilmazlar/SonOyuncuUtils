header = """package me.acablade.sonoyuncuutils.plugin.items;

import net.minecraft.server.v1_8_R3.*;

import java.util.Iterator;

public class SonOyuncuItems {

    private static Item get(String var0) {
        return (Item)Item.REGISTRY.get(new MinecraftKey(var0));
    }

    private static void a(int var0, String var1, Item var2) {
        a(var0, new MinecraftKey(var1), var2);
    }

    private static void a(int var0, String var1, Block var2) {
        b(var0, new MinecraftKey(var1), var2);
    }

    private static void b(int var0, MinecraftKey key, Block block){
        Block.REGISTRY.a(var0, key, block);
    }

    private static void a(Block var0, Item var1) {
        a(Block.getId(var0), Block.REGISTRY.c(var0), var1);
        Iterator iterator1 = var0.P().a().iterator();
        while(iterator1.hasNext()) {
            IBlockData iblockdata = (IBlockData)iterator1.next();
            int i = Block.REGISTRY.b(var0) << 4 | var0.toLegacyData(iblockdata);
            Block.d.a(iblockdata, i);
        }
    }

    private static void a(int var0, MinecraftKey var1, Item var2) {
        Item.REGISTRY.a(var0, var1, var2);
    }


    public static void init(){
"""

footer = """
    }

}
"""