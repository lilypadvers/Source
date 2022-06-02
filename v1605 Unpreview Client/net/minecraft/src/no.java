package net.minecraft.src;

import java.util.List;

public class no extends EntityMinecart implements WorldIso {
	private TileEntityFurnace[] h;
	public int a;
	public int b;
	public int c;
	private boolean i;
	public int d;
	public int e;
	public double f;
	public double g;
	private static final int[][][] j = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
	private int k;
	private double l;
	private double m;
	private double n;
	private double o;
	private double p;

	public no(EntitySpider var1) {
		super(var1);
		this.h = new TileEntityFurnace[36];
		this.a = 0;
		this.b = 0;
		this.c = 1;
		this.i = false;
		this.aa = true;
		this.a(0.98F, 0.7F);
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

	public no(EntitySpider var1, double var2, double var4, double var6, int var8) {
		this(var1);
		this.a(var2, var4 + (double)this.ay, var6);
		this.ak = 0.0D;
		this.al = 0.0D;
		this.am = 0.0D;
		this.ae = var2;
		this.af = var4;
		this.ag = var6;
		this.d = var8;
	}

	public double j_() {
		return (double)this.aA * 0.0D - (double)0.3F;
	}

	public boolean a(EntityMinecart var1, int var2) {
		this.c = -this.c;
		this.b = 10;
		this.a += var2 * 10;
		if(this.a > 40) {
			this.a(EntityTNTPrimed.ax.aQ, 1, 0.0F);
			if(this.d == 1) {
				this.a(ln.au.ba, 1, 0.0F);
			} else if(this.d == 2) {
				this.a(ln.aB.ba, 1, 0.0F);
			}

			this.D();
		}

		return true;
	}

	public boolean c_() {
		return !this.ax;
	}

	public void D() {
		for(int var1 = 0; var1 < this.a(); ++var1) {
			TileEntityFurnace var2 = this.a_(var1);
			if(var2 != null) {
				float var3 = this.aN.nextFloat() * 0.8F + 0.1F;
				float var4 = this.aN.nextFloat() * 0.8F + 0.1F;
				float var5 = this.aN.nextFloat() * 0.8F + 0.1F;

				while(var2.a > 0) {
					int var6 = this.aN.nextInt(21) + 10;
					if(var6 > var2.a) {
						var6 = var2.a;
					}

					var2.a -= var6;
					EffectRenderer var7 = new EffectRenderer(this.ad, this.ah + (double)var3, this.ai + (double)var4, this.aj + (double)var5, new TileEntityFurnace(var2.c, var6, var2.d));
					float var8 = 0.05F;
					var7.ak = (double)((float)this.aN.nextGaussian() * var8);
					var7.al = (double)((float)this.aN.nextGaussian() * var8 + 0.2F);
					var7.am = (double)((float)this.aN.nextGaussian() * var8);
					this.ad.a((EntityMinecart)var7);
				}
			}
		}

		super.D();
	}

	public void e_() {
		double var7;
		if(this.ad.v) {
			if(this.k > 0) {
				double var41 = this.ah + (this.l - this.ah) / (double)this.k;
				double var42 = this.ai + (this.m - this.ai) / (double)this.k;
				double var5 = this.aj + (this.n - this.aj) / (double)this.k;

				for(var7 = this.o - (double)this.an; var7 < -180.0D; var7 += 360.0D) {
				}

				while(var7 >= 180.0D) {
					var7 -= 360.0D;
				}

				this.an = (float)((double)this.an + var7 / (double)this.k);
				this.ao = (float)((double)this.ao + (this.p - (double)this.ao) / (double)this.k);
				--this.k;
				this.a(var41, var42, var5);
				this.c(this.an, this.ao);
			} else {
				this.a(this.ah, this.ai, this.aj);
				this.c(this.an, this.ao);
			}

		} else {
			if(this.b > 0) {
				--this.b;
			}

			if(this.a > 0) {
				--this.a;
			}

			this.ae = this.ah;
			this.af = this.ai;
			this.ag = this.aj;
			this.al -= (double)0.04F;
			int var1 = ModelPig.b(this.ah);
			int var2 = ModelPig.b(this.ai);
			int var3 = ModelPig.b(this.aj);
			if(this.ad.a(var1, var2 - 1, var3) == ln.aG.ba) {
				--var2;
			}

			double var4 = 0.4D;
			boolean var6 = false;
			var7 = 2.0D / 256D;
			if(this.ad.a(var1, var2, var3) == ln.aG.ba) {
				BlockTNT var9 = this.g(this.ah, this.ai, this.aj);
				int var10 = this.ad.e(var1, var2, var3);
				this.ai = (double)var2;
				if(var10 >= 2 && var10 <= 5) {
					this.ai = (double)(var2 + 1);
				}

				if(var10 == 2) {
					this.ak -= var7;
				}

				if(var10 == 3) {
					this.ak += var7;
				}

				if(var10 == 4) {
					this.am += var7;
				}

				if(var10 == 5) {
					this.am -= var7;
				}

				int[][] var11 = j[var10];
				double var12 = (double)(var11[1][0] - var11[0][0]);
				double var14 = (double)(var11[1][2] - var11[0][2]);
				double var16 = Math.sqrt(var12 * var12 + var14 * var14);
				double var18 = this.ak * var12 + this.am * var14;
				if(var18 < 0.0D) {
					var12 = -var12;
					var14 = -var14;
				}

				double var20 = Math.sqrt(this.ak * this.ak + this.am * this.am);
				this.ak = var20 * var12 / var16;
				this.am = var20 * var14 / var16;
				double var22 = 0.0D;
				double var24 = (double)var1 + 0.5D + (double)var11[0][0] * 0.5D;
				double var26 = (double)var3 + 0.5D + (double)var11[0][2] * 0.5D;
				double var28 = (double)var1 + 0.5D + (double)var11[1][0] * 0.5D;
				double var30 = (double)var3 + 0.5D + (double)var11[1][2] * 0.5D;
				var12 = var28 - var24;
				var14 = var30 - var26;
				double var32;
				double var34;
				double var36;
				if(var12 == 0.0D) {
					this.ah = (double)var1 + 0.5D;
					var22 = this.aj - (double)var3;
				} else if(var14 == 0.0D) {
					this.aj = (double)var3 + 0.5D;
					var22 = this.ah - (double)var1;
				} else {
					var32 = this.ah - var24;
					var34 = this.aj - var26;
					var36 = (var32 * var12 + var34 * var14) * 2.0D;
					var22 = var36;
				}

				this.ah = var24 + var12 * var22;
				this.aj = var26 + var14 * var22;
				this.a(this.ah, this.ai + (double)this.ay, this.aj);
				var32 = this.ak;
				var34 = this.am;
				if(this.ab != null) {
					var32 *= 0.75D;
					var34 *= 0.75D;
				}

				if(var32 < -var4) {
					var32 = -var4;
				}

				if(var32 > var4) {
					var32 = var4;
				}

				if(var34 < -var4) {
					var34 = -var4;
				}

				if(var34 > var4) {
					var34 = var4;
				}

				this.c(var32, 0.0D, var34);
				if(var11[0][1] != 0 && ModelPig.b(this.ah) - var1 == var11[0][0] && ModelPig.b(this.aj) - var3 == var11[0][2]) {
					this.a(this.ah, this.ai + (double)var11[0][1], this.aj);
				} else if(var11[1][1] != 0 && ModelPig.b(this.ah) - var1 == var11[1][0] && ModelPig.b(this.aj) - var3 == var11[1][2]) {
					this.a(this.ah, this.ai + (double)var11[1][1], this.aj);
				}

				if(this.ab != null) {
					this.ak *= (double)0.997F;
					this.al *= 0.0D;
					this.am *= (double)0.997F;
				} else {
					if(this.d == 2) {
						var36 = (double)ModelPig.a(this.f * this.f + this.g * this.g);
						if(var36 > 0.01D) {
							var6 = true;
							this.f /= var36;
							this.g /= var36;
							double var38 = 0.04D;
							this.ak *= (double)0.8F;
							this.al *= 0.0D;
							this.am *= (double)0.8F;
							this.ak += this.f * var38;
							this.am += this.g * var38;
						} else {
							this.ak *= (double)0.9F;
							this.al *= 0.0D;
							this.am *= (double)0.9F;
						}
					}

					this.ak *= (double)0.96F;
					this.al *= 0.0D;
					this.am *= (double)0.96F;
				}

				BlockTNT var46 = this.g(this.ah, this.ai, this.aj);
				if(var46 != null && var9 != null) {
					double var37 = (var9.b - var46.b) * 0.05D;
					var20 = Math.sqrt(this.ak * this.ak + this.am * this.am);
					if(var20 > 0.0D) {
						this.ak = this.ak / var20 * (var20 + var37);
						this.am = this.am / var20 * (var20 + var37);
					}

					this.a(this.ah, var46.b, this.aj);
				}

				int var47 = ModelPig.b(this.ah);
				int var48 = ModelPig.b(this.aj);
				if(var47 != var1 || var48 != var3) {
					var20 = Math.sqrt(this.ak * this.ak + this.am * this.am);
					this.ak = var20 * (double)(var47 - var1);
					this.am = var20 * (double)(var48 - var3);
				}

				if(this.d == 2) {
					double var39 = (double)ModelPig.a(this.f * this.f + this.g * this.g);
					if(var39 > 0.01D && this.ak * this.ak + this.am * this.am > 0.001D) {
						this.f /= var39;
						this.g /= var39;
						if(this.f * this.ak + this.g * this.am < 0.0D) {
							this.f = 0.0D;
							this.g = 0.0D;
						} else {
							this.f = this.ak;
							this.g = this.am;
						}
					}
				}
			} else {
				if(this.ak < -var4) {
					this.ak = -var4;
				}

				if(this.ak > var4) {
					this.ak = var4;
				}

				if(this.am < -var4) {
					this.am = -var4;
				}

				if(this.am > var4) {
					this.am = var4;
				}

				if(this.as) {
					this.ak *= 0.5D;
					this.al *= 0.5D;
					this.am *= 0.5D;
				}

				this.c(this.ak, this.al, this.am);
				if(!this.as) {
					this.ak *= (double)0.95F;
					this.al *= (double)0.95F;
					this.am *= (double)0.95F;
				}
			}

			this.ao = 0.0F;
			double var43 = this.ae - this.ah;
			double var44 = this.ag - this.aj;
			if(var43 * var43 + var44 * var44 > 0.001D) {
				this.an = (float)(Math.atan2(var44, var43) * 180.0D / Math.PI);
				if(this.i) {
					this.an += 180.0F;
				}
			}

			double var13;
			for(var13 = (double)(this.an - this.ap); var13 >= 180.0D; var13 -= 360.0D) {
			}

			while(var13 < -180.0D) {
				var13 += 360.0D;
			}

			if(var13 < -170.0D || var13 >= 170.0D) {
				this.an += 180.0F;
				this.i = !this.i;
			}

			this.c(this.an, this.ao);
			List var15 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar.b((double)0.2F, 0.0D, (double)0.2F));
			if(var15 != null && var15.size() > 0) {
				for(int var45 = 0; var45 < var15.size(); ++var45) {
					EntityMinecart var17 = (EntityMinecart)var15.get(var45);
					if(var17 != this.ab && var17.d_() && var17 instanceof no) {
						var17.f(this);
					}
				}
			}

			if(this.ab != null && this.ab.ax) {
				this.ab = null;
			}

			if(var6 && this.aN.nextInt(4) == 0) {
				--this.e;
				if(this.e < 0) {
					this.f = this.g = 0.0D;
				}

				this.ad.a("largesmoke", this.ah, this.ai + 0.8D, this.aj, 0.0D, 0.0D, 0.0D);
			}

		}
	}

