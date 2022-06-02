package net.minecraft.src;

public class mj extends NBTTagCompound {
	public boolean a = false;

	public mj(EntitySpider var1) {
		super(var1);
		this.u = "/mob/pig.png";
		this.a(0.9F, 0.9F);
		this.a = false;
	}

	public void a(EntityItem var1) {
		super.a(var1);
		var1.a("Saddle", this.a);
	}

	public void b(EntityItem var1) {
		super.b(var1);
		this.a = var1.m("Saddle");
	}

	protected String c() {
		return "mob.pig";
	}

	protected String d() {
		return "mob.pig";
	}

	protected String e() {
		return "mob.pigdeath";
	}

	public boolean a(BlockMobSpawner var1) {
		if(this.a) {
			var1.g(this);
			return true;
		} else {
			return false;
		}
	}

	protected int g() {
		return EntityTNTPrimed.ao.aQ;
	}
}
