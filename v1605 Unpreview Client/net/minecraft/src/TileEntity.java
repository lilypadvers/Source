package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class TileEntity {
	public EntitySpider a;
	private int C = -1;
	private static NBTTagByteArray D = NBTTagByteArray.a;
	public static int xCoord = 0;
	public int yCoord;
	public int zCoord;
	public int e;
	public int f;
	public int g;
	public int h;
	public int i;
	public int j;
	public int k;
	public int l;
	public int m;
	public int n;
	public boolean o = false;
	public boolean[] p = new boolean[2];
	public int q;
	public int r;
	public int s;
	public float t;
	public boolean u;
	public EntityRenderer v;
	public int w;
	public boolean x = true;
	public boolean y;
	public int z;
	public boolean A;
	private boolean E = false;
	public List B = new ArrayList();
	private List F;

	public TileEntity(EntitySpider var1, List var2, int var3, int var4, int var5, int var6, int var7) {
		this.a = var1;
		this.F = var2;
		this.f = this.g = this.h = var6;
		this.t = ModelPig.c((float)(this.f * this.f + this.g * this.g + this.h * this.h)) / 2.0F;
		this.C = var7;
		this.yCoord = -999;
		this.a(var3, var4, var5);
		this.u = false;
	}

	public void a(int var1, int var2, int var3) {
		if(var1 != this.yCoord || var2 != this.zCoord || var3 != this.e) {
			this.b();
			this.yCoord = var1;
			this.zCoord = var2;
			this.e = var3;
			this.q = var1 + this.f / 2;
			this.r = var2 + this.g / 2;
			this.s = var3 + this.h / 2;
			this.l = var1 & 1023;
			this.m = var2;
			this.n = var3 & 1023;
			this.i = var1 - this.l;
			this.j = var2 - this.m;
			this.k = var3 - this.n;
			float var4 = 2.0F;
			this.v = EntityRenderer.a((double)((float)var1 - var4), (double)((float)var2 - var4), (double)((float)var3 - var4), (double)((float)(var1 + this.f) + var4), (double)((float)(var2 + this.g) + var4), (double)((float)(var3 + this.h) + var4));
			GL11.glNewList(this.C + 2, GL11.GL_COMPILE);
			ModelMinecart.a(EntityRenderer.b((double)((float)this.l - var4), (double)((float)this.m - var4), (double)((float)this.n - var4), (double)((float)(this.l + this.f) + var4), (double)((float)(this.m + this.g) + var4), (double)((float)(this.n + this.h) + var4)));
			GL11.glEndList();
			this.f();
		}
	}

	private void g() {
		GL11.glTranslatef((float)this.l, (float)this.m, (float)this.n);
	}

	public void a() {
		if(this.u) {
			++xCoord;
			int var1 = this.yCoord;
			int var2 = this.zCoord;
			int var3 = this.e;
			int var4 = this.yCoord + this.f;
			int var5 = this.zCoord + this.g;
			int var6 = this.e + this.h;

			for(int var7 = 0; var7 < 2; ++var7) {
				this.p[var7] = true;
			}

			BlockMushroom.a = false;
			HashSet var21 = new HashSet();
			var21.addAll(this.B);
			this.B.clear();
			byte var8 = 1;
			GuiGameOver var9 = new GuiGameOver(this.a, var1 - var8, var2 - var8, var3 - var8, var4 + var8, var5 + var8, var6 + var8);
			GuiCrafting var10 = new GuiCrafting(var9);

			for(int var11 = 0; var11 < 2; ++var11) {
				boolean var12 = false;
				boolean var13 = false;
				boolean var14 = false;

				for(int var15 = var2; var15 < var5; ++var15) {
					for(int var16 = var3; var16 < var6; ++var16) {
						for(int var17 = var1; var17 < var4; ++var17) {
							int var18 = var9.a(var17, var15, var16);
							if(var18 > 0) {
								if(!var14) {
									var14 = true;
									GL11.glNewList(this.C + var11, GL11.GL_COMPILE);
									GL11.glPushMatrix();
									this.g();
									float var19 = 1.000001F;
									GL11.glTranslatef((float)(-this.h) / 2.0F, (float)(-this.g) / 2.0F, (float)(-this.h) / 2.0F);
									GL11.glScalef(var19, var19, var19);
									GL11.glTranslatef((float)this.h / 2.0F, (float)this.g / 2.0F, (float)this.h / 2.0F);
									D.b();
									D.b((double)(-this.yCoord), (double)(-this.zCoord), (double)(-this.e));
								}

								if(var11 == 0 && ln.n[var18] instanceof ChunkProviderLoadOrGenerate) {
									EntityCreature var23 = var9.b(var17, var15, var16);
									if(ThreadDownloadImage.a.a(var23)) {
										this.B.add(var23);
									}
								}

								ln var24 = ln.n[var18];
								int var20 = var24.g();
								if(var20 != var11) {
									var12 = true;
								} else if(var20 == var11) {
									var13 |= var10.a(var24, var17, var15, var16);
								}
							}
						}
					}
				}

				if(var14) {
					D.a();
					GL11.glPopMatrix();
					GL11.glEndList();
					D.b(0.0D, 0.0D, 0.0D);
				} else {
					var13 = false;
				}

				if(var13) {
					this.p[var11] = false;
				}

				if(!var12) {
					break;
				}
			}

			HashSet var22 = new HashSet();
			var22.addAll(this.B);
			var22.removeAll(var21);
			this.F.addAll(var22);
			var21.removeAll(this.B);
			this.F.removeAll(var21);
			this.A = BlockMushroom.a;
			this.E = true;
		}
	}

	public float a(EntityMinecart var1) {
		float var2 = (float)(var1.ah - (double)this.q);
		float var3 = (float)(var1.ai - (double)this.r);
		float var4 = (float)(var1.aj - (double)this.s);
		return var2 * var2 + var3 * var3 + var4 * var4;
	}

	public void b() {
		for(int var1 = 0; var1 < 2; ++var1) {
			this.p[var1] = true;
		}

		this.o = false;
		this.E = false;
	}

	public void c() {
		this.b();
		this.a = null;
	}

	public int a(int var1) {
		return !this.o?-1:(!this.p[var1]?this.C + var1:-1);
	}

	public void a(nq var1) {
		this.o = var1.a(this.v);
	}

	public void onInventoryChanged() {
		GL11.glCallList(this.C + 2);
	}

	public boolean e() {
		return !this.E?false:this.p[0] && this.p[1];
	}

	public void f() {
		this.u = true;
	}
}
