package net.minecraft.src;

public class BlockFlower extends Item {
	private static final int[] aZ = new int[]{3, 8, 6, 3};
	private static final int[] ba = new int[]{11, 16, 15, 13};
	public final int a;
	public final int aW;
	public final int aX;
	public final int aY;

	public BlockFlower(int var1, int var2, int var3, int var4) {
		super(var1);
		this.a = var2;
		this.aW = var4;
		this.aY = var3;
		this.aX = aZ[var4];
		this.maxStackSize = ba[var4] * 3 << var2;
		this.shiftedIndex = 1;
	}
}
