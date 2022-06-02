package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.lwjgl.input.Keyboard;

public class World {
	private static final String[] x = new String[]{"FAR", "NORMAL", "SHORT", "TINY"};
	private static final String[] y = new String[]{"Peaceful", "Easy", "Normal", "Hard"};
	public boolean a = true;
	public boolean b = true;
	public boolean c = false;
	public boolean editingBlocks = false;
	public int e = 0;
	public boolean f = true;
	public boolean g = false;
	public boolean h = false;
	public boolean i = true;
	public RenderEngine j = new RenderEngine("Forward", 17);
	public RenderEngine k = new RenderEngine("Left", 30);
	public RenderEngine l = new RenderEngine("Back", 31);
	public RenderEngine m = new RenderEngine("Right", 32);
	public RenderEngine n = new RenderEngine("Jump", 57);
	public RenderEngine o = new RenderEngine("Inventory", 23);
	public RenderEngine p = new RenderEngine("Drop", 16);
	public RenderEngine q = new RenderEngine("Chat", 20);
	public RenderEngine r = new RenderEngine("Toggle fog", 33);
	public RenderEngine[] s = new RenderEngine[]{this.j, this.k, this.l, this.m, this.n, this.p, this.o, this.q, this.r};
	protected net.minecraft.client.Minecraft t;
	private File z;
	public int u = 10;
	public int v = 2;
	public boolean w = false;

	public World(net.minecraft.client.Minecraft var1, File var2) {
		this.t = var1;
		this.z = new File(var2, "options.txt");
		this.setSpawnLocation();
	}

	public World() {
	}

	public String a(int var1) {
		return this.s[var1].a + ": " + Keyboard.getKeyName(this.s[var1].b);
	}

	public void a(int var1, int var2) {
		this.s[var1].b = var2;
		this.spawnPlayerWithLoadedChunks();
	}

	public void b(int var1, int var2) {
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
			this.editingBlocks = !this.editingBlocks;
		}

		if(var1 == 4) {
			this.e = this.e + var2 & 3;
		}

		if(var1 == 5) {
			this.f = !this.f;
		}

		if(var1 == 6) {
			this.g = !this.g;
			this.t.n.b();
		}

		if(var1 == 7) {
			this.h = !this.h;
		}

		if(var1 == 8) {
			this.v = this.v + var2 & 3;
		}

		if(var1 == 9) {
			this.i = !this.i;
			this.t.f.a();
		}

		this.spawnPlayerWithLoadedChunks();
	}

	public String b(int var1) {
		return var1 == 0?"Music: " + (this.a?"ON":"OFF"):(var1 == 1?"Sound: " + (this.b?"ON":"OFF"):(var1 == 2?"Invert mouse: " + (this.c?"ON":"OFF"):(var1 == 3?"Show FPS: " + (this.editingBlocks?"ON":"OFF"):(var1 == 4?"Render distance: " + x[this.e]:(var1 == 5?"View bobbing: " + (this.f?"ON":"OFF"):(var1 == 6?"3d anaglyph: " + (this.g?"ON":"OFF"):(var1 == 7?"Limit framerate: " + (this.h?"ON":"OFF"):(var1 == 8?"Difficulty: " + y[this.v]:(var1 == 9?"Graphics: " + (this.i?"FANCY":"FAST"):"")))))))));
	}

	public void setSpawnLocation() {
		try {
			if(!this.z.exists()) {
				return;
			}

			BufferedReader var1 = new BufferedReader(new FileReader(this.z));
			String var2 = "";

			while((var2 = var1.readLine()) != null) {
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
					this.editingBlocks = var3[1].equals("true");
				}

				if(var3[0].equals("viewDistance")) {
					this.e = Integer.parseInt(var3[1]);
				}

				if(var3[0].equals("bobView")) {
					this.f = var3[1].equals("true");
				}

				if(var3[0].equals("anaglyph3d")) {
					this.g = var3[1].equals("true");
				}

				if(var3[0].equals("limitFramerate")) {
					this.h = var3[1].equals("true");
				}

				if(var3[0].equals("difficulty")) {
					this.v = Integer.parseInt(var3[1]);
				}

				if(var3[0].equals("fancyGraphics")) {
					this.i = var3[1].equals("true");
				}

				for(int var4 = 0; var4 < this.s.length; ++var4) {
					if(var3[0].equals("key_" + this.s[var4].a)) {
						this.s[var4].b = Integer.parseInt(var3[1]);
					}
				}
			}

			var1.close();
		} catch (Exception var5) {
			System.out.println("Failed to load options");
			var5.printStackTrace();
		}

	}

	public void spawnPlayerWithLoadedChunks() {
		try {
			PrintWriter var1 = new PrintWriter(new FileWriter(this.z));
			var1.println("music:" + this.a);
			var1.println("sound:" + this.b);
			var1.println("invertYMouse:" + this.c);
			var1.println("showFrameRate:" + this.editingBlocks);
			var1.println("viewDistance:" + this.e);
			var1.println("bobView:" + this.f);
			var1.println("anaglyph3d:" + this.g);
			var1.println("limitFramerate:" + this.h);
			var1.println("difficulty:" + this.v);
			var1.println("fancyGraphics:" + this.i);

			for(int var2 = 0; var2 < this.s.length; ++var2) {
				var1.println("key_" + this.s[var2].a + ":" + this.s[var2].b);
			}

			var1.close();
		} catch (Exception var3) {
			System.out.println("Failed to save options");
			var3.printStackTrace();
		}

	}
}
