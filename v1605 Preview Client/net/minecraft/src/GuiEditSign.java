package net.minecraft.src;

public class GuiEditSign extends EntityTNTPrimed {
	public GuiEditSign(int var1) {
		super(var1);
		this.aR = 1;
		this.aS = 64;
	}

	public void b(TileEntityFurnace var1, RecipesIngots var2) {
		if(var2 instanceof mj) {
			mj var3 = (mj)var2;
			if(!var3.a) {
				var3.a = true;
				--var1.a;
			}
		}

	}

	public void a(TileEntityFurnace var1, RecipesIngots var2) {
		this.b(var1, var2);
	}
}
