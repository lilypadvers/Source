package net.minecraft.src;

public class TextureFX extends IsoImageBuffer {
	public TextureFX(EntitySpider var1) {
		super(var1);
		this.u = "/mob/spider.png";
		this.a(1.4F, 0.9F);
		this.Y = 0.8F;
	}

	protected EntityMinecart h() {
		float var1 = this.a(1.0F);
		if(var1 < 0.5F) {
			double var2 = 16.0D;
			return this.ad.a(this, var2);
		} else {
			return null;
		}
	}

	protected String c() {
		return "mob.spider";
	}

	protected String d() {
		return "mob.spider";
	}

	protected String e() {
		return "mob.spiderdeath";
	}

	protected void a(EntityMinecart var1, float var2) {
		float var3 = this.a(1.0F);
		if(var3 > 0.5F && this.aN.nextInt(100) == 0) {
			this.f = null;
		} else {
			if(var2 > 2.0F && var2 < 6.0F && this.aN.nextInt(10) == 0) {
				if(this.as) {
					double var4 = var1.ah - this.ah;
					double var6 = var1.aj - this.aj;
					float var8 = ModelPig.a(var4 * var4 + var6 * var6);
					this.ak = var4 / (double)var8 * 0.5D * (double)0.8F + this.ak * (double)0.2F;
					this.am = var6 / (double)var8 * 0.5D * (double)0.8F + this.am * (double)0.2F;
					this.al = (double)0.4F;
				}
			} else {
				super.a(var1, var2);
			}

		}
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	protected int g() {
		return EntityTNTPrimed.I.aQ;
	}
}
