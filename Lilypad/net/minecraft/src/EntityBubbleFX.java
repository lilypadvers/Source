package net.minecraft.src;

public class EntityBubbleFX extends RedstoneUpdateInfo {
	public EntityBubbleFX(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.i = 1.0F;
		this.j = 1.0F;
		this.k = 1.0F;
		this.y = 32;
		this.setSize(0.02F, 0.02F);
		this.g *= this.rand.nextFloat() * 0.6F + 0.2F;
		this.motionX = var8 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.motionY = var10 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.motionZ = var12 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY += 0.002D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= (double)0.85F;
		this.motionY *= (double)0.85F;
		this.motionZ *= (double)0.85F;
		if(this.worldObj.f(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) != Material.water) {
			this.kill();
		}

		if(this.f-- <= 0) {
			this.kill();
		}

	}
}
