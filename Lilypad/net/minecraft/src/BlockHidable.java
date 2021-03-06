package net.minecraft.src;

public class BlockHidable extends BlockGlass {
	public boolean render = true;
	public int id;
	public int tRes;

	public BlockHidable(int var1, int var2, Material var3, boolean var4) {
		super(var1, var2, var3, var4);
		this.id = var1;
		this.tRes = var2;
	}

	public int a(EntitySmokeFX var1, int var2, int var3, int var4, int var5) {
		return this.render?this.tRes:160;
	}

	public boolean blockActivated(World worldObj, int x, int y, int z, EntityPlayer entityPlayer) {
		ItemStack var6 = entityPlayer.inventory.getCurrentItem();
		if(var6 == null) {
			this.render = !this.render;
			worldObj.setBlockWithNotify(x, y, z, this.id);
			return true;
		} else {
			return false;
		}
	}
}
