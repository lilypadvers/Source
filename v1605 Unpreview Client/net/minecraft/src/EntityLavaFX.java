package net.minecraft.src;

import java.util.Comparator;

class EntityLavaFX implements Comparator<BlockPressurePlate> {
	final ItemMinecart a;

	EntityLavaFX(ItemMinecart var1) {
		this.a = var1;
	}

	public int compare(BlockPressurePlate var1, BlockPressurePlate var2) {
		return var2.a() < var1.a()?-1:(var2.a() > var1.a()?1:0);
	}
}
