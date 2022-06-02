package net.minecraft.src;

import java.io.IOException;

public class ItemSword implements BlockButton {
	private BlockMushroom[] b = new BlockMushroom[256];
	private EntitySpider c;
	private GuiSmallButton d;
	byte[] a = new byte['\u8000'];

	public ItemSword(EntitySpider var1, GuiSmallButton var2) {
		this.c = var1;
		this.d = var2;
	}

	public boolean a(int var1, int var2) {
		int var3 = var1 & 15 | (var2 & 15) * 16;
		return this.b[var3] != null && this.b[var3].a(var1, var2);
	}

	public BlockMushroom b(int var1, int var2) {
		int var3 = var1 & 15 | (var2 & 15) * 16;

		try {
			if(!this.a(var1, var2)) {
				BlockMushroom var4 = this.c(var1, var2);
				if(var4 == null) {
					var4 = new BlockMushroom(this.c, this.a, var1, var2);
					var4.q = true;
					var4.p = true;
				}

				this.b[var3] = var4;
			}

			return this.b[var3];
		} catch (Exception var5) {
			var5.printStackTrace();
			return null;
		}
	}

	private synchronized BlockMushroom c(int var1, int var2) {
		try {
			return this.d.a(this.c, var1, var2);
		} catch (IOException var4) {
			var4.printStackTrace();
			return null;
		}
	}

	public void a(BlockButton var1, int var2, int var3) {
	}

	public boolean a(boolean var1, nh var2) {
		return true;
	}

	public boolean a() {
		return false;
	}

	public boolean b() {
		return false;
	}
}
