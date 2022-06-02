package net.minecraft.src;

import java.util.Random;

public class nu extends ln {
	private boolean a;

	public nu(int var1, boolean var2) {
		super(var1, 6, EntitySkeleton.d);
		this.a = var2;
		if(!var2) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.d(255);
	}

	public int getGLCallListForPass(int var1) {
		return var1 <= 1?6:5;
	}

	public boolean b() {
		return this.a;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(this == ln.ak) {
		}
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		if(this != ln.ak) {
			super.e(var1, var2, var3, var4);
		}

		int var5 = var1.a(var2, var3 - 1, var4);
		if(var5 == ak.ba) {
			var1.d(var2, var3, var4, 0);
			var1.d(var2, var3 - 1, var4, ln.aj.ba);
		}

	}

	public int a(int var1, Random var2) {
		return ln.ak.ba;
	}

	public boolean c() {
		return this.a;
	}

	public boolean c(mz var1, int var2, int var3, int var4, int var5) {
		if(this != ln.ak) {
			super.c(var1, var2, var3, var4, var5);
		}

		return var5 == 1?true:(!super.c(var1, var2, var3, var4, var5)?false:(var5 == 0?true:var1.a(var2, var3, var4) != this.ba));
	}
}
