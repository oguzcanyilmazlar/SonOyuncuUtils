package me.acablade.sonoyuncuutils.plugin.items;

import net.minecraft.server.v1_8_R3.*;

import static net.minecraft.server.v1_8_R3.EnumDirection.*;
import static net.minecraft.server.v1_8_R3.EnumDirection.EAST;

public class SonOyuncuBlock extends Block {
    public SonOyuncuBlock(Material material, MaterialMapColor materialmapcolor) {
        super(material, materialmapcolor);
    }

    public SonOyuncuBlock strength(float f){
        return (SonOyuncuBlock) this.c(f);
    }
    public SonOyuncuBlock durability(float f){
        return (SonOyuncuBlock) this.b(f);
    }

    public SonOyuncuBlock stepSound(StepSound block_stepsound) {
        return (SonOyuncuBlock) this.a(block_stepsound);
    }

    public static EnumDirection fix(EnumDirection direction){
        switch (direction){
            case EAST:
                return SOUTH;
            case WEST:
                return WEST;
            case SOUTH:
                return NORTH;
            default:
                return EAST;
        }
    }

}
