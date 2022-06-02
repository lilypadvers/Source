package net.minecraft.src;

public class EntityPig implements IInventory {
	private ItemStack[] a = new ItemStack[1];

	public int getSizeInventory() {
		return 1;
	}

	public ItemStack getStackInSlot(int slot) {
		return this.a[slot];
	}

	public String getInvName() {
		return "Result";
	}

	public ItemStack decrStackSize(int slot, int stackSize) {
		if(this.a[slot] != null) {
			ItemStack var3 = this.a[slot];
			this.a[slot] = null;
			return var3;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		this.a[slot] = itemStack;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void onInventoryChanged() {
	}
}
