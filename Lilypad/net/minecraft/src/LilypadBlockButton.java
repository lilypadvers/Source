package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class LilypadBlockButton extends GuiButton {
	public int bID;
	public GuiScreen caller;

	public LilypadBlockButton(int var1, int var2, int var3, String var4, int var5, GuiScreen var6) {
		super(var1, var2, var3, 25, 20, var4);
		this.bID = var5;
		this.caller = var6;
	}

	public void drawButton(Minecraft minecraft, int mouseX, int mouseY) {
		if(this.f) {
			FontRenderer var4 = minecraft.fontRenderer;
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, minecraft.renderEngine.getTexture("/gui/GUICREA.png"));
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			byte var5 = 1;
			boolean var6 = mouseX >= this.width && mouseY >= this.height && mouseX < this.width + this.g && mouseY < this.height + this.h;
			if(!this.e) {
				var5 = 0;
			} else if(var6) {
				var5 = 2;
			}

			this.drawTexturedModalRect(this.width, this.height, 0, 46 + var5 * 20, this.g / 2, this.h);
			this.drawTexturedModalRect(this.width + this.g / 2, this.height, 200 - this.g / 2, 46 + var5 * 20, this.g / 2, this.h);
			if(!this.e) {
				this.drawCenteredString(var4, this.c, this.width + this.g / 2, this.height + (this.h - 8) / 2, -6250336);
			} else if(var6) {
				this.drawCenteredString(var4, this.c, this.width + this.g / 2, this.height + (this.h - 8) / 2, 16777120);
			} else {
				this.drawCenteredString(var4, this.c, this.width + this.g / 2, this.height + (this.h - 8) / 2, 14737632);
			}

		}
	}
}
