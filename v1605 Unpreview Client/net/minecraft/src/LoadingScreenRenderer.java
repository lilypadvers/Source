package net.minecraft.src;

public class LoadingScreenRenderer implements WorldIso {
	private TileEntityFurnace[] a;
	private int b;
	private CraftingRecipe c;

	public LoadingScreenRenderer(CraftingRecipe var1, int var2, int var3) {
		this.b = var2 * var3;
		this.a = new TileEntityFurnace[this.b];
		this.c = var1;
	}

	public LoadingScreenRenderer(CraftingRecipe var1, TileEntityFurnace[] var2) {
		this.b = var2.length;
		this.a = var2;
		this.c = var1;
	}

	public int a() {
		return this.b;
	}

	public TileEntityFurnace a_(int var1) {
		return this.a[var1];
	}

	public String b() {
		return "Crafting";
	}

	public TileEntityFurnace a(int var1, int var2) {
		if(this.a[var1] != null) {
			TileEntityFurnace var3;
			if(this.a[var1].a <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				this.c.a((WorldIso)this);
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if(this.a[var1].a == 0) {
					this.a[var1] = null;
				}

				this.c.a((WorldIso)this);
				return var3;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, TileEntityFurnace var2) {
		this.a[var1] = var2;
		this.c.a((WorldIso)this);
	}

	public int c() {
		return 64;
	}

	public void d() {
	}
}
