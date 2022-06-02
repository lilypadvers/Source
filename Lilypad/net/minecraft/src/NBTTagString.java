package net.minecraft.src;

public class NBTTagString extends RedstoneUpdateInfo {
	public NBTTagString(World var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.motionX *= (double)0.3F;
		this.motionY = (double)((float)Math.random() * 0.2F + 0.1F);
		this.motionZ *= (double)0.3F;
		this.i = 1.0F;
		this.j = 1.0F;
		this.k = 1.0F;
		this.y = 19 + this.rand.nextInt(4);
		this.setSize(0.01F, 0.01F);
		this.h = 0.06F;
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
	}

	public void a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= (double)this.h;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= (double)0.98F;
		this.motionY *= (double)0.98F;
		this.motionZ *= (double)0.98F;
		if(this.f-- <= 0) {
			this.kill();
		}

		if(this.onGround) {
			if(Math.random() < 0.5D) {
				this.kill();
			}

			this.motionX *= (double)0.7F;
			this.motionZ *= (double)0.7F;
		}

		Material var1 = this.worldObj.f(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
		if(var1.getIsLiquid() || var1.isSolid()) {
			double var2 = (double)((float)(MathHelper.floor_double(this.posY) + 1) - BlockFluid.getFluidHeightPercent(this.worldObj.e(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))));
			if(this.posY < var2) {
				this.kill();
			}
		}

	}
}
