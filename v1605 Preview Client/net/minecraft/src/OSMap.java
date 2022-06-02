package net.minecraft.src;

public class OSMap extends EntityTNTPrimed {
	private int a;

	public OSMap(int var1, int var2) {
		super(var1);
		this.a = var2;
	}

	public boolean a(TileEntityFurnace var1, BlockMobSpawner var2, EntitySpider var3, int var4, int var5, int var6, int var7) {
		if(var7 != 1) {
			return false;
		} else {
			int var8 = var3.a(var4, var5, var6);
			if(var8 == ln.aA.ba) {
				var3.d(var4, var5 + 1, var6, this.a);
				--var1.a;
				return true;
			} else {
				return false;
			}
		}
	}
}
