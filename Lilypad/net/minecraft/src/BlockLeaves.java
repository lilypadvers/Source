package net.minecraft.src;

import java.util.Random;

public class BlockLeaves extends BlockLeavesBase {
	private int leafTexIndex;
	private int decayCounter = 0;

	protected BlockLeaves(int id, int tex) {
		super(id, tex, Material.leaves, false);
		this.leafTexIndex = tex;
		this.setTickOnLoad(true);
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		this.decayCounter = 0;
		this.updateCurrentLeaves(worldObj, x, y, z);
		super.onNeighborBlockChange(worldObj, x, y, z, id);
	}

	public void updateConnectedLeaves(World worldObj, int x, int y, int z, int metadata) {
		if(worldObj.a(x, y, z) == this.blockID) {
			int var6 = worldObj.e(x, y, z);
			if(var6 != 0 && var6 == metadata - 1) {
				this.updateCurrentLeaves(worldObj, x, y, z);
			}
		}
	}

	public void updateCurrentLeaves(World worldObj, int x, int y, int z) {
		if(this.decayCounter++ < 100) {
			int var5 = worldObj.f(x, y - 1, z).isSolid()?16:0;
			int var6 = worldObj.e(x, y, z);
			if(var6 == 0) {
				var6 = 1;
				worldObj.setBlockMetadataWithNotify(x, y, z, 1);
			}

			var5 = this.getConnectionStrength(worldObj, x, y - 1, z, var5);
			var5 = this.getConnectionStrength(worldObj, x, y, z - 1, var5);
			var5 = this.getConnectionStrength(worldObj, x, y, z + 1, var5);
			var5 = this.getConnectionStrength(worldObj, x - 1, y, z, var5);
			var5 = this.getConnectionStrength(worldObj, x + 1, y, z, var5);
			int var7 = var5 - 1;
			if(var7 < 10) {
				var7 = 1;
			}

			if(var7 != var6) {
				worldObj.setBlockMetadataWithNotify(x, y, z, var7);
				this.updateConnectedLeaves(worldObj, x, y - 1, z, var6);
				this.updateConnectedLeaves(worldObj, x, y + 1, z, var6);
				this.updateConnectedLeaves(worldObj, x, y, z - 1, var6);
				this.updateConnectedLeaves(worldObj, x, y, z + 1, var6);
				this.updateConnectedLeaves(worldObj, x - 1, y, z, var6);
				this.updateConnectedLeaves(worldObj, x + 1, y, z, var6);
			}

		}
	}

	private int getConnectionStrength(World worldObj, int x, int y, int z, int metadata) {
		int var6 = worldObj.a(x, y, z);
		if(var6 == Block.wood.blockID) {
			return 16;
		} else {
			if(var6 == this.blockID) {
				int var7 = worldObj.e(x, y, z);
				if(var7 != 0 && var7 > metadata) {
					return var7;
				}
			}

			return metadata;
		}
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		int var6 = worldObj.e(x, y, z);
		if(var6 == 0) {
			this.decayCounter = 0;
			this.updateCurrentLeaves(worldObj, x, y, z);
		} else if(var6 == 1) {
			this.removeLeaves(worldObj, x, y, z);
		} else if(rand.nextInt(10) == 0) {
			this.updateCurrentLeaves(worldObj, x, y, z);
		}

	}

	private void removeLeaves(World worldObj, int x, int y, int z) {
		this.dropBlockAsItem(worldObj, x, y, z, worldObj.e(x, y, z));
		worldObj.setBlockWithNotify(x, y, z, 0);
	}

	public int quantityDropped(Random rand) {
		return rand.nextInt(20) == 0?1:0;
	}

	public int idDropped(int metadata, Random rand) {
		return Block.sapling.blockID;
	}

	public boolean isOpaqueCube() {
		return !this.graphicsLevel;
	}

	public void setGraphicsLevel(boolean graphicsLevel) {
		this.graphicsLevel = graphicsLevel;
		this.blockIndexInTexture = this.leafTexIndex + (graphicsLevel?0:1);
	}

	public void onEntityWalking(World worldObj, int x, int y, int z, Entity entity) {
		super.onEntityWalking(worldObj, x, y, z, entity);
	}
}
