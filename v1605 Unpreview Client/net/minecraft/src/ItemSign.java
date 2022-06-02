package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ItemSign extends ItemAxe {
	public int a;
	public String b;
	public String c;

	public ItemSign() {
	}

	public ItemSign(String var1, String var2, int var3) {
		this.b = var1;
		this.c = var2;
		this.a = var3;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readInt();
		this.b = var1.readUTF();
		this.c = var1.readUTF();
	}

	public void a(DataOutputStream var1) {
		var1.writeInt(this.a);
		var1.writeUTF(this.b);
		var1.writeUTF(this.c);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 4 + this.b.length() + this.c.length() + 4;
	}
}
