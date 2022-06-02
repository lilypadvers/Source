package net.minecraft.src;

class PlayerControllerMP extends Thread {
	final NetworkManager a;

	PlayerControllerMP(NetworkManager var1, String var2) {
		super(var2);
		this.a = var1;
	}

	public void run() {
		Object var1 = NetworkManager.threadSyncObject;
		synchronized(NetworkManager.threadSyncObject) {
			++NetworkManager.numWriteThreads;
		}

		while(true) {
			boolean var11 = false;

			try {
				var11 = true;
				if(!NetworkManager.isRunning(this.a)) {
					var11 = false;
					break;
				}

				NetworkManager.sendNetworkPacket(this.a);
			} finally {
				if(var11) {
					Object var5 = NetworkManager.threadSyncObject;
					synchronized(NetworkManager.threadSyncObject) {
						--NetworkManager.numWriteThreads;
					}
				}
			}
		}

		var1 = NetworkManager.threadSyncObject;
		synchronized(NetworkManager.threadSyncObject) {
			--NetworkManager.numWriteThreads;
		}
	}
}
