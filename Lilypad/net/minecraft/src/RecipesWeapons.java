package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class RecipesWeapons extends NBTBase {
	public String a;

	public RecipesWeapons() {
	}

	public RecipesWeapons(String var1) {
		this.a = var1;
		if(var1 == null) {
			throw new IllegalArgumentException("Empty string not allowed");
		}
	}

	void writeTagContents(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(this.a);
	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.a = dataInput.readUTF();
	}

	public byte getType() {
		return (byte)8;
	}

	public String toString() {
		return "" + this.a;
	}
}
