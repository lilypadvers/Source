package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class mn extends ItemAxe {
	public int a;
	public int b;
	public short[] c;
	public byte[] d;
	public byte[] e;
	public int f;

	public mn() {
		this.j = true;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readInt();
		this.b = var1.readInt();
		this.f = var1.readShort() & '\uffff';
		this.c = new short[this.f];
		this.d = new byte[this.f];
		this.e = new byte[this.f];

		for(int var2 = 0; var2 < this.f; ++var2) {
			this.c[var2] = var1.readShort();
		}

		var1.readFully(this.d);
		var1.readFully(this.e);
	}

	public void a(DataOutputStream var1) {
		var1.writeInt(this.a);
		var1.writeInt(this.b);
		var1.writeShort((short)this.f);

		for(int var2 = 0; var2 < this.f; ++var2) {
			var1.writeShort(this.c[var2]);
		}

		var1.write(this.d);
		var1.write(this.e);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 10 + this.f * 4;
	}
}
