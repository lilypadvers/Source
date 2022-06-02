package net.minecraft.src;

public class lo implements WorldIso {
	private TileEntityFurnace[] a = new TileEntityFurnace[1];

	public int a() {
		return 1;
	}

	public TileEntityFurnace a_(int var1) {
		return this.a[var1];
	}

	public String b() {
		return "Result";
	}

	public TileEntityFurnace a(int var1, int var2) {
		if(this.a[var1] != null) {
			TileEntityFurnace var3 = this.a[var1];
			this.a[var1] = null;
			return var3;
		} else {
			return null;
		}
	}

	public void a(int var1, TileEntityFurnace var2) {
		this.a[var1] = var2;
	}

	public int c() {
		return 64;
	}

	public void d() {
	}
}
