package net.minecraft.client;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.NBTTagLong;
import net.minecraft.src.UnexpectedThrowable;

public class MinecraftApplet extends Applet {
	private Canvas mcCanvas;
	private Minecraft b;
	private Thread mcThread = null;

	public void init() {
		this.mcCanvas = new NBTTagLong(this);
		boolean var1 = false;
		if(this.getParameter("fullscreen") != null) {
			var1 = this.getParameter("fullscreen").equalsIgnoreCase("true");
		}

		this.b = new UnexpectedThrowable(this, this, this.mcCanvas, this, this.getWidth(), this.getHeight(), var1);
		this.b.j = this.getDocumentBase().getHost();
		if(this.getDocumentBase().getPort() > 0) {
			this.b.j = this.b.j + ":" + this.getDocumentBase().getPort();
		}

		if(this.getParameter("username") != null && this.getParameter("sessionid") != null) {
			this.b.i = new EntityPlayerSP(this.getParameter("username"), this.getParameter("sessionid"));
			System.out.println("Setting user: " + this.b.i.b + ", " + this.b.i.c);
			if(this.getParameter("mppass") != null) {
				this.b.i.d = this.getParameter("mppass");
			}
		} else {
			this.b.i = new EntityPlayerSP("Player", "");
		}

		if(this.getParameter("loadmap_user") != null && this.getParameter("loadmap_id") != null) {
			this.b.s = this.getParameter("loadmap_user");
			this.b.t = Integer.parseInt(this.getParameter("loadmap_id"));
		} else if(this.getParameter("server") != null && this.getParameter("port") != null) {
			this.b.a(this.getParameter("server"), Integer.parseInt(this.getParameter("port")));
		}

		this.b.l = true;
		this.setLayout(new BorderLayout());
		this.add(this.mcCanvas, "Center");
		this.mcCanvas.setFocusable(true);
		this.validate();
	}

	public void startMainThread() {
		if(this.mcThread == null) {
			this.mcThread = new Thread(this.b, "Minecraft main thread");
			this.mcThread.start();
		}
	}

	public void start() {
		if(this.b != null) {
			this.b.m = false;
		}

	}

	public void stop() {
		if(this.b != null) {
			this.b.m = true;
		}

	}

	public void destroy() {
		this.shutdown();
	}

	public void shutdown() {
		if(this.mcThread != null) {
			this.b.d();

			try {
				this.mcThread.join(10000L);
			} catch (InterruptedException var4) {
				try {
					this.b.c();
				} catch (Exception var3) {
					var3.printStackTrace();
				}
			}

			this.mcThread = null;
		}
	}

	public void clearApplet() {
		this.mcCanvas = null;
		this.b = null;
		this.mcThread = null;

		try {
			this.removeAll();
			this.validate();
		} catch (Exception var2) {
		}

	}
}
