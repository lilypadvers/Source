package net.minecraft.src;

public class SoundPoolEntry extends NBTTagCompound {
	public boolean a = false;

	public SoundPoolEntry(EntitySpider var1) {
		super(var1);
		this.u = "/mob/sheep.png";
		this.a(0.9F, 1.3F);
	}

	public boolean a(EntityMinecart var1, int var2) {
		if(!this.a && var1 instanceof RecipesIngots) {
			this.a = true;
			int var3 = 1 + this.aN.nextInt(3);

			for(int var4 = 0; var4 < var3; ++var4) {
				EffectRenderer var5 = this.a(ln.ab.ba, 1, 1.0F);
				var5.al += (double)(this.aN.nextFloat() * 0.05F);
				var5.ak += (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.1F);
				var5.am += (double)((this.aN.nextFloat() - this.aN.nextFloat()) * 0.1F);
			}
		}

		return super.a(var1, var2);
	}

	public void a(EntityItem var1) {
		super.a(var1);
		var1.a("Sheared", this.a);
	}

	public void b(EntityItem var1) {
		super.b(var1);
		this.a = var1.m("Sheared");
	}

	protected String c() {
		return "mob.sheep";
	}

	protected String d() {
		return "mob.sheep";
	}

	protected String e() {
		return "mob.sheep";
	}
}
