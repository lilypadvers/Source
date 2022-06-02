package net.minecraft.src;

class BlockSponge extends Thread {
	final NetworkManager a;

	BlockSponge(NetworkManager var1) {
		this.a = var1;
	}

	public void run() {
		try {
			Thread.sleep(5000L);
			if(NetworkManager.getReadThread(this.a).isAlive()) {
				try {
					NetworkManager.getReadThread(this.a).stop();
				} catch (Throwable var3) {
				}
			}

			if(NetworkManager.getWriteThread(this.a).isAlive()) {
				try {
					NetworkManager.getWriteThread(this.a).stop();
				} catch (Throwable var2) {
				}
			}
		} catch (InterruptedException var4) {
			var4.printStackTrace();
		}

	}
}
