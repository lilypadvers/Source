package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class PositionTexureVertex extends CraftingRecipe {
	private LoadingScreenRenderer k = new LoadingScreenRenderer(this, 3, 3);
	private WorldIso l = new lo();

	public PositionTexureVertex(BlockStone var1) {
		this.i.add(new TileEntityChest(this, this.k, this.l, 0, 124, 35));

		int var2;
		int var3;
		for(var2 = 0; var2 < 3; ++var2) {
			for(var3 = 0; var3 < 3; ++var3) {
				this.i.add(new PathEntity(this, this.k, var3 + var2 * 3, 30 + var3 * 18, 17 + var2 * 18));
			}
		}

		for(var2 = 0; var2 < 3; ++var2) {
			for(var3 = 0; var3 < 9; ++var3) {
				this.i.add(new PathEntity(this, var1, var3 + (var2 + 1) * 9, 8 + var3 * 18, 84 + var2 * 18));
			}
		}

		for(var2 = 0; var2 < 9; ++var2) {
			this.i.add(new PathEntity(this, var1, var2, 8 + var2 * 18, 142));
		}

	}

	public void h() {
		super.h();

		for(int var1 = 0; var1 < 9; ++var1) {
			TileEntityFurnace var2 = this.k.a_(var1);
			if(var2 != null) {
				this.b.g.a((TileEntityFurnace)var2);
			}
		}

	}

	public void a(WorldIso var1) {
		int[] var2 = new int[9];

		for(int var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 3; ++var4) {
				int var5 = var3 + var4 * 3;
				TileEntityFurnace var6 = this.k.a_(var5);
				if(var6 == null) {
					var2[var5] = -1;
				} else {
					var2[var5] = var6.c;
				}
			}
		}

		this.l.a(0, ItemMinecart.a().a(var2));
	}

	protected void j() {
		this.g.b("Crafting", 28, 6, 0xFFFFFF);
		this.g.b("Inventory", 8, this.h - 96 + 2, 0xFFFFFF);
	}

	protected void a(float var1) {
		int var2 = this.b.n.a("/gui/crafting.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.b.n.b(var2);
		int var3 = (this.c - this.resultId) / 2;
		int var4 = (this.d - this.h) / 2;
		this.b(var3, var4, 0, 0, this.resultId, this.h);
	}
}
