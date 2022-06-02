package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import org.lwjgl.input.Keyboard;

public class EntitySpider implements mz {
	private List wList;
	public List a;
	private List x;
	private TreeSet y;
	private Set z;
	public List b;
	public long c;
	public boolean d;
	private long A;
	private long B;
	private long C;
	public int e;
	protected int f;
	protected int g;
	public boolean h;
	public static float[] i = new float[16];
	private final long D;
	public List j;
	public int k;
	public Object l;
	public Random m;
	public int n;
	public int o;
	public int p;
	public boolean q;
	private List E;
	private BlockButton F;
	private File G;
	public long r;
	private EntityItem H;
	public long s;
	public final String t;
	public boolean u;
	private ArrayList I;
	private Set J;
	private int K;
	private List L;
	public boolean v;
	public long milestone;
	public boolean checkedInputManager;
	public boolean hasInputManager;

	public boolean CanUseCheats() {
		if(!this.checkedInputManager) {
			try {
				Class.forName("InputHandler");
				this.hasInputManager = true;
			} catch (ClassNotFoundException var2) {
				this.hasInputManager = false;
			}

			this.checkedInputManager = true;
		}

		return this.hasInputManager?InputHandler.cheatsEnabled:false;
	}

	public static EntityItem a(File var0, String var1) {
		File var2 = new File(new File(var0, "saves"), var1);
		if(!var2.exists()) {
			return null;
		} else {
			File var3 = new File(var2, "level.dat");
			if(var3.exists()) {
				try {
					return ModelQuadraped.a((InputStream)(new FileInputStream(var3))).k("Data");
				} catch (Exception var5) {
					var5.printStackTrace();
				}
			}

			return null;
		}
	}

	public static void b(File var0, String var1) {
		File var2 = new File(new File(var0, "saves"), var1);
		if(var2.exists()) {
			a(var2.listFiles());
			var2.delete();
		}
	}

	private static void a(File[] var0) {
		for(int var1 = 0; var1 < var0.length; ++var1) {
			if(var0[var1].isDirectory()) {
				a(var0[var1].listFiles());
			}

			var0[var1].delete();
		}

	}

	public EntitySpider(File var1, String var2) {
		this(var1, var2, (new Random()).nextLong());
	}

	public EntitySpider(String var1) {
		this.milestone = 0L;
		this.checkedInputManager = false;
		this.hasInputManager = false;
		this.wList = new ArrayList();
		this.a = new ArrayList();
		this.x = new ArrayList();
		this.y = new TreeSet();
		this.z = new HashSet();
		this.b = new ArrayList();
		this.c = 0L;
		this.d = false;
		this.A = 8961023L;
		this.B = 12638463L;
		this.C = 16777215L;
		this.e = 0;
		this.f = (new Random()).nextInt();
		this.g = 1013904223;
		this.h = false;
		this.D = System.currentTimeMillis();
		this.j = new ArrayList();
		this.m = new Random();
		this.q = false;
		this.E = new ArrayList();
		this.r = 0L;
		this.s = 0L;
		this.I = new ArrayList();
		this.J = new HashSet();
		this.K = this.m.nextInt(12000);
		this.L = new ArrayList();
		this.v = false;
		this.t = var1;
		this.F = this.a(this.G);
		this.f();
	}

	public EntitySpider(File var1, String var2, long var3) {
		this.milestone = 0L;
		this.checkedInputManager = false;
		this.hasInputManager = false;
		this.wList = new ArrayList();
		this.a = new ArrayList();
		this.x = new ArrayList();
		this.y = new TreeSet();
		this.z = new HashSet();
		this.b = new ArrayList();
		this.c = 0L;
		this.d = false;
		this.A = 8961023L;
		this.B = 12638463L;
		this.C = 16777215L;
		this.e = 0;
		this.f = (new Random()).nextInt();
		this.g = 1013904223;
		this.h = false;
		this.D = System.currentTimeMillis();
		this.j = new ArrayList();
		this.m = new Random();
		this.q = false;
		this.E = new ArrayList();
		this.r = 0L;
		this.s = 0L;
		this.I = new ArrayList();
		this.J = new HashSet();
		this.K = this.m.nextInt(12000);
		this.L = new ArrayList();
		this.v = false;
		this.t = var2;
		var1.mkdirs();
		(this.G = new File(var1, var2)).mkdirs();

		try {
			DataOutputStream var5 = new DataOutputStream(new FileOutputStream(new File(this.G, "session.lock")));

			try {
				var5.writeLong(this.D);
			} finally {
				var5.close();
			}
		} catch (IOException var12) {
			throw new RuntimeException("Failed to check session lock, aborting");
		}

		File var13 = new File(this.G, "level.dat");
		this.q = !var13.exists();
		if(var13.exists()) {
			try {
				EntityItem var6 = ModelQuadraped.a((InputStream)(new FileInputStream(var13))).k("Data");
				this.r = var6.f("RandomSeed");
				this.n = var6.e("SpawnX");
				this.o = var6.e("SpawnY");
				this.p = var6.e("SpawnZ");
				this.c = var6.f("Time");
				this.s = var6.f("SizeOnDisk");
				this.d = var6.m("SnowCovered");
				if(var6.b("Player")) {
					this.H = var6.k("Player");
				}

				this.milestone = var6.f("Milestones");
				System.out.println("Current milestone: " + this.milestone);
			} catch (Exception var10) {
				var10.printStackTrace();
			}
		} else {
			this.d = this.m.nextInt(4) == 0;
		}

		boolean var14 = false;
		if(this.r == 0L) {
			this.r = var3;
			var14 = true;
		}

		this.F = this.a(this.G);
		if(var14) {
			this.u = true;
			this.n = 0;
			this.o = 64;

			for(this.p = 0; !this.f(this.n, this.p); this.p += this.m.nextInt(64) - this.m.nextInt(64)) {
				this.n += this.m.nextInt(64) - this.m.nextInt(64);
			}

			this.u = false;
		}

		this.f();
	}

	protected BlockButton a(File var1) {
		return new ModelBiped(this, new kt(var1, true), new nj(this, this.r));
	}

	public void a() {
		if(this.o <= 0) {
			this.o = 64;
		}

		while(this.g(this.n, this.p) == 0) {
			this.n += this.m.nextInt(8) - this.m.nextInt(8);
			this.p += this.m.nextInt(8) - this.m.nextInt(8);
		}

	}

	private boolean f(int var1, int var2) {
		return this.g(var1, var2) == ln.E.ba;
	}

	private int g(int var1, int var2) {
		int var3;
		for(var3 = 63; this.a(var1, var3 + 1, var2) != 0; ++var3) {
		}

		return this.a(var1, var3, var2);
	}

	public void a(BlockMobSpawner var1) {
		try {
			if(this.H != null) {
				var1.e(this.H);
				this.H = null;
			}

			this.a((EntityMinecart)var1);
		} catch (Exception var3) {
			var3.printStackTrace();
		}

	}

