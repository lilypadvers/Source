package net.minecraft.src;

import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;

public class ItemFood {
	private int healAmount;
	private int b;
	private int c;
	private float d;
	private float e;
	private float f;
	private IntBuffer g = BlockRedstoneTorch.c(65536);
	private boolean h = false;
	private boolean i = false;

	public void a(int var1, int var2, int var3, double var4, double var6, double var8) {
		this.h = true;
		this.g.clear();
		this.healAmount = var1;
		this.b = var2;
		this.c = var3;
		this.d = (float)var4;
		this.e = (float)var6;
		this.f = (float)var8;
	}

	public boolean a(int var1, int var2, int var3) {
		return !this.h?false:var1 == this.healAmount && var2 == this.b && var3 == this.c;
	}

	public void a(int var1) {
		this.g.put(var1);
		if(this.g.remaining() == 0) {
			this.a();
		}

	}

	public void a() {
		if(this.h) {
			if(!this.i) {
				this.g.flip();
				this.i = true;
			}

			if(this.g.remaining() > 0) {
				GL11.glPushMatrix();
				GL11.glTranslatef((float)this.healAmount - this.d, (float)this.b - this.e, (float)this.c - this.f);
				GL11.glCallLists(this.g);
				GL11.glPopMatrix();
			}

		}
	}

	public void b() {
		this.h = false;
		this.i = false;
	}
}
