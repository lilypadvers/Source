package net.minecraft.src;

import java.awt.Canvas;
import net.minecraft.client.MinecraftApplet;

public class NBTTagLong extends Canvas {
	final MinecraftApplet a;

	public NBTTagLong(MinecraftApplet var1) {
		this.a = var1;
	}

	public synchronized void addNotify() {
		super.addNotify();
		this.a.startMainThread();
	}

	public synchronized void removeNotify() {
		this.a.shutdown();
		super.removeNotify();
	}
}
