package net.minecraft.src;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class ni extends CanvasIsomPreview {
	protected String a = "Edit sign message:";
	private nn h;
	private int i;
	private int k = 0;

	public ni(nn var1) {
		this.h = var1;
	}

	public void a() {
		this.e.clear();
		Keyboard.enableRepeatEvents(true);
		this.e.add(new EntitySplashFX(0, this.c / 2 - 100, this.d / 4 + 120, "Done"));
	}

	public void h() {
		Keyboard.enableRepeatEvents(false);
	}

	public void g() {
		++this.i;
	}

	protected void a(EntitySplashFX var1) {
		if(var1.e) {
			if(var1.d == 0) {
				this.h.d();
				this.b.a((CanvasIsomPreview)null);
			}

		}
	}

	protected void a(char var1, int var2) {
		if(var2 == 200) {
			this.k = this.k - 1 & 3;
		}

		if(var2 == 208 || var2 == 28) {
			this.k = this.k + 1 & 3;
		}

		if(var2 == 14 && this.h.a[this.k].length() > 0) {
			this.h.a[this.k] = this.h.a[this.k].substring(0, this.h.a[this.k].length() - 1);
		}

		if(" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\'abcdefghijklmnopqrstuvwxyz{|}~\u2302\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8\u00a3\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1\u00aa\u00ba\u00bf\u00ae\u00ac\u00bd\u00bc\u00a1\u00ab\u00bb".indexOf(var1) >= 0 && this.h.a[this.k].length() < 15) {
			this.h.a[this.k] = this.h.a[this.k] + var1;
		}

	}

	public void a(int var1, int var2, float var3) {
		this.i();
		this.a(this.g, this.a, this.c / 2, 40, 0xFFFFFF);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.c / 2), (float)(this.d / 2), 50.0F);
		float var4 = 93.75F;
		GL11.glScalef(-var4, -var4, -var4);
		GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		ln var5 = this.h.f();
		if(var5 == ln.aD) {
			float var6 = (float)(this.h.e() * 360) / 16.0F;
			GL11.glRotatef(var6, 0.0F, 1.0F, 0.0F);
		} else {
			int var8 = this.h.e();
			float var7 = 0.0F;
			if(var8 == 2) {
				var7 = 180.0F;
			}

			if(var8 == 4) {
				var7 = 90.0F;
			}

			if(var8 == 5) {
				var7 = -90.0F;
			}

			GL11.glRotatef(var7, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0.3125F, 0.0F);
		}

		if(this.i / 6 % 2 == 0) {
			this.h.b = this.k;
		}

		ThreadDownloadImage.a.a(this.h, -0.5D, -0.75D, -0.5D, 0.0F);
		this.h.b = -1;
		GL11.glPopMatrix();
		super.a(var1, var2, var3);
	}
}
