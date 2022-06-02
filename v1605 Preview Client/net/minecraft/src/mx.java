package net.minecraft.src;

class mx extends Thread {
	final MouseHelper a;

	mx(MouseHelper var1, String var2) {
		super(var2);
		this.a = var1;
	}

	public void run() {
		Object var1 = MouseHelper.a;
		synchronized(MouseHelper.a) {
			++MouseHelper.c;
		}

		while(true) {
			boolean var11 = false;

			try {
				var11 = true;
				if(!MouseHelper.a(this.a)) {
					var11 = false;
					break;
				}

				MouseHelper.d(this.a);
			} finally {
				if(var11) {
					Object var5 = MouseHelper.a;
					synchronized(MouseHelper.a) {
						--MouseHelper.c;
					}
				}
			}
		}

		var1 = MouseHelper.a;
		synchronized(MouseHelper.a) {
			--MouseHelper.c;
		}
	}
}
