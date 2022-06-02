package net.minecraft.src;

public class RecipesFood extends nv {
	public RecipesFood(int var1, int var2) {
		super(var1, var2);
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		super.a(var1, var2, var3);
		return new TileEntityFurnace(EntityTNTPrimed.C);
	}
}
