package net.minecraft.src;

public class GuiControls extends GuiScreen {
	private GuiScreen parentScreen;
	protected String screenTitle = "Controls";
	private GameSettings options;
	private int buttonId = -1;

	public GuiControls(GuiScreen prevScreen, GameSettings gameSettings) {
		this.parentScreen = prevScreen;
		this.options = gameSettings;
	}

	public void initGui() {
		for(int var1 = 0; var1 < this.options.s.length; ++var1) {
			this.controlList.add(new GuiSmallButton(var1, this.width / 2 - 155 + var1 % 2 * 160, this.height / 6 + 24 * (var1 >> 1), this.options.getKeyBindingDescription(var1)));
		}

		this.controlList.add(new GuiButton(201, this.width / 2 - 100, this.height / 6 + 140, "Gamepad sensitivity: " + InputHandler.lookSens));
		this.controlList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, "Done"));
	}

	protected void actionPerformed(GuiButton button) {
		for(int var2 = 0; var2 < this.options.s.length; ++var2) {
			((GuiButton)this.controlList.get(var2)).c = this.options.getKeyBindingDescription(var2);
		}

		if(button.yPosition == 200) {
			this.mc.displayGuiScreen(this.parentScreen);
		} else if(button.yPosition == 201) {
			++InputHandler.lookSens;
			if(InputHandler.lookSens == 11) {
				InputHandler.lookSens = 1;
			}

			button.c = "Gamepad sensitivity: " + InputHandler.lookSens;
		} else {
			this.buttonId = button.yPosition;
			button.c = "> " + this.options.getKeyBindingDescription(button.yPosition) + " <";
		}

	}

	protected void keyTyped(char character, int key) {
		if(this.buttonId >= 0) {
			this.options.setKeyBinding(this.buttonId, key);
			((GuiButton)this.controlList.get(this.buttonId)).c = this.options.getKeyBindingDescription(this.buttonId);
			this.buttonId = -1;
		} else {
			super.keyTyped(character, key);
		}

	}

	public void drawScreen(int mouseX, int mouseY, float renderPartialTick) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 20, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, renderPartialTick);
	}
}
