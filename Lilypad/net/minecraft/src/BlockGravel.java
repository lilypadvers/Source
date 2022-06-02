package net.minecraft.src;

import java.util.Random;

public class BlockGravel extends BlockSand {
	public BlockGravel(int var1, int var2) {
		super(var1, var2);
	}

	public int idDropped(int metadata, Random rand) {
		return rand.nextInt(10) == 0?Item.flint.aR:this.blockID;
	}
}
