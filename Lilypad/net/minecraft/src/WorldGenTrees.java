package net.minecraft.src;

public class WorldGenTrees extends TileEntity {
	public String[] a = new String[]{"", "", "", ""};
	public int b = -1;

	public void writeToNBT(NBTTagCompound compoundTag) {
		super.writeToNBT(compoundTag);
		compoundTag.setString("Text1", this.a[0]);
		compoundTag.setString("Text2", this.a[1]);
		compoundTag.setString("Text3", this.a[2]);
		compoundTag.setString("Text4", this.a[3]);
	}

	public void readFromNBT(NBTTagCompound compoundTag) {
		super.readFromNBT(compoundTag);

		for(int var2 = 0; var2 < 4; ++var2) {
			this.a[var2] = compoundTag.getString("Text" + (var2 + 1));
			if(this.a[var2].length() > 15) {
				this.a[var2] = this.a[var2].substring(0, 15);
			}
		}

	}
}
