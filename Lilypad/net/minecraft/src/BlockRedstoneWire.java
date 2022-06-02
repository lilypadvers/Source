package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneWire extends Block {
	private boolean wiresProvidePower = true;

	public BlockRedstoneWire(int id, int tex) {
		super(id, tex, Material.circuits);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
	}

	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return this.blockIndexInTexture + (metadata > 0?16:0);
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
		return 5;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.g(x, y - 1, z);
	}

	private void updateAndPropagateCurrentStrength(World worldObj, int x, int y, int z) {
		int var5 = worldObj.e(x, y, z);
		int var6 = 0;
		this.wiresProvidePower = false;
		boolean var7 = worldObj.isBlockIndirectlyGettingPowered(x, y, z);
		this.wiresProvidePower = true;
		int var8;
		int var9;
		int var10;
		if(var7) {
			var6 = 15;
		} else {
			for(var8 = 0; var8 < 4; ++var8) {
				var9 = x;
				var10 = z;
				if(var8 == 0) {
					var9 = x - 1;
				}

				if(var8 == 1) {
					++var9;
				}

				if(var8 == 2) {
					var10 = z - 1;
				}

				if(var8 == 3) {
					++var10;
				}

				var6 = this.getMaxCurrentStrength(worldObj, var9, y, var10, var6);
				if(worldObj.g(var9, y, var10) && !worldObj.g(x, y + 1, z)) {
					var6 = this.getMaxCurrentStrength(worldObj, var9, y + 1, var10, var6);
				} else if(!worldObj.g(var9, y, var10)) {
					var6 = this.getMaxCurrentStrength(worldObj, var9, y - 1, var10, var6);
				}
			}

			if(var6 > 0) {
				--var6;
			} else {
				var6 = 0;
			}
		}

		if(var5 != var6) {
			worldObj.setBlockMetadataWithNotify(x, y, z, var6);
			worldObj.markBlocksDirty(x, y, z, x, y, z);
			if(var6 > 0) {
				--var6;
			}

			for(var8 = 0; var8 < 4; ++var8) {
				var9 = x;
				var10 = z;
				int var11 = y - 1;
				if(var8 == 0) {
					var9 = x - 1;
				}

				if(var8 == 1) {
					++var9;
				}

				if(var8 == 2) {
					var10 = z - 1;
				}

				if(var8 == 3) {
					++var10;
				}

				if(worldObj.g(var9, y, var10)) {
					var11 += 2;
				}

				int var12 = this.getMaxCurrentStrength(worldObj, var9, y, var10, -1);
				if(var12 >= 0 && var12 != var6) {
					this.updateAndPropagateCurrentStrength(worldObj, var9, y, var10);
				}

				var12 = this.getMaxCurrentStrength(worldObj, var9, var11, var10, -1);
				if(var12 >= 0 && var12 != var6) {
					this.updateAndPropagateCurrentStrength(worldObj, var9, var11, var10);
				}
			}

			if(var5 == 0 || var6 == 0) {
				worldObj.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
				worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
			}
		}

	}

	private void notifyWireNeighborsOfNeighborChange(World worldObj, int x, int y, int z) {
		if(worldObj.a(x, y, z) == this.blockID) {
			worldObj.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x - 1, y, z, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x + 1, y, z, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x, y, z - 1, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x, y, z + 1, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
			worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
		}
	}

	public void onBlockAdded(World worldObj, int x, int y, int z) {
		super.onBlockAdded(worldObj, x, y, z);
		this.updateAndPropagateCurrentStrength(worldObj, x, y, z);
		worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
		worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y, z);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y, z);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x, y, z - 1);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x, y, z + 1);
		if(worldObj.g(x - 1, y, z)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y + 1, z);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y - 1, z);
		}

		if(worldObj.g(x + 1, y, z)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y + 1, z);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y - 1, z);
		}

		if(worldObj.g(x, y, z - 1)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y + 1, z - 1);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y - 1, z - 1);
		}

		if(worldObj.g(x, y, z + 1)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y + 1, z + 1);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y - 1, z + 1);
		}

	}

	public void onBlockRemoval(World worldObj, int x, int y, int z) {
		super.onBlockRemoval(worldObj, x, y, z);
		worldObj.notifyBlocksOfNeighborChange(x, y + 1, z, this.blockID);
		worldObj.notifyBlocksOfNeighborChange(x, y - 1, z, this.blockID);
		this.updateAndPropagateCurrentStrength(worldObj, x, y, z);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y, z);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y, z);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x, y, z - 1);
		this.notifyWireNeighborsOfNeighborChange(worldObj, x, y, z + 1);
		if(worldObj.g(x - 1, y, z)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y + 1, z);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x - 1, y - 1, z);
		}

		if(worldObj.g(x + 1, y, z)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y + 1, z);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x + 1, y - 1, z);
		}

		if(worldObj.g(x, y, z - 1)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y + 1, z - 1);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y - 1, z - 1);
		}

		if(worldObj.g(x, y, z + 1)) {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y + 1, z + 1);
		} else {
			this.notifyWireNeighborsOfNeighborChange(worldObj, x, y - 1, z + 1);
		}

	}

	private int getMaxCurrentStrength(World worldObj, int x, int y, int z, int var5) {
		if(worldObj.a(x, y, z) != this.blockID) {
			return var5;
		} else {
			int var6 = worldObj.e(x, y, z);
			return var6 > var5?var6:var5;
		}
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		int var6 = worldObj.e(x, y, z);
		boolean var7 = this.canPlaceBlockAt(worldObj, x, y, z);
		if(!var7) {
			this.dropBlockAsItem(worldObj, x, y, z, var6);
			worldObj.setBlockWithNotify(x, y, z, 0);
		} else {
			this.updateAndPropagateCurrentStrength(worldObj, x, y, z);
		}

		super.onNeighborBlockChange(worldObj, x, y, z, id);
	}

	public int idDropped(int metadata, Random rand) {
		return Item.redstone.aR;
	}

	public boolean isIndirectlyPoweringTo(World worldObj, int x, int y, int z, int side) {
		return !this.wiresProvidePower?false:this.b(worldObj, x, y, z, side);
	}

	public boolean b(EntitySmokeFX var1, int var2, int var3, int var4, int var5) {
		if(!this.wiresProvidePower) {
			return false;
		} else if(var1.e(var2, var3, var4) == 0) {
			return false;
		} else if(var5 == 1) {
			return true;
		} else {
			boolean var6 = b(var1, var2 - 1, var3, var4) || !var1.g(var2 - 1, var3, var4) && b(var1, var2 - 1, var3 - 1, var4);
			boolean var7 = b(var1, var2 + 1, var3, var4) || !var1.g(var2 + 1, var3, var4) && b(var1, var2 + 1, var3 - 1, var4);
			boolean var8 = b(var1, var2, var3, var4 - 1) || !var1.g(var2, var3, var4 - 1) && b(var1, var2, var3 - 1, var4 - 1);
			boolean var9 = b(var1, var2, var3, var4 + 1) || !var1.g(var2, var3, var4 + 1) && b(var1, var2, var3 - 1, var4 + 1);
			if(!var1.g(var2, var3 + 1, var4)) {
				if(var1.g(var2 - 1, var3, var4) && b(var1, var2 - 1, var3 + 1, var4)) {
					var6 = true;
				}

				if(var1.g(var2 + 1, var3, var4) && b(var1, var2 + 1, var3 + 1, var4)) {
					var7 = true;
				}

				if(var1.g(var2, var3, var4 - 1) && b(var1, var2, var3 + 1, var4 - 1)) {
					var8 = true;
				}

				if(var1.g(var2, var3, var4 + 1) && b(var1, var2, var3 + 1, var4 + 1)) {
					var9 = true;
				}
			}

			return !var8 && !var7 && !var6 && !var9 && var5 >= 2 && var5 <= 5?true:(var5 == 2 && var8 && !var6 && !var7?true:(var5 == 3 && var9 && !var6 && !var7?true:(var5 == 4 && var6 && !var8 && !var9?true:var5 == 5 && var7 && !var8 && !var9)));
		}
	}

	public boolean canProvidePower() {
		return this.wiresProvidePower;
	}

	public void randomDisplayTick(World worldObj, int x, int y, int z, Random rand) {
		if(worldObj.e(x, y, z) > 0) {
			double var6 = (double)x + 0.5D + ((double)rand.nextFloat() - 0.5D) * 0.2D;
			double var8 = (double)((float)y + 0.0625F);
			double var10 = (double)z + 0.5D + ((double)rand.nextFloat() - 0.5D) * 0.2D;
			worldObj.spawnParticle("reddust", var6, var8, var10, 0.0D, 0.0D, 0.0D);
		}

	}

	public static boolean b(EntitySmokeFX var0, int var1, int var2, int var3) {
		int var4 = var0.a(var1, var2, var3);
		return var4 == Block.redstoneWire.blockID?true:(var4 == 0?false:Block.blocksList[var4].canProvidePower());
	}
}
