package me.acablade.sonoyuncuutils.plugin.blocks;


import java.util.Arrays;
import java.util.Random;

import me.acablade.Commons;
import net.minecraft.server.v1_8_R3.*;
import net.minecraft.server.v1_8_R3.EnumDirection.EnumAxis;
import net.minecraft.server.v1_8_R3.EnumDirection.EnumDirectionLimit;

public class SonOyuncuFurnace extends BlockContainer {

    //


    public static final BlockStateEnum<Variant> VARIANT = BlockStateEnum.of("variant", Variant.class);
    public static final BlockStateDirection FACING = BlockStateDirection.of("facing", EnumDirectionLimit.HORIZONTAL);

    public SonOyuncuFurnace() {
        super(Material.STONE);
        this.j(this.blockStateList.getBlockData().set(FACING, EnumDirection.NORTH));
        this.j(this.blockStateList.getBlockData().set(VARIANT, Variant.IRON));
    }

    public Item getDropType(IBlockData var1, Random var2, int var3) {
        return Item.getById(526);
    }

    public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
        this.e(var1, var2, var3);
    }

    private void e(World var1, BlockPosition var2, IBlockData var3) {
        if (!var1.isClientSide) {
            Block var4 = var1.getType(var2.north()).getBlock();
            Block var5 = var1.getType(var2.south()).getBlock();
            Block var6 = var1.getType(var2.west()).getBlock();
            Block var7 = var1.getType(var2.east()).getBlock();
            EnumDirection var8 = (EnumDirection)var3.get(FACING);
            if (var8 == EnumDirection.NORTH && var4.o() && !var5.o()) {
                var8 = EnumDirection.SOUTH;
            } else if (var8 == EnumDirection.SOUTH && var5.o() && !var4.o()) {
                var8 = EnumDirection.NORTH;
            } else if (var8 == EnumDirection.WEST && var6.o() && !var7.o()) {
                var8 = EnumDirection.EAST;
            } else if (var8 == EnumDirection.EAST && var7.o() && !var6.o()) {
                var8 = EnumDirection.WEST;
            }

            var1.setTypeAndData(var2, var3.set(FACING, var8), 2);
        }
    }

    public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumDirection var5, float var6, float var7, float var8) {
        if (var1.isClientSide) {
            return true;
        } else {
            TileEntity var9 = var1.getTileEntity(var2);
            if (var9 instanceof TileEntityFurnace) {
                var4.openContainer((TileEntityFurnace)var9);
                var4.b(StatisticList.Y);
            }

            return true;
        }
    }

    public TileEntity a(World var1, int var2) {
        return new TileEntityFurnace();
    }


    public int getDropData(IBlockData var1) {
        return (var1.get(VARIANT)).a();
    }

    public IBlockData getPlacedState(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
//        System.out.println(var8.bA().getData());
        return this.getBlockData().set(FACING, var8.getDirection().opposite()).set(VARIANT, Variant.fromInt(var8.bA().getData()));
    }

    public void postPlace(World var1, BlockPosition var2, IBlockData var3, EntityLiving var4, ItemStack var5) {

        var1.setTypeAndData(var2, var3.set(FACING, var4.getDirection().opposite()).set(VARIANT, Variant.fromInt(var5.getData())), 0);
        if (var5.hasName()) {
            TileEntity var6 = var1.getTileEntity(var2);
            if (var6 instanceof TileEntityFurnace) {
                ((TileEntityFurnace)var6).a(var5.getName());
            }
        }
    }

    public void remove(World var1, BlockPosition var2, IBlockData var3) {
        TileEntity var4 = var1.getTileEntity(var2);
        if (var4 instanceof TileEntityFurnace) {
            InventoryUtils.dropInventory(var1, var2, (TileEntityFurnace)var4);
            var1.updateAdjacentComparators(var2, this);
        }
        super.remove(var1, var2, var3);
    }

    public boolean isComplexRedstone() {
        return true;
    }

    public int l(World var1, BlockPosition var2) {
        return Container.a(var1.getTileEntity(var2));
    }

    public int b() {
        return -1;
    }

    public IBlockData fromLegacyData(int var1) {

        System.out.println(var1);


        int facing = (var1 & 0xFF00) >>> 8;
        int variant = (var1 & 0xFF);

        EnumDirection var2 = EnumDirection.fromType1(facing);
        if (var2.k() == EnumAxis.Y) {
            var2 = EnumDirection.NORTH;
        }

        return this.getBlockData().set(FACING, var2).set(VARIANT, Variant.fromInt(variant));
    }

    public int toLegacyData(IBlockData var1) {

        System.out.println(var1);

        return var1.get(FACING).a() | (var1.get(VARIANT).ordinal() << 8);
    }

    protected BlockStateList getStateList() {
        return new BlockStateList(this, new IBlockState[]{FACING, VARIANT});
    }

    public static enum Variant implements INamable {
        IRON(0, "iron"),
        GOLD(1, "gold"),
        DIAMOND(2, "diamond"),
        OBSIDIAN(3, "obsidian");

        private static final Variant[] h = new Variant[values().length];

        private final int i;
        private final String name;

        Variant(int var3, String name) {
            this.i = var3;
            this.name = name;
        }

        public int a() {
            return this.i;
        }

        public static Variant fromInt(int i){
            return h[i%h.length];
        }

        @Override
        public String toString() {
            return name;
        }

        public static Variant a(int var0) {
            if (var0 < 0 || var0 >= h.length) {
                var0 = 0;
            }

            return h[var0];
        }
        static {
            for(Variant var3 : values()) {
                h[var3.a()] = var3;
            }
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
