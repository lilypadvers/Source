package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

public class BlockDoor {
	private int[] b = new int[256];
	public int a = 0;
	private int c;
	private IntBuffer d = BlockRedstoneTorch.c(1024);

	public BlockDoor(World var1, String var2, BlockRedstoneWire var3) {
		BufferedImage var4;
		try {
			var4 = ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var2));
		} catch (IOException var18) {
			throw new RuntimeException(var18);
		}

		int var5 = var4.getWidth();
		int var6 = var4.getHeight();
		int[] var7 = new int[var5 * var6];
		var4.getRGB(0, 0, var5, var6, var7, 0, var5);
		int var8 = 0;

		int var9;
		int var10;
		int var11;
		int var12;
		int var15;
		int var16;
		while(var8 < 256) {
			var9 = var8 % 16;
			var10 = var8 / 16;
			var11 = 7;

			while(true) {
				if(var11 >= 0) {
					var12 = var9 * 8 + var11;
					boolean var13 = true;

					for(int var14 = 0; var14 < 8 && var13; ++var14) {
						var15 = (var10 * 8 + var14) * var5;
						var16 = var7[var12 + var15] & 255;
						if(var16 > 0) {
							var13 = false;
						}
					}

					if(var13) {
						--var11;
						continue;
					}
				}

				if(var8 == 32) {
					var11 = 2;
				}

				this.b[var8] = var11 + 2;
				++var8;
				break;
			}
		}

		this.a = var3.a(var4);
		this.c = BlockRedstoneTorch.a(288);
		NBTTagByteArray var19 = NBTTagByteArray.a;

		for(var9 = 0; var9 < 256; ++var9) {
			GL11.glNewList(this.c + var9, GL11.GL_COMPILE);
			var19.b();
			var10 = var9 % 16 * 8;
			var11 = var9 / 16 * 8;
			float var20 = 7.99F;
			float var21 = 0.0F;
			float var23 = 0.0F;
			var19.a(0.0D, (double)(0.0F + var20), 0.0D, (double)((float)var10 / 128.0F + var21), (double)(((float)var11 + var20) / 128.0F + var23));
			var19.a((double)(0.0F + var20), (double)(0.0F + var20), 0.0D, (double)(((float)var10 + var20) / 128.0F + var21), (double)(((float)var11 + var20) / 128.0F + var23));
			var19.a((double)(0.0F + var20), 0.0D, 0.0D, (double)(((float)var10 + var20) / 128.0F + var21), (double)((float)var11 / 128.0F + var23));
			var19.a(0.0D, 0.0D, 0.0D, (double)((float)var10 / 128.0F + var21), (double)((float)var11 / 128.0F + var23));
			var19.a();
			GL11.glTranslatef((float)this.b[var9], 0.0F, 0.0F);
			GL11.glEndList();
		}

		for(var9 = 0; var9 < 32; ++var9) {
			var10 = (var9 >> 3 & 1) * 85;
			var11 = (var9 >> 2 & 1) * 170 + var10;
			var12 = (var9 >> 1 & 1) * 170 + var10;
			int var22 = (var9 >> 0 & 1) * 170 + var10;
			if(var9 == 6) {
				var11 += 85;
			}

			boolean var24 = var9 >= 16;
			if(var1.g) {
				var15 = (var11 * 30 + var12 * 59 + var22 * 11) / 100;
				var16 = (var11 * 30 + var12 * 70) / 100;
				int var17 = (var11 * 30 + var22 * 70) / 100;
				var11 = var15;
				var12 = var16;
				var22 = var17;
			}

			if(var24) {
				var11 /= 4;
				var12 /= 4;
				var22 /= 4;
			}

			GL11.glNewList(this.c + 256 + var9, GL11.GL_COMPILE);
			GL11.glColor3f((float)var11 / 255.0F, (float)var12 / 255.0F, (float)var22 / 255.0F);
			GL11.glEndList();
		}

	}

	public void a(String var1, int var2, int var3, int var4) {
		this.a(var1, var2 + 1, var3 + 1, var4, true);
		this.b(var1, var2, var3, var4);
	}

	public void b(String var1, int var2, int var3, int var4) {
		this.a(var1, var2, var3, var4, false);
	}

	public void a(String var1, int var2, int var3, int var4, boolean var5) {
		if(var1 != null) {
			int var6;
			if(var5) {
				var6 = var4 & 0xFF000000;
				var4 = (var4 & 16579836) >> 2;
				var4 += var6;
			}

			GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.a);
			float var10 = (float)(var4 >> 16 & 255) / 255.0F;
			float var7 = (float)(var4 >> 8 & 255) / 255.0F;
			float var8 = (float)(var4 & 255) / 255.0F;
			float var9 = (float)(var4 >> 24 & 255) / 255.0F;
			if(var9 == 0.0F) {
				var9 = 1.0F;
			}

			GL11.glColor4f(var10, var7, var8, var9);
			this.d.clear();
			GL11.glPushMatrix();
			GL11.glTranslatef((float)var2, (float)var3, 0.0F);

			for(var6 = 0; var6 < var1.length(); ++var6) {
				int var11;
				for(; var1.charAt(var6) == 167 && var1.length() > var6 + 1; var6 += 2) {
					var11 = "0123456789abcdef".indexOf(var1.toLowerCase().charAt(var6 + 1));
					if(var11 < 0 || var11 > 15) {
						var11 = 15;
					}

					this.d.put(this.c + 256 + var11 + (var5?16:0));
					if(this.d.remaining() == 0) {
						this.d.flip();
						GL11.glCallLists(this.d);
						this.d.clear();
					}
				}

				var11 = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(var1.charAt(var6));
				if(var11 >= 0) {
					this.d.put(this.c + var11 + 32);
				}

				if(this.d.remaining() == 0) {
					this.d.flip();
					GL11.glCallLists(this.d);
					this.d.clear();
				}
			}

			this.d.flip();
			GL11.glCallLists(this.d);
			GL11.glPopMatrix();
		}
	}

	public int a(String var1) {
		if(var1 == null) {
			return 0;
		} else {
			int var2 = 0;

			for(int var3 = 0; var3 < var1.length(); ++var3) {
				if(var1.charAt(var3) == 167) {
					++var3;
				} else {
					int var4 = " !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(var1.charAt(var3));
					if(var4 >= 0) {
						var2 += this.b[var4 + 32];
					}
				}
			}

			return var2;
		}
	}
}
