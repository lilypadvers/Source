package net.minecraft.src;

import java.util.Random;

public class GuiContainer extends ln {
	protected GuiContainer(int var1, int var2) {
		super(var1, var2, EntitySkeleton.u);
		this.b(true);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, Random var5) {
		if(var1.a(var2, var3 + 1, var4) == 0) {
			int var6;
			for(var6 = 1; var1.a(var2, var3 - var6, var4) == this.ba; ++var6) {
			}

			if(var6 < 3) {
				int var7 = var1.e(var2, var3, var4);
				if(var7 == 15) {
					var1.d(var2, var3 + 1, var4, this.ba);
					var1.b(var2, var3, var4, 0);
				} else {
					var1.b(var2, var3, var4, var7 + 1);
				}
			}
		}

	}

	public EntityRenderer d(EntitySpider var1, int var2, int var3, int var4) {
		float var5 = 0.0625F;
		return EntityRenderer.b((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)((float)(var3 + 1) - var5), (double)((float)(var4 + 1) - var5));
	}

	public EntityRenderer f(EntitySpider var1, int var2, int var3, int var4) {
		float var5 = 0.0625F;
		return EntityRenderer.b((double)((float)var2 + var5), (double)var3, (double)((float)var4 + var5), (double)((float)(var2 + 1) - var5), (double)(var3 + 1), (double)((float)(var4 + 1) - var5));
	}

	public int getGLCallListForPass(int var1) {
		return var1 == 1?this.aZ - 1:(var1 == 0?this.aZ + 1:this.aZ);
	}

	public boolean c() {
		return false;
	}

	public boolean b() {
		return false;
	}

	public int f() {
		return 13;
	}

	public boolean a(EntitySpider var1, int var2, int var3, int var4) {
		return !super.a(var1, var2, var3, var4)?false:this.g(var1, var2, var3, var4);
	}

	public void a(EntitySpider var1, int var2, int var3, int var4, int var5) {
		if(!this.g(var1, var2, var3, var4)) {
			this.b_(var1, var2, var3, var4, var1.e(var2, var3, var4));
			var1.d(var2, var3, var4, 0);
		}

	}

	public boolean g(EntitySpider var1, int var2, int var3, int var4) {
		if(var1.f(var2 - 1, var3, var4).a()) {
			return false;
		} else if(var1.f(var2 + 1, var3, var4).a()) {
			return false;
		} else if(var1.f(var2, var3, var4 - 1).a()) {
			return false;
		} else if(var1.f(var2, var3, var4 + 1).a()) {
			return false;
		} else {
			int var5 = var1.a(var2, var3 - 1, var4);
			return var5 == ln.aV.ba || var5 == ln.E.ba;
		}
	}

	public void b(EntitySpider var1, int var2, int var3, int var4, EntityMinecart var5) {
		var5.a((EntityMinecart)null, 1);
	}
}
