package net.minecraft.src;

public class ChunkProviderIso extends Thread {
	final net.minecraft.client.Minecraft a;

	public ChunkProviderIso(net.minecraft.client.Minecraft var1, String var2) {
		super(var2);
		this.a = var1;
		this.setDaemon(true);
		this.start();
	}

	public void run() {
		while(this.a.F) {
			try {
				Thread.sleep(2147483647L);
			} catch (InterruptedException var2) {
			}
		}

	}
}
