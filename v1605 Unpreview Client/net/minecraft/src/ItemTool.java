package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ItemTool extends CraftingRecipe {
	private WorldIso k;
	private WorldIso l;
	private int m = 0;

	public ItemTool(WorldIso var1, WorldIso var2) {
		this.k = var1;
		this.l = var2;
		this.running = false;
		this.m = var2.a() / 9;
		this.h = 114 + this.m * 18;
		int var4 = (this.m - 4) * 18;

		int var5;
		int var6;
		for(var5 = 0; var5 < this.m; ++var5) {
			for(var6 = 0; var6 < 9; ++var6) {
				this.i.add(new PathEntity(this, var2, var6 + var5 * 9, 8 + var6 * 18, 18 + var5 * 18));
			}
		}

		for(var5 = 0; var5 < 3; ++var5) {
			for(var6 = 0; var6 < 9; ++var6) {
				this.i.add(new PathEntity(this, var1, var6 + (var5 + 1) * 9, 8 + var6 * 18, 103 + var5 * 18 + var4));
			}
		}

		for(var5 = 0; var5 < 9; ++var5) {
			this.i.add(new PathEntity(this, var1, var5, 8 + var5 * 18, 161 + var4));
		}

	}

	protected void j() {
		this.g.b(this.l.b(), 8, 6, 0xFFFFFF);
		this.g.b(this.k.b(), 8, this.h - 96 + 2, 0xFFFFFF);
	}

	protected void a(float var1) {
		int var2 = this.b.n.a("/gui/container.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.b.n.b(var2);
		int var3 = (this.c - this.resultId) / 2;
		int var4 = (this.d - this.h) / 2;
		this.b(var3, var4, 0, 0, this.resultId, this.m * 18 + 17);
		this.b(var3, var4 + this.m * 18 + 17, 0, 126, this.resultId, 96);
	}
}
