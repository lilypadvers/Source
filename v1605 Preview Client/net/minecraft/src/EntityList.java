package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;

public class EntityList extends EnumSkyBlock {
	public int a;

	public EntityList() {
	}

	public EntityList(int var1) {
		this.a = var1;
	}

	void a(DataOutput var1) {
		var1.writeInt(this.a);
	}

	void a(DataInput var1) {
		this.a = var1.readInt();
	}

	public byte a() {
		return (byte)3;
	}

	public String toString() {
		return "" + this.a;
	}
}
