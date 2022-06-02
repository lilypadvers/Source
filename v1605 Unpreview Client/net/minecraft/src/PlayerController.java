package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class PlayerController extends ln {
	private GameSettings a;

	protected PlayerController(int var1, int var2, GameSettings var3) {
		super(var1, var2, EntitySkeleton.d);
		this.a = var3;
		this.b(true);
		float var4 = 0.0625F;
		this.a(var4, 0.0F, var4, 1.0F - var4, 0.03125F, 1.0F - var4);
	}

	public int a() {
		return 20;
	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		return null;
	}

	public boolean b() {
		return false;
	}

	public boolean c() {
		return false;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return var1.g(var2, var3 - 1, var4);
	}

	public void e(EntitySpider var1, int var2, int var3, int var4) {
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		boolean var6 = false;
		if(!var1.g(var2, var3 - 1, var4)) {
			var6 = true;
		}

		if(var6) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.e(var2, var3, var4) != 0) {
			this.h(var1, var2, var3, var4);
		}
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5) {
		if(var1.e(var2, var3, var4) != 1) {
			this.h(var1, var2, var3, var4);
		}
	}

	private void h(EntitySpider var1, int var2, int var3, int var4) {
		boolean var5 = var1.e(var2, var3, var4) == 1;
		boolean var6 = false;
		float var7 = 0.125F;
		List var8 = null;
		if(this.a == GameSettings.a) {
			var8 = var1.b((EntityMinecart)null, (EntityRenderer)EntityRenderer.b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
		}

		if(this.a == GameSettings.b) {
			var8 = var1.a(RecipesIngots.class, EntityRenderer.b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
		}

		if(this.a == GameSettings.c) {
			var8 = var1.a(BlockMobSpawner.class, EntityRenderer.b((double)((float)var2 + var7), (double)var3, (double)((float)var4 + var7), (double)((float)(var2 + 1) - var7), (double)var3 + 0.25D, (double)((float)(var4 + 1) - var7)));
		}

		if(var8.size() > 0) {
			var6 = true;
		}

		if(var6 && !var5) {
			var1.b(var2, var3, var4, 1);
			var1.g(var2, var3, var4, this.ba);
			var1.g(var2, var3 - 1, var4, this.ba);
			var1.b(var2, var3, var4, var2, var3, var4);
			var1.a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.6F);
		}

		if(!var6 && var5) {
			var1.b(var2, var3, var4, 0);
			var1.g(var2, var3, var4, this.ba);
			var1.g(var2, var3 - 1, var4, this.ba);
			var1.b(var2, var3, var4, var2, var3, var4);
			var1.a((double)var2 + 0.5D, (double)var3 + 0.1D, (double)var4 + 0.5D, "random.click", 0.3F, 0.5F);
		}

		if(var6) {
			var1.h(var2, var3, var4, this.ba);
		}

	}

	public void b(EntitySpider var1, int var2, int var3, int var4) {
		int var5 = var1.e(var2, var3, var4);
		if(var5 > 0) {
			var1.g(var2, var3, var4, this.ba);
			var1.g(var2, var3 - 1, var4, this.ba);
		}

		super.b(var1, var2, var3, var4);
	}

	public void a(mz var1, int var2, int var3, int var4) {
		boolean var5 = var1.e(var2, var3, var4) == 1;
		float var6 = 0.0625F;
		if(var5) {
			this.a(var6, 0.0F, var6, 1.0F - var6, 0.03125F, 1.0F - var6);
		} else {
			this.a(var6, 0.0F, var6, 1.0F - var6, 0.0625F, 1.0F - var6);
		}

	}

	public boolean b(mz var1, int var2, int var3, int var4, int var5) {
		return var1.e(var2, var3, var4) > 0;
	}

	public boolean c(EntitySpider var1, int var2, int var3, int var4, int var5) {
		return var1.e(var2, var3, var4) == 0?false:var5 == 1;
	}

	public boolean d() {
		return true;
	}

	public void e() {
		float var1 = 0.5F;
		float var2 = 0.125F;
		float var3 = 0.5F;
		this.a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
	}
}
