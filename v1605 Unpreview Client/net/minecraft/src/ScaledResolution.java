package net.minecraft.src;

public class ScaledResolution extends ln {
	protected ScaledResolution(int var1) {
		super(var1, EntitySkeleton.c);
		this.aZ = 59;
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?this.aZ - 16:(var1 == 0?ln.x.getGLCallListForPass(0):(var1 != 2 && var1 != 4?this.aZ:this.aZ + 1));
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		var5.k();
		return true;
	}
}
