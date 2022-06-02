package net.minecraft.src;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.lwjgl.opengl.GL11;

public class ThreadDownloadImage {
	private Map m = new HashMap();
	public static ThreadDownloadImage a = new ThreadDownloadImage();
	private BlockDoor n;
	public static double b;
	public static double c;
	public static double d;
	public BlockRedstoneWire e;
	public EntitySpider f;
	public BlockMobSpawner g;
	public float h;
	public float i;
	public double j;
	public double k;
	public double l;

	private ThreadDownloadImage() {
		this.m.put(nn.class, new ItemSpade());
		this.m.put(PlayerControllerSP.class, new NBTTagFloat());
		Iterator var1 = this.m.values().iterator();

		while(var1.hasNext()) {
			AxisAlignedBB var2 = (AxisAlignedBB)var1.next();
			var2.a(this);
		}

	}

	public AxisAlignedBB a(Class var1) {
		AxisAlignedBB var2 = (AxisAlignedBB)this.m.get(var1);
		if(var2 == null && var1 != EntityCreature.class) {
			var2 = this.a(var1.getSuperclass());
			this.m.put(var1, var2);
		}

		return var2;
	}

	public boolean a(EntityCreature var1) {
		return this.b(var1) != null;
	}

	public AxisAlignedBB b(EntityCreature var1) {
		return this.a(var1.getClass());
	}

	public void a(EntitySpider var1, BlockRedstoneWire var2, BlockDoor var3, BlockMobSpawner var4, float var5) {
		this.f = var1;
		this.e = var2;
		this.g = var4;
		this.n = var3;
		this.h = var4.ap + (var4.an - var4.ap) * var5;
		this.i = var4.aq + (var4.ao - var4.aq) * var5;
		this.j = var4.aF + (var4.ah - var4.aF) * (double)var5;
		this.k = var4.aG + (var4.ai - var4.aG) * (double)var5;
		this.l = var4.aH + (var4.aj - var4.aH) * (double)var5;
	}

	public void a(EntityCreature var1, float var2) {
		if(var1.a(this.j, this.k, this.l) < 4096.0D) {
			float var3 = this.f.c(var1.f, var1.g, var1.h);
			GL11.glColor3f(var3, var3, var3);
			this.a(var1, (double)var1.f - b, (double)var1.g - c, (double)var1.h - d, var2);
		}

	}

	public void a(EntityCreature var1, double var2, double var4, double var6, float var8) {
		AxisAlignedBB var9 = this.b(var1);
		if(var9 != null) {
			var9.a(var1, var2, var4, var6, var8);
		}

	}

	public BlockDoor a() {
		return this.n;
	}
}
