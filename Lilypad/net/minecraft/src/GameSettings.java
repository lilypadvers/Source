package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class GameSettings {
	private static final String[] x = new String[]{"FAR", "NORMAL", "SHORT", "TINY"};
	private static final String[] RENDER_DISTANCES = new String[]{"Peaceful", "Easy", "Normal", "Hard", "Frail"};
	public boolean a = true;
	public boolean b = true;
	public boolean c = false;
	public boolean invertMouse = false;
	public int renderDistance = 0;
	public boolean viewBobbing = true;
	public boolean anaglyph = false;
	public boolean limitFramerate = false;
	public boolean fancyGraphics = true;
	public KeyBinding keyBindForward = new KeyBinding("Forward", Keyboard.KEY_W);
	public KeyBinding keyBindLeft = new KeyBinding("Left", Keyboard.KEY_A);
	public KeyBinding keyBindBack = new KeyBinding("Back", Keyboard.KEY_S);
	public KeyBinding keyBindRight = new KeyBinding("Right", Keyboard.KEY_D);
	public KeyBinding keyBindJump = new KeyBinding("Jump", Keyboard.KEY_SPACE);
	public KeyBinding keyBindInventory = new KeyBinding("Inventory", Keyboard.KEY_I);
	public KeyBinding keyBindDrop = new KeyBinding("Drop", Keyboard.KEY_Q);
	public KeyBinding keyBindChat = new KeyBinding("Chat", Keyboard.KEY_T);
	public KeyBinding keyBindToggleFog = new KeyBinding("Toggle fog", Keyboard.KEY_F);
	public KeyBinding[] s = new KeyBinding[]{this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindToggleFog};
	protected Minecraft t;
	private File z;
	public int u = 10;
	public int numberOfOptions = 2;
	public boolean w = false;

	public GameSettings(Minecraft minecraft, File file) {
		this.t = minecraft;
		this.z = new File(file, "options.txt");
		this.loadOptions();
	}

	public GameSettings() {
	}

	public String getKeyBindingDescription(int var1) {
		return this.s[var1].keyDescription + ": " + Keyboard.getKeyName(this.s[var1].keyCode);
	}

	public void setKeyBinding(int var1, int var2) {
		this.s[var1].keyCode = var2;
		this.saveOptions();
	}

	public void setOptionValue(int var1, int var2) {
		if(var1 == 0) {
			this.a = !this.a;
			this.t.A.a();
		}

		if(var1 == 1) {
			this.b = !this.b;
			this.t.A.a();
		}

		if(var1 == 2) {
			this.c = !this.c;
		}

		if(var1 == 3) {
			this.invertMouse = !this.invertMouse;
		}

		if(var1 == 4) {
			this.renderDistance = this.renderDistance + var2 & 3;
		}

		if(var1 == 5) {
			this.viewBobbing = !this.viewBobbing;
		}

		if(var1 == 6) {
			this.anaglyph = !this.anaglyph;
			this.t.renderEngine.refreshTextures();
		}

		if(var1 == 7) {
			this.limitFramerate = !this.limitFramerate;
		}

		if(var1 == 8) {
			this.numberOfOptions = (this.numberOfOptions + var2) % 5;
		}

		if(var1 == 9) {
			this.fancyGraphics = !this.fancyGraphics;
			this.t.renderGlobal.loadRenderers();
		}

		this.saveOptions();
	}

	public String b(int var1) {
		return var1 == 0?"Music: " + (this.a?"ON":"OFF"):(var1 == 1?"Sound: " + (this.b?"ON":"OFF"):(var1 == 2?"Invert mouse: " + (this.c?"ON":"OFF"):(var1 == 3?"Show FPS: " + (this.invertMouse?"ON":"OFF"):(var1 == 4?"Render distance: " + x[this.renderDistance]:(var1 == 5?"View bobbing: " + (this.viewBobbing?"ON":"OFF"):(var1 == 6?"3d anaglyph: " + (this.anaglyph?"ON":"OFF"):(var1 == 7?"Limit framerate: " + (this.limitFramerate?"ON":"OFF"):(var1 == 8?"Difficulty: " + RENDER_DISTANCES[this.numberOfOptions]:(var1 == 9?"Graphics: " + (this.fancyGraphics?"FANCY":"FAST"):"")))))))));
	}

	public void loadOptions() {
		try {
			if(!this.z.exists()) {
				return;
			}

			BufferedReader var1 = new BufferedReader(new FileReader(this.z));

			String var2;
			while((var2 = var1.readLine()) != null) {
				if(!var2.startsWith("#")) {
					String[] var3 = var2.split(":");
					if(var3[0].equals("music")) {
						this.a = var3[1].equals("true");
					}

					if(var3[0].equals("sound")) {
						this.b = var3[1].equals("true");
					}

					if(var3[0].equals("invertYMouse")) {
						this.c = var3[1].equals("true");
					}

					if(var3[0].equals("showFrameRate")) {
						this.invertMouse = var3[1].equals("true");
					}

					if(var3[0].equals("viewDistance")) {
						this.renderDistance = Integer.parseInt(var3[1]);
					}

					if(var3[0].equals("bobView")) {
						this.viewBobbing = var3[1].equals("true");
					}

					if(var3[0].equals("anaglyph3d")) {
						this.anaglyph = var3[1].equals("true");
					}

					if(var3[0].equals("limitFramerate")) {
						this.limitFramerate = var3[1].equals("true");
					}

					if(var3[0].equals("a1605ext_difficulty")) {
						this.numberOfOptions = Integer.parseInt(var3[1]);
					}

					if(var3[0].equals("a1605ext_gamepadSens")) {
						InputHandler.lookSens = Integer.parseInt(var3[1]);
					}

					if(var3[0].equals("fancyGraphics")) {
						this.fancyGraphics = var3[1].equals("true");
					}

					for(int var4 = 0; var4 < this.s.length; ++var4) {
						if(var3[0].equals("key_" + this.s[var4].keyDescription)) {
							this.s[var4].keyCode = Integer.parseInt(var3[1]);
						}
					}
				}
			}

			var1.close();
		} catch (Exception var5) {
			System.out.println("Failed to load options");
			var5.printStackTrace();
		}

	}

	public void saveOptions() {
		try {
			PrintWriter var1 = new PrintWriter(new FileWriter(this.z));
			var1.println("music:" + this.a);
			var1.println("sound:" + this.b);
			var1.println("invertYMouse:" + this.c);
			var1.println("showFrameRate:" + this.invertMouse);
			var1.println("viewDistance:" + this.renderDistance);
			var1.println("difficulty:" + Math.min(this.numberOfOptions, 3));
			var1.println("bobView:" + this.viewBobbing);
			var1.println("anaglyph3d:" + this.anaglyph);
			var1.println("limitFramerate:" + this.limitFramerate);
			var1.println("fancyGraphics:" + this.fancyGraphics);
			var1.println("# Settings below are specific to 1605 extension.");
			var1.println("a1605ext_difficulty:" + this.numberOfOptions);
			var1.println("a1605ext_gamepadSens:" + InputHandler.lookSens);

			for(int var2 = 0; var2 < this.s.length; ++var2) {
				var1.println("key_" + this.s[var2].keyDescription + ":" + this.s[var2].keyCode);
			}

			var1.close();
		} catch (Exception var3) {
			System.out.println("Failed to save options");
			var3.printStackTrace();
		}

	}
}
