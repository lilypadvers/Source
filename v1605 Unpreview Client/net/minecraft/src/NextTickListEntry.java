package net.minecraft.src;

public class NextTickListEntry extends CanvasIsomPreview {
	private MovementInput a;
	private int h = 0;

	public NextTickListEntry(MovementInput var1) {
		this.a = var1;
	}

	protected void a(char var1, int var2) {
	}

	public void a() {
		this.e.clear();
	}

	public void g() {
		++this.h;
		if(this.h % 20 == 0) {
			this.a.a((ItemAxe)(new SlotArmor()));
		}

		if(this.a != null) {
			this.a.resetKeyState();
		}

	}

	protected void a(EntitySplashFX var1) {
	}

	public void a(int var1, int var2, float var3) {
		this.b(0);
		this.a(this.g, "Downloading terrain", this.c / 2, this.d / 2 - 50, 0xFFFFFF);
		super.a(var1, var2, var3);
	}
}
