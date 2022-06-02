package net.minecraft.src;

public class lv {
	public int a;
	public int b;
	public int c;
	public int d;
	public int e;
	public BlockTNT f;
	public EntityMinecart g;

	public lv(int var1, int var2, int var3, int var4, BlockTNT var5) {
		this.a = 0;
		this.b = var1;
		this.c = var2;
		this.d = var3;
		this.e = var4;
		this.f = BlockTNT.b(var5.a, var5.b, var5.c);
	}

	public lv(EntityMinecart var1) {
		this.a = 1;
		this.g = var1;
		this.f = BlockTNT.b(var1.ah, var1.ai, var1.aj);
	}
}
