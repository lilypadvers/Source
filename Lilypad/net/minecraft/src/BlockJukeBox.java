package net.minecraft.src;

public class BlockJukeBox extends Block {
	protected BlockJukeBox(int blockID, int tex) {
		super(blockID, tex, Material.wood);
	}

	public int getBlockTextureFromSide(int side) {
		return this.blockIndexInTexture + (side == 1?1:0);
	}

	public boolean blockActivated(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		int var6 = worldObj.e(x, y, z);
		if(var6 > 0) {
			this.ejectRecord(worldObj, x, y, z, var6);
			return true;
		} else {
			return false;
		}
	}

	public void ejectRecord(World worldObj, int x, int y, int z, int var5) {
		worldObj.playRecord((String)null, x, y, z);
		worldObj.setBlockMetadataWithNotify(x, y, z, 0);
		int var6 = Item.fishingRod.aR + var5 - 1;
		float var7 = 0.7F;
		double var8 = (double)(worldObj.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		double var10 = (double)(worldObj.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
		double var12 = (double)(worldObj.rand.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		EntityItem var14 = new EntityItem(worldObj, (double)x + var8, (double)y + var10, (double)z + var12, new ItemStack(var6));
		var14.delayBeforeCanPickup = 10;
		worldObj.spawnEntityInWorld(var14);
	}

	public void dropBlockAsItemWithChance(World worldObj, int x, int y, int z, int metadata, float chance) {
		if(!worldObj.multiplayerWorld) {
			if(metadata > 0) {
				this.ejectRecord(worldObj, x, y, z, metadata);
			}

			super.dropBlockAsItemWithChance(worldObj, x, y, z, metadata, chance);
		}
	}
}
