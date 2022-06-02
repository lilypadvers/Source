package net.minecraft.src;

public class ChunkProviderGenerate extends Item {
	public ChunkProviderGenerate(int var1) {
		super(var1);
		this.shiftedIndex = 1;
		this.maxStackSize = 64;
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World worldObj, int x, int y, int z, int side) {
		if(side == 0) {
			--y;
		}

		if(side == 1) {
			++y;
		}

		if(side == 2) {
			--z;
		}

		if(side == 3) {
			++z;
		}

		if(side == 4) {
			--x;
		}

		if(side == 5) {
			++x;
		}

		int var8 = worldObj.a(x, y, z);
		if(var8 == 0) {
			worldObj.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
			worldObj.setBlockWithNotify(x, y, z, Block.as.blockID);
		}

		itemStack.damageItem(1);
		return true;
	}
}
