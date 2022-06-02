package net.minecraft.src;

public class EntityBubbleFX extends nd {
	private float a;

	public EntityBubbleFX(EntitySpider var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.ak *= (double)0.8F;
		this.al *= (double)0.8F;
		this.am *= (double)0.8F;
		this.al = (double)(this.aN.nextFloat() * 0.4F + 0.05F);
		this.i = this.j = this.k = 1.0F;
		this.g *= this.aN.nextFloat() * 2.0F + 0.2F;
		this.a = this.g;
		this.f = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
		this.aK = false;
		this.b = 49;
	}

	public float a(float var1) {
		return 1.0F;
	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.e + var2) / (float)this.f;
		this.g = this.a * (1.0F - var8 * var8);
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		if(this.e++ >= this.f) {
			this.D();
		}

		float var1 = (float)this.e / (float)this.f;
		if(this.aN.nextFloat() > var1) {
			this.ad.a("smoke", this.ah, this.ai, this.aj, this.ak, this.al, this.am);
		}

		this.al -= 0.03D;
		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.999F;
		this.al *= (double)0.999F;
		this.am *= (double)0.999F;
		if(this.as) {
			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
		}

	}
}
