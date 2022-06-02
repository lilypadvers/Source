package net.minecraft.src;

public class OSMapIsom extends ItemBow {
	public OSMapIsom(RenderMinecart var1, RenderMinecart var2, float var3) {
		super(var1, var3);
		this.a(var2);
	}

	protected boolean a(mj var1, int var2) {
		this.a("/mob/saddle.png");
		return var2 == 0 && var1.a;
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return this.a((mj)var1, var2);
	}
}
