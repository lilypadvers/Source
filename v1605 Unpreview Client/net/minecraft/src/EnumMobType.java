package net.minecraft.src;

public class EnumMobType extends BlockLeavesBase {
	protected float[] f = new float[256];
	protected float[] g = new float[256];
	protected float[] h = new float[256];
	protected float[] i = new float[256];
	int j = 0;

	public EnumMobType() {
		super(ln.C.aZ + 1);
		this.e = 2;
	}

	public void a() {
		++this.j;

		int var2;
		float var3;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		for(int var1 = 0; var1 < 16; ++var1) {
			for(var2 = 0; var2 < 16; ++var2) {
				var3 = 0.0F;
				int var4 = (int)(ModelPig.a((float)var2 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);
				var5 = (int)(ModelPig.a((float)var1 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);

				for(var6 = var1 - 1; var6 <= var1 + 1; ++var6) {
					for(var7 = var2 - 1; var7 <= var2 + 1; ++var7) {
						var8 = var6 + var4 & 15;
						var9 = var7 + var5 & 15;
						var3 += this.f[var8 + var9 * 16];
					}
				}

				this.g[var1 + var2 * 16] = var3 / 10.0F + (this.h[(var1 + 0 & 15) + (var2 + 0 & 15) * 16] + this.h[(var1 + 1 & 15) + (var2 + 0 & 15) * 16] + this.h[(var1 + 1 & 15) + (var2 + 1 & 15) * 16] + this.h[(var1 + 0 & 15) + (var2 + 1 & 15) * 16]) / 4.0F * 0.8F;
				this.h[var1 + var2 * 16] += this.i[var1 + var2 * 16] * 0.01F;
				if(this.h[var1 + var2 * 16] < 0.0F) {
					this.h[var1 + var2 * 16] = 0.0F;
				}

				this.i[var1 + var2 * 16] -= 0.06F;
				if(Math.random() < 0.005D) {
					this.i[var1 + var2 * 16] = 1.5F;
				}
			}
		}

		float[] var11 = this.g;
		this.g = this.f;
		this.f = var11;

		for(var2 = 0; var2 < 256; ++var2) {
			var3 = this.f[var2 - this.j / 3 * 16 & 255] * 2.0F;
			if(var3 > 1.0F) {
				var3 = 1.0F;
			}

			if(var3 < 0.0F) {
				var3 = 0.0F;
			}

			var5 = (int)(var3 * 100.0F + 155.0F);
			var6 = (int)(var3 * var3 * 255.0F);
			var7 = (int)(var3 * var3 * var3 * var3 * 128.0F);
			if(this.c) {
				var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
				var9 = (var5 * 30 + var6 * 70) / 100;
				int var10 = (var5 * 30 + var7 * 70) / 100;
				var5 = var8;
				var6 = var9;
				var7 = var10;
			}

			this.a[var2 * 4 + 0] = (byte)var5;
			this.a[var2 * 4 + 1] = (byte)var6;
			this.a[var2 * 4 + 2] = (byte)var7;
			this.a[var2 * 4 + 3] = -1;
		}

	}
}
