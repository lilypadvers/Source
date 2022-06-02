package net.minecraft.src;

public class MCHashTable {
	private transient InventoryCraftResult[] a = new InventoryCraftResult[16];
	private transient int count;
	private int threshold = 12;
	private final float growFactor = 0.75F;
	private transient volatile int versionStamp;

	private static int computeHash(int var0) {
		var0 ^= var0 >>> 20 ^ var0 >>> 12;
		return var0 ^ var0 >>> 7 ^ var0 >>> 4;
	}

	private static int getSlotIndex(int var0, int var1) {
		return var0 & var1 - 1;
	}

	public Object lookup(int var1) {
		int var2 = computeHash(var1);

		for(InventoryCraftResult var3 = this.a[getSlotIndex(var2, this.a.length)]; var3 != null; var3 = var3.c) {
			if(var3.a == var1) {
				return var3.b;
			}
		}

		return null;
	}

	public void addKey(int var1, Object var2) {
		int var3 = computeHash(var1);
		int var4 = getSlotIndex(var3, this.a.length);

		for(InventoryCraftResult var5 = this.a[var4]; var5 != null; var5 = var5.c) {
			if(var5.a == var1) {
				var5.b = var2;
			}
		}

		++this.versionStamp;
		this.insert(var3, var1, var2, var4);
	}

	private void grow(int var1) {
		InventoryCraftResult[] var2 = this.a;
		int var3 = var2.length;
		if(var3 == 1073741824) {
			this.threshold = Integer.MAX_VALUE;
		} else {
			InventoryCraftResult[] var4 = new InventoryCraftResult[var1];
			this.a(var4);
			this.a = var4;
			this.threshold = (int)((float)var1 * this.growFactor);
		}
	}

	private void a(InventoryCraftResult[] var1) {
		InventoryCraftResult[] var2 = this.a;
		int var3 = var1.length;

		for(int var4 = 0; var4 < var2.length; ++var4) {
			InventoryCraftResult var5 = var2[var4];
			if(var5 != null) {
				var2[var4] = null;

				InventoryCraftResult var6;
				do {
					var6 = var5.c;
					int var7 = getSlotIndex(var5.d, var3);
					var5.c = var1[var7];
					var1[var7] = var5;
					var5 = var6;
				} while(var6 != null);
			}
		}

	}

	public Object removeObject(int var1) {
		InventoryCraftResult var2 = this.c(var1);
		return var2 == null?null:var2.b;
	}

	final InventoryCraftResult c(int var1) {
		int var2 = computeHash(var1);
		int var3 = getSlotIndex(var2, this.a.length);
		InventoryCraftResult var4 = this.a[var3];

		InventoryCraftResult var5;
		InventoryCraftResult var6;
		for(var5 = var4; var5 != null; var5 = var6) {
			var6 = var5.c;
			if(var5.a == var1) {
				++this.versionStamp;
				--this.count;
				if(var4 == var5) {
					this.a[var3] = var6;
				} else {
					var4.c = var6;
				}

				return var5;
			}

			var4 = var5;
		}

		return var5;
	}

	public void clearMap() {
		++this.versionStamp;
		InventoryCraftResult[] var1 = this.a;

		for(int var2 = 0; var2 < var1.length; ++var2) {
			var1[var2] = null;
		}

		this.count = 0;
	}

	private void insert(int var1, int var2, Object var3, int var4) {
		InventoryCraftResult var5 = this.a[var4];
		this.a[var4] = new InventoryCraftResult(var1, var2, var3, var5);
		if(this.count++ >= this.threshold) {
			this.grow(2 * this.a.length);
		}

	}

	static int getHash(int var0) {
		return computeHash(var0);
	}
}
