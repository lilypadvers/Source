package net.minecraft.src;

public class ItemSaddle extends Item {
	public ItemSaddle(int var1) {
		super(var1);
		this.shiftedIndex = 1;
		this.maxStackSize = 64;
	}

	public void saddleEntity(ItemStack itemStack, EntityLiving entityLiving) {
		if(entityLiving instanceof NibbleArray) {
			NibbleArray var3 = (NibbleArray)entityLiving;
			if(!var3.a) {
				var3.a = true;
				--itemStack.stackSize;
			}
		}

	}

	public void hitEntity(ItemStack itemStack, EntityLiving entityLiving) {
		this.saddleEntity(itemStack, entityLiving);
	}
}
