package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelRenderer extends nd {
	private EntityMinecart a;
	private EntityMinecart o;
	private int p = 0;
	private int q = 0;
	private float r;

	public ModelRenderer(EntitySpider var1, EntityMinecart var2, EntityMinecart var3, float var4) {
		super(var1, var2.ah, var2.ai, var2.aj, var2.ak, var2.al, var2.am);
		this.a = var2;
		this.o = var3;
		this.q = 3;
		this.r = var4;
	}

	public void a(NBTTagByteArray var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = ((float)this.p + var2) / (float)this.q;
		var8 *= var8;
		double var9 = this.a.ah;
		double var11 = this.a.ai;
		double var13 = this.a.aj;
		double var15 = this.o.aF + (this.o.ah - this.o.aF) * (double)var2;
		double var17 = this.o.aG + (this.o.ai - this.o.aG) * (double)var2 + (double)this.r;
		double var19 = this.o.aH + (this.o.aj - this.o.aH) * (double)var2;
		double var21 = var9 + (var15 - var9) * (double)var8;
		double var23 = var11 + (var17 - var11) * (double)var8;
		double var25 = var13 + (var19 - var13) * (double)var8;
		int var27 = ModelPig.b(var21);
		int var28 = ModelPig.b(var23 + (double)(this.ay / 2.0F));
		int var29 = ModelPig.b(var25);
		float var30 = this.ad.c(var27, var28, var29);
		var21 -= l;
		var23 -= m;
		var25 -= n;
		GL11.glColor4f(var30, var30, var30, 1.0F);
		RenderSpider.a.a(this.a, (double)((float)var21), (double)((float)var23), (double)((float)var25), this.a.an, var2);
	}

	public void e_() {
		++this.p;
		if(this.p == this.q) {
			this.D();
		}

	}

	public int c() {
		return 3;
	}
}
