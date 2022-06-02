package net.minecraft.src;

public class TextureFlamesFX extends nd {
	float a;

	public TextureFlamesFX(EntitySpider var1, double var2, double var4, double var6) {
		this(var1, var2, var4, var6, 1.0F);
	}

	public TextureFlamesFX(EntitySpider var1, double var2, double var4, double var6, float var8) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.ak *= (double)0.1F;
		this.al *= (double)0.1F;
		this.am *= (double)0.1F;
		this.i = (float)(Math.random() * (double)0.3F) + 0.7F;
		this.j = this.k = (float)(Math.random() * (double)0.1F);
		this.g *= 0.75F;
		this.g *= var8;
		this.a = this.g;
		this.f = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
		this.f = (int)((float)this.f * var8);
		this.aK = false;
	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.e + var2) / (float)this.f * 32.0F;
		if(var8 < 0.0F) {
			var8 = 0.0F;
		}

		if(var8 > 1.0F) {
			var8 = 1.0F;
		}

		this.g = this.a * var8;
		super.a(var1, var2, var3, var4, var5, var6, var7);
	}

	public void e_() {
		this.ae = this.ah;
		this.af = this.ai;
		this.ag = this.aj;
		if(this.e++ >= this.f) {
			this.D();
		}

		this.b = 7 - this.e * 8 / this.f;
		this.c(this.ak, this.al, this.am);
		if(this.ai == this.af) {
			this.ak *= 1.1D;
			this.am *= 1.1D;
		}

		this.ak *= (double)0.96F;
		this.al *= (double)0.96F;
		this.am *= (double)0.96F;
		if(this.as) {
			this.ak *= (double)0.7F;
			this.am *= (double)0.7F;
		}

	}
}
