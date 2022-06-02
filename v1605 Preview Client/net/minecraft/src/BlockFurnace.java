package net.minecraft.src;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class BlockFurnace extends WindowAdapter {
	final net.minecraft.client.Minecraft a;
	final Thread b;

	public BlockFurnace(net.minecraft.client.Minecraft var1, Thread var2) {
		this.a = var1;
		this.b = var2;
	}

	public void windowClosing(WindowEvent var1) {
		this.a.d();

		try {
			this.b.join();
		} catch (InterruptedException var3) {
			var3.printStackTrace();
		}

		System.exit(0);
	}
}
