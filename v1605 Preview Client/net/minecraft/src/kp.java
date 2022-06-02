package net.minecraft.src;

public class kp extends GuiDeleteWorld {
	private MovementInput bd;
	private double be;
	private double bf;
	private double bg;
	private double bh;
	private float bi;
	private float bj;

	public kp(net.minecraft.client.Minecraft var1, EntitySpider var2, EntityPlayerSP var3, MovementInput var4) {
		super(var1, var2, var3);
		this.bd = var4;
	}

	public void e_() {
		super.e_();
		this.H();
	}

	public void m() {
		this.H();
	}

	public void H() {
		double var1 = this.ah - this.be;
		double var3 = this.ar.b - this.bf;
		double var5 = this.ai - this.bg;
		double var7 = this.aj - this.bh;
		double var9 = (double)(this.an - this.bi);
		double var11 = (double)(this.ao - this.bj);
		boolean var13 = var3 != 0.0D || var5 != 0.0D || var1 != 0.0D || var7 != 0.0D;
		boolean var14 = var9 != 0.0D || var11 != 0.0D;
		if(var13 && var14) {
			this.bd.a((ItemAxe)(new Timer(this.ah, this.ar.b, this.ai, this.aj, this.an, this.ao, this.as)));
		} else if(var13) {
			this.bd.a((ItemAxe)(new MinecraftAppletImpl(this.ah, this.ar.b, this.ai, this.aj, this.as)));
		} else if(var14) {
			this.bd.a((ItemAxe)(new lx(this.an, this.ao, this.as)));
		} else {
			this.bd.a((ItemAxe)(new BlockContainer(this.as)));
		}

		if(var13) {
			this.be = this.ah;
			this.bf = this.ar.b;
			this.bg = this.ai;
			this.bh = this.aj;
		}

		if(var14) {
			this.bi = this.an;
			this.bj = this.ao;
		}

	}

	protected void a(EffectRenderer var1) {
		GuiIngame var2 = new GuiIngame(var1);
		this.bd.a((ItemAxe)var2);
		var1.ah = (double)var2.b / 32.0D;
		var1.ai = (double)var2.c / 32.0D;
		var1.aj = (double)var2.d / 32.0D;
		var1.ak = (double)var2.e / 128.0D;
		var1.al = (double)var2.f / 128.0D;
		var1.am = (double)var2.g / 128.0D;
	}

	public void a(String var1) {
		this.bd.a((ItemAxe)(new InventoryPlayer(var1)));
	}

	public void u() {
		super.u();
		this.bd.a((ItemAxe)(new Slot(this, 1)));
	}
}
