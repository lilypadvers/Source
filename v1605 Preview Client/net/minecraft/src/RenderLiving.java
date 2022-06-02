package net.minecraft.src;

final class RenderLiving {
	public final int a;
	public final int b;

	public RenderLiving(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public boolean equals(Object var1) {
		if(!(var1 instanceof RenderLiving)) {
			return false;
		} else {
			RenderLiving var2 = (RenderLiving)var1;
			return this.a == var2.a && this.b == var2.b;
		}
	}

	public int hashCode() {
		return this.a << 16 ^ this.b;
	}
}
