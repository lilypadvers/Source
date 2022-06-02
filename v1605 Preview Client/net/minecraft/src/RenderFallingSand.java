package net.minecraft.src;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RenderFallingSand extends EntitySpider {
	private LinkedList w = new LinkedList();
	private MovementInput x;
	private lp y;
	private ChunkCache z = new ChunkCache();
	private Set A = new HashSet();
	private Set B = new HashSet();

	public RenderFallingSand(MovementInput var1) {
		super("MpServer");
		this.x = var1;
		this.n = 8;
		this.o = 64;
		this.p = 8;
	}

	public void g() {
		int var1;
		for(var1 = 0; var1 < 10 && !this.B.isEmpty(); ++var1) {
			EntityMinecart var2 = (EntityMinecart)this.B.iterator().next();
			this.a(var2);
		}

		this.x.resetKeyState();

		for(var1 = 0; var1 < this.w.size(); ++var1) {
			kr var3 = (kr)this.w.get(var1);
			if(--var3.d == 0) {
				super.a(var3.a, var3.b, var3.c, var3.e, var3.f);
				super.h(var3.a, var3.b, var3.c);
				this.w.remove(var1--);
			}
		}

	}

	public void c(int var1, int var2, int var3, int var4, int var5, int var6) {
		for(int var7 = 0; var7 < this.w.size(); ++var7) {
			kr var8 = (kr)this.w.get(var7);
			if(var8.a >= var1 && var8.b >= var2 && var8.c >= var3 && var8.a <= var4 && var8.b <= var5 && var8.c <= var6) {
				this.w.remove(var7--);
			}
		}

	}

	protected BlockButton a(File var1) {
		this.y = new lp(this);
		return this.y;
	}

	public void a() {
		this.n = 8;
		this.o = 64;
		this.p = 8;
	}

	protected void h() {
	}

	public void h(int var1, int var2, int var3, int var4) {
	}

	public boolean a(boolean var1) {
		return false;
	}

	public void a(int var1, int var2, boolean var3) {
		if(var3) {
			this.y.d(var1, var2);
		} else {
			this.y.c(var1, var2);
		}

		if(!var3) {
			this.b(var1 * 16, 0, var2 * 16, var1 * 16 + 15, 128, var2 * 16 + 15);
		}

	}

	public boolean a(EntityMinecart var1) {
		boolean var2 = super.a(var1);
		if(var1 instanceof GuiDeleteWorld) {
			this.A.add(var1);
		}

		return var2;
	}

	public void d(EntityMinecart var1) {
		super.d(var1);
		if(var1 instanceof GuiDeleteWorld) {
			this.A.remove(var1);
		}

	}

	protected void b(EntityMinecart var1) {
		super.b(var1);
		if(this.B.contains(var1)) {
			this.B.remove(var1);
		}

	}

	protected void c(EntityMinecart var1) {
		super.c(var1);
		if(this.A.contains(var1)) {
			this.B.add(var1);
		}

	}

	public void a(int var1, EntityMinecart var2) {
		this.A.add(var2);
		if(!this.a(var2)) {
			this.B.add(var2);
		}

		this.z.a(var1, var2);
	}

	public EntityMinecart b(int var1) {
		return (EntityMinecart)this.z.a(var1);
	}

	public EntityMinecart c(int var1) {
		EntityMinecart var2 = (EntityMinecart)this.z.b(var1);
		if(var2 != null) {
			this.A.remove(var2);
			this.d(var2);
		}

		return var2;
	}

	public boolean c(int var1, int var2, int var3, int var4) {
		int var5 = this.a(var1, var2, var3);
		int var6 = this.e(var1, var2, var3);
		if(super.c(var1, var2, var3, var4)) {
			this.w.add(new kr(this, var1, var2, var3, var5, var6));
			return true;
		} else {
			return false;
		}
	}

	public boolean a(int var1, int var2, int var3, int var4, int var5) {
		int var6 = this.a(var1, var2, var3);
		int var7 = this.e(var1, var2, var3);
		if(super.a(var1, var2, var3, var4, var5)) {
			this.w.add(new kr(this, var1, var2, var3, var6, var7));
			return true;
		} else {
			return false;
		}
	}

	public boolean a(int var1, int var2, int var3, int var4) {
		int var5 = this.a(var1, var2, var3);
		int var6 = this.e(var1, var2, var3);
		if(super.a(var1, var2, var3, var4)) {
			this.w.add(new kr(this, var1, var2, var3, var5, var6));
			return true;
		} else {
			return false;
		}
	}

	public boolean c(int var1, int var2, int var3, int var4, int var5) {
		this.c(var1, var2, var3, var1, var2, var3);
		if(super.a(var1, var2, var3, var4, var5)) {
			this.e(var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}

	public void k() {
		this.x.a((ItemAxe)(new nt("Quitting")));
	}
}
