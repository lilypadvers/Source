package net.minecraft.src;

import java.util.Random;

public class WorldRenderer extends ln {
	public WorldRenderer(int var1, int var2) {
		super(var1, var2, EntitySkeleton.c);
	}

	public int getGLCallListForPass(int var1) {
		return var1 <= 1?4:this.aZ;
	}

	public int a(Random var1) {
		return 0;
	}
}
