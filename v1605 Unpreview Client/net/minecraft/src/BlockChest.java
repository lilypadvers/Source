package net.minecraft.src;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class BlockChest implements ItemStack {
	public List a = new ArrayList();
	private EntitySpider k;
	private BlockRedstoneWire l;
	private List m = new ArrayList();
	private TileEntity[] n;
	private TileEntity[] o;
	private int p;
	private int q;
	private int r;
	private int s;
	private net.minecraft.client.Minecraft t;
	private GuiCrafting u;
	private IntBuffer v;
	private boolean w = false;
	private int x = 0;
	private int y;
	private int z;
	private int A;
	private int B;
	private int C;
	private int D;
	private int E;
	private int F;
	private int G;
	private int H = -1;
	private int I = 2;
	private int J;
	private int K;
	private int L;
	int[] b = new int['\uc350'];
	IntBuffer c = BlockRedstoneTorch.c(64);
	private int M;
	private int N;
	private int O;
	private int P;
	private int Q;
	private List R = new ArrayList();
	private ItemFood[] S = new ItemFood[]{new ItemFood(), new ItemFood(), new ItemFood(), new ItemFood()};
	int d = 0;
	int e = BlockRedstoneTorch.a(1);
	double f = -9999.0D;
	double g = -9999.0D;
	double h = -9999.0D;
	public float i;
	int j = 0;

	public BlockChest(net.minecraft.client.Minecraft var1, BlockRedstoneWire var2) {
		this.t = var1;
		this.l = var2;
		this.s = BlockRedstoneTorch.a(786432);
		this.w = var1.k().a();
		if(this.w) {
			this.c.clear();
			(this.v = BlockRedstoneTorch.c(262144)).clear();
			this.v.position(0);
			this.v.limit(262144);
			ARBOcclusionQuery.glGenQueriesARB(this.v);
		}

		this.y = BlockRedstoneTorch.a(3);
		GL11.glPushMatrix();
		GL11.glNewList(this.y, GL11.GL_COMPILE);
		this.f();
		GL11.glEndList();
		GL11.glPopMatrix();
		NBTTagByteArray var4 = NBTTagByteArray.a;
		GL11.glNewList(this.z = this.y + 1, GL11.GL_COMPILE);

		int var9;
		for(int var8 = -384; var8 <= 384; var8 += 64) {
			for(var9 = -384; var9 <= 384; var9 += 64) {
				var4.b();
				var4.a((double)(var8 + 0), 16.0D, (double)(var9 + 0));
				var4.a((double)(var8 + 64), 16.0D, (double)(var9 + 0));
				var4.a((double)(var8 + 64), 16.0D, (double)(var9 + 64));
				var4.a((double)(var8 + 0), 16.0D, (double)(var9 + 64));
				var4.a();
			}
		}

		GL11.glEndList();
		GL11.glNewList(this.A = this.y + 2, GL11.GL_COMPILE);
		var4.b();

		for(var9 = -384; var9 <= 384; var9 += 64) {
			for(int var10 = -384; var10 <= 384; var10 += 64) {
				var4.a((double)(var9 + 64), -16.0D, (double)(var10 + 0));
				var4.a((double)(var9 + 0), -16.0D, (double)(var10 + 0));
				var4.a((double)(var9 + 0), -16.0D, (double)(var10 + 64));
				var4.a((double)(var9 + 64), -16.0D, (double)(var10 + 64));
			}
		}

		var4.a();
		GL11.glEndList();
	}

	private void f() {
		Random var1 = new Random(10842L);
		NBTTagByteArray var2 = NBTTagByteArray.a;
		var2.b();

		for(int var3 = 0; var3 < 1500; ++var3) {
			double var4 = (double)(var1.nextFloat() * 2.0F - 1.0F);
			double var6 = (double)(var1.nextFloat() * 2.0F - 1.0F);
			double var8 = (double)(var1.nextFloat() * 2.0F - 1.0F);
			double var10 = (double)(0.25F + var1.nextFloat() * 0.25F);
			double var12 = var4 * var4 + var6 * var6 + var8 * var8;
			if(var12 < 1.0D && var12 > 0.01D) {
				double var14 = 1.0D / Math.sqrt(var12);
				double var16 = var4 * var14;
				double var18 = var6 * var14;
				double var20 = var8 * var14;
				double var22 = var16 * 100.0D;
				double var24 = var18 * 100.0D;
				double var26 = var20 * 100.0D;
				double var28 = Math.atan2(var16, var20);
				double var30 = Math.sin(var28);
				double var32 = Math.cos(var28);
				double var34 = Math.atan2(Math.sqrt(var16 * var16 + var20 * var20), var18);
				double var36 = Math.sin(var34);
				double var38 = Math.cos(var34);
				double var40 = var1.nextDouble() * Math.PI * 2.0D;
				double var42 = Math.sin(var40);
				double var44 = Math.cos(var40);

				for(int var46 = 0; var46 < 4; ++var46) {
					double var49 = (double)((var46 & 2) - 1) * var10;
					double var51 = (double)((var46 + 1 & 2) - 1) * var10;
					double var55 = var49 * var44 - var51 * var42;
					double var57 = var51 * var44 + var49 * var42;
					double var59 = var55 * var36 + 0.0D * var38;
					double var61 = 0.0D * var36 - var55 * var38;
					var2.a(var22 + (var61 * var30 - var57 * var32), var24 + var59, var26 + var57 * var30 + var61 * var32);
				}
			}
		}

		var2.a();
	}

	public void a(EntitySpider var1) {
		if(this.k != null) {
			this.k.b((ItemStack)this);
		}

		this.f = -9999.0D;
		this.g = -9999.0D;
		this.h = -9999.0D;
		RenderSpider.a.a(var1);
		this.k = var1;
		this.u = new GuiCrafting(var1);
		if(var1 != null) {
			var1.a((ItemStack)this);
			this.a();
		}

	}

	public void a() {
		ln.K.a(this.t.y.i);
		this.H = this.t.y.e;
		int var1;
		if(this.o != null) {
			for(var1 = 0; var1 < this.o.length; ++var1) {
				this.o[var1].c();
			}
		}

		var1 = 64 << 3 - this.H;
		if(var1 > 400) {
			var1 = 400;
		}

		this.p = var1 / 16 + 1;
		this.q = 8;
		this.r = var1 / 16 + 1;
		this.o = new TileEntity[this.p * this.q * this.r];
		this.n = new TileEntity[this.p * this.q * this.r];
		int var2 = 0;
		int var3 = 0;
		this.B = 0;
		this.C = 0;
		this.D = 0;
		this.E = this.p;
		this.F = this.q;
		this.G = this.r;

		int var4;
		for(var4 = 0; var4 < this.m.size(); ++var4) {
			((TileEntity)this.m.get(var4)).u = false;
		}

		this.m.clear();
		this.a.clear();

		for(var4 = 0; var4 < this.p; ++var4) {
			for(int var5 = 0; var5 < this.q; ++var5) {
				for(int var6 = 0; var6 < this.r; ++var6) {
					this.o[(var6 * this.q + var5) * this.p + var4] = new TileEntity(this.k, this.a, var4 * 16, var5 * 16, var6 * 16, 16, this.s + var2);
					if(this.w) {
						this.o[(var6 * this.q + var5) * this.p + var4].z = this.v.get(var3);
					}

					this.o[(var6 * this.q + var5) * this.p + var4].y = false;
					this.o[(var6 * this.q + var5) * this.p + var4].x = true;
					this.o[(var6 * this.q + var5) * this.p + var4].o = true;
					this.o[(var6 * this.q + var5) * this.p + var4].w = var3++;
					this.o[(var6 * this.q + var5) * this.p + var4].f();
					this.n[(var6 * this.q + var5) * this.p + var4] = this.o[(var6 * this.q + var5) * this.p + var4];
					this.m.add(this.o[(var6 * this.q + var5) * this.p + var4]);
					var2 += 3;
				}
			}
		}

		if(this.k != null) {
			GuiDeleteWorld var7 = this.t.g;
			this.b(ModelPig.b(var7.ah), ModelPig.b(var7.ai), ModelPig.b(var7.aj));
			Arrays.sort(this.n, new WorldGenDungeons(var7));
		}

		this.I = 2;
	}

	public void a(BlockTNT var1, nq var2, float var3) {
		if(this.I > 0) {
			--this.I;
		} else {
			ThreadDownloadImage.a.a(this.k, this.l, this.t.o, this.t.g, var3);
			RenderSpider.a.a(this.k, this.l, this.t.o, this.t.g, this.t.y, var3);
			this.J = 0;
			this.K = 0;
			this.L = 0;
			GuiDeleteWorld var4 = this.t.g;
			RenderSpider.b = var4.aF + (var4.ah - var4.aF) * (double)var3;
			RenderSpider.c = var4.aG + (var4.ai - var4.aG) * (double)var3;
			RenderSpider.d = var4.aH + (var4.aj - var4.aH) * (double)var3;
			ThreadDownloadImage.b = var4.aF + (var4.ah - var4.aF) * (double)var3;
			ThreadDownloadImage.c = var4.aG + (var4.ai - var4.aG) * (double)var3;
			ThreadDownloadImage.d = var4.aH + (var4.aj - var4.aH) * (double)var3;
			List var5 = this.k.i();
			this.J = var5.size();

			int var6;
			for(var6 = 0; var6 < var5.size(); ++var6) {
				EntityMinecart var7 = (EntityMinecart)var5.get(var6);
				if(var7.a(var1) && var2.a(var7.ar) && (var7 != this.t.g || this.t.y.w)) {
					++this.K;
					RenderSpider.a.a(var7, var3);
				}
			}

			for(var6 = 0; var6 < this.a.size(); ++var6) {
				ThreadDownloadImage.a.a((EntityCreature)this.a.get(var6), var3);
			}

		}
	}

	public String b() {
		return "C: " + this.P + "/" + this.M + ". F: " + this.N + ", O: " + this.O + ", E: " + this.Q;
	}

	public String c() {
		return "E: " + this.K + "/" + this.J + ". B: " + this.L + ", I: " + (this.J - this.L - this.K);
	}

	private void b(int var1, int var2, int var3) {
		var1 -= 8;
		var2 -= 8;
		var3 -= 8;
		this.B = Integer.MAX_VALUE;
		this.C = Integer.MAX_VALUE;
		this.D = Integer.MAX_VALUE;
		this.E = Integer.MIN_VALUE;
		this.F = Integer.MIN_VALUE;
		this.G = Integer.MIN_VALUE;
		int var4 = this.p * 16;
		int var5 = var4 / 2;

		for(int var6 = 0; var6 < this.p; ++var6) {
			int var7 = var6 * 16;
			int var8 = var7 + var5 - var1;
			if(var8 < 0) {
				var8 -= var4 - 1;
			}

			int var9 = var7 - var8 / var4 * var4;
			if(var9 < this.B) {
				this.B = var9;
			}

			if(var9 > this.E) {
				this.E = var9;
			}

			for(int var10 = 0; var10 < this.r; ++var10) {
				int var11 = var10 * 16;
				int var12 = var11 + var5 - var3;
				if(var12 < 0) {
					var12 -= var4 - 1;
				}

				int var13 = var11 - var12 / var4 * var4;
				if(var13 < this.D) {
					this.D = var13;
				}

				if(var13 > this.G) {
					this.G = var13;
				}

				for(int var14 = 0; var14 < this.q; ++var14) {
					int var15 = var14 * 16;
					if(var15 < this.C) {
						this.C = var15;
					}

					if(var15 > this.F) {
						this.F = var15;
					}

					TileEntity var16 = this.o[(var10 * this.q + var14) * this.p + var6];
					boolean var17 = var16.u;
					var16.a(var9, var15, var13);
					if(!var17 && var16.u) {
						this.m.add(var16);
					}
				}
			}
		}

	}

	public int a(BlockMobSpawner var1, int var2, double var3) {
		if(this.t.y.e != this.H) {
			this.a();
		}

		if(var2 == 0) {
			this.M = 0;
			this.N = 0;
			this.O = 0;
			this.P = 0;
			this.Q = 0;
		}

		double var5 = var1.aF + (var1.ah - var1.aF) * var3;
		double var7 = var1.aG + (var1.ai - var1.aG) * var3;
		double var9 = var1.aH + (var1.aj - var1.aH) * var3;
		double var11 = var1.ah - this.f;
		double var13 = var1.ai - this.g;
		double var15 = var1.aj - this.h;
		if(var11 * var11 + var13 * var13 + var15 * var15 > 16.0D) {
			this.f = var1.ah;
			this.g = var1.ai;
			this.h = var1.aj;
			this.b(ModelPig.b(var1.ah), ModelPig.b(var1.ai), ModelPig.b(var1.aj));
			Arrays.sort(this.n, new WorldGenDungeons(var1));
		}

		int var18;
		if(this.w && !this.t.y.g && var2 == 0) {
			int var20 = 16;
			this.a(0, var20);

			int var21;
			for(var21 = 0; var21 < var20; ++var21) {
				this.n[var21].x = true;
			}

			var18 = 0 + this.a(0, var20, var2, var3);

			do {
				var21 = var20;
				var20 *= 2;
				if(var20 > this.n.length) {
					var20 = this.n.length;
				}

				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				GL11.glDisable(GL11.GL_FOG);
				GL11.glColorMask(false, false, false, false);
				GL11.glDepthMask(false);
				this.a(var21, var20);
				GL11.glPushMatrix();
				float var22 = 0.0F;
				float var23 = 0.0F;
				float var24 = 0.0F;

				for(int var25 = var21; var25 < var20; ++var25) {
					if(this.n[var25].e()) {
						this.n[var25].o = false;
					} else {
						if(!this.n[var25].o) {
							this.n[var25].x = true;
						}

						if(this.n[var25].o && !this.n[var25].y) {
							int var26 = (int)(1.0F + ModelPig.c(this.n[var25].a((EntityMinecart)var1)) / 128.0F);
							if(this.x % var26 == var25 % var26) {
								TileEntity var27 = this.n[var25];
								float var28 = (float)((double)var27.i - var5);
								float var29 = (float)((double)var27.j - var7);
								float var30 = (float)((double)var27.k - var9);
								float var31 = var28 - var22;
								float var32 = var29 - var23;
								float var33 = var30 - var24;
								if(var31 != 0.0F || var32 != 0.0F || var33 != 0.0F) {
									GL11.glTranslatef(var31, var32, var33);
									var22 += var31;
									var23 += var32;
									var24 += var33;
								}

								ARBOcclusionQuery.glBeginQueryARB('\u8914', this.n[var25].z);
								this.n[var25].onInventoryChanged();
								ARBOcclusionQuery.glEndQueryARB('\u8914');
								this.n[var25].y = true;
							}
						}
					}
				}

				GL11.glPopMatrix();
				GL11.glColorMask(true, true, true, true);
				GL11.glDepthMask(true);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glEnable(GL11.GL_FOG);
				var18 += this.a(var21, var20, var2, var3);
			} while(var20 < this.n.length);
		} else {
			var18 = 0 + this.a(0, this.n.length, var2, var3);
		}

		return var18;
	}

	private void a(int var1, int var2) {
		for(int var3 = var1; var3 < var2; ++var3) {
			if(this.n[var3].y) {
				this.c.clear();
				ARBOcclusionQuery.glGetQueryObjectuARB(this.n[var3].z, '\u8867', this.c);
				if(this.c.get(0) != 0) {
					this.n[var3].y = false;
					this.c.clear();
					ARBOcclusionQuery.glGetQueryObjectuARB(this.n[var3].z, '\u8866', this.c);
					this.n[var3].x = this.c.get(0) != 0;
				}
			}
		}

	}

	private int a(int var1, int var2, int var3, double var4) {
		this.R.clear();
		int var6 = 0;

		for(int var7 = var1; var7 < var2; ++var7) {
			if(var3 == 0) {
				++this.M;
				if(this.n[var7].p[var3]) {
					++this.Q;
				} else if(!this.n[var7].o) {
					++this.N;
				} else if(this.w && !this.n[var7].x) {
					++this.O;
				} else {
					++this.P;
				}
			}

			if(!this.n[var7].p[var3] && this.n[var7].o && this.n[var7].x && this.n[var7].a(var3) >= 0) {
				this.R.add(this.n[var7]);
				++var6;
			}
		}

		GuiDeleteWorld var19 = this.t.g;
		double var8 = var19.aF + (var19.ah - var19.aF) * var4;
		double var10 = var19.aG + (var19.ai - var19.aG) * var4;
		double var12 = var19.aH + (var19.aj - var19.aH) * var4;
		int var14 = 0;

		int var15;
		for(var15 = 0; var15 < this.S.length; ++var15) {
			this.S[var15].b();
		}

		for(var15 = 0; var15 < this.R.size(); ++var15) {
			TileEntity var16 = (TileEntity)this.R.get(var15);
			int var17 = -1;

			for(int var18 = 0; var18 < var14; ++var18) {
				if(this.S[var18].a(var16.i, var16.j, var16.k)) {
					var17 = var18;
				}
			}

			if(var17 < 0) {
				var17 = var14++;
				this.S[var17].a(var16.i, var16.j, var16.k, var8, var10, var12);
			}

			this.S[var17].a(var16.a(var3));
		}

		this.a(var3, var4);
		return var6;
	}

	public void a(int var1, double var2) {
		for(int var4 = 0; var4 < this.S.length; ++var4) {
			this.S[var4].a();
		}

	}

	public void d() {
		++this.x;
	}

	public void a(float var1) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		BlockTNT var2 = this.k.b(var1);
		float var3 = (float)var2.a;
		float var4 = (float)var2.b;
		float var5 = (float)var2.c;
		float var6;
		if(this.t.y.g) {
			var6 = (var3 * 30.0F + var4 * 59.0F + var5 * 11.0F) / 100.0F;
			float var7 = (var3 * 30.0F + var4 * 70.0F) / 100.0F;
			float var8 = (var3 * 30.0F + var5 * 70.0F) / 100.0F;
			var3 = var6;
			var4 = var7;
			var5 = var8;
		}

		var6 = (float)(1000L - Math.abs(23000L - this.k.c % 24000L)) / 1000.0F;
		float[] var15 = ColorUtil.BlendColor(Math.max(0.0F, var6) / 2.0F, var3, var4, var5);
		var3 = var15[0];
		var4 = var15[1];
		var5 = var15[2];
		GL11.glColor3f(var3, var4, var5);
		NBTTagByteArray var16 = NBTTagByteArray.a;
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glColor3f(var3, var4, var5);
		GL11.glCallList(this.z);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		GL11.glRotatef(0.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(this.k.c(var1) * 360.0F, 1.0F, 0.0F, 0.0F);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/terrain/sun.png"));
		var16.b();
		var16.a(-30.0D, 100.0D, -30.0D, 0.0D, 0.0D);
		var16.a(30.0D, 100.0D, -30.0D, 1.0D, 0.0D);
		var16.a(30.0D, 100.0D, 30.0D, 1.0D, 1.0D);
		var16.a(-30.0D, 100.0D, 30.0D, 0.0D, 1.0D);
		var16.a();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/terrain/moon.png"));
		var16.b();
		var16.a(-20.0D, -100.0D, 20.0D, 1.0D, 1.0D);
		var16.a(20.0D, -100.0D, 20.0D, 0.0D, 1.0D);
		var16.a(20.0D, -100.0D, -20.0D, 0.0D, 0.0D);
		var16.a(-20.0D, -100.0D, -20.0D, 1.0D, 0.0D);
		var16.a();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		float var14 = this.k.f(var1);
		if(var14 > 0.0F) {
			GL11.glColor4f(var14, var14, var14, var14);
			GL11.glCallList(this.y);
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glPopMatrix();
		GL11.glColor3f(var3 * 0.2F + 0.04F, var4 * 0.2F + 0.04F, var5 * 0.6F + 0.1F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glCallList(this.A);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
	}

	public void b(float var1) {
		if(this.t.y.i) {
			this.c(var1);
		} else {
			GL11.glDisable(GL11.GL_CULL_FACE);
			float var2 = (float)(this.t.g.aG + (this.t.g.ai - this.t.g.aG) * (double)var1);
			NBTTagByteArray var5 = NBTTagByteArray.a;
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/clouds.png"));
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			BlockTNT var6 = this.k.d(var1);
			float var7 = (float)var6.a;
			float var8 = (float)var6.b;
			float var9 = (float)var6.c;
			if(this.t.y.g) {
				float var10 = (var7 * 30.0F + var8 * 59.0F + var9 * 11.0F) / 100.0F;
				float var11 = (var7 * 30.0F + var8 * 70.0F) / 100.0F;
				float var12 = (var7 * 30.0F + var9 * 70.0F) / 100.0F;
				var7 = var10;
				var8 = var11;
				var9 = var12;
			}

			double var26 = this.t.g.ae + (this.t.g.ah - this.t.g.ae) * (double)var1 + (double)(((float)this.x + var1) * 0.03F);
			double var13 = this.t.g.ag + (this.t.g.aj - this.t.g.ag) * (double)var1;
			int var15 = ModelPig.b(var26 / 2048.0D);
			int var16 = ModelPig.b(var13 / 2048.0D);
			double var17 = var26 - (double)(var15 * 2048);
			double var19 = var13 - (double)(var16 * 2048);
			float var21 = 120.0F - var2 + 0.33F;
			float var22 = (float)(var17 * 4.8828125E-4D);
			float var23 = (float)(var19 * 4.8828125E-4D);
			var5.b();
			var5.a(var7, var8, var9, 0.8F);

			for(int var24 = -256; var24 < 256; var24 += 32) {
				for(int var25 = -256; var25 < 256; var25 += 32) {
					var5.a((double)(var24 + 0), (double)var21, (double)(var25 + 32), (double)((float)(var24 + 0) * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23));
					var5.a((double)(var24 + 32), (double)var21, (double)(var25 + 32), (double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)(var25 + 32) * 4.8828125E-4F + var23));
					var5.a((double)(var24 + 32), (double)var21, (double)(var25 + 0), (double)((float)(var24 + 32) * 4.8828125E-4F + var22), (double)((float)(var25 + 0) * 4.8828125E-4F + var23));
					var5.a((double)(var24 + 0), (double)var21, (double)(var25 + 0), (double)((float)(var24 + 0) * 4.8828125E-4F + var22), (double)((float)(var25 + 0) * 4.8828125E-4F + var23));
				}
			}

			var5.a();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_CULL_FACE);
		}
	}

	public void c(float var1) {
		GL11.glDisable(GL11.GL_CULL_FACE);
		float var2 = (float)(this.t.g.aG + (this.t.g.ai - this.t.g.aG) * (double)var1);
		NBTTagByteArray var3 = NBTTagByteArray.a;
		double var6 = (this.t.g.ae + (this.t.g.ah - this.t.g.ae) * (double)var1 + (double)(((float)this.x + var1) * 0.03F)) / 12.0D;
		double var8 = (this.t.g.ag + (this.t.g.aj - this.t.g.ag) * (double)var1) / 12.0D + (double)0.33F;
		float var10 = 108.0F - var2 + 0.33F;
		int var11 = ModelPig.b(var6 / 2048.0D);
		int var12 = ModelPig.b(var8 / 2048.0D);
		double var13 = var6 - (double)(var11 * 2048);
		double var15 = var8 - (double)(var12 * 2048);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/clouds.png"));
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		BlockTNT var17 = this.k.d(var1);
		float var18 = (float)var17.a;
		float var19 = (float)var17.b;
		float var20 = (float)var17.c;
		float var21;
		float var22;
		if(this.t.y.g) {
			var21 = (var18 * 30.0F + var19 * 59.0F + var20 * 11.0F) / 100.0F;
			var22 = (var18 * 30.0F + var19 * 70.0F) / 100.0F;
			float var23 = (var18 * 30.0F + var20 * 70.0F) / 100.0F;
			var18 = var21;
			var19 = var22;
			var20 = var23;
		}

		var21 = (float)(var13 * 0.0D);
		var22 = (float)(var15 * 0.0D);
		float var24 = (float)ModelPig.b(var13) * 0.00390625F;
		float var25 = (float)ModelPig.b(var15) * 0.00390625F;
		float var26 = (float)(var13 - (double)ModelPig.b(var13));
		float var27 = (float)(var15 - (double)ModelPig.b(var15));
		GL11.glScalef(12.0F, 1.0F, 12.0F);

		for(int var31 = 0; var31 < 2; ++var31) {
			if(var31 == 0) {
				GL11.glColorMask(false, false, false, false);
			} else {
				GL11.glColorMask(true, true, true, true);
			}

			for(int var32 = -2; var32 <= 3; ++var32) {
				for(int var33 = -2; var33 <= 3; ++var33) {
					var3.b();
					float var34 = (float)(var32 * 8);
					float var35 = (float)(var33 * 8);
					float var36 = var34 - var26;
					float var37 = var35 - var27;
					if(var10 > -5.0F) {
						var3.a(var18 * 0.7F, var19 * 0.7F, var20 * 0.7F, 0.8F);
						var3.b(0.0F, -1.0F, 0.0F);
						var3.a((double)(var36 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + 8.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 8.0F), (double)(var10 + 0.0F), (double)(var37 + 8.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 8.0F), (double)(var10 + 0.0F), (double)(var37 + 0.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + 0.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
					}

					if(var10 <= 5.0F) {
						var3.a(var18, var19, var20, 0.8F);
						var3.b(0.0F, 1.0F, 0.0F);
						var3.a((double)(var36 + 0.0F), (double)(var10 + 4.0F - 9.765625E-4F), (double)(var37 + 8.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 8.0F), (double)(var10 + 4.0F - 9.765625E-4F), (double)(var37 + 8.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 8.0F), (double)(var10 + 4.0F - 9.765625E-4F), (double)(var37 + 0.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
						var3.a((double)(var36 + 0.0F), (double)(var10 + 4.0F - 9.765625E-4F), (double)(var37 + 0.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
					}

					var3.a(var18 * 0.9F, var19 * 0.9F, var20 * 0.9F, 0.8F);
					int var38;
					if(var32 > -1) {
						var3.b(-1.0F, 0.0F, 0.0F);

						for(var38 = 0; var38 < 8; ++var38) {
							var3.a((double)(var36 + (float)var38 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + 8.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 0.0F), (double)(var10 + 4.0F), (double)(var37 + 8.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 0.0F), (double)(var10 + 4.0F), (double)(var37 + 0.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + 0.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
						}
					}

					if(var32 <= 1) {
						var3.b(1.0F, 0.0F, 0.0F);

						for(var38 = 0; var38 < 8; ++var38) {
							var3.a((double)(var36 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var10 + 0.0F), (double)(var37 + 8.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var10 + 4.0F), (double)(var37 + 8.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 8.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var10 + 4.0F), (double)(var37 + 0.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
							var3.a((double)(var36 + (float)var38 + 1.0F - 9.765625E-4F), (double)(var10 + 0.0F), (double)(var37 + 0.0F), (double)((var34 + (float)var38 + 0.5F) * 0.00390625F + var24), (double)((var35 + 0.0F) * 0.00390625F + var25));
						}
					}

					var3.a(var18 * 0.8F, var19 * 0.8F, var20 * 0.8F, 0.8F);
					if(var33 > -1) {
						var3.b(0.0F, 0.0F, -1.0F);

						for(var38 = 0; var38 < 8; ++var38) {
							var3.a((double)(var36 + 0.0F), (double)(var10 + 4.0F), (double)(var37 + (float)var38 + 0.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 8.0F), (double)(var10 + 4.0F), (double)(var37 + (float)var38 + 0.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 8.0F), (double)(var10 + 0.0F), (double)(var37 + (float)var38 + 0.0F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + (float)var38 + 0.0F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
						}
					}

					if(var33 <= 1) {
						var3.b(0.0F, 0.0F, 1.0F);

						for(var38 = 0; var38 < 8; ++var38) {
							var3.a((double)(var36 + 0.0F), (double)(var10 + 4.0F), (double)(var37 + (float)var38 + 1.0F - 9.765625E-4F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 8.0F), (double)(var10 + 4.0F), (double)(var37 + (float)var38 + 1.0F - 9.765625E-4F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 8.0F), (double)(var10 + 0.0F), (double)(var37 + (float)var38 + 1.0F - 9.765625E-4F), (double)((var34 + 8.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
							var3.a((double)(var36 + 0.0F), (double)(var10 + 0.0F), (double)(var37 + (float)var38 + 1.0F - 9.765625E-4F), (double)((var34 + 0.0F) * 0.00390625F + var24), (double)((var35 + (float)var38 + 0.5F) * 0.00390625F + var25));
						}
					}

					var3.a();
				}
			}
		}

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_CULL_FACE);
	}

	public boolean a(BlockMobSpawner var1, boolean var2) {
		Collections.sort(this.m, new EntityCreeper(var1));
		int var3 = this.m.size() - 1;
		int var4 = this.m.size();

		for(int var5 = 0; var5 < var4; ++var5) {
			TileEntity var6 = (TileEntity)this.m.get(var3 - var5);
			if(!var2) {
				if(var6.a((EntityMinecart)var1) > 1024.0F) {
					if(var6.o) {
						if(var5 >= 3) {
							return false;
						}
					} else if(var5 >= 1) {
						return false;
					}
				}
			} else if(!var6.o) {
				continue;
			}

			var6.a();
			this.m.remove(var6);
			var6.u = false;
		}

		return this.m.size() == 0;
	}

	public void a(BlockMobSpawner var1, lv var2, int var3, TileEntityFurnace var4, float var5) {
		NBTTagByteArray var6 = NBTTagByteArray.a;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, (ModelPig.a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.4F) * 0.5F);
		if(var3 == 0) {
			if(this.i > 0.0F) {
				GL11.glBlendFunc(GL11.GL_DST_COLOR, GL11.GL_SRC_COLOR);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/terrain.png"));
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
				GL11.glPushMatrix();
				int var7 = this.k.a(var2.b, var2.c, var2.d);
				ln var8 = var7 > 0?ln.n[var7]:null;
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				GL11.glPolygonOffset(-3.0F, -3.0F);
				GL11.glEnable('\u8037');
				var6.b();
				var6.b(-(var1.aF + (var1.ah - var1.aF) * (double)var5), -(var1.aG + (var1.ai - var1.aG) * (double)var5), -(var1.aH + (var1.aj - var1.aH) * (double)var5));
				var6.c();
				if(var8 == null) {
					var8 = ln.t;
				}

				this.u.a(var8, var2.b, var2.c, var2.d, 240 + (int)(this.i * 10.0F));
				var6.a();
				var6.b(0.0D, 0.0D, 0.0D);
				GL11.glPolygonOffset(0.0F, 0.0F);
				GL11.glDisable('\u8037');
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glDepthMask(true);
				GL11.glPopMatrix();
			}
		} else if(var4 != null) {
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			float var11 = ModelPig.a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.8F;
			GL11.glColor4f(var11, var11, var11, ModelPig.a((float)System.currentTimeMillis() / 200.0F) * 0.2F + 0.5F);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.l.a("/terrain.png"));
			int var12 = var2.b;
			int var9 = var2.c;
			int var10 = var2.d;
			if(var2.e == 0) {
				--var9;
			}

			if(var2.e == 1) {
				++var9;
			}

			if(var2.e == 2) {
				--var10;
			}

			if(var2.e == 3) {
				++var10;
			}

			if(var2.e == 4) {
				--var12;
			}

			if(var2.e == 5) {
				++var12;
			}
		}

		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
	}

	public void b(BlockMobSpawner var1, lv var2, int var3, TileEntityFurnace var4, float var5) {
		if(var3 == 0 && var2.a == 0) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
			GL11.glLineWidth(2.0F);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDepthMask(false);
			int var7 = this.k.a(var2.b, var2.c, var2.d);
			if(var7 > 0) {
				ln.n[var7].a((mz)this.k, var2.b, var2.c, var2.d);
				this.a(ln.n[var7].f(this.k, var2.b, var2.c, var2.d).b(0.0020000000949949026D, 0.0020000000949949026D, 0.0020000000949949026D).c(-(var1.aF + (var1.ah - var1.aF) * (double)var5), -(var1.aG + (var1.ai - var1.aG) * (double)var5), -(var1.aH + (var1.aj - var1.aH) * (double)var5)));
			}

			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_BLEND);
		}

	}

	private void a(EntityRenderer var1) {
		NBTTagByteArray var2 = NBTTagByteArray.a;
		var2.a(3);
		var2.a(var1.a, var1.b, var1.c);
		var2.a(var1.d, var1.b, var1.c);
		var2.a(var1.d, var1.b, var1.f);
		var2.a(var1.a, var1.b, var1.f);
		var2.a(var1.a, var1.b, var1.c);
		var2.a();
		var2.a(3);
		var2.a(var1.a, var1.e, var1.c);
		var2.a(var1.d, var1.e, var1.c);
		var2.a(var1.d, var1.e, var1.f);
		var2.a(var1.a, var1.e, var1.f);
		var2.a(var1.a, var1.e, var1.c);
		var2.a();
		var2.a(1);
		var2.a(var1.a, var1.b, var1.c);
		var2.a(var1.a, var1.e, var1.c);
		var2.a(var1.d, var1.b, var1.c);
		var2.a(var1.d, var1.e, var1.c);
		var2.a(var1.d, var1.b, var1.f);
		var2.a(var1.d, var1.e, var1.f);
		var2.a(var1.a, var1.b, var1.f);
		var2.a(var1.a, var1.e, var1.f);
		var2.a();
	}

	public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = ModelPig.a(var1, 16);
		int var8 = ModelPig.a(var2, 16);
		int var9 = ModelPig.a(var3, 16);
		int var10 = ModelPig.a(var4, 16);
		int var11 = ModelPig.a(var5, 16);
		int var12 = ModelPig.a(var6, 16);

		for(int var13 = var7; var13 <= var10; ++var13) {
			int var14 = var13 % this.p;
			if(var14 < 0) {
				var14 += this.p;
			}

			for(int var15 = var8; var15 <= var11; ++var15) {
				int var16 = var15 % this.q;
				if(var16 < 0) {
					var16 += this.q;
				}

				for(int var17 = var9; var17 <= var12; ++var17) {
					int var18 = var17 % this.r;
					if(var18 < 0) {
						var18 += this.r;
					}

					TileEntity var19 = this.o[(var18 * this.q + var16) * this.p + var14];
					if(!var19.u) {
						this.m.add(var19);
					}

					var19.f();
				}
			}
		}

	}

	public void a(int var1, int var2, int var3) {
		this.a(var1 - 1, var2 - 1, var3 - 1, var1 + 1, var2 + 1, var3 + 1);
	}

	public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.a(var1 - 1, var2 - 1, var3 - 1, var4 + 1, var5 + 1, var6 + 1);
	}

	public void a(nq var1, float var2) {
		for(int var3 = 0; var3 < this.o.length; ++var3) {
			if(!this.o[var3].e() && (!this.o[var3].o || (var3 + this.j & 15) == 0)) {
				this.o[var3].a(var1);
			}
		}

		++this.j;
	}

	public void a(String var1, int var2, int var3, int var4) {
		if(var1 != null) {
			this.t.u.b(var1);
		}

		this.t.A.a(var1, (float)var2, (float)var3, (float)var4, 1.0F, 1.0F);
	}

	public void a(String var1, double var2, double var4, double var6, float var8, float var9) {
		float var10 = 16.0F;
		if(var8 > 1.0F) {
			var10 *= var8;
		}

		if(this.t.g.d(var2, var4, var6) < (double)(var10 * var10)) {
			this.t.A.b(var1, (float)var2, (float)var4, (float)var6, var8, var9);
		}

	}

	public void a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		double var14 = this.t.g.ah - var2;
		double var16 = this.t.g.ai - var4;
		double var18 = this.t.g.aj - var6;
		if(var14 * var14 + var16 * var16 + var18 * var18 <= 256.0D) {
			if(var1 == "bubble") {
				this.t.h.a((nd)(new BlockFlowing(this.k, var2, var4, var6, var8, var10, var12)));
			} else if(var1 == "smoke") {
				this.t.h.a((nd)(new my(this.k, var2, var4, var6)));
			} else if(var1 == "explode") {
				this.t.h.a((nd)(new NoiseGenerator(this.k, var2, var4, var6, var8, var10, var12)));
			} else if(var1 == "flame") {
				this.t.h.a((nd)(new NBTTagString(this.k, var2, var4, var6, var8, var10, var12)));
			} else if(var1 == "lava") {
				this.t.h.a((nd)(new EntityBubbleFX(this.k, var2, var4, var6)));
			} else if(var1 == "splash") {
				this.t.h.a((nd)(new Material(this.k, var2, var4, var6, var8, var10, var12)));
			} else if(var1 == "largesmoke") {
				this.t.h.a((nd)(new my(this.k, var2, var4, var6, 2.5F)));
			} else if(var1 == "reddust") {
				this.t.h.a((nd)(new TextureFlamesFX(this.k, var2, var4, var6)));
			} else if(var1 == "snowballpoof") {
				this.t.h.a((nd)(new MathHelper(this.k, var2, var4, var6, EntityTNTPrimed.aB)));
			} else if(var1 == "slime") {
				this.t.h.a((nd)(new MathHelper(this.k, var2, var4, var6, EntityTNTPrimed.aK)));
			}

		}
	}

	public void a(EntityMinecart var1) {
		if(var1.aV != null) {
			this.l.a(var1.aV, (TerrainTextureManager)(new RenderSheep()));
		}

	}

	public void b(EntityMinecart var1) {
		if(var1.aV != null) {
			this.l.b(var1.aV);
		}

	}

	public void e() {
		for(int var1 = 0; var1 < this.o.length; ++var1) {
			if(this.o[var1].A) {
				if(!this.o[var1].u) {
					this.m.add(this.o[var1]);
				}

				this.o[var1].f();
			}
		}

	}
}
