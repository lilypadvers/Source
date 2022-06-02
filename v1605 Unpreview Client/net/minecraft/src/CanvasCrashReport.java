package net.minecraft.src;

public class CanvasCrashReport extends CanvasIsomPreview {
	private CanvasIsomPreview a;
	private String h;
	private String i;
	private int k;

	public CanvasCrashReport(CanvasIsomPreview var1, String var2, String var3, int var4) {
		this.a = var1;
		this.h = var2;
		this.i = var3;
		this.k = var4;
	}

	public void a() {
		this.e.add(new RenderCreeper(0, this.c / 2 - 155 + 0, this.d / 6 + 96, "Yes"));
		this.e.add(new RenderCreeper(1, this.c / 2 - 155 + 160, this.d / 6 + 96, "No"));
	}

	protected void a(EntitySplashFX var1) {
		this.a.a(var1.d == 0, this.k);
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, this.h, this.c / 2, 70, 0xFFFFFF);
		this.a(this.g, this.i, this.c / 2, 90, 0xFFFFFF);
		super.a(var1, var2, var3);
	}
}
