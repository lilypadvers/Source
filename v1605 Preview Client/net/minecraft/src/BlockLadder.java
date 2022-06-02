package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class BlockLadder extends ItemAxe {
	public int a;
	public int b;

	public BlockLadder() {
	}

	public BlockLadder(int var1, int var2) {
		this.a = var1;
		this.b = var2;
	}

	public void a(DataInputStream var1) {
		this.a = var1.readInt();
		this.b = var1.readShort();
	}

	public void a(DataOutputStream var1) {
		var1.writeInt(this.a);
		var1.writeShort(this.b);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 6;
	}
}
