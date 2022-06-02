package net.minecraft.src;

public class nd extends EntityMinecart {
	protected int b;
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

	public nd(EntitySpider var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1);
		this.a(0.2F, 0.2F);
		this.ay = this.aA / 2.0F;
		this.a(var2, var4, var6);
		this.i = this.j = this.k = 1.0F;
		this.ak = var8 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		this.al = var10 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		this.am = var12 + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
		float var14 = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
		float var15 = ModelPig.a(this.ak * this.ak + this.al * this.al + this.am * this.am);
		this.ak = this.ak / (double)var15 * (double)var14 * (double)0.4F;
		this.al = this.al / (double)var15 * (double)var14 * (double)0.4F + (double)0.1F;
		this.am = this.am / (double)var15 * (double)var14 * (double)0.4F;
		this.c = this.aN.nextFloat() * 3.0F;
		this.d = this.aN.nextFloat() * 3.0F;
		this.g = (this.aN.nextFloat() * 0.5F + 0.5F) * 2.0F;
		this.f = (int)(4.0F / (this.aN.nextFloat() * 0.9F + 0.1F));
		this.e = 0;
		this.aD = false;
	}

	public nd b(float var1) {
		this.ak *= (double)var1;
		this.al = (this.al - (double)0.1F) * (double)var1 + (double)0.1F;
		this.am *= (double)var1;
		return this;
	}

	public nd d(float var1) {
		this.a(0.2F * var1, 0.2F * var1);
		this.g *= var1;
		return this;
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		if(this.e++ >= this.f) {
			this.D();
		}

		this.al -= 0.04D * (double)this.h;
		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.98F;
		this.al *= (double)0.98F;
		this.am *= (double)0.98F;
		if(this.as) {
			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
		}

	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = (float)(this.b % 16) / 16.0F;
		float var9 = var8 + 0.0624375F;
		float var10 = (float)(this.b / 16) / 16.0F;
		float var11 = var10 + 0.0624375F;
		float var12 = 0.1F * this.g;
		float var13 = (float)(this.ae + (this.ah - this.ae) * (double)var2 - l);
		float var14 = (float)(this.af + (this.ai - this.af) * (double)var2 - m);
		float var15 = (float)(this.ag + (this.aj - this.ag) * (double)var2 - n);
		float var16 = this.a(var2);
		var1.a(this.i * var16, this.j * var16, this.k * var16);
		var1.a((double)(var13 - var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 - var5 * var12 - var7 * var12), (double)var8, (double)var11);
		var1.a((double)(var13 - var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 - var5 * var12 + var7 * var12), (double)var8, (double)var10);
		var1.a((double)(var13 + var3 * var12 + var6 * var12), (double)(var14 + var4 * var12), (double)(var15 + var5 * var12 + var7 * var12), (double)var9, (double)var10);
		var1.a((double)(var13 + var3 * var12 - var6 * var12), (double)(var14 - var4 * var12), (double)(var15 + var5 * var12 - var7 * var12), (double)var9, (double)var11);
	}

	public int c() {
		return 0;
	}

	public void a(EntityItem var1) {
	}

	public void b(EntityItem var1) {
	}
}
