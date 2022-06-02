package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class InventoryLargeChest extends CanvasIsomPreview {
	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(1, this.c / 2 - 100, this.d / 4 + 72, "Respawn"));
		this.e.add(new EntitySplashFX(2, this.c / 2 - 100, this.d / 4 + 96, "Title menu"));
		if(this.b.i == null) {
			((EntitySplashFX)this.e.get(1)).e = false;
		}

	}

	protected void a(char var1, int var2) {
	}

	protected void a(EntitySplashFX var1) {
		if(var1.d == 0) {
					}

		if(var1.d == 1) {
			this.b.o();
			this.b.a((CanvasIsomPreview)null);
		}

		if(var1.d == 2) {
			this.b.a((EntitySpider)null);
			this.b.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
		}

	}

	public void a(int var1, int var2, float var3) {
		this.a(0, 0, this.c, this.d, 1615855616, -1602211792);
		GL11.glPushMatrix();
		GL11.glScalef(2.0F, 2.0F, 2.0F);
		this.a(this.g, "Game over!", this.c / 2 / 2, 30, 0xFFFFFF);
		GL11.glPopMatrix();
		this.a(this.g, "Milestone: " + this.b.e.milestone, this.c / 2, 100, 0xFFFFFF);
		super.a(var1, var2, var3);
	}

	public boolean b() {
		return false;
	}
}
