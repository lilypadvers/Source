package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Random;

public class MovementInput extends kq {
	private boolean unused = false;
	private MouseHelper d;
	public String a;
	private net.minecraft.client.Minecraft e;
	private RenderFallingSand f;
	private boolean g = false;
	Random b = new Random();

	public MovementInput(net.minecraft.client.Minecraft var1, String var2, int var3) {
		this.e = var1;
		Socket var4 = new Socket(InetAddress.getByName(var2), var3);
		this.d = new MouseHelper(var4, "Client", this);
	}

	public void resetKeyState() {
		if(!this.unused) {
			this.d.grabMouseCursor();
		}
	}

	public void a(ItemSign var1) {
		this.e.b = new mw(this.e, this);
		this.f = new RenderFallingSand(this);
		this.f.v = true;
		this.e.a((EntitySpider)this.f);
		this.e.a((CanvasIsomPreview)(new NextTickListEntry(this)));
	}

	public void a(GuiIngame var1) {
		double var2 = (double)var1.b / 32.0D;
		double var4 = (double)var1.c / 32.0D;
		double var6 = (double)var1.d / 32.0D;
		EffectRenderer var8 = new EffectRenderer(this.f, var2, var4, var6, new TileEntityFurnace(var1.updateCounter, var1.i));
		var8.ak = (double)var1.e / 128.0D;
		var8.al = (double)var1.f / 128.0D;
		var8.am = (double)var1.g / 128.0D;
		var8.ba = var1.b;
		var8.bb = var1.c;
		var8.bc = var1.d;
		this.f.a(var1.a, var8);
	}

	public void a(TileEntityRenderer var1) {
		double var2 = (double)var1.b / 32.0D;
		double var4 = (double)var1.c / 32.0D;
		double var6 = (double)var1.d / 32.0D;
		Object var8 = null;
		if(var1.e == 10) {
			var8 = new no(this.f, var2, var4, var6, 0);
		}

		if(var1.e == 11) {
			var8 = new no(this.f, var2, var4, var6, 1);
		}

		if(var1.e == 12) {
			var8 = new no(this.f, var2, var4, var6, 2);
		}

		if(var1.e == 1) {
			var8 = new ThreadDownloadResources(this.f, var2, var4, var6);
		}

		if(var8 != null) {
			((EntityMinecart)var8).ba = var1.b;
			((EntityMinecart)var8).bb = var1.c;
			((EntityMinecart)var8).bc = var1.d;
			((EntityMinecart)var8).an = 0.0F;
			((EntityMinecart)var8).ao = 0.0F;
			((EntityMinecart)var8).Z = var1.a;
			this.f.a(var1.a, (EntityMinecart)var8);
		}

	}

	public void a(NoiseGeneratorOctaves var1) {
		double var2 = (double)var1.c / 32.0D;
		double var4 = (double)var1.d / 32.0D;
		double var6 = (double)var1.e / 32.0D;
		float var8 = (float)(var1.f * 360) / 256.0F;
		float var9 = (float)(var1.g * 360) / 256.0F;
		ng var10 = new ng(this.e.e, var1.b);
		var10.ba = var1.c;
		var10.bb = var1.d;
		var10.bc = var1.e;
		int var11 = var1.h;
		if(var11 == 0) {
			var10.b.a[var10.b.d] = null;
		} else {
			var10.b.a[var10.b.d] = new TileEntityFurnace(var11);
		}

		var10.b(var2, var4, var6, var8, var9);
		this.f.a(var1.a, var10);
	}

	public void a(IBlockAccess var1) {
		EntityMinecart var2 = this.f.b(var1.a);
		if(var2 != null) {
			var2.ba = var1.b;
			var2.bb = var1.c;
			var2.bc = var1.d;
			double var3 = (double)var2.ba / 32.0D;
			double var5 = (double)var2.bb / 32.0D;
			double var7 = (double)var2.bc / 32.0D;
			float var9 = (float)(var1.e * 360) / 256.0F;
			float var10 = (float)(var1.f * 360) / 256.0F;
			var2.a(var3, var5, var7, var9, var10, 3);
		}
	}

	public void a(lf var1) {
		EntityMinecart var2 = this.f.b(var1.a);
		if(var2 != null) {
			var2.ba += var1.b;
			var2.bb += var1.c;
			var2.bc += var1.d;
			double var3 = (double)var2.ba / 32.0D;
			double var5 = (double)var2.bb / 32.0D;
			double var7 = (double)var2.bc / 32.0D;
			float var9 = var1.g?(float)(var1.e * 360) / 256.0F:var2.an;
			float var10 = var1.g?(float)(var1.f * 360) / 256.0F:var2.ao;
			var2.a(var3, var5, var7, var9, var10, 3);
		}
	}

	public void a(RecipeSorter var1) {
		this.f.c(var1.a);
	}

