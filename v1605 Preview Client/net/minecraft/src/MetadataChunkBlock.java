package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class MetadataChunkBlock extends ItemAxe {
	public int a;
	public int x;
	public int y;
	public int z;
	public int maxX;

	public MetadataChunkBlock() {
	}

	public MetadataChunkBlock(int var1, int var2, int var3, int var4, int var5) {
		this.maxX = var1;
		this.a = var2;
		this.x = var3;
		this.y = var4;
		this.z = var5;
	}

	public void a(DataInputStream var1) {
		this.maxX = var1.read();
		this.a = var1.readInt();
		this.x = var1.read();
		this.y = var1.readInt();
		this.z = var1.read();
	}

	public void a(DataOutputStream var1) {
		var1.write(this.maxX);
		var1.writeInt(this.a);
		var1.write(this.x);
		var1.writeInt(this.y);
		var1.write(this.z);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 11;
	}
}
