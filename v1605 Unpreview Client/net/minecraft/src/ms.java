package net.minecraft.src;

public class ms extends nd {
	public ms(EntitySpider var1, double var2, double var4, double var6) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.ak *= (double)0.3F;
		this.al = (double)((float)Math.random() * 0.2F + 0.1F);
		this.am *= (double)0.3F;
		this.i = 1.0F;
		this.j = 1.0F;
		this.k = 1.0F;
		this.b = 19 + this.aN.nextInt(4);
		this.a(0.01F, 0.01F);
		this.h = 0.06F;
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		this.al -= (double)this.h;
		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.98F;
		this.al *= (double)0.98F;
		this.am *= (double)0.98F;
		if(this.f-- <= 0) {
			this.D();
		}

		if(this.as) {
			if(Math.random() < 0.5D) {
				this.D();
			}

			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
		}

		EntitySkeleton var1 = this.ad.f(ModelPig.b(this.ah), ModelPig.b(this.ai), ModelPig.b(this.aj));
		if(var1.d() || var1.a()) {
			double var2 = (double)((float)(ModelPig.b(this.ai) + 1) - EntityFX.b(this.ad.e(ModelPig.b(this.ah), ModelPig.b(this.ai), ModelPig.b(this.aj))));
			if(this.ai < var2) {
				this.D();
			}
		}

	}
}
