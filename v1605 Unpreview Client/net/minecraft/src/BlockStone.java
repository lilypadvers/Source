package net.minecraft.src;

public class BlockStone implements WorldIso {
	public TileEntityFurnace[] a = new TileEntityFurnace[36];
	public TileEntityFurnace[] b = new TileEntityFurnace[4];
	public TileEntityFurnace[] c = new TileEntityFurnace[4];
	public int d = 0;
	private BlockMobSpawner e;

	public BlockStone(BlockMobSpawner var1) {
		this.e = var1;
	}

	public TileEntityFurnace e() {
		return this.a[this.d];
	}

	private int f(int var1) {
		for(int var2 = 0; var2 < this.a.length; ++var2) {
			if(this.a[var2] != null && this.a[var2].c == var1) {
				return var2;
			}
		}

		return -1;
	}

	private int g(int var1) {
		for(int var2 = 0; var2 < this.a.length; ++var2) {
			if(this.a[var2] != null && this.a[var2].c == var1 && this.a[var2].a < this.a[var2].c() && this.a[var2].a < this.c()) {
				return var2;
			}
		}

		return -1;
	}

	private int i() {
		for(int var1 = 0; var1 < this.a.length; ++var1) {
			if(this.a[var1] == null) {
				return var1;
			}
		}

		return -1;
	}

	public void a(int var1, boolean var2) {
		int var3 = this.f(var1);
		if(var3 >= 0 && var3 < 9) {
			this.d = var3;
		}
	}

	public void b(int var1) {
		if(var1 > 0) {
			var1 = 1;
		}

		if(var1 < 0) {
			var1 = -1;
		}

		for(this.d -= var1; this.d < 0; this.d += 9) {
		}

		while(this.d >= 9) {
			this.d -= 9;
		}

	}

	private int b(int var1, int var2) {
		int var3 = this.g(var1);
		if(var3 < 0) {
			var3 = this.i();
		}

		if(var3 < 0) {
			return var2;
		} else {
			if(this.a[var3] == null) {
				this.a[var3] = new TileEntityFurnace(var1, 0);
			}

			int var4 = var2;
			if(var2 > this.a[var3].c() - this.a[var3].a) {
				var4 = this.a[var3].c() - this.a[var3].a;
			}

			if(var4 > this.c() - this.a[var3].a) {
				var4 = this.c() - this.a[var3].a;
			}

			if(var4 == 0) {
				return var2;
			} else {
				var2 -= var4;
				this.a[var3].a += var4;
				this.a[var3].b = 5;
				return var2;
			}
		}
	}

	public void f() {
		for(int var1 = 0; var1 < this.a.length; ++var1) {
			if(this.a[var1] != null && this.a[var1].b > 0) {
				--this.a[var1].b;
			}
		}

	}

	public boolean c(int var1) {
		int var2 = this.f(var1);
		if(var2 < 0) {
			return false;
		} else {
			if(--this.a[var2].a <= 0) {
				this.a[var2] = null;
			}

			return true;
		}
	}

	public boolean a(TileEntityFurnace var1) {
		if(var1.d == 0) {
			var1.a = this.b(var1.c, var1.a);
			if(var1.a == 0) {
				return true;
			}
		}

		int var2 = this.i();
		if(var2 >= 0) {
			this.a[var2] = var1;
			this.a[var2].b = 5;
			return true;
		} else {
			return false;
		}
	}

	public TileEntityFurnace a(int var1, int var2) {
		TileEntityFurnace[] var3 = this.a;
		if(var1 >= this.a.length) {
			var3 = this.b;
			var1 -= this.a.length;
		}

		if(var3[var1] != null) {
			TileEntityFurnace var4;
			if(var3[var1].a <= var2) {
				var4 = var3[var1];
				var3[var1] = null;
				return var4;
			} else {
				var4 = var3[var1].a(var2);
				if(var3[var1].a == 0) {
					var3[var1] = null;
				}

				return var4;
			}
		} else {
			return null;
		}
	}

	public void a(int var1, TileEntityFurnace var2) {
		TileEntityFurnace[] var3 = this.a;
		if(var1 >= var3.length) {
			var1 -= var3.length;
			var3 = this.b;
		}

		if(var1 >= var3.length) {
			var1 -= var3.length;
			var3 = this.c;
		}

		var3[var1] = var2;
	}

