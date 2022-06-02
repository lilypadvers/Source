package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class GuiIngame extends ItemAxe {
	public int a;
	public int b;
	public int c;
	public int d;
	public byte e;
	public byte f;
	public byte g;
	public int updateCounter;
	public int i;

	public GuiIngame() {
	}

	public GuiIngame(EffectRenderer var1) {
		this.a = var1.Z;
		this.updateCounter = var1.a.c;
		this.i = var1.a.a;
		this.b = ModelPig.b(var1.ah * 32.0D);
		this.c = ModelPig.b(var1.ai * 32.0D);
		this.d = ModelPig.b(var1.aj * 32.0D);
		this.e = (byte)((int)(var1.ak * 128.0D));
		this.f = (byte)((int)(var1.al * 128.0D));
		this.g = (byte)((int)(var1.am * 128.0D));
	}

	public void a(DataInputStream var1) {
		this.a = var1.readInt();
		this.updateCounter = var1.readShort();
		this.i = var1.readByte();
		this.b = var1.readInt();
		this.c = var1.readInt();
		this.d = var1.readInt();
		this.e = var1.readByte();
		this.f = var1.readByte();
		this.g = var1.readByte();
	}

	public void a(DataOutputStream var1) {
		var1.writeInt(this.a);
		var1.writeShort(this.updateCounter);
		var1.writeByte(this.i);
		var1.writeInt(this.b);
		var1.writeInt(this.c);
		var1.writeInt(this.d);
		var1.writeByte(this.e);
		var1.writeByte(this.f);
		var1.writeByte(this.g);
	}

	public void a(kq var1) {
		var1.a(this);
	}

	public int a() {
		return 22;
	}
}
