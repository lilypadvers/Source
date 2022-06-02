package net.minecraft.src;

public abstract class EntityAnimal extends EntityCreature {
	public EntityAnimal(World var1) {
		super(var1);
	}

	protected float getBlockPathWeight(int x, int y, int z) {
		return this.worldObj.a(x, y - 1, z) == Block.v.blockID?10.0F:this.worldObj.c(x, y, z) - 0.5F;
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
		super.writeEntityToNBT(compoundTag);
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
		super.readEntityFromNBT(compoundTag);
	}

	public boolean getCanSpawnHere() {
		int var1 = MathHelper.floor_double(this.posX);
		int var2 = MathHelper.floor_double(this.boundingBox.minY);
		int var3 = MathHelper.floor_double(this.posZ);
		return this.worldObj.a(var1, var2 - 1, var3) == Block.v.blockID && this.worldObj.getBlockLightValue(var1, var2, var3) > 8 && super.getCanSpawnHere();
	}

	public int getTalkInterval() {
		return 120;
	}
}
