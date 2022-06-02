package net.minecraft.src;

class WorldGenTrees {
	public double a;
	public double b;
	public double c;
	final TileEntityMobSpawner d;

	public WorldGenTrees(TileEntityMobSpawner var1, int var2, int var3) {
		this.d = var1;
		double var4 = (double)(10 + var3) + TileEntityMobSpawner.h.nextDouble() * 32.0D + (double)var2;
		this.b = var4;
		this.a = var4;
	}

	public void a() {
		this.b = this.a;
		if(this.a > 0.0D) {
			this.c -= 0.6D;
		}

		this.a += this.c;
		this.c *= 0.9D;
		if(this.a < 0.0D) {
			this.a = 0.0D;
			this.c = 0.0D;
		}

	}
}
