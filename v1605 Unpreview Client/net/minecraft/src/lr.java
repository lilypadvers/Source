package net.minecraft.src;

public class lr extends IsoImageBuffer {
	public lr(EntitySpider var1) {
		super(var1);
		this.u = "/mob/zombie.png";
		this.Y = 0.5F;
		this.e = 5;
	}

	public void i() {
		super.i();
	}

	protected String c() {
		return "mob.zombie";
	}

	protected String d() {
		return "mob.zombiehurt";
	}

	protected String e() {
		return "mob.zombiedeath";
	}

	protected int g() {
		return EntityTNTPrimed.J.aQ;
	}
}
