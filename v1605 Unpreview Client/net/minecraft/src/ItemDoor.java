package net.minecraft.src;

import java.util.Random;

public class ItemDoor extends EntityFX {
	int a = 0;
	boolean[] b = new boolean[4];
	int[] c = new int[4];

	protected ItemDoor(int var1, EntitySkeleton var2) {
		super(var1, var2);
	}

	private void j(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4);
		var1.a(var2, var3, var4, this.ba + 1, var5);
		var1.b(var2, var3, var4, var2, var3, var4);
		var1.h(var2, var3, var4);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		int var6 = this.h(var1, var2, var3, var4);
		boolean var7 = true;
		int var9;
		if(var6 > 0) {
			byte var8 = -100;
			this.a = 0;
			int var11 = this.f(var1, var2 - 1, var3, var4, var8);
			var11 = this.f(var1, var2 + 1, var3, var4, var11);
			var11 = this.f(var1, var2, var3, var4 - 1, var11);
			var11 = this.f(var1, var2, var3, var4 + 1, var11);
			var9 = var11 + this.d;
			if(var9 >= 8 || var11 < 0) {
				var9 = -1;
			}

			if(this.h(var1, var2, var3 + 1, var4) >= 0) {
				int var10 = this.h(var1, var2, var3 + 1, var4);
				if(var10 >= 8) {
					var9 = var10;
				} else {
					var9 = var10 + 8;
				}
			}

			if(this.a >= 2 && this.bl == EntitySkeleton.f) {
				if(var1.g(var2, var3 - 1, var4)) {
					var9 = 0;
				} else if(var1.f(var2, var3 - 1, var4) == this.bl && var1.e(var2, var3, var4) == 0) {
					var9 = 0;
				}
			}

			if(this.bl == EntitySkeleton.g && var6 < 8 && var9 < 8 && var9 > var6 && var5.nextInt(4) != 0) {
				var9 = var6;
				var7 = false;
			}

			if(var9 != var6) {
				var6 = var9;
				if(var9 < 0) {
					var1.d(var2, var3, var4, 0);
				} else {
					var1.b(var2, var3, var4, var9);
					var1.h(var2, var3, var4, this.ba);
					var1.g(var2, var3, var4, this.ba);
				}
			} else if(var7) {
				this.j(var1, var2, var3, var4);
			}
		} else {
			this.j(var1, var2, var3, var4);
		}

		if(this.m(var1, var2, var3 - 1, var4)) {
			if(var6 >= 8) {
				var1.b(var2, var3 - 1, var4, this.ba, var6);
			} else {
				var1.b(var2, var3 - 1, var4, this.ba, var6 + 8);
			}
		} else if(var6 >= 0 && (var6 == 0 || this.l(var1, var2, var3 - 1, var4))) {
			boolean[] var12 = this.k(var1, var2, var3, var4);
			var9 = var6 + this.d;
			if(var6 >= 8) {
				var9 = 1;
			}

			if(var9 >= 8) {
				return;
			}

			if(var12[0]) {
				this.g(var1, var2 - 1, var3, var4, var9);
			}

			if(var12[1]) {
				this.g(var1, var2 + 1, var3, var4, var9);
			}

			if(var12[2]) {
				this.g(var1, var2, var3, var4 - 1, var9);
			}

			if(var12[3]) {
				this.g(var1, var2, var3, var4 + 1, var9);
			}
		}

	}

	private void g(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(this.m(var1, var2, var3, var4)) {
			int var6 = var1.a(var2, var3, var4);
			if(var6 > 0) {
				if(this.bl == EntitySkeleton.g) {
					this.i(var1, var2, var3, var4);
				} else {
					ln.n[var6].b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
				}
			}

			var1.b(var2, var3, var4, this.ba, var5);
		}

	}

	private int a(EntitySpider var1, int var2, int var3, int var4, int var5, int var6) {
		int var7 = 1000;

		for(int var8 = 0; var8 < 4; ++var8) {
			if((var8 != 0 || var6 != 1) && (var8 != 1 || var6 != 0) && (var8 != 2 || var6 != 3) && (var8 != 3 || var6 != 2)) {
				int var9 = var2;
				int var11 = var4;
				if(var8 == 0) {
					var9 = var2 - 1;
				}

				if(var8 == 1) {
					++var9;
				}

				if(var8 == 2) {
					var11 = var4 - 1;
				}

				if(var8 == 3) {
					++var11;
				}

				if(!this.l(var1, var9, var3, var11) && (var1.f(var9, var3, var11) != this.bl || var1.e(var9, var3, var11) != 0)) {
					if(!this.l(var1, var9, var3 - 1, var11)) {
						return var5;
					}

					if(var5 < 4) {
						int var12 = this.a(var1, var9, var3, var11, var5 + 1, var8);
						if(var12 < var7) {
							var7 = var12;
						}
					}
				}
			}
		}

		return var7;
	}

	private boolean[] k(EntitySpider var1, int var2, int var3, int var4) {
		int var5;
		int var6;
		for(var5 = 0; var5 < 4; ++var5) {
			this.c[var5] = 1000;
			var6 = var2;
			int var8 = var4;
			if(var5 == 0) {
				var6 = var2 - 1;
			}

			if(var5 == 1) {
				++var6;
			}

			if(var5 == 2) {
				var8 = var4 - 1;
			}

			if(var5 == 3) {
				++var8;
			}

			if(!this.l(var1, var6, var3, var8) && (var1.f(var6, var3, var8) != this.bl || var1.e(var6, var3, var8) != 0)) {
				if(!this.l(var1, var6, var3 - 1, var8)) {
					this.c[var5] = 0;
				} else {
					this.c[var5] = this.a(var1, var6, var3, var8, 1, var5);
				}
			}
		}

		var5 = this.c[0];

		for(var6 = 1; var6 < 4; ++var6) {
			if(this.c[var6] < var5) {
				var5 = this.c[var6];
			}
		}

		for(var6 = 0; var6 < 4; ++var6) {
			this.b[var6] = this.c[var6] == var5;
		}

		return this.b;
	}

	private boolean l(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.a(var2, var3, var4);
		if(var5 != ln.aE.ba && var5 != ln.aL.ba && var5 != ln.aD.ba && var5 != ln.aF.ba && var5 != ln.aX.ba) {
			if(var5 == 0) {
				return false;
			} else {
				EntitySkeleton var6 = ln.n[var5].bl;
				return var6.a();
			}
		} else {
			return true;
		}
	}

	protected int f(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = this.h(var1, var2, var3, var4);
		if(var6 < 0) {
			return var5;
		} else {
			if(var6 == 0) {
				++this.a;
			}

			if(var6 >= 8) {
				var6 = 0;
			}

			return var5 >= 0 && var6 >= var5?var5:var6;
		}
	}

	private boolean m(EntitySpider var1, int var2, int var3, int var4) {
		EntitySkeleton var5 = var1.f(var2, var3, var4);
		return var5 == this.bl?false:(var5 == EntitySkeleton.g?false:!this.l(var1, var2, var3, var4));
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
		super.e(var1, var2, var3, var4);
		if(var1.a(var2, var3, var4) == this.ba) {
			var1.h(var2, var3, var4, this.ba);
		}

	}
}
