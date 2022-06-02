package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class TileEntityRenderer extends ItemAxe {
	public int a;
	public int b;
	public int c;
	public int d;
	public int e;

	public void a(DataInputStream var1) {
		this.a = var1.readInt();
		this.e = var1.readByte();
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.d = var1.readInt();
	}

	public void a(DataOutputStream var1) {
		var1.writeInt(this.a);
		var1.writeByte(this.e);
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 17;
	}
}
