package net.minecraft.src;

import java.util.Random;

public class InventoryCraftResult extends Entity {
	public InventoryCraftResult(int var1, int var2) {
		super(var1, var2, EntitySkeleton.r, false);
		this.bm = 0.98F;
		this.b(true);
	}

	public int g() {
		return 1;
	}

	public boolean c(mz var1, int var2, int var3, int var4, int var5) {
		return super.c(var1, var2, var3, var4, 1 - var5);
	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
		EntitySkeleton var5 = var1.f(var2, var3 - 1, var4);
		if(var5.c() || var5.d()) {
			var1.d(var2, var3, var4, ln.A.ba);
		}

	}

	public int a(Random var1) {
		return 0;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.a(PlayerControllerCreative.b, var2, var3, var4) > 11 - ln.q[this.ba]) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, ln.B.ba);
		}

	}
}
