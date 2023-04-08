package me.acablade.sonoyuncuutils.plugin.items;

import net.minecraft.server.v1_8_R3.*;

public class SonOyuncuItems {

    private static Item get(String var0) {
        return (Item)Item.REGISTRY.get(new MinecraftKey(var0));
    }

    private static void a(int var0, String var1, Item var2) {
        a(var0, new MinecraftKey(var1), var2);
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
        a(811, "sword_mavigokyuzukilici", (new SonOyuncuSword()).damage(9.5f).c("sword_mavigokyuzukilici"));
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
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("customfurnace");
        b(536, new MinecraftKey("customfurnace"), block);
        a(536, "customfurnace", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("customfurnace"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("wasted_flower");
        b(540, new MinecraftKey("wasted_flower"), block);
        a(540, "wasted_flower", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("wasted_flower"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("tv");
        b(600, new MinecraftKey("tv"), block);
        a(600, "tv", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("tv"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("digital_clock");
        b(601, new MinecraftKey("digital_clock"), block);
        a(601, "digital_clock", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("digital_clock"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("chest_iron");
        b(604, new MinecraftKey("chest_iron"), block);
        a(604, "chest_iron", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("chest_iron"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("chest_gold");
        b(605, new MinecraftKey("chest_gold"), block);
        a(605, "chest_gold", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("chest_gold"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("chest_diamond");
        b(606, new MinecraftKey("chest_diamond"), block);
        a(606, "chest_diamond", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("chest_diamond"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("modern_tv");
        b(610, new MinecraftKey("modern_tv"), block);
        a(610, "modern_tv", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("modern_tv"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("fridge");
        b(611, new MinecraftKey("fridge"), block);
        a(611, "fridge", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("fridge"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("tv_stand");
        b(613, new MinecraftKey("tv_stand"), block);
        a(613, "tv_stand", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("tv_stand"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("range_hood");
        b(614, new MinecraftKey("range_hood"), block);
        a(614, "range_hood", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("range_hood"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("oven");
        b(615, new MinecraftKey("oven"), block);
        a(615, "oven", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("oven"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("washing_machine");
        b(616, new MinecraftKey("washing_machine"), block);
        a(616, "washing_machine", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("washing_machine"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("stereo");
        b(617, new MinecraftKey("stereo"), block);
        a(617, "stereo", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("stereo"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("printer");
        b(618, new MinecraftKey("printer"), block);
        a(618, "printer", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("printer"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("stone_path");
        b(619, new MinecraftKey("stone_path"), block);
        a(619, "stone_path", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("stone_path"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("grill");
        b(620, new MinecraftKey("grill"), block);
        a(620, "grill", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("grill"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("bird_bath");
        b(621, new MinecraftKey("bird_bath"), block);
        a(621, "bird_bath", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("bird_bath"));
        block = new SonOyuncuBlock(Material.STONE, MaterialMapColor.d).strength(1.0f).durability(10).stepSound(Block.i).c("podium");
        b(535, new MinecraftKey("podium"), block);
        a(535, "podium", (new SonOyuncuBlock(Material.STONE, MaterialMapColor.d)).strength(1.0f).durability(10).stepSound(Block.i).c("podium"));
    }

}
