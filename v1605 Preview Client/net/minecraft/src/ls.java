package net.minecraft.src;

public class ls extends ItemBow {
	public ls(RenderMinecart var1, float var2) {
		super(var1, var2);
	}

	public void a(StepSoundSand var1, double var2, double var4, double var6, float var8, float var9) {
		super.a((RecipesIngots)var1, var2, var4, var6, var8, var9);
	}

	public void a(RecipesIngots var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((StepSoundSand)var1, var2, var4, var6, var8, var9);
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8, float var9) {
		this.a((StepSoundSand)var1, var2, var4, var6, var8, var9);
	}
}
