package net.minecraft.src;

public class Frustrum extends EntityCreature implements WorldIso {
	private TileEntityFurnace[] a = new TileEntityFurnace[36];

	public int a() {
		return 27;
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
			int var5 = var4.c("Slot") & 255;
			if(var5 >= 0 && var5 < this.a.length) {
				this.a[var5] = new TileEntityFurnace(var4);
			}
		}

	}

	public void b(EntityItem var1) {
		super.b(var1);
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
}
