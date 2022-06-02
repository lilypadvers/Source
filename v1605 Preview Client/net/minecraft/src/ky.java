package net.minecraft.src;

class ky extends PathEntity {
	final int e;
	final ld f;

	ky(ld var1, CraftingRecipe var2, WorldIso var3, int var4, int var5, int var6, int var7) {
		super(var2, var3, var4, var5, var6);
		this.f = var1;
		this.e = var7;
	}

	public boolean a(TileEntityFurnace var1) {
		return var1.a() instanceof mf?((mf)var1.a()).aV == this.e:false;
	}

	public int c() {
		return 15 + this.e * 16;
	}
}
