package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class BlockSign extends ItemAxe {
	public String a;

	public BlockSign() {
	}

	public BlockSign(String var1) {
		this.a = var1;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readUTF();
	}

	public void a(DataOutputStream var1) {
		var1.writeUTF(this.a);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 4 + this.a.length() + 4;
	}
}
