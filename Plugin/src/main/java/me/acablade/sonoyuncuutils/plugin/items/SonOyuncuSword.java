package me.acablade.sonoyuncuutils.plugin.items;

import com.google.common.collect.Multimap;
import net.minecraft.server.v1_8_R3.*;

public class SonOyuncuSword extends Item {

    private float dmg;

    public SonOyuncuSword() {
        this.maxStackSize = 1;
        this.a(CreativeModeTab.j);
    }

    public Item damage(float damage){
        this.dmg = damage;
        return this;
    }


    public float getDestroySpeed(ItemStack var1, Block var2) {
        if (var2 == Blocks.WEB) {
            return 15.0F;
        } else {
            Material var3 = var2.getMaterial();
            return var3 != Material.PLANT && var3 != Material.REPLACEABLE_PLANT && var3 != Material.CORAL && var3 != Material.LEAVES && var3 != Material.PUMPKIN ? 1.0F : 1.5F;
        }
    }

    public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        var1.damage(1, var3);
        return true;
    }

    public boolean a(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
        if ((double)var3.g(var2, var4) != 0.0) {
            var1.damage(2, var5);
        }

        return true;
    }

    public EnumAnimation e(ItemStack var1) {
        return EnumAnimation.BLOCK;
    }

    public int d(ItemStack var1) {
        return 72000;
    }

    public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
        var3.a(var1, this.d(var1));
        return var1;
    }

    public boolean canDestroySpecialBlock(Block var1) {
        return var1 == Blocks.WEB;
    }


    public Multimap<String, AttributeModifier> i() {
        Multimap var1 = super.i();
        var1.put(GenericAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(f, "Weapon modifier", (double)this.dmg, 0));
        return var1;
    }

}
