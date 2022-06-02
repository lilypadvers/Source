package net.minecraft.src;

public class Block extends RenderMinecart {
	TileEntitySpecialRenderer a;
	TileEntitySpecialRenderer b;
	TileEntitySpecialRenderer c;
	TileEntitySpecialRenderer d;

	public Block(int var1) {
		this.a = new TileEntitySpecialRenderer(0, var1);
		this.a.a(-4.0F, 16.0F, -4.0F, 8, 8, 8);
		if(var1 > 0) {
			this.a = new TileEntitySpecialRenderer(0, var1);
			this.a.a(-3.0F, 17.0F, -3.0F, 6, 6, 6);
			this.b = new TileEntitySpecialRenderer(32, 0);
			this.b.a(-3.25F, 18.0F, -3.5F, 2, 2, 2);
			this.c = new TileEntitySpecialRenderer(32, 4);
			this.c.a(1.25F, 18.0F, -3.5F, 2, 2, 2);
			this.d = new TileEntitySpecialRenderer(32, 8);
			this.d.a(0.0F, 21.0F, -3.5F, 1, 1, 1);
		}

	}

	public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
	}

	public void b(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.setBlockBounds(var1, var2, var3, var4, var5, var6);
		this.a.a(var6);
		if(this.b != null) {
			this.b.a(var6);
			this.c.a(var6);
			this.d.a(var6);
		}

	}
}
