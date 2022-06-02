package net.minecraft.src;

public class lu extends EntityTNTPrimed {
	public lu(int var1) {
		super(var1);
		this.aR = 1;
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		float var4 = 1.0F;
		float var5 = var3.aq + (var3.ao - var3.aq) * var4;
		float var6 = var3.ap + (var3.an - var3.ap) * var4;
		double var7 = var3.ae + (var3.ah - var3.ae) * (double)var4;
		double var9 = var3.af + (var3.ai - var3.af) * (double)var4;
		double var11 = var3.ag + (var3.aj - var3.ag) * (double)var4;
		BlockTNT var13 = BlockTNT.b(var7, var9, var11);
		float var14 = ModelPig.b(-var6 * 0.017453292F - (float)Math.PI);
		float var15 = ModelPig.a(-var6 * 0.017453292F - (float)Math.PI);
		float var16 = -ModelPig.b(-var5 * 0.017453292F);
		float var17 = ModelPig.a(-var5 * 0.017453292F);
		float var18 = var15 * var16;
		float var20 = var14 * var16;
		double var21 = 5.0D;
		BlockTNT var23 = var13.c((double)var18 * var21, (double)var17 * var21, (double)var20 * var21);
		lv var24 = var2.a(var13, var23, true);
		if(var24 == null) {
			return var1;
		} else {
			if(var24.a == 0) {
				int var25 = var24.b;
				int var26 = var24.c;
				int var27 = var24.d;
				var2.a((EntityMinecart)(new ThreadDownloadResources(var2, (double)((float)var25 + 0.5F), (double)((float)var26 + 1.5F), (double)((float)var27 + 0.5F))));
				--var1.a;
			}

			return var1;
		}
	}
}