	public BlockTNT a(double var1, double var3, double var5, double var7) {
		int var9 = ModelPig.b(var1);
		int var10 = ModelPig.b(var3);
		int var11 = ModelPig.b(var5);
		if(this.ad.a(var9, var10 - 1, var11) == ln.aG.ba) {
			--var10;
		}

		if(this.ad.a(var9, var10, var11) == ln.aG.ba) {
			int var12 = this.ad.e(var9, var10, var11);
			var3 = (double)var10;
			if(var12 >= 2 && var12 <= 5) {
				var3 = (double)(var10 + 1);
			}

			int[][] var13 = j[var12];
			double var14 = (double)(var13[1][0] - var13[0][0]);
			double var16 = (double)(var13[1][2] - var13[0][2]);
			double var18 = Math.sqrt(var14 * var14 + var16 * var16);
			var14 /= var18;
			var16 /= var18;
			var1 += var14 * var7;
			var5 += var16 * var7;
			if(var13[0][1] != 0 && ModelPig.b(var1) - var9 == var13[0][0] && ModelPig.b(var5) - var11 == var13[0][2]) {
				var3 += (double)var13[0][1];
			} else if(var13[1][1] != 0 && ModelPig.b(var1) - var9 == var13[1][0] && ModelPig.b(var5) - var11 == var13[1][2]) {
				var3 += (double)var13[1][1];
			}

			return this.g(var1, var3, var5);
		} else {
			return null;
		}
	}

