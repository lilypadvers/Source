package net.minecraft.src;

import java.util.Random;

public class RenderArrow extends ChunkProviderLoadOrGenerate {
	private Random a = new Random();

	protected RenderArrow(int var1) {
		super(var1, EntitySkeleton.c);
		this.aZ = 26;
	}

	public int a(mz var1, int var2, int var3, int var4, int var5) {
		if(var5 == 1) {
			return this.aZ - 1;
		} else if(var5 == 0) {
			return this.aZ - 1;
		} else {
			int var6 = var1.a(var2, var3, var4 - 1);
			int var7 = var1.a(var2, var3, var4 + 1);
			int var8 = var1.a(var2 - 1, var3, var4);
			int var9 = var1.a(var2 + 1, var3, var4);
			int var10;
			int var11;
			int var12;
			byte var13;
			if(var6 != this.ba && var7 != this.ba) {
				if(var8 != this.ba && var9 != this.ba) {
					byte var14 = 3;
					if(ln.p[var6] && !ln.p[var7]) {
						var14 = 3;
					}

					if(ln.p[var7] && !ln.p[var6]) {
						var14 = 2;
					}

					if(ln.p[var8] && !ln.p[var9]) {
						var14 = 5;
					}

					if(ln.p[var9] && !ln.p[var8]) {
						var14 = 4;
					}

					return var5 == var14?this.aZ + 1:this.aZ;
				} else if(var5 != 4 && var5 != 5) {
					var10 = 0;
					if(var8 == this.ba) {
						var10 = -1;
					}

					var11 = var1.a(var8 == this.ba?var2 - 1:var2 + 1, var3, var4 - 1);
					var12 = var1.a(var8 == this.ba?var2 - 1:var2 + 1, var3, var4 + 1);
					if(var5 == 3) {
						var10 = -1 - var10;
					}

					var13 = 3;
					if((ln.p[var6] || ln.p[var11]) && !ln.p[var7] && !ln.p[var12]) {
						var13 = 3;
					}

					if((ln.p[var7] || ln.p[var12]) && !ln.p[var6] && !ln.p[var11]) {
						var13 = 2;
					}

					return (var5 == var13?this.aZ + 16:this.aZ + 32) + var10;
				} else {
					return this.aZ;
				}
			} else if(var5 != 2 && var5 != 3) {
				var10 = 0;
				if(var6 == this.ba) {
					var10 = -1;
				}

				var11 = var1.a(var2 - 1, var3, var6 == this.ba?var4 - 1:var4 + 1);
				var12 = var1.a(var2 + 1, var3, var6 == this.ba?var4 - 1:var4 + 1);
				if(var5 == 4) {
					var10 = -1 - var10;
				}

				var13 = 5;
				if((ln.p[var8] || ln.p[var11]) && !ln.p[var9] && !ln.p[var12]) {
					var13 = 5;
				}

				if((ln.p[var9] || ln.p[var12]) && !ln.p[var8] && !ln.p[var11]) {
					var13 = 4;
				}

				return (var5 == var13?this.aZ + 16:this.aZ + 32) + var10;
			} else {
				return this.aZ;
			}
		}
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?this.aZ - 1:(var1 == 0?this.aZ - 1:(var1 == 3?this.aZ + 1:this.aZ));
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = 0;
		if(var1.a(var2 - 1, var3, var4) == this.ba) {
			++var5;
		}

		if(var1.a(var2 + 1, var3, var4) == this.ba) {
			++var5;
		}

		if(var1.a(var2, var3, var4 - 1) == this.ba) {
			++var5;
		}

		if(var1.a(var2, var3, var4 + 1) == this.ba) {
			++var5;
		}

		return var5 > 1?false:(this.h(var1, var2 - 1, var3, var4)?false:(this.h(var1, var2 + 1, var3, var4)?false:(this.h(var1, var2, var3, var4 - 1)?false:!this.h(var1, var2, var3, var4 + 1))));
	}

	private boolean h(EntitySpider var1, int var2, int var3, int var4) {
		return var1.a(var2, var3, var4) != this.ba?false:(var1.a(var2 - 1, var3, var4) == this.ba?true:(var1.a(var2 + 1, var3, var4) == this.ba?true:(var1.a(var2, var3, var4 - 1) == this.ba?true:var1.a(var2, var3, var4 + 1) == this.ba)));
	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
		Frustrum var5 = (Frustrum)var1.b(var2, var3, var4);

		for(int var6 = 0; var6 < var5.a(); ++var6) {
			TileEntityFurnace var7 = var5.a_(var6);
			if(var7 != null) {
				float var8 = this.a.nextFloat() * 0.8F + 0.1F;
				float var9 = this.a.nextFloat() * 0.8F + 0.1F;
				float var10 = this.a.nextFloat() * 0.8F + 0.1F;

				while(var7.a > 0) {
					int var11 = this.a.nextInt(21) + 10;
					if(var11 > var7.a) {
						var11 = var7.a;
					}

					var7.a -= var11;
					EffectRenderer var12 = new EffectRenderer(var1, (double)((float)var2 + var8), (double)((float)var3 + var9), (double)((float)var4 + var10), new TileEntityFurnace(var7.c, var11, var7.d));
					float var13 = 0.05F;
					var12.ak = (double)((float)this.a.nextGaussian() * var13);
					var12.al = (double)((float)this.a.nextGaussian() * var13 + 0.2F);
					var12.am = (double)((float)this.a.nextGaussian() * var13);
					var1.a((EntityMinecart)var12);
				}
			}
		}

		super.b(var1, var2, var3, var4);
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4, BlockMobSpawner var5) {
		Object var6 = (Frustrum)var1.b(var2, var3, var4);
		if(var1.g(var2, var3 + 1, var4)) {
			return true;
		} else if(var1.a(var2 - 1, var3, var4) == this.ba && var1.g(var2 - 1, var3 + 1, var4)) {
			return true;
		} else if(var1.a(var2 + 1, var3, var4) == this.ba && var1.g(var2 + 1, var3 + 1, var4)) {
			return true;
		} else if(var1.a(var2, var3, var4 - 1) == this.ba && var1.g(var2, var3 + 1, var4 - 1)) {
			return true;
		} else if(var1.a(var2, var3, var4 + 1) == this.ba && var1.g(var2, var3 + 1, var4 + 1)) {
			return true;
		} else {
			if(var1.a(var2 - 1, var3, var4) == this.ba) {
				var6 = new GuiChest("Large chest", (Frustrum)var1.b(var2 - 1, var3, var4), (WorldIso)var6);
			}

			if(var1.a(var2 + 1, var3, var4) == this.ba) {
				var6 = new GuiChest("Large chest", (WorldIso)var6, (Frustrum)var1.b(var2 + 1, var3, var4));
			}

			if(var1.a(var2, var3, var4 - 1) == this.ba) {
				var6 = new GuiChest("Large chest", (Frustrum)var1.b(var2, var3, var4 - 1), (WorldIso)var6);
			}

			if(var1.a(var2, var3, var4 + 1) == this.ba) {
				var6 = new GuiChest("Large chest", (WorldIso)var6, (Frustrum)var1.b(var2, var3, var4 + 1));
			}

			var5.a((WorldIso)var6);
			return true;
		}
	}

	protected EntityCreature a_() {
		return new Frustrum();
	}
}
