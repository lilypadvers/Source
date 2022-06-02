package net.minecraft.src;

public class RedstoneUpdateInfo extends Entity {
	protected int y;
	protected float c;
	protected float d;
	protected int e = 0;
	protected int f = 0;
	protected float g;
	protected float h;
	protected float i;
	protected float j;
	protected float k;
	public static double l;
	public static double m;
	public static double n;

	public RedstoneUpdateInfo(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1);
		this.setSize(0.2F, 0.2F);
		this.yOffset = this.height / 2.0F;
		this.setPosition(var2, var4, var6);
		this.i = this.j = this.k = 1.0F;
		this.motionX = var8 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		this.motionY = var10 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		this.motionZ = var12 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
		float var15 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
		this.motionX = this.motionX / (double)var15 * (double)var14 * (double)0.4F;
		this.motionY = this.motionY / (double)var15 * (double)var14 * (double)0.4F + (double)0.1F;
		this.motionZ = this.motionZ / (double)var15 * (double)var14 * (double)0.4F;
		this.c = this.rand.nextFloat() * 3.0F;
		this.d = this.rand.nextFloat() * 3.0F;
		this.g = (this.rand.nextFloat() * 0.5F + 0.5F) * 2.0F;
		this.f = (int)(4.0F / (this.rand.nextFloat() * 0.9F + 0.1F));
		this.e = 0;
		this.canTriggerWalking = false;
	}

	public RedstoneUpdateInfo b(float var1) {
		this.motionX *= (double)var1;
		this.motionY = (this.motionY - (double)0.1F) * (double)var1 + (double)0.1F;
		this.motionZ *= (double)var1;
		return this;
	}

	public RedstoneUpdateInfo d(float var1) {
		this.setSize(0.2F * var1, 0.2F * var1);
		this.g *= var1;
		return this;
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if(this.e++ >= this.f) {
			this.kill();
		}

		this.motionY -= 0.04D * (double)this.h;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= (double)0.98F;
		this.motionY *= (double)0.98F;
		this.motionZ *= (double)0.98F;
		if(this.onGround) {
			this.motionX *= (double)0.7F;
			this.motionZ *= (double)0.7F;
		}

	}

	public void a(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = (float)(this.y % 16) / 16.0F;
		float var9 = var8 + 0.0624375F;
		float var10 = (float)(this.y / 16) / 16.0F;
		float var11 = var10 + 0.0624375F;
		float var12 = 0.1F * this.g;
		float var13 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)var2 - l);
		float var14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)var2 - m);
		float var15 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)var2 - n);
		float var16 = this.getBrightness(var2);
		var1.setColorOpaque_F(this.i * var16, this.j * var16, this.k * var16);
		var1.addVertexWithUV((double)(var13 - var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 - var5 * var12 - var7 * var12), (double)var8, (double)var11);
		var1.addVertexWithUV((double)(var13 - var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 - var5 * var12 + var7 * var12), (double)var8, (double)var10);
		var1.addVertexWithUV((double)(var13 + var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 + var5 * var12 + var7 * var12), (double)var9, (double)var10);
		var1.addVertexWithUV((double)(var13 + var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 + var5 * var12 - var7 * var12), (double)var9, (double)var11);
	}

	public int c() {
		return 0;
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
	}
}
