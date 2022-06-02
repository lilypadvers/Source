package net.minecraft.src;

public class mm extends NBTTagCompound {
	public boolean a = false;
	public float b = 0.0F;
	public float c = 0.0F;
	public float d;
	public float e;
	public float h = 1.0F;
	public int i;

	public mm(EntitySpider var1) {
		super(var1);
		this.u = "/mob/chicken.png";
		this.a(0.3F, 0.4F);
		this.D = 4;
		this.i = this.aN.nextInt(6000) + 6000;
	}

	public void i() {
		super.i();
		this.e = this.b;
		this.d = this.c;
		this.c = (float)((double)this.c + (double)(this.as?-1:4) * 0.3D);
		if(this.c < 0.0F) {
			this.c = 0.0F;
		}

		if(this.c > 1.0F) {
			this.c = 1.0F;
		}

		if(!this.as && this.h < 1.0F) {
			this.h = 1.0F;
		}

		this.h = (float)((double)this.h * 0.9D);
		if(!this.as && this.al < 0.0D) {
			this.al *= 0.6D;
		}

		this.b += this.h * 2.0F;
		if(--this.i <= 0) {
			this.b(EntityTNTPrimed.aN.aQ, 1);
			this.i = this.aN.nextInt(6000) + 6000;
		}

	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	protected String c() {
		return "mob.chicken";
	}

	protected String d() {
		return "mob.chickenhurt";
	}

	protected String e() {
		return "mob.chickenhurt";
	}

	protected int g() {
		return EntityTNTPrimed.J.aQ;
	}
}
