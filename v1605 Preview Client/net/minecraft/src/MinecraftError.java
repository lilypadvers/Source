package net.minecraft.src;

import java.io.File;

public class MinecraftError extends CanvasIsomPreview {
	protected CanvasIsomPreview a;
	protected String h = "Select world";
	private boolean i = false;

	public MinecraftError(CanvasIsomPreview var1) {
		this.a = var1;
	}

	public void a() {
		File var1 = net.minecraft.client.Minecraft.b();
		EntityItem var2 = EntitySpider.a(var1, "World1");
		if(var2 == null) {
			this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 6 + 24, "Start preview"));
		} else {
			this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 6 + 24, "Resume preview world  (" + (float)(var2.f("SizeOnDisk") / 1024L * 100L / 1024L) / 100.0F + " MB)"));
		}

		this.j();
	}

	protected String d(int var1) {
		return EntitySpider.a(net.minecraft.client.Minecraft.b(), "World" + var1) != null?"World" + var1:null;
	}

	public void j() {
		this.e.add(new EntitySplashFX(5, this.c / 2 - 100, this.d / 6 + 120 + 12, "Delete world..."));
		this.e.add(new EntitySplashFX(6, this.c / 2 - 100, this.d / 6 + 168, "Cancel"));
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d < 5) {
				this.c(var1.d + 1);
			} else if(var1.d == 5) {
				this.b.a((CanvasIsomPreview)(new TextureLavaFlowFX(this)));
			} else if(var1.d == 6) {
				this.b.a(this.a);
			}

		}
	}

	public void c(int var1) {
		this.b.a((CanvasIsomPreview)null);
		if(!this.i) {
			this.i = true;
			this.b.b("World" + var1);
			this.b.a((CanvasIsomPreview)null);
		}
	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, this.h, this.c / 2, 20, 0xFFFFFF);
		super.a(var1, var2, var3);
	}
}
