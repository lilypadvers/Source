package net.minecraft.src;

public class kn extends me {
	protected kn(int var1, int var2) {
		super(var1, var2);
		float var3 = 0.2F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
	}

	protected boolean b(int var1) {
		return ln.p[var1];
	}

	public boolean g(EntitySpider var1, int var2, int var3, int var4) {
		return var1.j(var2, var3, var4) <= 13 && this.b(var1.a(var2, var3 - 1, var4));
	}
}
