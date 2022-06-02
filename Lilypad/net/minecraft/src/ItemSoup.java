package net.minecraft.src;

public class ItemSoup extends BlockStep {
	public ItemSoup(int var1, int var2) {
		super(var1, var2);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer) {
		super.onItemRightClick(itemStack, worldObj, entityPlayer);
		return new ItemStack(Item.bowlEmpty);
	}
}
