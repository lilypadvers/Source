package net.minecraft.src;

import java.util.Comparator;

public class EntityCreeper implements Comparator<TileEntity> {
	private BlockMobSpawner a;

	public EntityCreeper(BlockMobSpawner var1) {
		this.a = var1;
	}

	public int compare(TileEntity var1, TileEntity var2) {
		boolean var3 = var1.o;
		boolean var4 = var2.o;
		return var3 && !var4?1:(var4 && !var3?-1:(var1.a((EntityMinecart)this.a) < var2.a((EntityMinecart)this.a)?1:-1));
	}
}
