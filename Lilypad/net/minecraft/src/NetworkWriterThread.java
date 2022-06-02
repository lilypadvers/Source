package net.minecraft.src;

public class NetworkWriterThread extends RedstoneUpdateInfo {
	float a;

	public NetworkWriterThread(World var1, double var2, double var4, double var6) {
		this(var1, var2, var4, var6, 1.0F);
	}

	public NetworkWriterThread(World var1, double var2, double var4, double var6, float var8) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.1F;
		this.motionY *= (double)0.1F;
		this.motionZ *= (double)0.1F;
		this.i = this.j = this.k = (float)(Math.random() * (double)0.3F);
		this.g *= 0.75F;
		this.g *= var8;
		this.a = this.g;
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
		this.f = (int)((float)this.f * var8);
		this.noClip = false;
	}

	public void a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.e + var2) / (float)this.f * 32.0F;
		if(var8 < 0.0F) {
			var8 = 0.0F;
		}

		if(var8 > 1.0F) {
			var8 = 1.0F;
		}

		this.g = this.a * var8;
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if(this.e++ >= this.f) {
			this.kill();
		}

		this.y = 7 - this.e * 8 / this.f;
		this.motionY += 0.004D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		if(this.posY == this.prevPosY) {
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}

		this.motionX *= (double)0.96F;
		this.motionY *= (double)0.96F;
		this.motionZ *= (double)0.96F;
		if(this.onGround) {
			this.motionX *= (double)0.7F;
			this.motionZ *= (double)0.7F;
		}

	}
}
