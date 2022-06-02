package net.minecraft.src;

import java.util.List;

public class NBTTagEnd extends EntityMinecart {
	private int b = -1;
	private int c = -1;
	private int d = -1;
	private int e = 0;
	private boolean f = false;
	public int a = 0;
	private RecipesIngots g;
	private int h;
	private int i = 0;

	public NBTTagEnd(EntitySpider var1) {
		super(var1);
		this.a(0.5F, 0.5F);
	}

	public NBTTagEnd(EntitySpider var1, RecipesIngots var2) {
		super(var1);
		this.g = var2;
		this.a(0.5F, 0.5F);
		this.c(var2.ah, var2.ai, var2.aj, var2.an, var2.ao);
		this.ah -= (double)(ModelPig.b(this.an / 180.0F * (float)Math.PI) * 0.16F);
		this.ai -= (double)0.1F;
		this.aj -= (double)(ModelPig.a(this.an / 180.0F * (float)Math.PI) * 0.16F);
		this.a(this.ah, this.ai, this.aj);
		this.ay = 0.0F;
		this.ak = (double)(-ModelPig.a(this.an / 180.0F * (float)Math.PI) * ModelPig.b(this.ao / 180.0F * (float)Math.PI));
		this.am = (double)(ModelPig.b(this.an / 180.0F * (float)Math.PI) * ModelPig.b(this.ao / 180.0F * (float)Math.PI));
		this.al = (double)(-ModelPig.a(this.ao / 180.0F * (float)Math.PI));
		this.a(this.ak, this.al, this.am, 1.5F, 1.0F);
	}

	public void a(double var1, double var3, double var5, float var7, float var8) {
		float var9 = ModelPig.a(var1 * var1 + var3 * var3 + var5 * var5);
		var1 /= (double)var9;
		var3 /= (double)var9;
		var5 /= (double)var9;
		var1 += this.aN.nextGaussian() * (double)0.0075F * (double)var8;
		var3 += this.aN.nextGaussian() * (double)0.0075F * (double)var8;
		var5 += this.aN.nextGaussian() * (double)0.0075F * (double)var8;
		var1 *= (double)var7;
		var3 *= (double)var7;
		var5 *= (double)var7;
		this.ak = var1;
		this.al = var3;
		this.am = var5;
		float var10 = ModelPig.a(var1 * var1 + var5 * var5);
		this.ap = this.an = (float)(Math.atan2(var1, var5) * 180.0D / (double)(float)Math.PI);
		this.aq = this.ao = (float)(Math.atan2(var3, (double)var10) * 180.0D / (double)(float)Math.PI);
		this.h = 0;
	}

	public void e_() {
		super.e_();
		if(this.a > 0) {
			--this.a;
		}

		if(this.f) {
			int var1 = this.ad.a(this.b, this.c, this.d);
			if(var1 == this.e) {
				++this.h;
				if(this.h == 1200) {
					this.D();
				}

				return;
			}

			this.f = false;
			this.ak *= (double)(this.aN.nextFloat() * 0.2F);
			this.al *= (double)(this.aN.nextFloat() * 0.2F);
			this.am *= (double)(this.aN.nextFloat() * 0.2F);
			this.h = 0;
			this.i = 0;
		} else {
			++this.i;
		}

		BlockTNT var15 = BlockTNT.b(this.ah, this.ai, this.aj);
		BlockTNT var2 = BlockTNT.b(this.ah + this.ak, this.ai + this.al, this.aj + this.am);
		lv var3 = this.ad.a(var15, var2);
		var15 = BlockTNT.b(this.ah, this.ai, this.aj);
		var2 = BlockTNT.b(this.ah + this.ak, this.ai + this.al, this.aj + this.am);
		if(var3 != null) {
			var2 = BlockTNT.b(var3.f.a, var3.f.b, var3.f.c);
		}

		EntityMinecart var4 = null;
		List var5 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar.a(this.ak, this.al, this.am).b(1.0D, 1.0D, 1.0D));
		double var6 = 0.0D;

		float var10;
		for(int var8 = 0; var8 < var5.size(); ++var8) {
			EntityMinecart var9 = (EntityMinecart)var5.get(var8);
			if(var9.c_() && (var9 != this.g || this.i >= 5)) {
				var10 = 0.3F;
				EntityRenderer var11 = var9.ar.b((double)var10, (double)var10, (double)var10);
				lv var12 = var11.a(var15, var2);
				if(var12 != null) {
					double var13 = var15.c(var12.f);
					if(var13 < var6 || var6 == 0.0D) {
						var4 = var9;
						var6 = var13;
					}
				}
			}
		}

