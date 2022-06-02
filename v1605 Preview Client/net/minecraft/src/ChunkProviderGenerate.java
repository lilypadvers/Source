package net.minecraft.src;

public class ChunkProviderGenerate extends RenderMinecart {
	public TileEntitySpecialRenderer a;
	public TileEntitySpecialRenderer b;
	public TileEntitySpecialRenderer c;
	public TileEntitySpecialRenderer d;
	public TileEntitySpecialRenderer e;
	public TileEntitySpecialRenderer f;
	public TileEntitySpecialRenderer g;
	public TileEntitySpecialRenderer h;
	public TileEntitySpecialRenderer i;
	public TileEntitySpecialRenderer l;
	public TileEntitySpecialRenderer m;

	public ChunkProviderGenerate() {
		float var1 = 0.0F;
		byte var2 = 15;
		this.a = new TileEntitySpecialRenderer(32, 4);
		this.a.a(-4.0F, -4.0F, -8.0F, 8, 8, 8, var1);
		this.a.a(0.0F, (float)(0 + var2), -3.0F);
		this.b = new TileEntitySpecialRenderer(0, 0);
		this.b.a(-3.0F, -3.0F, -3.0F, 6, 6, 6, var1);
		this.b.a(0.0F, (float)var2, 0.0F);
		this.c = new TileEntitySpecialRenderer(0, 12);
		this.c.a(-5.0F, -4.0F, -6.0F, 10, 8, 12, var1);
		this.c.a(0.0F, (float)(0 + var2), 9.0F);
		this.d = new TileEntitySpecialRenderer(18, 0);
		this.d.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.d.a(-4.0F, (float)(0 + var2), 2.0F);
		this.e = new TileEntitySpecialRenderer(18, 0);
		this.e.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.e.a(4.0F, (float)(0 + var2), 2.0F);
		this.f = new TileEntitySpecialRenderer(18, 0);
		this.f.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.f.a(-4.0F, (float)(0 + var2), 1.0F);
		this.g = new TileEntitySpecialRenderer(18, 0);
		this.g.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.g.a(4.0F, (float)(0 + var2), 1.0F);
		this.h = new TileEntitySpecialRenderer(18, 0);
		this.h.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.h.a(-4.0F, (float)(0 + var2), 0.0F);
		this.i = new TileEntitySpecialRenderer(18, 0);
		this.i.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.i.a(4.0F, (float)(0 + var2), 0.0F);
		this.l = new TileEntitySpecialRenderer(18, 0);
		this.l.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.l.a(-4.0F, (float)(0 + var2), -1.0F);
		this.m = new TileEntitySpecialRenderer(18, 0);
		this.m.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.m.a(4.0F, (float)(0 + var2), -1.0F);
	}

	public void b(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.setBlockBounds(var1, var2, var3, var4, var5, var6);
		this.a.a(var6);
		this.b.a(var6);
		this.c.a(var6);
		this.d.a(var6);
		this.e.a(var6);
		this.f.a(var6);
		this.g.a(var6);
		this.h.a(var6);
		this.i.a(var6);
		this.l.a(var6);
		this.m.a(var6);
	}

	public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.a.e = var4 / 57.295776F;
		this.a.d = var5 / 57.295776F;
		float var7 = 0.7853982F;
		this.d.f = -var7;
		this.e.f = var7;
		this.f.f = -var7 * 0.74F;
		this.g.f = var7 * 0.74F;
		this.h.f = -var7 * 0.74F;
		this.i.f = var7 * 0.74F;
		this.l.f = -var7;
		this.m.f = var7;
		float var8 = -0.0F;
		float var9 = 0.3926991F;
		this.d.e = var9 * 2.0F + var8;
		this.e.e = -var9 * 2.0F - var8;
		this.f.e = var9 * 1.0F + var8;
		this.g.e = -var9 * 1.0F - var8;
		this.h.e = -var9 * 1.0F + var8;
		this.i.e = var9 * 1.0F - var8;
		this.l.e = -var9 * 2.0F + var8;
		this.m.e = var9 * 2.0F - var8;
		float var10 = -(ModelPig.b(var1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * var2;
		float var11 = -(ModelPig.b(var1 * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * var2;
		float var12 = -(ModelPig.b(var1 * 0.6662F * 2.0F + (float)Math.PI / 2F) * 0.4F) * var2;
		float var13 = -(ModelPig.b(var1 * 0.6662F * 2.0F + 4.712389F) * 0.4F) * var2;
		float var14 = Math.abs(ModelPig.a(var1 * 0.6662F + 0.0F) * 0.4F) * var2;
		float var15 = Math.abs(ModelPig.a(var1 * 0.6662F + (float)Math.PI) * 0.4F) * var2;
		float var16 = Math.abs(ModelPig.a(var1 * 0.6662F + (float)Math.PI / 2F) * 0.4F) * var2;
		float var17 = Math.abs(ModelPig.a(var1 * 0.6662F + 4.712389F) * 0.4F) * var2;
		this.d.e += var10;
		this.e.e += -var10;
		this.f.e += var11;
		this.g.e += -var11;
		this.h.e += var12;
		this.i.e += -var12;
		this.l.e += var13;
		this.m.e += -var13;
		this.d.f += var14;
		this.e.f += -var14;
		this.f.f += var15;
		this.g.f += -var15;
		this.h.f += var16;
		this.i.f += -var16;
		this.l.f += var17;
		this.m.f += -var17;
	}
}
