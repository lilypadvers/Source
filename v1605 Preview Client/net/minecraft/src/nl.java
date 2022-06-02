package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class nl extends ItemBow {
	private float f;

	public nl(RenderMinecart var1, float var2, float var3) {
		super(var1, var2 * var3);
		this.f = var3;
	}

	protected void a(EntityZombie var1, float var2) {
		GL11.glScalef(this.f, this.f, this.f);
	}

	protected void a(RecipesIngots var1, float var2) {
		this.a((EntityZombie)var1, var2);
	}
}
