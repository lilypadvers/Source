package net.minecraft.src;

import java.util.List;
import java.util.Random;

public abstract class EntityMinecart {
	private static int damageTaken = 0;
	public int Z = damageTaken++;
	public boolean aa = false;
	public EntityMinecart ab;
	public EntityMinecart ac;
	protected EntitySpider ad;
	public double ae;
	public double af;
	public double ag;
	public double ah;
	public double ai;
	public double aj;
	public double ak;
	public double al;
	public double am;
	public float an;
	public float ao;
	public float ap;
	public float aq;
	public final EntityRenderer ar = EntityRenderer.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
	public boolean as = false;
	public boolean at;
	public boolean au;
	public boolean av = false;
	public boolean aw = true;
	public boolean ax = false;
	public float ay = 0.0F;
	public float az = 0.6F;
	public float aA = 1.8F;
	public float aB = 0.0F;
	public float aC = 0.0F;
	protected boolean aD = true;
	protected float aE = 0.0F;
	private int timeSinceHit = 1;
	public double aF;
	public double aG;
	public double aH;
	public float aI = 0.0F;
	public float aJ = 0.0F;
	public boolean aK = false;
	public float aL = 0.0F;
	public boolean aM = false;
	protected Random aN = new Random();
	public int aO = 0;
	public int aP = 1;
	public int aQ = 0;
	protected int aR = 300;
	protected boolean aS = false;
	public int aT = 0;
	public int aU = 300;
	private boolean c = true;
	public String aV;
	private double d;
	private double e;
	public boolean aW = false;
	public int aX;
	public int aY;
	public int aZ;
	public int ba;
	public int bb;
	public int bc;

	public EntityMinecart(EntitySpider var1) {
		this.ad = var1;
		this.a(0.0D, 0.0D, 0.0D);
	}

	public boolean equals(Object var1) {
		return var1 instanceof EntityMinecart?((EntityMinecart)var1).Z == this.Z:false;
	}

	public int hashCode() {
		return this.Z;
	}

	protected void o() {
		if(this.ad != null) {
			while(this.ai > 0.0D) {
				this.a(this.ah, this.ai, this.aj);
				if(this.ad.a(this, this.ar).size() == 0) {
					break;
				}

				++this.ai;
			}

			this.ak = this.al = this.am = 0.0D;
			this.ao = 0.0F;
		}
	}

	public void D() {
		this.ax = true;
	}

	protected void a(float var1, float var2) {
		this.az = var1;
		this.aA = var2;
	}

	protected void c(float var1, float var2) {
		this.an = var1;
		this.ao = var2;
	}

	public void a(double var1, double var3, double var5) {
		this.ah = var1;
		this.ai = var3;
		this.aj = var5;
		float var7 = this.az / 2.0F;
		float var8 = this.aA;
		this.ar.c(var1 - (double)var7, var3 - (double)this.ay + (double)this.aI, var5 - (double)var7, var1 + (double)var7, var3 - (double)this.ay + (double)this.aI + (double)var8, var5 + (double)var7);
	}

	public void d(float var1, float var2) {
		float var3 = this.ao;
		float var4 = this.an;
		this.an = (float)((double)this.an + (double)var1 * 0.15D);
		this.ao = (float)((double)this.ao - (double)var2 * 0.15D);
		if(this.ao < -90.0F) {
			this.ao = -90.0F;
		}

		if(this.ao > 90.0F) {
			this.ao = 90.0F;
		}

		this.aq += this.ao - var3;
		this.ap += this.an - var4;
	}

	public void e_() {
		this.w();
	}

