package me.acablade.sonoyuncuutils.plugin.blocks;

import net.minecraft.server.v1_8_R3.INamable;

public enum EnumFlowerVariant implements INamable {
    PETUNYA(0, "siyah_petunya"),
    ATES_DIKENI(1, "ates_dikeni"),
    KORKU_DIKENI(2, "korku_dikeni"),
    HAYALET_BITKI(3, "hayalet_bitki"),
    CORAK_BITKI(4, "corak_bitki");

    private static final EnumFlowerVariant[] h = new EnumFlowerVariant[values().length];

    private final int i;
    private final String name;

    EnumFlowerVariant(int var3, String name) {
        this.i = var3;
        this.name = name;
    }

    public int a() {
        return this.i;
    }

    public static EnumFlowerVariant fromInt(int i){
        return h[i%h.length];
    }

    @Override
    public String toString() {
        return name;
    }

    public static EnumFlowerVariant a(int var0) {
        if (var0 < 0 || var0 >= h.length) {
            var0 = 0;
        }

        return h[var0];
    }
    static {
        for(EnumFlowerVariant var3 : values()) {
            h[var3.a()] = var3;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
