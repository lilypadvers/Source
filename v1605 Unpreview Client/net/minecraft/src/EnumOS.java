package net.minecraft.src;

public class EnumOS {
	public float[][] a = new float[16][16];
	public float[] b = new float[16];
	public float[] c = new float[16];
	public float[] d = new float[16];

	public boolean a(double var1, double var3, double var5, double var7, double var9, double var11) {
		for(int var13 = 0; var13 < 6; ++var13) {
			if((double)this.a[var13][0] * var1 + (double)this.a[var13][1] * var3 + (double)this.a[var13][2] * var5 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var7 + (double)this.a[var13][1] * var3 + (double)this.a[var13][2] * var5 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var1 + (double)this.a[var13][1] * var9 + (double)this.a[var13][2] * var5 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var7 + (double)this.a[var13][1] * var9 + (double)this.a[var13][2] * var5 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var1 + (double)this.a[var13][1] * var3 + (double)this.a[var13][2] * var11 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var7 + (double)this.a[var13][1] * var3 + (double)this.a[var13][2] * var11 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var1 + (double)this.a[var13][1] * var9 + (double)this.a[var13][2] * var11 + (double)this.a[var13][3] <= 0.0D && (double)this.a[var13][0] * var7 + (double)this.a[var13][1] * var9 + (double)this.a[var13][2] * var11 + (double)this.a[var13][3] <= 0.0D) {
				return false;
			}
		}

		return true;
	}
}
