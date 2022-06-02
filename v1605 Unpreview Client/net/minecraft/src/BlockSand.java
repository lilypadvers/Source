package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class BlockSand extends ItemBow {
	private RenderMinecart f;

	public BlockSand(RenderMinecart var1, RenderMinecart var2, float var3) {
		super(var1, var3);
		this.f = var2;
	}

	protected boolean a(lq var1, int var2) {
		if(var2 == 0) {
			this.a(this.f);
			GL11.glEnable(GL11.GL_NORMALIZE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			return true;
		} else {
			if(var2 == 1) {
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}

			return false;
		}
	}

	protected void a(lq var1, float var2) {
		float var3 = (var1.b + (var1.a - var1.b) * var2) / ((float)var1.c * 0.5F + 1.0F);
		float var4 = 1.0F / (var3 + 1.0F);
		float var5 = (float)var1.c;
		GL11.glScalef(var4 * var5, 1.0F / var4 * var5, var4 * var5);
	}

	protected void a(RecipesIngots var1, float var2) {
		this.a((lq)var1, var2);
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return this.a((lq)var1, var2);
	}
}
