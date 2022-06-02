package net.minecraft.src;

import java.util.Random;

public class BlockLever extends ln {
	protected BlockLever(int var1, int var2) {
		super(var1, EntitySkeleton.i);
		this.aZ = var2;
		float var3 = 0.375F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
		this.b(true);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.a(var2, var3 + 1, var4) == 0) {
			int var6;
			for(var6 = 1; var1.a(var2, var3 - var6, var4) == this.ba; ++var6) {
			}

			if(var6 < 3) {
				int var7 = var1.e(var2, var3, var4);
				if(var7 == 15) {
					var1.d(var2, var3 + 1, var4, this.ba);
					var1.b(var2, var3, var4, 0);
				} else {
					var1.b(var2, var3, var4, var7 + 1);
				}
			}
		}

	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.a(var2, var3 - 1, var4);
		return var5 == this.ba?true:(var5 != ln.u.ba && var5 != ln.v.ba?false:(var1.f(var2 - 1, var3 - 1, var4) == EntitySkeleton.f?true:(var1.f(var2 + 1, var3 - 1, var4) == EntitySkeleton.f?true:(var1.f(var2, var3 - 1, var4 - 1) == EntitySkeleton.f?true:var1.f(var2, var3 - 1, var4 + 1) == EntitySkeleton.f))));
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this.h(var1, var2, var3, var4);
	}

	protected final void h(EntitySpider var1, int var2, int var3, int var4) {
		if(!this.g(var1, var2, var3, var4)) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}

	public boolean g(EntitySpider var1, int var2, int var3, int var4) {
		return this.a(var1, var2, var3, var4);
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return null;
	}

	public int a(int var1, Random var2) {
		return EntityTNTPrimed.aH.aQ;
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int f() {
		return 1;
	}
}
