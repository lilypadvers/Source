package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public abstract class TileEntityMobSpawnerRenderer {
	protected RenderSpider a;
	private RenderMinecart d = new EntityDiggingFX();
	private GuiCrafting e = new GuiCrafting();
	protected float b = 0.0F;
	protected float c = 1.0F;

	public abstract void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9);

	protected void a(String var1) {
		BlockRedstoneWire var2 = this.a.e;
		var2.b(var2.a(var1));
	}

	protected void a(String var1, String var2) {
		BlockRedstoneWire var3 = this.a.e;
		var3.b(var3.a(var1, var2));
	}

	private void a(EntityMinecart var1, double var2, double var4, double var6, float var8) {
		GL11.glDisable(GL11.GL_LIGHTING);
		int var9 = ln.ar.aZ;
		int var10 = (var9 & 15) << 4;
		int var11 = var9 & 240;
		float var12 = (float)var10 / 256.0F;
		float var13 = ((float)var10 + 15.99F) / 256.0F;
		float var14 = (float)var11 / 256.0F;
		float var15 = ((float)var11 + 15.99F) / 256.0F;
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		float var16 = var1.az * 1.4F;
		GL11.glScalef(var16, var16, var16);
		this.a("/terrain.png");
		NBTTagByteArray var17 = NBTTagByteArray.a;
		float var18 = 1.0F;
		float var19 = 0.5F;
		float var20 = 0.0F;
		float var21 = var1.aA / var1.az;
		GL11.glRotatef(-this.a.i, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(0.0F, 0.0F, 0.4F + (float)((int)var21) * 0.02F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var17.b();

		while(var21 > 0.0F) {
			var17.a((double)(var18 - var19), (double)(0.0F - var20), 0.0D, (double)var13, (double)var15);
			var17.a((double)(0.0F - var19), (double)(0.0F - var20), 0.0D, (double)var12, (double)var15);
			var17.a((double)(0.0F - var19), (double)(1.4F - var20), 0.0D, (double)var12, (double)var14);
			var17.a((double)(var18 - var19), (double)(1.4F - var20), 0.0D, (double)var13, (double)var14);
			--var21;
			--var20;
			var18 *= 0.9F;
			GL11.glTranslatef(0.0F, 0.0F, -0.04F);
		}

		var17.a();
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_LIGHTING);
	}

	private void c(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		BlockRedstoneWire var10 = this.a.e;
		var10.b(var10.a("%%/shadow.png"));
		EntitySpider var11 = this.b();
		GL11.glDepthMask(false);
		float var12 = this.b;
		double var13 = var1.aF + (var1.ah - var1.aF) * (double)var9;
		double var15 = var1.aG + (var1.ai - var1.aG) * (double)var9 + (double)var1.h_();
		double var17 = var1.aH + (var1.aj - var1.aH) * (double)var9;
		int var19 = ModelPig.b(var13 - (double)var12);
		int var20 = ModelPig.b(var13 + (double)var12);
		int var21 = ModelPig.b(var15 - (double)var12);
		int var22 = ModelPig.b(var15);
		int var23 = ModelPig.b(var17 - (double)var12);
		int var24 = ModelPig.b(var17 + (double)var12);
		double var25 = var2 - var13;
		double var27 = var4 - var15;
		double var29 = var6 - var17;
		NBTTagByteArray var31 = NBTTagByteArray.a;
		var31.b();

		for(int var32 = var19; var32 <= var20; ++var32) {
			for(int var33 = var21; var33 <= var22; ++var33) {
				for(int var34 = var23; var34 <= var24; ++var34) {
					int var35 = var11.a(var32, var33 - 1, var34);
					if(var35 > 0 && var11.j(var32, var33, var34) > 3) {
						this.a(ln.n[var35], var2, var4 + (double)var1.h_(), var6, var32, var33, var34, var8, var12, var25, var27 + (double)var1.h_(), var29);
					}
				}
			}
		}

		var31.a();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
	}

	private EntitySpider b() {
		return this.a.g;
	}

	private void a(ln var1, double var2, double var4, double var6, int var8, int var9, int var10, float var11, float var12, double var13, double var15, double var17) {
		NBTTagByteArray var19 = NBTTagByteArray.a;
		if(var1.c()) {
			double var20 = ((double)var11 - (var4 - ((double)var9 + var15)) / 2.0D) * 0.5D * (double)this.b().c(var8, var9, var10);
			if(var20 >= 0.0D) {
				if(var20 > 1.0D) {
					var20 = 1.0D;
				}

				var19.a(1.0F, 1.0F, 1.0F, (float)var20);
				double var22 = (double)var8 + var1.bd + var13;
				double var24 = (double)var8 + var1.bg + var13;
				double var26 = (double)var9 + var1.be + var15 + 0.015625D;
				double var28 = (double)var10 + var1.bf + var17;
				double var30 = (double)var10 + var1.bi + var17;
				float var32 = (float)((var2 - var22) / 2.0D / (double)var12 + 0.5D);
				float var33 = (float)((var2 - var24) / 2.0D / (double)var12 + 0.5D);
				float var34 = (float)((var6 - var28) / 2.0D / (double)var12 + 0.5D);
				float var35 = (float)((var6 - var30) / 2.0D / (double)var12 + 0.5D);
				var19.a(var22, var26, var28, (double)var32, (double)var34);
				var19.a(var22, var26, var30, (double)var32, (double)var35);
				var19.a(var24, var26, var30, (double)var33, (double)var35);
				var19.a(var24, var26, var28, (double)var33, (double)var34);
			}
		}
	}

	public static void a(EntityRenderer var0, double var1, double var3, double var5) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		NBTTagByteArray var7 = NBTTagByteArray.a;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var7.b();
		var7.b(var1, var3, var5);
		var7.b(0.0F, 0.0F, -1.0F);
		var7.a(var0.a, var0.e, var0.c);
		var7.a(var0.d, var0.e, var0.c);
		var7.a(var0.d, var0.b, var0.c);
		var7.a(var0.a, var0.b, var0.c);
		var7.b(0.0F, 0.0F, 1.0F);
		var7.a(var0.a, var0.b, var0.f);
		var7.a(var0.d, var0.b, var0.f);
		var7.a(var0.d, var0.e, var0.f);
		var7.a(var0.a, var0.e, var0.f);
		var7.b(0.0F, -1.0F, 0.0F);
		var7.a(var0.a, var0.b, var0.c);
		var7.a(var0.d, var0.b, var0.c);
		var7.a(var0.d, var0.b, var0.f);
		var7.a(var0.a, var0.b, var0.f);
		var7.b(0.0F, 1.0F, 0.0F);
		var7.a(var0.a, var0.e, var0.f);
		var7.a(var0.d, var0.e, var0.f);
		var7.a(var0.d, var0.e, var0.c);
		var7.a(var0.a, var0.e, var0.c);
		var7.b(-1.0F, 0.0F, 0.0F);
		var7.a(var0.a, var0.b, var0.f);
		var7.a(var0.a, var0.e, var0.f);
		var7.a(var0.a, var0.e, var0.c);
		var7.a(var0.a, var0.b, var0.c);
		var7.b(1.0F, 0.0F, 0.0F);
		var7.a(var0.d, var0.b, var0.c);
		var7.a(var0.d, var0.e, var0.c);
		var7.a(var0.d, var0.e, var0.f);
		var7.a(var0.d, var0.b, var0.f);
		var7.b(0.0D, 0.0D, 0.0D);
		var7.a();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public static void a(EntityRenderer var0) {
		NBTTagByteArray var1 = NBTTagByteArray.a;
		var1.b();
		var1.a(var0.a, var0.e, var0.c);
		var1.a(var0.d, var0.e, var0.c);
		var1.a(var0.d, var0.b, var0.c);
		var1.a(var0.a, var0.b, var0.c);
		var1.a(var0.a, var0.b, var0.f);
		var1.a(var0.d, var0.b, var0.f);
		var1.a(var0.d, var0.e, var0.f);
		var1.a(var0.a, var0.e, var0.f);
		var1.a(var0.a, var0.b, var0.c);
		var1.a(var0.d, var0.b, var0.c);
		var1.a(var0.d, var0.b, var0.f);
		var1.a(var0.a, var0.b, var0.f);
		var1.a(var0.a, var0.e, var0.f);
		var1.a(var0.d, var0.e, var0.f);
		var1.a(var0.d, var0.e, var0.c);
		var1.a(var0.a, var0.e, var0.c);
		var1.a(var0.a, var0.b, var0.f);
		var1.a(var0.a, var0.e, var0.f);
		var1.a(var0.a, var0.e, var0.c);
		var1.a(var0.a, var0.b, var0.c);
		var1.a(var0.d, var0.b, var0.c);
		var1.a(var0.d, var0.e, var0.c);
		var1.a(var0.d, var0.e, var0.f);
		var1.a(var0.d, var0.b, var0.f);
		var1.a();
	}

	public void a(RenderSpider var1) {
		this.a = var1;
	}

	public void b(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		if(this.a.k.i && this.b > 0.0F) {
			double var10 = this.a.a(var1.ah, var1.ai, var1.aj);
			float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.c);
			if(var12 > 0.0F) {
				this.c(var1, var2, var4, var6, var12, var9);
			}
		}

		if(var1.aQ > 0) {
			this.a(var1, var2, var4, var6, var9);
		}

	}

	public BlockDoor a() {
		return this.a.a();
	}
}
