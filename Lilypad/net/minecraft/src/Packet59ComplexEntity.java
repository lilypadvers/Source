package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class Packet59ComplexEntity extends RenderLiving {
	private float f;

	public Packet59ComplexEntity(ModelBase var1, float var2, float var3) {
		super(var1, var2 * var3);
		this.f = var3;
	}

	protected void a(EntityGiantZombie var1, float var2) {
		GL11.glScalef(this.f, this.f, this.f);
	}

	protected void preRenderCallback(EntityLiving var1, float var2) {
		this.a((EntityGiantZombie)var1, var2);
	}
}
