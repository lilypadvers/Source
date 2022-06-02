package net.minecraft.src;

public class MinecartTrackLogic extends MovingObjectPosition {
	private int trackX = -1;
	private int trackY = -1;
	private int trackZ = -1;
	private float f = 0.0F;
	private float g = 0.0F;
	private float h = 0.0F;
	private int i = 0;
	private Minecraft j = new BlockOreBlock(this, 200, GuiOptions.class, new Class[]{lr.class, RenderBlocks.class, EntityFlameFX.class, TextureFX.class, lq.class});
	private Minecraft k = new Minecraft(20, NBTTagCompound.class, new Class[]{SoundPoolEntry.class, mj.class, StepSoundSand.class, mm.class});

	public MinecartTrackLogic(net.minecraft.client.Minecraft var1) {
		super(var1);
	}

	public void a(BlockMobSpawner var1) {
		var1.an = -180.0F;
	}

	public void calculateConnectedTracks() {
	}

	public boolean b(int var1, int var2, int var3, int var4) {
		int var5 = this.a.e.a(var1, var2, var3);
		int var6 = this.a.e.e(var1, var2, var3);
		boolean var7 = super.b(var1, var2, var3, var4);
		TileEntityFurnace var8 = this.a.g.r();
		boolean var9 = this.a.g.b(ln.n[var5]);
		if(var8 != null) {
			var8.a(var5, var1, var2, var3);
			if(var8.a == 0) {
				var8.a((BlockMobSpawner)this.a.g);
				this.a.g.s();
			}
		}

		if(var7 && var9) {
			ln.n[var5].a_(this.a.e, var1, var2, var3, var6);
		}

		return var7;
	}

	public void a(int var1, int var2, int var3, int var4) {
		int var5 = this.a.e.a(var1, var2, var3);
		if(var5 > 0 && this.f == 0.0F) {
			ln.n[var5].b(this.a.e, var1, var2, var3, (BlockMobSpawner)this.a.g);
		}

		if(var5 > 0 && ln.n[var5].a((BlockMobSpawner)this.a.g) >= 1.0F) {
			this.b(var1, var2, var3, var4);
		}

	}

	public void refreshConnectedTracks() {
		this.f = 0.0F;
		this.i = 0;
	}

	public void c(int var1, int var2, int var3, int var4) {
		if(this.i > 0) {
			--this.i;
		} else {
			if(var1 == this.trackX && var2 == this.trackY && var3 == this.trackZ) {
				int var5 = this.a.e.a(var1, var2, var3);
				if(var5 == 0) {
					return;
				}

				ln var6 = ln.n[var5];
				this.f += var6.a((BlockMobSpawner)this.a.g);
				if(this.h % 4.0F == 0.0F && var6 != null) {
					this.a.A.b(var6.bj.d(), (float)var1 + 0.5F, (float)var2 + 0.5F, (float)var3 + 0.5F, (var6.bj.b() + 1.0F) / 8.0F, var6.bj.c() * 0.5F);
				}

				++this.h;
				if(this.f >= 1.0F) {
					this.b(var1, var2, var3, var4);
					this.f = 0.0F;
					this.g = 0.0F;
					this.h = 0.0F;
					this.i = 5;
				}
			} else {
				this.f = 0.0F;
				this.g = 0.0F;
				this.h = 0.0F;
				this.trackX = var1;
				this.trackY = var2;
				this.trackZ = var3;
			}

		}
	}

	public void a(float var1) {
		if(this.f <= 0.0F) {
			this.a.u.b = 0.0F;
			this.a.f.i = 0.0F;
		} else {
			float var2 = this.g + (this.f - this.g) * var1;
			this.a.u.b = var2;
			this.a.f.i = var2;
		}

	}

	public float c() {
		return 4.0F;
	}

	public void a(EntitySpider var1) {
		super.a(var1);
	}

	public void d() {
		this.g = this.f;
		this.j.a(this.a.e);
		this.k.a(this.a.e);
		this.a.A.c();
	}
}
