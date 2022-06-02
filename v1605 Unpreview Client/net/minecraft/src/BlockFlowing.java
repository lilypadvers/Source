package net.minecraft.src;

public class BlockFlowing extends nd {
	public BlockFlowing(EntitySpider var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1, var2, var4, var6, var8, var10, var12);
		this.i = 1.0F;
		this.j = 1.0F;
		this.k = 1.0F;
		this.b = 32;
		this.a(0.02F, 0.02F);
		this.g *= this.aN.nextFloat() * 0.6F + 0.2F;
		this.ak = var8 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.al = var10 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.am = var12 * (double)0.2F + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.02F);
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		this.al += 0.002D;
		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.85F;
		this.al *= (double)0.85F;
		this.am *= (double)0.85F;
		if(this.ad.f(ModelPig.b(this.ah), ModelPig.b(this.ai), ModelPig.b(this.aj)) != EntitySkeleton.f) {
			this.D();
		}

		if(this.f-- <= 0) {
			this.D();
		}

	}
}
