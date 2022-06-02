package net.minecraft.src;

public class EntityLavaFX extends RedstoneUpdateInfo {
	private float lavaParticleScale;

	public EntityLavaFX(World worldObj, double x, double y, double z) {
		super(worldObj, x, y, z, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.8F;
		this.motionY *= (double)0.8F;
		this.motionZ *= (double)0.8F;
		this.motionY = (double)(this.rand.nextFloat() * 0.4F + 0.05F);
		this.i = this.j = this.k = 1.0F;
		this.g *= this.rand.nextFloat() * 2.0F + 0.2F;
		this.lavaParticleScale = this.g;
		this.f = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
		this.noClip = false;
		this.y = 49;
	}

	public float getBrightness(float renderPartialTick) {
		return 1.0F;
	}

	public void a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.e + var2) / (float)this.f;
		this.g = this.lavaParticleScale * (1.0F - var8 * var8);
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if(this.e++ >= this.f) {
			this.kill();
		}

		float var1 = (float)this.e / (float)this.f;
		if(this.rand.nextFloat() > var1) {
			this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
		}

		this.motionY -= 0.03D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= (double)0.999F;
		this.motionY *= (double)0.999F;
		this.motionZ *= (double)0.999F;
		if(this.onGround) {
			this.motionX *= (double)0.7F;
			this.motionZ *= (double)0.7F;
		}

	}
}
