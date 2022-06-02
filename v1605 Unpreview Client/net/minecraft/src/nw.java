package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class nw extends ItemBow {
	public nw() {
		super(new ChunkProviderGenerate(), 1.0F);
		this.a((RenderMinecart)(new ChunkProviderGenerate()));
	}

	protected float a(TextureFX var1) {
		return 180.0F;
	}

	protected boolean a(TextureFX var1, int var2) {
		if(var2 != 0) {
			return false;
		} else if(var2 != 0) {
			return false;
		} else {
			this.a((String)"/mob/spider_eyes.png");
			float var3 = (1.0F - var1.a(1.0F)) * 0.5F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var3);
			return true;
		}
	}

	protected float a(RecipesIngots var1) {
		return this.a((TextureFX)var1);
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return this.a((TextureFX)var1, var2);
	}
}
