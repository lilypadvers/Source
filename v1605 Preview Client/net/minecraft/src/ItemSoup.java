package net.minecraft.src;

public class ItemSoup extends EntityMob {
	public ItemSoup() {
		super(12, 0.0F);
		this.d = new TileEntitySpecialRenderer(0, 0);
		this.d.a(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
		this.d.a(0.0F, 6.0F, -8.0F);
		this.e = new TileEntitySpecialRenderer(28, 8);
		this.e.a(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
		this.e.a(0.0F, 5.0F, 2.0F);
		float var1 = 0.5F;
		this.f = new TileEntitySpecialRenderer(0, 16);
		this.f.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.f.a(-3.0F, 12.0F, 7.0F);
		this.g = new TileEntitySpecialRenderer(0, 16);
		this.g.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.g.a(3.0F, 12.0F, 7.0F);
		this.h = new TileEntitySpecialRenderer(0, 16);
		this.h.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.h.a(-3.0F, 12.0F, -5.0F);
		this.i = new TileEntitySpecialRenderer(0, 16);
		this.i.a(-2.0F, 0.0F, -2.0F, 4, 6, 4, var1);
		this.i.a(3.0F, 12.0F, -5.0F);
	}
}
