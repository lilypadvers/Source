package net.minecraft.src;

import java.util.Random;

public class NBTTagShort extends ln {
	public NBTTagShort(int var1, int var2) {
		super(var1, var2, EntitySkeleton.d);
	}

	public int a(int var1, Random var2) {
		return this.ba == ln.I.ba?EntityTNTPrimed.k.aQ:(this.ba == ln.aw.ba?EntityTNTPrimed.l.aQ:this.ba);
	}

	public int a(Random var1) {
		return 1;
	}
}
