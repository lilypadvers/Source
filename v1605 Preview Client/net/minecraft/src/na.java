package net.minecraft.src;

import java.util.Random;

public class na extends ItemArmor {
	private int a;

	public na(int var1) {
		this.a = var1;
	}

	public boolean a(EntitySpider var1, Random var2, int var3, int var4, int var5) {
		if(var1.a(var3, var4 + 1, var5) != ln.t.ba) {
			return false;
		} else if(var1.a(var3, var4 - 1, var5) != ln.t.ba) {
			return false;
		} else if(var1.a(var3, var4, var5) != 0 && var1.a(var3, var4, var5) != ln.t.ba) {
			return false;
		} else {
			int var6 = 0;
			if(var1.a(var3 - 1, var4, var5) == ln.t.ba) {
				++var6;
			}

			if(var1.a(var3 + 1, var4, var5) == ln.t.ba) {
				++var6;
			}

			if(var1.a(var3, var4, var5 - 1) == ln.t.ba) {
				++var6;
			}

			if(var1.a(var3, var4, var5 + 1) == ln.t.ba) {
				++var6;
			}

			int var7 = 0;
			if(var1.a(var3 - 1, var4, var5) == 0) {
				++var7;
			}

			if(var1.a(var3 + 1, var4, var5) == 0) {
				++var7;
			}

			if(var1.a(var3, var4, var5 - 1) == 0) {
				++var7;
			}

			if(var1.a(var3, var4, var5 + 1) == 0) {
				++var7;
			}

			if(var6 == 3 && var7 == 1) {
				var1.d(var3, var4, var5, this.a);
			}

			return true;
		}
	}
}
