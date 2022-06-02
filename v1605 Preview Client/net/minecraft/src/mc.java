package net.minecraft.src;

public class mc extends CanvasIsomPreview {
	private MovementInput a;
	private boolean h = false;

	public mc(net.minecraft.client.Minecraft var1, String var2, int var3) {
		var1.a((EntitySpider)null);
		(new mp(this, var1, var2, var3)).start();
	}

	public void g() {
		if(this.a != null) {
			this.a.resetKeyState();
		}

	}

	protected void a(char var1, int var2) {
	}

	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Cancel"));
	}

	protected void a(EntitySplashFX var1) {
		if(var1.d == 0) {
			this.h = true;
			if(this.a != null) {
				this.a.b();
			}

			this.b.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
		}

	}

	public void a(int var1, int var2, float var3) {
		this.i();
		if(this.a == null) {
			this.a(this.g, "Connecting to the server...", this.c / 2, this.d / 2 - 50, 0xFFFFFF);
			this.a(this.g, "", this.c / 2, this.d / 2 - 10, 0xFFFFFF);
		} else {
			this.a(this.g, "Logging in...", this.c / 2, this.d / 2 - 50, 0xFFFFFF);
			this.a(this.g, this.a.a, this.c / 2, this.d / 2 - 10, 0xFFFFFF);
		}

		super.a(var1, var2, var3);
	}

	static MovementInput a(mc var0, MovementInput var1) {
		return var0.a = var1;
	}

	static boolean a(mc var0) {
		return var0.h;
	}

	static MovementInput b(mc var0) {
		return var0.a;
	}
}