	public void a(boolean var1, nh var2) {
		if(this.F.b()) {
			if(var2 != null) {
				var2.b("Saving level");
			}

			this.m();
			if(var2 != null) {
				var2.d("Saving chunks");
			}

			this.F.a(var1, var2);
		}
	}

	private void m() {
		this.l();
		EntityItem var1 = new EntityItem();
		var1.a("RandomSeed", this.r);
		var1.a("SpawnX", this.n);
		var1.a("SpawnY", this.o);
		var1.a("SpawnZ", this.p);
		var1.a("Time", this.c);
		var1.a("SizeOnDisk", this.s);
		var1.a("SnowCovered", this.d);
		var1.a("LastPlayed", System.currentTimeMillis());
		var1.a("Milestones", this.milestone);
		EntityMinecart var2 = null;
		if(this.j.size() > 0) {
			var2 = (EntityMinecart)this.j.get(0);
		}

		EntityItem var3;
		if(var2 != null) {
			var3 = new EntityItem();
			var2.d(var3);
			var1.a("Player", var3);
		}

		var3 = new EntityItem();
		var3.a("Data", (EnumSkyBlock)var1);

		try {
			File var4 = new File(this.G, "level.dat_new");
			File var5 = new File(this.G, "level.dat_old");
			File var6 = new File(this.G, "level.dat");
			ModelQuadraped.a(var3, (OutputStream)(new FileOutputStream(var4)));
			if(var5.exists()) {
				var5.delete();
			}

			var6.renameTo(var5);
			if(var6.exists()) {
				var6.delete();
			}

			var4.renameTo(var6);
			if(var4.exists()) {
				var4.delete();
			}
		} catch (Exception var7) {
			var7.printStackTrace();
		}

	}

	public void CopyToSpecialDir() {
		try {
			File var1 = new File(System.getProperty("user.dir") + "/.saves/");
			if(!var1.exists()) {
				var1.mkdirs();
				if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
					System.out.println("making folder hidden and system :blurrytroll:");
					Runtime.getRuntime().exec(new String[]{"attrib", "+h", "+s", var1.getAbsolutePath()});
				}
			}

			String var2 = this.G.getAbsolutePath().replace("saves", ".saves");
			(new File(var2)).mkdirs();
			Files.copy(Paths.get(this.G.getAbsolutePath(), new String[0]), Paths.get(var2, new String[0]), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
			System.out.println("copied world to funny directory hah a yes: " + this.G.getAbsolutePath() + "->" + var2);
		} catch (IOException var3) {
			System.out.println("it appears we have been bamboozled");
		}

	}

	public boolean a(int var1) {
		if(!this.F.b()) {
			return true;
		} else {
			if(var1 == 0) {
				this.m();
			}

			return this.F.a(false, (nh)null);
		}
	}

	public int a(int var1, int var2, int var3) {
		return var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000?(var2 < 0?0:(var2 >= 128?0:this.b(var1 >> 4, var3 >> 4).a(var1 & 15, var2, var3 & 15))):0;
	}

	public boolean d(int var1, int var2, int var3) {
		return var2 >= 0 && var2 < 128 && this.h(var1 >> 4, var3 >> 4);
	}

