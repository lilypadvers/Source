package net.minecraft.src;

public class nb extends ln {
	protected nb(int var1, int var2) {
		super(var1, var2, EntitySkeleton.n);
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
		return 12;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return var1.g(var2 - 1, var3, var4)?true:(var1.g(var2 + 1, var3, var4)?true:(var1.g(var2, var3, var4 - 1)?true:(var1.g(var2, var3, var4 + 1)?true:var1.g(var2, var3 - 1, var4))));
	}

	public void d(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = var1.e(var2, var3, var4);
		int var7 = var6 & 8;
		var6 &= 7;
		if(var5 == 1 && var1.g(var2, var3 - 1, var4)) {
			var6 = 5 + var1.m.nextInt(2);
		}

		if(var5 == 2 && var1.g(var2, var3, var4 + 1)) {
			var6 = 4;
		}

		if(var5 == 3 && var1.g(var2, var3, var4 - 1)) {
			var6 = 3;
		}

		if(var5 == 4 && var1.g(var2 + 1, var3, var4)) {
			var6 = 2;
		}

		if(var5 == 5 && var1.g(var2 - 1, var3, var4)) {
			var6 = 1;
		}

		var1.b(var2, var3, var4, var6 + var7);
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		if(var1.g(var2 - 1, var3, var4)) {
			var1.b(var2, var3, var4, 1);
		} else if(var1.g(var2 + 1, var3, var4)) {
			var1.b(var2, var3, var4, 2);
		} else if(var1.g(var2, var3, var4 - 1)) {
			var1.b(var2, var3, var4, 3);
		} else if(var1.g(var2, var3, var4 + 1)) {
			var1.b(var2, var3, var4, 4);
		} else if(var1.g(var2, var3 - 1, var4)) {
			var1.b(var2, var3, var4, 5 + var1.m.nextInt(2));
		}

		this.h(var1, var2, var3, var4);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(this.h(var1, var2, var3, var4)) {
			int var6 = var1.e(var2, var3, var4) & 7;
			boolean var7 = false;
			if(!var1.g(var2 - 1, var3, var4) && var6 == 1) {
				var7 = true;
			}

			if(!var1.g(var2 + 1, var3, var4) && var6 == 2) {
				var7 = true;
			}

			if(!var1.g(var2, var3, var4 - 1) && var6 == 3) {
				var7 = true;
			}

			if(!var1.g(var2, var3, var4 + 1) && var6 == 4) {
				var7 = true;
			}

			if(!var1.g(var2, var3 - 1, var4) && var6 == 5) {
				var7 = true;
			}

			if(var7) {
				this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
				var1.d(var2, var3, var4, 0);
			}
		}

	}

	private boolean h(EntitySpider var1, int var2, int var3, int var4) {
		if(!this.a(var1, var2, var3, var4)) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
			return false;
		} else {
			return true;
		}
	}

	public void a(mz var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4) & 7;
		float var6 = 0.1875F;
		if(var5 == 1) {
			this.a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
		} else if(var5 == 2) {
			this.a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
		} else if(var5 == 3) {
			this.a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
		} else if(var5 == 4) {
			this.a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
		} else {
			var6 = 0.25F;
			this.a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
		}

	}

	public void b(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		this.a(var1, var2, var3, var4, var5);
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		int var6 = var1.e(var2, var3, var4);
		int var7 = var6 & 7;
		int var8 = 8 - (var6 & 8);
		var1.b(var2, var3, var4, var7 + var8);
		var1.b(var2, var3, var4, var2, var3, var4);
		var1.a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.click", 0.3F, var8 > 0?0.6F:0.5F);
		var1.g(var2, var3, var4, this.ba);
		if(var7 == 1) {
			var1.g(var2 - 1, var3, var4, this.ba);
		} else if(var7 == 2) {
			var1.g(var2 + 1, var3, var4, this.ba);
		} else if(var7 == 3) {
			var1.g(var2, var3, var4 - 1, this.ba);
		} else if(var7 == 4) {
			var1.g(var2, var3, var4 + 1, this.ba);
		} else {
			var1.g(var2, var3 - 1, var4, this.ba);
		}

		return true;
	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4);
		if((var5 & 8) > 0) {
			var1.g(var2, var3, var4, this.ba);
			int var6 = var5 & 7;
			if(var6 == 1) {
				var1.g(var2 - 1, var3, var4, this.ba);
			} else if(var6 == 2) {
				var1.g(var2 + 1, var3, var4, this.ba);
			} else if(var6 == 3) {
				var1.g(var2, var3, var4 - 1, this.ba);
			} else if(var6 == 4) {
				var1.g(var2, var3, var4 + 1, this.ba);
			} else {
				var1.g(var2, var3 - 1, var4, this.ba);
			}
		}

		super.b(var1, var2, var3, var4);
	}

	public boolean b(mz var1, int var2, int var3, int var4, int var5) {
		return (var1.e(var2, var3, var4) & 8) > 0;
	}

	public boolean c(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = var1.e(var2, var3, var4);
		if((var6 & 8) == 0) {
			return false;
		} else {
			int var7 = var6 & 7;
			return var7 == 5 && var5 == 1?true:(var7 == 4 && var5 == 2?true:(var7 == 3 && var5 == 3?true:(var7 == 2 && var5 == 4?true:var7 == 1 && var5 == 5)));
		}
	}

	public boolean d() {
		return true;
	}
}
