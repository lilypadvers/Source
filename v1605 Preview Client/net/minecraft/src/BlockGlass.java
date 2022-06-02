package net.minecraft.src;

import java.util.Random;

public class BlockGlass extends ln {
	protected BlockGlass(int var1, EntitySkeleton var2) {
		super(var1, var2);
		this.aZ = 97;
		if(var2 == EntitySkeleton.e) {
			++this.aZ;
		}

		float var3 = 0.5F;
		float var4 = 1.0F;
		this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
	}

	public int a(int var1, int var2) {
		if(var1 != 0 && var1 != 1) {
			int var3 = this.c(var2);
			if((var3 == 0 || var3 == 2) ^ var1 <= 3) {
				return this.aZ;
			} else {
				int var4 = var3 / 2 + (var1 & 1 ^ var3);
				var4 += (var2 & 4) / 4;
				int var5 = this.aZ - (var2 & 8) * 2;
				if((var4 & 1) != 0) {
					var5 = -var5;
				}

				return var5;
			}
		} else {
			return this.aZ;
		}
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public int f() {
		return 7;
	}

	public EntityRenderer f(EntitySpider var1, int var2, int var3, int var4) {
		this.a((mz)var1, var2, var3, var4);
		return super.f(var1, var2, var3, var4);
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		this.a((mz)var1, var2, var3, var4);
		return super.d(var1, var2, var3, var4);
	}

	public void a(mz var1, int var2, int var3, int var4) {
		this.b(this.c(var1.e(var2, var3, var4)));
	}

	public void b(int var1) {
		float var2 = 0.1875F;
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		if(var1 == 0) {
			this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
		}

		if(var1 == 1) {
			this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}

		if(var1 == 2) {
			this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
		}

		if(var1 == 3) {
			this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
		}

	}

	public void b(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		this.a(var1, var2, var3, var4, var5);
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		if(this.bl == EntitySkeleton.e) {
			return true;
		} else {
			int var6 = var1.e(var2, var3, var4);
			if((var6 & 8) != 0) {
				if(var1.a(var2, var3 - 1, var4) == this.ba) {
					this.a(var1, var2, var3 - 1, var4, var5);
				}

				return true;
			} else {
				if(var1.a(var2, var3 + 1, var4) == this.ba) {
					var1.b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
				}

				var1.b(var2, var3, var4, var6 ^ 4);
				var1.b(var2, var3 - 1, var4, var2, var3, var4);
				if(Math.random() < 0.5D) {
					var1.a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.door_open", 1.0F, var1.m.nextFloat() * 0.1F + 0.9F);
				} else {
					var1.a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.door_close", 1.0F, var1.m.nextFloat() * 0.1F + 0.9F);
				}

				return true;
			}
		}
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, boolean var5) {
		int var6 = var1.e(var2, var3, var4);
		if((var6 & 8) != 0) {
			if(var1.a(var2, var3 - 1, var4) == this.ba) {
				this.a(var1, var2, var3 - 1, var4, var5);
			}

		} else {
			boolean var7 = (var1.e(var2, var3, var4) & 4) > 0;
			if(var7 != var5) {
				if(var1.a(var2, var3 + 1, var4) == this.ba) {
					var1.b(var2, var3 + 1, var4, (var6 ^ 4) + 8);
				}

				var1.b(var2, var3, var4, var6 ^ 4);
				var1.b(var2, var3 - 1, var4, var2, var3, var4);
				if(Math.random() < 0.5D) {
					var1.a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.door_open", 1.0F, var1.m.nextFloat() * 0.1F + 0.9F);
				} else {
					var1.a((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "random.door_close", 1.0F, var1.m.nextFloat() * 0.1F + 0.9F);
				}

			}
		}
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		int var6 = var1.e(var2, var3, var4);
		if((var6 & 8) != 0) {
			if(var1.a(var2, var3 - 1, var4) != this.ba) {
				var1.d(var2, var3, var4, 0);
			}

			if(var5 > 0 && ln.n[var5].d()) {
				this.a(var1, var2, var3 - 1, var4, var5);
			}
		} else {
			boolean var7 = false;
			if(var1.a(var2, var3 + 1, var4) != this.ba) {
				var1.d(var2, var3, var4, 0);
				var7 = true;
			}

			if(!var1.g(var2, var3 - 1, var4)) {
				var1.d(var2, var3, var4, 0);
				var7 = true;
				if(var1.a(var2, var3 + 1, var4) == this.ba) {
					var1.d(var2, var3 + 1, var4, 0);
				}
			}

			if(var7) {
				this.b_(var1, var2, var3, var4, var6);
			} else if(var5 > 0 && ln.n[var5].d()) {
				boolean var8 = var1.p(var2, var3, var4) || var1.p(var2, var3 + 1, var4);
				this.a(var1, var2, var3, var4, var8);
			}
		}

	}

	public int a(int var1, Random var2) {
		return (var1 & 8) != 0?0:(this.bl == EntitySkeleton.e?EntityTNTPrimed.az.aQ:EntityTNTPrimed.at.aQ);
	}

	public lv a(EntitySpider var1, int var2, int var3, int var4, BlockTNT var5, BlockTNT var6) {
		this.a((mz)var1, var2, var3, var4);
		return super.a(var1, var2, var3, var4, var5, var6);
	}

	public int c(int var1) {
		return (var1 & 4) == 0?var1 - 1 & 3:var1 & 3;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return var3 >= 127?false:var1.g(var2, var3 - 1, var4) && super.a(var1, var2, var3, var4) && super.a(var1, var2, var3 + 1, var4);
	}
}
