package net.minecraft.src;

public class EnumOSIsom extends EntityTNTPrimed {
	private int a;

	public EnumOSIsom(int var1, int var2) {
		super(var1);
		this.aR = 1;
		this.aS = 32 << var2;
		if(var2 == 3) {
			this.aS *= 4;
		}

		this.a = 4 + var2 * 2;
	}

	public float a(TileEntityFurnace var1, ln var2) {
		return 1.5F;
	}

	public void a(TileEntityFurnace var1, RecipesIngots var2) {
		var1.b(1);
	}

	public void a(TileEntityFurnace var1, int var2, int var3, int var4, int var5) {
		var1.b(2);
	}

	public int a(EntityMinecart var1) {
		return this.a;
	}

	public boolean a() {
		return true;
	}
}
