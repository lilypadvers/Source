package net.minecraft.src;

public class Entity extends ln {
	private boolean a;

	protected Entity(int var1, int var2, EntitySkeleton var3, boolean var4) {
		super(var1, var2, var3);
		this.a = var4;
	}

	public boolean b() {
		return false;
	}

	public boolean c(mz var1, int var2, int var3, int var4, int var5) {
		int var6 = var1.a(var2, var3, var4);
		return !this.a && var6 == this.ba?false:super.c(var1, var2, var3, var4, var5);
	}
}
