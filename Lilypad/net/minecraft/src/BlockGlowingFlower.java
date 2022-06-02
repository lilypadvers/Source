package net.minecraft.src;

import java.util.Random;

public class BlockGlowingFlower extends BlockGlowing {
	int renderMode = 1;

	protected BlockGlowingFlower(int var1, int var2, int var3) {
		super(var1, var2, var3);
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

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return true;
	}

	public boolean blockActivated(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		ItemStack var6 = entityPlayer.inventory.getCurrentItem();
		if(var6 == null) {
			return false;
		} else {
			if(var6.itemID == 116) {
				worldObj.setBlockWithNotify(x, y, z, 117);
				entityPlayer.inventory.consumeInventoryItem(116);
				worldObj.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "ext.infuse", 1.0F, 1.0F);
			} else if(var6.itemID == 266) {
				worldObj.setBlockWithNotify(x, y, z, 118);
				entityPlayer.inventory.consumeInventoryItem(266);
				worldObj.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "ext.infuse", 1.0F, 0.7F);
			} else if(var6.itemID == 355) {
				worldObj.setBlockWithNotify(x, y, z, 119);
				entityPlayer.inventory.consumeInventoryItem(355);
				worldObj.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "ext.infuse", 1.0F, 0.3F);
			}

			return true;
		}
	}

	public void randomDisplayTick(World worldObj, int x, int y, int z, Random rand) {
	}
}
