package net.minecraft.src;

public abstract class TileEntitySpecialRenderer {
	protected TileEntityRenderer tileEntityRenderer;

	public abstract void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8);

	protected void bindTextureByName(String name) {
		RenderEngine var2 = this.tileEntityRenderer.renderEngine;
		var2.bindTexture(var2.getTexture(name));
	}

	public void setTileEntityRenderer(TileEntityRenderer tileEntityRenderer) {
		this.tileEntityRenderer = tileEntityRenderer;
	}

	public FontRenderer getFontRenderer() {
		return this.tileEntityRenderer.getFontRenderer();
	}
}
