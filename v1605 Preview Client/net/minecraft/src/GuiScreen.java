package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiScreen extends TileEntityMobSpawnerRenderer {
	private GuiCrafting d = new GuiCrafting();

	public GuiScreen() {
		this.b = 0.5F;
	}

	public void a(BlockStairs var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		this.a("/terrain.png");
		ln var10 = ln.n[var1.a];
		EntitySpider var11 = var1.i();
		GL11.glDisable(GL11.GL_LIGHTING);
		this.d.a(var10, var11, ModelPig.b(var1.ah), ModelPig.b(var1.ai), ModelPig.b(var1.aj));
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((BlockStairs)var1, var2, var4, var6, var8, var9);
	}
}
