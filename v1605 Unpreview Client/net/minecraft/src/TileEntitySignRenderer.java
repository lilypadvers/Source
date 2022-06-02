package net.minecraft.src;

import java.awt.image.BufferedImage;

public class TileEntitySignRenderer {
	public BufferedImage a;
	public int b = 1;
	public int c = -1;
	public boolean d = false;

	public TileEntitySignRenderer(String var1, TerrainTextureManager var2) {
		(new ko(this, var1, var2)).start();
	}
}
