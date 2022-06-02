package net.minecraft.src;

public class BlockStairs extends EntityMinecart {
	public int a;
	public int b = 0;

	public BlockStairs(EntitySpider var1) {
		super(var1);
	}

	public BlockStairs(EntitySpider var1, float var2, float var3, float var4, int var5) {
		super(var1);
		this.a = var5;
		this.aa = true;
		this.a(0.98F, 0.98F);
		this.ay = this.aA / 2.0F;
		this.a((double)var2, (double)var3, (double)var4);
		this.ak = 0.0D;
		this.al = 0.0D;
		this.am = 0.0D;
		this.aD = false;
		this.ae = (double)var2;
		this.af = (double)var3;
		this.ag = (double)var4;
	}

	public boolean c_() {
		return !this.ax;
	}

	public void e_() {
		if(this.a == 0) {
			this.D();
		} else {
			this.ae = this.ah;
			this.af = this.ai;
			this.ag = this.aj;
			++this.b;
			this.al -= (double)0.04F;
			this.c(this.ak, this.al, this.am);
			this.ak *= (double)0.98F;
			this.al *= (double)0.98F;
			this.am *= (double)0.98F;
			int var1 = ModelPig.b(this.ah);
			int var2 = ModelPig.b(this.ai);
			int var3 = ModelPig.b(this.aj);
			if(this.ad.a(var1, var2, var3) == this.a) {
				this.ad.d(var1, var2, var3, 0);
			}

			if(this.as) {
				this.ak *= (double)0.7F;
				this.am *= (double)0.7F;
				this.al *= -0.5D;
				this.D();
				if(!this.ad.a(this.a, var1, var2, var3, true) || !this.ad.d(var1, var2, var3, this.a)) {
					this.b(this.a, 1);
				}
			} else if(this.b > 100) {
				this.b(this.a, 1);
				this.D();
			}

		}
	}

	protected void a(EntityItem var1) {
		var1.a("Tile", (byte)this.a);
	}

	protected void b(EntityItem var1) {
		this.a = var1.c("Tile") & 255;
	}

	public float h_() {
		return 0.0F;
	}

	public EntitySpider i() {
		return this.ad;
	}
}
