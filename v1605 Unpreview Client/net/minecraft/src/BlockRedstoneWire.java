package net.minecraft.src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.lwjgl.opengl.GL11;

public class BlockRedstoneWire {
	public static boolean wiresProvidePower = false;
	private HashMap b = new HashMap();
	private HashMap c = new HashMap();
	private IntBuffer d = BlockRedstoneTorch.c(1);
	private ByteBuffer e = BlockRedstoneTorch.b(1048576);
	private List f = new ArrayList();
	private Map g = new HashMap();
	private World h;
	private boolean i = false;

	public BlockRedstoneWire(World var1) {
		this.h = var1;
	}

	public int a(String var1) {
		Integer var2 = (Integer)this.b.get(var1);
		if(var2 != null) {
			return var2.intValue();
		} else {
			try {
				this.d.clear();
				BlockRedstoneTorch.a(this.d);
				int var4 = this.d.get(0);
				if(var1.startsWith("##")) {
					this.a(this.b(ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var1.substring(2)))), var4);
				} else if(var1.startsWith("%%")) {
					this.i = true;
					this.a(ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var1.substring(2))), var4);
					this.i = false;
				} else {
					this.a(ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var1)), var4);
				}

				this.b.put(var1, Integer.valueOf(var4));
				return var4;
			} catch (IOException var3) {
				throw new RuntimeException("!!");
			}
		}
	}

	private BufferedImage b(BufferedImage var1) {
		int var2 = var1.getWidth() / 16;
		BufferedImage var3 = new BufferedImage(16, var1.getHeight() * var2, 2);
		Graphics var4 = var3.getGraphics();

		for(int var5 = 0; var5 < var2; ++var5) {
			var4.drawImage(var1, -var5 * 16, var5 * var1.getHeight(), (ImageObserver)null);
		}

		var4.dispose();
		return var3;
	}

	public int a(BufferedImage var1) {
		this.d.clear();
		BlockRedstoneTorch.a(this.d);
		int var2 = this.d.get(0);
		this.a(var1, var2);
		this.c.put(Integer.valueOf(var2), var1);
		return var2;
	}

	public void a(BufferedImage var1, int var2) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, var2);
		if(wiresProvidePower) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR_MIPMAP_LINEAR);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		} else {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		}

		if(this.i) {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
		} else {
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);
		}

		int var3 = var1.getWidth();
		int var4 = var1.getHeight();
		int[] var5 = new int[var3 * var4];
		byte[] var6 = new byte[var3 * var4 * 4];
		var1.getRGB(0, 0, var3, var4, var5, 0, var3);

		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		for(var7 = 0; var7 < var5.length; ++var7) {
			var8 = var5[var7] >> 24 & 255;
			var9 = var5[var7] >> 16 & 255;
			var10 = var5[var7] >> 8 & 255;
			var11 = var5[var7] & 255;
			if(this.h != null && this.h.g) {
				var12 = (var9 * 30 + var10 * 59 + var11 * 11) / 100;
				var13 = (var9 * 30 + var10 * 70) / 100;
				var14 = (var9 * 30 + var11 * 70) / 100;
				var9 = var12;
				var10 = var13;
				var11 = var14;
			}

			var6[var7 * 4 + 0] = (byte)var9;
			var6[var7 * 4 + 1] = (byte)var10;
			var6[var7 * 4 + 2] = (byte)var11;
			var6[var7 * 4 + 3] = (byte)var8;
		}

		this.e.clear();
		this.e.put(var6);
		this.e.position(0).limit(var6.length);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, var3, var4, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
		if(wiresProvidePower) {
			for(var7 = 1; var7 <= 4; ++var7) {
				var8 = var3 >> var7 - 1;
				var9 = var3 >> var7;
				var10 = var4 >> var7;

				for(var11 = 0; var11 < var9; ++var11) {
					for(var12 = 0; var12 < var10; ++var12) {
						var13 = this.e.getInt((var11 * 2 + 0 + (var12 * 2 + 0) * var8) * 4);
						var14 = this.e.getInt((var11 * 2 + 1 + (var12 * 2 + 0) * var8) * 4);
						int var15 = this.e.getInt((var11 * 2 + 1 + (var12 * 2 + 1) * var8) * 4);
						int var16 = this.e.getInt((var11 * 2 + 0 + (var12 * 2 + 1) * var8) * 4);
						int var17 = this.b(this.b(var13, var14), this.b(var15, var16));
						this.e.putInt((var11 + var12 * var9) * 4, var17);
					}
				}

				GL11.glTexImage2D(GL11.GL_TEXTURE_2D, var7, GL11.GL_RGBA, var9, var10, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
			}
		}

	}

	public void a(int var1) {
		this.c.remove(Integer.valueOf(var1));
		this.d.clear();
		this.d.put(var1);
		this.d.flip();
		GL11.glDeleteTextures(this.d);
	}

	public int a(String var1, String var2) {
		TileEntitySignRenderer var3 = (TileEntitySignRenderer)this.g.get(var1);
		if(var3 != null && var3.a != null && !var3.d) {
			if(var3.c < 0) {
				var3.c = this.a(var3.a);
			} else {
				this.a(var3.a, var3.c);
			}

			var3.d = true;
		}

		return var3 != null && var3.c >= 0?var3.c:this.a(var2);
	}

	public TileEntitySignRenderer a(String var1, TerrainTextureManager var2) {
		TileEntitySignRenderer var3 = (TileEntitySignRenderer)this.g.get(var1);
		if(var3 == null) {
			this.g.put(var1, new TileEntitySignRenderer(var1, var2));
		} else {
			++var3.b;
		}

		return var3;
	}

	public void b(String var1) {
		TileEntitySignRenderer var2 = (TileEntitySignRenderer)this.g.get(var1);
		if(var2 != null) {
			--var2.b;
			if(var2.b == 0) {
				if(var2.c >= 0) {
					this.a(var2.c);
				}

				this.g.remove(var1);
			}
		}

	}

	public void a(BlockLeavesBase var1) {
		this.f.add(var1);
		var1.a();
	}

	public void a() {
		int var1;
		BlockLeavesBase var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		for(var1 = 0; var1 < this.f.size(); ++var1) {
			var2 = (BlockLeavesBase)this.f.get(var1);
			var2.c = this.h.g;
			var2.a();
			this.e.clear();
			this.e.put(var2.a);
			this.e.position(0).limit(var2.a.length);

			for(var3 = 0; var3 < var2.e; ++var3) {
				for(var4 = 0; var4 < var2.e; ++var4) {
					GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, var2.b % 16 * 16 + var3 * 16, var2.b / 16 * 16 + var4 * 16, 16, 16, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
					if(wiresProvidePower) {
						for(var5 = 1; var5 <= 4; ++var5) {
							var6 = 16 >> var5 - 1;
							var7 = 16 >> var5;

							for(var8 = 0; var8 < var7; ++var8) {
								for(var9 = 0; var9 < var7; ++var9) {
									var10 = this.e.getInt((var8 * 2 + 0 + (var9 * 2 + 0) * var6) * 4);
									var11 = this.e.getInt((var8 * 2 + 1 + (var9 * 2 + 0) * var6) * 4);
									var12 = this.e.getInt((var8 * 2 + 1 + (var9 * 2 + 1) * var6) * 4);
									int var13 = this.e.getInt((var8 * 2 + 0 + (var9 * 2 + 1) * var6) * 4);
									int var14 = this.a(this.a(var10, var11), this.a(var12, var13));
									this.e.putInt((var8 + var9 * var7) * 4, var14);
								}
							}

							GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, var5, var2.b % 16 * var7, var2.b / 16 * var7, var7, var7, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
						}
					}
				}
			}
		}

		for(var1 = 0; var1 < this.f.size(); ++var1) {
			var2 = (BlockLeavesBase)this.f.get(var1);
			if(var2.d > 0) {
				this.e.clear();
				this.e.put(var2.a);
				this.e.position(0).limit(var2.a.length);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, var2.d);
				GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 16, 16, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
				if(wiresProvidePower) {
					for(var3 = 1; var3 <= 4; ++var3) {
						var4 = 16 >> var3 - 1;
						var5 = 16 >> var3;

						for(var6 = 0; var6 < var5; ++var6) {
							for(var7 = 0; var7 < var5; ++var7) {
								var8 = this.e.getInt((var6 * 2 + 0 + (var7 * 2 + 0) * var4) * 4);
								var9 = this.e.getInt((var6 * 2 + 1 + (var7 * 2 + 0) * var4) * 4);
								var10 = this.e.getInt((var6 * 2 + 1 + (var7 * 2 + 1) * var4) * 4);
								var11 = this.e.getInt((var6 * 2 + 0 + (var7 * 2 + 1) * var4) * 4);
								var12 = this.a(this.a(var8, var9), this.a(var10, var11));
								this.e.putInt((var6 + var7 * var5) * 4, var12);
							}
						}

						GL11.glTexSubImage2D(GL11.GL_TEXTURE_2D, var3, 0, 0, var5, var5, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, this.e);
					}
				}
			}
		}

	}

	private int a(int var1, int var2) {
		int var3 = (var1 & 0xFF000000) >> 24 & 255;
		int var4 = (var2 & 0xFF000000) >> 24 & 255;
		return (var3 + var4 >> 1 << 24) + ((var1 & 16711422) + (var2 & 16711422) >> 1);
	}

	private int b(int var1, int var2) {
		int var3 = (var1 & 0xFF000000) >> 24 & 255;
		int var4 = (var2 & 0xFF000000) >> 24 & 255;
		short var5 = 255;
		if(var3 + var4 == 0) {
			var3 = 1;
			var4 = 1;
			var5 = 0;
		}

		int var6 = (var1 >> 16 & 255) * var3;
		int var7 = (var1 >> 8 & 255) * var3;
		int var8 = (var1 & 255) * var3;
		int var9 = (var2 >> 16 & 255) * var4;
		int var10 = (var2 >> 8 & 255) * var4;
		int var11 = (var2 & 255) * var4;
		int var12 = (var6 + var9) / (var3 + var4);
		int var13 = (var7 + var10) / (var3 + var4);
		int var14 = (var8 + var11) / (var3 + var4);
		return var5 << 24 | var12 << 16 | var13 << 8 | var14;
	}

	public void b() {
		Iterator var1 = this.c.keySet().iterator();

		BufferedImage var3;
		while(var1.hasNext()) {
			int var2 = ((Integer)var1.next()).intValue();
			var3 = (BufferedImage)this.c.get(Integer.valueOf(var2));
			this.a(var3, var2);
		}

		TileEntitySignRenderer var6;
		for(var1 = this.g.values().iterator(); var1.hasNext(); var6.d = false) {
			var6 = (TileEntitySignRenderer)var1.next();
		}

		var1 = this.b.keySet().iterator();

		while(var1.hasNext()) {
			String var7 = (String)var1.next();

			try {
				if(var7.startsWith("##")) {
					var3 = this.b(ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var7.substring(2))));
				} else if(var7.startsWith("%%")) {
					this.i = true;
					var3 = ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var7.substring(2)));
					this.i = false;
				} else {
					var3 = ImageIO.read(BlockRedstoneWire.class.getResourceAsStream(var7));
				}

				int var4 = ((Integer)this.b.get(var7)).intValue();
				this.a(var3, var4);
			} catch (IOException var5) {
				var5.printStackTrace();
			}
		}

	}

	public void b(int var1) {
		if(var1 >= 0) {
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, var1);
		}
	}
}
