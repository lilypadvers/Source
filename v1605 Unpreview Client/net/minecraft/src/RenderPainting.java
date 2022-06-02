package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderPainting extends TileEntityMobSpawnerRenderer {
	public void a(StepSoundGlass var1, double var2, double var4, double var6, float var8, float var9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var2, (float)var4, (float)var6);
		GL11.glEnable('\u803a');
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		int var10 = EntityTNTPrimed.aB.a((TileEntityFurnace)null);
		this.a("/gui/items.png");
		NBTTagByteArray var11 = NBTTagByteArray.a;
		float var12 = (float)(var10 % 16 * 16 + 0) / 256.0F;
		float var13 = (float)(var10 % 16 * 16 + 16) / 256.0F;
		float var14 = (float)(var10 / 16 * 16 + 0) / 256.0F;
		float var15 = (float)(var10 / 16 * 16 + 16) / 256.0F;
		float var16 = 1.0F;
		float var17 = 0.5F;
		float var18 = 0.25F;
		GL11.glRotatef(180.0F - this.a.i, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.a.j, 1.0F, 0.0F, 0.0F);
		var11.b();
		var11.b(0.0F, 1.0F, 0.0F);
		var11.a((double)(0.0F - var17), (double)(0.0F - var18), 0.0D, (double)var12, (double)var15);
		var11.a((double)(var16 - var17), (double)(0.0F - var18), 0.0D, (double)var13, (double)var15);
		var11.a((double)(var16 - var17), (double)(1.0F - var18), 0.0D, (double)var13, (double)var14);
		var11.a((double)(0.0F - var17), (double)(1.0F - var18), 0.0D, (double)var12, (double)var14);
		var11.a();
		GL11.glDisable('\u803a');
		GL11.glPopMatrix();
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((StepSoundGlass)var1, var2, var4, var6, var8, var9);
	}
}
