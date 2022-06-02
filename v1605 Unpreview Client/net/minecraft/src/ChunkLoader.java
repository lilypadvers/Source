package net.minecraft.src;

public class ChunkLoader extends CanvasIsomPreview {
	private CanvasIsomPreview a;
	private int h = 0;
	private String i = "";

	public ChunkLoader(CanvasIsomPreview var1) {
		this.a = var1;
	}

	public void g() {
		++this.h;
	}

	public void a() {
		this.e.clear();
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 96 + 12, "Connect"));
		this.e.add(new EntitySplashFX(1, this.c / 2 - 100, this.d / 4 + 120 + 12, "Cancel"));
		((EntitySplashFX)this.e.get(0)).e = false;
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d == 1) {
				this.b.a(this.a);
			} else if(var1.d == 0) {
				String[] var2 = this.i.split(":");
				this.b.a((CanvasIsomPreview)(new mc(this.b, var2[0], var2.length > 1?Integer.parseInt(var2[1]):25565)));
			}

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

		if(" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(var1) >= 0 && this.i.length() < 32) {
			this.i = this.i + var1;
		}

		((EntitySplashFX)this.e.get(0)).e = this.i.length() > 0;
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, "Play Multiplayer", this.c / 2, this.d / 4 - 60 + 20, 0xFFFFFF);
		this.b(this.g, "Minecraft Multiplayer is currently not finished, but there", this.c / 2 - 140, this.d / 4 - 60 + 60 + 0, 10526880);
		this.b(this.g, "is some buggy early testing going on.", this.c / 2 - 140, this.d / 4 - 60 + 60 + 9, 10526880);
		this.b(this.g, "Enter the IP of a server to connect to it:", this.c / 2 - 140, this.d / 4 - 60 + 60 + 36, 10526880);
		int var4 = this.c / 2 - 100;
		int var5 = this.d / 4 - 10 + 50 + 18;
		short var6 = 200;
		byte var7 = 20;
		this.a(var4 - 1, var5 - 1, var4 + var6 + 1, var5 + var7 + 1, -6250336);
		this.a(var4, var5, var4 + var6, var5 + var7, 0xFF000000);
		this.b(this.g, this.i + (this.h / 6 % 2 == 0?"_":""), var4 + 4, var5 + (var7 - 8) / 2, 14737632);
		super.a(var1, var2, var3);
	}
}
