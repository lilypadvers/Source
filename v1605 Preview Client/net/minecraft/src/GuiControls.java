package net.minecraft.src;

import java.util.Random;

public class GuiControls extends Explosion {
	public GuiControls(int var1, int var2) {
		super(var1, var2);
	}

	public int a(int var1, Random var2) {
		return var2.nextInt(10) == 0?EntityTNTPrimed.an.aQ:this.ba;
	}
}
