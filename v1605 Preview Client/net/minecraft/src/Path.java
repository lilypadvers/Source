package net.minecraft.src;

public class Path extends EntityCreature implements WorldIso {
	private TileEntityFurnace[] a = new TileEntityFurnace[3];
	private int count = 0;
	private int c = 0;
	private int d = 0;

	public int a() {
		return this.a.length;
	}

	public TileEntityFurnace a_(int var1) {
		return this.a[var1];
	}

	public TileEntityFurnace a(int var1, int var2) {
		if(this.a[var1] != null) {
			TileEntityFurnace var3;
			if(this.a[var1].a <= var2) {
				var3 = this.a[var1];
				this.a[var1] = null;
				return var3;
			} else {
				var3 = this.a[var1].a(var2);
				if(this.a[var1].a == 0) {
					this.a[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, TileEntityFurnace var2) {
		this.a[var1] = var2;
		if(var2 != null && var2.a > this.c()) {
			var2.a = this.c();
		}

	}

	public String b() {
		return "Chest";
	}

	public void a(EntityItem var1) {
		super.a(var1);
		ItemPainting var2 = var1.l("Items");
		this.a = new TileEntityFurnace[this.a()];

		for(int var3 = 0; var3 < var2.c(); ++var3) {
			EntityItem var4 = (EntityItem)var2.a(var3);
			byte var5 = var4.c("Slot");
			if(var5 >= 0 && var5 < this.a.length) {
				this.a[var5] = new TileEntityFurnace(var4);
			}
		}

		this.count = var1.d("BurnTime");
		this.d = var1.d("CookTime");
		this.c = this.a(this.a[1]);
	}

	public void b(EntityItem var1) {
		super.b(var1);
		var1.a("BurnTime", (short)this.count);
		var1.a("CookTime", (short)this.d);
		ItemPainting var2 = new ItemPainting();

		for(int var3 = 0; var3 < this.a.length; ++var3) {
			if(this.a[var3] != null) {
				EntityItem var4 = new EntityItem();
				var4.a("Slot", (byte)var3);
				this.a[var3].a(var4);
				var2.a((EnumSkyBlock)var4);
			}
		}

		var1.a("Items", (EnumSkyBlock)var2);
	}

	public int c() {
		return 64;
	}

	public int b(int var1) {
		return this.d * var1 / 200;
	}

	public int c(int var1) {
		if(this.c == 0) {
			this.c = 200;
		}

		return this.count * var1 / this.c;
	}

	public boolean g() {
		return this.count > 0;
	}

	public void k_() {
		boolean var1 = this.count > 0;
		boolean var2 = false;
		if(this.count > 0) {
			--this.count;
			var2 = true;
		}

		if(this.count == 0 && this.i()) {
			this.c = this.count = this.a(this.a[1]);
			if(this.count > 0) {
				var2 = true;
				if(this.a[1] != null) {
					--this.a[1].a;
					if(this.a[1].a == 0) {
						this.a[1] = null;
					}
				}
			}
		}

		if(this.g() && this.i()) {
			++this.d;
			if(this.d == 200) {
				this.d = 0;
				this.h();
				var2 = true;
			}
		} else {
			this.d = 0;
		}

		if(var1 != this.count > 0) {
			var2 = true;
			MaterialTransparent.a(this.count > 0, this.e, this.f, this.g, this.h);
		}

		if(var2) {
			this.e.n(this.f, this.g, this.h);
		}

	}

	private boolean i() {
		if(this.a[0] == null) {
			return false;
		} else {
			int var1 = this.d(this.a[0].a().aQ);
			return var1 < 0?false:(this.a[2] == null?true:(this.a[2].c != var1?false:(this.a[2].a < this.c() && this.a[2].a < this.a[2].c()?true:this.a[2].a < EntityTNTPrimed.c[var1].b())));
		}
	}

	public void h() {
		if(this.i()) {
			int var1 = this.d(this.a[0].a().aQ);
			if(this.a[2] == null) {
				this.a[2] = new TileEntityFurnace(var1, 1);
			} else if(this.a[2].c == var1) {
				++this.a[2].a;
			}

			--this.a[0].a;
			if(this.a[0].a <= 0) {
				this.a[0] = null;
			}

		}
	}

	private int d(int var1) {
		return var1 == ln.H.ba?EntityTNTPrimed.m.aQ:(var1 == ln.G.ba?EntityTNTPrimed.n.aQ:(var1 == ln.aw.ba?EntityTNTPrimed.l.aQ:(var1 == ln.E.ba?ln.M.ba:(var1 == EntityTNTPrimed.ao.aQ?EntityTNTPrimed.ap.aQ:(var1 == ln.w.ba?ln.t.ba:(var1 == EntityTNTPrimed.aG.aQ?EntityTNTPrimed.aF.aQ:-1))))));
	}

	private int a(TileEntityFurnace var1) {
		if(var1 == null) {
			return 0;
		} else {
			int var2 = var1.a().aQ;
			return var2 < 256 && ln.n[var2].bl == EntitySkeleton.c?300:(var2 == EntityTNTPrimed.B.aQ?100:(var2 == EntityTNTPrimed.k.aQ?1600:0));
		}
	}

	public void d() {
		this.e.n(this.f, this.g, this.h);
	}
}
