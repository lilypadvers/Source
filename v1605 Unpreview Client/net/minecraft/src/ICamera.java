package net.minecraft.src;

public class ICamera implements nq {
	private EnumOS a = ModelSheep.a();
	private double b;
	private double c;
	private double d;

	public void setPosition(double var1, double var3, double var5) {
		this.b = var1;
		this.c = var3;
		this.d = var5;
	}

	public boolean a(double var1, double var3, double var5, double var7, double var9, double var11) {
		return this.a.a(var1 - this.b, var3 - this.c, var5 - this.d, var7 - this.b, var9 - this.c, var11 - this.d);
	}

	public boolean a(EntityRenderer var1) {
		return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f);
	}
}