	public void a(BlockContainer var1) {
		GuiDeleteWorld var2 = this.e.g;
		double var3 = var2.ah;
		double var5 = var2.ai;
		double var7 = var2.aj;
		float var9 = var2.an;
		float var10 = var2.ao;
		if(var1.h) {
			var3 = var1.a;
			var5 = var1.b;
			var7 = var1.c;
		}

		if(var1.i) {
			var9 = var1.e;
			var10 = var1.f;
		}

		var2.aI = 0.0F;
		var2.ak = var2.al = var2.am = 0.0D;
		var2.b(var3, var5, var7, var9, var10);
		var1.a = var2.ah;
		var1.b = var2.ar.b;
		var1.c = var2.aj;
		var1.d = var2.ai;
		this.d.a((ItemAxe)var1);
		if(!this.g) {
			this.e.g.ae = this.e.g.ah;
			this.e.g.af = this.e.g.ai;
			this.e.g.ag = this.e.g.aj;
			this.g = true;
			this.e.a((CanvasIsomPreview)null);
		}

	}

	public void a(RenderGiantZombie var1) {
		this.f.a(var1.a, var1.b, var1.c);
	}

	public void a(mn var1) {
		BlockMushroom var2 = this.f.b(var1.a, var1.b);
		int var3 = var1.a * 16;
		int var4 = var1.b * 16;

		for(int var5 = 0; var5 < var1.f; ++var5) {
			short var6 = var1.c[var5];
			int var7 = var1.d[var5] & 255;
			byte var8 = var1.e[var5];
			int var9 = var6 >> 12 & 15;
			int var10 = var6 >> 8 & 15;
			int var11 = var6 & 255;
			var2.a(var9, var11, var10, var7, var8);
			this.f.c(var9 + var3, var11, var10 + var4, var9 + var3, var11, var10 + var4);
			this.f.b(var9 + var3, var11, var10 + var4, var9 + var3, var11, var10 + var4);
		}

	}

	public void a(PanelCrashReport var1) {
		this.f.c(var1.a, var1.b, var1.c, var1.a + var1.d - 1, var1.b + var1.e - 1, var1.c + var1.f - 1);
		this.f.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var1.g);
	}

	public void a(kx var1) {
		this.f.c(var1.a, var1.b, var1.c, var1.d, var1.e);
	}

	public void a(nt var1) {
		this.d.a("Got kicked");
		this.unused = true;
		this.e.a((EntitySpider)null);
		this.e.a((CanvasIsomPreview)(new KeyBinding("Disconnected by server", var1.a)));
	}

	public void a(String var1) {
		if(!this.unused) {
			this.unused = true;
			this.e.a((EntitySpider)null);
			this.e.a((CanvasIsomPreview)(new KeyBinding("Connection lost", var1)));
		}
	}

	public void a(ItemAxe var1) {
		if(!this.unused) {
			this.d.a(var1);
		}
	}

	public void a(EntityAnimal var1) {
		EffectRenderer var2 = (EffectRenderer)this.f.b(var1.a);
		Object var3 = (RecipesIngots)this.f.b(var1.b);
		if(var3 == null) {
			var3 = this.e.g;
		}

		if(var2 != null) {
			this.f.a(var2, "random.pop", 0.2F, ((this.b.nextFloat() - this.b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			this.e.h.a((nd)(new ModelRenderer(this.e.e, var2, (EntityMinecart)var3, -0.5F)));
			this.f.c(var1.a);
		}

	}

	public void a(BlockLadder var1) {
		EntityMinecart var2 = this.f.b(var1.a);
		if(var2 != null) {
			BlockMobSpawner var3 = (BlockMobSpawner)var2;
			int var4 = var1.b;
			if(var4 == 0) {
				var3.b.a[var3.b.d] = null;
			} else {
				var3.b.a[var3.b.d] = new TileEntityFurnace(var4);
			}

		}
	}

	public void a(InventoryPlayer var1) {
		this.e.u.a(var1.a);
	}

	public void a(Slot var1) {
		EntityMinecart var2 = this.f.b(var1.a);
		if(var2 != null) {
			BlockMobSpawner var3 = (BlockMobSpawner)var2;
			var3.u();
		}
	}

	public void a(ks var1) {
		this.e.g.b.a(new TileEntityFurnace(var1.a, var1.b, var1.c));
	}

	public void a(BlockSign var1) {
		if(var1.a.equals("-")) {
			this.a((ItemAxe)(new ItemSign(this.e.i.b, "Password", 14)));
		} else {
			try {
				URL var2 = new URL("http://www.minecraft.net/game/joinserver.jsp?user=" + this.e.i.b + "&sessionId=" + this.e.i.c + "&serverId=" + var1.a);
				BufferedReader var3 = new BufferedReader(new InputStreamReader(var2.openStream()));
				String var4 = var3.readLine();
				var3.close();
				if(var4.equalsIgnoreCase("ok")) {
					this.a((ItemAxe)(new ItemSign(this.e.i.b, "Password", 14)));
				} else {
					this.d.a("Failed to login: " + var4);
				}
			} catch (Exception var5) {
				var5.printStackTrace();
				this.d.a("Internal client error: " + var5.toString());
			}
		}

	}

	public void b() {
		this.unused = true;
		this.d.a("Closed");
	}
}
