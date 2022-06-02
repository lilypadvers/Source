package net.minecraft.src;

public class EntityDiggingFX extends RenderMinecart {
	public TileEntitySpecialRenderer a;
	public TileEntitySpecialRenderer b;
	public TileEntitySpecialRenderer c;
	public TileEntitySpecialRenderer d;
	public TileEntitySpecialRenderer e;
	public TileEntitySpecialRenderer f;
	public TileEntitySpecialRenderer g;
	public boolean h;
	public boolean i;

	public EntityDiggingFX() {
		this(0.0F);
	}

	public EntityDiggingFX(float var1) {
		this(var1, 0.0F);
	}

	public EntityDiggingFX(float var1, float var2) {
		this.h = false;
		this.i = false;
		this.a = new TileEntitySpecialRenderer(0, 0);
		this.a.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
		this.a.a(0.0F, 0.0F + var2, 0.0F);
		this.b = new TileEntitySpecialRenderer(32, 0);
		this.b.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
		this.b.a(0.0F, 0.0F + var2, 0.0F);
		this.c = new TileEntitySpecialRenderer(16, 16);
		this.c.a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
		this.c.a(0.0F, 0.0F + var2, 0.0F);
		this.d = new TileEntitySpecialRenderer(40, 16);
		this.d.a(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1);
		this.d.a(-5.0F, 2.0F + var2, 0.0F);
		this.e = new TileEntitySpecialRenderer(40, 16);
		this.e.g = true;
		this.e.a(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
		this.e.a(5.0F, 2.0F + var2, 0.0F);
		this.f = new TileEntitySpecialRenderer(0, 16);
		this.f.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
		this.f.a(-2.0F, 12.0F + var2, 0.0F);
		this.g = new TileEntitySpecialRenderer(0, 16);
		this.g.g = true;
		this.g.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
		this.g.a(2.0F, 12.0F + var2, 0.0F);
	}

	public void b(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.setBlockBounds(var1, var2, var3, var4, var5, var6);
		this.a.a(var6);
		this.c.a(var6);
		this.d.a(var6);
		this.e.a(var6);
		this.f.a(var6);
		this.g.a(var6);
		this.b.a(var6);
	}

	public void setBlockBounds(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.a.e = var4 / 57.295776F;
		this.a.d = var5 / 57.295776F;
		this.b.e = this.a.e;
		this.b.d = this.a.d;
		this.d.d = ModelPig.b(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
		this.e.d = ModelPig.b(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
		this.d.f = 0.0F;
		this.e.f = 0.0F;
		this.f.d = ModelPig.b(var1 * 0.6662F) * 1.4F * var2;
		this.g.d = ModelPig.b(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
		this.f.e = 0.0F;
		this.g.e = 0.0F;
		if(this.k) {
			this.d.d += -0.62831855F;
			this.e.d += -0.62831855F;
			this.f.d = -1.2566371F;
			this.g.d = -1.2566371F;
			this.f.e = 0.31415927F;
			this.g.e = -0.31415927F;
		}

		if(this.h) {
			this.e.d = this.e.d * 0.5F - 0.31415927F;
		}

		if(this.i) {
			this.d.d = this.d.d * 0.5F - 0.31415927F;
		}

		this.d.e = 0.0F;
		this.e.e = 0.0F;
		if(this.j > -9990.0F) {
			float var7 = this.j;
			this.c.e = ModelPig.a(ModelPig.c(var7) * (float)Math.PI * 2.0F) * 0.2F;
			this.d.c = ModelPig.a(this.c.e) * 5.0F;
			this.d.a = -ModelPig.b(this.c.e) * 5.0F;
			this.e.c = -ModelPig.a(this.c.e) * 5.0F;
			this.e.a = ModelPig.b(this.c.e) * 5.0F;
			this.d.e += this.c.e;
			this.e.e += this.c.e;
			this.e.d += this.c.e;
			var7 = 1.0F - this.j;
			var7 *= var7;
			var7 *= var7;
			var7 = 1.0F - var7;
			float var8 = ModelPig.a(var7 * (float)Math.PI);
			float var9 = ModelPig.a(this.j * (float)Math.PI) * -(this.a.d - 0.7F) * 0.75F;
			this.d.d = (float)((double)this.d.d - ((double)var8 * 1.2D + (double)var9));
			this.d.e += this.c.e * 2.0F;
			this.d.f = ModelPig.a(this.j * (float)Math.PI) * -0.4F;
		}

		this.d.f += ModelPig.b(var3 * 0.09F) * 0.05F + 0.05F;
		this.e.f -= ModelPig.b(var3 * 0.09F) * 0.05F + 0.05F;
		this.d.d += ModelPig.a(var3 * 0.067F) * 0.05F;
		this.e.d -= ModelPig.a(var3 * 0.067F) * 0.05F;
	}
}
