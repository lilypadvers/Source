package net.minecraft.src;

public class ThreadSleepForever extends EntityTNTPrimed {
	public ThreadSleepForever(int var1) {
		super(var1);
		this.aR = 1;
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		if(var3.b.c(EntityTNTPrimed.j.aQ)) {
			var2.a(var3, "random.bow", 1.0F, 1.0F / (b.nextFloat() * 0.4F + 0.8F));
			var2.a((EntityMinecart)(new NBTTagEnd(var2, var3)));
		}

		return var1;
	}
}
