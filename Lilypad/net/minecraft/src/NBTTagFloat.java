package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagFloat extends NBTBase {
	public float floatValue;

	public NBTTagFloat() {
	}

	public NBTTagFloat(float value) {
		this.floatValue = value;
	}

	void writeTagContents(DataOutput dataOutput) throws IOException {
		dataOutput.writeFloat(this.floatValue);
	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.floatValue = dataInput.readFloat();
	}

	public byte getType() {
		return (byte)5;
	}

	public String toString() {
		return "" + this.floatValue;
	}
}
