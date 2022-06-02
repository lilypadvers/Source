package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class EntityChicken extends Packet {
	public int a;
	public int b;
	public short[] c;
	public byte[] d;
	public byte[] e;
	public int f;

	public EntityChicken() {
		this.isChunkDataPacket = true;
	}

	public void readPacketData(DataInputStream dataInputStream) throws IOException {
		this.a = dataInputStream.readInt();
		this.b = dataInputStream.readInt();
		this.f = dataInputStream.readShort() & '\uffff';
		this.c = new short[this.f];
		this.d = new byte[this.f];
		this.e = new byte[this.f];

		for(int var2 = 0; var2 < this.f; ++var2) {
			this.c[var2] = dataInputStream.readShort();
		}

		dataInputStream.readFully(this.d);
		dataInputStream.readFully(this.e);
	}

	public void writePacket(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeInt(this.a);
		dataOutputStream.writeInt(this.b);
		dataOutputStream.writeShort((short)this.f);

		for(int var2 = 0; var2 < this.f; ++var2) {
			dataOutputStream.writeShort(this.c[var2]);
		}

		dataOutputStream.write(this.d);
		dataOutputStream.write(this.e);
	}

	public void processPacket(NetHandler netHandler) {
		netHandler.a(this);
	}

	public int getPacketSize() {
		return 10 + this.f * 4;
	}
}
