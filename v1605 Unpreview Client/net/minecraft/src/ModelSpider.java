package net.minecraft.src;

public class ModelSpider extends RenderMinecart {
	public TileEntitySpecialRenderer a;
	public TileEntitySpecialRenderer b;
	public TileEntitySpecialRenderer c;
	public TileEntitySpecialRenderer d;
	public TileEntitySpecialRenderer e;
	public TileEntitySpecialRenderer f;
	public TileEntitySpecialRenderer g;

	public ModelSpider() {
		float var1 = 0.0F;
		byte var2 = 4;
		this.a = new TileEntitySpecialRenderer(0, 0);
		this.a.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
		this.a.a(0.0F, (float)var2, 0.0F);
		this.b = new TileEntitySpecialRenderer(32, 0);
		this.b.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
		this.b.a(0.0F, (float)var2, 0.0F);
		this.c = new TileEntitySpecialRenderer(16, 16);
		this.c.a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
		this.c.a(0.0F, (float)var2, 0.0F);
		this.d = new TileEntitySpecialRenderer(0, 16);
		this.d.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.d.a(-2.0F, (float)(12 + var2), 4.0F);
		this.e = new TileEntitySpecialRenderer(0, 16);
		this.e.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.e.a(2.0F, (float)(12 + var2), 4.0F);
		this.f = new TileEntitySpecialRenderer(0, 16);
		this.f.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.f.a(-2.0F, (float)(12 + var2), -4.0F);
		this.g = new TileEntitySpecialRenderer(0, 16);
		this.g.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.g.a(2.0F, (float)(12 + var2), -4.0F);
	}

	public void b(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.setBlockBounds(var1, var2, var3, var4, var5, var6);
		this.a.a(var6);
		this.c.a(var6);
		this.d.a(var6);
		this.e.a(var6);
		this.f.a(var6);
		this.g.a(var6);
	}

	public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.a.e = var4 / 57.295776F;
		this.a.d = var5 / 57.295776F;
		this.d.d = ModelPig.b(var1 * 0.6662F) * 1.4F * var2;
		this.e.d = ModelPig.b(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
		this.f.d = ModelPig.b(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
		this.g.d = ModelPig.b(var1 * 0.6662F) * 1.4F * var2;
	}
}
