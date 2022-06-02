package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class EntityCreature {
	private static Map a = new HashMap();
	private static Map b = new HashMap();
	public EntitySpider e;
	public int f;
	public int g;
	public int h;

	private static void a(Class var0, String var1) {
		if(b.containsKey(var1)) {
			throw new IllegalArgumentException("Duplicate id: " + var1);
		} else {
			a.put(var1, var0);
			b.put(var0, var1);
		}
	}

	public void a(EntityItem var1) {
		this.f = var1.e("x");
		this.g = var1.e("y");
		this.h = var1.e("z");
	}

	public void b(EntityItem var1) {
		String var2 = (String)b.get(this.getClass());
		if(var2 == null) {
			throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
		} else {
			var1.a("id", var2);
			var1.a("x", this.f);
			var1.a("y", this.g);
			var1.a("z", this.h);
		}
	}

	public void k_() {
	}

	public static EntityCreature c(EntityItem var0) {
		EntityCreature var1 = null;

		try {
			Class var2 = (Class)a.get(var0.i("id"));
			if(var2 != null) {
				var1 = (EntityCreature)var2.newInstance();
			}
		} catch (Exception var3) {
			var3.printStackTrace();
		}

		if(var1 != null) {
			var1.a(var0);
		} else {
			System.out.println("Skipping TileEntity with id " + var0.i("id"));
		}

		return var1;
	}

	public int e() {
		return this.e.e(this.f, this.g, this.h);
	}

	public void d() {
		this.e.n(this.f, this.g, this.h);
	}

	public double a(double var1, double var3, double var5) {
		double var7 = (double)this.f + 0.5D - var1;
		double var9 = (double)this.g + 0.5D - var3;
		double var11 = (double)this.h + 0.5D - var5;
		return var7 * var7 + var9 * var9 + var11 * var11;
	}

	public ln f() {
		return ln.n[this.e.a(this.f, this.g, this.h)];
	}

	static {
		a(Path.class, "Furnace");
		a(Frustrum.class, "Chest");
		a(nn.class, "Sign");
		a(PlayerControllerSP.class, "MobSpawner");
	}
}
