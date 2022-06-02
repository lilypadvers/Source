package net.minecraft.src;

public class WorldGenLiquids extends Block {
	protected WorldGenLiquids(int var1, int var2) {
		super(var1, var2, Material.circuits);
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
		return 12;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.g(x - 1, y, z)?true:(world.g(x + 1, y, z)?true:(world.g(x, y, z - 1)?true:(world.g(x, y, z + 1)?true:world.g(x, y - 1, z))));
	}

	public void onBlockPlaced(World worldObj, int x, int y, int z, int metadata) {
		int var6 = worldObj.e(x, y, z);
		int var7 = var6 & 8;
		var6 &= 7;
		if(metadata == 1 && worldObj.g(x, y - 1, z)) {
			var6 = 5 + worldObj.rand.nextInt(2);
		}

		if(metadata == 2 && worldObj.g(x, y, z + 1)) {
			var6 = 4;
		}

		if(metadata == 3 && worldObj.g(x, y, z - 1)) {
			var6 = 3;
		}

		if(metadata == 4 && worldObj.g(x + 1, y, z)) {
			var6 = 2;
		}

		if(metadata == 5 && worldObj.g(x - 1, y, z)) {
			var6 = 1;
		}

		worldObj.setBlockMetadataWithNotify(x, y, z, var6 + var7);
	}

	public void onBlockAdded(World worldObj, int x, int y, int z) {
		if(worldObj.g(x - 1, y, z)) {
			worldObj.setBlockMetadataWithNotify(x, y, z, 1);
		} else if(worldObj.g(x + 1, y, z)) {
			worldObj.setBlockMetadataWithNotify(x, y, z, 2);
		} else if(worldObj.g(x, y, z - 1)) {
			worldObj.setBlockMetadataWithNotify(x, y, z, 3);
		} else if(worldObj.g(x, y, z + 1)) {
			worldObj.setBlockMetadataWithNotify(x, y, z, 4);
		} else if(worldObj.g(x, y - 1, z)) {
			worldObj.setBlockMetadataWithNotify(x, y, z, 5 + worldObj.rand.nextInt(2));
		}

		this.h(worldObj, x, y, z);
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		if(this.h(worldObj, x, y, z)) {
			int var6 = worldObj.e(x, y, z) & 7;
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

	public void a(EntitySmokeFX var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4) & 7;
		float var6 = 0.1875F;
		if(var5 == 1) {
			this.setBlockBounds(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
		} else if(var5 == 2) {
			this.setBlockBounds(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
		} else if(var5 == 3) {
			this.setBlockBounds(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
		} else if(var5 == 4) {
			this.setBlockBounds(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
		} else {
			var6 = 0.25F;
			this.setBlockBounds(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
		}

	}

	public void onBlockClicked(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		this.blockActivated(worldObj, x, y, z, entityPlayer);
	}

	public boolean blockActivated(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		int var6 = worldObj.e(x, y, z);
		int var7 = var6 & 7;
		int var8 = 8 - (var6 & 8);
		worldObj.setBlockMetadataWithNotify(x, y, z, var7 + var8);
		worldObj.markBlocksDirty(x, y, z, x, y, z);
		worldObj.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, var8 > 0?0.6F:0.5F);
		worldObj.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
		if(var7 == 1) {
			worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
		} else if(var7 == 2) {
			worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
		} else if(var7 == 3) {
			worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
		} else if(var7 == 4) {
			worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
		} else {
			worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
		}

		return true;
	}

	public void onBlockRemoval(World worldObj, int x, int y, int z) {
		int var5 = worldObj.e(x, y, z);
		if((var5 & 8) > 0) {
			worldObj.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
			int var6 = var5 & 7;
			if(var6 == 1) {
				worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
			} else if(var6 == 2) {
				worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
			} else if(var6 == 3) {
				worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
			} else if(var6 == 4) {
				worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
			} else {
				worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
			}
		}

		super.onBlockRemoval(worldObj, x, y, z);
	}

	public boolean b(EntitySmokeFX var1, int var2, int var3, int var4, int var5) {
		return (var1.e(var2, var3, var4) & 8) > 0;
	}

	public boolean isIndirectlyPoweringTo(World worldObj, int x, int y, int z, int side) {
		int var6 = worldObj.e(x, y, z);
		if((var6 & 8) == 0) {
			return false;
		} else {
			int var7 = var6 & 7;
			return var7 == 5 && side == 1?true:(var7 == 4 && side == 2?true:(var7 == 3 && side == 3?true:(var7 == 2 && side == 4?true:var7 == 1 && side == 5)));
		}
	}

	public boolean canProvidePower() {
		return true;
	}
}
