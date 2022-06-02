package net.minecraft.src;

public class ng extends BlockMobSpawner {
	private int bd;
	private double be;
	private double bf;
	private double bg;
	private double bh;
	private double bi;
	float a = 0.0F;

	public ng(EntitySpider var1, String var2) {
		super(var1);
		this.i = var2;
		this.ay = 0.0F;
		this.aJ = 0.0F;
		if(var2 != null && var2.length() > 0) {
			this.aV = "file:///C:/skincache/" + var2 + ".png";
			System.out.println("Loading texture " + this.aV);
		}

		this.aK = true;
	}

	public boolean a(EntityMinecart var1, int var2) {
		return true;
	}

	public void a(double var1, double var3, double var5, float var7, float var8, int var9) {
		this.ay = 0.0F;
		this.be = var1;
		this.bf = var3;
		this.bg = var5;
		this.bh = (double)var7;
		this.bi = (double)var8;
		this.bd = var9;
	}

	public void e_() {
		super.e_();
		this.P = this.Q;
		double var1 = this.ah - this.ae;
		double var3 = this.aj - this.ag;
		float var5 = ModelPig.a(var1 * var1 + var3 * var3) * 4.0F;
		if(var5 > 1.0F) {
			var5 = 1.0F;
		}

		this.Q += (var5 - this.Q) * 0.4F;
		this.R += this.Q;
	}

	public float h_() {
		return 0.0F;
	}

	public void i() {
		super.b_();
		if(this.bd > 0) {
			double var1 = this.ah + (this.be - this.ah) / (double)this.bd;
			double var3 = this.ai + (this.bf - this.ai) / (double)this.bd;
			double var5 = this.aj + (this.bg - this.aj) / (double)this.bd;

			double var7;
			for(var7 = this.bh - (double)this.an; var7 < -180.0D; var7 += 360.0D) {
			}

			while(var7 >= 180.0D) {
				var7 -= 360.0D;
			}

			this.an = (float)((double)this.an + var7 / (double)this.bd);
			this.ao = (float)((double)this.ao + (this.bi - (double)this.ao) / (double)this.bd);
			--this.bd;
			this.a(var1, var3, var5);
			this.c(this.an, this.ao);
		}

		this.e = this.f;
		float var9 = ModelPig.a(this.ak * this.ak + this.am * this.am);
		float var2 = (float)Math.atan(-this.al * (double)0.2F) * 15.0F;
		if(var9 > 0.1F) {
			var9 = 0.1F;
		}

		if(!this.as || this.D <= 0) {
			var9 = 0.0F;
		}

		if(this.as || this.D <= 0) {
			var2 = 0.0F;
		}

		this.f += (var9 - this.f) * 0.4F;
		this.L += (var2 - this.L) * 0.8F;
	}
}
