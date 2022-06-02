package net.minecraft.src;

import java.util.Random;

public class ImageBuffer extends ln {
	public ImageBuffer(int var1, int var2) {
		super(var1, var2, EntitySkeleton.p);
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 0?this.aZ + 2:(var1 == 1?this.aZ + 1:this.aZ);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(var5 > 0 && ln.n[var5].d() && var1.p(var2, var3, var4)) {
			this.b(var1, var2, var3, var4, 0);
			var1.d(var2, var3, var4, 0);
		}

	}

	public int a(Random var1) {
		return 0;
	}

	public void c(EntitySpider var1, int var2, int var3, int var4) {
		EntityRainFX var5 = new EntityRainFX(var1, (float)var2 + 0.5F, (float)var3 + 0.5F, (float)var4 + 0.5F);
		var5.a = var1.m.nextInt(var5.a / 4) + var5.a / 8;
		var1.a((EntityMinecart)var5);
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, int var5) {
		EntityRainFX var6 = new EntityRainFX(var1, (float)var2 + 0.5F, (float)var3 + 0.5F, (float)var4 + 0.5F);
		var1.a((EntityMinecart)var6);
		var1.a(var6, "random.fuse", 1.0F, 1.0F);
	}
}
