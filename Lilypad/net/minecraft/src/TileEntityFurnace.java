package net.minecraft.src;

public class TileEntityFurnace extends TileEntity implements IInventory {
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	private int furnaceBurnTime = 0;
	private int currentItemBurnTime = 0;
	private int furnaceCookTime = 0;

	public int getSizeInventory() {
		return this.furnaceItemStacks.length;
	}

	public ItemStack getStackInSlot(int slot) {
		return this.furnaceItemStacks[slot];
	}

	public ItemStack decrStackSize(int slot, int stackSize) {
		if(this.furnaceItemStacks[slot] == null) {
			return null;
		} else {
			ItemStack var3;
			if(this.furnaceItemStacks[slot].stackSize <= stackSize) {
				var3 = this.furnaceItemStacks[slot];
				this.furnaceItemStacks[slot] = null;
				return var3;
			} else {
				var3 = this.furnaceItemStacks[slot].splitStack(stackSize);
				if(this.furnaceItemStacks[slot].stackSize == 0) {
					this.furnaceItemStacks[slot] = null;
				}

				return var3;
			}
		}
	}

	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		this.furnaceItemStacks[slot] = itemStack;
		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}

	}

	public String getInvName() {
		return "Chest";
	}

	public void readFromNBT(NBTTagCompound compoundTag) {
		super.readFromNBT(compoundTag);
		NBTTagList var2 = compoundTag.getTagList("Items");
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

		for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
			NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
			byte var5 = var4.getByte("Slot");
			if(var5 >= 0 && var5 < this.furnaceItemStacks.length) {
				this.furnaceItemStacks[var5] = new ItemStack(var4);
			}
		}

		this.furnaceBurnTime = compoundTag.getShort("BurnTime");
		this.furnaceCookTime = compoundTag.getShort("CookTime");
		this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
	}

	public void writeToNBT(NBTTagCompound compoundTag) {
		super.writeToNBT(compoundTag);
		compoundTag.setShort("BurnTime", (short)this.furnaceBurnTime);
		compoundTag.setShort("CookTime", (short)this.furnaceCookTime);
		NBTTagList var2 = new NBTTagList();

		for(int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3) {
			if(this.furnaceItemStacks[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte)var3);
				this.furnaceItemStacks[var3].writeToNBT(var4);
				var2.setTag(var4);
			}
		}

		compoundTag.setTag("Items", var2);
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public int getCookProgressScaled(int scale) {
		return this.furnaceCookTime * scale / 200;
	}

	public int getBurnTimeRemainingScaled(int scale) {
		if(this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = 200;
		}

		return this.furnaceBurnTime * scale / this.currentItemBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	public void updateEntity() {
		boolean var1 = this.furnaceBurnTime > 0;
		boolean var2 = false;
		if(this.furnaceBurnTime > 0) {
			--this.furnaceBurnTime;
		}

		if(this.furnaceBurnTime == 0 && this.canSmelt()) {
			int var3 = this.getItemBurnTime(this.furnaceItemStacks[1]);
			this.furnaceBurnTime = var3;
			this.currentItemBurnTime = var3;
			if(this.furnaceBurnTime > 0) {
				var2 = true;
				if(this.furnaceItemStacks[1] != null) {
					ItemStack var4 = this.furnaceItemStacks[1];
					--var4.stackSize;
					if(this.furnaceItemStacks[1].stackSize == 0) {
						this.furnaceItemStacks[1] = null;
					}
				}
			}
		}

		if(this.isBurning() && this.canSmelt()) {
			++this.furnaceCookTime;
			if(this.furnaceCookTime == 200) {
				this.furnaceCookTime = 0;
				this.smeltItem();
				var2 = true;
			}
		} else {
			this.furnaceCookTime = 0;
		}

		if(var1 != this.furnaceBurnTime > 0) {
			var2 = true;
			BlockFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		if(var2) {
			this.onInventoryChanged();
		}

	}

	private boolean canSmelt() {
		if(this.furnaceItemStacks[0] == null) {
			return false;
		} else {
			int var1 = this.getCookedItem(this.furnaceItemStacks[0].getItem().aR);
			return var1 >= 0 && (this.furnaceItemStacks[2] == null || this.furnaceItemStacks[2].itemID == var1 && (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize() || this.furnaceItemStacks[2].stackSize < Item.itemsList[var1].getItemStackLimit()));
		}
	}

	public void smeltItem() {
		if(this.canSmelt()) {
			int var1 = this.getCookedItem(this.furnaceItemStacks[0].getItem().aR);
			ItemStack var2;
			if(this.furnaceItemStacks[2] == null) {
				this.furnaceItemStacks[2] = new ItemStack(var1, 1);
			} else if(this.furnaceItemStacks[2].itemID == var1) {
				var2 = this.furnaceItemStacks[2];
				++var2.stackSize;
			}

			var2 = this.furnaceItemStacks[0];
			--var2.stackSize;
			if(this.furnaceItemStacks[0].stackSize <= 0) {
				this.furnaceItemStacks[0] = null;
			}

		}
	}

	private int getCookedItem(int id) {
		return id == Block.oreIron.blockID?Item.ingotIron.aR:(id == Block.oreGold.blockID?Item.ingotGold.aR:(id == Block.oreDiamond.blockID?Item.diamond.aR:(id == Block.sand.blockID?Block.glass.blockID:(id == Item.porkRaw.aR?Item.porkCooked.aR:(id == Block.cobblestone.blockID?Block.stone.blockID:(id == Item.clay.aR?Item.brick.aR:(id == Block.obsidian.blockID?Item.obsidianIngot.aR:(id == Item.coal.aR?Item.blackDye.aR:(id == Item.redstone.aR?Item.greenDye.aR:(id == Block.ae.blockID?Item.blueDye.aR:(id == Block.ag.blockID?Item.pinkDye.aR:(id == Block.ah.blockID?Item.fryshroom.aR:-1))))))))))));
	}

	private int getItemBurnTime(ItemStack itemStack) {
		if(itemStack == null) {
			return 0;
		} else {
			int var2 = itemStack.getItem().aR;
			return var2 < 256 && Block.blocksList[var2].material == Material.wood?300:(var2 == Item.stick.aR?100:(var2 == Item.coal.aR?1600:(var2 == Item.bucketLava.aR?20000:0)));
		}
	}
}
