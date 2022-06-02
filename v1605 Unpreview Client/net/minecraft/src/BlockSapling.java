package net.minecraft.src;

import java.io.InputStream;
import java.net.URL;

class BlockSapling extends InputStream {
	private int c;
	private InputStream d;
	byte[] a;
	final ModelZombie b;

	public BlockSapling(ModelZombie var1, URL var2, InputStream var3) {
		this.b = var1;
		this.a = new byte[1];
		this.d = var3;
		String var4 = var2.getPath();
		var4 = var4.substring(var4.lastIndexOf("/") + 1);
		this.c = var4.hashCode();
	}

	public int read() {
		int var1 = this.read(this.a, 0, 1);
		return var1 < 0?var1:this.a[0];
	}

	public int read(byte[] var1, int var2, int var3) {
		var3 = this.d.read(var1, var2, var3);

		for(int var4 = 0; var4 < var3; ++var4) {
			byte var5 = var1[var2 + var4] = (byte)(var1[var2 + var4] ^ this.c >> 8);
			this.c = this.c * 498729871 + 85731 * var5;
		}

		return var3;
	}
}
