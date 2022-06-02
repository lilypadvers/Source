package net.minecraft.src;

public class BlockPressurePlate {
	private int b;
	private int c;
	private int[] d;
	private TileEntityFurnace e;
	public final int a;

	public BlockPressurePlate(int var1, int var2, int[] var3, TileEntityFurnace var4) {
		this.a = var4.c;
		this.b = var1;
		this.c = var2;
		this.d = var3;
		this.e = var4;
	}

	public boolean a(int[] var1) {
		for(int var2 = 0; var2 <= 3 - this.b; ++var2) {
			for(int var3 = 0; var3 <= 3 - this.c; ++var3) {
				if(this.a(var1, var2, var3, true)) {
					return true;
				}

				if(this.a(var1, var2, var3, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean a(int[] var1, int var2, int var3, boolean var4) {
		for(int var5 = 0; var5 < 3; ++var5) {
			for(int var6 = 0; var6 < 3; ++var6) {
				int var7 = var5 - var2;
				int var8 = var6 - var3;
				int var9 = -1;
				if(var7 >= 0 && var8 >= 0 && var7 < this.b && var8 < this.c) {
					if(var4) {
						var9 = this.d[this.b - var7 - 1 + var8 * this.b];
					} else {
						var9 = this.d[var7 + var8 * this.b];
					}
				}

				if(var1[var5 + var6 * 3] != var9) {
					return false;
				}
			}
		}

		return true;
	}

	public TileEntityFurnace b(int[] var1) {
		return new TileEntityFurnace(this.e.c, this.e.a);
	}

	public int a() {
		return this.b * this.c;
	}
}
