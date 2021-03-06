package net.minecraft.src;

public class GuiErrorScreen extends GuiScreen {
	private String title;
	private String text;

	public void initGui() {
	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawGradientRect(0, 0, this.width, this.height, -12574688, -11530224);
		this.drawCenteredString(this.fontRenderer, this.title, this.width / 2, 90, 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, this.text, this.width / 2, 110, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}

	protected void keyTyped(char character, int key) {
	}
}
