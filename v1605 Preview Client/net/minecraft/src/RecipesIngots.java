package net.minecraft.src;

import java.util.List;

public class RecipesIngots extends EntityMinecart {
	public int j = 20;
	public float k;
	public float l;
	public float m;
	public float n = 0.0F;
	public float o = 0.0F;
	protected float p;
	protected float q;
	protected float r;
	protected float s;
	protected boolean t = true;
	protected String u = "/char.png";
	protected boolean v = true;
	protected float w = 0.0F;
	protected String x = null;
	protected float y = 1.0F;
	protected int z = 0;
	protected float A = 0.0F;
	public float B;
	public float C;
	public int D = 10;
	public int E;
	private int a;
	public int F;
	public int G;
	public float H = 0.0F;
	public int I = 0;
	public int J = 0;
	public float K;
	public float L;
	protected boolean M = false;
	public int N = -1;
	public float O = (float)(Math.random() * (double)0.9F + (double)0.1F);
	public float P;
	public float Q;
	public float R;
	protected int S = 0;
	protected float T;
	protected float U;
	protected float V;
	protected boolean W = false;
	protected float X = 0.0F;
	protected float Y = 0.7F;
	private EntityMinecart b;
	private int c = 0;

	public RecipesIngots(EntitySpider var1) {
		super(var1);
		this.aa = true;
		this.m = (float)(Math.random() + 1.0D) * 0.01F;
		this.a(this.ah, this.ai, this.aj);
		this.k = (float)Math.random() * 12398.0F;
		this.an = (float)(Math.random() * (double)(float)Math.PI * 2.0D);
		this.l = 1.0F;
		this.aJ = 0.5F;
	}

	protected boolean c(EntityMinecart var1) {
		return this.ad.a(BlockTNT.b(this.ah, this.ai + (double)this.q(), this.aj), BlockTNT.b(var1.ah, var1.ai + (double)var1.q(), var1.aj)) == null;
	}

	public String v() {
		return this.u;
	}

	public boolean c_() {
		return !this.ax;
	}

	public boolean d_() {
		return !this.ax;
	}

	protected float q() {
		return this.aA * 0.85F;
	}

	public int b() {
		return 80;
	}

	public void w() {
		this.B = this.C;
		super.w();
		if(this.aN.nextInt(1000) < this.a++) {
			this.a = -this.b();
			String var1 = this.c();
			if(var1 != null) {
				this.ad.a(this, var1, this.f(), (this.aN.nextFloat() - this.aN.nextFloat()) * 0.2F + 1.0F);
			}
		}

		if(this.z() && this.G()) {
			this.a((EntityMinecart)null, 1);
		}

		int var8;
		if(this.z() && this.a(EntitySkeleton.f)) {
			--this.aU;
			if(this.aU == -20) {
				this.aU = 0;

				for(var8 = 0; var8 < 8; ++var8) {
					float var2 = this.aN.nextFloat() - this.aN.nextFloat();
					float var3 = this.aN.nextFloat() - this.aN.nextFloat();
					float var4 = this.aN.nextFloat() - this.aN.nextFloat();
					this.ad.a("bubble", this.ah + (double)var2, this.ai + (double)var3, this.aj + (double)var4, this.ak, this.al, this.am);
				}

				this.a((EntityMinecart)null, 2);
			}

			this.aQ = 0;
		} else {
			this.aU = this.aR;
		}

		this.K = this.L;
		if(this.J > 0) {
			--this.J;
		}

		if(this.F > 0) {
			--this.F;
		}

		if(this.aT > 0) {
			--this.aT;
		}

		if(this.D <= 0) {
			++this.I;
			if(this.I > 20) {
				this.B();
				this.D();

				for(var8 = 0; var8 < 20; ++var8) {
					double var9 = this.aN.nextGaussian() * 0.02D;
					double var10 = this.aN.nextGaussian() * 0.02D;
					double var6 = this.aN.nextGaussian() * 0.02D;
					this.ad.a("explode", this.ah + (double)(this.aN.nextFloat() * this.az * 2.0F) - (double)this.az, this.ai + (double)(this.aN.nextFloat() * this.aA), this.aj + (double)(this.aN.nextFloat() * this.az * 2.0F) - (double)this.az, var9, var10, var6);
				}
			}
		}

		this.s = this.r;
		this.o = this.n;
		this.ap = this.an;
		this.aq = this.ao;
	}

