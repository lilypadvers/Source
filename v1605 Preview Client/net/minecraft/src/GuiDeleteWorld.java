package net.minecraft.src;

public class GuiDeleteWorld extends BlockMobSpawner {
	public li a;
	private net.minecraft.client.Minecraft bd;

	public GuiDeleteWorld(net.minecraft.client.Minecraft var1, EntitySpider var2, EntityPlayerSP var3) {
		super(var2);
		this.bd = var1;
		if(var3 != null && var3.b != null && var3.b.length() > 0) {
			this.aV = "file:///C:/skincache/" + var3.b + ".png";
			System.out.println("Loading texture " + this.aV);
		}

		this.i = var3.b;
	}

	public void b_() {
		super.b_();
		this.T = this.a.a;
		this.U = this.a.b;
		this.W = this.a.d;
	}

	public void i() {
		this.a.a(this);
		super.i();
	}

	public void j() {
		this.a.a();
	}

	public void a(int var1, boolean var2) {
		this.a.a(var1, var2);
	}

	public void a(EntityItem var1) {
		super.a(var1);
		var1.a("Score", this.d);
		var1.a("Inventory", (EnumSkyBlock)this.b.a(new ItemPainting()));
	}

	public void b(EntityItem var1) {
		super.b(var1);
		this.d = var1.e("Score");
		ItemPainting var2 = var1.l("Inventory");
		this.b.b(var2);
	}

	public void a(WorldIso var1) {
		this.bd.a((CanvasIsomPreview)(new ItemTool(this.b, var1)));
	}

	public void a(nn var1) {
		this.bd.a((CanvasIsomPreview)(new ni(var1)));
	}

	public void k() {
		this.bd.a((CanvasIsomPreview)(new PositionTexureVertex(this.b)));
	}

	public void a(Path var1) {
		this.bd.a((CanvasIsomPreview)(new NBTBase(this.b, var1)));
	}

	public void a(EntityMinecart var1) {
		int var2 = this.b.a(var1);
		if(var2 > 0) {
			var1.a(this, var2);
			TileEntityFurnace var3 = this.r();
			if(var3 != null && var1 instanceof RecipesIngots) {
				var3.a((RecipesIngots)var1);
				if(var3.a <= 0) {
					var3.a((BlockMobSpawner)this);
					this.s();
				}
			}
		}

	}

	public void a_(EntityMinecart var1, int var2) {
		this.bd.h.a((nd)(new ModelRenderer(this.bd.e, var1, this, -0.5F)));
	}

	public int l() {
		return this.b.g();
	}

	public void a_(EntityMinecart var1) {
		if(!var1.a((BlockMobSpawner)this)) {
			TileEntityFurnace var2 = this.r();
			if(var2 != null && var1 instanceof RecipesIngots) {
				var2.b((RecipesIngots)var1);
				if(var2.a <= 0) {
					var2.a((BlockMobSpawner)this);
					this.s();
				}
			}

		}
	}

	public void a(String var1) {
	}

	public void m() {
	}
}
