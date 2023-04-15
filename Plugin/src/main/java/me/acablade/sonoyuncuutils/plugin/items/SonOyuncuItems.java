package me.acablade.sonoyuncuutils.plugin.items;

import me.acablade.sonoyuncuutils.plugin.blocks.SonOyuncuDirectional;
import me.acablade.sonoyuncuutils.plugin.blocks.SonOyuncuFurnace;

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
        Block block;
        a(810, "sword_zehirlikeskinlik", (new SonOyuncuSword()).damage(8f).c("sword_zehirlikeskinlik"));
        a(811, "sword_kankilici", (new SonOyuncuSword()).damage(8f).c("sword_kankilici"));
        a(812, "sword_buzperisi", (new SonOyuncuSword()).damage(8f).c("sword_buzperisi"));
        a(813, "sword_mavigokyuzukilici", (new SonOyuncuSword()).damage(9.5f).c("sword_mavigokyuzukilici"));
        a(883, "gun/t_knife", (new SonOyuncuSword()).damage(4f).c("gun/t_knife"));
        a(806, "titanium_waraxe", (new SonOyuncuSword()).damage(7.5f).c("titanium_waraxe"));
        a(790, "titanium_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 0)).c("titanium_helmet"));
        a(791, "titanium_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 1)).c("titanium_chestplate"));
        a(792, "titanium_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 2)).c("titanium_leggings"));
        a(793, "titanium_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 4, 3)).c("titanium_boots"));
        a(802, "titanium_shovel", (new ItemSpade(Item.EnumToolMaterial.EMERALD)).c("titanium_shovel"));
        a(803, "titanium_pickaxe", (new SonOyuncuPickaxe(Item.EnumToolMaterial.EMERALD)).c("titanium_pickaxe"));
        a(804, "titanium_axe", (new SonOyuncuAxe(Item.EnumToolMaterial.EMERALD)).c("titanium_axe"));
        a(805, "titanium_hoe", (new ItemHoe(Item.EnumToolMaterial.EMERALD)).c("titanium_hoe"));
        a(851, "repairkit", (new Item()).c("repairkit"));
        a(853, "hammer", (new Item()).c("hammer"));
        a(855, "lock_iron", (new Item()).c("lock_iron"));
        a(856, "key_golden", (new Item()).c("key_golden"));
        block = new SonOyuncuDirectional().c("tv");
        b(600, new MinecraftKey("tv"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("digital_clock");
        b(601, new MinecraftKey("digital_clock"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("modern_tv");
        b(610, new MinecraftKey("modern_tv"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("fridge");
        b(611, new MinecraftKey("fridge"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("tv_stand");
        b(613, new MinecraftKey("tv_stand"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("range_hood");
        b(614, new MinecraftKey("range_hood"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("oven");
        b(615, new MinecraftKey("oven"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("washing_machine");
        b(616, new MinecraftKey("washing_machine"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("stereo");
        b(617, new MinecraftKey("stereo"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("printer");
        b(618, new MinecraftKey("printer"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("stone_path");
        b(619, new MinecraftKey("stone_path"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("grill");
        b(620, new MinecraftKey("grill"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("bird_bath");
        b(621, new MinecraftKey("bird_bath"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("podium");
        b(535, new MinecraftKey("podium"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("bin");
        b(622, new MinecraftKey("bin"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("toaster");
        b(623, new MinecraftKey("toaster"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("wall_cabinet");
        b(624, new MinecraftKey("wall_cabinet"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("bedside_cabinet_oak");
        b(625, new MinecraftKey("bedside_cabinet_oak"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("bedside_cabinet_spruce");
        b(626, new MinecraftKey("bedside_cabinet_spruce"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("bedside_cabinet_acacia");
        b(629, new MinecraftKey("bedside_cabinet_acacia"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("vent");
        b(630, new MinecraftKey("vent"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("worktable");
        b(631, new MinecraftKey("worktable"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("security_camera");
        b(632, new MinecraftKey("security_camera"), block);
        a(block, (new ItemBlock(block)));
        block = new SonOyuncuDirectional().c("telescope");
        b(633, new MinecraftKey("telescope"), block);
        a(block, (new ItemBlock(block)));
    }

}
