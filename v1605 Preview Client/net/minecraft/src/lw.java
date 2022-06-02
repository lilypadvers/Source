package net.minecraft.src;

import java.util.Random;

public class lw extends ln {
	protected lw(int var1) {
		super(var1, EntitySkeleton.c);
		this.aZ = 20;
	}

	public int a(Random var1) {
		return 1;
	}

	public int a(int var1, Random var2) {
		return ln.J.ba;
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?21:(var1 == 0?21:20);
	}
}
