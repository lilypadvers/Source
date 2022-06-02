package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.GL11;

public class lk extends lb {
	private static ModelMinecart d = new ModelMinecart();
	private List e = new ArrayList();
	private Random f = new Random();
	private net.minecraft.client.Minecraft g;
	public String a = null;
	private int h = 0;
	private String i = "";
	private int k = 0;
	public float b;
	float c = 1.0F;

	public void a(float var1, boolean var2, int var3, int var4) {
		EntityFallingSand var5 = new EntityFallingSand(this.g.c, this.g.d);
		int var6 = var5.a();
		int var7 = var5.b();
		BlockDoor var8 = this.g.o;
		this.g.r.b();
		GL11.glEnable(GL11.GL_BLEND);
		if(this.g.y.i) {
			this.a(this.g.g.a(var1), var6, var7);
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.g.n.a("/gui/gui.png"));
		BlockStone var9 = this.g.g.b;
		this.j = -90.0F;
		this.b(var6 / 2 - 91, var7 - 22, 0, 0, 182, 22);
		this.b(var6 / 2 - 91 - 1 + var9.d * 20, var7 - 22 - 1, 0, 22, 24, 22);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.g.n.a("/gui/icons.png"));
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR, GL11.GL_ONE_MINUS_SRC_COLOR);
		this.b(var6 / 2 - 7, var7 / 2 - 7, 0, 0, 16, 16);
		GL11.glDisable(GL11.GL_BLEND);
		boolean var10 = this.g.g.aT / 3 % 2 == 1;
		if(this.g.g.aT < 10) {
			var10 = false;
		}

		int var11 = this.g.g.D;
		int var12 = this.g.g.E;
		this.f.setSeed((long)(this.h * 312871));
		int var14;
		int var15;
		int var16;
		if(this.g.b.e()) {
			int var13 = this.g.g.l();

			for(var14 = 0; var14 < 10; ++var14) {
				var15 = var7 - 32;
				if(var13 > 0) {
					var16 = var6 / 2 + 91 - var14 * 8 - 9;
					if(var14 * 2 + 1 < var13) {
						this.b(var16, var15, 34, 9, 9, 9);
					}

					if(var14 * 2 + 1 == var13) {
						this.b(var16, var15, 25, 9, 9, 9);
					}

					if(var14 * 2 + 1 > var13) {
						this.b(var16, var15, 16, 9, 9, 9);
					}
				}

				byte var28 = 0;
				if(var10) {
					var28 = 1;
				}

				int var17 = var6 / 2 - 91 + var14 * 8;
				if(var11 <= 4) {
					var15 += this.f.nextInt(2);
				}

				this.b(var17, var15, 16 + var28 * 9, 0, 9, 9);
				if(var10) {
					if(var14 * 2 + 1 < var12) {
						this.b(var17, var15, 70, 0, 9, 9);
					}

					if(var14 * 2 + 1 == var12) {
						this.b(var17, var15, 79, 0, 9, 9);
					}
				}

				if(var14 * 2 + 1 < var11) {
					this.b(var17, var15, 52, 0, 9, 9);
				}

				if(var14 * 2 + 1 == var11) {
					this.b(var17, var15, 61, 0, 9, 9);
				}
			}

			if(this.g.g.a((EntitySkeleton)EntitySkeleton.f)) {
				var14 = (int)Math.ceil((double)(this.g.g.aU - 2) * 10.0D / 300.0D);
				var15 = (int)Math.ceil((double)this.g.g.aU * 10.0D / 300.0D) - var14;

				for(byte var29 = 0; var29 < var14 + var15; ++var29) {
					if(var29 < var14) {
						this.b(var6 / 2 - 91 + var29 * 8, var7 - 32 - 9, 16, 18, 9, 9);
					} else {
						this.b(var6 / 2 - 91 + var29 * 8, var7 - 32 - 9, 25, 18, 9, 9);
					}
				}
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable('\u803a');
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GLStatics.b();
		GL11.glPopMatrix();

		for(byte var23 = 0; var23 < 9; ++var23) {
			var14 = var6 / 2 - 90 + var23 * 20 + 2;
			var15 = var7 - 16 - 3;
			this.a(var23, var14, var15, var1);
		}

		GLStatics.a();
		GL11.glDisable('\u803a');
		if(this.g.y.editingBlocks) {
			var8.a("Minecraft Alpha v1.0.16.05 [PREVIEW] (" + this.g.G + ")", 2, 2, 0xFFFFFF);
			var8.a(this.g.l(), 2, 12, 0xFFFFFF);
			var8.a(this.g.m(), 2, 22, 0xFFFFFF);
			var8.a(this.g.n(), 2, 32, 0xFFFFFF);
			long var25 = Runtime.getRuntime().maxMemory();
			long var31 = Runtime.getRuntime().totalMemory();
			long var18 = Runtime.getRuntime().freeMemory();
			long var20 = var31 - var18;
			String var22 = "Used memory: " + var20 * 100L / var25 + "% (" + var20 / 1024L / 1024L + "MB) of " + var25 / 1024L / 1024L + "MB";
			this.b(var8, var22, var6 - var8.a(var22) - 2, 2, 14737632);
			var22 = "Allocated memory: " + var31 * 100L / var25 + "% (" + var31 / 1024L / 1024L + "MB)";
			this.b(var8, var22, var6 - var8.a(var22) - 2, 12, 14737632);
		} else {
			var8.a("Minecraft Alpha v1.0.16.05 [PREVIEW]", 2, 2, 0xFFFFFF);
			var8.a(TileEntityMobSpawner.timeRemaining(), 2, 12, 0xFFFFFF);
		}

		if(this.k > 0) {
			float var26 = (float)this.k - var1;
			var15 = (int)(var26 * 256.0F / 20.0F);
			if(var15 > 255) {
				var15 = 255;
			}

			if(var15 > 0) {
				GL11.glPushMatrix();
				GL11.glTranslatef((float)(var6 / 2), (float)(var7 - 48), 0.0F);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				var16 = Color.HSBtoRGB(var26 / 50.0F, 0.7F, 0.6F) & 0xFFFFFF;
				var8.b(this.i, -var8.a(this.i) / 2, -4, var16 + (var15 << 24));
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glPopMatrix();
			}
		}

		byte var24 = 10;
		boolean var27 = false;
		if(this.g.p instanceof EntityPainting) {
			var24 = 20;
			var27 = true;
		}

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, (float)(var7 - 48), 0.0F);

		for(byte var30 = 0; var30 < this.e.size() && var30 < var24; ++var30) {
			if(((Chunk)this.e.get(var30)).b < 200 || var27) {
				double var33 = (double)((Chunk)this.e.get(var30)).b / 200.0D;
				var33 = 1.0D - var33;
				var33 *= 10.0D;
				if(var33 < 0.0D) {
					var33 = 0.0D;
				}

				if(var33 > 1.0D) {
					var33 = 1.0D;
				}

				var33 *= var33;
				int var32 = (int)(255.0D * var33);
				if(var27) {
					var32 = 255;
				}

				if(var32 > 0) {
					byte var19 = 2;
					int var34 = -var30 * 9;
					String var21 = ((Chunk)this.e.get(var30)).a;
					this.a(var19, var34 - 1, var19 + 320, var34 + 8, var32 / 2 << 24);
					GL11.glEnable(GL11.GL_BLEND);
					var8.a(var21, var19, var34, 0xFFFFFF + (var32 << 24));
				}
			}
		}

		if(CanvasIsomPreview.currentID != "") {
			var8.a("[Use numpad to enter, - to clear, + to give]", 2, 10, 16449390);
			var8.a("Give item: " + CanvasIsomPreview.currentID, 2, 20, 16449390);
			var15 = Integer.parseInt(CanvasIsomPreview.currentID);
			if((ln.n.length <= var15 || ln.n[var15] == null) && (EntityTNTPrimed.c.length <= var15 || EntityTNTPrimed.c[var15] == null)) {
				var8.a("(INVALID)", 2, 30, 16711680);
			}
		}

		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public lk(net.minecraft.client.Minecraft var1) {
		this.g = var1;
	}

	private void a(float var1, int var2, int var3) {
		var1 = 1.0F - var1;
		if(var1 < 0.0F) {
			var1 = 0.0F;
		}

		if(var1 > 1.0F) {
			var1 = 1.0F;
		}

		this.c = (float)((double)this.c + (double)(var1 - this.c) * 0.01D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_ZERO, GL11.GL_ONE_MINUS_SRC_COLOR);
		GL11.glColor4f(this.c, this.c, this.c, 1.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.g.n.a("/misc/vignette.png"));
		NBTTagByteArray var4 = NBTTagByteArray.a;
		var4.b();
		var4.a(0.0D, (double)var3, -90.0D, 0.0D, 1.0D);
		var4.a((double)var2, (double)var3, -90.0D, 1.0D, 1.0D);
		var4.a((double)var2, 0.0D, -90.0D, 1.0D, 0.0D);
		var4.a(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		var4.a();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}

	private void a(int var1, int var2, int var3, float var4) {
		TileEntityFurnace var5 = this.g.g.b.a[var1];
		if(var5 != null) {
			float var6 = (float)var5.b - var4;
			if(var6 > 0.0F) {
				GL11.glPushMatrix();
				float var7 = 1.0F + var6 / 5.0F;
				GL11.glTranslatef((float)(var2 + 8), (float)(var3 + 12), 0.0F);
				GL11.glScalef(1.0F / var7, (var7 + 1.0F) / 2.0F, 1.0F);
				GL11.glTranslatef((float)(-(var2 + 8)), (float)(-(var3 + 12)), 0.0F);
			}

			d.a(this.g.o, this.g.n, var5, var2, var3);
			if(var6 > 0.0F) {
				GL11.glPopMatrix();
			}

			d.b(this.g.o, this.g.n, var5, var2, var3);
		}
	}

	public void a() {
		if(this.k > 0) {
			--this.k;
		}

		++this.h;

		for(byte var1 = 0; var1 < this.e.size(); ++var1) {
			++((Chunk)this.e.get(var1)).b;
		}

	}

	public void a(String var1) {
		while(this.g.o.a(var1) > 320) {
			byte var2;
			for(var2 = 1; var2 < var1.length() && this.g.o.a(var1.substring(0, var2 + 1)) <= 320; ++var2) {
			}

			this.a(var1.substring(0, var2));
			var1 = var1.substring(var2);
		}

		this.e.add(0, new Chunk(var1));

		while(this.e.size() > 50) {
			this.e.remove(this.e.size() - 1);
		}

	}

	public void b(String var1) {
		this.i = "Now playing: " + var1;
		this.k = 60;
	}
}
