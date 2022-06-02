package net.minecraft.src;

public class nf extends ItemBow {
	public nf(RenderMinecart var1, RenderMinecart var2, float var3) {
		super(var1, var3);
		this.a(var2);
	}

	protected boolean a(SoundPoolEntry var1, int var2) {
		this.a("/mob/sheep_fur.png");
		return var2 == 0 && !var1.a;
	}

	protected boolean a(RecipesIngots var1, int var2) {
		return this.a((SoundPoolEntry)var1, var2);
	}
}
