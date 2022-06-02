package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class NBTBase extends CraftingRecipe {
	private Path k;

	public NBTBase(BlockStone var1, Path var2) {
		this.k = var2;
		this.i.add(new PathEntity(this, var2, 0, 56, 17));
		this.i.add(new PathEntity(this, var2, 1, 56, 53));
		this.i.add(new PathEntity(this, var2, 2, 116, 35));

		int var3;
		for(var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 9; ++var4) {
				this.i.add(new PathEntity(this, var1, var4 + (var3 + 1) * 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for(var3 = 0; var3 < 9; ++var3) {
			this.i.add(new PathEntity(this, var1, var3, 8 + var3 * 18, 142));
		}

	}

	protected void j() {
		this.g.b("Furnace", 60, 6, 0xFFFFFF);
		this.g.b("Inventory", 8, this.h - 96 + 2, 0xFFFFFF);
	}

	protected void a(float var1) {
		int var2 = this.b.n.a("/gui/furnace.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.b.n.b(var2);
		int var3 = (this.c - this.resultId) / 2;
		int var4 = (this.d - this.h) / 2;
		this.b(var3, var4, 0, 0, this.resultId, this.h);
		int var5;
		if(this.k.g()) {
			var5 = this.k.c(12);
			this.b(var3 + 56, var4 + 36 + 12 - var5, 176, 12 - var5, 14, var5 + 2);
		}

		var5 = this.k.b(24);
		this.b(var3 + 79, var4 + 34, 176, 14, var5 + 1, 16);
	}
}
