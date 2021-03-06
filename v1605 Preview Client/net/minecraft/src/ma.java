package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

class ma {
	private EntitySpider b;
	private int c;
	private int d;
	private int e;
	private int f;
	private List g;
	final TextureWaterFX a;

	public ma(TextureWaterFX var1, EntitySpider var2, int var3, int var4, int var5) {
		this.a = var1;
		this.g = new ArrayList();
		this.b = var2;
		this.c = var3;
		this.d = var4;
		this.e = var5;
		this.f = var2.e(var3, var4, var5);
		this.a();
	}

	private void a() {
		this.g.clear();
		if(this.f == 0) {
			this.g.add(new mh(this.c, this.d, this.e - 1));
			this.g.add(new mh(this.c, this.d, this.e + 1));
		} else if(this.f == 1) {
			this.g.add(new mh(this.c - 1, this.d, this.e));
			this.g.add(new mh(this.c + 1, this.d, this.e));
		} else if(this.f == 2) {
			this.g.add(new mh(this.c - 1, this.d, this.e));
			this.g.add(new mh(this.c + 1, this.d + 1, this.e));
		} else if(this.f == 3) {
			this.g.add(new mh(this.c - 1, this.d + 1, this.e));
			this.g.add(new mh(this.c + 1, this.d, this.e));
		} else if(this.f == 4) {
			this.g.add(new mh(this.c, this.d + 1, this.e - 1));
			this.g.add(new mh(this.c, this.d, this.e + 1));
		} else if(this.f == 5) {
			this.g.add(new mh(this.c, this.d, this.e - 1));
			this.g.add(new mh(this.c, this.d + 1, this.e + 1));
		} else if(this.f == 6) {
			this.g.add(new mh(this.c + 1, this.d, this.e));
			this.g.add(new mh(this.c, this.d, this.e + 1));
		} else if(this.f == 7) {
			this.g.add(new mh(this.c - 1, this.d, this.e));
			this.g.add(new mh(this.c, this.d, this.e + 1));
		} else if(this.f == 8) {
			this.g.add(new mh(this.c - 1, this.d, this.e));
			this.g.add(new mh(this.c, this.d, this.e - 1));
		} else if(this.f == 9) {
			this.g.add(new mh(this.c + 1, this.d, this.e));
			this.g.add(new mh(this.c, this.d, this.e - 1));
		}

	}

	private void b() {
		for(int var1 = 0; var1 < this.g.size(); ++var1) {
			ma var2 = this.a((mh)this.g.get(var1));
			if(var2 != null && var2.b(this)) {
				this.g.set(var1, new mh(var2.c, var2.d, var2.e));
			} else {
				this.g.remove(var1--);
			}
		}

	}

	private boolean a(int var1, int var2, int var3) {
		return this.b.a(var1, var2, var3) == this.a.ba?true:(this.b.a(var1, var2 + 1, var3) == this.a.ba?true:this.b.a(var1, var2 - 1, var3) == this.a.ba);
	}

	private ma a(mh var1) {
		return this.b.a(var1.a, var1.b, var1.c) == this.a.ba?new ma(this.a, this.b, var1.a, var1.b, var1.c):(this.b.a(var1.a, var1.b + 1, var1.c) == this.a.ba?new ma(this.a, this.b, var1.a, var1.b + 1, var1.c):(this.b.a(var1.a, var1.b - 1, var1.c) == this.a.ba?new ma(this.a, this.b, var1.a, var1.b - 1, var1.c):null));
	}

	private boolean b(ma var1) {
		for(int var2 = 0; var2 < this.g.size(); ++var2) {
			mh var3 = (mh)this.g.get(var2);
			if(var3.a == var1.c && var3.c == var1.e) {
				return true;
			}
		}

		return false;
	}

	private boolean b(int var1, int var2, int var3) {
		for(int var4 = 0; var4 < this.g.size(); ++var4) {
			mh var5 = (mh)this.g.get(var4);
			if(var5.a == var1 && var5.c == var3) {
				return true;
			}
		}

		return false;
	}

	private int c() {
		int var1 = 0;
		if(this.a(this.c, this.d, this.e - 1)) {
			++var1;
		}

		if(this.a(this.c, this.d, this.e + 1)) {
			++var1;
		}

		if(this.a(this.c - 1, this.d, this.e)) {
			++var1;
		}

		if(this.a(this.c + 1, this.d, this.e)) {
			++var1;
		}

		return var1;
	}

