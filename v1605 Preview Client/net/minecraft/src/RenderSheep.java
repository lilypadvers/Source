package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;

public class RenderSheep implements TerrainTextureManager {
	private int[] a;
	private int b;
	private int c;

	public BufferedImage a(BufferedImage var1) {
		if(var1 == null) {
			return null;
		} else {
			this.b = 64;
			this.c = 32;
			BufferedImage var2 = new BufferedImage(this.b, this.c, 2);
			Graphics var3 = var2.getGraphics();
			var3.drawImage(var1, 0, 0, (ImageObserver)null);
			var3.dispose();
			this.a = ((DataBufferInt)var2.getRaster().getDataBuffer()).getData();
			this.b(0, 0, 32, 16);
			this.a(32, 0, 64, 32);
			this.b(0, 16, 64, 32);
			boolean var4 = false;

			int var5;
			int var6;
			int var7;
			for(var5 = 32; var5 < 64; ++var5) {
				for(var6 = 0; var6 < 16; ++var6) {
					var7 = this.a[var5 + var6 * 64];
					if((var7 >> 24 & 255) < 128) {
						var4 = true;
					}
				}
			}

			if(!var4) {
				for(var5 = 32; var5 < 64; ++var5) {
					for(var6 = 0; var6 < 16; ++var6) {
						var7 = this.a[var5 + var6 * 64];
						if((var7 >> 24 & 255) < 128) {
							var4 = true;
						}
					}
				}
			}

			return var2;
		}
	}

	private void a(int var1, int var2, int var3, int var4) {
		if(!this.c(var1, var2, var3, var4)) {
			for(int var5 = var1; var5 < var3; ++var5) {
				for(int var6 = var2; var6 < var4; ++var6) {
					this.a[var5 + var6 * this.b] &= 0xFFFFFF;
				}
			}

		}
	}

	private void b(int var1, int var2, int var3, int var4) {
		for(int var5 = var1; var5 < var3; ++var5) {
			for(int var6 = var2; var6 < var4; ++var6) {
				this.a[var5 + var6 * this.b] |= 0xFF000000;
			}
		}

	}

	private boolean c(int var1, int var2, int var3, int var4) {
		for(int var5 = var1; var5 < var3; ++var5) {
			for(int var6 = var2; var6 < var4; ++var6) {
				int var7 = this.a[var5 + var6 * this.b];
				if((var7 >> 24 & 255) < 128) {
					return true;
				}
			}
		}

		return false;
	}
}