	public BlockTNT g(double var1, double var3, double var5) {
		int var7 = ModelPig.b(var1);
		int var8 = ModelPig.b(var3);
		int var9 = ModelPig.b(var5);
		if(this.ad.a(var7, var8 - 1, var9) == ln.aG.ba) {
			--var8;
		}

		if(this.ad.a(var7, var8, var9) == ln.aG.ba) {
			int var10 = this.ad.e(var7, var8, var9);
			var3 = (double)var8;
			if(var10 >= 2 && var10 <= 5) {
				var3 = (double)(var8 + 1);
			}

			int[][] var11 = j[var10];
			double var12 = 0.0D;
			double var14 = (double)var7 + 0.5D + (double)var11[0][0] * 0.5D;
			double var16 = (double)var8 + 0.5D + (double)var11[0][1] * 0.5D;
			double var18 = (double)var9 + 0.5D + (double)var11[0][2] * 0.5D;
			double var20 = (double)var7 + 0.5D + (double)var11[1][0] * 0.5D;
			double var22 = (double)var8 + 0.5D + (double)var11[1][1] * 0.5D;
			double var24 = (double)var9 + 0.5D + (double)var11[1][2] * 0.5D;
			double var26 = var20 - var14;
			double var28 = (var22 - var16) * 2.0D;
			double var30 = var24 - var18;
			if(var26 == 0.0D) {
				var1 = (double)var7 + 0.5D;
				var12 = var5 - (double)var9;
			} else if(var30 == 0.0D) {
				var5 = (double)var9 + 0.5D;
				var12 = var1 - (double)var7;
			} else {
				double var32 = var1 - var14;
				double var34 = var5 - var18;
				double var36 = (var32 * var26 + var34 * var30) * 2.0D;
				var12 = var36;
			}

			var1 = var14 + var26 * var12;
			var3 = var16 + var28 * var12;
			var5 = var18 + var30 * var12;
			if(var28 < 0.0D) {
				++var3;
			}

			if(var28 > 0.0D) {
				var3 += 0.5D;
			}

			return BlockTNT.b(var1, var3, var5);
		} else {
			return null;
		}
	}

