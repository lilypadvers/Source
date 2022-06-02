package net.minecraft.src;

public class IsoImageBuffer extends ModelSheepFur implements GuiOptions {
	protected int e = 2;

	public IsoImageBuffer(EntitySpider var1) {
		super(var1);
		this.D = 20;
	}

	public void i() {
		float var1 = this.a(1.0F);
		if(var1 > 0.5F) {
			this.S += 2;
		}

		super.i();
	}

	public void e_() {
		super.e_();
		if(this.ad.k == 0) {
			this.D();
		}

	}

	protected EntityMinecart h() {
		BlockMobSpawner var1 = this.ad.a(this, 16.0D);
		return var1 != null && this.c(var1)?var1:null;
	}

	public boolean a(EntityMinecart var1, int var2) {
		if(super.a(var1, var2)) {
			if(var1 != this) {
				this.f = var1;
			}

			return true;
		} else {
			return false;
		}
	}

	protected void a(EntityMinecart var1, float var2) {
		if((double)var2 < 2.5D && var1.ar.e > this.ar.b && var1.ar.b < this.ar.e) {
			this.J = 20;
			var1.a(this, this.e);
		}

	}

	protected float a(int var1, int var2, int var3) {
		return 0.5F - this.ad.c(var1, var2, var3);
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	public boolean a() {
		int var1 = ModelPig.b(this.ah);
		int var2 = ModelPig.b(this.ar.b);
		int var3 = ModelPig.b(this.aj);
		if(this.ad.a(PlayerControllerCreative.a, var1, var2, var3) > this.aN.nextInt(32)) {
			return false;
		} else {
			int var4 = this.ad.j(var1, var2, var3);
			return var4 <= this.aN.nextInt(8) && super.a();
		}
	}
}
