package net.minecraft.src;

import java.util.Random;

public class BlockLog extends Block {
	protected BlockLog(int id) {
		super(id, Material.wood);
		this.blockIndexInTexture = 20;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public int idDropped(int metadata, Random rand) {
		return Block.wood.blockID;
	}

	public int getBlockTextureFromSide(int side) {
		return side == 1?21:(side == 0?21:20);
	}
}
