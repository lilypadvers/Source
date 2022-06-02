package net.minecraft.src;

public class RenderBlocks extends IsoImageBuffer {
	public RenderBlocks(EntitySpider var1) {
		super(var1);
		this.u = "/mob/skeleton.png";
	}

	protected String c() {
		return "mob.skeleton";
	}

	protected String d() {
		return "mob.skeletonhurt";
	}

	protected String e() {
		return "mob.skeletonhurt";
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

	protected void a(EntityMinecart var1, float var2) {
		if(var2 < 10.0F) {
			double var3 = var1.ah - this.ah;
			double var5 = var1.aj - this.aj;
			if(this.J == 0) {
				NBTTagEnd var7 = new NBTTagEnd(this.ad, this);
				++var7.ai;
				double var8 = var1.ai - (double)0.2F - var7.ai;
				float var10 = ModelPig.a(var3 * var3 + var5 * var5) * 0.2F;
				this.ad.a(this, "random.bow", 1.0F, 1.0F / (this.aN.nextFloat() * 0.4F + 0.8F));
				this.ad.a((EntityMinecart)var7);
				var7.a(var3, var8 + (double)var10, var5, 0.6F, 12.0F);
				this.J = 30;
			}

			this.an = (float)(Math.atan2(var5, var3) * 180.0D / (double)(float)Math.PI) - 90.0F;
			this.g = true;
		}

	}

	public void a(EntityItem var1) {
		super.a(var1);
	}

	public void b(EntityItem var1) {
		super.b(var1);
	}

	protected int g() {
		return EntityTNTPrimed.j.aQ;
	}
}
