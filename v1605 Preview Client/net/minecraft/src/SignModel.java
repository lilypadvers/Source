package net.minecraft.src;

public class SignModel {
	private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
	private Object[][] b = new Object[][]{{ln.x, ln.w, EntityTNTPrimed.m, EntityTNTPrimed.l, EntityTNTPrimed.n}, {EntityTNTPrimed.r, EntityTNTPrimed.v, EntityTNTPrimed.e, EntityTNTPrimed.z, EntityTNTPrimed.G}, {EntityTNTPrimed.q, EntityTNTPrimed.u, EntityTNTPrimed.d, EntityTNTPrimed.y, EntityTNTPrimed.F}, {EntityTNTPrimed.s, EntityTNTPrimed.w, EntityTNTPrimed.f, EntityTNTPrimed.A, EntityTNTPrimed.H}, {EntityTNTPrimed.L, EntityTNTPrimed.M, EntityTNTPrimed.N, EntityTNTPrimed.O, EntityTNTPrimed.P}};

	public void a(ItemMinecart var1) {
		for(int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
				EntityTNTPrimed var5 = (EntityTNTPrimed)this.b[var4 + 1][var2];
				var1.a(new TileEntityFurnace(var5), new Object[]{this.a[var4], Character.valueOf('#'), EntityTNTPrimed.B, Character.valueOf('X'), var3});
			}
		}

	}
}
