package net.minecraft.src;

public class WorldGenMinable {
	private RenderEntity[] a = new RenderEntity[1024];
	private int numberOfBlocks = 0;

	public RenderEntity a(RenderEntity var1) {
		if(var1.e >= 0) {
			throw new IllegalStateException("OW KNOWS!");
		} else {
			if(this.numberOfBlocks == this.a.length) {
				RenderEntity[] var2 = new RenderEntity[this.numberOfBlocks << 1];
				System.arraycopy(this.a, 0, var2, 0, this.numberOfBlocks);
				this.a = var2;
			}

			this.a[this.numberOfBlocks] = var1;
			var1.e = this.numberOfBlocks;
			this.a(this.numberOfBlocks++);
			return var1;
		}
	}

	public void a() {
		this.numberOfBlocks = 0;
	}

	public RenderEntity b() {
		RenderEntity var1 = this.a[0];
		this.a[0] = this.a[--this.numberOfBlocks];
		this.a[this.numberOfBlocks] = null;
		if(this.numberOfBlocks > 0) {
			this.b(0);
		}

		var1.e = -1;
		return var1;
	}

	public void a(RenderEntity var1, float var2) {
		float var3 = var1.h;
		var1.h = var2;
		if(var2 < var3) {
			this.a(var1.e);
		} else {
			this.b(var1.e);
		}

	}

	private void a(int var1) {
		RenderEntity var2 = this.a[var1];

		int var4;
		for(float var3 = var2.h; var1 > 0; var1 = var4) {
			var4 = var1 - 1 >> 1;
			RenderEntity var5 = this.a[var4];
			if(var3 >= var5.h) {
				break;
			}

			this.a[var1] = var5;
			var5.e = var1;
		}

		this.a[var1] = var2;
		var2.e = var1;
	}

	private void b(int var1) {
		RenderEntity var2 = this.a[var1];
		float var3 = var2.h;

		while(true) {
			int var4 = 1 + (var1 << 1);
			int var5 = var4 + 1;
			if(var4 >= this.numberOfBlocks) {
				break;
			}

			RenderEntity var6 = this.a[var4];
			float var7 = var6.h;
			RenderEntity var8;
			float var9;
			if(var5 >= this.numberOfBlocks) {
				var8 = null;
				var9 = Float.POSITIVE_INFINITY;
			} else {
				var8 = this.a[var5];
				var9 = var8.h;
			}

			if(var7 < var9) {
				if(var7 >= var3) {
					break;
				}

				this.a[var1] = var6;
				var6.e = var1;
				var1 = var4;
			} else {
				if(var9 >= var3) {
					break;
				}

				this.a[var1] = var8;
				var8.e = var1;
				var1 = var5;
			}
		}

		this.a[var1] = var2;
		var2.e = var1;
	}

	public boolean c() {
		return this.numberOfBlocks == 0;
	}
}