	public void w() {
		if(this.ac != null && this.ac.ax) {
			this.ac = null;
		}

		++this.aO;
		this.aB = this.aC;
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		this.aq = this.ao;
		this.ap = this.an;
		if(this.g_()) {
			if(!this.aS && !this.c) {
				float var1 = ModelPig.a(this.ak * this.ak * (double)0.2F + this.al * this.al + this.am * this.am * (double)0.2F) * 0.2F;
				if(var1 > 1.0F) {
					var1 = 1.0F;
				}

				this.ad.a(this, "random.splash", var1, 1.0F + (this.aN.nextFloat() - this.aN.nextFloat()) * 0.4F);
				float var2 = (float)ModelPig.b(this.ar.b);

				int var3;
				float var4;
				float var5;
				for(var3 = 0; (float)var3 < 1.0F + this.az * 20.0F; ++var3) {
					var4 = (this.aN.nextFloat() * 2.0F - 1.0F) * this.az;
					var5 = (this.aN.nextFloat() * 2.0F - 1.0F) * this.az;
					this.ad.a("bubble", this.ah + (double)var4, (double)(var2 + 1.0F), this.aj + (double)var5, this.ak, this.al - (double)(this.aN.nextFloat() * 0.2F), this.am);
				}

				for(var3 = 0; (float)var3 < 1.0F + this.az * 20.0F; ++var3) {
					var4 = (this.aN.nextFloat() * 2.0F - 1.0F) * this.az;
					var5 = (this.aN.nextFloat() * 2.0F - 1.0F) * this.az;
					this.ad.a("splash", this.ah + (double)var4, (double)(var2 + 1.0F), this.aj + (double)var5, this.ak, this.al, this.am);
				}
			}

			this.aE = 0.0F;
			this.aS = true;
			this.aQ = 0;
		} else {
			this.aS = false;
		}

		if(this.aQ > 0) {
			if(this.aQ % 20 == 0) {
				this.a((EntityMinecart)null, 1);
			}

			--this.aQ;
		}

		if(this.E()) {
			this.a((EntityMinecart)null, 10);
			this.aQ = 600;
		}

		if(this.ai < -64.0D) {
			this.C();
		}

		this.c = false;
	}

	protected void C() {
		this.D();
	}

	public boolean b(double var1, double var3, double var5) {
		EntityRenderer var7 = this.ar.c(var1, var3, var5);
		List var8 = this.ad.a(this, var7);
		return var8.size() > 0?false:!this.ad.b(var7);
	}

