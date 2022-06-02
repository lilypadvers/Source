package net.minecraft.src;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class TileEntityMobSpawner extends CanvasIsomPreview {
	public static final Random h = new Random();
	String[] a = new String[]{" *   * * *   * *** *** *** *** *** ***", " ** ** * **  * *   *   * * * * *    * ", " * * * * * * * **  *   **  *** **   * ", " *   * * *  ** *   *   * * * * *    * ", " *   * * *   * *** *** * * * * *    * "};
	private WorldGenTrees[][] i;
	private float k = 0.0F;
	private String l = "missingno";
	private String[] splashes = new String[]{"MINECRAFT DEMO", "(Stay tuned for more)"};
	public static boolean shw = false;

	public TileEntityMobSpawner() {
		try {
			this.l = this.splashes[h.nextInt(this.splashes.length)];
		} catch (Exception var2) {
		}

	}

	public void g() {
		++this.k;
		if(this.i != null) {
			for(int var1 = 0; var1 < this.i.length; ++var1) {
				for(int var2 = 0; var2 < this.i[var1].length; ++var2) {
					this.i[var1][var2].a();
				}
			}
		}

	}

	protected void a(char var1, int var2) {
	}

	public void a() {
		Calendar var1 = Calendar.getInstance();
		var1.setTime(new Date());
		if(this.b.i.b.equals("athna") && var1.get(2) + 1 == 7 && var1.get(5) == 26 && var1.get(1) == 2010) {
			this.l = "Happy birthday! I love you! Alex x";
		} else if(var1.get(2) + 1 == 11 && var1.get(5) == 9) {
			this.l = "Happy birthday, ez!";
		} else if(var1.get(2) + 1 == 6 && var1.get(5) == 1) {
			this.l = "Happy birthday, Notch!";
		} else if(var1.get(2) + 1 == 12 && var1.get(5) == 24) {
			this.l = "Merry X-mas!";
		} else if(var1.get(2) + 1 == 1 && var1.get(5) == 1) {
			this.l = "Happy new year!";
		}

		this.e.clear();
		this.e.add(new EntitySplashFX(1, this.c / 2 - 100, this.d / 4 + 48, "Singleplayer"));
		this.e.add(new EntitySplashFX(2, this.c / 2 - 100, this.d / 4 + 72, "Multiplayer"));
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 120 + 12, "Options..."));
	}

	protected void a(EntitySplashFX var1) {
		if(!shw) {
			this.b.a((CanvasIsomPreview)(new ScreenInputPass(this.b)));
			shw = true;
		} else {
			if(var1.d == 0) {
				this.b.a((CanvasIsomPreview)(new ItemPickaxe(this, this.b.y)));
			}

			if(var1.d == 1) {
				this.b.a((CanvasIsomPreview)(new MinecraftError(this)));
			}

			if(var1.d == 2) {
				this.b.a((CanvasIsomPreview)(new ChunkLoader(this)));
			}

		}
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		NBTTagByteArray var4 = NBTTagByteArray.a;
		this.a(var3);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.b.n.a("/gui/logo.png"));
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var4.b(0xFFFFFF);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.c / 2 + 90), 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float var5 = (1.8F - ModelPig.e(ModelPig.a((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F)) * 100.0F / (float)(this.g.a(this.l) + 32);
		GL11.glScalef(var5, var5, var5);
		this.a(this.g, this.l, 0, -8, 16776960);
		GL11.glPopMatrix();
		this.b(this.g, "Copyright Mojang. Distribution strictly prohibited.", this.c - this.g.a("Copyright Mojang. Distribution strictly prohibited.") - 2, this.d - 10, 0xFFFFFF);
		long var7 = Runtime.getRuntime().maxMemory();
		long var9 = Runtime.getRuntime().totalMemory();
		String var11 = "Free memory: " + (var7 - Runtime.getRuntime().freeMemory()) * 100L / var7 + "% of " + var7 / 1024L / 1024L + "MB";
		this.b(this.g, var11, this.c - this.g.a(var11) - 2, 2, 8421504);
		String var12 = "Allocated memory: " + var9 * 100L / var7 + "% (" + var9 / 1024L / 1024L + "MB)";
		this.b(this.g, var12, this.c - this.g.a(var12) - 2, 12, 8421504);
		super.a(var1, var2, var3);
	}

	private void a(float var1) {
		int var2;
		int var3;
		if(this.i == null) {
			this.i = new WorldGenTrees[this.a[0].length()][this.a.length];

			for(var2 = 0; var2 < this.i.length; ++var2) {
				for(var3 = 0; var3 < this.i[var2].length; ++var3) {
					this.i[var2][var3] = new WorldGenTrees(this, var2, var3);
				}
			}
		}

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		var2 = 120 * (new EntityFallingSand(this.b.c, this.b.d)).blockID;
		GLU.gluPerspective(70.0F, (float)this.b.c / (float)var2, 0.05F, 100.0F);
		GL11.glViewport(0, this.b.d - var2, this.b.c, var2);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glDepthMask(true);

		for(var3 = 0; var3 < 3; ++var3) {
			GL11.glPushMatrix();
			GL11.glTranslatef(0.4F, 0.6F, -12.0F);
			if(var3 == 0) {
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glTranslatef(0.0F, -0.4F, 0.0F);
				GL11.glScalef(0.98F, 1.0F, 1.0F);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			}

			if(var3 == 1) {
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			}

			if(var3 == 2) {
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
			}

			GL11.glScalef(1.0F, -1.0F, 1.0F);
			GL11.glRotatef(15.0F, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(0.89F, 1.0F, 0.4F);
			GL11.glTranslatef((float)(-this.a[0].length()) * 0.5F, (float)(-this.a.length) * 0.5F, 0.0F);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.b.n.a("/terrain.png"));
			if(var3 == 0) {
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.b.n.a("/title/black.png"));
			}

			GuiCrafting var4 = new GuiCrafting();

			for(int var5 = 0; var5 < this.a.length; ++var5) {
				for(int var6 = 0; var6 < this.a[var5].length(); ++var6) {
					if(this.a[var5].charAt(var6) != 32) {
						GL11.glPushMatrix();
						WorldGenTrees var7 = this.i[var6][var5];
						float var8 = (float)(var7.b + (var7.a - var7.b) * (double)var1);
						float var9 = 1.0F;
						float var10 = 1.0F;
						if(var3 == 0) {
							var9 = var8 * 0.04F + 1.0F;
							var10 = 1.0F / var9;
							var8 = 0.0F;
						}

						GL11.glTranslatef((float)var6, (float)var5, var8);
						GL11.glScalef(var9, var9, var9);
						GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
						var4.a(ln.t, var10);
						GL11.glPopMatrix();
					}
				}
			}

			GL11.glPopMatrix();
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glViewport(0, 0, this.b.c, this.b.d);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}
}
