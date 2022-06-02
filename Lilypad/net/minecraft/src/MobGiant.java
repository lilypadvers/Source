package net.minecraft.src;

public class MobGiant extends EntityMob {
	public int maxHP = -1;

	public MobGiant(World var1, int var2) {
		super(var1);
		if(var2 <= 0) {
			var2 = 1;
		}

		this.texture = "/mob/collosal_a.png";
		this.moveSpeed = 0.5F;
		this.attackStrength = 50;
		this.health *= Math.min(4 * var2, 800);
		this.maxHP = this.health;
		this.yOffset *= 6.0F;
		this.setSize(this.width * 6.0F, this.height * 6.0F);
	}

	protected float getBlockPathWeight(int x, int y, int z) {
		return this.worldObj.c(x, y, z) - 0.5F;
	}

	protected void fall(float distance) {
	}

	protected String getLivingSound() {
		return "ext.giantambient";
	}

	protected String getHurtSound() {
		return "ext.gianthurt";
	}

	protected String getDeathSound() {
		return "ext.giantdead";
	}

	public void onDeath(Entity entity) {
		super.onDeath(entity);
		if(this.rand.nextInt(50) > 10) {
			this.dropItem(Item.flameberge.aR, 1);
		}

	}
}
