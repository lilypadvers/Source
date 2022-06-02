package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BlockFire extends Packet {
	public String a;

	public BlockFire() {
	}

	public BlockFire(String var1) {
		this.a = var1;
	}

	public void readPacketData(DataInputStream dataInputStream) throws IOException {
		this.a = dataInputStream.readUTF();
	}

	public void writePacket(DataOutputStream dataOutputStream) throws IOException {
		dataOutputStream.writeUTF(this.a);
	}

	public void processPacket(NetHandler netHandler) {
		netHandler.a(this);
	}

	public int getPacketSize() {
		return this.a.length();
	}
}
