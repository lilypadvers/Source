package net.minecraft.src;

import java.util.List;

public class ThreadDownloadResources extends EntityMinecart {
	public int a;
	public int b;
	public int c;

	public ThreadDownloadResources(EntitySpider var1) {
		super(var1);
		this.a = 0;
		this.b = 0;
		this.c = 1;
		this.aa = true;
		this.a(1.5F, 0.6F);
		this.ay = this.aA / 2.0F;
		this.aD = false;
	}

	public EntityRenderer b_(EntityMinecart var1) {
		return var1.ar;
	}

	public EntityRenderer f_() {
		return this.ar;
	}

	public boolean d_() {
		return true;
	}

	public ThreadDownloadResources(EntitySpider var1, double var2, double var4, double var6) {
		this(var1);
		this.a(var2, var4 + (double)this.ay, var6);
		this.ak = 0.0D;
		this.al = 0.0D;
		this.am = 0.0D;
		this.ae = var2;
		this.af = var4;
		this.ag = var6;
	}

	public double j_() {
		return (double)this.aA * 0.0D - (double)0.3F;
	}

	public boolean a(EntityMinecart var1, int var2) {
		this.c = -this.c;
		this.b = 10;
		this.a += var2 * 10;
		if(this.a > 40) {
			int var3;
			for(var3 = 0; var3 < 3; ++var3) {
				this.a(ln.x.ba, 1, 0.0F);
			}

			for(var3 = 0; var3 < 2; ++var3) {
				this.a(EntityTNTPrimed.B.aQ, 1, 0.0F);
			}

			this.D();
		}

		return true;
	}

	public boolean c_() {
		return !this.ax;
	}

	public void e_() {
		super.e_();
		if(this.b > 0) {
			--this.b;
		}

		if(this.a > 0) {
			--this.a;
		}

		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		byte var1 = 5;
		double var2 = 0.0D;

		for(int var4 = 0; var4 < var1; ++var4) {
			double var5 = this.ar.b + (this.ar.e - this.ar.b) * (double)(var4 + 0) / (double)var1 - 0.125D;
			double var7 = this.ar.b + (this.ar.e - this.ar.b) * (double)(var4 + 1) / (double)var1 - 0.125D;
			EntityRenderer var9 = EntityRenderer.b(this.ar.a, var5, this.ar.c, this.ar.d, var7, this.ar.f);
			if(this.ad.b(var9, EntitySkeleton.f)) {
				var2 += 1.0D / (double)var1;
			}
		}

		double var23 = var2 * 2.0D - 1.0D;
		this.al += (double)0.04F * var23;
		if(this.ab != null) {
			this.ak += this.ab.ak * 0.2D;
			this.am += this.ab.am * 0.2D;
		}

		double var6 = 0.4D;
		if(this.ak < -var6) {
			this.ak = -var6;
		}

		if(this.ak > var6) {
			this.ak = var6;
		}

		if(this.am < -var6) {
			this.am = -var6;
		}

		if(this.am > var6) {
			this.am = var6;
		}

		if(this.as) {
			this.ak *= 0.5D;
			this.al *= 0.5D;
			this.am *= 0.5D;
		}

		this.c(this.ak, this.al, this.am);
		double var8 = Math.sqrt(this.ak * this.ak + this.am * this.am);
		double var10;
		double var12;
		if(var8 > 0.15D) {
			var10 = Math.cos((double)this.an * Math.PI / 180.0D);
			var12 = Math.sin((double)this.an * Math.PI / 180.0D);

			for(int var14 = 0; (double)var14 < 1.0D + var8 * 60.0D; ++var14) {
				double var15 = (double)(this.aN.nextFloat() * 2.0F - 1.0F);
				double var17 = (double)(this.aN.nextInt(2) * 2 - 1) * 0.7D;
				double var19;
				double var21;
				if(this.aN.nextBoolean()) {
					var19 = this.ah - var10 * var15 * 0.8D + var12 * var17;
					var21 = this.aj - var12 * var15 * 0.8D - var10 * var17;
					this.ad.a("splash", var19, this.ai - 0.125D, var21, this.ak, this.al, this.am);
				} else {
					var19 = this.ah + var10 + var12 * var15 * 0.7D;
					var21 = this.aj + var12 - var10 * var15 * 0.7D;
					this.ad.a("splash", var19, this.ai - 0.125D, var21, this.ak, this.al, this.am);
				}
			}
		}

		if(this.at && var8 > 0.15D) {
			this.D();

			int var24;
			for(var24 = 0; var24 < 3; ++var24) {
				this.a(ln.x.ba, 1, 0.0F);
			}

			for(var24 = 0; var24 < 2; ++var24) {
				this.a(EntityTNTPrimed.B.aQ, 1, 0.0F);
			}
		} else {
			this.ak *= (double)0.99F;
			this.al *= (double)0.95F;
			this.am *= (double)0.99F;
		}

		this.ao = 0.0F;
		var10 = (double)this.an;
		var12 = this.ae - this.ah;
		double var25 = this.ag - this.aj;
		if(var12 * var12 + var25 * var25 > 0.001D) {
			var10 = (double)((float)(Math.atan2(var25, var12) * 180.0D / Math.PI));
		}

		double var16;
		for(var16 = var10 - (double)this.an; var16 >= 180.0D; var16 -= 360.0D) {
		}

		while(var16 < -180.0D) {
			var16 += 360.0D;
		}

		if(var16 > 20.0D) {
			var16 = 20.0D;
		}

		if(var16 < -20.0D) {
			var16 = -20.0D;
		}

		this.an = (float)((double)this.an + var16);
		this.c(this.an, this.ao);
		List var18 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar.b((double)0.2F, 0.0D, (double)0.2F));
		if(var18 != null && var18.size() > 0) {
			for(int var26 = 0; var26 < var18.size(); ++var26) {
				EntityMinecart var20 = (EntityMinecart)var18.get(var26);
				if(var20 != this.ab && var20.d_() && var20 instanceof ThreadDownloadResources) {
					var20.f(this);
				}
			}
		}

		if(this.ab != null && this.ab.ax) {
			this.ab = null;
		}

	}

	protected void i_() {
		double var1 = Math.cos((double)this.an * Math.PI / 180.0D) * 0.4D;
		double var3 = Math.sin((double)this.an * Math.PI / 180.0D) * 0.4D;
		this.ab.a(this.ah + var1, this.ai + this.j_() + this.ab.t(), this.aj + var3);
	}

	protected void a(EntityItem var1) {
	}

	protected void b(EntityItem var1) {
	}

	public float h_() {
		return 0.0F;
	}

	public boolean a(BlockMobSpawner var1) {
		var1.g(this);
		return true;
	}
}
