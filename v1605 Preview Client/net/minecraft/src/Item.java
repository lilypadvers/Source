package net.minecraft.src;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class Item implements nh {
	private String a = "";
	private net.minecraft.client.Minecraft b;
	private String c = "";
	private long d = System.currentTimeMillis();
	private boolean e = false;

	public Item(net.minecraft.client.Minecraft var1) {
		this.b = var1;
	}

	public void a(String var1) {
		this.e = false;
		this.c(var1);
	}

	public void b(String var1) {
		this.e = true;
		this.c(this.c);
	}

	public void c(String var1) {
		if(!this.b.F) {
			if(!this.e) {
				throw new ne();
			}
		} else {
			this.c = var1;
			EntityFallingSand var2 = new EntityFallingSand(this.b.c, this.b.d);
			int var3 = var2.a();
			int var4 = var2.b();
			GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0.0D, (double)var3, (double)var4, 0.0D, 100.0D, 300.0D);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.0F, 0.0F, -200.0F);
		}
	}

	public void d(String var1) {
		if(!this.b.F) {
			if(!this.e) {
				throw new ne();
			}
		} else {
			this.d = 0L;
			this.a = var1;
			this.a(-1);
			this.d = 0L;
		}
	}

	public void a(int var1) {
		if(!this.b.F) {
			if(!this.e) {
				throw new ne();
			}
		} else {
			long var2 = System.currentTimeMillis();
			if(var2 - this.d >= 20L) {
				this.d = var2;
				EntityFallingSand var4 = new EntityFallingSand(this.b.c, this.b.d);
				int var5 = var4.a();
				int var6 = var4.b();
				GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glMatrixMode(GL11.GL_PROJECTION);
				GL11.glLoadIdentity();
				GL11.glOrtho(0.0D, (double)var5, (double)var6, 0.0D, 100.0D, 300.0D);
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glLoadIdentity();
				GL11.glTranslatef(0.0F, 0.0F, -200.0F);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
				NBTTagByteArray var7 = NBTTagByteArray.a;
				int var8 = this.b.n.a("/dirt.png");
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, var8);
				float var9 = 32.0F;
				var7.b();
				var7.b(4210752);
				var7.a(0.0D, (double)var6, 0.0D, 0.0D, (double)((float)var6 / var9));
				var7.a((double)var5, (double)var6, 0.0D, (double)((float)var5 / var9), (double)((float)var6 / var9));
				var7.a((double)var5, 0.0D, 0.0D, (double)((float)var5 / var9), 0.0D);
				var7.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
				var7.a();
				if(var1 >= 0) {
					byte var10 = 100;
					byte var11 = 2;
					int var12 = var5 / 2 - var10 / 2;
					int var13 = var6 / 2 + 16;
					GL11.glDisable(GL11.GL_TEXTURE_2D);
					var7.b();
					var7.b(8421504);
					var7.a((double)var12, (double)var13, 0.0D);
					var7.a((double)var12, (double)(var13 + var11), 0.0D);
					var7.a((double)(var12 + var10), (double)(var13 + var11), 0.0D);
					var7.a((double)(var12 + var10), (double)var13, 0.0D);
					var7.b(8454016);
					var7.a((double)var12, (double)var13, 0.0D);
					var7.a((double)var12, (double)(var13 + var11), 0.0D);
					var7.a((double)(var12 + var1), (double)(var13 + var11), 0.0D);
					var7.a((double)(var12 + var1), (double)var13, 0.0D);
					var7.a();
					GL11.glEnable(GL11.GL_TEXTURE_2D);
				}

				this.b.o.a(this.c, (var5 - this.b.o.a(this.c)) / 2, var6 / 2 - 4 - 16, 0xFFFFFF);
				this.b.o.a(this.a, (var5 - this.b.o.a(this.a)) / 2, var6 / 2 - 4 + 8, 0xFFFFFF);
				Display.update();

				try {
					Thread.yield();
				} catch (Exception var14) {
				}

			}
		}
	}
}
