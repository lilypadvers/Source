package net.minecraft.src;

public class np extends EntityTNTPrimed {
	public np(int var1) {
		super(var1);
		this.aS = 64;
	}

	public boolean a(TileEntityFurnace var1, BlockMobSpawner var2, EntitySpider var3, int var4, int var5, int var6, int var7) {
		if(var7 == 0) {
			return false;
		} else if(var7 == 1) {
			return false;
		} else {
			byte var8 = 0;
			if(var7 == 4) {
				var8 = 1;
			}

			if(var7 == 3) {
				var8 = 2;
			}

			if(var7 == 5) {
				var8 = 3;
			}

			RecipesWeapons var9 = new RecipesWeapons(var3, var4, var5, var6, var8);
			if(var9.i()) {
				var3.a((EntityMinecart)var9);
				--var1.a;
			}

			return true;
		}
	}
}
