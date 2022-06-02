package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class BlockTorch extends TileEntityMobSpawnerRenderer {
	private GuiCrafting d = new GuiCrafting();

	public BlockTorch() {
		this.b = 0.5F;
	}

	public void a(EntityRainFX var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		float var10;
		if((float)var1.a - var9 + 1.0F < 10.0F) {
			var10 = 1.0F - ((float)var1.a - var9 + 1.0F) / 10.0F;
			if(var10 < 0.0F) {
				var10 = 0.0F;
			}

			if(var10 > 1.0F) {
				var10 = 1.0F;
			}

			var10 *= var10;
			var10 *= var10;
			float var11 = 1.0F + var10 * 0.3F;
			GL11.glScalef(var11, var11, var11);
		}

		var10 = (1.0F - ((float)var1.a - var9 + 1.0F) / 100.0F) * 0.8F;
		this.a("/terrain.png");
		this.d.a(ln.am);
		if(var1.a / 5 % 2 == 0) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var10);
			this.d.a(ln.am);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		GL11.glPopMatrix();
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((EntityRainFX)var1, var2, var4, var6, var8, var9);
	}
}
