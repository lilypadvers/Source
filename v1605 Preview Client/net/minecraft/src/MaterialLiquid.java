package net.minecraft.src;

public class MaterialLiquid extends ItemBow {
	public MaterialLiquid(RenderMinecart var1, float var2) {
		super(var1, var2);
	}

	public void a(mm var1, double var2, double var4, double var6, float var8, float var9) {
		super.a((RecipesIngots)var1, var2, var4, var6, var8, var9);
	}

	protected float a(mm var1, float var2) {
		float var3 = var1.e + (var1.b - var1.e) * var2;
		float var4 = var1.d + (var1.c - var1.d) * var2;
		return (ModelPig.a(var3) + 1.0F) * var4;
	}

	protected float d(RecipesIngots var1, float var2) {
		return this.a((mm)var1, var2);
	}

	public void a(RecipesIngots var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((mm)var1, var2, var4, var6, var8, var9);
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((mm)var1, var2, var4, var6, var8, var9);
	}
}