	private boolean c(ma var1) {
		if(this.b(var1)) {
			return true;
		} else if(this.g.size() == 2) {
			return false;
		} else if(this.g.size() == 0) {
			return true;
		} else {
			mh var2 = (mh)this.g.get(0);
			return var1.d == this.d && var2.b == this.d?true:true;
		}
	}

	private void d(ma var1) {
		this.g.add(new mh(var1.c, var1.d, var1.e));
		boolean var2 = this.b(this.c, this.d, this.e - 1);
		boolean var3 = this.b(this.c, this.d, this.e + 1);
		boolean var4 = this.b(this.c - 1, this.d, this.e);
		boolean var5 = this.b(this.c + 1, this.d, this.e);
		byte var6 = -1;
		if(var2 || var3) {
			var6 = 0;
		}

		if(var4 || var5) {
			var6 = 1;
		}

		if(var3 && var5 && !var2 && !var4) {
			var6 = 6;
		}

		if(var3 && var4 && !var2 && !var5) {
			var6 = 7;
		}

		if(var2 && var4 && !var3 && !var5) {
			var6 = 8;
		}

		if(var2 && var5 && !var3 && !var4) {
			var6 = 9;
		}

		if(var6 == 0) {
			if(this.b.a(this.c, this.d + 1, this.e - 1) == this.a.ba) {
				var6 = 4;
			}

			if(this.b.a(this.c, this.d + 1, this.e + 1) == this.a.ba) {
				var6 = 5;
			}
		}

		if(var6 == 1) {
			if(this.b.a(this.c + 1, this.d + 1, this.e) == this.a.ba) {
				var6 = 2;
			}

			if(this.b.a(this.c - 1, this.d + 1, this.e) == this.a.ba) {
				var6 = 3;
			}
		}

		if(var6 < 0) {
			var6 = 0;
		}

		this.b.b(this.c, this.d, this.e, var6);
	}

	private boolean c(int var1, int var2, int var3) {
		ma var4 = this.a(new mh(var1, var2, var3));
		if(var4 == null) {
			return false;
		} else {
			var4.b();
			return var4.c(this);
		}
	}

	public void a(boolean var1) {
		boolean var2 = this.c(this.c, this.d, this.e - 1);
		boolean var3 = this.c(this.c, this.d, this.e + 1);
		boolean var4 = this.c(this.c - 1, this.d, this.e);
		boolean var5 = this.c(this.c + 1, this.d, this.e);
		byte var6 = -1;
		if((var2 || var3) && !var4 && !var5) {
			var6 = 0;
		}

		if((var4 || var5) && !var2 && !var3) {
			var6 = 1;
		}

		if(var3 && var5 && !var2 && !var4) {
			var6 = 6;
		}

		if(var3 && var4 && !var2 && !var5) {
			var6 = 7;
		}

		if(var2 && var4 && !var3 && !var5) {
			var6 = 8;
		}

		if(var2 && var5 && !var3 && !var4) {
			var6 = 9;
		}

		if(var6 == -1) {
			if(var2 || var3) {
				var6 = 0;
			}

			if(var4 || var5) {
				var6 = 1;
			}

			if(var1) {
				if(var3 && var5) {
					var6 = 6;
				}

				if(var4 && var3) {
					var6 = 7;
				}

				if(var5 && var2) {
					var6 = 9;
				}

				if(var2 && var4) {
					var6 = 8;
				}
			} else {
				if(var2 && var4) {
					var6 = 8;
				}

				if(var5 && var2) {
					var6 = 9;
				}

				if(var4 && var3) {
					var6 = 7;
				}

				if(var3 && var5) {
					var6 = 6;
				}
			}
		}

		if(var6 == 0) {
			if(this.b.a(this.c, this.d + 1, this.e - 1) == this.a.ba) {
				var6 = 4;
			}

			if(this.b.a(this.c, this.d + 1, this.e + 1) == this.a.ba) {
				var6 = 5;
			}
		}

		if(var6 == 1) {
			if(this.b.a(this.c + 1, this.d + 1, this.e) == this.a.ba) {
				var6 = 2;
			}

			if(this.b.a(this.c - 1, this.d + 1, this.e) == this.a.ba) {
				var6 = 3;
			}
		}

		if(var6 < 0) {
			var6 = 0;
		}

		this.f = var6;
		this.a();
		this.b.b(this.c, this.d, this.e, var6);

		for(int var7 = 0; var7 < this.g.size(); ++var7) {
			ma var8 = this.a((mh)this.g.get(var7));
			if(var8 != null) {
				var8.b();
				if(var8.c(this)) {
					var8.d(this);
				}
			}
		}

	}

	static int a(ma var0) {
		return var0.c();
	}
}
