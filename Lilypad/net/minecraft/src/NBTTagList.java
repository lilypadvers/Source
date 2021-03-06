package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NBTTagList extends NBTBase {
	private List tagList = new ArrayList();
	private byte tagType;

	void writeTagContents(DataOutput dataOutput) throws IOException {
		if(this.tagList.size() > 0) {
			this.tagType = ((NBTBase)this.tagList.get(0)).getType();
		} else {
			this.tagType = 1;
		}

		dataOutput.writeByte(this.tagType);
		dataOutput.writeInt(this.tagList.size());

		for(int var2 = 0; var2 < this.tagList.size(); ++var2) {
			((NBTBase)this.tagList.get(var2)).writeTagContents(dataOutput);
		}

	}

	void readTagContents(DataInput dataInput) throws IOException {
		this.tagType = dataInput.readByte();
		int var2 = dataInput.readInt();
		this.tagList = new ArrayList();

		for(int var3 = 0; var3 < var2; ++var3) {
			NBTBase var4 = NBTBase.createTagOfType(this.tagType);
			var4.readTagContents(dataInput);
			this.tagList.add(var4);
		}

	}

	public byte getType() {
		return (byte)9;
	}

	public String toString() {
		return "" + this.tagList.size() + " entries of type " + NBTBase.getTagName(this.tagType);
	}

	public void setTag(NBTBase tag) {
		this.tagType = tag.getType();
		this.tagList.add(tag);
	}

	public NBTBase tagAt(int index) {
		return (NBTBase)this.tagList.get(index);
	}

	public int tagCount() {
		return this.tagList.size();
	}
}
