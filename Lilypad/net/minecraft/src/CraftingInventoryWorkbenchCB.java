package net.minecraft.src;

public class CraftingInventoryWorkbenchCB extends CraftingInventoryCB {
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new EntityPig();

	public void onCraftMatrixChanged(IInventory inventory) {
		int[] var2 = new int[9];

		for(int var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 3; ++var4) {
				int var5 = var3 + var4 * 3;
				ItemStack var6 = this.craftMatrix.getStackInSlot(var5);
				if(var6 == null) {
					var2[var5] = -1;
				} else {
					var2[var5] = var6.itemID;
				}
			}
		}

		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(var2));
	}

	public void onCraftGuiClosed(EntityPlayer entityPlayer) {
		super.onCraftGuiClosed(entityPlayer);

		for(int var2 = 0; var2 < 9; ++var2) {
			ItemStack var3 = this.craftMatrix.getStackInSlot(var2);
			if(var3 != null) {
				entityPlayer.dropPlayerItem(var3);
			}
		}

	}
}
