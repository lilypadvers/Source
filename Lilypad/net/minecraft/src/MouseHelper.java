package net.minecraft.src;

import java.util.Random;

public class MouseHelper extends Block {
	protected MouseHelper(int var1, int var2) {
		super(var1, Material.plants);
		this.blockIndexInTexture = var2;
		this.setTickOnLoad(true);
		float var3 = 0.2F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return this.b(world.a(x, y - 1, z));
	}

	protected boolean b(int var1) {
		return var1 == Block.v.blockID || var1 == Block.dirt.blockID || var1 == Block.tilledField.blockID;
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		super.onNeighborBlockChange(worldObj, x, y, z, id);
		this.h(worldObj, x, y, z);
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		this.h(worldObj, x, y, z);
	}

	protected final void h(World var1, int var2, int var3, int var4) {
		if(!this.canBlockStay(var1, var2, var3, var4)) {
			this.dropBlockAsItem(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.setBlockWithNotify(var2, var3, var4, 0);
		}

	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return (world.getBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && this.b(world.a(x, y - 1, z));
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
		return 1;
	}
}
