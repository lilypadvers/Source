package net.minecraft.src;

import java.awt.image.BufferedImage;

public class ModelBase {
	public BufferedImage a;
	public EntitySpider b;
	public int c;
	public int d;
	public boolean e = false;
	public boolean f = false;
	public int g = 0;
	public boolean h = false;

	public ModelBase(EntitySpider var1, int var2, int var3) {
		this.b = var1;
		this.a(var2, var3);
	}

	public void a(int var1, int var2) {
		this.e = false;
		this.c = var1;
		this.d = var2;
		this.g = 0;
		this.h = false;
	}

	public void a(EntitySpider var1, int var2, int var3) {
		this.b = var1;
		this.a(var2, var3);
	}
}
