package net.minecraft.src;

public class StepSoundSand extends NBTTagCompound {
	public boolean a = false;

	public StepSoundSand(EntitySpider var1) {
		super(var1);
		this.u = "/mob/cow.png";
		this.a(0.9F, 1.3F);
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	protected String c() {
		return "mob.cow";
	}

	protected String d() {
		return "mob.cowhurt";
	}

	protected String e() {
		return "mob.cowhurt";
	}

	protected float f() {
		return 0.4F;
	}

	protected int g() {
		return EntityTNTPrimed.aD.aQ;
	}

	public boolean a(BlockMobSpawner var1) {
		TileEntityFurnace var2 = var1.b.e();
		if(var2 != null && var2.c == EntityTNTPrimed.au.aQ) {
			var1.b.a(var1.b.d, new TileEntityFurnace(EntityTNTPrimed.aE));
			return true;
		} else {
			return false;
		}
	}
}
