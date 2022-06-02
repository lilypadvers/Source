package net.minecraft.src;

import mcextension_a1605.auth.PreviewAuth;

public class ColorUtil {
	public static float[] BlendColor(float var0, float var1, float var2, float var3) {
		float var4 = 0.58431375F;
		float var5 = 0.0F;
		float var6 = 1.0F;
		float var7;
		if(PreviewAuth.rdMins <= 5) {
			long var8 = PreviewAuth.endtime - System.currentTimeMillis();
			var7 = (1.0F - (float)var8 / 300000.0F) / 2.0F;
		} else {
			var7 = 0.0F;
		}

		float[] var10 = new float[]{var7 * var4 + (1.0F - var7) * var1, var7 * var5 + (1.0F - var7) * var2, var7 * var6 + (1.0F - var7) * var3};
		return var10;
	}

	public static String timeRemaining() {
		long var0 = (PreviewAuth.endtime - System.currentTimeMillis()) / 1000L;
		long var2 = var0 % 60L;
		String var4 = var0 / 60L + ":" + (var2 < 10L?"0":"") + var2;
		return var4;
	}
}
