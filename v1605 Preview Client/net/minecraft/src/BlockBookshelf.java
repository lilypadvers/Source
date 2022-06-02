package net.minecraft.src;

public class BlockBookshelf extends RenderMinecart {
	public TileEntitySpecialRenderer[] a = new TileEntitySpecialRenderer[7];

	public BlockBookshelf() {
		this.a[0] = new TileEntitySpecialRenderer(0, 10);
		this.a[1] = new TileEntitySpecialRenderer(0, 0);
		this.a[2] = new TileEntitySpecialRenderer(0, 0);
		this.a[3] = new TileEntitySpecialRenderer(0, 0);
		this.a[4] = new TileEntitySpecialRenderer(0, 0);
		this.a[5] = new TileEntitySpecialRenderer(44, 10);
		byte var1 = 20;
		byte var2 = 8;
		byte var3 = 16;
		byte var4 = 4;
		this.a[0].a((float)(-var1 / 2), (float)(-var3 / 2), -1.0F, var1, var3, 2, 0.0F);
		this.a[0].a(0.0F, (float)(0 + var4), 0.0F);
		this.a[5].a((float)(-var1 / 2 + 1), (float)(-var3 / 2 + 1), -1.0F, var1 - 2, var3 - 2, 1, 0.0F);
		this.a[5].a(0.0F, (float)(0 + var4), 0.0F);
		this.a[1].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
		this.a[1].a((float)(-var1 / 2 + 1), (float)(0 + var4), 0.0F);
		this.a[2].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
		this.a[2].a((float)(var1 / 2 - 1), (float)(0 + var4), 0.0F);
		this.a[3].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
		this.a[3].a(0.0F, (float)(0 + var4), (float)(-var3 / 2 + 1));
		this.a[4].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
		this.a[4].a(0.0F, (float)(0 + var4), (float)(var3 / 2 - 1));
		this.a[0].d = (float)Math.PI / 2F;
		this.a[1].e = 4.712389F;
		this.a[2].e = (float)Math.PI / 2F;
		this.a[3].e = (float)Math.PI;
		this.a[5].d = -1.5707964F;
	}

	public void b(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.a[5].b = 4.0F - var3;

		for(int var7 = 0; var7 < 6; ++var7) {
			this.a[var7].a(var6);
		}

	}

	public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
	}
}
