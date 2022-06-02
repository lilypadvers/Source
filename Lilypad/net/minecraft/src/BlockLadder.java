package net.minecraft.src;

import java.util.Random;

public class BlockLadder extends Block {
	protected BlockLadder(int blockID, int tex) {
		super(blockID, tex, Material.circuits);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldObj, int x, int y, int z) {
		int var5 = worldObj.e(x, y, z);
		float var6 = 0.125F;
		if(var5 == 2) {
			this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
		}

		if(var5 == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
		}

		if(var5 == 4) {
			this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if(var5 == 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
		}

		return super.getCollisionBoundingBoxFromPool(worldObj, x, y, z);
	}

	public AxisAlignedBB getSelectedBoundingBoxFromPool(World worldObj, int x, int y, int z) {
		int var5 = worldObj.e(x, y, z);
		float var6 = 0.125F;
		if(var5 == 2) {
			this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
		}

		if(var5 == 3) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
		}

		if(var5 == 4) {
			this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if(var5 == 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
		}

		return super.getSelectedBoundingBoxFromPool(worldObj, x, y, z);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 8;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.g(x - 1, y, z)?true:(world.g(x + 1, y, z)?true:(world.g(x, y, z - 1)?true:world.g(x, y, z + 1)));
	}

	public void onBlockPlaced(World worldObj, int x, int y, int z, int metadata) {
		int var6 = worldObj.e(x, y, z);
		if((var6 == 0 || metadata == 2) && worldObj.g(x, y, z + 1)) {
			var6 = 2;
		}

		if((var6 == 0 || metadata == 3) && worldObj.g(x, y, z - 1)) {
			var6 = 3;
		}

		if((var6 == 0 || metadata == 4) && worldObj.g(x + 1, y, z)) {
			var6 = 4;
		}

		if((var6 == 0 || metadata == 5) && worldObj.g(x - 1, y, z)) {
			var6 = 5;
		}

		worldObj.setBlockMetadataWithNotify(x, y, z, var6);
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		int var6 = worldObj.e(x, y, z);
		boolean var7 = false;
		if(var6 == 2 && worldObj.g(x, y, z + 1)) {
			var7 = true;
		}

		if(var6 == 3 && worldObj.g(x, y, z - 1)) {
			var7 = true;
		}

		if(var6 == 4 && worldObj.g(x + 1, y, z)) {
			var7 = true;
		}

		if(var6 == 5 && worldObj.g(x - 1, y, z)) {
			var7 = true;
		}

		if(!var7) {
			this.dropBlockAsItem(worldObj, x, y, z, var6);
			worldObj.setBlockWithNotify(x, y, z, 0);
		}

		super.onNeighborBlockChange(worldObj, x, y, z, id);
	}

	public int quantityDropped(Random rand) {
		return 1;
	}
}
