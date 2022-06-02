package net.minecraft.src;

public class EntityRainFX extends EntityMinecart {
	public int a;

	public EntityRainFX(EntitySpider var1) {
		super(var1);
		this.a = 0;
		this.aa = true;
		this.a(0.98F, 0.98F);
		this.ay = this.aA / 2.0F;
	}

	public EntityRainFX(EntitySpider var1, float var2, float var3, float var4) {
		this(var1);
		this.a((double)var2, (double)var3, (double)var4);
		float var5 = (float)(Math.random() * (double)(float)Math.PI * 2.0D);
		this.ak = (double)(-ModelPig.a(var5 * (float)Math.PI / 180.0F) * 0.02F);
		this.al = (double)0.2F;
		this.am = (double)(-ModelPig.b(var5 * (float)Math.PI / 180.0F) * 0.02F);
		this.aD = false;
		this.a = 80;
		this.ae = (double)var2;
		this.af = (double)var3;
		this.ag = (double)var4;
	}

	public boolean c_() {
		return !this.ax;
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		this.al -= (double)0.04F;
		this.c(this.ak, this.al, this.am);
		this.ak *= (double)0.98F;
		this.al *= (double)0.98F;
		this.am *= (double)0.98F;
		if(this.as) {
			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
			this.al *= -0.5D;
		}

		if(this.a-- <= 0) {
			this.D();
			this.i();
		} else {
			this.ad.a("smoke", this.ah, this.ai + 0.5D, this.aj, 0.0D, 0.0D, 0.0D);
		}

	}

	private void i() {
		float var1 = 4.0F;
		this.ad.a((EntityMinecart)null, this.ah, this.ai, this.aj, var1);
	}

	protected void a(EntityItem var1) {
		var1.a("Fuse", (byte)this.a);
	}

	protected void b(EntityItem var1) {
		this.a = var1.c("Fuse");
	}

	public float h_() {
		return 0.0F;
	}
}
