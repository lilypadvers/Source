package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;

public class GuiInventory extends EnumSkyBlock {
	public long a;

	public GuiInventory() {
	}

	public GuiInventory(long var1) {
		this.a = var1;
	}

	void a(DataOutput var1) {
		var1.writeLong(this.a);
	}

	void a(DataInput var1) {
		this.a = var1.readLong();
	}

	public byte a() {
		return (byte)4;
	}

	public String toString() {
		return "" + this.a;
	}
}
