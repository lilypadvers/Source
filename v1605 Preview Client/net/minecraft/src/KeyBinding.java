package net.minecraft.src;

public class KeyBinding extends CanvasIsomPreview {
	private String keyDescription;
	private String h;

	public KeyBinding(String var1, String var2) {
		this.keyDescription = var1;
		this.h = var2;
	}

	public void g() {
	}

	protected void a(char var1, int var2) {
	}

	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Back to title screen"));
	}

	protected void a(EntitySplashFX var1) {
		if(var1.d == 0) {
			this.b.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
		}

	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, this.keyDescription, this.c / 2, this.d / 2 - 50, 0xFFFFFF);
		this.a(this.g, this.h, this.c / 2, this.d / 2 - 10, 0xFFFFFF);
		super.a(var1, var2, var3);
	}
}
