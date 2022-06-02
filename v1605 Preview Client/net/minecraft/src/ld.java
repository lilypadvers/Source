package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ld extends CraftingRecipe {
	private LoadingScreenRenderer k;
	private WorldIso l = new lo();
	private float m;
	private float n;

	public ld(WorldIso var1, TileEntityFurnace[] var2) {
		this.running = true;
		this.k = new LoadingScreenRenderer(this, var2);
		this.i.add(new TileEntityChest(this, this.k, this.l, 0, 144, 36));

		int var3;
		int var4;
		for(var3 = 0; var3 < 2; ++var3) {
			for(var4 = 0; var4 < 2; ++var4) {
				this.i.add(new PathEntity(this, this.k, var4 + var3 * 2, 88 + var4 * 18, 26 + var3 * 18));
			}
		}

		for(var3 = 0; var3 < 4; ++var3) {
			this.i.add(new ky(this, this, var1, var1.a() - 1 - var3, 8, 8 + var3 * 18, var3));
		}

		for(var3 = 0; var3 < 3; ++var3) {
			for(var4 = 0; var4 < 9; ++var4) {
				this.i.add(new PathEntity(this, var1, var4 + (var3 + 1) * 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for(var3 = 0; var3 < 9; ++var3) {
			this.i.add(new PathEntity(this, var1, var3, 8 + var3 * 18, 142));
		}

		this.a(this.k);
	}

	public void a(WorldIso var1) {
		int[] var2 = new int[9];

		for(int var3 = 0; var3 < 3; ++var3) {
			for(int var4 = 0; var4 < 3; ++var4) {
				int var5 = -1;
				if(var3 < 2 && var4 < 2) {
					TileEntityFurnace var6 = this.k.a_(var3 + var4 * 2);
					if(var6 != null) {
						var5 = var6.c;
					}
				}

				var2[var3 + var4 * 3] = var5;
			}
		}

		this.l.a(0, ItemMinecart.a().a(var2));
	}

	protected void j() {
		this.g.b("Crafting", 86, 16, 0xFFFFFF);
	}

	public void a(int var1, int var2, float var3) {
		super.a(var1, var2, var3);
		this.m = (float)var1;
		this.n = (float)var2;
	}

	protected void a(float var1) {
		int var2 = this.b.n.a("/gui/inventory.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.b.n.b(var2);
		int var3 = (this.c - this.resultId) / 2;
		int var4 = (this.d - this.h) / 2;
		this.b(var3, var4, 0, 0, this.resultId, this.h);
		GL11.glEnable('\u803a');
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(var3 + 51), (float)(var4 + 75), 50.0F);
		float var5 = 30.0F;
		GL11.glScalef(-var5, var5, var5);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		float var6 = this.b.g.n;
		float var7 = this.b.g.an;
		float var8 = this.b.g.ao;
		float var9 = (float)(var3 + 51) - this.m;
		float var10 = (float)(var4 + 75 - 50) - this.n;
		GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		BlockOre.b();
		GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-((float)Math.atan((double)(var10 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
		this.b.g.n = (float)Math.atan((double)(var9 / 40.0F)) * 20.0F;
		this.b.g.an = (float)Math.atan((double)(var9 / 40.0F)) * 40.0F;
		this.b.g.ao = -((float)Math.atan((double)(var10 / 40.0F))) * 20.0F;
		GL11.glTranslatef(0.0F, this.b.g.ay, 0.0F);
		RenderSpider.a.a(this.b.g, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
		this.b.g.n = var6;
		this.b.g.an = var7;
		this.b.g.ao = var8;
		GL11.glPopMatrix();
		BlockOre.a();
		GL11.glDisable('\u803a');
	}
}
