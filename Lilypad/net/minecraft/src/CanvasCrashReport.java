package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;

class CanvasCrashReport extends Thread {
	final Minecraft a;
	final String b;
	final int c;
	final GuiConnecting d;

	CanvasCrashReport(GuiConnecting var1, Minecraft var2, String var3, int var4) {
		this.d = var1;
		this.a = var2;
		this.b = var3;
		this.c = var4;
	}

	public void run() {
		try {
			GuiConnecting.setNetClientHandler(this.d, new NetClientHandler(this.a, this.b, this.c));
			if(GuiConnecting.isCancelled(this.d)) {
				return;
			}

			GuiConnecting.getNetClientHandler(this.d).addToSendQueue(new Packet2Handshake(this.a.session.username));
		} catch (UnknownHostException var2) {
			if(GuiConnecting.isCancelled(this.d)) {
				return;
			}

			this.a.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", "Unknown host \'" + this.b + "\'"));
		} catch (ConnectException var3) {
			if(GuiConnecting.isCancelled(this.d)) {
				return;
			}

			this.a.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", var3.getMessage()));
		} catch (Exception var4) {
			if(GuiConnecting.isCancelled(this.d)) {
				return;
			}

			var4.printStackTrace();
			this.a.displayGuiScreen(new GuiConnectFailed("Failed to connect to the server", var4.toString()));
		}

	}
}
