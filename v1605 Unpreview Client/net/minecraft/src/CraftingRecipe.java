package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public abstract class CraftingRecipe extends CanvasIsomPreview {
	private static ModelMinecart k = new ModelMinecart();
	private TileEntityFurnace l = null;
	protected int resultId = 176;
	protected int h = 166;
	protected List i = new ArrayList();

	public void a(int var1, int var2, float var3) {
		this.i();
		int var4 = (this.c - this.resultId) / 2;
		int var5 = (this.d - this.h) / 2;
		this.a(var3);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		BlockOre.b();
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		GL11.glTranslatef((float)var4, (float)var5, 0.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glEnable('\u803a');

		for(int var6 = 0; var6 < this.i.size(); ++var6) {
			PathEntity var7 = (PathEntity)this.i.get(var6);
			this.a(var7);
			if(var7.a(var1, var2)) {
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				int var8 = var7.b;
				int var9 = var7.pathIndex;
				this.a(var8, var9, var8 + 16, var9 + 16, -2130706433, -2130706433);
				GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
			}
		}

		if(this.l != null) {
			GL11.glTranslatef(0.0F, 0.0F, 32.0F);
			k.a(this.g, this.b.n, this.l, var1 - var4 - 8, var2 - var5 - 8);
			k.b(this.g, this.b.n, this.l, var1 - var4 - 8, var2 - var5 - 8);
		}

		GL11.glDisable('\u803a');
		BlockOre.a();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		this.j();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
	}

	protected void j() {
	}

	protected abstract void a(float var1);

	private void a(PathEntity var1) {
		WorldIso var2 = var1.d;
		int var3 = var1.pathLength;
		int var4 = var1.b;
		int var5 = var1.pathIndex;
		TileEntityFurnace var6 = var2.a_(var3);
		if(var6 == null) {
			int var7 = var1.c();
			if(var7 >= 0) {
				GL11.glDisable(GL11.GL_LIGHTING);
				this.b.n.b(this.b.n.a("/gui/items.png"));
				this.b(var4, var5, var7 % 16 * 16, var7 / 16 * 16, 16, 16);
				GL11.glEnable(GL11.GL_LIGHTING);
				return;
			}
		}

		k.a(this.g, this.b.n, var6, var4, var5);
		k.b(this.g, this.b.n, var6, var4, var5);
	}

	private PathEntity a(int var1, int var2) {
		for(int var3 = 0; var3 < this.i.size(); ++var3) {
			PathEntity var4 = (PathEntity)this.i.get(var3);
			if(var4.a(var1, var2)) {
				return var4;
			}
		}

		return null;
	}

	protected void a(int var1, int var2, int var3) {
		if(var3 == 0 || var3 == 1) {
			PathEntity var4 = this.a(var1, var2);
			int var6;
			if(var4 != null) {
				var4.d();
				TileEntityFurnace var5 = var4.b();
				if(var5 != null || this.l != null) {
					if(var5 != null && this.l == null) {
						var6 = var3 == 0?var5.a:(var5.a + 1) / 2;
						this.l = var4.d.a(var4.pathLength, var6);
						if(var5.a == 0) {
							var4.b((TileEntityFurnace)null);
						}

						var4.incrementPathIndex();
					} else if(var5 == null && this.l != null && var4.a(this.l)) {
						var6 = var3 == 0?this.l.a:1;
						if(var6 > var4.d.c()) {
							var6 = var4.d.c();
						}

						var4.b(this.l.a(var6));
						if(this.l.a == 0) {
							this.l = null;
						}
					} else if(var5 != null && this.l != null) {
						if(var4.a(this.l)) {
							if(var5.c != this.l.c) {
								if(this.l.a <= var4.d.c()) {
									var4.b(this.l);
									this.l = var5;
								}
							} else if(var5.c == this.l.c) {
								if(var3 == 0) {
									var6 = this.l.a;
									if(var6 > var4.d.c() - var5.a) {
										var6 = var4.d.c() - var5.a;
									}

									if(var6 > this.l.c() - var5.a) {
										var6 = this.l.c() - var5.a;
									}

									this.l.a(var6);
									if(this.l.a == 0) {
										this.l = null;
									}

									var5.a += var6;
								} else if(var3 == 1) {
									var6 = 1;
									if(var6 > var4.d.c() - var5.a) {
										var6 = var4.d.c() - var5.a;
									}

									if(var6 > this.l.c() - var5.a) {
										var6 = this.l.c() - var5.a;
									}

									this.l.a(var6);
									if(this.l.a == 0) {
										this.l = null;
									}

									var5.a += var6;
								}
							}
						} else if(var5.c == this.l.c && this.l.c() > 1) {
							var6 = var5.a;
							if(var6 > 0 && var6 + this.l.a <= this.l.c()) {
								this.l.a += var6;
								var5.a(var6);
								if(var5.a == 0) {
									var4.b((TileEntityFurnace)null);
								}

								var4.incrementPathIndex();
							}
						}
					}
				}
			} else if(this.l != null) {
				int var8 = (this.c - this.resultId) / 2;
				var6 = (this.d - this.h) / 2;
				if(var1 < var8 || var2 < var6 || var1 >= var8 + this.resultId || var2 >= var6 + this.resultId) {
					GuiDeleteWorld var7 = this.b.g;
					if(var3 == 0) {
						var7.a(this.l);
						this.l = null;
					}

					if(var3 == 1) {
						var7.a(this.l.a(1));
						if(this.l.a == 0) {
							this.l = null;
						}
					}
				}
			}
		}

	}

	protected void b(int var1, int var2, int var3) {
		if(var3 == 0) {
					}

	}

	protected void a(char var1, int var2) {
		if(var2 == 1 || var2 == this.b.y.o.b) {
			this.b.a((CanvasIsomPreview)null);
		}

	}

	public void h() {
		if(this.l != null) {
			this.b.g.a((TileEntityFurnace)this.l);
		}

	}

	public void a(WorldIso var1) {
	}

	public boolean b() {
		return false;
	}
}
