package net.minecraft.src;

import java.util.List;

public class BlockMobSpawner extends RecipesIngots {
	public BlockStone b = new BlockStone(this);
	public byte c = 0;
	public int d = 0;
	public float e;
	public float f;
	public boolean g = false;
	public int h = 0;
	public String i;
	private int a = 0;
	public int hunger = 0;

	public BlockMobSpawner(EntitySpider var1) {
		super(var1);
		this.ay = 1.62F;
		this.c((double)var1.n + 0.5D, (double)(var1.o + 1), (double)var1.p + 0.5D, 0.0F, 0.0F);
		this.D = 20;
		this.x = "humanoid";
		this.w = 180.0F;
		this.aP = 20;
		this.u = "/char.png";
	}

	public void n() {
		super.n();
		this.e = this.f;
		this.f = 0.0F;
	}

	public void o() {
		this.ay = 1.62F;
		this.a(0.6F, 1.8F);
		super.o();
		this.D = 20;
		this.I = 0;
	}

	protected void b_() {
		if(this.g) {
			++this.h;
			if(this.h == 8) {
				this.h = 0;
				this.g = false;
			}
		} else {
			this.h = 0;
		}

		this.C = (float)this.h / 8.0F;
	}

	public void i() {
		++this.hunger;
		if(this.hunger >= 1200) {
			this.a((EntityMinecart)null, 2);
			this.hunger = 0;
		}

		if(this.ad.k == 0 && this.D < 20 && this.aO % 20 * 4 == 0) {
			this.b(1);
		}

		this.b.f();
		this.e = this.f;
		super.i();
		float var1 = ModelPig.a(this.ak * this.ak + this.am * this.am);
		float var2 = (float)Math.atan(-this.al * (double)0.2F) * 15.0F;
		if(var1 > 0.1F) {
			var1 = 0.1F;
		}

		if(!this.as || this.D <= 0) {
			var1 = 0.0F;
		}

		if(this.as || this.D <= 0) {
			var2 = 0.0F;
		}

		this.f += (var1 - this.f) * 0.4F;
		this.L += (var2 - this.L) * 0.8F;
		if(this.D > 0) {
			List var3 = this.ad.b((EntityMinecart)this, (EntityRenderer)this.ar.b(1.0D, 0.0D, 1.0D));
			if(var3 != null) {
				for(int var4 = 0; var4 < var3.size(); ++var4) {
					this.h((EntityMinecart)var3.get(var4));
				}
			}
		}

	}

	private void h(EntityMinecart var1) {
		var1.b(this);
	}

	public int p() {
		return this.d;
	}

	public void b(EntityMinecart var1) {
		this.a(0.2F, 0.2F);
		this.a(this.ah, this.ai, this.aj);
		this.al = (double)0.1F;
		if(this.i.equals("Notch")) {
			this.a(new TileEntityFurnace(EntityTNTPrimed.h, 1), true);
		}

		this.b.h();
		if(var1 != null) {
			this.ak = (double)(-ModelPig.b((this.H + this.an) * (float)Math.PI / 180.0F) * 0.1F);
			this.am = (double)(-ModelPig.a((this.H + this.an) * (float)Math.PI / 180.0F) * 0.1F);
		} else {
			this.am = 0.0D;
			this.ak = 0.0D;
		}

		this.ay = 0.1F;
	}

	public void b(EntityMinecart var1, int var2) {
		this.d += var2;
	}

	public void a(TileEntityFurnace var1) {
		this.a(var1, false);
	}

	public void a(TileEntityFurnace var1, boolean var2) {
		if(var1 != null) {
			EffectRenderer var3 = new EffectRenderer(this.ad, this.ah, this.ai - (double)0.3F + (double)this.q(), this.aj, var1);
			var3.c = 40;
			if(var2) {
				float var4 = this.aN.nextFloat() * 0.5F;
				float var5 = this.aN.nextFloat() * (float)Math.PI * 2.0F;
				var3.ak = (double)(-ModelPig.a(var5) * var4);
				var3.am = (double)(ModelPig.b(var5) * var4);
				var3.al = (double)0.2F;
			} else {
				var3.ak = (double)(-ModelPig.a(this.an / 180.0F * (float)Math.PI) * ModelPig.b(this.ao / 180.0F * (float)Math.PI) * 0.3F);
				var3.am = (double)(ModelPig.b(this.an / 180.0F * (float)Math.PI) * ModelPig.b(this.ao / 180.0F * (float)Math.PI) * 0.3F);
				var3.al = (double)(-ModelPig.a(this.ao / 180.0F * (float)Math.PI) * 0.3F + 0.1F);
				float var6 = this.aN.nextFloat() * (float)Math.PI * 2.0F;
				float var7 = 0.02F * this.aN.nextFloat();
				var3.ak += Math.cos((double)var6) * (double)var7;
				var3.al += (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.1F);
				var3.am += Math.sin((double)var6) * (double)var7;
			}

			this.a(var3);
		}
	}

	protected void a(EffectRenderer var1) {
		this.ad.a((EntityMinecart)var1);
	}

	public float a(ln var1) {
		float var2 = this.b.a(var1);
		if(this.a((EntitySkeleton)EntitySkeleton.f)) {
			var2 /= 5.0F;
		}

		if(!this.as) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(ln var1) {
		return this.b.b(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void a(WorldIso var1) {
	}

	public void k() {
	}

	public void a_(EntityMinecart var1, int var2) {
	}

	protected float q() {
		return 0.12F;
	}

	public boolean a(EntityMinecart var1, int var2) {
		this.S = 0;
		if(this.D <= 0) {
			return false;
		} else if((float)this.aT > (float)this.j / 2.0F) {
			return false;
		} else {
			if(var1 instanceof IsoImageBuffer || var1 instanceof NBTTagEnd) {
				if(this.ad.k == 0) {
					var2 = 0;
				}

				if(this.ad.k == 1) {
					var2 = var2 / 3 + 1;
				}

				if(this.ad.k == 3) {
					var2 = var2 * 3 / 2;
				}
			}

			int var3 = var2 * (25 - this.b.g()) + this.a;
			this.b.e(var2);
			var2 = var3 / 25;
			this.a = var3 % 25;
			return var2 != 0 && super.a(var1, var2);
		}
	}

	public void a(Path var1) {
	}

	public void a(nn var1) {
	}

	public void a_(EntityMinecart var1) {
	}

	public TileEntityFurnace r() {
		return this.b.e();
	}

	public void s() {
		this.b.a(this.b.d, (TileEntityFurnace)null);
	}

	public double t() {
		return (double)(this.ay - 0.5F);
	}

	public void u() {
		this.h = -1;
		this.g = true;
	}
}