	public void c(double var1, double var3, double var5) {
		if(this.aK) {
			this.ar.d(var1, var3, var5);
			this.ah = (this.ar.a + this.ar.d) / 2.0D;
			this.ai = this.ar.b + (double)this.ay - (double)this.aI;
			this.aj = (this.ar.c + this.ar.f) / 2.0D;
		} else {
			double var7 = this.ah;
			double var9 = this.aj;
			double var11 = var1;
			double var13 = var3;
			double var15 = var5;
			EntityRenderer var17 = this.ar.c();
			List var18 = this.ad.a(this, this.ar.a(var1, var3, var5));

			for(int var19 = 0; var19 < var18.size(); ++var19) {
				var3 = ((EntityRenderer)var18.get(var19)).b(this.ar, var3);
			}

			this.ar.d(0.0D, var3, 0.0D);
			if(!this.aw && var13 != var3) {
				var5 = 0.0D;
				var3 = 0.0D;
				var1 = 0.0D;
			}

			boolean var34 = this.as || var13 != var3 && var13 < 0.0D;

			int var20;
			for(var20 = 0; var20 < var18.size(); ++var20) {
				var1 = ((EntityRenderer)var18.get(var20)).a(this.ar, var1);
			}

			this.ar.d(var1, 0.0D, 0.0D);
			if(!this.aw && var11 != var1) {
				var5 = 0.0D;
				var3 = 0.0D;
				var1 = 0.0D;
			}

			for(var20 = 0; var20 < var18.size(); ++var20) {
				var5 = ((EntityRenderer)var18.get(var20)).c(this.ar, var5);
			}

			this.ar.d(0.0D, 0.0D, var5);
			if(!this.aw && var15 != var5) {
				var5 = 0.0D;
				var3 = 0.0D;
				var1 = 0.0D;
			}

			double var22;
			int var27;
			double var35;
			if(this.aJ > 0.0F && var34 && this.aI < 0.05F && (var11 != var1 || var15 != var5)) {
				var35 = var1;
				var22 = var3;
				double var24 = var5;
				var1 = var11;
				var3 = (double)this.aJ;
				var5 = var15;
				EntityRenderer var26 = this.ar.c();
				this.ar.b(var17);
				var18 = this.ad.a(this, this.ar.a(var11, var3, var15));

				for(var27 = 0; var27 < var18.size(); ++var27) {
					var3 = ((EntityRenderer)var18.get(var27)).b(this.ar, var3);
				}

				this.ar.d(0.0D, var3, 0.0D);
				if(!this.aw && var13 != var3) {
					var5 = 0.0D;
					var3 = 0.0D;
					var1 = 0.0D;
				}

				for(var27 = 0; var27 < var18.size(); ++var27) {
					var1 = ((EntityRenderer)var18.get(var27)).a(this.ar, var1);
				}

				this.ar.d(var1, 0.0D, 0.0D);
				if(!this.aw && var11 != var1) {
					var5 = 0.0D;
					var3 = 0.0D;
					var1 = 0.0D;
				}

				for(var27 = 0; var27 < var18.size(); ++var27) {
					var5 = ((EntityRenderer)var18.get(var27)).c(this.ar, var5);
				}

				this.ar.d(0.0D, 0.0D, var5);
				if(!this.aw && var15 != var5) {
					var5 = 0.0D;
					var3 = 0.0D;
					var1 = 0.0D;
				}

				if(var35 * var35 + var24 * var24 >= var1 * var1 + var5 * var5) {
					var1 = var35;
					var3 = var22;
					var5 = var24;
					this.ar.b(var26);
				} else {
					this.aI = (float)((double)this.aI + 0.5D);
				}
			}

			this.ah = (this.ar.a + this.ar.d) / 2.0D;
			this.ai = this.ar.b + (double)this.ay - (double)this.aI;
			this.aj = (this.ar.c + this.ar.f) / 2.0D;
			this.at = var11 != var1 || var15 != var5;
			this.au = var13 != var3;
			this.as = var13 != var3 && var13 < 0.0D;
			this.av = this.at || this.au;
			if(this.as) {
				if(this.aE > 0.0F) {
					this.c(this.aE);
					this.aE = 0.0F;
				}
			} else if(var3 < 0.0D) {
				this.aE = (float)((double)this.aE - var3);
			}

			if(var11 != var1) {
				this.ak = 0.0D;
			}

			if(var13 != var3) {
				this.al = 0.0D;
			}

			if(var15 != var5) {
				this.am = 0.0D;
			}

			var35 = this.ah - var7;
			var22 = this.aj - var9;
			this.aC = (float)((double)this.aC + (double)ModelPig.a(var35 * var35 + var22 * var22) * 0.6D);
			int var25;
			int var36;
			int var38;
			if(this.aD) {
				var36 = ModelPig.b(this.ah);
				var25 = ModelPig.b(this.ai - (double)0.2F - (double)this.ay);
				var38 = ModelPig.b(this.aj);
				var27 = this.ad.a(var36, var25, var38);
				if(this.aC > (float)this.timeSinceHit && var27 > 0) {
					++this.timeSinceHit;
					RenderTNTPrimed var28 = ln.n[var27].bj;
					if(this.ad.a(var36, var25 + 1, var38) == ln.aS.ba) {
						var28 = ln.aS.bj;
						this.ad.a(this, var28.d(), var28.b() * 0.15F, var28.c());
					} else if(!ln.n[var27].bl.d()) {
						this.ad.a(this, var28.d(), var28.b() * 0.15F, var28.c());
					}

					ln.n[var27].a(this.ad, var36, var25, var38, this);
				}
			}

			var36 = ModelPig.b(this.ar.a);
			var25 = ModelPig.b(this.ar.b);
			var38 = ModelPig.b(this.ar.c);
			var27 = ModelPig.b(this.ar.d);
			int var39 = ModelPig.b(this.ar.e);
			int var29 = ModelPig.b(this.ar.f);

			for(int var30 = var36; var30 <= var27; ++var30) {
				for(int var31 = var25; var31 <= var39; ++var31) {
					for(int var32 = var38; var32 <= var29; ++var32) {
						int var33 = this.ad.a(var30, var31, var32);
						if(var33 > 0) {
							ln.n[var33].b(this.ad, var30, var31, var32, this);
						}
					}
				}
			}

			this.aI *= 0.4F;
			boolean var37 = this.g_();
			if(this.ad.c(this.ar)) {
				this.a(1);
				if(!var37) {
					++this.aQ;
					if(this.aQ == 0) {
						this.aQ = 300;
					}
				}
			} else if(this.aQ <= 0) {
				this.aQ = -this.aP;
			}

			if(var37 && this.aQ > 0) {
				this.ad.a(this, "random.fizz", 0.7F, 1.6F + (this.aN.nextFloat() - this.aN.nextFloat()) * 0.4F);
				this.aQ = -this.aP;
			}

		}
	}

