package net.minecraft.src;

public class BlockGrass extends EntityAnimal {
	public boolean a = false;
	public float b = 0.0F;
	public float c = 0.0F;
	public float d;
	public float e;
	public float h = 1.0F;
	public int i;

	public BlockGrass(World var1) {
		super(var1);
		this.texture = "/mob/chicken.png";
		this.setSize(0.3F, 0.4F);
		this.health = 4;
		this.i = this.rand.nextInt(6000) + 6000;
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.e = this.b;
		this.d = this.c;
		this.c = (float)((double)this.c + (double)(this.onGround?-1:4) * 0.3D);
		if(this.c < 0.0F) {
			this.c = 0.0F;
		}

		if(this.c > 1.0F) {
			this.c = 1.0F;
		}

		if(!this.onGround && this.h < 1.0F) {
			this.h = 1.0F;
		}

		this.h = (float)((double)this.h * 0.9D);
		if(!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		this.b += this.h * 2.0F;
		if(!this.worldObj.multiplayerWorld && --this.i <= 0) {
			this.worldObj.playSoundAtEntity(this, "mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.dropItem(Item.egg.aR, 1);
			this.i = this.rand.nextInt(6000) + 6000;
		}

	}

	protected void fall(float distance) {
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
		super.writeEntityToNBT(compoundTag);
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
		super.readEntityFromNBT(compoundTag);
	}

	protected String getLivingSound() {
		return "mob.chicken";
	}

	protected String getHurtSound() {
		return "mob.chickenhurt";
	}

	protected String getDeathSound() {
		return "mob.chickenhurt";
	}

	protected int getDropItemId() {
		return Item.feather.aR;
	}
}
