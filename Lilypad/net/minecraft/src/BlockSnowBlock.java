package net.minecraft.src;

import java.util.Random;

public class BlockSnowBlock extends Block {
	protected BlockSnowBlock(int id, int tex) {
		super(id, tex, Material.craftedSnow);
		this.setTickOnLoad(true);
	}

	public int idDropped(int metadata, Random rand) {
		return Item.snowball.aR;
	}

	public int quantityDropped(Random rand) {
		return 4;
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		if(worldObj.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11) {
			this.dropBlockAsItem(worldObj, x, y, z, worldObj.e(x, y, z));
			worldObj.setBlockWithNotify(x, y, z, 0);
		}

	}
}
