package net.minecraft.src;

public class ModelPig {
	private static float[] a = new float[65536];

	public static final float a(float var0) {
		return a[(int)(var0 * 10430.378F) & '\uffff'];
	}

	public static final float b(float var0) {
		return a[(int)(var0 * 10430.378F + 16384.0F) & '\uffff'];
	}

	public static final float c(float var0) {
		return (float)Math.sqrt((double)var0);
	}

	public static final float a(double var0) {
		return (float)Math.sqrt(var0);
	}

	public static int d(float var0) {
		int var1 = (int)var0;
		return var0 < (float)var1?var1 - 1:var1;
	}

	public static int b(double var0) {
		int var2 = (int)var0;
		return var0 < (double)var2?var2 - 1:var2;
	}

	public static float e(float var0) {
		return var0 >= 0.0F?var0:-var0;
	}

	public static double a(double var0, double var2) {
		if(var0 < 0.0D) {
			var0 = -var0;
		}

		if(var2 < 0.0D) {
			var2 = -var2;
		}

		return var0 > var2?var0:var2;
	}

	public static int a(int var0, int var1) {
		return var0 < 0?-((-var0 - 1) / var1) - 1:var0 / var1;
	}

	static {
		for(int var0 = 0; var0 < 65536; ++var0) {
			a[var0] = (float)Math.sin((double)var0 * Math.PI * 2.0D / 65536.0D);
		}

	}
}
