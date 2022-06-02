package net.minecraft.src;

public class RedstoneUpdateInfo extends EntityTNTPrimed {
	public int x;

	public RedstoneUpdateInfo(int var1, int var2) {
		super(var1);
		this.aR = 1;
		this.x = var2;
	}

	public boolean a(TileEntityFurnace var1, BlockMobSpawner var2, EntitySpider var3, int var4, int var5, int var6, int var7) {
		int var8 = var3.a(var4, var5, var6);
		if(var8 == ln.aG.ba) {
			var3.a((EntityMinecart)(new no(var3, (double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), this.x)));
			--var1.a;
			return true;
		} else {
			return false;
		}
	}
}
