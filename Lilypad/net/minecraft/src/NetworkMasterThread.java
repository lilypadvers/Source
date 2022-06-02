package net.minecraft.src;

class NetworkMasterThread extends Thread {
	final NetworkManager netManager;

	NetworkMasterThread(NetworkManager var1, String var2) {
		super(var2);
		this.netManager = var1;
	}

	public void run() {
		Object var1 = NetworkManager.threadSyncObject;
		synchronized(NetworkManager.threadSyncObject) {
			++NetworkManager.numReadThreads;
		}

		while(true) {
			boolean var11 = false;

			try {
				var11 = true;
				if(NetworkManager.isRunning(this.netManager)) {
					if(!NetworkManager.isServerTerminating(this.netManager)) {
						NetworkManager.readNetworkPacket(this.netManager);
						continue;
					}

					var11 = false;
					break;
				}

				var11 = false;
				break;
			} finally {
				if(var11) {
					Object var5 = NetworkManager.threadSyncObject;
					synchronized(NetworkManager.threadSyncObject) {
						--NetworkManager.numReadThreads;
					}
				}
			}
		}

		var1 = NetworkManager.threadSyncObject;
		synchronized(NetworkManager.threadSyncObject) {
			--NetworkManager.numReadThreads;
		}
	}
}
