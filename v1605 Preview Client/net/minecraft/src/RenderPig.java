package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;

public class RenderPig extends EnumSkyBlock {
	public float a;

	public RenderPig() {
	}

	public RenderPig(float var1) {
		this.a = var1;
	}

	void a(DataOutput var1) {
		var1.writeFloat(this.a);
	}

	void a(DataInput var1) {
		this.a = var1.readFloat();
	}

	public byte a() {
		return (byte)5;
	}

	public String toString() {
		return "" + this.a;
	}
}
