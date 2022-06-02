package net.minecraft.src;

public class GuiFurnace {
	private final RenderEntity[] b;
	public final int a;
	private int c;

	public GuiFurnace(RenderEntity[] var1) {
		this.b = var1;
		this.a = var1.length;
	}

	public void a() {
		++this.c;
	}

	public boolean b() {
		return this.c >= this.b.length;
	}

	public BlockTNT a(EntityMinecart var1) {
		double var2 = (double)this.b[this.c].a + (double)((int)(var1.az + 1.0F)) * 0.5D;
		double var4 = (double)this.b[this.c].b;
		double var6 = (double)this.b[this.c].c + (double)((int)(var1.az + 1.0F)) * 0.5D;
		return BlockTNT.b(var2, var4, var6);
	}
}
