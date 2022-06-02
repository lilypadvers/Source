package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTBase {
	public double doubleValue;

	public NBTTagDouble() {
	}

	public NBTTagDouble(double value) {
		this.doubleValue = value;
	}

	void writeTagContents(DataOutput dataOutput) throws IOException {
		dataOutput.writeDouble(this.doubleValue);
	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.doubleValue = dataInput.readDouble();
	}

	public byte getType() {
		return (byte)6;
	}

	public String toString() {
		return "" + this.doubleValue;
	}
}
