package net.minecraft.src;

public class BlockStep extends Item {
	private int a;

	public BlockStep(int var1, int var2) {
		super(var1);
		this.a = var2;
		this.shiftedIndex = 1;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer) {
		--itemStack.stackSize;
		entityPlayer.heal(this.a);
		return itemStack;
	}
}
