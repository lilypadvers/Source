package net.minecraft.src;

public final class TileEntityFurnace {
	public int a;
	public int b;
	public int c;
	public int d;

	public TileEntityFurnace(ln var1) {
		this((ln)var1, 1);
	}

	public TileEntityFurnace(ln var1, int var2) {
		this(var1.ba, var2);
	}

	public TileEntityFurnace(EntityTNTPrimed var1) {
		this((EntityTNTPrimed)var1, 1);
	}

	public TileEntityFurnace(EntityTNTPrimed var1, int var2) {
		this(var1.aQ, var2);
	}

	public TileEntityFurnace(int var1) {
		this(var1, 1);
	}

	public TileEntityFurnace(int var1, int var2) {
		this.a = 0;
		this.c = var1;
		this.a = var2;
	}

	public TileEntityFurnace(int var1, int var2, int var3) {
		this.a = 0;
		this.c = var1;
		this.a = var2;
		this.d = var3;
	}

	public TileEntityFurnace(EntityItem var1) {
		this.a = 0;
		this.b(var1);
	}

	public TileEntityFurnace a(int var1) {
		this.a -= var1;
		return new TileEntityFurnace(this.c, var1, this.d);
	}

	public EntityTNTPrimed a() {
		return EntityTNTPrimed.c[this.c];
	}

	public int b() {
		return this.a().a(this);
	}

	public boolean a(BlockMobSpawner var1, EntitySpider var2, int var3, int var4, int var5, int var6) {
		return this.a().a(this, var1, var2, var3, var4, var5, var6);
	}

	public float a(ln var1) {
		return this.a().a(this, var1);
	}

	public TileEntityFurnace a(EntitySpider var1, BlockMobSpawner var2) {
		return this.a().a(this, var1, var2);
	}

	public EntityItem a(EntityItem var1) {
		var1.a("id", (short)this.c);
		var1.a("Count", (byte)this.a);
		var1.a("Damage", (short)this.d);
		return var1;
	}

	public void b(EntityItem var1) {
		this.c = var1.d("id");
		this.a = var1.c("Count");
		this.d = var1.d("Damage");
	}

	public int c() {
		return this.a().b();
	}

	public int d() {
		return EntityTNTPrimed.c[this.c].c();
	}

	public void b(int var1) {
		this.d += var1;
		if(this.d > this.d()) {
			--this.a;
			if(this.a < 0) {
				this.a = 0;
			}

			this.d = 0;
		}

	}

	public void a(RecipesIngots var1) {
		EntityTNTPrimed.c[this.c].a(this, var1);
	}

	public void a(int var1, int var2, int var3, int var4) {
		EntityTNTPrimed.c[this.c].a(this, var1, var2, var3, var4);
	}

	public int a(EntityMinecart var1) {
		return EntityTNTPrimed.c[this.c].a(var1);
	}

	public boolean b(ln var1) {
		return EntityTNTPrimed.c[this.c].a(var1);
	}

	public void a(BlockMobSpawner var1) {
	}

	public void b(RecipesIngots var1) {
		EntityTNTPrimed.c[this.c].b(this, var1);
	}
}
