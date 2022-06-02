package net.minecraft.src;

import java.util.Random;

public class ClassIf extends Block {
	protected ClassIf(int var1, int var2) {
		super(var1, var2, Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldObj, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public MovingObjectPosition collisionRayTrace(World worldObj, int x, int y, int z, Vec3D vector1, Vec3D vector2) {
		this.a(worldObj, x, y, z);
		return super.collisionRayTrace(worldObj, x, y, z, vector1, vector2);
	}

	public void a(EntitySmokeFX var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4);
		if(var5 >= 2 && var5 <= 5) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
		} else {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		}

	}

	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return metadata >= 6?this.blockIndexInTexture - 16:this.blockIndexInTexture;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 9;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.g(x, y - 1, z);
	}

	public void onBlockAdded(World worldObj, int x, int y, int z) {
		worldObj.setBlockMetadataWithNotify(x, y, z, 15);
		this.h(worldObj, x, y, z);
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		int var6 = worldObj.e(x, y, z);
		boolean var7 = false;
		if(!worldObj.g(x, y - 1, z)) {
			var7 = true;
		}

		if(var6 == 2 && !worldObj.g(x + 1, y, z)) {
			var7 = true;
		}

		if(var6 == 3 && !worldObj.g(x - 1, y, z)) {
			var7 = true;
		}

		if(var6 == 4 && !worldObj.g(x, y, z - 1)) {
			var7 = true;
		}

		if(var6 == 5 && !worldObj.g(x, y, z + 1)) {
			var7 = true;
		}

		if(var7) {
			this.dropBlockAsItem(worldObj, x, y, z, worldObj.e(x, y, z));
			worldObj.setBlockWithNotify(x, y, z, 0);
		} else if(id > 0 && Block.blocksList[id].canProvidePower() && (new MinecartTrackLogic(this, worldObj, x, y, z)).getAdjacentTracks() == 3) {
			this.h(worldObj, x, y, z);
		}

	}

	private void h(World var1, int var2, int var3, int var4) {
		(new MinecartTrackLogic(this, var1, var2, var3, var4)).place(var1.isBlockIndirectlyGettingPowered(var2, var3, var4));
	}
}