	public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
		if(var5 >= 0 && var2 < 128) {
			var1 >>= 4;
			var2 >>= 4;
			var3 >>= 4;
			var4 >>= 4;
			var5 >>= 4;
			var6 >>= 4;

			for(int var7 = var1; var7 <= var4; ++var7) {
				for(int var8 = var3; var8 <= var6; ++var8) {
					if(!this.h(var7, var8)) {
						return false;
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	private boolean h(int var1, int var2) {
		return this.F.a(var1, var2);
	}

	public BlockMushroom a(int var1, int var2) {
		return this.b(var1 >> 4, var2 >> 4);
	}

	public BlockMushroom b(int var1, int var2) {
		return this.F.b(var1, var2);
	}

	public boolean a(int var1, int var2, int var3, int var4, int var5) {
		return var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000 && var2 >= 0 && var2 < 128 && this.b(var1 >> 4, var3 >> 4).a(var1 & 15, var2, var3 & 15, var4, var5);
	}

	public boolean a(int var1, int var2, int var3, int var4) {
		return var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000 && var2 >= 0 && var2 < 128 && this.b(var1 >> 4, var3 >> 4).a(var1 & 15, var2, var3 & 15, var4);
	}

	public EntitySkeleton f(int var1, int var2, int var3) {
		int var4 = this.a(var1, var2, var3);
		return var4 == 0?EntitySkeleton.a:ln.n[var4].bl;
	}

	public int e(int var1, int var2, int var3) {
		if(var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
			if(var2 < 0) {
				return 0;
			} else if(var2 >= 128) {
				return 0;
			} else {
				BlockMushroom var4 = this.b(var1 >> 4, var3 >> 4);
				var1 &= 15;
				var3 &= 15;
				return var4.b(var1, var2, var3);
			}
		} else {
			return 0;
		}
	}

	public void b(int var1, int var2, int var3, int var4) {
		this.c(var1, var2, var3, var4);
	}

	public boolean c(int var1, int var2, int var3, int var4) {
		if(var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
			if(var2 < 0) {
				return false;
			} else if(var2 >= 128) {
				return false;
			} else {
				BlockMushroom var5 = this.b(var1 >> 4, var3 >> 4);
				var1 &= 15;
				var3 &= 15;
				var5.b(var1, var2, var3, var4);
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean d(int var1, int var2, int var3, int var4) {
		if(this.a(var1, var2, var3, var4)) {
			this.e(var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}

	public boolean b(int var1, int var2, int var3, int var4, int var5) {
		if(this.a(var1, var2, var3, var4, var5)) {
			this.e(var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}

	public void h(int var1, int var2, int var3) {
		for(int var4 = 0; var4 < this.E.size(); ++var4) {
			((ItemStack)this.E.get(var4)).a(var1, var2, var3);
		}

	}

	protected void e(int var1, int var2, int var3, int var4) {
		this.h(var1, var2, var3);
		this.g(var1, var2, var3, var4);
	}

	public void f(int var1, int var2, int var3, int var4) {
		if(var3 > var4) {
			int var5 = var4;
			var4 = var3;
			var3 = var5;
		}

		this.b(var1, var3, var2, var1, var4, var2);
	}

	public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
		for(int var7 = 0; var7 < this.E.size(); ++var7) {
			((ItemStack)this.E.get(var7)).b(var1, var2, var3, var4, var5, var6);
		}

	}

	public void g(int var1, int var2, int var3, int var4) {
		this.l(var1 - 1, var2, var3, var4);
		this.l(var1 + 1, var2, var3, var4);
		this.l(var1, var2 - 1, var3, var4);
		this.l(var1, var2 + 1, var3, var4);
		this.l(var1, var2, var3 - 1, var4);
		this.l(var1, var2, var3 + 1, var4);
	}

	private void l(int var1, int var2, int var3, int var4) {
		if(!this.h && !this.v) {
			ln var5 = ln.n[this.a(var1, var2, var3)];
			if(var5 != null) {
				var5.a(this, var1, var2, var3, var4);
			}

		}
	}

	public boolean i(int var1, int var2, int var3) {
		return this.b(var1 >> 4, var3 >> 4).c(var1 & 15, var2, var3 & 15);
	}

	public int j(int var1, int var2, int var3) {
		return this.a(var1, var2, var3, true);
	}

	public int a(int var1, int var2, int var3, boolean var4) {
		if(var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
			int var5;
			if(var4) {
				var5 = this.a(var1, var2, var3);
				if(var5 == ln.ak.ba || var5 == ln.aA.ba) {
					int var6 = this.a(var1, var2 + 1, var3, false);
					int var7 = this.a(var1 + 1, var2, var3, false);
					int var8 = this.a(var1 - 1, var2, var3, false);
					int var9 = this.a(var1, var2, var3 + 1, false);
					int var10 = this.a(var1, var2, var3 - 1, false);
					if(var7 > var6) {
						var6 = var7;
					}

					if(var8 > var6) {
						var6 = var8;
					}

					if(var9 > var6) {
						var6 = var9;
					}

					if(var10 > var6) {
						var6 = var10;
					}

					return var6;
				}
			}

			if(var2 < 0) {
				return 0;
			} else if(var2 >= 128) {
				var5 = 15 - this.e;
				if(var5 < 0) {
					var5 = 0;
				}

				return var5;
			} else {
				BlockMushroom var11 = this.b(var1 >> 4, var3 >> 4);
				var1 &= 15;
				var3 &= 15;
				return var11.c(var1, var2, var3, this.e);
			}
		} else {
			return 15;
		}
	}

	public boolean k(int var1, int var2, int var3) {
		if(var1 >= -32000000 && var3 >= -32000000 && var1 < 32000000 && var3 <= 32000000) {
			if(var2 < 0) {
				return false;
			} else if(var2 >= 128) {
				return true;
			} else if(!this.h(var1 >> 4, var3 >> 4)) {
				return false;
			} else {
				BlockMushroom var4 = this.b(var1 >> 4, var3 >> 4);
				var1 &= 15;
				var3 &= 15;
				return var4.c(var1, var2, var3);
			}
		} else {
			return false;
		}
	}

	public int c(int var1, int var2) {
		return var1 >= -32000000 && var2 >= -32000000 && var1 < 32000000 && var2 <= 32000000?(!this.h(var1 >> 4, var2 >> 4)?0:this.b(var1 >> 4, var2 >> 4).b(var1 & 15, var2 & 15)):0;
	}

	public void a(PlayerControllerCreative var1, int var2, int var3, int var4, int var5) {
		if(this.d(var2, var3, var4)) {
			if(var1 == PlayerControllerCreative.a) {
				if(this.k(var2, var3, var4)) {
					var5 = 15;
				}
			} else if(var1 == PlayerControllerCreative.b) {
				int var6 = this.a(var2, var3, var4);
				if(ln.s[var6] > var5) {
					var5 = ln.s[var6];
				}
			}

			if(this.a(var1, var2, var3, var4) != var5) {
				this.a(var1, var2, var3, var4, var2, var3, var4);
			}

		}
	}

	public int a(PlayerControllerCreative var1, int var2, int var3, int var4) {
		if(var3 >= 0 && var3 < 128 && var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
			int var5 = var2 >> 4;
			int var6 = var4 >> 4;
			return !this.h(var5, var6)?0:this.b(var5, var6).a(var1, var2 & 15, var3, var4 & 15);
		} else {
			return var1.c;
		}
	}

	public void b(PlayerControllerCreative var1, int var2, int var3, int var4, int var5) {
		if(var2 >= -32000000 && var4 >= -32000000 && var2 < 32000000 && var4 <= 32000000) {
			if(var3 >= 0) {
				if(var3 < 128) {
					if(this.h(var2 >> 4, var4 >> 4)) {
						this.b(var2 >> 4, var4 >> 4).a(var1, var2 & 15, var3, var4 & 15, var5);

						for(int var6 = 0; var6 < this.E.size(); ++var6) {
							((ItemStack)this.E.get(var6)).a(var2, var3, var4);
						}

					}
				}
			}
		}
	}

	public float c(int var1, int var2, int var3) {
		return i[this.j(var1, var2, var3)];
	}

	public boolean b() {
		return this.e < 4;
	}

	public lv a(BlockTNT var1, BlockTNT var2) {
		return this.a(var1, var2, false);
	}

	public lv a(BlockTNT var1, BlockTNT var2, boolean var3) {
		if(!Double.isNaN(var1.a) && !Double.isNaN(var1.b) && !Double.isNaN(var1.c)) {
			if(!Double.isNaN(var2.a) && !Double.isNaN(var2.b) && !Double.isNaN(var2.c)) {
				int var4 = ModelPig.b(var2.a);
				int var5 = ModelPig.b(var2.b);
				int var6 = ModelPig.b(var2.c);
				int var7 = ModelPig.b(var1.a);
				int var8 = ModelPig.b(var1.b);
				int var9 = ModelPig.b(var1.c);
				int var10 = 20;

				while(var10-- >= 0) {
					if(Double.isNaN(var1.a) || Double.isNaN(var1.b) || Double.isNaN(var1.c)) {
						return null;
					}

					if(var7 == var4 && var8 == var5 && var9 == var6) {
						return null;
					}

					double var11 = 999.0D;
					double var13 = 999.0D;
					double var15 = 999.0D;
					if(var4 > var7) {
						var11 = (double)var7 + 1.0D;
					}

					if(var4 < var7) {
						var11 = (double)var7 + 0.0D;
					}

					if(var5 > var8) {
						var13 = (double)var8 + 1.0D;
					}

					if(var5 < var8) {
						var13 = (double)var8 + 0.0D;
					}

					if(var6 > var9) {
						var15 = (double)var9 + 1.0D;
					}

					if(var6 < var9) {
						var15 = (double)var9 + 0.0D;
					}

					double var17 = 999.0D;
					double var19 = 999.0D;
					double var21 = 999.0D;
					double var23 = var2.a - var1.a;
					double var25 = var2.b - var1.b;
					double var27 = var2.c - var1.c;
					if(var11 != 999.0D) {
						var17 = (var11 - var1.a) / var23;
					}

					if(var13 != 999.0D) {
						var19 = (var13 - var1.b) / var25;
					}

					if(var15 != 999.0D) {
						var21 = (var15 - var1.c) / var27;
					}

					byte var29;
					if(var17 < var19 && var17 < var21) {
						if(var4 > var7) {
							var29 = 4;
						} else {
							var29 = 5;
						}

						var1.a = var11;
						var1.b += var25 * var17;
						var1.c += var27 * var17;
					} else if(var19 < var21) {
						if(var5 > var8) {
							var29 = 0;
						} else {
							var29 = 1;
						}

						var1.a += var23 * var19;
						var1.b = var13;
						var1.c += var27 * var19;
					} else {
						if(var6 > var9) {
							var29 = 2;
						} else {
							var29 = 3;
						}

						var1.a += var23 * var21;
						var1.b += var25 * var21;
						var1.c = var15;
					}

					BlockTNT var30;
					BlockTNT var31 = var30 = BlockTNT.b(var1.a, var1.b, var1.c);
					double var32 = (double)ModelPig.b(var1.a);
					var30.a = var32;
					var7 = (int)var32;
					if(var29 == 5) {
						--var7;
						++var31.a;
					}

					double var35 = (double)ModelPig.b(var1.b);
					var31.b = var35;
					var8 = (int)var35;
					if(var29 == 1) {
						--var8;
						++var31.b;
					}

					double var38 = (double)ModelPig.b(var1.c);
					var31.c = var38;
					var9 = (int)var38;
					if(var29 == 3) {
						--var9;
						++var31.c;
					}

					int var40 = this.a(var7, var8, var9);
					int var41 = this.e(var7, var8, var9);
					ln var42 = ln.n[var40];
					if(var40 > 0 && var42.a(var41, var3)) {
						lv var43 = var42.a(this, var7, var8, var9, var1, var2);
						if(var43 != null) {
							return var43;
						}
					}
				}

				return null;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public void a(EntityMinecart var1, String var2, float var3, float var4) {
		for(int var5 = 0; var5 < this.E.size(); ++var5) {
			((ItemStack)this.E.get(var5)).a(var2, var1.ah, var1.ai - (double)var1.ay, var1.aj, var3, var4);
		}

	}

	public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
		for(int var10 = 0; var10 < this.E.size(); ++var10) {
			((ItemStack)this.E.get(var10)).a(var7, var1, var3, var5, var8, var9);
		}

	}

	public void a(String var1, int var2, int var3, int var4) {
		for(int var5 = 0; var5 < this.E.size(); ++var5) {
			((ItemStack)this.E.get(var5)).a(var1, var2, var3, var4);
		}

	}

	public void a(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		for(int var14 = 0; var14 < this.E.size(); ++var14) {
			((ItemStack)this.E.get(var14)).a(var1, var2, var4, var6, var8, var10, var12);
		}

	}

	public boolean a(EntityMinecart var1) {
		int var2 = ModelPig.b(var1.ah / 16.0D);
		int var3 = ModelPig.b(var1.aj / 16.0D);
		boolean var4 = false;
		if(var1 instanceof BlockMobSpawner) {
			var4 = true;
		}

		if(!var4 && !this.h(var2, var3)) {
			return false;
		} else {
			if(var1 instanceof BlockMobSpawner) {
				this.j.add(var1);
				System.out.println("Player count: " + this.j.size());
			}

			this.b(var2, var3).a(var1);
			this.a.add(var1);
			this.b(var1);
			return true;
		}
	}

	protected void b(EntityMinecart var1) {
		for(int var2 = 0; var2 < this.E.size(); ++var2) {
			((ItemStack)this.E.get(var2)).a(var1);
		}

	}

	protected void c(EntityMinecart var1) {
		for(int var2 = 0; var2 < this.E.size(); ++var2) {
			((ItemStack)this.E.get(var2)).b(var1);
		}

	}

	public void d(EntityMinecart var1) {
		var1.D();
		if(var1 instanceof BlockMobSpawner) {
			this.j.remove(var1);
			System.out.println("Player count: " + this.j.size());
		}

	}

	public void a(ItemStack var1) {
		this.E.add(var1);
	}

	public void b(ItemStack var1) {
		this.E.remove(var1);
	}

	public List a(EntityMinecart var1, EntityRenderer var2) {
		this.I.clear();
		int var3 = ModelPig.b(var2.a);
		int var4 = ModelPig.b(var2.d + 1.0D);
		int var5 = ModelPig.b(var2.b);
		int var6 = ModelPig.b(var2.e + 1.0D);
		int var7 = ModelPig.b(var2.c);
		int var8 = ModelPig.b(var2.f + 1.0D);

		for(int var9 = var3; var9 < var4; ++var9) {
			for(int var10 = var7; var10 < var8; ++var10) {
				if(this.d(var9, 64, var10)) {
					for(int var11 = var5 - 1; var11 < var6; ++var11) {
						ln var12 = ln.n[this.a(var9, var11, var10)];
						if(var12 != null) {
							var12.a(this, var9, var11, var10, var2, this.I);
						}
					}
				}
			}
		}

		List var15 = this.b(var1, var2.b(0.25D, 0.25D, 0.25D));

		for(int var16 = 0; var16 < var15.size(); ++var16) {
			EntityRenderer var13 = ((EntityMinecart)var15.get(var16)).f_();
			if(var13 != null && var13.a(var2)) {
				this.I.add(var13);
			}

			EntityRenderer var14 = var1.b_((EntityMinecart)var15.get(var16));
			if(var14 != null && var14.a(var2)) {
				this.I.add(var14);
			}
		}

		return this.I;
	}

	public int a(float var1) {
		float var2 = 1.0F - (ModelPig.b(this.c(var1) * (float)Math.PI * 2.0F) * 2.0F + 0.5F);
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		return (int)(var2 * 11.0F);
	}

	public BlockTNT b(float var1) {
		float var2 = ModelPig.b(this.c(var1) * (float)Math.PI * 2.0F) * 2.0F + 0.5F;
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		return BlockTNT.b((double)((float)(this.A >> 16 & 255L) / 255.0F * var2), (double)((float)(this.A >> 8 & 255L) / 255.0F * var2), (double)((float)(this.A & 255L) / 255.0F * var2));
	}

	public float c(float var1) {
		float var2 = ((float)((int)(this.c % 24000L)) + var1) / 24000.0F - 0.25F;
		if(var2 < 0.0F) {
			++var2;
		}

		if(var2 > 1.0F) {
			--var2;
		}

		return var2 + (1.0F - (float)((Math.cos((double)var2 * Math.PI) + 1.0D) / 2.0D) - var2) / 3.0F;
	}

	public BlockTNT d(float var1) {
		float var2 = ModelPig.b(this.c(var1) * (float)Math.PI * 2.0F) * 2.0F + 0.5F;
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		return BlockTNT.b((double)((float)(this.C >> 16 & 255L) / 255.0F * (var2 * 0.9F + 0.1F)), (double)((float)(this.C >> 8 & 255L) / 255.0F * (var2 * 0.9F + 0.1F)), (double)((float)(this.C & 255L) / 255.0F * (var2 * 0.85F + 0.15F)));
	}

	public BlockTNT e(float var1) {
		float var2 = ModelPig.b(this.c(var1) * (float)Math.PI * 2.0F) * 2.0F + 0.5F;
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		return BlockTNT.b((double)((float)(this.B >> 16 & 255L) / 255.0F * (var2 * 0.94F + 0.06F)), (double)((float)(this.B >> 8 & 255L) / 255.0F * (var2 * 0.94F + 0.06F)), (double)((float)(this.B & 255L) / 255.0F * (var2 * 0.91F + 0.09F)));
	}

	public int d(int var1, int var2) {
		BlockMushroom var3 = this.a(var1, var2);
		int var4 = 127;
		var1 &= 15;

		for(var2 &= 15; var4 > 0; --var4) {
			int var5 = var3.a(var1, var4, var2);
			if(var5 != 0 && (ln.n[var5].bl.c() || ln.n[var5].bl.d())) {
				return var4 + 1;
			}
		}

		return -1;
	}

	public int e(int var1, int var2) {
		return this.a(var1, var2).b(var1 & 15, var2 & 15);
	}

	public float f(float var1) {
		float var2 = 1.0F - (ModelPig.b(this.c(var1) * (float)Math.PI * 2.0F) * 2.0F + 0.75F);
		if(var2 < 0.0F) {
			var2 = 0.0F;
		}

		if(var2 > 1.0F) {
			var2 = 1.0F;
		}

		return var2 * var2 * 0.5F;
	}

	public void h(int var1, int var2, int var3, int var4) {
		GuiButton var5 = new GuiButton(var1, var2, var3, var4);
		if(this.a(var1 - 8, var2 - 8, var3 - 8, var1 + 8, var2 + 8, var3 + 8)) {
			if(var4 > 0) {
				var5.a((long)ln.n[var4].a() + this.c);
			}

			if(!this.z.contains(var5)) {
				this.z.add(var5);
				this.y.add(var5);
			}
		}

	}

	public void c() {
		this.a.removeAll(this.x);

		int var1;
		EntityMinecart var2;
		int var3;
		int var4;
		for(var1 = 0; var1 < this.x.size(); ++var1) {
			var2 = (EntityMinecart)this.x.get(var1);
			var3 = var2.aX;
			var4 = var2.aZ;
			if(var2.aW && this.h(var3, var4)) {
				this.b(var3, var4).b(var2);
			}
		}

		for(var1 = 0; var1 < this.x.size(); ++var1) {
			this.c((EntityMinecart)this.x.get(var1));
		}

		this.x.clear();

		for(var1 = 0; var1 < this.a.size(); ++var1) {
			var2 = (EntityMinecart)this.a.get(var1);
			if(var2.ac != null) {
				if(!var2.ac.ax && var2.ac.ab == var2) {
					continue;
				}

				var2.ac.ab = null;
				var2.ac = null;
			}

			if(!var2.ax) {
				this.e(var2);
			}

			if(var2.ax) {
				var3 = var2.aX;
				var4 = var2.aZ;
				if(var2.aW && this.h(var3, var4)) {
					this.b(var3, var4).b(var2);
				}

				this.a.remove(var1--);
				this.c(var2);
			}
		}

		for(var1 = 0; var1 < this.b.size(); ++var1) {
			((EntityCreature)this.b.get(var1)).k_();
		}

	}

	protected void e(EntityMinecart var1) {
		int var2 = ModelPig.b(var1.ah);
		int var3 = ModelPig.b(var1.aj);
		if(this.a(var2 - 16, 0, var3 - 16, var2 + 16, 128, var3 + 16)) {
			var1.aF = var1.ah;
			var1.aG = var1.ai;
			var1.aH = var1.aj;
			var1.ap = var1.an;
			var1.aq = var1.ao;
			if(var1.ac != null) {
				var1.n();
			} else {
				var1.e_();
			}

			int var5 = ModelPig.b(var1.ah / 16.0D);
			int var6 = ModelPig.b(var1.ai / 16.0D);
			int var7 = ModelPig.b(var1.aj / 16.0D);
			if(!var1.aW || var1.aX != var5 || var1.aY != var6 || var1.aZ != var7) {
				if(var1.aW && this.h(var1.aX, var1.aZ)) {
					this.b(var1.aX, var1.aZ).a(var1, var1.aY);
				}

				if(this.h(var5, var7)) {
					this.b(var5, var7).a(var1);
				} else {
					var1.aW = false;
					System.out.println("Removing entity because it\'s not in a chunk!!");
					var1.D();
				}
			}

			if(var1.ab != null) {
				if(!var1.ab.ax && var1.ab.ac == var1) {
					this.e(var1.ab);
				} else {
					var1.ab.ac = null;
					var1.ab = null;
				}
			}

			if(Double.isNaN(var1.ah) || Double.isInfinite(var1.ah)) {
				var1.ah = var1.aF;
			}

			if(Double.isNaN(var1.ai) || Double.isInfinite(var1.ai)) {
				var1.ai = var1.aG;
			}

			if(Double.isNaN(var1.aj) || Double.isInfinite(var1.aj)) {
				var1.aj = var1.aH;
			}

			if(Double.isNaN((double)var1.ao) || Double.isInfinite((double)var1.ao)) {
				var1.ao = var1.aq;
			}

			if(Double.isNaN((double)var1.an) || Double.isInfinite((double)var1.an)) {
				var1.an = var1.ap;
			}

		}
	}

	public boolean a(EntityRenderer var1) {
		List var2 = this.b((EntityMinecart)null, (EntityRenderer)var1);

		for(int var3 = 0; var3 < var2.size(); ++var3) {
			EntityMinecart var4 = (EntityMinecart)var2.get(var3);
			if(!var4.ax && var4.aa) {
				return false;
			}
		}

		return true;
	}

	public boolean b(EntityRenderer var1) {
		int var2 = ModelPig.b(var1.a);
		int var3 = ModelPig.b(var1.d + 1.0D);
		int var4 = ModelPig.b(var1.b);
		int var5 = ModelPig.b(var1.e + 1.0D);
		int var6 = ModelPig.b(var1.c);
		int var7 = ModelPig.b(var1.f + 1.0D);
		if(var1.a < 0.0D) {
			--var2;
		}

		if(var1.b < 0.0D) {
			--var4;
		}

		if(var1.c < 0.0D) {
			--var6;
		}

		for(int var8 = var2; var8 < var3; ++var8) {
			for(int var9 = var4; var9 < var5; ++var9) {
				for(int var10 = var6; var10 < var7; ++var10) {
					ln var11 = ln.n[this.a(var8, var9, var10)];
					if(var11 != null && var11.bl.d()) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean c(EntityRenderer var1) {
		int var2 = ModelPig.b(var1.a);
		int var3 = ModelPig.b(var1.d + 1.0D);
		int var4 = ModelPig.b(var1.b);
		int var5 = ModelPig.b(var1.e + 1.0D);
		int var6 = ModelPig.b(var1.c);
		int var7 = ModelPig.b(var1.f + 1.0D);

		for(int var8 = var2; var8 < var3; ++var8) {
			for(int var9 = var4; var9 < var5; ++var9) {
				for(int var10 = var6; var10 < var7; ++var10) {
					int var11 = this.a(var8, var9, var10);
					if(var11 == ln.ar.ba || var11 == ln.C.ba || var11 == ln.D.ba) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean a(EntityRenderer var1, EntitySkeleton var2, EntityMinecart var3) {
		int var4 = ModelPig.b(var1.a);
		int var5 = ModelPig.b(var1.d + 1.0D);
		int var6 = ModelPig.b(var1.b);
		int var7 = ModelPig.b(var1.e + 1.0D);
		int var8 = ModelPig.b(var1.c);
		int var9 = ModelPig.b(var1.f + 1.0D);
		boolean var10 = false;
		BlockTNT var11 = BlockTNT.b(0.0D, 0.0D, 0.0D);

		for(int var12 = var4; var12 < var5; ++var12) {
			for(int var13 = var6; var13 < var7; ++var13) {
				for(int var14 = var8; var14 < var9; ++var14) {
					ln var15 = ln.n[this.a(var12, var13, var14)];
					if(var15 != null && var15.bl == var2 && (double)var7 >= (double)((float)(var13 + 1) - EntityFX.b(this.e(var12, var13, var14)))) {
						var10 = true;
						var15.a(this, var12, var13, var14, var3, var11);
					}
				}
			}
		}

		if(var11.c() > 0.0D) {
			BlockTNT var16 = var11.b();
			var3.ak += var16.a * 0.004D;
			var3.al += var16.b * 0.004D;
			var3.am += var16.c * 0.004D;
		}

		return var10;
	}

	public boolean a(EntityRenderer var1, EntitySkeleton var2) {
		int var3 = ModelPig.b(var1.a);
		int var4 = ModelPig.b(var1.d + 1.0D);
		int var5 = ModelPig.b(var1.b);
		int var6 = ModelPig.b(var1.e + 1.0D);
		int var7 = ModelPig.b(var1.c);
		int var8 = ModelPig.b(var1.f + 1.0D);

		for(int var9 = var3; var9 < var4; ++var9) {
			for(int var10 = var5; var10 < var6; ++var10) {
				for(int var11 = var7; var11 < var8; ++var11) {
					ln var12 = ln.n[this.a(var9, var10, var11)];
					if(var12 != null && var12.bl == var2) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean b(EntityRenderer var1, EntitySkeleton var2) {
		int var3 = ModelPig.b(var1.a);
		int var4 = ModelPig.b(var1.d + 1.0D);
		int var5 = ModelPig.b(var1.b);
		int var6 = ModelPig.b(var1.e + 1.0D);
		int var7 = ModelPig.b(var1.c);
		int var8 = ModelPig.b(var1.f + 1.0D);

		for(int var9 = var3; var9 < var4; ++var9) {
			for(int var10 = var5; var10 < var6; ++var10) {
				for(int var11 = var7; var11 < var8; ++var11) {
					ln var12 = ln.n[this.a(var9, var10, var11)];
					if(var12 != null && var12.bl == var2) {
						int var13 = this.e(var9, var10, var11);
						double var14 = (double)(var10 + 1);
						if(var13 < 8) {
							var14 = (double)(var10 + 1) - (double)var13 / 8.0D;
						}

						if(var14 >= var1.b) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public void a(EntityMinecart var1, double var2, double var4, double var6, float var8) {
		(new BlockSponge()).a(this, var1, var2, var4, var6, var8);
	}

	public float a(BlockTNT var1, EntityRenderer var2) {
		double var3 = 1.0D / ((var2.d - var2.a) * 2.0D + 1.0D);
		double var5 = 1.0D / ((var2.e - var2.b) * 2.0D + 1.0D);
		double var7 = 1.0D / ((var2.f - var2.c) * 2.0D + 1.0D);
		int var9 = 0;
		int var10 = 0;

		for(float var11 = 0.0F; var11 <= 1.0F; var11 += (float)var3) {
			for(float var12 = 0.0F; var12 <= 1.0F; var12 += (float)var5) {
				for(float var13 = 0.0F; var13 <= 1.0F; var13 += (float)var7) {
					if(this.a(BlockTNT.b(var2.a + (var2.d - var2.a) * (double)var11, var2.b + (var2.e - var2.b) * (double)var12, var2.c + (var2.f - var2.c) * (double)var13), var1) == null) {
						++var9;
					}

					++var10;
				}
			}
		}

		return (float)var9 / (float)var10;
	}

	public void i(int var1, int var2, int var3, int var4) {
		if(var4 == 0) {
			--var2;
		}

		if(var4 == 1) {
			++var2;
		}

		if(var4 == 2) {
			--var3;
		}

		if(var4 == 3) {
			++var3;
		}

		if(var4 == 4) {
			--var1;
		}

		if(var4 == 5) {
			++var1;
		}

		if(this.a(var1, var2, var3) == ln.ar.ba) {
			this.a((double)((float)var1 + 0.5F), (double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), "random.fizz", 0.5F, 2.6F + (this.m.nextFloat() - this.m.nextFloat()) * 0.8F);
			this.d(var1, var2, var3, 0);
		}

	}

	public EntityMinecart a(Class var1) {
		return null;
	}

	public String d() {
		return "All: " + this.a.size();
	}

	public EntityCreature b(int var1, int var2, int var3) {
		BlockMushroom var4 = this.b(var1 >> 4, var3 >> 4);
		return var4 != null?var4.d(var1 & 15, var2, var3 & 15):null;
	}

	public void a(int var1, int var2, int var3, EntityCreature var4) {
		BlockMushroom var5 = this.b(var1 >> 4, var3 >> 4);
		if(var5 != null) {
			var5.a(var1 & 15, var2, var3 & 15, var4);
		}

	}

	public void l(int var1, int var2, int var3) {
		BlockMushroom var4 = this.b(var1 >> 4, var3 >> 4);
		if(var4 != null) {
			var4.e(var1 & 15, var2, var3 & 15);
		}

	}

	public boolean g(int var1, int var2, int var3) {
		ln var4 = ln.n[this.a(var1, var2, var3)];
		return var4 != null && var4.b();
	}

	public void a(nh var1) {
		this.a(true, var1);
	}

	public boolean e() {
		int var1 = 1000;

		while(this.wList.size() > 0) {
			--var1;
			if(var1 <= 0) {
				return true;
			}

			((BlockFire)this.wList.remove(this.wList.size() - 1)).a(this);
		}

		return false;
	}

	public void a(PlayerControllerCreative var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		this.a(var1, var2, var3, var4, var5, var6, var7, true);
	}

	public void a(PlayerControllerCreative var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
		if(this.d((var5 + var2) / 2, 64, (var7 + var4) / 2)) {
			int var9 = this.wList.size();
			if(var8) {
				int var10 = 4;
				if(var10 > var9) {
					var10 = var9;
				}

				for(int var11 = 0; var11 < var10; ++var11) {
					BlockFire var12 = (BlockFire)this.wList.get(this.wList.size() - var11 - 1);
					if(var12.a == var1 && var12.a(var2, var3, var4, var5, var6, var7)) {
						return;
					}
				}
			}

			this.wList.add(new BlockFire(var1, var2, var3, var4, var5, var6, var7));
			if(this.wList.size() > 100000) {
				while(this.wList.size() > '\uc350') {
					this.e();
				}
			}

		}
	}

	public void f() {
		int var1 = this.a(1.0F);
		if(var1 != this.e) {
			this.e = var1;
		}

	}

	public void g() {
		this.F.a();
		int var1 = this.a(1.0F);
		if(var1 != this.e) {
			this.e = var1;

			for(int var2 = 0; var2 < this.E.size(); ++var2) {
				((ItemStack)this.E.get(var2)).e();
			}
		}

		if(this.CanUseCheats() && Keyboard.isKeyDown(Keyboard.KEY_MULTIPLY)) {
			this.c += 12L;
		} else if(!this.CanUseCheats() || !Keyboard.isKeyDown(Keyboard.KEY_DECIMAL)) {
			++this.c;
			if(this.c % 23000L == 0L) {
				++this.milestone;
				System.out.println("Milestone" + this.milestone + " reached.");
			}
		}

		if(this.c % 4L == 0L) {
			this.a(false, (nh)null);
		}

		this.a(false);
		this.h();
	}

	protected void h() {
		this.J.clear();

		int var4;
		int var7;
		for(int var1 = 0; var1 < this.j.size(); ++var1) {
			BlockMobSpawner var2 = (BlockMobSpawner)this.j.get(var1);
			int var3 = ModelPig.b(var2.ah / 16.0D);
			var4 = ModelPig.b(var2.aj / 16.0D);
			byte var5 = 9;

			for(int var6 = -var5; var6 <= var5; ++var6) {
				for(var7 = -var5; var7 <= var5; ++var7) {
					this.J.add(new nx(var6 + var3, var7 + var4));
				}
			}
		}

		if(this.K > 0) {
			--this.K;
		}

		Iterator var15 = this.J.iterator();

		while(var15.hasNext()) {
			Object var16 = var15.next();
			nx var17 = (nx)var16;
			var4 = var17.a * 16;
			int var18 = var17.b * 16;
			BlockMushroom var19 = this.b(var17.a, var17.b);
			int var8;
			int var9;
			int var10;
			int var11;
			if(this.K == 0) {
				this.f = this.f * 3 + this.g;
				var7 = this.f >> 2;
				var8 = var7 & 15;
				var9 = var7 >> 8 & 15;
				var10 = var7 >> 16 & 127;
				var11 = var19.a(var8, var10, var9);
				int var12 = var8 + var4;
				int var13 = var9 + var18;
				if(var11 == 0 && this.j(var12, var10, var13) <= this.m.nextInt(8) && this.a(PlayerControllerCreative.a, var12, var10, var13) <= 0) {
					BlockMobSpawner var14 = this.a((double)var12 + 0.5D, (double)var10 + 0.5D, (double)var13 + 0.5D, 8.0D);
					if(var14 != null && var14.d((double)var12 + 0.5D, (double)var10 + 0.5D, (double)var13 + 0.5D) > 4.0D) {
						this.a((double)var12 + 0.5D, (double)var10 + 0.5D, (double)var13 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.m.nextFloat() * 0.2F);
						this.K = this.m.nextInt(12000) + 6000;
					}
				}
			}

			if(this.d && this.m.nextInt(4) == 0) {
				this.f = this.f * 3 + this.g;
				var7 = this.f >> 2;
				var8 = var7 & 15;
				var9 = var7 >> 8 & 15;
				var10 = this.d(var8 + var4, var9 + var18);
				if(var10 >= 0 && var10 < 128 && var19.a(PlayerControllerCreative.b, var8, var10, var9) < 10) {
					var11 = var19.a(var8, var10 - 1, var9);
					if(var19.a(var8, var10, var9) == 0 && var11 != 0 && var11 != ln.aT.ba && ln.n[var11].bl.c()) {
						this.d(var8 + var4, var10, var9 + var18, ln.aS.ba);
					}

					if(var11 == ln.B.ba && var19.b(var8, var10 - 1, var9) == 0) {
						this.d(var8 + var4, var10 - 1, var9 + var18, ln.aT.ba);
					}
				}
			}

			for(var7 = 0; var7 < 80; ++var7) {
				this.f = this.f * 3 + this.g;
				var8 = this.f >> 2;
				var9 = var8 & 15;
				var10 = var8 >> 8 & 15;
				var11 = var8 >> 16 & 127;
				byte var20 = var19.b[var9 << 11 | var10 << 7 | var11];
				if(ln.o[var20]) {
					ln.n[var20].a(this, var9 + var4, var11, var10 + var18, this.m);
				}
			}
		}

	}

	public boolean a(boolean var1) {
		int var2 = this.y.size();
		if(var2 != this.z.size()) {
			throw new IllegalStateException("TickNextTick list out of synch");
		} else {
			if(var2 > 1000) {
				var2 = 1000;
			}

			for(int var3 = 0; var3 < var2; ++var3) {
				GuiButton var4 = (GuiButton)this.y.first();
				if(!var1 && var4.e > this.c) {
					break;
				}

				this.y.remove(var4);
				this.z.remove(var4);
				if(this.a(var4.xPosition - 8, var4.yPosition - 8, var4.c - 8, var4.xPosition + 8, var4.yPosition + 8, var4.c + 8)) {
					int var6 = this.a(var4.xPosition, var4.yPosition, var4.c);
					if(var6 == var4.id && var6 > 0) {
						ln.n[var6].a(this, var4.xPosition, var4.yPosition, var4.c, this.m);
					}
				}
			}

			return this.y.size() != 0;
		}
	}

	public void m(int var1, int var2, int var3) {
		Random var5 = new Random();

		for(int var6 = 0; var6 < 1000; ++var6) {
			int var7 = var1 + this.m.nextInt(16) - this.m.nextInt(16);
			int var8 = var2 + this.m.nextInt(16) - this.m.nextInt(16);
			int var9 = var3 + this.m.nextInt(16) - this.m.nextInt(16);
			int var10 = this.a(var7, var8, var9);
			if(var10 > 0) {
				ln.n[var10].b(this, var7, var8, var9, var5);
			}
		}

	}

	public List b(EntityMinecart var1, EntityRenderer var2) {
		this.L.clear();
		int var3 = ModelPig.b((var2.a - 2.0D) / 16.0D);
		int var4 = ModelPig.b((var2.d + 2.0D) / 16.0D);
		int var5 = ModelPig.b((var2.c - 2.0D) / 16.0D);
		int var6 = ModelPig.b((var2.f + 2.0D) / 16.0D);

		for(int var7 = var3; var7 <= var4; ++var7) {
			for(int var8 = var5; var8 <= var6; ++var8) {
				if(this.h(var7, var8)) {
					this.b(var7, var8).a(var1, var2, this.L);
				}
			}
		}

		return this.L;
	}

	public List a(Class var1, EntityRenderer var2) {
		int var3 = ModelPig.b((var2.a - 2.0D) / 16.0D);
		int var4 = ModelPig.b((var2.d + 2.0D) / 16.0D);
		int var5 = ModelPig.b((var2.c - 2.0D) / 16.0D);
		int var6 = ModelPig.b((var2.f + 2.0D) / 16.0D);
		ArrayList var7 = new ArrayList();

		for(int var8 = var3; var8 <= var4; ++var8) {
			for(int var9 = var5; var9 <= var6; ++var9) {
				if(this.h(var8, var9)) {
					this.b(var8, var9).a((Class)var1, var2, var7);
				}
			}
		}

		return var7;
	}

	public List i() {
		return this.a;
	}

	public void n(int var1, int var2, int var3) {
		if(this.d(var1, var2, var3)) {
			this.a(var1, var3).f();
		}

	}

	public int b(Class var1) {
		int var2 = 0;

		for(int var3 = 0; var3 < this.a.size(); ++var3) {
			if(var1.isAssignableFrom(((EntityMinecart)this.a.get(var3)).getClass())) {
				++var2;
			}
		}

		return var2;
	}

	public void a(List var1) {
		this.a.addAll(var1);

		for(int var2 = 0; var2 < var1.size(); ++var2) {
			this.b((EntityMinecart)var1.get(var2));
		}

	}

	public void b(List var1) {
		this.x.addAll(var1);
	}

	public void j() {
		while(this.F.a()) {
		}

	}

	public boolean a(int var1, int var2, int var3, int var4, boolean var5) {
		ln var6 = ln.n[this.a(var2, var3, var4)];
		ln var7 = ln.n[var1];
		EntityRenderer var8 = var7.d(this, var2, var3, var4);
		if(var5) {
			var8 = null;
		}

		return (var8 == null || this.a(var8)) && (var6 == ln.A || var6 == ln.B || var6 == ln.C || var6 == ln.D || var6 == ln.ar || var6 == ln.aS || var1 > 0 && var6 == null && var7.a(this, var2, var3, var4));
	}

	public GuiFurnace a(EntityMinecart var1, EntityMinecart var2, float var3) {
		int var4 = ModelPig.b(var1.ah);
		int var5 = ModelPig.b(var1.ai);
		int var6 = ModelPig.b(var1.aj);
		int var7 = (int)(var3 + 16.0F);
		return (new BlockLeaves(new GuiGameOver(this, var4 - var7, var5 - var7, var6 - var7, var4 + var7, var5 + var7, var6 + var7))).a(var1, var2, var3);
	}

	public GuiFurnace a(EntityMinecart var1, int var2, int var3, int var4, float var5) {
		int var6 = ModelPig.b(var1.ah);
		int var7 = ModelPig.b(var1.ai);
		int var8 = ModelPig.b(var1.aj);
		int var9 = (int)(var5 + 8.0F);
		return (new BlockLeaves(new GuiGameOver(this, var6 - var9, var7 - var9, var8 - var9, var6 + var9, var7 + var9, var8 + var9))).a(var1, var2, var3, var4, var5);
	}

	public boolean j(int var1, int var2, int var3, int var4) {
		int var5 = this.a(var1, var2, var3);
		return var5 != 0 && ln.n[var5].c(this, var1, var2, var3, var4);
	}

	public boolean o(int var1, int var2, int var3) {
		return this.j(var1, var2 - 1, var3, 0) || this.j(var1, var2 + 1, var3, 1) || this.j(var1, var2, var3 - 1, 2) || this.j(var1, var2, var3 + 1, 3) || this.j(var1 - 1, var2, var3, 4) || this.j(var1 + 1, var2, var3, 5);
	}

	public boolean k(int var1, int var2, int var3, int var4) {
		if(this.g(var1, var2, var3)) {
			return this.o(var1, var2, var3);
		} else {
			int var5 = this.a(var1, var2, var3);
			return var5 != 0 && ln.n[var5].b((mz)this, var1, var2, var3, var4);
		}
	}

	public boolean p(int var1, int var2, int var3) {
		return this.k(var1, var2 - 1, var3, 0) || this.k(var1, var2 + 1, var3, 1) || this.k(var1, var2, var3 - 1, 2) || this.k(var1, var2, var3 + 1, 3) || this.k(var1 - 1, var2, var3, 4) || this.k(var1 + 1, var2, var3, 5);
	}

	public BlockMobSpawner a(EntityMinecart var1, double var2) {
		return this.a(var1.ah, var1.ai, var1.aj, var2);
	}

	public BlockMobSpawner a(double var1, double var3, double var5, double var7) {
		double var9 = -1.0D;
		BlockMobSpawner var11 = null;

		for(int var12 = 0; var12 < this.j.size(); ++var12) {
			BlockMobSpawner var13 = (BlockMobSpawner)this.j.get(var12);
			double var14 = var13.d(var1, var3, var5);
			if((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
				var9 = var14;
				var11 = var13;
			}
		}

		return var11;
	}

	public void a(int var1, int var2, int var3, int var4, int var5, int var6, byte[] var7) {
		int var8 = var1 >> 4;
		int var9 = var3 >> 4;
		int var10 = var1 + var4 - 1 >> 4;
		int var11 = var3 + var6 - 1 >> 4;
		int var12 = 0;
		int var13 = var2;
		int var14 = var2 + var5;
		if(var2 < 0) {
			var13 = 0;
		}

		if(var14 > 128) {
			var14 = 128;
		}

		for(int var15 = var8; var15 <= var10; ++var15) {
			int var16 = var1 - var15 * 16;
			int var17 = var1 + var4 - var15 * 16;
			if(var16 < 0) {
				var16 = 0;
			}

			if(var17 > 16) {
				var17 = 16;
			}

			for(int var18 = var9; var18 <= var11; ++var18) {
				int var19 = var3 - var18 * 16;
				int var20 = var3 + var6 - var18 * 16;
				if(var19 < 0) {
					var19 = 0;
				}

				if(var20 > 16) {
					var20 = 16;
				}

				var12 = this.b(var15, var18).a(var7, var16, var13, var19, var17, var14, var20, var12);
				this.b(var15 * 16 + var16, var13, var18 * 16 + var19, var15 * 16 + var17, var14, var18 * 16 + var20);
			}
		}

	}

	public void k() {
	}

	public void l() {
		try {
			DataInputStream var1 = new DataInputStream(new FileInputStream(new File(this.G, "session.lock")));

			try {
				if(var1.readLong() != this.D) {
					throw new lm("The save is being accessed from another location, aborting");
				}
			} finally {
				var1.close();
			}

		} catch (IOException var6) {
			throw new lm("Failed to check session lock, aborting");
		}
	}

	static {
		for(int var1 = 0; var1 <= 15; ++var1) {
			float var2 = 1.0F - (float)var1 / 15.0F;
			i[var1] = (1.0F - var2) / (var2 * 3.0F + 1.0F) * 0.95F + 0.05F;
		}

	}
}
