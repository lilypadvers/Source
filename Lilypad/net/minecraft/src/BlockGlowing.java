package net.minecraft.src;

import java.util.Random;

public class BlockGlowing extends Block {
	int renderMode = 1;

	protected BlockGlowing(int var1, int var2, int var3) {
		super(var1, var2, Material.plants);
		this.setTickOnLoad(true);
		this.renderMode = var3;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldObj, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return this.renderMode;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return true;
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		super.updateTick(worldObj, x, y, z, rand);
		if(worldObj.e(x, y, z) == 0) {
			this.onBlockAdded(worldObj, x, y, z);
		}

	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		if(this.h(worldObj, x, y, z)) {
			int var6 = worldObj.e(x, y, z);
			boolean var7 = false;
			if(!worldObj.g(x - 1, y, z) && var6 == 1) {
				var7 = true;
			}

			if(!worldObj.g(x + 1, y, z) && var6 == 2) {
				var7 = true;
			}

			if(!worldObj.g(x, y, z - 1) && var6 == 3) {
				var7 = true;
			}

			if(!worldObj.g(x, y, z + 1) && var6 == 4) {
				var7 = true;
			}

			if(!worldObj.g(x, y - 1, z) && var6 == 5) {
				var7 = true;
			}

			if(var7) {
				this.dropBlockAsItem(worldObj, x, y, z, worldObj.e(x, y, z));
				worldObj.setBlockWithNotify(x, y, z, 0);
			}
		}

	}

	private boolean h(World var1, int var2, int var3, int var4) {
		if(!this.canPlaceBlockAt(var1, var2, var3, var4)) {
			this.dropBlockAsItem(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.setBlockWithNotify(var2, var3, var4, 0);
			return false;
		} else {
			return true;
		}
	}

	public void randomDisplayTick(World worldObj, int x, int y, int z, Random rand) {
	}
}
