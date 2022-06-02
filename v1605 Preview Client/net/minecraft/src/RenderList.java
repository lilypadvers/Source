package net.minecraft.src;

public class RenderList extends GuiErrorScreen {
	public RenderList() {
		float var1 = 0.0F;
		this.d = new TileEntitySpecialRenderer(40, 16);
		this.d.a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
		this.d.a(-5.0F, 2.0F, 0.0F);
		this.e = new TileEntitySpecialRenderer(40, 16);
		this.e.g = true;
		this.e.a(-1.0F, -2.0F, -1.0F, 2, 12, 2, var1);
		this.e.a(5.0F, 2.0F, 0.0F);
		this.f = new TileEntitySpecialRenderer(0, 16);
		this.f.a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
		this.f.a(-2.0F, 12.0F, 0.0F);
		this.g = new TileEntitySpecialRenderer(0, 16);
		this.g.g = true;
		this.g.a(-1.0F, 0.0F, -1.0F, 2, 12, 2, var1);
		this.g.a(2.0F, 12.0F, 0.0F);
	}
}
