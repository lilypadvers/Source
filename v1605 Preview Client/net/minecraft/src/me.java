package net.minecraft.src;

import java.util.Random;

public class me extends ln {
	protected me(int var1, int var2) {
		super(var1, EntitySkeleton.i);
		this.aZ = var2;
		this.b(true);
		float var3 = 0.2F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return this.b(var1.a(var2, var3 - 1, var4));
	}

	protected boolean b(int var1) {
		return var1 == ln.u.ba || var1 == ln.v.ba || var1 == ln.aA.ba;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		this.h(var1, var2, var3, var4);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		this.h(var1, var2, var3, var4);
	}

	protected final void h(EntitySpider var1, int var2, int var3, int var4) {
		if(!this.g(var1, var2, var3, var4)) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}

	public boolean g(EntitySpider var1, int var2, int var3, int var4) {
		return (var1.j(var2, var3, var4) >= 8 || var1.i(var2, var3, var4)) && this.b(var1.a(var2, var3 - 1, var4));
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return null;
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int f() {
		return 1;
	}
}
