package net.minecraft.src;

import java.io.File;

public class TextureLavaFlowFX extends MinecraftError {
	public TextureLavaFlowFX(CanvasIsomPreview var1) {
		super(var1);
		this.h = "Delete world";
	}

	public void j() {
		this.e.add(new EntitySplashFX(6, this.c / 2 - 100, this.d / 6 + 168, "Cancel"));
	}

	public void c(int var1) {
		String var2 = this.d(var1);
		if(var2 != null) {
			this.b.a((CanvasIsomPreview)(new CanvasCrashReport(this, "Are you sure you want to delete this world?", "\'" + var2 + "\' will be lost forever!", var1)));
		}

	}

	public void a(boolean var1, int var2) {
		if(var1) {
			File var3 = net.minecraft.client.Minecraft.b();
			EntitySpider.b(var3, this.d(var2));
		}

		this.b.a(this.a);
	}
}
