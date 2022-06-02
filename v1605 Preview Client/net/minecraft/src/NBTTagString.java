package net.minecraft.src;

public class NBTTagString extends nd {
	private float a;

	public NBTTagString(EntitySpider var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.ak = this.ak * (double)0.01F + var8;
		this.al = this.al * (double)0.01F + var10;
		this.am = this.am * (double)0.01F + var12;
		double var10000 = var2 + (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.05F);
		var10000 = var4 + (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.05F);
		var10000 = var6 + (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.05F);
		this.a = this.g;
		this.i = this.j = this.k = 1.0F;
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
		this.aK = true;
		this.b = 48;
	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.e + var2) / (float)this.f;
		this.g = this.a * (1.0F - var8 * var8 * 0.5F);
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public float a(float var1) {
		float var2 = ((float)this.e + var1) / (float)this.f;
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		float var3 = super.a(var1);
		return var3 * var2 + (1.0F - var2);
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		if(this.e++ >= this.f) {
			this.D();
		}

		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.96F;
		this.al *= (double)0.96F;
		this.am *= (double)0.96F;
		if(this.as) {
			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
		}

	}
}
