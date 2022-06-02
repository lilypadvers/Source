package net.minecraft.src;

public class nv extends EntityTNTPrimed {
	private int a;

	public nv(int var1, int var2) {
		super(var1);
		this.a = var2;
		this.aR = 1;
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		--var1.a;
		var3.b(this.a);
		return var1;
	}
}
