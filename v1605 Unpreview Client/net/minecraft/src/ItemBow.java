package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ItemBow extends TileEntityMobSpawnerRenderer {
	protected RenderMinecart d;
	protected RenderMinecart e;

	public ItemBow(RenderMinecart var1, float var2) {
		this.d = var1;
		this.b = var2;
	}

	public void a(RenderMinecart var1) {
		this.e = var1;
	}

	public void a(RecipesIngots var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.d.j = this.c(var1, var9);
		this.d.k = var1.ac != null;
		if(this.e != null) {
			this.e.k = this.d.k;
		}

		try {
			float var10 = var1.o + (var1.n - var1.o) * var9;
			float var11 = var1.ap + (var1.an - var1.ap) * var9;
			float var12 = var1.aq + (var1.ao - var1.aq) * var9;
			GL11.glTranslatef((float)var2, (float)var4, (float)var6);
			float var13 = this.d(var1, var9);
			GL11.glRotatef(180.0F - var10, 0.0F, 1.0F, 0.0F);
			if(var1.I > 0) {
				float var14 = ModelPig.c(((float)var1.I + var9 - 1.0F) / 20.0F * 1.6F);
				if(var14 > 1.0F) {
					var14 = 1.0F;
				}

				GL11.glRotatef(var14 * this.a(var1), 0.0F, 0.0F, 1.0F);
			}

			GL11.glEnable('\u803a');
			GL11.glScalef(-1.0F, -1.0F, 1.0F);
			this.a(var1, var9);
			GL11.glTranslatef(0.0F, -1.5078125F, 0.0F);
			float var15 = var1.P + (var1.Q - var1.P) * var9;
			float var16 = var1.R - var1.Q * (1.0F - var9);
			if(var15 > 1.0F) {
				var15 = 1.0F;
			}

			this.a(var1.aV, var1.v());
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			boolean var17 = true;
			if(var1 instanceof BlockMobSpawner && ((BlockMobSpawner)var1).i.startsWith("\u0105")) {
				var17 = false;
			}

			if(var17) {
				this.d.b(var16, var15, var13, var11 - var10, var12, 0.0625F);
			}

			for(int var18 = 0; var18 < 4; ++var18) {
				if(this.a(var1, var18)) {
					this.e.b(var16, var15, var13, var11 - var10, var12, 0.0625F);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glEnable(GL11.GL_ALPHA_TEST);
				}
			}

			this.b(var1, var9);
			float var26 = var1.a(var9);
			int var19 = this.a(var1, var26, var9);
			if((var19 >> 24 & 255) > 0 || var1.F > 0 || var1.I > 0) {
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glDepthFunc(GL11.GL_EQUAL);
				if(var1.F > 0 || var1.I > 0) {
					GL11.glColor4f(var26, 0.0F, 0.0F, 0.4F);
					this.d.b(var16, var15, var13, var11 - var10, var12, 0.0625F);

					for(int var20 = 0; var20 < 4; ++var20) {
						if(this.a(var1, var20)) {
							GL11.glColor4f(var26, 0.0F, 0.0F, 0.4F);
							this.e.b(var16, var15, var13, var11 - var10, var12, 0.0625F);
						}
					}
				}

				if((var19 >> 24 & 255) > 0) {
					float var27 = (float)(var19 >> 16 & 255) / 255.0F;
					float var21 = (float)(var19 >> 8 & 255) / 255.0F;
					float var22 = (float)(var19 & 255) / 255.0F;
					float var23 = (float)(var19 >> 24 & 255) / 255.0F;
					GL11.glColor4f(var27, var21, var22, var23);
					this.d.b(var16, var15, var13, var11 - var10, var12, 0.0625F);

					for(int var24 = 0; var24 < 4; ++var24) {
						if(this.a(var1, var24)) {
							GL11.glColor4f(var27, var21, var22, var23);
							this.e.b(var16, var15, var13, var11 - var10, var12, 0.0625F);
						}
					}
				}

				GL11.glDepthFunc(GL11.GL_LEQUAL);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
			}

			GL11.glDisable('\u803a');
		} catch (Exception var25) {
			var25.printStackTrace();
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	protected float c(RecipesIngots var1, float var2) {
		return var1.d(var2);
	}

	protected float d(RecipesIngots var1, float var2) {
		return (float)var1.aO + var2;
	}

	protected void b(RecipesIngots var1, float var2) {
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return false;
	}

	protected float a(RecipesIngots var1) {
		return 90.0F;
	}

	protected int a(RecipesIngots var1, float var2, float var3) {
		return 0;
	}

	protected void a(RecipesIngots var1, float var2) {
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((RecipesIngots)var1, var2, var4, var6, var8, var9);
	}
}