	public EntityRenderer f_() {
		return null;
	}

	protected void a(int var1) {
		this.a((EntityMinecart)null, var1);
	}

	protected void c(float var1) {
	}

	public boolean g_() {
		return this.ad.a(this.ar.b(0.0D, -0.4000000059604645D, 0.0D), EntitySkeleton.f, this);
	}

	public boolean a(EntitySkeleton var1) {
		double var2 = this.ai + (double)this.q();
		int var4 = ModelPig.b(this.ah);
		int var5 = ModelPig.d((float)ModelPig.b(var2));
		int var6 = ModelPig.b(this.aj);
		int var7 = this.ad.a(var4, var5, var6);
		if(var7 != 0 && ln.n[var7].bl == var1) {
			float var8 = EntityFX.b(this.ad.e(var4, var5, var6)) - 0.11111111F;
			float var9 = (float)(var5 + 1) - var8;
			return var2 < (double)var9;
		} else {
			return false;
		}
	}

	protected float q() {
		return 0.0F;
	}

	public boolean E() {
		return this.ad.a(this.ar.b(0.0D, -0.4000000059604645D, 0.0D), EntitySkeleton.g);
	}

	public void a(float var1, float var2, float var3) {
		float var4 = ModelPig.c(var1 * var1 + var2 * var2);
		if(var4 >= 0.01F) {
			if(var4 < 1.0F) {
				var4 = 1.0F;
			}

			var4 = var3 / var4;
			var1 *= var4;
			var2 *= var4;
			float var5 = ModelPig.a(this.an * (float)Math.PI / 180.0F);
			float var6 = ModelPig.b(this.an * (float)Math.PI / 180.0F);
			this.ak += (double)(var1 * var6 - var2 * var5);
			this.am += (double)(var2 * var6 + var1 * var5);
		}
	}

	public float a(float var1) {
		int var2 = ModelPig.b(this.ah);
		double var3 = (this.ar.e - this.ar.b) * 0.66D;
		int var5 = ModelPig.b(this.ai - (double)this.ay + var3);
		int var6 = ModelPig.b(this.aj);
		return this.ad.c(var2, var5, var6);
	}

	public void a(EntitySpider var1) {
		this.ad = var1;
	}

	public void b(double var1, double var3, double var5, float var7, float var8) {
		this.ae = this.ah = var1;
		this.af = this.ai = var3;
		this.ag = this.aj = var5;
		this.an = var7;
		this.ao = var8;
		this.aI = 0.0F;
		double var9 = (double)(this.ap - var7);
		if(var9 < -180.0D) {
			this.ap += 360.0F;
		}

		if(var9 >= 180.0D) {
			this.ap -= 360.0F;
		}

		this.a(this.ah, this.ai, this.aj);
	}

	public void c(double var1, double var3, double var5, float var7, float var8) {
		this.ae = this.ah = var1;
		this.af = this.ai = var3 + (double)this.ay;
		this.ag = this.aj = var5;
		this.an = var7;
		this.ao = var8;
		this.a(this.ah, this.ai, this.aj);
	}

	public float d(EntityMinecart var1) {
		float var2 = (float)(this.ah - var1.ah);
		float var3 = (float)(this.ai - var1.ai);
		float var4 = (float)(this.aj - var1.aj);
		return ModelPig.c(var2 * var2 + var3 * var3 + var4 * var4);
	}

