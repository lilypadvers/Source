package net.minecraft.src;

public class ClippingHelperImplementation extends Vec3D {
	private static ln[] aV = new ln[]{ln.w, ln.aj, ln.ak, ln.t, ln.ao, ln.H, ln.ai, ln.I, ln.ah, ln.G, ln.aw, ln.ax, ln.aT};
	private int aW;

	public ClippingHelperImplementation(int var1, int var2) {
		super(var1, 2, var2, aV);
		this.aW = var2;
	}

	public boolean a(ln var1) {
		return var1 == ln.ap?this.aW == 3:(var1 != ln.ax && var1 != ln.aw?(var1 != ln.ah && var1 != ln.G?(var1 != ln.ai && var1 != ln.H?(var1 != ln.aN && var1 != ln.aO?(var1.bl == EntitySkeleton.d?true:var1.bl == EntitySkeleton.e):this.aW >= 2):this.aW >= 1):this.aW >= 2):this.aW >= 2);
	}
}
