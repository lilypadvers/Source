package net.minecraft.src;

public class Pathfinder extends li {
	private boolean[] e;
	private World f;

	public Pathfinder(World var1) {
		InputHandler.CaptureGamepad();
		this.e = new boolean[10];
		this.f = var1;
	}

	public void a(int var1, boolean var2) {
		byte var3 = -1;
		if(var1 == this.f.j.b) {
			var3 = 0;
		}

		if(var1 == this.f.l.b) {
			var3 = 1;
		}

		if(var1 == this.f.k.b) {
			var3 = 2;
		}

		if(var1 == this.f.m.b) {
			var3 = 3;
		}

		if(var1 == this.f.n.b) {
			var3 = 4;
		}

		if(var3 >= 0) {
			this.e[var3] = var2;
		}

	}

	public void a() {
		for(int var1 = 0; var1 < 10; ++var1) {
			this.e[var1] = false;
		}

	}

	public void a(BlockMobSpawner var1) {
		this.a = 0.0F;
		this.b = 0.0F;
		this.d = this.e[4];
		if(InputHandler.gamepads != null) {
			for(int var2 = 0; var2 != InputHandler.gamepads.length; ++var2) {
				if(InputHandler.gamepads[var2] != null && (InputHandler.gamepads[var2].getXAxisValue() != -1.0F || InputHandler.gamepads[var2].getYAxisValue() != -1.0F)) {
					this.a = -InputHandler.gamepads[var2].getXAxisValue();
					if((double)this.a > -0.15D && (double)this.a < 0.15D) {
						this.a = 0.0F;
					}

					this.b = -InputHandler.gamepads[var2].getYAxisValue();
					if((double)this.b > -0.15D && (double)this.b < 0.15D) {
						this.b = 0.0F;
					}

					if(this.a != 0.0F || this.b != 0.0F) {
						return;
					}
				}
			}
		}

		if(this.e[0]) {
			++this.b;
		}

		if(this.e[1]) {
			--this.b;
		}

		if(this.e[2]) {
			++this.a;
		}

		if(this.e[3]) {
			--this.a;
		}

	}
}
