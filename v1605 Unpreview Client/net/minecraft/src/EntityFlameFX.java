package net.minecraft.src;

public class EntityFlameFX extends IsoImageBuffer {
	int a;
	int b;
	int c = 30;
	int d = -1;

	public EntityFlameFX(EntitySpider var1) {
		super(var1);
		this.u = "/mob/creeper.png";
	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	protected void b_() {
		this.b = this.a;
		if(this.a > 0 && this.d < 0) {
			--this.a;
		}

		if(this.d >= 0) {
			this.d = 2;
		}

		super.b_();
		if(this.d != 1) {
			this.d = -1;
		}

	}

	protected String d() {
		return "mob.creeper";
	}

	protected String e() {
		return "mob.creeperdeath";
	}

	public void b(EntityMinecart var1) {
		super.b(var1);
		if(var1 instanceof RenderBlocks) {
			this.b(EntityTNTPrimed.aO.aQ + this.aN.nextInt(2), 1);
		}

	}

	protected void a(EntityMinecart var1, float var2) {
		if(this.d <= 0 && var2 < 3.0F || this.d > 0 && var2 < 7.0F) {
			if(this.a == 0) {
				this.ad.a(this, "random.fuse", 1.0F, 0.5F);
			}

			this.d = 1;
			++this.a;
			if(this.a == this.c) {
				this.ad.a(this, this.ah, this.ai, this.aj, 3.0F);
				this.D();
			}

			this.g = true;
		}

	}

	public float b(float var1) {
		return ((float)this.b + (float)(this.a - this.b) * var1) / (float)(this.c - 2);
	}

	protected int g() {
		return EntityTNTPrimed.K.aQ;
	}
}
