package net.minecraft.src;

public class ItemBow extends Item {
	public ItemBow(int var1) {
		super(var1);
		this.shiftedIndex = 1;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World worldObj, EntityPlayer entityPlayer) {
		if(entityPlayer.inventory.consumeInventoryItem(Item.arrow.aR)) {
			worldObj.playSoundAtEntity(entityPlayer, "random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
			worldObj.spawnEntityInWorld(new EntityArrow(worldObj, entityPlayer));
		}

		return itemStack;
	}
}
