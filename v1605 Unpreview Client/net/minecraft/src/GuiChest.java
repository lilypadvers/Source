package net.minecraft.src;

public class GuiChest implements WorldIso {
	private String a;
	private WorldIso b;
	private WorldIso c;

	public GuiChest(String var1, WorldIso var2, WorldIso var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public int a() {
		return this.b.a() + this.c.a();
	}

	public String b() {
		return this.a;
	}

	public TileEntityFurnace a_(int var1) {
		return var1 >= this.b.a()?this.c.a_(var1 - this.b.a()):this.b.a_(var1);
	}

	public TileEntityFurnace a(int var1, int var2) {
		return var1 >= this.b.a()?this.c.a(var1 - this.b.a(), var2):this.b.a(var1, var2);
	}

	public void a(int var1, TileEntityFurnace var2) {
		if(var1 >= this.b.a()) {
			this.c.a(var1 - this.b.a(), var2);
		} else {
			this.b.a(var1, var2);
		}

	}

	public int c() {
		return this.b.c();
	}

	public void d() {
		this.b.d();
		this.c.d();
	}
}
