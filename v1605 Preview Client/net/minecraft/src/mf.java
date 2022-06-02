package net.minecraft.src;

public class mf extends EntityTNTPrimed {
	private static final int[] aY = new int[]{3, 8, 6, 3};
	private static final int[] aZ = new int[]{11, 16, 15, 13};
	public final int a;
	public final int aV;
	public final int aW;
	public final int aX;

	public mf(int var1, int var2, int var3, int var4) {
		super(var1);
		this.a = var2;
		this.aV = var4;
		this.aX = var3;
		this.aW = aY[var4];
		this.aS = aZ[var4] * 3 << var2;
		this.aR = 1;
	}
}
