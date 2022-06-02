package net.minecraft.src;

public class lr extends IsoImageBuffer {
	public lr(EntitySpider var1) {
		super(var1);
		this.u = "/mob/zombie.png";
		this.Y = 0.5F;
		this.e = 5;
	}

	public void i() {
		if(this.ad.b()) {
			float var1 = this.a(1.0F);
			if(var1 > 0.5F && this.ad.i(ModelPig.b(this.ah), ModelPig.b(this.ai), ModelPig.b(this.aj)) && this.aN.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
				this.aQ = 300;
			}
		}

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
