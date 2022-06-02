package net.minecraft.src;

public class MovingObjectPosition {
	protected final net.minecraft.client.Minecraft a;
	public boolean b = false;

	public MovingObjectPosition(net.minecraft.client.Minecraft var1) {
		this.a = var1;
	}

	public void calculateConnectedTracks() {
	}

	public void a(EntitySpider var1) {
	}

	public void a(int var1, int var2, int var3, int var4) {
		this.b(var1, var2, var3, var4);
	}

	public boolean b(int var1, int var2, int var3, int var4) {
		this.a.h.a(var1, var2, var3);
		EntitySpider var5 = this.a.e;
		ln var6 = ln.n[var5.a(var1, var2, var3)];
		int var7 = var5.e(var1, var2, var3);
		boolean var8 = var5.d(var1, var2, var3, 0);
		if(var6 != null && var8) {
			this.a.A.b(var6.bj.a(), (float)var1 + 0.5F, (float)var2 + 0.5F, (float)var3 + 0.5F, (var6.bj.b() + 1.0F) / 2.0F, var6.bj.c() * 0.8F);
			var6.b(var5, var1, var2, var3, var7);
		}

		return var8;
	}

	public void c(int var1, int var2, int var3, int var4) {
	}

	public void refreshConnectedTracks() {
	}

	public void a(float var1) {
	}

	public float c() {
		return 5.0F;
	}

	public void a(BlockMobSpawner var1) {
	}

	public void d() {
	}

	public boolean e() {
		return true;
	}

	public void b(BlockMobSpawner var1) {
	}

	public boolean a(BlockMobSpawner var1, EntitySpider var2, TileEntityFurnace var3, int var4, int var5, int var6, int var7) {
		return var3.a(var1, var2, var4, var5, var6, var7);
	}

	public BlockMobSpawner b(EntitySpider var1) {
		return new GuiDeleteWorld(this.a, var1, this.a.i);
	}
}
