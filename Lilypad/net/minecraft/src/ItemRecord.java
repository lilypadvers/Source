package net.minecraft.src;

public class ItemRecord extends Item {
	private String recordName;

	protected ItemRecord(int id, String record) {
		super(id);
		this.recordName = record;
		this.shiftedIndex = 1;
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World worldObj, int x, int y, int z, int side) {
		if(worldObj.a(x, y, z) == Block.jukebox.blockID && worldObj.e(x, y, z) == 0) {
			worldObj.setBlockMetadataWithNotify(x, y, z, this.aR - Item.fishingRod.aR + 1);
			worldObj.playRecord(this.recordName, x, y, z);
			--itemStack.stackSize;
			return true;
		} else {
			return false;
		}
	}
}
