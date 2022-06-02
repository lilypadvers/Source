package net.minecraft.src;

import java.util.Random;

public class BlockIce extends BlockBreakable {
	public BlockIce(int blockID, int tex) {
		super(blockID, tex, Material.ice, false);
		this.slipperiness = 0.98F;
		this.setTickOnLoad(true);
	}

	public int getRenderBlockPass() {
		return 1;
	}

	public boolean c(EntitySmokeFX var1, int var2, int var3, int var4, int var5) {
		return super.c(var1, var2, var3, var4, 1 - var5);
	}

	public void onBlockRemoval(World worldObj, int x, int y, int z) {
		Material var5 = worldObj.f(x, y - 1, z);
		if(var5.getIsSolid() || var5.getIsLiquid()) {
			worldObj.setBlockWithNotify(x, y, z, Block.waterMoving.blockID);
		}

	}

	public int quantityDropped(Random rand) {
		return 0;
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		if(worldObj.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - Block.lightOpacity[this.blockID]) {
			this.dropBlockAsItem(worldObj, x, y, z, worldObj.e(x, y, z));
			worldObj.setBlockWithNotify(x, y, z, Block.waterStill.blockID);
		}

	}
}
