package net.minecraft.src;

public class SpawnerMonsters extends EntityTNTPrimed {
	private int a;

	public SpawnerMonsters(int var1, int var2) {
		super(var1);
		this.aR = 1;
		this.aS = 64;
		this.a = var2;
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
		lv var24 = var2.a(var13, var23, this.a == 0);
		if(var24 == null) {
			return var1;
		} else {
			if(var24.a == 0) {
				int var25 = var24.b;
				int var26 = var24.c;
				int var27 = var24.d;
				if(this.a == 0) {
					if(var2.f(var25, var26, var27) == EntitySkeleton.f && var2.e(var25, var26, var27) == 0) {
						var2.d(var25, var26, var27, 0);
						return new TileEntityFurnace(EntityTNTPrimed.av);
					}

					if(var2.f(var25, var26, var27) == EntitySkeleton.g && var2.e(var25, var26, var27) == 0) {
						var2.d(var25, var26, var27, 0);
						return new TileEntityFurnace(EntityTNTPrimed.aw);
					}
				} else {
					if(var24.e == 0) {
						--var26;
					}

					if(var24.e == 1) {
						++var26;
					}

					if(var24.e == 2) {
						--var27;
					}

					if(var24.e == 3) {
						++var27;
					}

					if(var24.e == 4) {
						--var25;
					}

					if(var24.e == 5) {
						++var25;
					}

					if(var2.a(var25, var26, var27) == 0 || !var2.f(var25, var26, var27).a()) {
						var2.b(var25, var26, var27, this.a, 0);
						return new TileEntityFurnace(EntityTNTPrimed.au);
					}
				}
			} else if(this.a == 0 && var24.g instanceof StepSoundSand) {
				return new TileEntityFurnace(EntityTNTPrimed.aE);
			}

			return var1;
		}
	}
}
