package net.minecraft.src;

import java.util.Random;

public class MaterialTransparent extends ChunkProviderLoadOrGenerate {
	private final boolean a;

	protected MaterialTransparent(int var1, boolean var2) {
		super(var1, EntitySkeleton.d);
		this.a = var2;
		this.aZ = 45;
	}

	public int a(int var1, Random var2) {
		return ln.aB.ba;
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		super.e(var1, var2, var3, var4);
		this.h(var1, var2, var3, var4);
	}

	private void h(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.a(var2, var3, var4 - 1);
		int var6 = var1.a(var2, var3, var4 + 1);
		int var7 = var1.a(var2 - 1, var3, var4);
		int var8 = var1.a(var2 + 1, var3, var4);
		byte var9 = 3;
		if(ln.p[var5] && !ln.p[var6]) {
			var9 = 3;
		}

		if(ln.p[var6] && !ln.p[var5]) {
			var9 = 2;
		}

		if(ln.p[var7] && !ln.p[var8]) {
			var9 = 5;
		}

		if(ln.p[var8] && !ln.p[var7]) {
			var9 = 4;
		}

		var1.b(var2, var3, var4, var9);
	}

	public int a(mz var1, int var2, int var3, int var4, int var5) {
		if(var5 == 1) {
			return ln.t.aZ;
		} else if(var5 == 0) {
			return ln.t.aZ;
		} else {
			int var6 = var1.e(var2, var3, var4);
			return var5 != var6?this.aZ:(this.a?this.aZ + 16:this.aZ - 1);
		}
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(this.a) {
			int var6 = var1.e(var2, var3, var4);
			float var7 = (float)var2 + 0.5F;
			float var8 = (float)var3 + 0.0F + var5.nextFloat() * 6.0F / 16.0F;
			float var9 = (float)var4 + 0.5F;
			float var10 = 0.52F;
			float var11 = var5.nextFloat() * 0.6F - 0.3F;
			if(var6 == 4) {
				var1.a("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				var1.a("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
			} else if(var6 == 5) {
				var1.a("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
				var1.a("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
			} else if(var6 == 2) {
				var1.a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
				var1.a("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
			} else if(var6 == 3) {
				var1.a("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
				var1.a("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
			}

		}
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?ln.t.ba:(var1 == 0?ln.t.ba:(var1 == 3?this.aZ - 1:this.aZ));
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		Path var6 = (Path)var1.b(var2, var3, var4);
		var5.a(var6);
		return true;
	}

	public static void a(boolean var0, EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4);
		EntityCreature var6 = var1.b(var2, var3, var4);
		if(var0) {
			var1.d(var2, var3, var4, ln.aC.ba);
		} else {
			var1.d(var2, var3, var4, ln.aB.ba);
		}

		var1.b(var2, var3, var4, var5);
		var1.a(var2, var3, var4, var6);
	}

	protected EntityCreature a_() {
		return new Path();
	}
}
