package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class RecipesWeapons extends EntityMinecart {
	private int c;
	public int a;
	private int d;
	private int e;
	private int f;
	public ThreadDownloadImageData b;

	public RecipesWeapons(EntitySpider var1) {
		super(var1);
		this.c = 0;
		this.a = 0;
		this.ay = 0.0F;
		this.a(0.5F, 0.5F);
	}

	public RecipesWeapons(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this(var1);
		this.d = var2;
		this.e = var3;
		this.f = var4;
		ArrayList var6 = new ArrayList();
		ThreadDownloadImageData[] var7 = ThreadDownloadImageData.values();
		int var8 = var7.length;

		for(int var9 = 0; var9 < var8; ++var9) {
			ThreadDownloadImageData var10 = var7[var9];
			this.b = var10;
			this.b(var5);
			if(this.i()) {
				var6.add(var10);
			}
		}

		if(var6.size() > 0) {
			this.b = (ThreadDownloadImageData)var6.get(this.aN.nextInt(var6.size()));
		}

		this.b(var5);
	}

	public void b(int var1) {
		this.a = var1;
		this.ap = this.an = (float)(var1 * 90);
		float var2 = (float)this.b.u;
		float var3 = (float)this.b.v;
		float var4 = (float)this.b.u;
		if(var1 != 0 && var1 != 2) {
			var2 = 0.5F;
		} else {
			var4 = 0.5F;
		}

		var2 /= 32.0F;
		var3 /= 32.0F;
		var4 /= 32.0F;
		float var5 = (float)this.d + 0.5F;
		float var6 = (float)this.e + 0.5F;
		float var7 = (float)this.f + 0.5F;
		float var8 = 0.5625F;
		if(var1 == 0) {
			var7 -= var8;
		}

		if(var1 == 1) {
			var5 -= var8;
		}

		if(var1 == 2) {
			var7 += var8;
		}

		if(var1 == 3) {
			var5 += var8;
		}

		if(var1 == 0) {
			var5 -= this.c(this.b.u);
		}

		if(var1 == 1) {
			var7 += this.c(this.b.u);
		}

		if(var1 == 2) {
			var5 += this.c(this.b.u);
		}

		if(var1 == 3) {
			var7 -= this.c(this.b.u);
		}

		var6 += this.c(this.b.v);
		this.a((double)var5, (double)var6, (double)var7);
		float var9 = -0.00625F;
		this.ar.c((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
	}

	private float c(int var1) {
		return var1 == 32?0.5F:(var1 == 64?0.5F:0.0F);
	}

	public void e_() {
		if(this.c++ == 100 && !this.i()) {
			this.c = 0;
			this.D();
			this.ad.a((EntityMinecart)(new EffectRenderer(this.ad, this.ah, this.ai, this.aj, new TileEntityFurnace(EntityTNTPrimed.aq))));
		}

	}

	public boolean i() {
		if(this.ad.a((EntityMinecart)this, (EntityRenderer)this.ar).size() > 0) {
			return false;
		} else {
			int var1 = this.b.u / 16;
			int var2 = this.b.v / 16;
			int var3 = this.d;
			int var4 = this.e;
			int var5 = this.f;
			if(this.a == 0) {
				var3 = ModelPig.b(this.ah - (double)((float)this.b.u / 32.0F));
			}

			if(this.a == 1) {
				var5 = ModelPig.b(this.aj - (double)((float)this.b.u / 32.0F));
			}

			if(this.a == 2) {
				var3 = ModelPig.b(this.ah - (double)((float)this.b.u / 32.0F));
			}

			if(this.a == 3) {
				var5 = ModelPig.b(this.aj - (double)((float)this.b.u / 32.0F));
			}

			var4 = ModelPig.b(this.ai - (double)((float)this.b.v / 32.0F));

			int var7;
			for(int var6 = 0; var6 < var1; ++var6) {
				for(var7 = 0; var7 < var2; ++var7) {
					EntitySkeleton var8;
					if(this.a != 0 && this.a != 2) {
						var8 = this.ad.f(this.d, var4 + var7, var5 + var6);
					} else {
						var8 = this.ad.f(var3 + var6, var4 + var7, this.f);
					}

					if(!var8.a()) {
						return false;
					}
				}
			}

			List var9 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar);

			for(var7 = 0; var7 < var9.size(); ++var7) {
				if(var9.get(var7) instanceof RecipesWeapons) {
					return false;
				}
			}

			return true;
		}
	}

	public boolean c_() {
		return true;
	}

	public boolean a(EntityMinecart var1, int var2) {
		this.D();
		this.ad.a((EntityMinecart)(new EffectRenderer(this.ad, this.ah, this.ai, this.aj, new TileEntityFurnace(EntityTNTPrimed.aq))));
		return true;
	}

	public void a(EntityItem var1) {
		var1.a("Dir", (byte)this.a);
		var1.a("Motive", this.b.t);
		var1.a("TileX", this.d);
		var1.a("TileY", this.e);
		var1.a("TileZ", this.f);
	}

	public void b(EntityItem var1) {
		this.a = var1.c("Dir");
		this.d = var1.e("TileX");
		this.e = var1.e("TileY");
		this.f = var1.e("TileZ");
		String var2 = var1.i("Motive");
		ThreadDownloadImageData[] var3 = ThreadDownloadImageData.values();
		int var4 = var3.length;

		for(int var5 = 0; var5 < var4; ++var5) {
			ThreadDownloadImageData var6 = var3[var5];
			if(var6.t.equals(var2)) {
				this.b = var6;
			}
		}

		if(this.b == null) {
			this.b = ThreadDownloadImageData.a;
		}

		this.b(this.a);
	}
}
