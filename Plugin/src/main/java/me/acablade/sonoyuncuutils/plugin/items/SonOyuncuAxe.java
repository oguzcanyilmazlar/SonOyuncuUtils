package me.acablade.sonoyuncuutils.plugin.items;

import com.google.common.collect.Sets;
import net.minecraft.server.v1_8_R3.*;

import java.util.Set;

public class SonOyuncuAxe extends ItemTool {
    private static final Set<Block> c;

    protected SonOyuncuAxe(Item.EnumToolMaterial var1) {
        super(3.0F, var1, c);
    }

    public float getDestroySpeed(ItemStack var1, Block var2) {
        return var2.getMaterial() != Material.WOOD && var2.getMaterial() != Material.PLANT && var2.getMaterial() != Material.REPLACEABLE_PLANT ? super.getDestroySpeed(var1, var2) : this.a;
    }

    static {
        c = Sets.newHashSet(new Block[]{Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER});
    }
}
