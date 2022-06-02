package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class TileEntitySpecialRenderer {
	private ImageBufferDownload[] j;
	private la[] k;
	private int l;
	private int m;
	public float a;
	public float b;
	public float c;
	public float d;
	public float e;
	public float f;
	private boolean n = false;
	private int o = 0;
	public boolean g = false;
	public boolean h = true;
	public boolean i = false;

	public TileEntitySpecialRenderer(int var1, int var2) {
		this.l = var1;
		this.m = var2;
	}

	public void a(float var1, float var2, float var3, int var4, int var5, int var6) {
		this.a(var1, var2, var3, var4, var5, var6, 0.0F);
	}

	public void a(float var1, float var2, float var3, int var4, int var5, int var6, float var7) {
		this.j = new ImageBufferDownload[8];
		this.k = new la[6];
		float var8 = var1 + (float)var4;
		float var9 = var2 + (float)var5;
		float var10 = var3 + (float)var6;
		var1 -= var7;
		var2 -= var7;
		var3 -= var7;
		var8 += var7;
		var9 += var7;
		var10 += var7;
		if(this.g) {
			float var11 = var8;
			var8 = var1;
			var1 = var11;
		}

		ImageBufferDownload var20 = new ImageBufferDownload(var1, var2, var3, 0.0F, 0.0F);
		ImageBufferDownload var12 = new ImageBufferDownload(var8, var2, var3, 0.0F, 8.0F);
		ImageBufferDownload var13 = new ImageBufferDownload(var8, var9, var3, 8.0F, 8.0F);
		ImageBufferDownload var14 = new ImageBufferDownload(var1, var9, var3, 8.0F, 0.0F);
		ImageBufferDownload var15 = new ImageBufferDownload(var1, var2, var10, 0.0F, 0.0F);
		ImageBufferDownload var16 = new ImageBufferDownload(var8, var2, var10, 0.0F, 8.0F);
		ImageBufferDownload var17 = new ImageBufferDownload(var8, var9, var10, 8.0F, 8.0F);
		ImageBufferDownload var18 = new ImageBufferDownload(var1, var9, var10, 8.0F, 0.0F);
		this.j[0] = var20;
		this.j[1] = var12;
		this.j[2] = var13;
		this.j[3] = var14;
		this.j[4] = var15;
		this.j[5] = var16;
		this.j[6] = var17;
		this.j[7] = var18;
		this.k[0] = new la(new ImageBufferDownload[]{var16, var12, var13, var17}, this.l + var6 + var4, this.m + var6, this.l + var6 + var4 + var6, this.m + var6 + var5);
		this.k[1] = new la(new ImageBufferDownload[]{var20, var15, var18, var14}, this.l + 0, this.m + var6, this.l + var6, this.m + var6 + var5);
		this.k[2] = new la(new ImageBufferDownload[]{var16, var15, var20, var12}, this.l + var6, this.m + 0, this.l + var6 + var4, this.m + var6);
		this.k[3] = new la(new ImageBufferDownload[]{var13, var14, var18, var17}, this.l + var6 + var4, this.m + 0, this.l + var6 + var4 + var4, this.m + var6);
		this.k[4] = new la(new ImageBufferDownload[]{var12, var20, var14, var13}, this.l + var6, this.m + var6, this.l + var6 + var4, this.m + var6 + var5);
		this.k[5] = new la(new ImageBufferDownload[]{var15, var16, var17, var18}, this.l + var6 + var4 + var6, this.m + var6, this.l + var6 + var4 + var6 + var4, this.m + var6 + var5);
		if(this.g) {
			for(int var19 = 0; var19 < this.k.length; ++var19) {
				this.k[var19].a();
			}
		}

	}

	public void a(float var1, float var2, float var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public void a(float var1) {
		if(!this.i) {
			if(this.h) {
				if(!this.n) {
					this.c(var1);
				}

				if(this.d == 0.0F && this.e == 0.0F && this.f == 0.0F) {
					if(this.a == 0.0F && this.b == 0.0F && this.c == 0.0F) {
						GL11.glCallList(this.o);
					} else {
						GL11.glTranslatef(this.a * var1, this.b * var1, this.c * var1);
						GL11.glCallList(this.o);
						GL11.glTranslatef(-this.a * var1, -this.b * var1, -this.c * var1);
					}
				} else {
					GL11.glPushMatrix();
					GL11.glTranslatef(this.a * var1, this.b * var1, this.c * var1);
					if(this.f != 0.0F) {
						GL11.glRotatef(this.f * 57.295776F, 0.0F, 0.0F, 1.0F);
					}

					if(this.e != 0.0F) {
						GL11.glRotatef(this.e * 57.295776F, 0.0F, 1.0F, 0.0F);
					}

					if(this.d != 0.0F) {
						GL11.glRotatef(this.d * 57.295776F, 1.0F, 0.0F, 0.0F);
					}

					GL11.glCallList(this.o);
					GL11.glPopMatrix();
				}

			}
		}
	}

	public void b(float var1) {
		if(!this.i) {
			if(this.h) {
				if(!this.n) {
					this.c(var1);
				}

				if(this.d == 0.0F && this.e == 0.0F && this.f == 0.0F) {
					if(this.a != 0.0F || this.b != 0.0F || this.c != 0.0F) {
						GL11.glTranslatef(this.a * var1, this.b * var1, this.c * var1);
					}
				} else {
					GL11.glTranslatef(this.a * var1, this.b * var1, this.c * var1);
					if(this.f != 0.0F) {
						GL11.glRotatef(this.f * 57.295776F, 0.0F, 0.0F, 1.0F);
					}

					if(this.e != 0.0F) {
						GL11.glRotatef(this.e * 57.295776F, 0.0F, 1.0F, 0.0F);
					}

					if(this.d != 0.0F) {
						GL11.glRotatef(this.d * 57.295776F, 1.0F, 0.0F, 0.0F);
					}
				}

			}
		}
	}

	private void c(float var1) {
		this.o = BlockRedstoneTorch.a(1);
		GL11.glNewList(this.o, GL11.GL_COMPILE);
		NBTTagByteArray var2 = NBTTagByteArray.a;

		for(int var3 = 0; var3 < this.k.length; ++var3) {
			this.k[var3].a(var2, var1);
		}

		GL11.glEndList();
		this.n = true;
	}
}
