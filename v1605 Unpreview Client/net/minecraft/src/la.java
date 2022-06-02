package net.minecraft.src;

public class la {
	public ImageBufferDownload[] a;
	public int b;
	private boolean c;

	public la(ImageBufferDownload[] var1) {
		this.b = 0;
		this.c = false;
		this.a = var1;
		this.b = var1.length;
	}

	public la(ImageBufferDownload[] var1, int var2, int var3, int var4, int var5) {
		this(var1);
		float var6 = 0.0015625F;
		float var7 = 0.003125F;
		var1[0] = var1[0].a((float)var4 / 64.0F - var6, (float)var3 / 32.0F + var7);
		var1[1] = var1[1].a((float)var2 / 64.0F + var6, (float)var3 / 32.0F + var7);
		var1[2] = var1[2].a((float)var2 / 64.0F + var6, (float)var5 / 32.0F - var7);
		var1[3] = var1[3].a((float)var4 / 64.0F - var6, (float)var5 / 32.0F - var7);
	}

	public void a() {
		ImageBufferDownload[] var1 = new ImageBufferDownload[this.a.length];

		for(int var2 = 0; var2 < this.a.length; ++var2) {
			var1[var2] = this.a[this.a.length - var2 - 1];
		}

		this.a = var1;
	}

	public void a(NBTTagByteArray var1, float var2) {
		BlockTNT var3 = this.a[1].a.a(this.a[0].a);
		BlockTNT var4 = this.a[1].a.a(this.a[2].a);
		BlockTNT var5 = var4.b(var3).b();
		var1.b();
		if(this.c) {
			var1.b(-((float)var5.a), -((float)var5.b), -((float)var5.c));
		} else {
			var1.b((float)var5.a, (float)var5.b, (float)var5.c);
		}

		for(int var6 = 0; var6 < 4; ++var6) {
			ImageBufferDownload var7 = this.a[var6];
			var1.a((double)((float)var7.a.a * var2), (double)((float)var7.a.b * var2), (double)((float)var7.a.c * var2), (double)var7.b, (double)var7.c);
		}

		var1.a();
	}
}
