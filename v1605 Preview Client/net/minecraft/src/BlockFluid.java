package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;

public class BlockFluid extends EnumSkyBlock {
	public byte[] a;

	public BlockFluid() {
	}

	public BlockFluid(byte[] var1) {
		this.a = var1;
	}

	void a(DataOutput var1) {
		var1.writeInt(this.a.length);
		var1.write(this.a);
	}

	void a(DataInput var1) {
		int var2 = var1.readInt();
		this.a = new byte[var2];
		var1.readFully(this.a);
	}

	public byte a() {
		return (byte)7;
	}

	public String toString() {
		return "[" + this.a.length + " bytes]";
	}
}
