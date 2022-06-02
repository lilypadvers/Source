package net.minecraft.src;

import java.util.Random;

public class BlockCrops extends MouseHelper {
	protected BlockCrops(int var1, int var2) {
		super(var1, var2);
		this.blockIndexInTexture = var2;
		this.setTickOnLoad(true);
		float var3 = 0.5F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
	}

	protected boolean b(int var1) {
		return var1 == Block.tilledField.blockID;
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		super.updateTick(worldObj, x, y, z, rand);
		if(worldObj.getBlockLightValue(x, y + 1, z) >= 9) {
			int var6 = worldObj.e(x, y, z);
			if(var6 < 7) {
				float var7 = this.getGrowthRate(worldObj, x, y, z);
				if(rand.nextInt((int)(100.0F / var7)) == 0) {
					++var6;
					worldObj.setBlockMetadataWithNotify(x, y, z, var6);
				}
			}
		}

	}

	private float getGrowthRate(World worldObj, int x, int y, int z) {
		float var5 = 1.0F;
		int var6 = worldObj.a(x, y, z - 1);
		int var7 = worldObj.a(x, y, z + 1);
		int var8 = worldObj.a(x - 1, y, z);
		int var9 = worldObj.a(x + 1, y, z);
		int var10 = worldObj.a(x - 1, y, z - 1);
		int var11 = worldObj.a(x + 1, y, z - 1);
		int var12 = worldObj.a(x + 1, y, z + 1);
		int var13 = worldObj.a(x - 1, y, z + 1);
		boolean var14 = var8 == this.blockID || var9 == this.blockID;
		boolean var15 = var6 == this.blockID || var7 == this.blockID;
		boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;

		for(int var17 = x - 1; var17 <= x + 1; ++var17) {
			for(int var18 = z - 1; var18 <= z + 1; ++var18) {
				int var19 = worldObj.a(var17, y - 1, var18);
				float var20 = 0.0F;
				if(var19 == Block.tilledField.blockID) {
					var20 = 1.0F;
					if(worldObj.e(var17, y - 1, var18) > 0) {
						var20 = 3.0F;
					}
				}

				if(var17 != x || var18 != z) {
					var20 /= 4.0F;
				}

				var5 += var20;
			}
		}

		if(var16 || var14 && var15) {
			var5 /= 2.0F;
		}

		return var5;
	}

	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		if(metadata < 0) {
			metadata = 7;
		}

		return this.blockIndexInTexture + metadata;
	}

	public int getRenderType() {
		return 6;
	}

	public void onBlockDestroyedByPlayer(World worldObj, int x, int y, int z, int metadata) {
		super.onBlockDestroyedByPlayer(worldObj, x, y, z, metadata);

		for(int var6 = 0; var6 < 3; ++var6) {
			if(worldObj.rand.nextInt(15) <= metadata) {
				float var7 = 0.7F;
				float var8 = worldObj.rand.nextFloat() * var7 + (1.0F - var7) * 0.5F;
				float var9 = worldObj.rand.nextFloat() * var7 + (1.0F - var7) * 0.5F;
				float var10 = worldObj.rand.nextFloat() * var7 + (1.0F - var7) * 0.5F;
				EntityItem var11 = new EntityItem(worldObj, (double)((float)x + var8), (double)((float)y + var9), (double)((float)z + var10), new ItemStack(Item.seeds));
				var11.delayBeforeCanPickup = 10;
				worldObj.spawnEntityInWorld(var11);
			}
		}

	}

	public int idDropped(int metadata, Random rand) {
		System.out.println("Get resource: " + metadata);
		return metadata == 7?Item.wheat.aR:-1;
	}

	public int quantityDropped(Random rand) {
		return 1;
	}
}