	protected void a(EntityItem var1) {
		var1.a("Type", this.d);
		if(this.d == 2) {
			var1.a("PushX", this.f);
			var1.a("PushZ", this.g);
			var1.a("Fuel", (short)this.e);
		} else if(this.d == 1) {
			ItemPainting var2 = new ItemPainting();

			for(int var3 = 0; var3 < this.h.length; ++var3) {
				if(this.h[var3] != null) {
					EntityItem var4 = new EntityItem();
					var4.a("Slot", (byte)var3);
					this.h[var3].a(var4);
					var2.a((EnumSkyBlock)var4);
				}
			}

			var1.a("Items", (EnumSkyBlock)var2);
		}

	}

	protected void b(EntityItem var1) {
		this.d = var1.e("Type");
		if(this.d == 2) {
			this.f = var1.h("PushX");
			this.g = var1.h("PushZ");
			this.e = var1.d("Fuel");
		} else if(this.d == 1) {
			ItemPainting var2 = var1.l("Items");
			this.h = new TileEntityFurnace[this.a()];

			for(int var3 = 0; var3 < var2.c(); ++var3) {
				EntityItem var4 = (EntityItem)var2.a(var3);
				int var5 = var4.c("Slot") & 255;
				if(var5 >= 0 && var5 < this.h.length) {
					this.h[var5] = new TileEntityFurnace(var4);
				}
			}
		}

	}

