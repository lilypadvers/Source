package net.minecraft.src;

public class ImageBufferDownload {
	public BlockTNT a;
	public float b;
	public float c;

	public ImageBufferDownload(float var1, float var2, float var3, float var4, float var5) {
		this(BlockTNT.a((double)var1, (double)var2, (double)var3), var4, var5);
	}

	public ImageBufferDownload a(float var1, float var2) {
		return new ImageBufferDownload(this, var1, var2);
	}

	public ImageBufferDownload(ImageBufferDownload var1, float var2, float var3) {
		this.a = var1.a;
		this.b = var2;
		this.c = var3;
	}

	public ImageBufferDownload(BlockTNT var1, float var2, float var3) {
		this.a = var1;
		this.b = var2;
		this.c = var3;
	}
}