	public double d(double var1, double var3, double var5) {
		double var7 = this.ah - var1;
		double var9 = this.ai - var3;
		double var11 = this.aj - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public double e(double var1, double var3, double var5) {
		double var7 = this.ah - var1;
		double var9 = this.ai - var3;
		double var11 = this.aj - var5;
		return (double)ModelPig.a(var7 * var7 + var9 * var9 + var11 * var11);
	}

	public double e(EntityMinecart var1) {
		double var2 = this.ah - var1.ah;
		double var4 = this.ai - var1.ai;
		double var6 = this.aj - var1.aj;
		return var2 * var2 + var4 * var4 + var6 * var6;
	}

	public void b(BlockMobSpawner var1) {
	}

	public void f(EntityMinecart var1) {
		if(var1.ab != this && var1.ac != this) {
			double var2 = var1.ah - this.ah;
			double var4 = var1.aj - this.aj;
			double var6 = ModelPig.a(var2, var4);
			if(var6 >= (double)0.01F) {
				var6 = (double)ModelPig.a(var6);
				var2 /= var6;
				var4 /= var6;
				double var8 = 1.0D / var6;
				if(var8 > 1.0D) {
					var8 = 1.0D;
				}

				var2 *= var8;
				var4 *= var8;
				var2 *= (double)0.05F;
				var4 *= (double)0.05F;
				var2 *= (double)(1.0F - this.aL);
				var4 *= (double)(1.0F - this.aL);
				this.f(-var2, 0.0D, -var4);
				var1.f(var2, 0.0D, var4);
			}

		}
	}

	public void f(double var1, double var3, double var5) {
		this.ak += var1;
		this.al += var3;
		this.am += var5;
	}

	public boolean a(EntityMinecart var1, int var2) {
		return false;
	}

	public boolean c_() {
		return false;
	}

	public boolean d_() {
		return false;
	}

	public void b(EntityMinecart var1, int var2) {
	}

	public boolean a(BlockTNT var1) {
		double var2 = this.ah - var1.a;
		double var4 = this.ai - var1.b;
		double var6 = this.aj - var1.c;
		double var8 = var2 * var2 + var4 * var4 + var6 * var6;
		return this.a(var8);
	}

	public boolean a(double var1) {
		double var3 = this.ar.b();
		var3 *= 64.0D;
		return var1 < var3 * var3;
	}

	public String v() {
		return null;
	}

	public boolean c(EntityItem var1) {
		String var2 = this.F();
		if(!this.ax && var2 != null) {
			var1.a("id", var2);
			this.d(var1);
			return true;
		} else {
			return false;
		}
	}

	public void d(EntityItem var1) {
		var1.a("Pos", (EnumSkyBlock)this.a(new double[]{this.ah, this.ai, this.aj}));
		var1.a("Motion", (EnumSkyBlock)this.a(new double[]{this.ak, this.al, this.am}));
		var1.a("Rotation", (EnumSkyBlock)this.a(new float[]{this.an, this.ao}));
		var1.a("FallDistance", this.aE);
		var1.a("Fire", (short)this.aQ);
		var1.a("Air", (short)this.aU);
		var1.a("OnGround", this.as);
		this.a(var1);
	}

	public void e(EntityItem var1) {
		ItemPainting var2 = var1.l("Pos");
		ItemPainting var3 = var1.l("Motion");
		ItemPainting var4 = var1.l("Rotation");
		this.a(0.0D, 0.0D, 0.0D);
		this.ak = ((MovementInputFromOptions)var3.a(0)).a;
		this.al = ((MovementInputFromOptions)var3.a(1)).a;
		this.am = ((MovementInputFromOptions)var3.a(2)).a;
		this.ae = this.aF = this.ah = ((MovementInputFromOptions)var2.a(0)).a;
		this.af = this.aG = this.ai = ((MovementInputFromOptions)var2.a(1)).a;
		this.ag = this.aH = this.aj = ((MovementInputFromOptions)var2.a(2)).a;
		this.ap = this.an = ((RenderPig)var4.a(0)).a;
		this.aq = this.ao = ((RenderPig)var4.a(1)).a;
		this.aE = var1.g("FallDistance");
		this.aQ = var1.d("Fire");
		this.aU = var1.d("Air");
		this.as = var1.m("OnGround");
		this.a(this.ah, this.ai, this.aj);
		this.b(var1);
	}

	protected final String F() {
		return EntityPickupFX.a(this);
	}

	protected abstract void b(EntityItem var1);

	protected abstract void a(EntityItem var1);

	protected ItemPainting a(double... var1) {
		ItemPainting var2 = new ItemPainting();
		double[] var3 = var1;
		int var4 = var1.length;

		for(int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.a((EnumSkyBlock)(new MovementInputFromOptions(var6)));
		}

		return var2;
	}

	protected ItemPainting a(float... var1) {
		ItemPainting var2 = new ItemPainting();
		float[] var3 = var1;
		int var4 = var1.length;

		for(int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.a((EnumSkyBlock)(new RenderPig(var6)));
		}

		return var2;
	}

	public float h_() {
		return this.aA / 2.0F;
	}

	public EffectRenderer b(int var1, int var2) {
		return this.a(var1, var2, 0.0F);
	}

	public EffectRenderer a(int var1, int var2, float var3) {
		EffectRenderer var4 = new EffectRenderer(this.ad, this.ah, this.ai + (double)var3, this.aj, new TileEntityFurnace(var1, var2));
		var4.c = 10;
		this.ad.a((EntityMinecart)var4);
		return var4;
	}

	public boolean z() {
		return !this.ax;
	}

	public boolean G() {
		int var1 = ModelPig.b(this.ah);
		int var2 = ModelPig.b(this.ai + (double)this.q());
		int var3 = ModelPig.b(this.aj);
		return this.ad.g(var1, var2, var3);
	}

	public boolean a(BlockMobSpawner var1) {
		return false;
	}

	public EntityRenderer b_(EntityMinecart var1) {
		return null;
	}

	public void n() {
		if(this.ac.ax) {
			this.ac = null;
		} else {
			this.ak = 0.0D;
			this.al = 0.0D;
			this.am = 0.0D;
			this.e_();
			this.ac.i_();
			this.e += (double)(this.ac.an - this.ac.ap);

			for(this.d += (double)(this.ac.ao - this.ac.aq); this.e >= 180.0D; this.e -= 360.0D) {
			}

			while(this.e < -180.0D) {
				this.e += 360.0D;
			}

			while(this.d >= 180.0D) {
				this.d -= 360.0D;
			}

			while(this.d < -180.0D) {
				this.d += 360.0D;
			}

			double var1 = this.e * 0.5D;
			double var3 = this.d * 0.5D;
			float var5 = 10.0F;
			if(var1 > (double)var5) {
				var1 = (double)var5;
			}

			if(var1 < (double)(-var5)) {
				var1 = (double)(-var5);
			}

			if(var3 > (double)var5) {
				var3 = (double)var5;
			}

			if(var3 < (double)(-var5)) {
				var3 = (double)(-var5);
			}

			this.e -= var1;
			this.d -= var3;
			this.an = (float)((double)this.an + var1);
			this.ao = (float)((double)this.ao + var3);
		}
	}

	protected void i_() {
		this.ab.a(this.ah, this.ai + this.j_() + this.ab.t(), this.aj);
	}

	public double t() {
		return (double)this.ay;
	}

	public double j_() {
		return (double)this.aA * 0.75D;
	}

	public void g(EntityMinecart var1) {
		this.d = 0.0D;
		this.e = 0.0D;
		if(this.ac == var1) {
			this.ac.ab = null;
			this.ac = null;
			this.c(var1.ah, var1.ar.b + (double)var1.aA, var1.aj, this.an, this.ao);
		} else {
			if(this.ac != null) {
				this.ac.ab = null;
			}

			if(var1.ab != null) {
				var1.ab.ac = null;
			}

			this.ac = var1;
			var1.ab = this;
		}
	}

	public void a(double var1, double var3, double var5, float var7, float var8, int var9) {
		this.a(var1, var3, var5);
		this.c(var7, var8);
	}
}
