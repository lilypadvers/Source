package net.minecraft.src;

public class NibbleArray extends EntityAnimal {
	public boolean a = false;

	public NibbleArray(World var1) {
		super(var1);
		this.texture = "/mob/pig.png";
		this.setSize(0.9F, 0.9F);
		this.a = false;
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
		super.writeEntityToNBT(compoundTag);
		compoundTag.setBoolean("Saddle", this.a);
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
		super.readEntityFromNBT(compoundTag);
		this.a = compoundTag.getBoolean("Saddle");
	}

	protected String getLivingSound() {
		return "mob.pig";
	}

	protected String getHurtSound() {
		return "mob.pig";
	}

	protected String getDeathSound() {
		return "mob.pigdeath";
	}

	public boolean interact(EntityPlayer entityPlayer) {
		if(this.a) {
			entityPlayer.mountEntity(this);
			return true;
		} else {
			return false;
		}
	}

	protected int getDropItemId() {
		return Item.porkRaw.aR;
	}
}
