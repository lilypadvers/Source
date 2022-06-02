package net.minecraft.src;

public class ku {
	private Object[][] a = new Object[][]{{ln.ah, EntityTNTPrimed.n}, {ln.ai, EntityTNTPrimed.m}, {ln.ax, EntityTNTPrimed.l}};

	public void a(ItemMinecart var1) {
		for(int var2 = 0; var2 < this.a.length; ++var2) {
			ln var3 = (ln)this.a[var2][0];
			EntityTNTPrimed var4 = (EntityTNTPrimed)this.a[var2][1];
			var1.a(new TileEntityFurnace(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
			var1.a(new TileEntityFurnace(var4, 9), new Object[]{"#", Character.valueOf('#'), var3});
		}

	}
}
