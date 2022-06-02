package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagShort extends NBTBase {
	public short shortValue;

	public NBTTagShort() {
	}

	public NBTTagShort(short value) {
		this.shortValue = value;
	}

	void writeTagContents(DataOutput dataOutput) throws IOException {
		dataOutput.writeShort(this.shortValue);
	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.shortValue = dataInput.readShort();
	}

	public byte getType() {
		return (byte)2;
	}

	public String toString() {
		return "" + this.shortValue;
	}
}
