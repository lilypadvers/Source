package net.minecraft.src;

import java.util.Random;

public class ItemSeeds extends me {
	protected ItemSeeds(int var1, int var2) {
		super(var1, var2);
		float var3 = 0.4F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		super.a(var1, var2, var3, var4, var5);
		if(var1.j(var2, var3 + 1, var4) >= 9 && var5.nextInt(5) == 0) {
			int var6 = var1.e(var2, var3, var4);
			if(var6 < 15) {
				var1.b(var2, var3, var4, var6 + 1);
			} else {
				var1.a(var2, var3, var4, 0);
				Object var7 = new nm();
				if(var5.nextInt(10) == 0) {
					var7 = new ItemSaddle();
				}

				if(!((ItemArmor)var7).a(var1, var5, var2, var3, var4)) {
					var1.a(var2, var3, var4, this.ba);
				}
			}
		}

	}
}
