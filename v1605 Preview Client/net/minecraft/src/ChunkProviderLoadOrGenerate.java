package net.minecraft.src;

public abstract class ChunkProviderLoadOrGenerate extends ln {
	protected ChunkProviderLoadOrGenerate(int var1, EntitySkeleton var2) {
		super(var1, var2);
	}

	protected ChunkProviderLoadOrGenerate(int var1, int var2, EntitySkeleton var3) {
		super(var1, var2, var3);
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		super.e(var1, var2, var3, var4);
		var1.a(var2, var3, var4, this.a_());
	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
		super.b(var1, var2, var3, var4);
		var1.l(var2, var3, var4);
	}

	protected abstract EntityCreature a_();
}
