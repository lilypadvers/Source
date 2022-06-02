package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiMainMenu extends TileEntityMobSpawnerRenderer {
	protected RenderMinecart d;

	public GuiMainMenu() {
		this.b = 0.5F;
		this.d = new BlockBookshelf();
	}

	public void a(no var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
		double var10 = var1.aF + (var1.ah - var1.aF) * (double)var9;
		double var12 = var1.aG + (var1.ai - var1.aG) * (double)var9;
		double var14 = var1.aH + (var1.aj - var1.aH) * (double)var9;
		double var16 = (double)0.3F;
		BlockTNT var18 = var1.g(var10, var12, var14);
		float var19 = var1.aq + (var1.ao - var1.aq) * var9;
		if(var18 != null) {
			BlockTNT var20 = var1.a(var10, var12, var14, var16);
			BlockTNT var21 = var1.a(var10, var12, var14, -var16);
			if(var20 == null) {
				var20 = var18;
			}

			if(var21 == null) {
				var21 = var18;
			}

			var2 += var18.a - var10;
			var4 += (var20.b + var21.b) / 2.0D - var12;
			var6 += var18.c - var14;
			BlockTNT var22 = var21.c(-var20.a, -var20.b, -var20.c);
			if(var22.c() != 0.0D) {
				var22 = var22.b();
				var8 = (float)(Math.atan2(var22.c, var22.a) * 180.0D / Math.PI);
				var19 = (float)(Math.atan(var22.b) * 73.0D);
			}
		}

		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-var19, 0.0F, 0.0F, 1.0F);
		float var23 = (float)var1.b - var9;
		float var24 = (float)var1.a - var9;
		if(var24 < 0.0F) {
			var24 = 0.0F;
		}

		if(var23 > 0.0F) {
			GL11.glRotatef(ModelPig.a(var23) * var23 * var24 / 10.0F * (float)var1.c, 1.0F, 0.0F, 0.0F);
		}

		if(var1.d != 0) {
			this.a("/terrain.png");
			float var25 = 0.75F;
			GL11.glScalef(var25, var25, var25);
			GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
			if(var1.d == 1) {
				(new GuiCrafting()).a(ln.au);
			} else if(var1.d == 2) {
				(new GuiCrafting()).a(ln.aB);
			}

			GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, -0.3125F, 0.0F);
			GL11.glScalef(1.0F / var25, 1.0F / var25, 1.0F / var25);
		}

		this.a("/item/cart.png");
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.d.b(0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((no)var1, var2, var4, var6, var8, var9);
	}
}
