package net.minecraft.src;

public class RenderGlobal {
	private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
	private Object[][] b = new Object[][]{{EntityTNTPrimed.aD, ln.ar, EntityTNTPrimed.m, EntityTNTPrimed.l, EntityTNTPrimed.n}, {EntityTNTPrimed.T, EntityTNTPrimed.X, EntityTNTPrimed.ab, EntityTNTPrimed.af, EntityTNTPrimed.aj}, {EntityTNTPrimed.U, EntityTNTPrimed.Y, EntityTNTPrimed.ac, EntityTNTPrimed.ag, EntityTNTPrimed.ak}, {EntityTNTPrimed.V, EntityTNTPrimed.Z, EntityTNTPrimed.ad, EntityTNTPrimed.ah, EntityTNTPrimed.al}, {EntityTNTPrimed.W, EntityTNTPrimed.aa, EntityTNTPrimed.ae, EntityTNTPrimed.ai, EntityTNTPrimed.am}};

	public void a(ItemMinecart var1) {
		for(int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
				EntityTNTPrimed var5 = (EntityTNTPrimed)this.b[var4 + 1][var2];
				var1.a(new TileEntityFurnace(var5), new Object[]{this.a[var4], Character.valueOf('X'), var3});
			}
		}

	}
}
