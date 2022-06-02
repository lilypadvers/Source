package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
	public BlockOre(int id, int tex) {
		super(id, tex, Material.rock);
	}

	public int idDropped(int metadata, Random rand) {
		return this.blockID == Block.oreCoal.blockID?Item.coal.aR:(this.blockID == Block.oreDiamond.blockID?Item.diamond.aR:this.blockID);
	}

	public int quantityDropped(Random rand) {
		return 1;
	}
}
