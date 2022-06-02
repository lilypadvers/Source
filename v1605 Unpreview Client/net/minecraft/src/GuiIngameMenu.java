package net.minecraft.src;

public class GuiIngameMenu extends EntityTNTPrimed {
	public GuiIngameMenu(int var1) {
		super(var1);
		this.aR = 16;
	}

	public TileEntityFurnace a(TileEntityFurnace var1, EntitySpider var2, BlockMobSpawner var3) {
		--var1.a;
		var2.a(var3, "random.bow", 0.5F, 0.4F / (b.nextFloat() * 0.4F + 0.8F));
		var2.a((EntityMinecart)(new StepSoundGlass(var2, var3)));
		return var1;
	}
}
