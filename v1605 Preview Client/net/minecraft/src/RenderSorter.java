package net.minecraft.src;

public class RenderSorter extends ln {
	public RenderSorter(int var1, int var2) {
		super(var1, EntitySkeleton.e);
		this.aZ = var2;
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?this.aZ - 16:(var1 == 0?this.aZ + 16:this.aZ);
	}
}
