package me.acablade.sonoyuncuutils.plugin.blocks;

import net.minecraft.server.v1_8_R3.*;

import static me.acablade.sonoyuncuutils.plugin.items.SonOyuncuBlock.fix;
import static net.minecraft.server.v1_8_R3.EnumDirection.*;

public class SonOyuncuDirectional extends BlockDirectional {

    // EAST -> NORTH
    // WEST -> EAST
    // SOUTH -> WEST
    // NORTH -> SOUTH


    public SonOyuncuDirectional() {
        super(Material.PUMPKIN, MaterialMapColor.q);
        this.j(this.blockStateList.getBlockData().set(FACING, EnumDirection.SOUTH));
        this.a(true);
        this.a(CreativeModeTab.b);
    }


    public boolean canPlace(World world, BlockPosition blockposition) {
        return world.getType(blockposition).getBlock().getMaterial().isReplaceable() && World.a(world, blockposition.down());
    }

    public IBlockData getPlacedState(
            World world, BlockPosition blockposition, EnumDirection enumdirection, float f, float f1, float f2, int i, EntityLiving entityliving
    ) {
        return this.getBlockData().set(FACING, fix(entityliving.getDirection()));
    }

    public IBlockData fromLegacyData(int i) {
        return this.getBlockData().set(FACING, EnumDirection.fromType2(i));
    }

    public int toLegacyData(IBlockData iblockdata) {
        return ((EnumDirection)iblockdata.get(FACING)).b();
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, FACING);
    }


}
