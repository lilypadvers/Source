package net.minecraft.src;

import java.util.Random;

public class ns extends ln {
	private int[] a = new int[256];
	private int[] b = new int[256];

	protected ns(int var1, int var2) {
		super(var1, var2, EntitySkeleton.l);
		this.a(ln.x.ba, 5, 20);
		this.a(ln.J.ba, 5, 5);
		this.a(ln.K.ba, 30, 60);
		this.a(ln.an.ba, 30, 20);
		this.a(ln.am.ba, 15, 100);
		this.a(ln.ab.ba, 30, 60);
		this.b(true);
	}

	private void a(int var1, int var2, int var3) {
		this.a[var1] = var2;
		this.b[var1] = var3;
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return null;
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int f() {
		return 3;
	}

	public int a(Random var1) {
		return 0;
	}

	public int a() {
		return 10;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		int var6 = var1.e(var2, var3, var4);
		if(var6 < 15) {
			var1.b(var2, var3, var4, var6 + 1);
			var1.h(var2, var3, var4, this.ba);
		}

		if(!this.h(var1, var2, var3, var4)) {
			if(!var1.g(var2, var3 - 1, var4) || var6 > 3) {
				var1.d(var2, var3, var4, 0);
			}

		} else if(!this.b(var1, var2, var3 - 1, var4) && var6 == 15 && var5.nextInt(4) == 0) {
			var1.d(var2, var3, var4, 0);
		} else {
			if(var6 % 2 == 0 && var6 > 2) {
				this.a(var1, var2 + 1, var3, var4, 300, var5);
				this.a(var1, var2 - 1, var3, var4, 300, var5);
				this.a(var1, var2, var3 - 1, var4, 200, var5);
				this.a(var1, var2, var3 + 1, var4, 250, var5);
				this.a(var1, var2, var3, var4 - 1, 300, var5);
				this.a(var1, var2, var3, var4 + 1, 300, var5);

				for(int var7 = var2 - 1; var7 <= var2 + 1; ++var7) {
					for(int var8 = var4 - 1; var8 <= var4 + 1; ++var8) {
						for(int var9 = var3 - 1; var9 <= var3 + 4; ++var9) {
							if(var7 != var2 || var9 != var3 || var8 != var4) {
								int var10 = 100;
								if(var9 > var3 + 1) {
									var10 += (var9 - (var3 + 1)) * 100;
								}

								int var11 = this.i(var1, var7, var9, var8);
								if(var11 > 0 && var5.nextInt(var10) <= var11) {
									var1.d(var7, var9, var8, this.ba);
								}
							}
						}
					}
				}
			}

		}
	}

	private void a(EntitySpider var1, int var2, int var3, int var4, int var5, Random var6) {
		int var7 = this.b[var1.a(var2, var3, var4)];
		if(var6.nextInt(var5) < var7) {
			boolean var8 = var1.a(var2, var3, var4) == ln.am.ba;
			if(var6.nextInt(2) == 0) {
				var1.d(var2, var3, var4, this.ba);
			} else {
				var1.d(var2, var3, var4, 0);
			}

			if(var8) {
				ln.am.b((EntitySpider)var1, var2, var3, var4, 0);
			}
		}

	}

	private boolean h(EntitySpider var1, int var2, int var3, int var4) {
		return this.b(var1, var2 + 1, var3, var4)?true:(this.b(var1, var2 - 1, var3, var4)?true:(this.b(var1, var2, var3 - 1, var4)?true:(this.b(var1, var2, var3 + 1, var4)?true:(this.b(var1, var2, var3, var4 - 1)?true:this.b(var1, var2, var3, var4 + 1)))));
	}

	private int i(EntitySpider var1, int var2, int var3, int var4) {
		byte var5 = 0;
		if(var1.a(var2, var3, var4) != 0) {
			return 0;
		} else {
			int var6 = this.g(var1, var2 + 1, var3, var4, var5);
			var6 = this.g(var1, var2 - 1, var3, var4, var6);
			var6 = this.g(var1, var2, var3 - 1, var4, var6);
			var6 = this.g(var1, var2, var3 + 1, var4, var6);
			var6 = this.g(var1, var2, var3, var4 - 1, var6);
			var6 = this.g(var1, var2, var3, var4 + 1, var6);
			return var6;
		}
	}

	public boolean h() {
		return false;
	}

	public boolean b(mz var1, int var2, int var3, int var4) {
		return this.a[var1.a(var2, var3, var4)] > 0;
	}

	public int g(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = this.a[var1.a(var2, var3, var4)];
		return var6 > var5?var6:var5;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return var1.g(var2, var3 - 1, var4) || this.h(var1, var2, var3, var4);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(!var1.g(var2, var3 - 1, var4) && !this.h(var1, var2, var3, var4)) {
			var1.d(var2, var3, var4, 0);
		}
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		if(!var1.g(var2, var3 - 1, var4) && !this.h(var1, var2, var3, var4)) {
			var1.d(var2, var3, var4, 0);
		} else {
			var1.h(var2, var3, var4, this.ba);
		}
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var5.nextInt(24) == 0) {
			var1.a((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "fire.fire", 1.0F + var5.nextFloat(), var5.nextFloat() * 0.7F + 0.3F);
		}

		int var6;
		float var7;
		float var8;
		float var9;
		if(!var1.g(var2, var3 - 1, var4) && !ln.ar.b(var1, var2, var3 - 1, var4)) {
			if(ln.ar.b(var1, var2 - 1, var3, var4)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)var2 + var5.nextFloat() * 0.1F;
					var8 = (float)var3 + var5.nextFloat();
					var9 = (float)var4 + var5.nextFloat();
					var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(ln.ar.b(var1, var2 + 1, var3, var4)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)(var2 + 1) - var5.nextFloat() * 0.1F;
					var8 = (float)var3 + var5.nextFloat();
					var9 = (float)var4 + var5.nextFloat();
					var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(ln.ar.b(var1, var2, var3, var4 - 1)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)var2 + var5.nextFloat();
					var8 = (float)var3 + var5.nextFloat();
					var9 = (float)var4 + var5.nextFloat() * 0.1F;
					var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(ln.ar.b(var1, var2, var3, var4 + 1)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)var2 + var5.nextFloat();
					var8 = (float)var3 + var5.nextFloat();
					var9 = (float)(var4 + 1) - var5.nextFloat() * 0.1F;
					var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(ln.ar.b(var1, var2, var3 + 1, var4)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)var2 + var5.nextFloat();
					var8 = (float)(var3 + 1) - var5.nextFloat() * 0.1F;
					var9 = (float)var4 + var5.nextFloat();
					var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for(var6 = 0; var6 < 3; ++var6) {
				var7 = (float)var2 + var5.nextFloat();
				var8 = (float)var3 + var5.nextFloat() * 0.5F + 0.5F;
				var9 = (float)var4 + var5.nextFloat();
				var1.a("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
			}
		}

	}
}
