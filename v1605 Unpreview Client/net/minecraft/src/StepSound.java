package net.minecraft.src;

public class StepSound extends ln {
	protected StepSound(int var1, int var2) {
		super(var1, var2, EntitySkeleton.c);
	}

	public int getGLCallListForPass(int var1) {
		return this.aZ + (var1 == 1?1:0);
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		int var6 = var1.e(var2, var3, var4);
		if(var6 > 0) {
			this.e(var1, var2, var3, var4, var6);
			return true;
		} else {
			return false;
		}
	}

	public void e(EntitySpider var1, int var2, int var3, int var4, int var5) {
		var1.a((String)null, var2, var3, var4);
		var1.b(var2, var3, var4, 0);
		int var6 = EntityTNTPrimed.aO.aQ + var5 - 1;
		float var7 = 0.7F;
		double var8 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		double var10 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.2D + 0.6D;
		double var12 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		EffectRenderer var14 = new EffectRenderer(var1, (double)var2 + var8, (double)var3 + var10, (double)var4 + var12, new TileEntityFurnace(var6));
		var14.c = 10;
		var1.a((EntityMinecart)var14);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5, float var6) {
		if(!var1.v) {
			if(var5 > 0) {
				this.e(var1, var2, var3, var4, var5);
			}

			super.a(var1, var2, var3, var4, var5, var6);
		}
	}
}
