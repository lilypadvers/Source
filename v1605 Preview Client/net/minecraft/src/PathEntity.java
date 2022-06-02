package net.minecraft.src;

public class PathEntity {
	public final int pathLength;
	public final int b;
	public final int pathIndex;
	public final WorldIso d;
	private final CraftingRecipe e;

	public PathEntity(CraftingRecipe var1, WorldIso var2, int var3, int var4, int var5) {
		this.e = var1;
		this.d = var2;
		this.pathLength = var3;
		this.b = var4;
		this.pathIndex = var5;
	}

	public boolean a(int var1, int var2) {
		int var3 = (this.e.c - this.e.resultId) / 2;
		int var4 = (this.e.d - this.e.h) / 2;
		var1 -= var3;
		var2 -= var4;
		return var1 >= this.b - 1 && var1 < this.b + 16 + 1 && var2 >= this.pathIndex - 1 && var2 < this.pathIndex + 16 + 1;
	}

	public void incrementPathIndex() {
		this.d();
	}

	public boolean a(TileEntityFurnace var1) {
		return true;
	}

	public TileEntityFurnace b() {
		return this.d.a_(this.pathLength);
	}

	public void b(TileEntityFurnace var1) {
		this.d.a(this.pathLength, var1);
		this.d();
	}

	public int c() {
		return -1;
	}

	public void d() {
		this.d.d();
	}
}
