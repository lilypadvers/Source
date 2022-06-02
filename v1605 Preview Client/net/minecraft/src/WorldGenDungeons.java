package net.minecraft.src;

import java.util.Comparator;

public class WorldGenDungeons implements Comparator<TileEntity> {
	private EntityMinecart a;

	public WorldGenDungeons(EntityMinecart var1) {
		this.a = var1;
	}

	public int compare(TileEntity var1, TileEntity var2) {
		return var1.a(this.a) < var2.a(this.a)?-1:1;
	}
}
