package net.minecraft.src;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ScreenInputPass extends CanvasIsomPreview {
	private CanvasIsomPreview a;
	private int h = 0;
	private String i = "";
	private net.minecraft.client.Minecraft b;
	private String starStr = "";
	private String einval = "";

	public ScreenInputPass(net.minecraft.client.Minecraft var1) {
		this.b = var1;
	}

	public void g() {
		++this.h;
	}

	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 96 + 12, "Input"));
		((EntitySplashFX)this.e.get(0)).e = false;
	}

	public static String byteArrayToHex(byte[] var0) {
		StringBuilder var1 = new StringBuilder(var0.length * 2);
		byte[] var2 = var0;
		int var3 = var0.length;

		for(int var4 = 0; var4 < var3; ++var4) {
			byte var5 = var2[var4];
			var1.append(String.format("%02x", new Object[]{Byte.valueOf(var5)}));
		}

		return var1.toString();
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d == 1) {
				System.exit(0);
			} else if(var1.d == 0) {
				try {
					MessageDigest var2 = MessageDigest.getInstance("SHA-256");
					MessageDigest var3 = MessageDigest.getInstance("MD5");
					byte[] var4 = var2.digest(this.i.getBytes(StandardCharsets.UTF_8));
					byte[] var5 = var3.digest(this.i.getBytes(StandardCharsets.UTF_8));
					if(byteArrayToHex(var4).equals("0c2e1872ba4be8417a6038529e229bbfb896749e7300a3370de4ed17e82d6878") && byteArrayToHex(var5).equals("294d7b5b76709e6ab569bf53d34900ef")) {
						this.b.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
					} else if(byteArrayToHex(var4).equals("540a6a11447be05a9c19a11c01895776294aea4c6f17be34484acd8769563630") && byteArrayToHex(var5).equals("ebb48915824d862ed6c32b3ccd0842da")) {
						try {
							Class.forName("InputHandler");
							InputHandler.cheatsEnabled = true;
							System.out.println("Cheats enabled");
							this.einval = "Cheats enabled";
						} catch (ClassNotFoundException var7) {
							System.out.println("Failed to enable cheats");
							this.einval = "Failed to enable cheats";
						}
					} else {
						this.einval = "Invalid key";
					}
				} catch (NoSuchAlgorithmException var8) {
					this.einval = "An error has occurred.";
				}
			}

		}
	}

	private void MakeStarStr() {
		this.starStr = "";
		char[] var1 = this.i.toCharArray();
		int var2 = var1.length;

		for(int var3 = 0; var3 < var2; ++var3) {
			char var10000 = var1[var3];
			this.starStr = this.starStr + "*";
		}

	}

	protected void a(char var1, int var2) {
		if(var1 == 22) {
			String var3 = CanvasIsomPreview.c();
			if(var3 == null) {
				var3 = "";
			}

			int var4 = 32 - this.i.length();
			if(var4 > var3.length()) {
				var4 = var3.length();
			}

			if(var4 > 0) {
				this.i = this.i + var3.substring(0, var4);
			}
		}

		if(var1 == 13) {
			this.a((EntitySplashFX)this.e.get(0));
		}

		if(var2 == 14 && this.i.length() > 0) {
			this.i = this.i.substring(0, this.i.length() - 1);
		}

		if(" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???\u00ae\u00ac???\u00ab\u00bb".indexOf(var1) >= 0 && this.i.length() < 32) {
			this.i = this.i + var1;
		}

		((EntitySplashFX)this.e.get(0)).e = this.i.length() > 0;
		this.MakeStarStr();
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, "Input key", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
		this.b(this.g, "You should have received a key", this.c / 2 - 140, this.d / 4 - 60 + 60 + 0, 10526880);
		this.b(this.g, "with your copy of Unrestricted Preview 2.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 9, 10526880);
		this.b(this.g, "If you didn\'t, please contact 0", this.c / 2 - 140, this.d / 4 - 60 + 60 + 18, 10526880);
		this.b(this.g, "Enter it here:", this.c / 2 - 140, this.d / 4 - 60 + 60 + 40, 10526880);
		int var4 = this.c / 2 - 100;
		int var5 = this.d / 4 - 10 + 50 + 18;
		this.a(var4 - 1, var5 - 1, var4 + 200 + 1, var5 + 20 + 1, -6250336);
		this.a(var4, var5, var4 + 200, var5 + 20, 0xFF000000);
		this.b(this.g, this.starStr + (this.h / 6 % 2 == 0?"_":""), var4 + 4, var5 + 6, 14737632);
		this.b(this.g, this.einval, this.c / 2 - 70, this.d / 4 - 60 + 60 + 90, 16711680);
		super.a(var1, var2, var3);
	}
}