	public void x() {
		for(int var1 = 0; var1 < 20; ++var1) {
			double var2 = this.aN.nextGaussian() * 0.02D;
			double var4 = this.aN.nextGaussian() * 0.02D;
			double var6 = this.aN.nextGaussian() * 0.02D;
			double var8 = 10.0D;
			this.ad.a("explode", this.ah + (double)(this.aN.nextFloat() * this.az * 2.0F) - (double)this.az - var2 * var8, this.ai + (double)(this.aN.nextFloat() * this.aA) - var4 * var8, this.aj + (double)(this.aN.nextFloat() * this.az * 2.0F) - (double)this.az - var6 * var8, var2, var4, var6);
		}

	}

	public void n() {
		super.n();
		this.p = this.q;
		this.q = 0.0F;
	}

	public void e_() {
		super.e_();
		this.i();
		double var1 = this.ah - this.ae;
		double var3 = this.aj - this.ag;
		float var5 = ModelPig.a(var1 * var1 + var3 * var3);
		float var6 = this.n;
		float var7 = 0.0F;
		this.p = this.q;
		float var8 = 0.0F;
		if(var5 > 0.05F) {
			var8 = 1.0F;
			var7 = var5 * 3.0F;
			var6 = (float)Math.atan2(var3, var1) * 180.0F / (float)Math.PI - 90.0F;
		}

		if(this.C > 0.0F) {
			var6 = this.an;
		}

		if(!this.as) {
			var8 = 0.0F;
		}

		this.q += (var8 - this.q) * 0.3F;

		float var9;
		for(var9 = var6 - this.n; var9 < -180.0F; var9 += 360.0F) {
		}

		while(var9 >= 180.0F) {
			var9 -= 360.0F;
		}

		this.n += var9 * 0.3F;

		float var10;
		for(var10 = this.an - this.n; var10 < -180.0F; var10 += 360.0F) {
		}

		while(var10 >= 180.0F) {
			var10 -= 360.0F;
		}

		boolean var11 = var10 < -90.0F || var10 >= 90.0F;
		if(var10 < -75.0F) {
			var10 = -75.0F;
		}

		if(var10 >= 75.0F) {
			var10 = 75.0F;
		}

		this.n = this.an - var10;
		if(var10 * var10 > 2500.0F) {
			this.n += var10 * 0.2F;
		}

		if(var11) {
			var7 *= -1.0F;
		}

		while(this.an - this.ap < -180.0F) {
			this.ap -= 360.0F;
		}

		while(this.an - this.ap >= 180.0F) {
			this.ap += 360.0F;
		}

		while(this.n - this.o < -180.0F) {
			this.o -= 360.0F;
		}

		while(this.n - this.o >= 180.0F) {
			this.o += 360.0F;
		}

		while(this.ao - this.aq < -180.0F) {
			this.aq -= 360.0F;
		}

		while(this.ao - this.aq >= 180.0F) {
			this.aq += 360.0F;
		}

		this.r += var7;
	}

	protected void a(float var1, float var2) {
		super.a(var1, var2);
	}

	public void b(int var1) {
		if(this.D > 0) {
			this.D += var1;
			if(this.D > 20) {
				this.D = 20;
			}

			this.aT = this.j / 2;
		}
	}

