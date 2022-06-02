package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import mcextension_a1605.auth.PreviewAuth;
import net.minecraft.src.BlockChest;
import net.minecraft.src.BlockDoor;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.BlockFurnace;
import net.minecraft.src.BlockLeavesBase;
import net.minecraft.src.BlockMinecartTrack;
import net.minecraft.src.BlockMobSpawner;
import net.minecraft.src.BlockRedstoneTorch;
import net.minecraft.src.BlockRedstoneWire;
import net.minecraft.src.BlockTNT;
import net.minecraft.src.CanvasIsomPreview;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.ChunkProviderIso;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.EntityDiggingFX;
import net.minecraft.src.EntityFallingSand;
import net.minecraft.src.EntityMinecart;
import net.minecraft.src.EntityPainting;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayerSP;
import net.minecraft.src.EntityRenderer;
import net.minecraft.src.EntitySmokeFX;
import net.minecraft.src.EntitySorter;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EnumArt;
import net.minecraft.src.EnumMobType;
import net.minecraft.src.GLAllocation;
import net.minecraft.src.GuiDeleteWorld;
import net.minecraft.src.InputHandler;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBucket;
import net.minecraft.src.ItemHoe;
import net.minecraft.src.MaterialLogic;
import net.minecraft.src.MinecartTrackLogic;
import net.minecraft.src.ModelCreeper;
import net.minecraft.src.ModelPig;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.NBTTagByteArray;
import net.minecraft.src.NBTTagDouble;
import net.minecraft.src.Pathfinder;
import net.minecraft.src.RenderItem;
import net.minecraft.src.RenderSpider;
import net.minecraft.src.SoundPool;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;
import net.minecraft.src.ld;
import net.minecraft.src.lk;
import net.minecraft.src.lm;
import net.minecraft.src.ln;
import net.minecraft.src.lv;
import net.minecraft.src.mb;
import net.minecraft.src.mc;
import net.minecraft.src.md;
import net.minecraft.src.ne;
import net.minecraft.src.nh;
import net.minecraft.src.nr;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable {
	public MovingObjectPosition b = new MinecartTrackLogic(this);
	private boolean a = false;
	public int c;
	public int d;
	private RenderItem L;
	private EntityPig M = new EntityPig(20.0F);
	public EntitySpider e;
	public BlockChest f;
	public GuiDeleteWorld g;
	public BlockMinecartTrack h;
	public EntityPlayerSP i = null;
	public String j;
	public Canvas k;
	public boolean l = true;
	public volatile boolean m = false;
	public BlockRedstoneWire n;
	public BlockDoor o;
	public CanvasIsomPreview p = null;
	public Item q = new Item(this);
	public ChunkPosition r = new ChunkPosition(this);
	private ItemBucket N;
	private int O = 0;
	private int P = 0;
	private int Q;
	private int R;
	public String s = null;
	public int t = 0;
	public lk u;
	public boolean v = false;
	public EntityDiggingFX w = new EntityDiggingFX(0.0F);
	public lv x = null;
	public World y;
	protected MinecraftApplet z;
	public nr A = new nr();
	public md B;
	public File C;
	public static long[] D = new long[512];
	public static int E = 0;
	private String S;
	private int T;
	private mb U = new mb();
	private CompressedStreamTools V = new CompressedStreamTools();
	private static File W = null;
	public volatile boolean F = true;
	public String G = "";
	long H = -1L;
	public boolean I = false;
	private int X = 0;
	public boolean J = false;
	long K = System.currentTimeMillis();

	public Minecraft(Component var1, Canvas var2, MinecraftApplet var3, int var4, int var5, boolean var6) {
		this.Q = var4;
		this.R = var5;
		this.a = var6;
		this.z = var3;
		new ChunkProviderIso(this, "Timer hack thread");
		this.k = var2;
		this.c = var4;
		this.d = var5;
		this.a = var6;
	}

	public abstract void a(GLAllocation var1);

	public void a(String var1, int var2) {
		this.S = var1;
		this.T = var2;
	}

	public void a() {
		if(this.k != null) {
			Graphics var1 = this.k.getGraphics();
			if(var1 != null) {
				var1.setColor(Color.BLACK);
				var1.fillRect(0, 0, this.c, this.d);
				var1.dispose();
			}

			Display.setParent(this.k);
		} else if(this.a) {
			Display.setFullscreen(true);
			this.c = Display.getDisplayMode().getWidth();
			this.d = Display.getDisplayMode().getHeight();
			if(this.c <= 0) {
				this.c = 1;
			}

			if(this.d <= 0) {
				this.d = 1;
			}
		} else {
			Display.setDisplayMode(new DisplayMode(this.c, this.d));
		}

		Display.setTitle("Minecraft Minecraft Alpha v1.0.16_02");

		try {
			Display.create();
		} catch (LWJGLException var6) {
			var6.printStackTrace();

			try {
				Thread.sleep(1000L);
			} catch (InterruptedException var5) {
			}

			Display.create();
		}

		RenderSpider.a.f = new EntitySmokeFX(this);
		this.C = b();
		this.y = new World(this, this.C);
		this.n = new BlockRedstoneWire(this.y);
		this.o = new BlockDoor(this.y, "/default.png", this.n);
		this.p();
		Keyboard.create();
		Mouse.create();
		this.B = new md(this.k);

		try {
			Controllers.create();
		} catch (Exception var4) {
			var4.printStackTrace();
		}

		this.c("Pre startup");
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearDepth(1.0D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glCullFace(GL11.GL_BACK);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		this.c("Startup");
		this.L = new RenderItem();
		this.A.a(this.y);
		this.n.a((BlockLeavesBase)this.V);
		this.n.a((BlockLeavesBase)this.U);
		this.n.a((BlockLeavesBase)(new SoundPool()));
		this.n.a((BlockLeavesBase)(new EnumMobType()));
		this.n.a((BlockLeavesBase)(new ItemHoe(0)));
		this.n.a((BlockLeavesBase)(new ItemHoe(1)));
		this.f = new BlockChest(this, this.n);
		GL11.glViewport(0, 0, this.c, this.d);
		this.h = new BlockMinecartTrack(this.e, this.n);

		try {
			this.N = new ItemBucket(this.C, this);
			this.N.start();
		} catch (Exception var3) {
		}

		this.c("Post startup");
		this.u = new lk(this);
		this.b.calculateConnectedTracks();
		if(this.S != null) {
			this.a((CanvasIsomPreview)(new mc(this, this.S, this.T)));
		} else {
			this.a((CanvasIsomPreview)(new TileEntityMobSpawner()));
		}

	}

	private void p() {
		EntityFallingSand var1 = new EntityFallingSand(this.c, this.d);
		int var2 = var1.a();
		int var3 = var1.b();
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0D, (double)var2, (double)var3, 0.0D, 1000.0D, 3000.0D);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
		GL11.glViewport(0, 0, this.c, this.d);
		GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
		NBTTagByteArray var4 = NBTTagByteArray.a;
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.n.a("/title/mojang.png"));
		var4.b();
		var4.b(0xFFFFFF);
		var4.a(0.0D, (double)this.d, 0.0D, 0.0D, 0.0D);
		var4.a((double)this.c, (double)this.d, 0.0D, 0.0D, 0.0D);
		var4.a((double)this.c, 0.0D, 0.0D, 0.0D, 0.0D);
		var4.a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
		var4.a();
		short var5 = 256;
		short var6 = 256;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		var4.b(0xFFFFFF);
		this.a((this.c / 2 - var5) / 2, (this.d / 2 - var6) / 2, 0, 0, var5, var6);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		Display.swapBuffers();
	}

	public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
		float var7 = 0.00390625F;
		float var8 = 0.00390625F;
		NBTTagByteArray var9 = NBTTagByteArray.a;
		var9.b();
		var9.a((double)(var1 + 0), (double)(var2 + var6), 0.0D, (double)((float)(var3 + 0) * var7), (double)((float)(var4 + var6) * var8));
		var9.a((double)(var1 + var5), (double)(var2 + var6), 0.0D, (double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8));
		var9.a((double)(var1 + var5), (double)(var2 + 0), 0.0D, (double)((float)(var3 + var5) * var7), (double)((float)(var4 + 0) * var8));
		var9.a((double)(var1 + 0), (double)(var2 + 0), 0.0D, (double)((float)(var3 + 0) * var7), (double)((float)(var4 + 0) * var8));
		var9.a();
	}

	public static File b() {
		if(W == null) {
			W = a("minecraft");
		}

		return W;
	}

	public static File a(String var0) {
		String var1 = System.getProperty("user.home", ".");
		File var2;
		switch(Minecraft.SyntheticClass_1.$SwitchMap$net$minecraft$src$EnumArt[q().ordinal()]) {
		case 1:
		case 2:
			var2 = new File(var1, '.' + var0 + '/');
			break;
		case 3:
			String var3 = System.getenv("APPDATA");
			if(var3 != null) {
				var2 = new File(var3, "." + var0 + '/');
			} else {
				var2 = new File(var1, '.' + var0 + '/');
			}
			break;
		case 4:
			var2 = new File(var1, "Library/Application Support/" + var0);
			break;
		default:
			var2 = new File(var1, var0 + '/');
		}

		if(!var2.exists() && !var2.mkdirs()) {
			throw new RuntimeException("The working directory could not be created: " + var2);
		} else {
			return var2;
		}
	}

	private static EnumArt q() {
		String var0 = System.getProperty("os.name").toLowerCase();
		return var0.contains("win")?EnumArt.Alban:(var0.contains("mac")?EnumArt.Aztec2:(var0.contains("solaris")?EnumArt.Aztec:(var0.contains("sunos")?EnumArt.Aztec:(var0.contains("linux")?EnumArt.Kebab:(var0.contains("unix")?EnumArt.Kebab:EnumArt.Bomb)))));
	}

	public void a(CanvasIsomPreview var1) {
		if(!(this.p instanceof MaterialLogic)) {
			if(this.p != null) {
				this.p.h();
			}

			if(var1 == null && this.e == null) {
				TileEntityMobSpawner var10000 = new TileEntityMobSpawner();
				v();
				var1 = var10000;
			}

			this.p = (CanvasIsomPreview)var1;
			if(var1 != null) {
				this.f();
				EntityFallingSand var2 = new EntityFallingSand(this.c, this.d);
				int var3 = var2.a();
				int var4 = var2.b();
				((CanvasIsomPreview)var1).a(this, var3, var4);
				this.v = false;
			} else {
				this.e();
			}

		}
	}

	private void c(String var1) {
		int var2 = GL11.glGetError();
		if(var2 != 0) {
			String var3 = GLU.gluErrorString(var2);
			System.out.println("########## GL ERROR ##########");
			System.out.println("@ " + var1);
			System.out.println(var2 + ": " + var3);
			System.exit(0);
		}

	}

	public void c() {
		if(this.z != null) {
			this.z.clearApplet();
		}

		try {
			if(this.N != null) {
				this.N.a();
			}
		} catch (Exception var8) {
		}

		try {
			System.out.println("Stopping!");
			this.a((EntitySpider)null);

			try {
				BlockRedstoneTorch.a();
			} catch (Exception var6) {
			}

			this.A.b();
			Mouse.destroy();
			Keyboard.destroy();
		} finally {
			Display.destroy();
		}

		System.gc();
	}

	public void run() {
		this.F = true;

		try {
			this.a();
		} catch (Exception var13) {
			var13.printStackTrace();
			this.a(new GLAllocation("Failed to start game", var13));
			return;
		}

		try {
			long var1 = System.currentTimeMillis();
			int var3 = 0;

			while(this.F && (this.z == null || this.z.isActive())) {
				EntityRenderer.updateRenderer();
				BlockTNT.a();
				if(this.k == null && Display.isCloseRequested()) {
					this.d();
				}

				if(this.m && this.e != null) {
					float var4 = this.M.c;
					this.M.a();
					this.M.c = var4;
				} else {
					this.M.a();
				}

				for(int var17 = 0; var17 < this.M.b; ++var17) {
					++this.O;

					try {
						this.i();
					} catch (lm var12) {
						this.e = null;
						this.a((EntitySpider)null);
						this.a((CanvasIsomPreview)(new EntitySorter()));
					}
				}

				this.c("Pre render");
				this.A.a(this.g, this.M.c);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				if(this.e != null) {
					while(true) {
						if(this.e.e()) {
							continue;
						}
						break;
					}
				}

				if(!this.v) {
					this.b.a(this.M.c);
					this.r.b(this.M.c);
				}

				if(!Display.isActive()) {
					if(this.a) {
						this.h();
					}

					Thread.sleep(10L);
				}

				if(Keyboard.isKeyDown(Keyboard.KEY_F6)) {
					this.r();
				} else {
					this.H = System.nanoTime();
				}

				Thread.yield();
				Display.update();
				if(this.k != null && !this.a && (this.k.getWidth() != this.c || this.k.getHeight() != this.d)) {
					this.c = this.k.getWidth();
					this.d = this.k.getHeight();
					if(this.c <= 0) {
						this.c = 1;
					}

					if(this.d <= 0) {
						this.d = 1;
					}

					this.a(this.c, this.d);
				}

				if(this.y.h) {
					Thread.sleep(5L);
				}

				this.c("Post render");
				++var3;

				for(this.m = !this.j() && this.p != null && this.p.b(); System.currentTimeMillis() >= var1 + 1000L; var3 = 0) {
					this.G = var3 + " fps, " + TileEntity.xCoord + " chunk updates";
					TileEntity.xCoord = 0;
					var1 += 1000L;
				}
			}
		} catch (ne var14) {
		} catch (Throwable var15) {
			this.e = null;
			var15.printStackTrace();
			this.a(new GLAllocation("Unexpected error", var15));
		} finally {
			this.c();
		}

	}

	private void r() {
		if(this.H == -1L) {
			this.H = System.nanoTime();
		}

		long var1 = System.nanoTime();
		D[E++ & D.length - 1] = var1 - this.H;
		this.H = var1;
		GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0D, (double)this.c, (double)this.d, 0.0D, 1000.0D, 3000.0D);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
		GL11.glLineWidth(1.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		NBTTagByteArray var3 = NBTTagByteArray.a;
		var3.a(7);
		var3.b(0x20200000);
		var3.a(0.0D, (double)(this.d - 100), 0.0D);
		var3.a(0.0D, (double)this.d, 0.0D);
		var3.a((double)D.length, (double)this.d, 0.0D);
		var3.a((double)D.length, (double)(this.d - 100), 0.0D);
		var3.a();
		long var4 = 0L;

		int var6;
		for(var6 = 0; var6 < D.length; ++var6) {
			var4 += D[var6];
		}

		var6 = (int)(var4 / 200000L / (long)D.length);
		var3.a(7);
		var3.b(0x20400000);
		var3.a(0.0D, (double)(this.d - var6), 0.0D);
		var3.a(0.0D, (double)this.d, 0.0D);
		var3.a((double)D.length, (double)this.d, 0.0D);
		var3.a((double)D.length, (double)(this.d - var6), 0.0D);
		var3.a();
		var3.a(1);

		for(int var7 = 0; var7 < D.length; ++var7) {
			int var8 = (var7 - E & D.length - 1) * 255 / D.length;
			int var9 = var8 * var8 / 255;
			var9 = var9 * var9 / 255;
			int var10 = var9 * var9 / 255;
			var10 = var10 * var10 / 255;
			var3.b(0xFF000000 + var10 + var9 * 256 + var8 * 65536);
			long var11 = D[var7] / 200000L;
			var3.a((double)((float)var7 + 0.5F), (double)((float)((long)this.d - var11) + 0.5F), 0.0D);
			var3.a((double)((float)var7 + 0.5F), (double)((float)this.d + 0.5F), 0.0D);
		}

		var3.a();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public void d() {
		this.F = false;
	}

	public void e() {
		if(Display.isActive()) {
			if(!this.I) {
				this.I = true;
				this.B.a();
				this.a((CanvasIsomPreview)null);
				this.X = this.O + 10000;
			}
		}
	}

	public void f() {
		if(this.I) {
			if(this.g != null) {
				this.g.j();
			}

			this.I = false;
			this.B.b();
		}
	}

	public void g() {
		if(this.p == null) {
			this.a((CanvasIsomPreview)(new ModelCreeper()));
		}
	}

	private void a(int var1, boolean var2) {
		if(!this.b.b) {
			if(var1 != 0 || this.P <= 0) {
				if(var2 && this.x != null && this.x.a == 0 && var1 == 0) {
					int var3 = this.x.b;
					int var4 = this.x.c;
					int var5 = this.x.d;
					this.b.c(var3, var4, var5, this.x.e);
					this.h.a(var3, var4, var5, this.x.e);
				} else {
					this.b.refreshConnectedTracks();
				}

			}
		}
	}

	private void a(int var1) {
		if(var1 != 0 || this.P <= 0) {
			if(var1 == 0) {
				this.g.u();
			}

			int var3;
			if(this.x == null) {
				if(var1 == 0 && !(this.b instanceof BlockFlower)) {
					this.P = 10;
				}
			} else if(this.x.a == 1) {
				if(var1 == 0) {
					this.g.a(this.x.g);
				}

				if(var1 == 1) {
					this.g.a_(this.x.g);
				}
			} else if(this.x.a == 0) {
				int var2 = this.x.b;
				var3 = this.x.c;
				int var4 = this.x.d;
				int var5 = this.x.e;
				ln var6 = ln.n[this.e.a(var2, var3, var4)];
				if(var1 == 0) {
					this.e.i(var2, var3, var4, this.x.e);
					if(var6 != ln.z || this.g.c >= 100) {
						this.b.a(var2, var3, var4, this.x.e);
					}
				} else {
					TileEntityFurnace var7 = this.g.b.e();
					int var8 = this.e.a(var2, var3, var4);
					if(var8 > 0 && ln.n[var8].a(this.e, var2, var3, var4, (BlockMobSpawner)this.g)) {
						return;
					}

					if(var7 == null) {
						return;
					}

					int var9 = var7.a;
					if(this.b.a(this.g, this.e, var7, var2, var3, var4, var5)) {
						this.g.u();
					}

					if(var7.a == 0) {
						this.g.b.a[this.g.b.d] = null;
					} else if(var7.a != var9) {
						this.r.a.b();
					}
				}
			}

			if(var1 == 1) {
				TileEntityFurnace var10 = this.g.b.e();
				if(var10 != null) {
					var3 = var10.a;
					TileEntityFurnace var11 = var10.a(this.e, this.g);
					if(var11 != var10 || var11 != null && var11.a != var3) {
						this.g.b.a[this.g.b.d] = var11;
						this.r.a.c();
						if(var11.a == 0) {
							this.g.b.a[this.g.b.d] = null;
						}
					}
				}
			}

		}
	}

	public void h() {
		try {
			this.a = !this.a;
			System.out.println("Toggle fullscreen!");
			if(this.a) {
				Display.setDisplayMode(Display.getDesktopDisplayMode());
				this.c = Display.getDisplayMode().getWidth();
				this.d = Display.getDisplayMode().getHeight();
				if(this.c <= 0) {
					this.c = 1;
				}

				if(this.d <= 0) {
					this.d = 1;
				}
			} else {
				if(this.k != null) {
					this.c = this.k.getWidth();
					this.d = this.k.getHeight();
				} else {
					this.c = this.Q;
					this.d = this.R;
				}

				if(this.c <= 0) {
					this.c = 1;
				}

				if(this.d <= 0) {
					this.d = 1;
				}

				Display.setDisplayMode(new DisplayMode(this.Q, this.R));
			}

			this.f();
			Display.setFullscreen(this.a);
			Display.update();
			Thread.sleep(1000L);
			if(this.a) {
				this.e();
			}

			if(this.p != null) {
				this.f();
				this.a(this.c, this.d);
			}

			System.out.println("Size: " + this.c + ", " + this.d);
		} catch (Exception var2) {
			var2.printStackTrace();
		}

	}

	private void a(int var1, int var2) {
		if(var1 <= 0) {
			var1 = 1;
		}

		if(var2 <= 0) {
			var2 = 1;
		}

		this.c = var1;
		this.d = var2;
		if(this.p != null) {
			EntityFallingSand var3 = new EntityFallingSand(var1, var2);
			int var4 = var3.a();
			int var5 = var3.b();
			this.p.a(this, var4, var5);
		}

	}

	private void s() {
		if(this.x != null) {
			int var1 = this.e.a(this.x.b, this.x.c, this.x.d);
			if(var1 == ln.u.ba) {
				var1 = ln.v.ba;
			}

			if(var1 == ln.aj.ba) {
				var1 = ln.ak.ba;
			}

			if(var1 == ln.z.ba) {
				var1 = ln.t.ba;
			}

			this.g.b.a(var1, this.b instanceof BlockFlower);
		}

	}

	public void i() {
		this.u.a();
		this.r.a(1.0F);
		if(this.g != null) {
			this.g.m();
		}

		if(!this.m && this.e != null) {
			this.b.d();
		}

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, this.n.a("/terrain.png"));
		if(!this.m) {
			this.n.a();
		}

		if(this.p == null && this.g != null && this.g.D <= 0) {
			this.a((CanvasIsomPreview)null);
		}

		if(this.p != null) {
			this.X = this.O + 10000;
		}

		if(this.p != null) {
			this.p.render();
			if(this.p != null) {
				this.p.g();
			}
		}

		if(this.p == null || this.p.running) {
			while(InputHandler.NextEvent()) {
				long var1 = System.currentTimeMillis() - this.K;
				if(var1 <= 200L) {
					int var3 = InputHandler.GetDWheel();
					if(var3 != 0) {
						this.g.b.b(var3);
					}

					if(this.p == null) {
						if(!this.I && InputHandler.GetEventButtonState()) {
							this.e();
						} else {
							if(InputHandler.GetEventButton() == 0 && InputHandler.GetEventButtonState()) {
								this.a(0);
								this.X = this.O;
							}

							if(InputHandler.GetEventButton() == 1 && InputHandler.GetEventButtonState()) {
								this.a(1);
								this.X = this.O;
							}

							if(InputHandler.GetEventButton() == 2 && InputHandler.GetEventButtonState()) {
								this.s();
							}
						}
					} else if(this.p != null) {
						this.p.e();
					}
				}
			}

			if(this.P > 0) {
				--this.P;
			}

			while(InputHandler.NextKBEvent()) {
				this.g.a(InputHandler.GetKBEventKey(), InputHandler.GetKBEventKeyState());
				if(InputHandler.GetKBEventKeyState()) {
					if(InputHandler.GetKBEventKey() == 87) {
						this.h();
					} else {
						if(this.p != null) {
							this.p.f();
						} else {
							if(InputHandler.GetKBEventKey() == 1) {
								this.g();
							}

							if(InputHandler.GetKBEventKey() == 63) {
								this.y.w = !this.y.w;
							}

							if(InputHandler.GetKBEventKey() == this.y.o.b) {
								this.a((CanvasIsomPreview)(new ld(this.g.b, this.g.b.c)));
							}

							if(InputHandler.GetKBEventKey() == this.y.p.b) {
								this.g.a(this.g.b.a(this.g.b.d, 1), false);
							}

							if(this.j() && InputHandler.GetKBEventKey() == this.y.q.b) {
								this.a((CanvasIsomPreview)(new EntityPainting()));
							}
						}

						for(int var4 = 0; var4 < 9; ++var4) {
							if(InputHandler.GetKBEventKey() == 2 + var4) {
								this.g.b.d = var4;
							}
						}

						if(InputHandler.GetKBEventKey() == this.y.r.b) {
							this.y.b(4, !InputHandler.IsKeyDown(42) && !InputHandler.IsKeyDown(54)?1:-1);
						}
					}
				}
			}

			if(this.p == null) {
				if(InputHandler.InputMouseAction(0) && (float)(this.O - this.X) >= this.M.a / 4.0F && this.I) {
					this.a(0);
					this.X = this.O;
				}

				if(InputHandler.InputMouseAction(1) && (float)(this.O - this.X) >= this.M.a / 4.0F && this.I) {
					this.a(1);
					this.X = this.O;
				}
			}

			this.a(0, this.p == null && InputHandler.InputMouseAction(0) && this.I);
		}

		if(this.e != null) {
			this.e.k = this.y.v;
			if(!this.m) {
				this.r.a();
			}

			if(!this.m) {
				this.f.d();
			}

			if(!this.m) {
				this.e.c();
			}

			if(!this.m || this.j()) {
				this.e.g();
			}

			if(!this.m && this.e != null) {
				this.e.m(ModelPig.b(this.g.ah), ModelPig.b(this.g.ai), ModelPig.b(this.g.aj));
			}

			if(!this.m) {
				this.h.a();
			}
		}

		this.K = System.currentTimeMillis();
	}

	public boolean j() {
		return this.e != null && this.e.v;
	}

	public void b(String var1) {
		this.a((EntitySpider)null);
		System.gc();
		EntitySpider var2 = new EntitySpider(new File(b(), "saves"), var1);
		if(var2.q) {
			this.a(var2, "Generating level");
		} else {
			this.a(var2, "Loading level");
		}

	}

	public void a(EntitySpider var1) {
		this.a(var1, "");
	}

	public void a(EntitySpider var1, String var2) {
		this.A.a((String)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		if(this.e != null) {
			this.e.a((nh)this.q);
		}

		this.e = var1;
		if(var1 != null) {
			this.b.a(var1);
			var1.l = this.o;
			if(!this.j()) {
				this.g = (GuiDeleteWorld)var1.a(GuiDeleteWorld.class);
			} else if(this.g != null) {
				this.g.o();
				if(var1 != null) {
					var1.a((EntityMinecart)this.g);
				}
			}

			if(!var1.v) {
				this.d(var2);
			}

			if(this.g == null) {
				this.g = (GuiDeleteWorld)this.b.b(var1);
				this.g.o();
				this.b.a((BlockMobSpawner)this.g);
			}

			this.g.a = new Pathfinder(this.y);
			if(this.f != null) {
				this.f.a(var1);
			}

			if(this.h != null) {
				this.h.a(var1);
			}

			this.b.b((BlockMobSpawner)this.g);
			var1.a((BlockMobSpawner)this.g);
			if(var1.q) {
				var1.a((nh)this.q);
			}
		} else {
			this.g = null;
		}

		System.gc();
		this.K = 0L;
	}

	private void d(String var1) {
		this.q.a(var1);
		this.q.d("Building terrain");
		short var2 = 128;
		int var3 = 0;
		int var4 = var2 * 2 / 16 + 1;
		var4 *= var4;

		for(int var5 = -var2; var5 <= var2; var5 += 16) {
			int var6 = this.e.n;
			int var7 = this.e.p;
			if(this.g != null) {
				var6 = (int)this.g.ah;
				var7 = (int)this.g.aj;
			}

			for(int var8 = -var2; var8 <= var2; var8 += 16) {
				this.q.a(var3++ * 100 / var4);
				this.e.a(var6 + var5, 64, var7 + var8);

				while(this.e.e()) {
				}
			}
		}

		this.q.d("Simulating world for a bit");
		boolean var9 = true;
		this.e.j();
	}

	public void a(String var1, File var2) {
		int var3 = var1.indexOf("/");
		String var4 = var1.substring(0, var3);
		var1 = var1.substring(var3 + 1);
		if(var4.equalsIgnoreCase("sound")) {
			this.A.a(var1, var2);
		} else if(var4.equalsIgnoreCase("newsound")) {
			this.A.a(var1, var2);
		} else if(var4.equalsIgnoreCase("streaming")) {
			this.A.b(var1, var2);
		} else if(var4.equalsIgnoreCase("music")) {
			this.A.c(var1, var2);
		} else if(var4.equalsIgnoreCase("newmusic")) {
			this.A.c(var1, var2);
		}

	}

	public RenderItem k() {
		return this.L;
	}

	public String l() {
		return this.f.b();
	}

	public String m() {
		return this.f.c();
	}

	public String n() {
		return "P: " + this.h.b() + ". T: " + this.e.d();
	}

	public void o() {
		this.e.a();
		if(this.g != null) {
			this.e.d(this.g);
		}

		this.g = (GuiDeleteWorld)this.b.b(this.e);
		this.g.o();
		this.b.a((BlockMobSpawner)this.g);
		this.e.a((BlockMobSpawner)this.g);
		this.g.a = new Pathfinder(this.y);
		this.b.b((BlockMobSpawner)this.g);
		this.d("Respawning");
	}

	public static void a(String var0, String var1) {
		a(var0, var1, (String)null);
	}

	public static void a(String var0, String var1, String var2) {
		boolean var3 = false;
		Frame var5 = new Frame("Minecraft");
		Canvas var6 = new Canvas();
		var5.setLayout(new BorderLayout());
		var5.add(var6, "Center");
		var6.setPreferredSize(new Dimension(854, 480));
		var5.pack();
		var5.setLocationRelativeTo((Component)null);
		NBTTagDouble var7 = new NBTTagDouble(var5, var6, (MinecraftApplet)null, 854, 480, var3, var5);
		Thread var8 = new Thread(var7, "Minecraft main thread");
		var8.setPriority(10);
		var7.l = false;
		var7.j = "www.minecraft.net";
		if(var0 != null && var1 != null) {
			var7.i = new EntityPlayerSP(var0, var1);
		} else {
			var7.i = new EntityPlayerSP("Player" + System.currentTimeMillis() % 1000L, "");
		}

		if(var2 != null) {
			String[] var9 = var2.split(":");
			var7.a(var9[0], Integer.parseInt(var9[1]));
		}

		var5.setVisible(true);
		var5.addWindowListener(new BlockFurnace(var7, var8));
		var8.start();
	}

	public static void main(String[] var0) {
		String var1 = "Player" + System.currentTimeMillis() % 1000L;
		if(var0.length > 0) {
			var1 = var0[0];
		}

		String var2 = "-";
		if(var0.length > 1) {
			var2 = var0[1];
		}

		a(var1, var2);
	}

	private static void v() {
		if(!PreviewAuth.shownPreviewMessage || PreviewAuth.authThread == null) {
			System.exit(-1);
		}
	}

	static final class SyntheticClass_1 {
		public static final int[] $SwitchMap$net$minecraft$src$EnumArt = new int[EnumArt.values().length];

		static {
			try {
				$SwitchMap$net$minecraft$src$EnumArt[EnumArt.Kebab.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
			}

			try {
				$SwitchMap$net$minecraft$src$EnumArt[EnumArt.Aztec.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
			}

			try {
				$SwitchMap$net$minecraft$src$EnumArt[EnumArt.Alban.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
			}

			try {
				$SwitchMap$net$minecraft$src$EnumArt[EnumArt.Aztec2.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
			}

		}
	}
}
