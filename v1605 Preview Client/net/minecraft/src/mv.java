package net.minecraft.src;

class mv extends Thread {
	final MouseHelper a;

	mv(MouseHelper var1, String var2) {
		super(var2);
		this.a = var1;
	}

	public void run() {
		Object var1 = MouseHelper.a;
		synchronized(MouseHelper.a) {
			++MouseHelper.deltaY;
		}

		while(true) {
			boolean var11 = false;

			try {
				var11 = true;
				if(MouseHelper.a(this.a)) {
					if(!MouseHelper.b(this.a)) {
						MouseHelper.c(this.a);
						continue;
					}

					var11 = false;
					break;
				}

				var11 = false;
				break;
			} finally {
				if(var11) {
					Object var5 = MouseHelper.a;
					synchronized(MouseHelper.a) {
						--MouseHelper.deltaY;
					}
				}
			}
		}

		var1 = MouseHelper.a;
		synchronized(MouseHelper.a) {
			--MouseHelper.deltaY;
		}
	}
}
