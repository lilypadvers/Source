package net.minecraft.src;

import java.util.Random;

public class Explosion extends ln {
	public static boolean a = false;

	public Explosion(int var1, int var2) {
		super(var1, var2, EntitySkeleton.m);
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		var1.h(var2, var3, var4, this.ba);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		var1.h(var2, var3, var4, this.ba);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		this.h(var1, var2, var3, var4);
	}

	private void h(EntitySpider var1, int var2, int var3, int var4) {
		if(a_(var1, var2, var3 - 1, var4) && var3 >= 0) {
			BlockStairs var8 = new BlockStairs(var1, (float)var2 + 0.5F, (float)var3 + 0.5F, (float)var4 + 0.5F, this.ba);
			if(a) {
				while(!var8.ax) {
					var8.e_();
				}
			} else {
				var1.a((EntityMinecart)var8);
			}
		}

	}

	public int a() {
		return 3;
	}

	public static boolean a_(EntitySpider var0, int var1, int var2, int var3) {
		int var4 = var0.a(var1, var2, var3);
		if(var4 == 0) {
			return true;
		} else if(var4 == ln.ar.ba) {
			return true;
		} else {
			EntitySkeleton var5 = ln.n[var4].bl;
			return var5 == EntitySkeleton.f?true:var5 == EntitySkeleton.g;
		}
	}
}
