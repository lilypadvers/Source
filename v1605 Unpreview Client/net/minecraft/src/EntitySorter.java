package net.minecraft.src;

public class EntitySorter extends CanvasIsomPreview {
	private int a = 0;

	public void g() {
		++this.a;
	}

	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Back to title screen"));
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d == 0) {
				this.b.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
			}

		}
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, "Level save conflict", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
		this.b(this.g, "Minecraft detected a conflict in the level save data.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 0, 10526880);
		this.b(this.g, "This could be caused by two copies of the game", this.c / 2 - 140, this.d / 4 - 60 + 60 + 18, 10526880);
		this.b(this.g, "accessing the same level.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 27, 10526880);
		this.b(this.g, "To prevent level corruption, the current game has quit.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 45, 10526880);
		super.a(var1, var2, var3);
	}
}
