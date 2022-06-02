package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ItemRenderer extends ItemAxe {
	public int a;
	public int b;
	public int c;
	public int d;
	public int swingProgress;

	public ItemRenderer() {
	}

	public ItemRenderer(int var1, int var2, int var3, int var4, int var5) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.swingProgress = var5;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readShort();
		this.b = var1.readInt();
		this.c = var1.read();
		this.d = var1.readInt();
		this.swingProgress = var1.read();
	}

	public void a(DataOutputStream var1) {
		var1.writeShort(this.a);
		var1.writeInt(this.b);
		var1.write(this.c);
		var1.writeInt(this.d);
		var1.write(this.swingProgress);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 12;
	}
}
