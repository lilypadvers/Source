package net.minecraft.src;

import java.util.Random;

public class EntityGiantZombie extends ItemArmor {
	private int a;

	public EntityGiantZombie(int var1) {
		this.a = var1;
	}

	public boolean a(EntitySpider var1, Random var2, int var3, int var4, int var5) {
		for(int var6 = 0; var6 < 64; ++var6) {
			int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
			int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
			int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
			if(var1.a(var7, var8, var9) == 0 && ((me)ln.n[this.a]).g(var1, var7, var8, var9)) {
				var1.a(var7, var8, var9, this.a);
			}
		}

		return true;
	}
}
