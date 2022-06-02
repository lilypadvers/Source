package net.minecraft.src;

import java.util.Random;

public class BlockRedstoneOre extends Block {
	private boolean glowing;

	public BlockRedstoneOre(int id, int tex, boolean glowing) {
		super(id, tex, Material.rock);
		if(glowing) {
			this.setTickOnLoad(true);
		}

		this.glowing = glowing;
	}

	public int tickRate() {
		return 30;
	}

	public void onBlockClicked(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		this.glow(worldObj, x, y, z);
		super.onBlockClicked(worldObj, x, y, z, entityPlayer);
	}

	public void onEntityWalking(World worldObj, int x, int y, int z, Entity entity) {
		this.glow(worldObj, x, y, z);
		super.onEntityWalking(worldObj, x, y, z, entity);
	}

	public boolean blockActivated(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		this.glow(worldObj, x, y, z);
		return super.blockActivated(worldObj, x, y, z, entityPlayer);
	}

	private void glow(World worldObj, int x, int y, int z) {
		this.sparkle(worldObj, x, y, z);
		if(this.blockID == Block.oreRedstone.blockID) {
			worldObj.setBlockWithNotify(x, y, z, Block.oreRedstoneGlowing.blockID);
		}

	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		if(this.blockID == Block.oreRedstoneGlowing.blockID) {
			worldObj.setBlockWithNotify(x, y, z, Block.oreRedstone.blockID);
		}

	}

	public int idDropped(int metadata, Random rand) {
		return Item.redstone.aR;
	}

	public int quantityDropped(Random rand) {
		return 4 + rand.nextInt(2);
	}

	public void randomDisplayTick(World worldObj, int x, int y, int z, Random rand) {
		if(this.glowing) {
			this.sparkle(worldObj, x, y, z);
		}

	}

	private void sparkle(World worldObj, int x, int y, int z) {
		Random var5 = worldObj.rand;
		double var6 = 0.0625D;

		for(int var8 = 0; var8 < 6; ++var8) {
			double var9 = (double)((float)x + var5.nextFloat());
			double var11 = (double)((float)y + var5.nextFloat());
			double var13 = (double)((float)z + var5.nextFloat());
			if(var8 == 0 && !worldObj.g(x, y + 1, z)) {
				var11 = (double)(y + 1) + var6;
			}

			if(var8 == 1 && !worldObj.g(x, y - 1, z)) {
				var11 = (double)(y + 0) - var6;
			}

			if(var8 == 2 && !worldObj.g(x, y, z + 1)) {
				var13 = (double)(z + 1) + var6;
			}

			if(var8 == 3 && !worldObj.g(x, y, z - 1)) {
				var13 = (double)(z + 0) - var6;
			}

			if(var8 == 4 && !worldObj.g(x + 1, y, z)) {
				var9 = (double)(x + 1) + var6;
			}

			if(var8 == 5 && !worldObj.g(x - 1, y, z)) {
				var9 = (double)(x + 0) - var6;
			}

			if(var9 < (double)x || var9 > (double)(x + 1) || var11 < 0.0D || var11 > (double)(y + 1) || var13 < (double)z || var13 > (double)(z + 1)) {
				worldObj.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
			}
		}

	}
}
