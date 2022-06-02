package net.minecraft.src;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class NBTTagByteArray {
	private static boolean b = true;
	private static boolean c = false;
	private ByteBuffer d;
	private IntBuffer e;
	private FloatBuffer f;
	private int[] g;
	private int h = 0;
	private double i;
	private double j;
	private int k;
	private boolean l = false;
	private boolean m = false;
	private boolean n = false;
	private int o = 0;
	private int p = 0;
	private boolean q = false;
	private int r;
	private double s;
	private double t;
	private double u;
	private int v;
	public static final NBTTagByteArray a = new NBTTagByteArray(2097152);
	private boolean w = false;
	private boolean x = false;
	private IntBuffer y;
	private int z = 0;
	private int A = 10;
	private int B;

	private NBTTagByteArray(int var1) {
		this.B = var1;
		this.d = BlockRedstoneTorch.b(var1 * 4);
		this.e = this.d.asIntBuffer();
		this.f = this.d.asFloatBuffer();
		this.g = new int[var1];
		this.x = c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
		if(this.x) {
			this.y = BlockRedstoneTorch.c(this.A);
			ARBVertexBufferObject.glGenBuffersARB(this.y);
		}

	}

	public void a() {
		if(!this.w) {
			throw new IllegalStateException("Not tesselating!");
		} else {
			this.w = false;
			if(this.h > 0) {
				this.e.clear();
				this.e.put(this.g, 0, this.o);
				this.d.position(0);
				this.d.limit(this.o * 4);
				if(this.x) {
					this.z = (this.z + 1) % this.A;
					ARBVertexBufferObject.glBindBufferARB('\u8892', this.y.get(this.z));
					ARBVertexBufferObject.glBufferDataARB('\u8892', this.d, '\u88e0');
				}

				if(this.m) {
					if(this.x) {
						GL11.glTexCoordPointer(2, GL11.GL_FLOAT, 32, 12L);
					} else {
						this.f.position(3);
						GL11.glTexCoordPointer(2, 32, this.f);
					}

					GL11.glEnableClientState('\u8078');
				}

				if(this.l) {
					if(this.x) {
						GL11.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 32, 20L);
					} else {
						this.d.position(20);
						GL11.glColorPointer(4, true, 32, this.d);
					}

					GL11.glEnableClientState('\u8076');
				}

				if(this.n) {
					if(this.x) {
						GL11.glNormalPointer(GL11.GL_BYTE, 32, 24L);
					} else {
						this.d.position(24);
						GL11.glNormalPointer(32, this.d);
					}

					GL11.glEnableClientState('\u8075');
				}

				if(this.x) {
					GL11.glVertexPointer(3, GL11.GL_FLOAT, 32, 0L);
				} else {
					this.f.position(0);
					GL11.glVertexPointer(3, 32, this.f);
				}

				GL11.glEnableClientState('\u8074');
				if(this.r == 7 && b) {
					GL11.glDrawArrays(GL11.GL_TRIANGLES, GL11.GL_POINTS, this.h);
				} else {
					GL11.glDrawArrays(this.r, GL11.GL_POINTS, this.h);
				}

				GL11.glDisableClientState('\u8074');
				if(this.m) {
					GL11.glDisableClientState('\u8078');
				}

				if(this.l) {
					GL11.glDisableClientState('\u8076');
				}

				if(this.n) {
					GL11.glDisableClientState('\u8075');
				}
			}

			this.d();
		}
	}

	private void d() {
		this.h = 0;
		this.d.clear();
		this.o = 0;
		this.p = 0;
	}

	public void b() {
		this.a(7);
	}

	public void a(int var1) {
		if(this.w) {
			throw new IllegalStateException("Already tesselating!");
		} else {
			this.w = true;
			this.d();
			this.r = var1;
			this.n = false;
			this.l = false;
			this.m = false;
			this.q = false;
		}
	}

	public void a(double var1, double var3) {
		this.m = true;
		this.i = var1;
		this.j = var3;
	}

	public void a(float var1, float var2, float var3) {
		this.a((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F));
	}

	public void a(float var1, float var2, float var3, float var4) {
		this.a((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F), (int)(var4 * 255.0F));
	}

	public void a(int var1, int var2, int var3) {
		this.a(var1, var2, var3, 255);
	}

	public void a(int var1, int var2, int var3, int var4) {
		if(!this.q) {
			if(var1 > 255) {
				var1 = 255;
			}

			if(var2 > 255) {
				var2 = 255;
			}

			if(var3 > 255) {
				var3 = 255;
			}

			if(var4 > 255) {
				var4 = 255;
			}

			if(var1 < 0) {
				var1 = 0;
			}

			if(var2 < 0) {
				var2 = 0;
			}

			if(var3 < 0) {
				var3 = 0;
			}

			if(var4 < 0) {
				var4 = 0;
			}

			this.l = true;
			this.k = var4 << 24 | var3 << 16 | var2 << 8 | var1;
		}
	}

	public void a(double var1, double var3, double var5, double var7, double var9) {
		this.a(var7, var9);
		this.a(var1, var3, var5);
	}

	public void a(double var1, double var3, double var5) {
		++this.p;
		if(this.r == 7 && b && this.p % 4 == 0) {
			for(int var7 = 0; var7 < 2; ++var7) {
				int var8 = 8 * (3 - var7);
				if(this.m) {
					this.g[this.o + 3] = this.g[this.o - var8 + 3];
					this.g[this.o + 4] = this.g[this.o - var8 + 4];
				}

				if(this.l) {
					this.g[this.o + 5] = this.g[this.o - var8 + 5];
				}

				this.g[this.o + 0] = this.g[this.o - var8 + 0];
				this.g[this.o + 1] = this.g[this.o - var8 + 1];
				this.g[this.o + 2] = this.g[this.o - var8 + 2];
				++this.h;
				this.o += 8;
			}
		}

		if(this.m) {
			this.g[this.o + 3] = Float.floatToRawIntBits((float)this.i);
			this.g[this.o + 4] = Float.floatToRawIntBits((float)this.j);
		}

		if(this.l) {
			this.g[this.o + 5] = this.k;
		}

		if(this.n) {
			this.g[this.o + 6] = this.v;
		}

		this.g[this.o + 0] = Float.floatToRawIntBits((float)(var1 + this.s));
		this.g[this.o + 1] = Float.floatToRawIntBits((float)(var3 + this.t));
		this.g[this.o + 2] = Float.floatToRawIntBits((float)(var5 + this.u));
		this.o += 8;
		++this.h;
		if(this.h % 4 == 0 && this.o >= this.B - 32) {
			this.a();
			this.w = true;
		}

	}

	public void b(int var1) {
		int var2 = var1 >> 16 & 255;
		int var3 = var1 >> 8 & 255;
		int var4 = var1 & 255;
		this.a(var2, var3, var4);
	}

	public void c() {
		this.q = true;
	}

	public void b(float var1, float var2, float var3) {
		if(!this.w) {
			System.out.println("But..");
		}

		this.n = true;
		byte var4 = (byte)((int)(var1 * 128.0F));
		byte var5 = (byte)((int)(var2 * 127.0F));
		byte var6 = (byte)((int)(var3 * 127.0F));
		this.v = var4 | var5 << 8 | var6 << 16;
	}

	public void b(double var1, double var3, double var5) {
		this.s = var1;
		this.t = var3;
		this.u = var5;
	}

	public void c(float var1, float var2, float var3) {
		this.s += (double)var1;
		this.t += (double)var2;
		this.u += (double)var3;
	}
}
