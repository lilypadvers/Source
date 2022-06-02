package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ItemFlintAndSteel extends Packet {
	public int a;
	public int b;
	public int c;
	public byte[] d;
	public NBTTagCompound e;

	public ItemFlintAndSteel() {
		this.isChunkDataPacket = true;
	}

	public ItemFlintAndSteel(int var1, int var2, int var3, TileEntity var4) {
		this.isChunkDataPacket = true;
		this.a = var1;
		this.b = var2;
		this.c = var3;
		this.e = new NBTTagCompound();
		var4.writeToNBT(this.e);

		try {
			this.d = CompressedStreamTools.compress(this.e);
		} catch (IOException var6) {
			var6.printStackTrace();
		}

	}

	public void readPacketData(DataInputStream dataInputStream) throws IOException {
		this.a = dataInputStream.readInt();
		this.b = dataInputStream.readShort();
		this.c = dataInputStream.readInt();
		int var2 = dataInputStream.readShort() & '\uffff';
		this.d = new byte[var2];
		dataInputStream.readFully(this.d);
		this.e = CompressedStreamTools.decompress(this.d);
	}

	public void writePacket(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(this.a);
		dataOutputStream.writeShort(this.b);
		dataOutputStream.writeInt(this.c);
		dataOutputStream.writeShort((short)this.d.length);
		dataOutputStream.write(this.d);
	}

	public void processPacket(NetHandler netHandler) {
		netHandler.a(this);
	}

	public int getPacketSize() {
		return this.d.length + 2 + 10;
	}
}