	public boolean a(EntityMinecart var1, int var2) {
		this.S = 0;
		if(this.D <= 0) {
			return false;
		} else {
			this.Q = 1.5F;
			if((float)this.aT > (float)this.j / 2.0F) {
				if(this.E - var2 >= this.D) {
					return false;
				}

				this.D = this.E - var2;
			} else {
				this.E = this.D;
				this.aT = this.j;
				this.D -= var2;
				this.F = this.G = 10;
			}

			this.H = 0.0F;
			if(var1 != null) {
				double var3 = var1.ah - this.ah;

				double var5;
				for(var5 = var1.aj - this.aj; var3 * var3 + var5 * var5 < 1.0E-4D; var5 = (Math.random() - Math.random()) * 0.01D) {
					var3 = (Math.random() - Math.random()) * 0.01D;
				}

				this.H = (float)(Math.atan2(var5, var3) * 180.0D / (double)(float)Math.PI) - this.an;
				this.a(var1, var2, var3, var5);
			} else {
				this.H = (float)((int)(Math.random() * 2.0D) * 180);
			}

			if(this.D <= 0) {
				this.ad.a(this, this.e(), this.f(), (this.aN.nextFloat() - this.aN.nextFloat()) * 0.2F + 1.0F);
				this.b(var1);
			} else {
				this.ad.a(this, this.d(), this.f(), (this.aN.nextFloat() - this.aN.nextFloat()) * 0.2F + 1.0F);
			}

			return true;
		}
	}

	protected float f() {
		return 1.0F;
	}

	protected String c() {
		return null;
	}

	protected String d() {
		return "random.hurt";
	}

	protected String e() {
		return "random.hurt";
	}

	public void a(EntityMinecart var1, int var2, double var3, double var5) {
		float var7 = ModelPig.a(var3 * var3 + var5 * var5);
		float var8 = 0.4F;
		this.ak /= 2.0D;
		this.al /= 2.0D;
		this.am /= 2.0D;
		this.ak -= var3 / (double)var7 * (double)var8;
		this.al += (double)0.4F;
		this.am -= var5 / (double)var7 * (double)var8;
		if(this.al > (double)0.4F) {
			this.al = (double)0.4F;
		}

	}

	public void b(EntityMinecart var1) {
		if(this.z > 0 && var1 != null) {
			var1.b(this, this.z);
		}

		this.M = true;
		int var2 = this.g();
		if(var2 > 0) {
			int var3 = this.aN.nextInt(3);

			for(int var4 = 0; var4 < var3; ++var4) {
				this.b(var2, 1);
			}
		}

	}

	protected int g() {
		return 0;
	}

	protected void c(float var1) {
		int var2 = (int)Math.ceil((double)(var1 - 3.0F));
		if(var2 > 0) {
			this.a((EntityMinecart)null, var2);
			int var3 = this.ad.a(ModelPig.b(this.ah), ModelPig.b(this.ai - (double)0.2F - (double)this.ay), ModelPig.b(this.aj));
			if(var3 > 0) {
				RenderTNTPrimed var4 = ln.n[var3].bj;
				this.ad.a(this, var4.d(), var4.b() * 0.5F, var4.c() * 0.75F);
			}
		}

	}

	public void b(float var1, float var2) {
		double var3;
		if(this.g_()) {
			var3 = this.ai;
			this.a(var1, var2, 0.02F);
			this.c(this.ak, this.al, this.am);
			this.ak *= (double)0.8F;
			this.al *= (double)0.8F;
			this.am *= (double)0.8F;
			this.al -= 0.02D;
			if(this.at && this.b(this.ak, this.al + (double)0.6F - this.ai + var3, this.am)) {
				this.al = (double)0.3F;
			}
		} else if(this.E()) {
			var3 = this.ai;
			this.a(var1, var2, 0.02F);
			this.c(this.ak, this.al, this.am);
			this.ak *= 0.5D;
			this.al *= 0.5D;
			this.am *= 0.5D;
			this.al -= 0.02D;
			if(this.at && this.b(this.ak, this.al + (double)0.6F - this.ai + var3, this.am)) {
				this.al = (double)0.3F;
			}
		} else {
			float var8 = 0.91F;
			if(this.as) {
				var8 = 0.54600006F;
				int var4 = this.ad.a(ModelPig.b(this.ah), ModelPig.b(this.ar.b) - 1, ModelPig.b(this.aj));
				if(var4 > 0) {
					var8 = ln.n[var4].bm * 0.91F;
				}
			}

			float var9 = 0.16277136F / (var8 * var8 * var8);
			this.a(var1, var2, this.as?0.1F * var9:0.02F);
			var8 = 0.91F;
			if(this.as) {
				var8 = 0.54600006F;
				int var5 = this.ad.a(ModelPig.b(this.ah), ModelPig.b(this.ar.b) - 1, ModelPig.b(this.aj));
				if(var5 > 0) {
					var8 = ln.n[var5].bm * 0.91F;
				}
			}

			if(this.y()) {
				this.aE = 0.0F;
				if(this.al < -0.15D) {
					this.al = -0.15D;
				}
			}

			this.c(this.ak, this.al, this.am);
			if(this.at && this.y()) {
				this.al = 0.2D;
			}

			this.al -= 0.08D;
			this.al *= (double)0.98F;
			this.ak *= (double)var8;
			this.am *= (double)var8;
		}

		this.P = this.Q;
		var3 = this.ah - this.ae;
		double var10 = this.aj - this.ag;
		float var7 = ModelPig.a(var3 * var3 + var10 * var10) * 4.0F;
		if(var7 > 1.0F) {
			var7 = 1.0F;
		}

		this.Q += (var7 - this.Q) * 0.4F;
		this.R += this.Q;
	}

