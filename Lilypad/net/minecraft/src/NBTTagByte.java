package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase {
	public byte byteValue;

	public NBTTagByte() {
	}

	public NBTTagByte(byte value) {
		this.byteValue = value;
	}

	void writeTagContents(DataOutput dataOutput) throws IOException {
		dataOutput.writeByte(this.byteValue);
	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.byteValue = dataInput.readByte();
	}

	public byte getType() {
		return (byte)1;
	}

	public String toString() {
		return "" + this.byteValue;
	}
}
