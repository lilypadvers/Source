package net.minecraft.src;

import java.io.File;

class kz extends EntitySpider {
	final RecipesArmor w;

	kz(RecipesArmor var1, File var2, String var3) {
		super(var2, var3);
		this.w = var1;
	}

	protected BlockButton a(File var1) {
		return new ItemSword(this, new kt(var1, false));
	}
}
