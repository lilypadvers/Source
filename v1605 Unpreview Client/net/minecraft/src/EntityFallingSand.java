package net.minecraft.src;

public class EntityFallingSand {
	private int fallTime;
	private int c;
	public int blockID;

	public EntityFallingSand(int var1, int var2) {
		this.fallTime = var1;
		this.c = var2;

		for(this.blockID = 1; this.fallTime / (this.blockID + 1) >= 320 && this.c / (this.blockID + 1) >= 240; ++this.blockID) {
		}

		this.fallTime /= this.blockID;
		this.c /= this.blockID;
	}

	public int a() {
		return this.fallTime;
	}

	public int b() {
		return this.c;
	}
}
