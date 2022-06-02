package net.minecraft.src;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class ModelSheep extends EnumOS {
	private static ModelSheep e = new ModelSheep();
	private FloatBuffer f = BlockRedstoneTorch.d(16);
	private FloatBuffer g = BlockRedstoneTorch.d(16);
	private FloatBuffer h = BlockRedstoneTorch.d(16);

	public static EnumOS a() {
		e.b();
		return e;
	}

	private void a(float[][] var1, int var2) {
		float var3 = ModelPig.c(var1[var2][0] * var1[var2][0] + var1[var2][1] * var1[var2][1] + var1[var2][2] * var1[var2][2]);
		var1[var2][0] /= var3;
		var1[var2][1] /= var3;
		var1[var2][2] /= var3;
		var1[var2][3] /= var3;
	}

	private void b() {
		this.f.clear();
		this.g.clear();
		this.h.clear();
		GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, this.f);
		GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, this.g);
		this.f.flip().limit(16);
		this.f.get(this.b);
		this.g.flip().limit(16);
		this.g.get(this.c);
		this.d[0] = this.c[0] * this.b[0] + this.c[1] * this.b[4] + this.c[2] * this.b[8] + this.c[3] * this.b[12];
		this.d[1] = this.c[0] * this.b[1] + this.c[1] * this.b[5] + this.c[2] * this.b[9] + this.c[3] * this.b[13];
		this.d[2] = this.c[0] * this.b[2] + this.c[1] * this.b[6] + this.c[2] * this.b[10] + this.c[3] * this.b[14];
		this.d[3] = this.c[0] * this.b[3] + this.c[1] * this.b[7] + this.c[2] * this.b[11] + this.c[3] * this.b[15];
		this.d[4] = this.c[4] * this.b[0] + this.c[5] * this.b[4] + this.c[6] * this.b[8] + this.c[7] * this.b[12];
		this.d[5] = this.c[4] * this.b[1] + this.c[5] * this.b[5] + this.c[6] * this.b[9] + this.c[7] * this.b[13];
		this.d[6] = this.c[4] * this.b[2] + this.c[5] * this.b[6] + this.c[6] * this.b[10] + this.c[7] * this.b[14];
		this.d[7] = this.c[4] * this.b[3] + this.c[5] * this.b[7] + this.c[6] * this.b[11] + this.c[7] * this.b[15];
		this.d[8] = this.c[8] * this.b[0] + this.c[9] * this.b[4] + this.c[10] * this.b[8] + this.c[11] * this.b[12];
		this.d[9] = this.c[8] * this.b[1] + this.c[9] * this.b[5] + this.c[10] * this.b[9] + this.c[11] * this.b[13];
		this.d[10] = this.c[8] * this.b[2] + this.c[9] * this.b[6] + this.c[10] * this.b[10] + this.c[11] * this.b[14];
		this.d[11] = this.c[8] * this.b[3] + this.c[9] * this.b[7] + this.c[10] * this.b[11] + this.c[11] * this.b[15];
		this.d[12] = this.c[12] * this.b[0] + this.c[13] * this.b[4] + this.c[14] * this.b[8] + this.c[15] * this.b[12];
		this.d[13] = this.c[12] * this.b[1] + this.c[13] * this.b[5] + this.c[14] * this.b[9] + this.c[15] * this.b[13];
		this.d[14] = this.c[12] * this.b[2] + this.c[13] * this.b[6] + this.c[14] * this.b[10] + this.c[15] * this.b[14];
		this.d[15] = this.c[12] * this.b[3] + this.c[13] * this.b[7] + this.c[14] * this.b[11] + this.c[15] * this.b[15];
		this.a[0][0] = this.d[3] - this.d[0];
		this.a[0][1] = this.d[7] - this.d[4];
		this.a[0][2] = this.d[11] - this.d[8];
		this.a[0][3] = this.d[15] - this.d[12];
		this.a(this.a, 0);
		this.a[1][0] = this.d[3] + this.d[0];
		this.a[1][1] = this.d[7] + this.d[4];
		this.a[1][2] = this.d[11] + this.d[8];
		this.a[1][3] = this.d[15] + this.d[12];
		this.a(this.a, 1);
		this.a[2][0] = this.d[3] + this.d[1];
		this.a[2][1] = this.d[7] + this.d[5];
		this.a[2][2] = this.d[11] + this.d[9];
		this.a[2][3] = this.d[15] + this.d[13];
		this.a(this.a, 2);
		this.a[3][0] = this.d[3] - this.d[1];
		this.a[3][1] = this.d[7] - this.d[5];
		this.a[3][2] = this.d[11] - this.d[9];
		this.a[3][3] = this.d[15] - this.d[13];
		this.a(this.a, 3);
		this.a[4][0] = this.d[3] - this.d[2];
		this.a[4][1] = this.d[7] - this.d[6];
		this.a[4][2] = this.d[11] - this.d[10];
		this.a[4][3] = this.d[15] - this.d[14];
		this.a(this.a, 4);
		this.a[5][0] = this.d[3] + this.d[2];
		this.a[5][1] = this.d[7] + this.d[6];
		this.a[5][2] = this.d[11] + this.d[10];
		this.a[5][3] = this.d[15] + this.d[14];
		this.a(this.a, 5);
	}
}