	public boolean y() {
		int var1 = ModelPig.b(this.ah);
		int var2 = ModelPig.b(this.ar.b);
		int var3 = ModelPig.b(this.aj);
		return this.ad.a(var1, var2, var3) == ln.aF.ba || this.ad.a(var1, var2 + 1, var3) == ln.aF.ba;
	}

	public void a(EntityItem var1) {
		var1.a("Health", (short)this.D);
		var1.a("HurtTime", (short)this.F);
		var1.a("DeathTime", (short)this.I);
		var1.a("AttackTime", (short)this.J);
	}

	public void b(EntityItem var1) {
		this.D = var1.d("Health");
		if(!var1.b("Health")) {
			this.D = 10;
		}

		this.F = var1.d("HurtTime");
		this.I = var1.d("DeathTime");
		this.J = var1.d("AttackTime");
	}

	public boolean z() {
		return !this.ax && this.D > 0;
	}

	public void i() {
		if(this.D <= 0) {
			this.W = false;
			this.T = 0.0F;
			this.U = 0.0F;
			this.V = 0.0F;
		} else {
			this.b_();
		}

		boolean var1 = this.g_();
		boolean var2 = this.E();
		if(this.W) {
			if(var1) {
				this.al += (double)0.04F;
			} else if(var2) {
				this.al += (double)0.04F;
			} else if(this.as) {
				this.A();
			}
		}

		this.T *= 0.98F;
		this.U *= 0.98F;
		this.V *= 0.9F;
		this.b(this.T, this.U);
		List var3 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar.b((double)0.2F, 0.0D, (double)0.2F));
		if(var3 != null && var3.size() > 0) {
			for(int var4 = 0; var4 < var3.size(); ++var4) {
				EntityMinecart var5 = (EntityMinecart)var3.get(var4);
				if(var5.d_()) {
					var5.f(this);
				}
			}
		}

	}

	protected void A() {
		this.al = (double)0.42F;
	}

	protected void b_() {
		++this.S;
		BlockMobSpawner var1 = this.ad.a(this, -1.0D);
		if(var1 != null) {
			double var2 = var1.ah - this.ah;
			double var4 = var1.ai - this.ai;
			double var6 = var1.aj - this.aj;
			double var8 = var2 * var2 + var4 * var4 + var6 * var6;
			if(var8 > 16384.0D) {
				this.D();
			}

			if(this.S > 600 && this.aN.nextInt(800) == 0) {
				if(var8 < 1024.0D) {
					this.S = 0;
				} else {
					this.D();
				}
			}
		}

		this.T = 0.0F;
		this.U = 0.0F;
		float var10 = 8.0F;
		if(this.aN.nextFloat() < 0.02F) {
			var1 = this.ad.a(this, (double)var10);
			if(var1 != null) {
				this.b = var1;
				this.c = 10 + this.aN.nextInt(20);
			} else {
				this.V = (this.aN.nextFloat() - 0.5F) * 20.0F;
			}
		}

		if(this.b != null) {
			this.b(this.b, 10.0F);
			if(this.c-- <= 0 || this.b.ax || this.b.e((EntityMinecart)this) > (double)(var10 * var10)) {
				this.b = null;
			}
		} else {
			if(this.aN.nextFloat() < 0.05F) {
				this.V = (this.aN.nextFloat() - 0.5F) * 20.0F;
			}

			this.an += this.V;
			this.ao = this.X;
		}

		boolean var3 = this.g_();
		boolean var11 = this.E();
		if(var3 || var11) {
			this.W = this.aN.nextFloat() < 0.8F;
		}

	}

	public void b(EntityMinecart var1, float var2) {
		double var3 = var1.ah - this.ah;
		double var7 = var1.aj - this.aj;
		double var5;
		if(var1 instanceof RecipesIngots) {
			RecipesIngots var9 = (RecipesIngots)var1;
			var5 = var9.ai + (double)var9.q() - (this.ai + (double)this.q());
		} else {
			var5 = (var1.ar.b + var1.ar.e) / 2.0D - (this.ai + (double)this.q());
		}

		double var13 = (double)ModelPig.a(var3 * var3 + var7 * var7);
		float var11 = (float)(Math.atan2(var7, var3) * 180.0D / (double)(float)Math.PI) - 90.0F;
		float var12 = (float)(Math.atan2(var5, var13) * 180.0D / (double)(float)Math.PI);
		this.ao = this.b(this.ao, var12, var2);
		this.an = this.b(this.an, var11, var2);
	}

	private float b(float var1, float var2, float var3) {
		float var4;
		for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
		}

		while(var4 >= 180.0F) {
			var4 -= 360.0F;
		}

		if(var4 > var3) {
			var4 = var3;
		}

		if(var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	public void B() {
	}

	public boolean a() {
		return this.ad.a(this.ar) && this.ad.a((EntityMinecart)this, (EntityRenderer)this.ar).size() == 0 && !this.ad.b(this.ar);
	}

	protected void C() {
		this.a((EntityMinecart)null, 4);
	}

	public float d(float var1) {
		float var2 = this.C - this.B;
		if(var2 < 0.0F) {
			++var2;
		}

		return this.B + var2 * var1;
	}

	public BlockTNT e(float var1) {
		if(var1 == 1.0F) {
			return BlockTNT.b(this.ah, this.ai, this.aj);
		} else {
			double var2 = this.ae + (this.ah - this.ae) * (double)var1;
			double var4 = this.af + (this.ai - this.af) * (double)var1;
			double var6 = this.ag + (this.aj - this.ag) * (double)var1;
			return BlockTNT.b(var2, var4, var6);
		}
	}

	public BlockTNT f(float var1) {
		float var2;
		float var3;
		float var4;
		float var5;
		if(var1 == 1.0F) {
			var2 = ModelPig.b(-this.an * 0.017453292F - (float)Math.PI);
			var3 = ModelPig.a(-this.an * 0.017453292F - (float)Math.PI);
			var4 = -ModelPig.b(-this.ao * 0.017453292F);
			var5 = ModelPig.a(-this.ao * 0.017453292F);
			return BlockTNT.b((double)(var3 * var4), (double)var5, (double)(var2 * var4));
		} else {
			var2 = this.aq + (this.ao - this.aq) * var1;
			var3 = this.ap + (this.an - this.ap) * var1;
			var4 = ModelPig.b(-var3 * 0.017453292F - (float)Math.PI);
			var5 = ModelPig.a(-var3 * 0.017453292F - (float)Math.PI);
			float var6 = -ModelPig.b(-var2 * 0.017453292F);
			float var7 = ModelPig.a(-var2 * 0.017453292F);
			return BlockTNT.b((double)(var5 * var6), (double)var7, (double)(var4 * var6));
		}
	}

	public lv a(double var1, float var3) {
		BlockTNT var4 = this.e(var3);
		BlockTNT var5 = this.f(var3);
		BlockTNT var6 = var4.c(var5.a * var1, var5.b * var1, var5.c * var1);
		return this.ad.a(var4, var6);
	}
}
