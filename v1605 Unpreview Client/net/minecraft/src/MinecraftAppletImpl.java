package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MinecraftAppletImpl extends BlockContainer {
	public MinecraftAppletImpl() {
		this.h = true;
	}

	public MinecraftAppletImpl(double var1, double var3, double var5, double var7, boolean var9) {
		this.a = var1;
		this.b = var3;
		this.d = var5;
		this.c = var7;
		this.g = var9;
		this.h = true;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readDouble();
		this.b = var1.readDouble();
		this.d = var1.readDouble();
		this.c = var1.readDouble();
		super.a(var1);
	}

	public void a(DataOutputStream var1) {
		var1.writeDouble(this.a);
		var1.writeDouble(this.b);
		var1.writeDouble(this.d);
		var1.writeDouble(this.c);
		super.a(var1);
	}

	public int a() {
		return 33;
	}
}
