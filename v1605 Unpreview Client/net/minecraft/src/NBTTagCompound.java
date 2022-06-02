package net.minecraft.src;

public abstract class NBTTagCompound extends ModelSheepFur {
	public NBTTagCompound(EntitySpider var1) {
		super(var1);
	}

	protected float a(int var1, int var2, int var3) {
		return this.ad.a(var1, var2 - 1, var3) == ln.u.ba?10.0F:this.ad.c(var1, var2, var3) - 0.5F;
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	public boolean a() {
		int var1 = ModelPig.b(this.ah);
		int var2 = ModelPig.b(this.ar.b);
		int var3 = ModelPig.b(this.aj);
		return this.ad.a(var1, var2 - 1, var3) == ln.u.ba && this.ad.j(var1, var2, var3) > 8 && super.a();
	}

	public int b() {
		return 120;
	}
}