	public float a(ln var1) {
		float var2 = 1.0F;
		if(this.a[this.d] != null) {
			var2 *= this.a[this.d].a(var1);
		}

		return var2;
	}

	public ItemPainting a(ItemPainting var1) {
		int var2;
		EntityItem var3;
		for(var2 = 0; var2 < this.a.length; ++var2) {
			if(this.a[var2] != null) {
				var3 = new EntityItem();
				var3.a("Slot", (byte)var2);
				this.a[var2].a(var3);
				var1.a((EnumSkyBlock)var3);
			}
		}

		for(var2 = 0; var2 < this.b.length; ++var2) {
			if(this.b[var2] != null) {
				var3 = new EntityItem();
				var3.a("Slot", (byte)(var2 + 100));
				this.b[var2].a(var3);
				var1.a((EnumSkyBlock)var3);
			}
		}

		for(var2 = 0; var2 < this.c.length; ++var2) {
			if(this.c[var2] != null) {
				var3 = new EntityItem();
				var3.a("Slot", (byte)(var2 + 80));
				this.c[var2].a(var3);
				var1.a((EnumSkyBlock)var3);
			}
		}

		return var1;
	}

	public void b(ItemPainting var1) {
		this.a = new TileEntityFurnace[36];
		this.b = new TileEntityFurnace[4];
		this.c = new TileEntityFurnace[4];

		for(int var2 = 0; var2 < var1.c(); ++var2) {
			EntityItem var3 = (EntityItem)var1.a(var2);
			int var4 = var3.c("Slot") & 255;
			if(var4 >= 0 && var4 < this.a.length) {
				this.a[var4] = new TileEntityFurnace(var3);
			}

			if(var4 >= 80 && var4 < this.c.length + 80) {
				this.c[var4 - 80] = new TileEntityFurnace(var3);
			}

			if(var4 >= 100 && var4 < this.b.length + 100) {
				this.b[var4 - 100] = new TileEntityFurnace(var3);
			}
		}

	}

	public int a() {
		return this.a.length + 4;
	}

	public TileEntityFurnace a_(int var1) {
		TileEntityFurnace[] var2 = this.a;
		if(var1 >= var2.length) {
			var1 -= var2.length;
			var2 = this.b;
		}

		if(var1 >= var2.length) {
			var1 -= var2.length;
			var2 = this.c;
		}

		return var2[var1];
	}

	public String b() {
		return "Inventory";
	}

	public int c() {
		return 64;
	}

	public int a(EntityMinecart var1) {
		TileEntityFurnace var2 = this.a_(this.d);
		return var2 != null?var2.a(var1):1;
	}

	public boolean b(ln var1) {
		if(var1.bl != EntitySkeleton.d && var1.bl != EntitySkeleton.e && var1.bl != EntitySkeleton.t && var1.bl != EntitySkeleton.s) {
			return true;
		} else {
			TileEntityFurnace var2 = this.a_(this.d);
			return var2 != null?var2.b(var1):false;
		}
	}

	public TileEntityFurnace d(int var1) {
		return this.b[var1];
	}

	public int g() {
		int var1 = 0;
		int var2 = 0;
		int var3 = 0;

		for(int var4 = 0; var4 < this.b.length; ++var4) {
			if(this.b[var4] != null && this.b[var4].a() instanceof mf) {
				int var5 = this.b[var4].d();
				int var6 = this.b[var4].d;
				int var7 = var5 - var6;
				var2 += var7;
				var3 += var5;
				int var8 = ((mf)this.b[var4].a()).aW;
				var1 += var8;
			}
		}

		if(var3 == 0) {
			return 0;
		} else {
			return (var1 - 1) * var2 / var3 + 1;
		}
	}

	public void e(int var1) {
		for(int var2 = 0; var2 < this.b.length; ++var2) {
			if(this.b[var2] != null && this.b[var2].a() instanceof mf) {
				this.b[var2].b(var1);
				if(this.b[var2].a == 0) {
					this.b[var2].a(this.e);
					this.b[var2] = null;
				}
			}
		}

	}

	public void h() {
		int var1;
		for(var1 = 0; var1 < this.a.length; ++var1) {
			if(this.a[var1] != null) {
				this.e.a(this.a[var1], true);
				this.a[var1] = null;
			}
		}

		for(var1 = 0; var1 < this.b.length; ++var1) {
			if(this.b[var1] != null) {
				this.e.a(this.b[var1], true);
				this.b[var1] = null;
			}
		}

	}

	public void d() {
	}
}
