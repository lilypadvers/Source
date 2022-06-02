package net.minecraft.src;

import java.util.Random;

public class NBTTagList extends ln {
	protected NBTTagList(int var1, int var2) {
		super(var1, var2, EntitySkeleton.s);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
		this.b(true);
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return null;
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return var1.f(var2, var3 - 1, var4).c();
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		this.h(var1, var2, var3, var4);
	}

	private boolean h(EntitySpider var1, int var2, int var3, int var4) {
		if(!this.a(var1, var2, var3, var4)) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
			return false;
		} else {
			return true;
		}
	}

	public void a_(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = EntityTNTPrimed.aB.aQ;
		float var7 = 0.7F;
		double var8 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		double var10 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		double var12 = (double)(var1.m.nextFloat() * var7) + (double)(1.0F - var7) * 0.5D;
		EffectRenderer var14 = new EffectRenderer(var1, (double)var2 + var8, (double)var3 + var10, (double)var4 + var12, new TileEntityFurnace(var6));
		var14.c = 10;
		var1.a((EntityMinecart)var14);
		var1.d(var2, var3, var4, 0);
	}

	public int a(int var1, Random var2) {
		return EntityTNTPrimed.aB.aQ;
	}

	public int a(Random var1) {
		return 0;
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.a(PlayerControllerCreative.b, var2, var3, var4) > 11) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}

	public boolean c(mz var1, int var2, int var3, int var4, int var5) {
		EntitySkeleton var6 = var1.f(var2, var3, var4);
		return var5 == 1?true:(var6 == this.bl?false:super.c(var1, var2, var3, var4, var5));
	}
}
