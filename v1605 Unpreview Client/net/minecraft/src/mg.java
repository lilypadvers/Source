package net.minecraft.src;

public class mg extends Vec3D {
	private static ln[] aV = new ln[]{ln.u, ln.v, ln.E, ln.F, ln.aS, ln.aU, ln.aW};

	public mg(int var1, int var2) {
		super(var1, 1, var2, aV);
	}

	public boolean a(ln var1) {
		return var1 == ln.aS?true:var1 == ln.aU;
	}
}