		if(var4 != null) {
			var3 = new lv(var4);
		}

		float var16;
		if(var3 != null) {
			if(var3.g != null) {
				if(var3.g.a(this.g, 4)) {
					this.ad.a(this, "random.drr", 1.0F, 1.2F / (this.aN.nextFloat() * 0.2F + 0.9F));
					this.D();
				} else {
					this.ak *= -0.10000000149011612D;
					this.al *= -0.10000000149011612D;
					this.am *= -0.10000000149011612D;
					this.an += 180.0F;
					this.ap += 180.0F;
					this.i = 0;
				}
			} else {
				this.b = var3.b;
				this.c = var3.c;
				this.d = var3.d;
				this.e = this.ad.a(this.b, this.c, this.d);
				this.ak = (double)((float)(var3.f.a - this.ah));
				this.al = (double)((float)(var3.f.b - this.ai));
				this.am = (double)((float)(var3.f.c - this.aj));
				var16 = ModelPig.a(this.ak * this.ak + this.al * this.al + this.am * this.am);
				this.ah -= this.ak / (double)var16 * (double)0.05F;
				this.ai -= this.al / (double)var16 * (double)0.05F;
				this.aj -= this.am / (double)var16 * (double)0.05F;
				this.ad.a(this, "random.drr", 1.0F, 1.2F / (this.aN.nextFloat() * 0.2F + 0.9F));
				this.f = true;
				this.a = 7;
			}
		}

		this.ah += this.ak;
		this.ai += this.al;
		this.aj += this.am;
		var16 = ModelPig.a(this.ak * this.ak + this.am * this.am);
		this.an = (float)(Math.atan2(this.ak, this.am) * 180.0D / (double)(float)Math.PI);

		for(this.ao = (float)(Math.atan2(this.al, (double)var16) * 180.0D / (double)(float)Math.PI); this.ao - this.aq < -180.0F; this.aq -= 360.0F) {
		}

		while(this.ao - this.aq >= 180.0F) {
			this.aq += 360.0F;
		}

		while(this.an - this.ap < -180.0F) {
			this.ap -= 360.0F;
		}

		while(this.an - this.ap >= 180.0F) {
			this.ap += 360.0F;
		}

		this.ao = this.aq + (this.ao - this.aq) * 0.2F;
		this.an = this.ap + (this.an - this.ap) * 0.2F;
		float var17 = 0.99F;
		var10 = 0.03F;
		if(this.g_()) {
			for(int var18 = 0; var18 < 4; ++var18) {
				float var19 = 0.25F;
				this.ad.a("bubble", this.ah - this.ak * (double)var19, this.ai - this.al * (double)var19, this.aj - this.am * (double)var19, this.ak, this.al, this.am);
			}

			var17 = 0.8F;
		}

		this.ak *= (double)var17;
		this.al *= (double)var17;
		this.am *= (double)var17;
		this.al -= (double)var10;
		this.a(this.ah, this.ai, this.aj);
	}

	public void a(EntityItem var1) {
		var1.a("xTile", (short)this.b);
		var1.a("yTile", (short)this.c);
		var1.a("zTile", (short)this.d);
		var1.a("inTile", (byte)this.e);
		var1.a("shake", (byte)this.a);
		var1.a("inGround", (byte)(this.f?1:0));
	}

	public void b(EntityItem var1) {
		this.b = var1.d("xTile");
		this.c = var1.d("yTile");
		this.d = var1.d("zTile");
		this.e = var1.c("inTile") & 255;
		this.a = var1.c("shake") & 255;
		this.f = var1.c("inGround") == 1;
	}

	public void b(BlockMobSpawner var1) {
		if(this.f && this.g == var1 && this.a <= 0 && var1.b.a(new TileEntityFurnace(EntityTNTPrimed.j.aQ, 1))) {
			this.ad.a(this, "random.pop", 0.2F, ((this.aN.nextFloat() - this.aN.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			var1.a_(this, 1);
			this.D();
		}

	}

	public float h_() {
		return 0.0F;
	}
}
