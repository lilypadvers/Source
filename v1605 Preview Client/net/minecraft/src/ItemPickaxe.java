package net.minecraft.src;

public class ItemPickaxe extends CanvasIsomPreview {
	private CanvasIsomPreview h;
	protected String a = "Options";
	private World i;

	public ItemPickaxe(CanvasIsomPreview var1, World var2) {
		this.h = var1;
		this.i = var2;
	}

	public void a() {
		for(int var1 = 0; var1 < this.i.u; ++var1) {
			this.e.add(new RenderCreeper(var1, this.c / 2 - 155 + var1 % 2 * 160, this.d / 6 + 24 * (var1 >> 1), this.i.b(var1)));
		}

		this.e.add(new EntitySplashFX(100, this.c / 2 - 100, this.d / 6 + 120 + 12, "Controls..."));
		this.e.add(new EntitySplashFX(200, this.c / 2 - 100, this.d / 6 + 168, "Done"));
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d < 100) {
				this.i.b(var1.d, 1);
				var1.c = this.i.b(var1.d);
			}

			if(var1.d == 100) {
				this.b.a((CanvasIsomPreview)(new lj(this, this.i)));
			}

			if(var1.d == 200) {
				this.b.a(this.h);
			}

		}
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, this.a, this.c / 2, 20, 0xFFFFFF);
		super.a(var1, var2, var3);
	}
}
