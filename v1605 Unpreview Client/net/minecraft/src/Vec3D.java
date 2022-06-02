package net.minecraft.src;

public class Vec3D extends EntityTNTPrimed {
	private ln[] aV;
	private float aW = 4.0F;
	private int aX;
	protected int a;

	public Vec3D(int var1, int var2, int var3, ln[] var4) {
		super(var1);
		this.a = var3;
		this.aV = var4;
		this.aR = 1;
		this.aS = 32 << var3;
		if(var3 == 3) {
			this.aS *= 4;
		}

		this.aW = (float)((var3 + 1) * 2);
		this.aX = var2 + var3;
	}

	public float a(TileEntityFurnace var1, ln var2) {
		for(int var3 = 0; var3 < this.aV.length; ++var3) {
			if(this.aV[var3] == var2) {
				return this.aW;
			}
		}

		return 1.0F;
	}

	public void a(TileEntityFurnace var1, RecipesIngots var2) {
		var1.b(2);
	}

	public void a(TileEntityFurnace var1, int var2, int var3, int var4, int var5) {
		var1.b(1);
	}

	public int a(EntityMinecart var1) {
		return this.aX;
	}

	public boolean a() {
		return true;
	}
}
