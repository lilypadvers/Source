package net.minecraft.src;

import java.util.Random;

public class BlockGravel extends ln {
	protected BlockGravel(int var1, int var2) {
		super(var1, var2, EntitySkeleton.t);
		this.b(true);
	}

	public int a(int var1, Random var2) {
		return EntityTNTPrimed.aB.aQ;
	}

	public int a(Random var1) {
		return 4;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.a(PlayerControllerCreative.b, var2, var3, var4) > 11) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}
}
