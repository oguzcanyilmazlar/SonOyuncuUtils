package me.acablade.sonoyuncuutils.plugin.items;

import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.ItemBlock;
import net.minecraft.server.v1_8_R3.Material;
import net.minecraft.server.v1_8_R3.MaterialMapColor;

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

}
