package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class ll {
	private float[] a = new float[768];
	private int[] b = new int[5120];
	private int[] c = new int[5120];
	private int[] d = new int[5120];
	private int[] e = new int[5120];
	private int[] f = new int[34];
	private int[] g = new int[768];

	public ll() {
		try {
			BufferedImage var1 = ImageIO.read(ll.class.getResource("/terrain.png"));
			int[] var2 = new int[65536];
			var1.getRGB(0, 0, 256, 256, var2, 0, 256);

			for(int var3 = 0; var3 < 256; ++var3) {
				int var4 = 0;
				int var5 = 0;
				int var6 = 0;
				int var7 = var3 % 16 * 16;
				int var8 = var3 / 16 * 16;
				int var9 = 0;

				for(int var10 = 0; var10 < 16; ++var10) {
					for(int var11 = 0; var11 < 16; ++var11) {
						int var12 = var2[var11 + var7 + (var10 + var8) * 256];
						int var13 = var12 >> 24 & 255;
						if(var13 > 128) {
							var4 += var12 >> 16 & 255;
							var5 += var12 >> 8 & 255;
							var6 += var12 & 255;
							++var9;
						}
					}

					if(var9 == 0) {
						++var9;
					}

					this.a[var3 * 3 + 0] = (float)(var4 / var9);
					this.a[var3 * 3 + 1] = (float)(var5 / var9);
					this.a[var3 * 3 + 2] = (float)(var6 / var9);
				}
			}
		} catch (IOException var14) {
			var14.printStackTrace();
		}

		for(int var15 = 0; var15 < 256; ++var15) {
			if(ln.n[var15] != null) {
				this.g[var15 * 3 + 0] = ln.n[var15].getGLCallListForPass(1);
				this.g[var15 * 3 + 1] = ln.n[var15].getGLCallListForPass(2);
				this.g[var15 * 3 + 2] = ln.n[var15].getGLCallListForPass(3);
			}
		}

	}

	public void a(ModelBase var1) {
		EntitySpider var2 = var1.b;
		if(var2 == null) {
			var1.f = true;
			var1.e = true;
		} else {
			int var3 = var1.c * 16;
			int var4 = var1.d * 16;
			int var5 = var3 + 16;
			int var6 = var4 + 16;
			BlockMushroom var7 = var2.b(var1.c, var1.d);
			if(var7.q) {
				var1.f = true;
				var1.e = true;
			} else {
				var1.f = false;
				Arrays.fill(this.c, 0);
				Arrays.fill(this.d, 0);
				Arrays.fill(this.f, 160);

				for(int var8 = var6 - 1; var8 >= var4; --var8) {
					for(int var9 = var5 - 1; var9 >= var3; --var9) {
						int var10 = var9 - var3;
						int var11 = var8 - var4;
						int var12 = var10 + var11;
						boolean var13 = true;

						for(int var14 = 0; var14 < 128; ++var14) {
							int var15 = var11 - var10 - var14 + 160 - 16;
							if(var15 < this.f[var12] || var15 < this.f[var12 + 1]) {
								ln var16 = ln.n[var2.a(var9, var14, var8)];
								if(var16 == null) {
									var13 = false;
								} else if(var16.bl == EntitySkeleton.f) {
									int var17 = var2.a(var9, var14 + 1, var8);
									if(var17 == 0 || ln.n[var17].bl != EntitySkeleton.f) {
										float var18 = (float)var14 / 127.0F * 0.6F + 0.4F;
										float var19 = var2.c(var9, var14 + 1, var8) * var18;
										if(var15 >= 0 && var15 < 160) {
											int var20 = var12 + var15 * 32;
											if(var12 >= 0 && var12 <= 32 && this.d[var20] <= var14) {
												this.d[var20] = var14;
												this.e[var20] = (int)(var19 * 127.0F);
											}

											if(var12 >= -1 && var12 <= 31 && this.d[var20 + 1] <= var14) {
												this.d[var20 + 1] = var14;
												this.e[var20 + 1] = (int)(var19 * 127.0F);
											}

											var13 = false;
										}
									}
								} else {
									if(var13) {
										if(var15 < this.f[var12]) {
											this.f[var12] = var15;
										}

										if(var15 < this.f[var12 + 1]) {
											this.f[var12 + 1] = var15;
										}
									}

									float var24 = (float)var14 / 127.0F * 0.6F + 0.4F;
									float var22;
									int var25;
									int var26;
									float var27;
									if(var15 >= 0 && var15 < 160) {
										var25 = var12 + var15 * 32;
										var26 = this.g[var16.ba * 3 + 0];
										var27 = (var2.c(var9, var14 + 1, var8) * 0.8F + 0.2F) * var24;
										if(var12 >= 0 && this.c[var25] <= var14) {
											this.c[var25] = var14;
											this.b[var25] = 0xFF000000 | (int)(this.a[var26 * 3 + 0] * var27) << 16 | (int)(this.a[var26 * 3 + 1] * var27) << 8 | (int)(this.a[var26 * 3 + 2] * var27);
										}

										if(var12 < 31) {
											var22 = var27 * 0.9F;
											if(this.c[var25 + 1] <= var14) {
												this.c[var25 + 1] = var14;
												this.b[var25 + 1] = 0xFF000000 | (int)(this.a[var26 * 3 + 0] * var22) << 16 | (int)(this.a[var26 * 3 + 1] * var22) << 8 | (int)(this.a[var26 * 3 + 2] * var22);
											}
										}
									}

									if(var15 >= -1 && var15 < 159) {
										var25 = var12 + (var15 + 1) * 32;
										var26 = this.g[var16.ba * 3 + 1];
										var27 = var2.c(var9 - 1, var14, var8) * 0.8F + 0.2F;
										int var21 = this.g[var16.ba * 3 + 2];
										var22 = var2.c(var9, var14, var8 + 1) * 0.8F + 0.2F;
										float var23;
										if(var12 >= 0) {
											var23 = var27 * var24 * 0.6F;
											if(this.c[var25] <= var14 - 1) {
												this.c[var25] = var14 - 1;
												this.b[var25] = 0xFF000000 | (int)(this.a[var26 * 3 + 0] * var23) << 16 | (int)(this.a[var26 * 3 + 1] * var23) << 8 | (int)(this.a[var26 * 3 + 2] * var23);
											}
										}

										if(var12 < 31) {
											var23 = var22 * 0.9F * var24 * 0.4F;
											if(this.c[var25 + 1] <= var14 - 1) {
												this.c[var25 + 1] = var14 - 1;
												this.b[var25 + 1] = 0xFF000000 | (int)(this.a[var21 * 3 + 0] * var23) << 16 | (int)(this.a[var21 * 3 + 1] * var23) << 8 | (int)(this.a[var21 * 3 + 2] * var23);
											}
										}
									}
								}
							}
						}
					}
				}

				this.a();
				if(var1.a == null) {
					var1.a = new BufferedImage(32, 160, 2);
				}

				var1.a.setRGB(0, 0, 32, 160, this.b, 0, 32);
				var1.e = true;
			}
		}
	}

	private void a() {
		for(int var1 = 0; var1 < 32; ++var1) {
			for(int var2 = 0; var2 < 160; ++var2) {
				int var3 = var1 + var2 * 32;
				if(this.c[var3] == 0) {
					this.b[var3] = 0;
				}

				if(this.d[var3] > this.c[var3]) {
					int var4 = this.b[var3] >> 24 & 255;
					this.b[var3] = ((this.b[var3] & 16711422) >> 1) + this.e[var3];
					if(var4 < 128) {
						this.b[var3] = Integer.MIN_VALUE + this.e[var3] * 2;
					} else {
						this.b[var3] |= 0xFF000000;
					}
				}
			}
		}

	}
}
