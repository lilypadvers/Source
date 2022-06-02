package net.minecraft.src;

public class ItemSpade {
	public final int a;
	public final int b;
	public final int c;

	public ItemSpade(int var1, int var2, int var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}

	public boolean equals(Object var1) {
		if(!(var1 instanceof ItemSpade)) {
			return false;
		} else {
			ItemSpade var2 = (ItemSpade)var1;
			return var2.a == this.a && var2.b == this.b && var2.c == this.c;
		}
	}

	public int hashCode() {
		return this.a * 8976890 + this.b * 981131 + this.c;
	}
}
