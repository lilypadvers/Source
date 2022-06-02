package net.minecraft.src;

import java.util.Random;

public class RecipesCrafting extends RecipesTools {
	private int b;
	private int c = 0;

	protected RecipesCrafting(int var1, int var2) {
		super(var1, var2, EntitySkeleton.h, false);
		this.b = var2;
		this.b(true);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this.c = 0;
		this.h(var1, var2, var3, var4);
		super.a(var1, var2, var3, var4, var5);
	}

	public void f(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(var1.a(var2, var3, var4) == this.ba) {
			int var6 = var1.e(var2, var3, var4);
			if(var6 != 0 && var6 == var5 - 1) {
				this.h(var1, var2, var3, var4);
			}
		}
	}

	public void h(EntitySpider var1, int var2, int var3, int var4) {
		if(this.c++ < 100) {
			int var5 = var1.f(var2, var3 - 1, var4).a()?16:0;
			int var6 = var1.e(var2, var3, var4);
			if(var6 == 0) {
				var6 = 1;
				var1.b(var2, var3, var4, 1);
			}

			var5 = this.g(var1, var2, var3 - 1, var4, var5);
			var5 = this.g(var1, var2, var3, var4 - 1, var5);
			var5 = this.g(var1, var2, var3, var4 + 1, var5);
			var5 = this.g(var1, var2 - 1, var3, var4, var5);
			var5 = this.g(var1, var2 + 1, var3, var4, var5);
			int var7 = var5 - 1;
			if(var7 < 10) {
				var7 = 1;
			}

			if(var7 != var6) {
				var1.b(var2, var3, var4, var7);
				this.f(var1, var2, var3 - 1, var4, var6);
				this.f(var1, var2, var3 + 1, var4, var6);
				this.f(var1, var2, var3, var4 - 1, var6);
				this.f(var1, var2, var3, var4 + 1, var6);
				this.f(var1, var2 - 1, var3, var4, var6);
				this.f(var1, var2 + 1, var3, var4, var6);
			}

		}
	}

	private int g(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = var1.a(var2, var3, var4);
		if(var6 == ln.J.ba) {
			return 16;
		} else {
			if(var6 == this.ba) {
				int var7 = var1.e(var2, var3, var4);
				if(var7 != 0 && var7 > var5) {
					return var7;
				}
			}

			return var5;
		}
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		int var6 = var1.e(var2, var3, var4);
		if(var6 == 0) {
			this.c = 0;
			this.h(var1, var2, var3, var4);
		} else if(var6 == 1) {
			this.i(var1, var2, var3, var4);
		} else if(var5.nextInt(10) == 0) {
			this.h(var1, var2, var3, var4);
		}

	}

	private void i(EntitySpider var1, int var2, int var3, int var4) {
		this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
		var1.d(var2, var3, var4, 0);
	}

	public int a(Random var1) {
		return var1.nextInt(20) == 0?1:0;
	}

	public int a(int var1, Random var2) {
		return ln.y.ba;
	}

	public boolean b() {
		return !this.a;
	}

	public void a(boolean var1) {
		this.a = var1;
		this.aZ = this.b + (var1?0:1);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5) {
		super.a(var1, var2, var3, var4, var5);
	}
}
