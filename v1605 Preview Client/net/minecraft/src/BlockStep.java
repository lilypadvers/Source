package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class BlockStep extends lf {
	public void a(DataInputStream var1) {
		super.a(var1);
		this.b = var1.readByte();
		this.c = var1.readByte();
		this.d = var1.readByte();
	}

	public void a(DataOutputStream var1) {
		super.a(var1);
		var1.writeByte(this.b);
		var1.writeByte(this.c);
		var1.writeByte(this.d);
	}

	public int a() {
		return 7;
	}
}
