package net.minecraft.src;

class kw extends Thread {
	final RecipesArmor a;

	kw(RecipesArmor var1) {
		this.a = var1;
	}

	public void run() {
		while(RecipesArmor.a(this.a)) {
			this.a.d();

			try {
				Thread.sleep(1L);
			} catch (Exception var2) {
			}
		}

	}
}
