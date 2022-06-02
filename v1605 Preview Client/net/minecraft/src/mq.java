package net.minecraft.src;

public class mq {
	private String[][] a = new String[][]{{"X", "X", "#"}};
	private Object[][] b = new Object[][]{{ln.x, ln.w, EntityTNTPrimed.m, EntityTNTPrimed.l, EntityTNTPrimed.n}, {EntityTNTPrimed.p, EntityTNTPrimed.t, EntityTNTPrimed.o, EntityTNTPrimed.x, EntityTNTPrimed.E}};

	public void a(ItemMinecart var1) {
		for(int var2 = 0; var2 < this.b[0].length; ++var2) {
			Object var3 = this.b[0][var2];

			for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
				EntityTNTPrimed var5 = (EntityTNTPrimed)this.b[var4 + 1][var2];
				var1.a(new TileEntityFurnace(var5), new Object[]{this.a[var4], Character.valueOf('#'), EntityTNTPrimed.B, Character.valueOf('X'), var3});
			}
		}

		var1.a(new TileEntityFurnace(EntityTNTPrimed.i, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), EntityTNTPrimed.I, Character.valueOf('#'), EntityTNTPrimed.B});
		var1.a(new TileEntityFurnace(EntityTNTPrimed.j, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), EntityTNTPrimed.J, Character.valueOf('X'), EntityTNTPrimed.an, Character.valueOf('#'), EntityTNTPrimed.B});
	}
}