	public float h_() {
		return 0.0F;
	}

	public void f(EntityMinecart var1) {
		if(var1 != this.ab) {
			if(var1 instanceof RecipesIngots && !(var1 instanceof BlockMobSpawner) && this.d == 0 && this.ak * this.ak + this.am * this.am > 0.01D && this.ab == null && var1.ac == null) {
				var1.g(this);
			}

			double var2 = var1.ah - this.ah;
			double var4 = var1.aj - this.aj;
			double var6 = var2 * var2 + var4 * var4;
			if(var6 >= 9.999999747378752E-5D) {
				var6 = (double)ModelPig.a(var6);
				var2 /= var6;
				var4 /= var6;
				double var8 = 1.0D / var6;
				if(var8 > 1.0D) {
					var8 = 1.0D;
				}

				var2 *= var8;
				var4 *= var8;
				var2 *= (double)0.1F;
				var4 *= (double)0.1F;
				var2 *= (double)(1.0F - this.aL);
				var4 *= (double)(1.0F - this.aL);
				var2 *= 0.5D;
				var4 *= 0.5D;
				if(var1 instanceof no) {
					double var10 = var1.ak + this.ak;
					double var12 = var1.am + this.am;
					if(((no)var1).d == 2 && this.d != 2) {
						this.ak *= (double)0.2F;
						this.am *= (double)0.2F;
						this.f(var1.ak - var2, 0.0D, var1.am - var4);
						var1.ak *= (double)0.7F;
						var1.am *= (double)0.7F;
					} else if(((no)var1).d != 2 && this.d == 2) {
						var1.ak *= (double)0.2F;
						var1.am *= (double)0.2F;
						var1.f(this.ak + var2, 0.0D, this.am + var4);
						this.ak *= (double)0.7F;
						this.am *= (double)0.7F;
					} else {
						var10 /= 2.0D;
						var12 /= 2.0D;
						this.ak *= (double)0.2F;
						this.am *= (double)0.2F;
						this.f(var10 - var2, 0.0D, var12 - var4);
						var1.ak *= (double)0.2F;
						var1.am *= (double)0.2F;
						var1.f(var10 + var2, 0.0D, var12 + var4);
					}
				} else {
					this.f(-var2, 0.0D, -var4);
					var1.f(var2 / 4.0D, 0.0D, var4 / 4.0D);
				}
			}

		}
	}

	public int a() {
		return 27;
	}

	public TileEntityFurnace a_(int var1) {
		return this.h[var1];
	}

	public TileEntityFurnace a(int var1, int var2) {
		if(this.h[var1] != null) {
			TileEntityFurnace var3;
			if(this.h[var1].a <= var2) {
				var3 = this.h[var1];
				this.h[var1] = null;
				return var3;
			} else {
				var3 = this.h[var1].a(var2);
				if(this.h[var1].a == 0) {
					this.h[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, TileEntityFurnace var2) {
		this.h[var1] = var2;
		if(var2 != null && var2.a > this.c()) {
			var2.a = this.c();
		}

	}

	public String b() {
		return "Minecart";
	}

	public int c() {
		return 64;
	}

	public void d() {
	}

	public boolean a(BlockMobSpawner var1) {
		if(this.d == 0) {
			var1.g(this);
		} else if(this.d == 1) {
			var1.a((WorldIso)this);
		} else if(this.d == 2) {
			TileEntityFurnace var2 = var1.b.e();
			if(var2 != null && var2.c == EntityTNTPrimed.k.aQ) {
				if(--var2.a == 0) {
					var1.b.a(var1.b.d, (TileEntityFurnace)null);
				}

				this.e += 1200;
			}

			this.f = this.ah - var1.ah;
			this.g = this.aj - var1.aj;
		}

		return true;
	}

	public void a(double var1, double var3, double var5, float var7, float var8, int var9) {
		this.l = var1;
		this.m = var3;
		this.n = var5;
		this.o = (double)var7;
		this.p = (double)var8;
		this.k = var9;
	}
}
