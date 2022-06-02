package net.minecraft.src;

class TileEntityChest extends PathEntity {
	private final WorldIso e;

	public TileEntityChest(CraftingRecipe var1, WorldIso var2, WorldIso var3, int var4, int var5, int var6) {
		super(var1, var3, var4, var5, var6);
		this.e = var2;
	}

	public boolean a(TileEntityFurnace var1) {
		return false;
	}

	public void incrementPathIndex() {
		for(int var1 = 0; var1 < this.e.a(); ++var1) {
			if(this.e.a_(var1) != null) {
				this.e.a(var1, 1);
			}
		}

	}
}
