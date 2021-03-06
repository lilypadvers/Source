package net.minecraft.src;

import java.util.Random;

public class PillarGen extends WorldGenerator {
	private int a;

	public PillarGen(int var1) {
		this.a = var1;
	}

	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		for(int var6 = 0; var6 < 64; ++var6) {
			int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
			int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
			int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
			int var10 = var1.a(var7, var8 - 1, var9);
			boolean var11 = var10 != 0 && var10 != 9 && var10 != 116 && var10 != 18;
			if(var1.a(var7, var8, var9) == 0 && var11) {
				var1.setBlock(var7, var8, var9, this.a);
				if(var2.nextInt(100) > 50) {
					var1.setBlock(var7, var8 + 1, var9, this.a);
					if(var2.nextInt(100) > 50) {
						var1.setBlock(var7, var8 + 2, var9, this.a);
					}
				}
			}
		}

		return true;
	}
}
