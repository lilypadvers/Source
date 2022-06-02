package net.minecraft.src;

class mu extends Thread {
	final MouseHelper a;

	mu(MouseHelper var1) {
		this.a = var1;
	}

	public void run() {
		try {
			Thread.sleep(5000L);
			if(MouseHelper.e(this.a).isAlive()) {
				try {
					MouseHelper.e(this.a).stop();
				} catch (Throwable var3) {
				}
			}

			if(MouseHelper.f(this.a).isAlive()) {
				try {
					MouseHelper.f(this.a).stop();
				} catch (Throwable var2) {
				}
			}
		} catch (InterruptedException var4) {
			var4.printStackTrace();
		}

	}
}
