package net.minecraft.src;

import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class ChunkPosition {
	private net.minecraft.client.Minecraft h;
	private float i = 0.0F;
	public EntitySmokeFX a;
	private int j;
	private EntityMinecart jx2 = null;
	private long l = System.currentTimeMillis();
	private Random m = new Random();
	volatile int y = 0;
	volatile int z = 0;
	FloatBuffer d = BlockRedstoneTorch.d(16);
	float e;
	float f;
	float g;
	private float n;
	private float o;

	public ChunkPosition(net.minecraft.client.Minecraft var1) {
		this.h = var1;
		this.a = new EntitySmokeFX(var1);
	}

	public void a() {
		this.n = this.o;
		float var1 = this.h.e.c(ModelPig.b(this.h.g.ah), ModelPig.b(this.h.g.ai), ModelPig.b(this.h.g.aj));
		float var2 = (float)(3 - this.h.y.e) / 3.0F;
		this.o += (var1 * (1.0F - var2) + var2 - this.o) * 0.1F;
		++this.j;
		this.a.a();
		if(this.h.J) {
			this.c();
		}

	}

	public void a(float var1) {
		if(this.h.g != null) {
			double var2 = (double)this.h.b.c();
			this.h.x = this.h.g.a(var2, var1);
			double var4 = var2;
			BlockTNT var6 = this.h.g.e(var1);
			if(this.h.x != null) {
				var4 = this.h.x.f.c(var6);
			}

			double var7;
			if(this.h.b instanceof BlockFlower) {
				var7 = 32.0D;
			} else {
				if(var4 > 3.0D) {
					var4 = 3.0D;
				}

				var7 = var4;
			}

			BlockTNT var9 = this.h.g.f(var1);
			BlockTNT var10 = var6.c(var9.a * var7, var9.b * var7, var9.c * var7);
			this.jx2 = null;
			List var11 = this.h.e.b((EntityMinecart)this.h.g, (EntityRenderer)this.h.g.ar.a(var9.a * var7, var9.b * var7, var9.c * var7));
			double var12 = 0.0D;

			for(int var14 = 0; var14 < var11.size(); ++var14) {
				EntityMinecart var15 = (EntityMinecart)var11.get(var14);
				if(var15.c_()) {
					lv var17 = var15.ar.b((double)0.1F, (double)0.1F, (double)0.1F).a(var6, var10);
					if(var17 != null) {
						double var18 = var6.c(var17.f);
						if(var18 < var12 || var12 == 0.0D) {
							this.jx2 = var15;
							var12 = var18;
						}
					}
				}
			}

			if(this.jx2 != null && !(this.h.b instanceof BlockFlower)) {
				this.h.x = new lv(this.jx2);
			}

		}
	}

	private float d(float var1) {
		GuiDeleteWorld var2 = this.h.g;
		float var3 = 70.0F;
		if(var2.a((EntitySkeleton)EntitySkeleton.f)) {
			var3 = 60.0F;
		}

		if(var2.D <= 0) {
			var3 /= (1.0F - 500.0F / ((float)var2.I + var1 + 500.0F)) * 2.0F + 1.0F;
		}

		return var3;
	}

	private void e(float var1) {
		GuiDeleteWorld var2 = this.h.g;
		float var3 = (float)var2.F - var1;
		if(var2.D <= 0) {
			GL11.glRotatef(40.0F - 8000.0F / ((float)var2.I + var1 + 200.0F), 0.0F, 0.0F, 1.0F);
		}

		if(var3 >= 0.0F) {
			float var4 = var3 / (float)var2.G;
			float var5 = ModelPig.a(var4 * var4 * var4 * var4 * (float)Math.PI);
			float var6 = var2.H;
			GL11.glRotatef(-var6, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-var5 * 14.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
		}
	}

	private void f(float var1) {
		if(!this.h.y.w) {
			GuiDeleteWorld var2 = this.h.g;
			float var3 = var2.aC + (var2.aC - var2.aB) * var1;
			float var4 = var2.e + (var2.f - var2.e) * var1;
			float var5 = var2.K + (var2.L - var2.K) * var1;
			GL11.glTranslatef(ModelPig.a(var3 * (float)Math.PI) * var4 * 0.5F, -Math.abs(ModelPig.b(var3 * (float)Math.PI) * var4), 0.0F);
			GL11.glRotatef(ModelPig.a(var3 * (float)Math.PI) * var4 * 3.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(Math.abs(ModelPig.b(var3 * (float)Math.PI + 0.2F) * var4) * 5.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(var5, 1.0F, 0.0F, 0.0F);
		}
	}

	private void g(float var1) {
		GuiDeleteWorld var2 = this.h.g;
		double var3 = var2.ae + (var2.ah - var2.ae) * (double)var1;
		double var5 = var2.af + (var2.ai - var2.af) * (double)var1;
		double var7 = var2.ag + (var2.aj - var2.ag) * (double)var1;
		if(this.h.y.w) {
			double var9 = 4.0D;
			float var10000 = var2.o + (var2.n - var2.o) * var1;
			float var12 = var2.an - 10.0F;
			float var13 = var2.ao + 2.0F;
			double var14 = (double)(-ModelPig.a(var12 / 180.0F * (float)Math.PI) * ModelPig.b(var13 / 180.0F * (float)Math.PI)) * var9;
			double var16 = (double)(ModelPig.b(var12 / 180.0F * (float)Math.PI) * ModelPig.b(var13 / 180.0F * (float)Math.PI)) * var9;
			double var18 = (double)(-ModelPig.a(var13 / 180.0F * (float)Math.PI)) * var9;

			for(int var20 = 0; var20 < 8; ++var20) {
				float var21 = (float)((var20 & 1) * 2 - 1);
				float var22 = (float)((var20 >> 1 & 1) * 2 - 1);
				float var23 = (float)((var20 >> 2 & 1) * 2 - 1);
				float var24 = var21 * 0.1F;
				float var25 = var22 * 0.1F;
				float var26 = var23 * 0.1F;
				lv var27 = this.h.e.a(BlockTNT.b(var3 + (double)var24, var5 + (double)var25, var7 + (double)var26), BlockTNT.b(var3 - var14 + (double)var24 + (double)var26, var5 - var18 + (double)var25, var7 - var16 + (double)var26));
				if(var27 != null) {
					double var28 = var27.f.c(BlockTNT.b(var3, var5, var7));
					if(var28 < var9) {
						var9 = var28;
					}
				}
			}

			GL11.glRotatef(var2.ao - var13, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(var2.an - var12, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.0F, (float)(-var9));
			GL11.glRotatef(var12 - var2.an, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(var13 - var2.ao, 1.0F, 0.0F, 0.0F);
		} else {
			GL11.glTranslatef(0.0F, 0.0F, -0.1F);
		}

		GL11.glRotatef(var2.aq + (var2.ao - var2.aq) * var1, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(var2.ap + (var2.an - var2.ap) * var1 + 180.0F, 0.0F, 1.0F, 0.0F);
	}

	private void a(float var1, int var2) {
		this.i = (float)(256 >> this.h.y.e);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		if(this.h.y.g) {
			GL11.glTranslatef((float)(-(var2 * 2 - 1)) * 0.07F, 0.0F, 0.0F);
		}

		GLU.gluPerspective(this.d(var1), (float)this.h.c / (float)this.h.d, 0.05F, this.i);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		if(this.h.y.g) {
			GL11.glTranslatef((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
		}

		this.e(var1);
		if(this.h.y.f) {
			this.f(var1);
		}

		this.g(var1);
	}

	private void b(float var1, int var2) {
		GL11.glLoadIdentity();
		if(this.h.y.g) {
			GL11.glTranslatef((float)(var2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
		}

		GL11.glPushMatrix();
		this.e(var1);
		if(this.h.y.f) {
			this.f(var1);
		}

		if(!this.h.y.w) {
			this.a.a(var1);
		}

		GL11.glPopMatrix();
		if(!this.h.y.w) {
			this.a.b(var1);
			this.e(var1);
		}

		if(this.h.y.f) {
			this.f(var1);
		}

	}

	public void b(float var1) {
		if(!Display.isActive()) {
			if(System.currentTimeMillis() - this.l > 500L) {
				this.h.g();
			}
		} else {
			this.l = System.currentTimeMillis();
		}

		int var3;
		if(this.h.I) {
			this.h.B.c();
			int var2 = this.h.B.a;
			var3 = this.h.B.b;
			byte var4 = 1;
			if(this.h.y.c) {
				var4 = -1;
			}

			this.h.g.d((float)var2, (float)(var3 * var4));
		}

		if(!this.h.v) {
			EntityFallingSand var7 = new EntityFallingSand(this.h.c, this.h.d);
			var3 = var7.a();
			int var8 = var7.b();
			int var5 = Mouse.getX() * var3 / this.h.c;
			int var6 = var8 - Mouse.getY() * var8 / this.h.d - 1;
			if(this.h.e != null) {
				this.c(var1);
				this.h.u.a(var1, this.h.p != null, var5, var6);
			} else {
				GL11.glViewport(0, 0, this.h.c, this.h.d);
				GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glLoadIdentity();
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glLoadIdentity();
				this.b();
			}

			if(this.h.p != null) {
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
				this.h.p.a(var5, var6, var1);
			}

		}
	}

	public void c(float var1) {
		this.a(var1);
		GuiDeleteWorld var2 = this.h.g;
		BlockChest var3 = this.h.f;
		BlockMinecartTrack var4 = this.h.h;
		double var5 = var2.aF + (var2.ah - var2.aF) * (double)var1;
		double var7 = var2.aG + (var2.ai - var2.aG) * (double)var1;
		double var9 = var2.aH + (var2.aj - var2.aH) * (double)var1;

		for(int var11 = 0; var11 < 2; ++var11) {
			if(this.h.y.g) {
				if(var11 == 0) {
					GL11.glColorMask(false, true, true, false);
				} else {
					GL11.glColorMask(true, false, false, false);
				}
			}

			GL11.glViewport(0, 0, this.h.c, this.h.d);
			this.j(var1);
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_CULL_FACE);
			this.a(var1, var11);
			ModelSheep.a();
			if(this.h.y.e < 2) {
				this.a(-1);
				var3.a(var1);
			}

			GL11.glEnable(GL11.GL_FOG);
			this.a(1);
			ICamera var12 = new ICamera();
			var12.setPosition(var5, var7, var9);
			this.h.f.a(var12, var1);
			this.h.f.a(var2, false);
			this.a(0);
			GL11.glEnable(GL11.GL_FOG);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.h.n.a("/terrain.png"));
			GLStatics.a();
			var3.a(var2, 0, (double)var1);
			GLStatics.b();
			var3.a(var2.e(var1), var12, var1);
			var4.b(var2, var1);
			GLStatics.a();
			this.a(0);
			var4.a(var2, var1);
			if(this.h.x != null && var2.a((EntitySkeleton)EntitySkeleton.f)) {
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				var3.a(var2, this.h.x, 0, var2.b.e(), var1);
				var3.b(var2, this.h.x, 0, var2.b.e(), var1);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
			}

			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.a(0);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.h.n.a("/terrain.png"));
			if(this.h.y.i) {
				GL11.glColorMask(false, false, false, false);
				int var13 = var3.a(var2, 1, (double)var1);
				GL11.glColorMask(true, true, true, true);
				if(this.h.y.g) {
					if(var11 == 0) {
						GL11.glColorMask(false, true, true, false);
					} else {
						GL11.glColorMask(true, false, false, false);
					}
				}

				if(var13 > 0) {
					var3.a(1, (double)var1);
				}
			} else {
				var3.a(var2, 1, (double)var1);
			}

			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			if(this.h.x != null && !var2.a((EntitySkeleton)EntitySkeleton.f)) {
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				var3.a(var2, this.h.x, 0, var2.b.e(), var1);
				var3.b(var2, this.h.x, 0, var2.b.e(), var1);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
			}

			GL11.glDisable(GL11.GL_FOG);
			if(this.h.e.d) {
				this.h(var1);
			}

			if(this.h.J) {
				this.i(var1);
			}

			if(this.jx2 != null) {
							}

			this.a(0);
			GL11.glEnable(GL11.GL_FOG);
			var3.b(var1);
			GL11.glDisable(GL11.GL_FOG);
			this.a(1);
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			this.b(var1, var11);
			if(!this.h.y.g) {
				return;
			}
		}

		GL11.glColorMask(true, true, true, false);
	}

	private void c() {
		if(this.h.y.i) {
			GuiDeleteWorld var1 = this.h.g;
			EntitySpider var2 = this.h.e;
			int var3 = ModelPig.b(var1.ah);
			int var4 = ModelPig.b(var1.ai);
			int var5 = ModelPig.b(var1.aj);

			for(int var7 = 0; var7 < 150; ++var7) {
				int var8 = var3 + this.m.nextInt(16) - this.m.nextInt(16);
				int var9 = var5 + this.m.nextInt(16) - this.m.nextInt(16);
				int var10 = var2.e(var8, var9);
				int var11 = var2.a(var8, var10 - 1, var9);
				if(var10 <= var4 + 16 && var10 >= var4 - 16) {
					float var12 = this.m.nextFloat();
					float var13 = this.m.nextFloat();
					if(var11 > 0) {
						this.h.h.a((nd)(new ms(var2, (double)((float)var8 + var12), (double)((float)var10 + 0.1F) - ln.n[var11].be, (double)((float)var9 + var13))));
					}
				}
			}

		}
	}

	private void h(float var1) {
		GuiDeleteWorld var2 = this.h.g;
		EntitySpider var3 = this.h.e;
		int var4 = ModelPig.b(var2.ah);
		int var5 = ModelPig.b(var2.ai);
		int var6 = ModelPig.b(var2.aj);
		NBTTagByteArray var7 = NBTTagByteArray.a;
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.h.n.a("/snow.png"));
		double var8 = var2.aF + (var2.ah - var2.aF) * (double)var1;
		double var10 = var2.aG + (var2.ai - var2.aG) * (double)var1;
		double var12 = var2.aH + (var2.aj - var2.aH) * (double)var1;
		byte var14 = 5;
		if(this.h.y.i) {
			var14 = 10;
		}

		for(int var15 = var4 - var14; var15 <= var4 + var14; ++var15) {
			for(int var16 = var6 - var14; var16 <= var6 + var14; ++var16) {
				int var17 = var3.d(var15, var16);
				if(var17 < 0) {
					var17 = 0;
				}

				int var18 = var5 - var14;
				int var19 = var5 + var14;
				if(var18 < var17) {
					var18 = var17;
				}

				if(var19 < var17) {
					var19 = var17;
				}

				if(var18 != var19) {
					this.m.setSeed((long)(var15 * var15 * 3121 + var15 * 45238971 + var16 * var16 * 418711 + var16 * 13761));
					float var21 = (float)this.j + var1;
					float var22 = ((float)(this.j & 511) + var1) / 512.0F;
					float var23 = this.m.nextFloat() + var21 * 0.01F * (float)this.m.nextGaussian();
					float var24 = this.m.nextFloat() + var21 * (float)this.m.nextGaussian() * 0.001F;
					double var25 = (double)((float)var15 + 0.5F) - var2.ah;
					double var27 = (double)((float)var16 + 0.5F) - var2.aj;
					float var29 = ModelPig.a(var25 * var25 + var27 * var27) / (float)var14;
					var7.b();
					float var30 = var3.c(var15, 128, var16);
					GL11.glColor4f(var30, var30, var30, (1.0F - var29 * var29) * 0.7F);
					var7.b(-var8 * 1.0D, -var10 * 1.0D, -var12 * 1.0D);
					var7.a((double)(var15 + 0), (double)var18, (double)(var16 + 0), (double)(0.0F + var23), (double)((float)var18 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 1), (double)var18, (double)(var16 + 1), (double)(2.0F + var23), (double)((float)var18 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 1), (double)var19, (double)(var16 + 1), (double)(2.0F + var23), (double)((float)var19 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 0), (double)var19, (double)(var16 + 0), (double)(0.0F + var23), (double)((float)var19 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 0), (double)var18, (double)(var16 + 1), (double)(0.0F + var23), (double)((float)var18 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 1), (double)var18, (double)(var16 + 0), (double)(2.0F + var23), (double)((float)var18 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 1), (double)var19, (double)(var16 + 0), (double)(2.0F + var23), (double)((float)var19 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.a((double)(var15 + 0), (double)var19, (double)(var16 + 1), (double)(0.0F + var23), (double)((float)var19 * 2.0F / 8.0F + var22 * 2.0F + var24));
					var7.b(0.0D, 0.0D, 0.0D);
					var7.a();
				}
			}
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void i(float var1) {
		GuiDeleteWorld var2 = this.h.g;
		EntitySpider var3 = this.h.e;
		int var4 = ModelPig.b(var2.ah);
		int var5 = ModelPig.b(var2.ai);
		int var6 = ModelPig.b(var2.aj);
		NBTTagByteArray var7 = NBTTagByteArray.a;
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glNormal3f(0.0F, 1.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.h.n.a("/rain.png"));
		double var8 = var2.aF + (var2.ah - var2.aF) * (double)var1;
		double var10 = var2.aG + (var2.ai - var2.aG) * (double)var1;
		double var12 = var2.aH + (var2.aj - var2.aH) * (double)var1;
		byte var14 = 5;
		if(this.h.y.i) {
			var14 = 10;
		}

		for(int var15 = var4 - var14; var15 <= var4 + var14; ++var15) {
			for(int var16 = var6 - var14; var16 <= var6 + var14; ++var16) {
				int var17 = var3.e(var15, var16);
				int var18 = var5 - var14;
				int var19 = var5 + var14;
				if(var18 < var17) {
					var18 = var17;
				}

				if(var19 < var17) {
					var19 = var17;
				}

				if(var18 != var19) {
					float var21 = ((float)(this.j + var15 * var15 * 3121 + var15 * 45238971 + var16 * var16 * 418711 + var16 * 13761 & 31) + var1) / 32.0F;
					double var22 = (double)((float)var15 + 0.5F) - var2.ah;
					double var24 = (double)((float)var16 + 0.5F) - var2.aj;
					float var26 = ModelPig.a(var22 * var22 + var24 * var24) / (float)var14;
					var7.b();
					float var27 = var3.c(var15, 128, var16);
					GL11.glColor4f(var27, var27, var27, (1.0F - var26 * var26) * 0.7F);
					var7.b(-var8 * 1.0D, -var10 * 1.0D, -var12 * 1.0D);
					var7.a((double)(var15 + 0), (double)var18, (double)(var16 + 0), 0.0D, (double)((float)var18 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 1), (double)var18, (double)(var16 + 1), 2.0D, (double)((float)var18 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 1), (double)var19, (double)(var16 + 1), 2.0D, (double)((float)var19 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 0), (double)var19, (double)(var16 + 0), 0.0D, (double)((float)var19 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 0), (double)var18, (double)(var16 + 1), 0.0D, (double)((float)var18 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 1), (double)var18, (double)(var16 + 0), 2.0D, (double)((float)var18 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 1), (double)var19, (double)(var16 + 0), 2.0D, (double)((float)var19 * 2.0F / 8.0F + var21 * 2.0F));
					var7.a((double)(var15 + 0), (double)var19, (double)(var16 + 1), 0.0D, (double)((float)var19 * 2.0F / 8.0F + var21 * 2.0F));
					var7.b(0.0D, 0.0D, 0.0D);
					var7.a();
				}
			}
		}

		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
	}

	public void b() {
		EntityFallingSand var1 = new EntityFallingSand(this.h.c, this.h.d);
		int var2 = var1.a();
		int var3 = var1.b();
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0D, (double)var2, (double)var3, 0.0D, 1000.0D, 3000.0D);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
	}

	private void j(float var1) {
		EntitySpider var2 = this.h.e;
		GuiDeleteWorld var3 = this.h.g;
		float var4 = 1.0F - (float)Math.pow((double)(1.0F / (float)(4 - this.h.y.e)), 0.25D);
		BlockTNT var5 = var2.b(var1);
		float var6 = (float)var5.a;
		float var7 = (float)var5.b;
		float var8 = (float)var5.c;
		BlockTNT var9 = var2.e(var1);
		this.e = (float)var9.a;
		this.f = (float)var9.b;
		this.g = (float)var9.c;
		this.e += (var6 - this.e) * var4;
		this.f += (var7 - this.f) * var4;
		this.g += (var8 - this.g) * var4;
		if(var3.a((EntitySkeleton)EntitySkeleton.f)) {
			this.e = 0.02F;
			this.f = 0.02F;
			this.g = 0.2F;
		} else if(var3.a((EntitySkeleton)EntitySkeleton.g)) {
			this.e = 0.6F;
			this.f = 0.1F;
			this.g = 0.0F;
		}

		float var10 = this.n + (this.o - this.n) * var1;
		this.e *= var10;
		this.f *= var10;
		this.g *= var10;
		if(this.h.y.g) {
			float var11 = (this.e * 30.0F + this.f * 59.0F + this.g * 11.0F) / 100.0F;
			float var12 = (this.e * 30.0F + this.f * 70.0F) / 100.0F;
			float var13 = (this.e * 30.0F + this.g * 70.0F) / 100.0F;
			this.e = var11;
			this.f = var12;
			this.g = var13;
		}

		float[] var14 = ColorUtil.BlendColor(0.5F, this.e, this.f, this.g);
		this.e = var14[0];
		this.f = var14[1];
		this.g = var14[2];
		GL11.glClearColor(this.e, this.f, this.g, 0.0F);
	}

	private void a(int var1) {
		GuiDeleteWorld var2 = this.h.g;
		GL11.glFog(GL11.GL_FOG_COLOR, this.a(this.e, this.f, this.g, 1.0F));
		GL11.glNormal3f(0.0F, -1.0F, 0.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		if(var2.a((EntitySkeleton)EntitySkeleton.f)) {
			GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
			GL11.glFogf(GL11.GL_FOG_DENSITY, 0.1F);
			if(this.h.y.g) {
							}
		} else if(var2.a((EntitySkeleton)EntitySkeleton.g)) {
			GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
			GL11.glFogf(GL11.GL_FOG_DENSITY, 2.0F);
			if(this.h.y.g) {
							}
		} else {
			GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_LINEAR);
			GL11.glFogf(GL11.GL_FOG_START, this.i * 0.25F);
			GL11.glFogf(GL11.GL_FOG_END, this.i);
			if(var1 < 0) {
				GL11.glFogf(GL11.GL_FOG_START, 0.0F);
				GL11.glFogf(GL11.GL_FOG_END, this.i * 0.8F);
			}

			if(GLContext.getCapabilities().GL_NV_fog_distance) {
				GL11.glFogi('\u855a', '\u855b');
			}
		}

		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glColorMaterial(GL11.GL_FRONT, GL11.GL_AMBIENT);
	}

	private FloatBuffer a(float var1, float var2, float var3, float var4) {
		this.d.clear();
		this.d.put(var1).put(var2).put(var3).put(var4);
		this.d.flip();
		return this.d;
	}
}
