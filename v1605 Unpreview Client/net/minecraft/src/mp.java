package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;

class mp extends Thread {
	final net.minecraft.client.Minecraft a;
	final String b;
	final int c;
	final mc d;

	mp(mc var1, net.minecraft.client.Minecraft var2, String var3, int var4) {
		this.d = var1;
		this.a = var2;
		this.b = var3;
		this.c = var4;
	}

	public void run() {
		try {
			mc.a(this.d, new MovementInput(this.a, this.b, this.c));
			if(mc.a(this.d)) {
				return;
			}

			mc.b(this.d).a((ItemAxe)(new BlockSign(this.a.i.b)));
		} catch (UnknownHostException var2) {
			if(mc.a(this.d)) {
				return;
			}

			this.a.a((CanvasIsomPreview)(new KeyBinding("Failed to connect to the server", "Unknown host \'" + this.b + "\'")));
		} catch (ConnectException var3) {
			if(mc.a(this.d)) {
				return;
			}

			this.a.a((CanvasIsomPreview)(new KeyBinding("Failed to connect to the server", var3.getMessage())));
		} catch (Exception var4) {
			if(mc.a(this.d)) {
				return;
			}

			var4.printStackTrace();
			this.a.a((CanvasIsomPreview)(new KeyBinding("Failed to connect to the server", var4.toString())));
		}

	}
}
