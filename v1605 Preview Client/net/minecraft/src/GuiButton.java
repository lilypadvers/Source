package net.minecraft.src;

public class GuiButton implements Comparable {
	private static long f = 0L;
	public int xPosition;
	public int yPosition;
	public int c;
	public int id;
	public long e;
	private long g = f++;

	public GuiButton(int var1, int var2, int var3, int var4) {
		this.xPosition = var1;
		this.yPosition = var2;
		this.c = var3;
		this.id = var4;
	}

	public boolean equals(Object var1) {
		if(!(var1 instanceof GuiButton)) {
			return false;
		} else {
			GuiButton var2 = (GuiButton)var1;
			return this.xPosition == var2.xPosition && this.yPosition == var2.yPosition && this.c == var2.c && this.id == var2.id;
		}
	}

	public int hashCode() {
		return (this.xPosition * 128 * 1024 + this.c * 128 + this.yPosition) * 256 + this.id;
	}

	public GuiButton a(long var1) {
		this.e = var1;
		return this;
	}

	public int a(GuiButton var1) {
		return this.e < var1.e?-1:(this.e > var1.e?1:(this.g < var1.g?-1:(this.g > var1.g?1:0)));
	}

	public int compareTo(Object var1) {
		return this.a((GuiButton)var1);
	}
}
